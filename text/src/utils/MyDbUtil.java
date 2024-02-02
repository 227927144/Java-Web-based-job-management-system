package utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MyDbUtil {
    private static String driver = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        try {
            InputStream inputStream = MyDbUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            driver = properties.getProperty("db.driver").trim();
            url = properties.getProperty("db.url").trim();
            user = properties.getProperty("db.user").trim();
            password = properties.getProperty("db.password").trim();
            inputStream.close();

            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    /**
     * 获取数据库连接的方法,同一个线程多次获取同一个对象
     *
     * @return
     */

    public static Connection getConnection() {
        Connection conn = null;
        try {
            //水桶!!
            conn = threadLocal.get();
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                threadLocal.set(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库连接!!
     */
    public static void closeConnection() {
        Connection conn = threadLocal.get();
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        threadLocal.set(null);
    }

    public static <T> List<T> executeQuery(Connection conn, Class<T> type, String sql, Object... pras) {
        List<T> list = new ArrayList<>();

        ResultSet result = null;
        PreparedStatement preparedStatement =null;

        try {
            preparedStatement = conn.prepareStatement(sql);
            for (int i = 0; i < pras.length; i++) {
                preparedStatement.setObject(i + 1, pras[i]);
            }
            if (preparedStatement.execute()) {
                result = preparedStatement.getResultSet();
            }
            ResultSetMetaData metaData = result.getMetaData();
            int clounmCount = metaData.getColumnCount();
            //获取字段名
            String[] clounmNames  = new String[clounmCount];
            for (int i = 0; i < clounmCount; i++) {
                clounmNames[i]=metaData.getColumnLabel(i+1);
            }
            Method[] methods = type.getDeclaredMethods();
            while (result.next()) {
                Object obj = type.newInstance();//new User( )
                for (int i = 0; i < clounmCount; i++) {
                    String clounmName =clounmNames[i];//name
                    Object clounmValue = result.getObject(i + 1);
                    String  setterName = "set"+clounmName.substring(0,1).toUpperCase()+clounmName.substring(1);// setName
                    Method setter = null;
                    for (int j = 0; j < methods.length; j++) {
                        if (methods[j].getName().equals(setterName)){
                            setter = methods[j];
                            break;
                        }
                    }
                    if(setter!=null ){
//                        System.out.println(""+setter + ":"+clounmValue.getClass().getName()  );
                        if(setter.getParameterTypes()[0].getName().equals("boolean") || setter.getParameterTypes()[0].getName().equals("java.lang.Boolean")){
                            clounmValue = ((Integer)clounmValue==0)?false:true;
                        }

                        boolean isBasic = false;
                        String parameter0Name = setter.getParameterTypes()[0].getName();
                        String[] allBasic =new String[]{"byte","short","int","long","float","double","char","boolean"};
                        for (String each:
                                allBasic ) {
                            if(parameter0Name.equals(each)){
                                isBasic= true;
                                break;
                            }
                        }

                        if( !( clounmValue==null && isBasic ) ){
                            setter.invoke(obj,clounmValue);
                        }
                    }
                    //获取字段值
                }
                list.add((T) obj);
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (result!=null){
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }


    public static <T> List<T> executeQuery(Class<T> type, String sql, Object... pras) {
        Connection conn = MyDbUtil.getConnection();
        List<T> list = executeQuery(conn,type,sql,pras);
        MyDbUtil.closeConnection();
        return list;
    }

    public static <T> List<T> executeQuery(Class<T> type, String sql) {
        Connection conn = MyDbUtil.getConnection();
        List<T> list = executeQuery(conn,type,sql);
        MyDbUtil.closeConnection();
        return list;
    }


    public static int executeUpdate(Connection conn, String sql, Object... pras) {
        int rows = -1;
        PreparedStatement preparedStatement = null;
        try {
            conn.setAutoCommit(false);
            preparedStatement = conn.prepareStatement(sql);
            for (int i = 0; i < pras.length; i++) {
                preparedStatement.setObject(i + 1, pras[i]);
            }
            if (!preparedStatement.execute()) {
                rows = preparedStatement.getUpdateCount();
            }
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();

        }finally {
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return rows;
    }


    public static int executeUpdate( String sql, Object... pras) {
        int  rows = -1 ;
        Connection connection = MyDbUtil.getConnection();
        rows =  executeUpdate(connection,sql,pras);
        MyDbUtil.closeConnection();
        return  rows;
    }

    public static int executeUpdate( String sql) {
        int  rows = -1 ;
        Connection connection = MyDbUtil.getConnection();
        rows =  executeUpdate(connection,sql);
        MyDbUtil.closeConnection();
        return  rows;
    }

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println("ThreadA:"+MyDbUtil.getConnection().hashCode());
                System.out.println("ThreadA:"+MyDbUtil.getConnection().hashCode());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println("ThreadB:"+MyDbUtil.getConnection().hashCode());
            }
        }.start();

    }

}
