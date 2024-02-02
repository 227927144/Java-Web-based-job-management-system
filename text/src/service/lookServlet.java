package service;

import dao.studDao;
import dao.stuhowkDao;
import dao.teatDao;
import entity.homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;

/**
 * @auther lyh
 * @create 2023-07-07
 */
@WebServlet(urlPatterns = "/lookproject")
public class lookServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("UTF-8");
        String method=req.getParameter("method");
        String sno = req.getParameter("sno");
        String tno = req.getParameter("tno");
        stuhowkDao shDao=new stuhowkDao();
        String howksno="";
        String thowktno="";
        List<homework> hlist=shDao.stuhowklist();
        if(method==null)//初始状态无method，故设置method="showstulist"使得登录成功后自动跳转至学生信息列表界面
        {
            method="showhowklist";
        }
        switch(method)
        {
            case "showhowklist"://获取作业列表，跳转至查看界面
                req.setAttribute("hlist",hlist);
                req.getRequestDispatcher("Look.jsp").forward(req,resp);
                break;
            case "lookstu"://跳转至查看学生作业提交情况界面
                List<homework> howk=shDao.Select_StuHowk(Integer.valueOf(sno));
                howksno= String.valueOf(howk.get(0).getSno());
                req.setAttribute("howksno",howksno);//将学生学号传给Look.jsp
                req.getRequestDispatcher("Lookstu.jsp").forward(req,resp);
                break;
            case "lookstu1"://跳转至查看学生作业提交详情界面
                List<homework> hlistNotnull=shDao.Select_shConNotnull(Integer.valueOf(sno));
                if(hlistNotnull!=null)
                {
                    req.setAttribute("hlistNotnull",hlistNotnull);//获取已提交作业内容
                }

                List<homework> hlistNull=shDao.Select_shConNull(Integer.valueOf(sno));
                if(hlistNull!=null)
                {
                    req.setAttribute("hlistNull",hlistNull);//获取未提交作业内容
                }

                List<homework> howk1=shDao.Select_StuHowk(Integer.valueOf(sno));
                howksno= String.valueOf(howk1.get(0).getSno());
                req.setAttribute("howksno",howksno);

                double wcl=0.0,pjf=0.0;//完成率,平均分
                int c1=0,c2=0;
                if(hlistNotnull.size()>0) {c1=hlistNotnull.size();}
                if(hlistNull.size()>0) { c2=hlistNull.size();}
                if(c1>0 && c2==0){wcl= 1.00;}
                if(c1>0 && c2>0)
                {
                    int c3=c1+c2;
                    wcl=(double) c1/c3;
                }
                NumberFormat percentFormat = NumberFormat.getPercentInstance();
                percentFormat.setMaximumFractionDigits(2);//两位小数
                String percentwcl = percentFormat.format(wcl);
                req.setAttribute("percentwcl",percentwcl);

                int n=0,zf=0;//总分
                for(homework i:hlistNotnull) {
                    if(i.getScore()!=null) {
                        //有分数
                        n=n+1;
                        zf=zf+i.getScore();
                    }
                }
                pjf= (double) (zf/n);//计算平均分
                req.setAttribute("pjf",pjf);

                req.getRequestDispatcher("Lookstu.jsp").forward(req,resp);//传递平均分
                break;
            case "looktea":
                List<homework> thowk=shDao.Select_TeaHowk(Integer.valueOf(tno));
                thowktno=String.valueOf(thowk.get(0).getTno());
                req.setAttribute("thowktno",thowktno);
                req.getRequestDispatcher("Looktea.jsp").forward(req,resp);
                break;
            case "looktea1":
                List<homework> scoreNotnull=shDao.Select_scoreNotnull(Integer.valueOf(tno));
                req.setAttribute("scoreNotnull",scoreNotnull);
                List<homework> scoreNull=shDao.Select_scoreNull(Integer.valueOf(tno));
                req.setAttribute("scoreNull",scoreNull);

                List<homework> thowk1=shDao.Select_TeaHowk(Integer.valueOf(tno));
                thowktno=String.valueOf(thowk1.get(0).getTno());
                req.setAttribute("thowktno",thowktno);

                double twcl=0.0;//作业批改率率
                int tc1=0,tc2=0;
                if(scoreNotnull.size()>0) {tc1=scoreNotnull.size();}
                if(scoreNull.size()>0) { tc2=scoreNull.size();}
                if(tc1>0 && tc2==0){twcl= 1.00;}
                if(tc1>0 && tc2>0)
                {
                    int tc3=tc1+tc2;
                    twcl=(double) tc1/tc3;
                }
                NumberFormat tpercentFormat = NumberFormat.getPercentInstance();
                tpercentFormat.setMaximumFractionDigits(2);//两位小数
                String tpercentwcl = tpercentFormat.format(twcl);//是作业批改率是保留两位小数的百分数
                req.setAttribute("tpercentwcl",tpercentwcl);

                req.getRequestDispatcher("Looktea.jsp").forward(req,resp);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        String sno = req.getParameter("sno");
        String tno = req.getParameter("tno");
        studDao stuDao=new studDao();
        teatDao teaDao=new teatDao();
        stuhowkDao shDao=new stuhowkDao();
    }
}
