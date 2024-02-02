package dao;

import entity.Teacher;
import utils.MyDbUtil;

import java.util.List;

/**
 * @auther lyh
 * @create 2023-07-09
 */
public class teatDao {
    public List<Teacher> tealist()
    {
        String sql="select * from teacher";
        List<Teacher> teacherList= MyDbUtil.executeQuery(Teacher.class,sql);
        return teacherList;
    }

    public void add_Teacher(Integer tno,String tname)
    {
        String sql="insert into teacher(tno,tname,tpassword) values(?,?,?)";
        String pas="000000";
        MyDbUtil.executeUpdate(sql,tno,tname,pas);
    }

    public void delete_Teacher(Integer tno)
    {
        String sql="set foreign_key_checks=0;";
        MyDbUtil.executeUpdate(sql);
        String s1="delete from teacher where tno=?";
        MyDbUtil.executeUpdate(s1,tno);
        String s2="delete from homework where tno=?";
        MyDbUtil.executeUpdate(s2,tno);
        String s3="set foreign_key_checks=1;";
        MyDbUtil.executeUpdate(s3);
    }

    public Teacher Select_Teacher(Integer tno)
    {
        String sql="select * from teacher where tno=?";
        List<Teacher> teas=MyDbUtil.executeQuery(Teacher.class,sql,tno);
        return teas.size()>0?teas.get(0):null;//判断学号为sno的学生是否存在，是则返回不是则返回null
    }

    public void update_Teacher(Integer tno,String tname,String tpassword)
    {
        String sql="update teacher set tname=?,tpassword=? where tno=?";
        MyDbUtil.executeUpdate(sql,tname,tpassword,tno);
    }
}
