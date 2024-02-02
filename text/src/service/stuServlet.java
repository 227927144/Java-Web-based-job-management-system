package service;

import dao.studDao;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @auther lyh
 * @create 2023-07-07
 */
@WebServlet(urlPatterns = "/project")
public class stuServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //编写学生列表
        req.setCharacterEncoding("UTF-8");
        String method=req.getParameter("method");
        String sno = req.getParameter("sno");
        studDao stuDao=new studDao();
        List<Student> slist=stuDao.stulist();
        if(method==null)//初始状态无method，故设置method="showstulist"使得登录成功后自动跳转至学生信息列表界面
        {
            method="showstulist";
        }
        switch(method)
        {
            case "showstulist"://显示学生列表
                req.setAttribute("slist",slist);
                req.getRequestDispatcher("studentList.jsp").forward(req,resp);
                break;
            case "delstulist":
                req.setAttribute("slist",slist);//删除界面获取学生列表
                req.getRequestDispatcher("stuDelete.jsp").forward(req,resp);
                break;
            case "delstu"://删除学生并结合dao层删除数据库中数据
                stuDao.delete_Student(Integer.valueOf(sno));
                String s2 = req.getContextPath()+"/project";
                resp.sendRedirect(s2);
                break;
            case "updstu"://将待修改信息学生的信息发送给修改学生信息界面
                Student stus=stuDao.Select_Student(Integer.valueOf(sno));
                req.setAttribute("stus" , stus);
                req.getRequestDispatcher("stuUpdate.jsp").forward(req,resp);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        String sno = req.getParameter("sno");
        String sname = req.getParameter("sname");
        String spassword = req.getParameter("spassword");
        String email = req.getParameter("email");
        studDao stuDao=new studDao();
        switch (method){
            case "addstu"://删除学生并结合dao层在student数据库添加中数据
                stuDao.add_Student(Integer.valueOf(sno),sname,email);
                String s1 = req.getContextPath()+"/project";
                resp.sendRedirect(s1);
                break;
            case "updatestu"://修改学生信息并结合dao层修改数据库中对应学生的数据
                stuDao.update_Student(Integer.valueOf(sno),sname,spassword,email);
                String s = req.getContextPath()+"/project";
                resp.sendRedirect(s);
                break;
        }
    }
}
