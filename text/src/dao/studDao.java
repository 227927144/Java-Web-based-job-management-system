package dao;

import entity.Student;
import utils.MyDbUtil;

import java.util.List;

/**
 * @auther lyh
 * @create 2023-07-07
 */
public class studDao {
    public List<Student> stulist()//显示学生列表
    {
        String sql="select * from student";
        List<Student> studentList= MyDbUtil.executeQuery(Student.class,sql);
        return studentList;
    }

    //通过学号删除学生
    public void delete_Student(Integer sno)
    {
        String sql="set foreign_key_checks=0;";
        MyDbUtil.executeUpdate(sql);
        String s1="delete from student where sno=?";
        MyDbUtil.executeUpdate(s1,sno);
        String s2="delete from homework where sno=?";
        MyDbUtil.executeUpdate(s2,sno);
        String s3="set foreign_key_checks=1;";
        MyDbUtil.executeUpdate(s3);
    }

    //增加学生(初始密码为000000)
    public void add_Student(Integer sno,String sname,String email)
    {
        String sql="insert into student(sno,sname,spassword,email) values(?,?,?,?)";
        String pas="000000";
        MyDbUtil.executeUpdate(sql,sno,sname,pas,email);
    }

    public Student Select_Student(Integer sno)//选择学生
    {
        String sql="select * from student where sno=?";
        List<Student> stus=MyDbUtil.executeQuery(Student.class,sql,sno);
        return stus.size()>0?stus.get(0):null;//判断学号为sno的学生是否存在，是则返回不是则返回null
    }
    //修改信息
    public void update_Student(Integer sno,String sname,String spassword,String email)
    {
        String sql="update student set sname=?,spassword=?,email=? where sno=?";
        MyDbUtil.executeUpdate(sql,sname,spassword,email,sno);
    }
}
