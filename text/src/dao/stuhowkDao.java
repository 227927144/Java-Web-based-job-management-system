package dao;

import entity.homework;
import utils.MyDbUtil;

import java.util.List;

/**
 * @auther lyh
 * @create 2023-07-11
 */
public class stuhowkDao {
    public List<homework> stuhowklist()
    {
        String sql="select * from homework;";
        List<homework> shList= MyDbUtil.executeQuery(homework.class,sql);
        //private LocalDateTime deadlineTime;
        return shList;
    }

    public List<homework> Select_StuHowk(Integer sno)
    {
        //学生和老师只有一个但同一个学生的作业可以有很多个，所以采用列表存储同一个学生的所有作业。
        String sql="select * from homework where sno=?";
        List<homework> stuhowks=MyDbUtil.executeQuery(homework.class,sql,sno);
        return stuhowks;
    }

    public List<homework> Select_shConNotnull(Integer sno)//选取内容不为空的作业（即学生已完成作业）
    {
        String sql="select * from homework where sno=? and content is not null;";
        List<homework> stuhowks=MyDbUtil.executeQuery(homework.class,sql,sno);
        if(stuhowks.size()>0)
        {
            return stuhowks;
        }
        else return null;
    }

    public List<homework> Select_shConNull(Integer sno)//选取内容为空的作业（即学生未完成作业）
    {
        String sql="select * from homework where sno=? and isNull(content);";
        List<homework> stuhowks=MyDbUtil.executeQuery(homework.class,sql,sno);
        if(stuhowks.size()>0)
        {
            return stuhowks;
        }
        else return null;
    }

    public List<homework> Select_TeaHowk(Integer tno)
    {
        String sql="select * from homework where tno=?";
        List<homework> teahowks=MyDbUtil.executeQuery(homework.class,sql,tno);
        return teahowks;
    }

    public List<homework> Select_scoreNotnull(Integer tno)//选取分数不为空的作业（即已批改的作业）
    {
        String sql="select * from homework where tno=? and score is not null;";
        List<homework> teahowks=MyDbUtil.executeQuery(homework.class,sql,tno);
        if(teahowks.size()>0)
        {
            return teahowks;
        }
        else return null;
    }

    public List<homework> Select_scoreNull(Integer tno)//选取分数未空的作业（即未批改作业）
    {
        String sql="select * from homework where tno=? and isNull(score);";
        List<homework> teahowks=MyDbUtil.executeQuery(homework.class,sql,tno);
        if(teahowks.size()>0)
        {
            return teahowks;
        }
        else return null;
    }

}
