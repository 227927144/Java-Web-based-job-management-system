package service;

import dao.teatDao;
import entity.Teacher;

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
@WebServlet(urlPatterns = "/teaproject")
public class teaServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("UTF-8");
        String method=req.getParameter("method");
        String tno = req.getParameter("tno");
        teatDao teaDao=new teatDao();
        List<Teacher> tlist=teaDao.tealist();
        if(method==null)//初始状态无method，故设置method="showstulist"使得登录成功后自动跳转至学生信息列表界面
        {
            method="showtealist";
        }
        switch(method)
        {
            case "showtealist":
                req.setAttribute("tlist",tlist);
                req.getRequestDispatcher("teacherList.jsp").forward(req,resp);
                break;
            case "deltealist":
                req.setAttribute("tlist",tlist);
                req.getRequestDispatcher("teaDelete.jsp").forward(req,resp);
                break;
            case "deltea":
                teaDao.delete_Teacher(Integer.valueOf(tno));
                String t2 = req.getContextPath()+"/teaproject";
                resp.sendRedirect(t2);
                break;
            case "updtea":
                Teacher teas=teaDao.Select_Teacher(Integer.valueOf(tno));
                req.setAttribute("teas" , teas);
                req.getRequestDispatcher("teaUpdate.jsp").forward(req,resp);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        String tno = req.getParameter("tno");
        String tname = req.getParameter("tname");
        String tpassword = req.getParameter("tpassword");
        teatDao teaDao=new teatDao();
        switch (method){
            case "addtea":
                teaDao.add_Teacher(Integer.valueOf(tno),tname);
                String t1 = req.getContextPath()+"/teaproject";
                resp.sendRedirect(t1);
                break;
            case "updatetea":
                teaDao.update_Teacher(Integer.valueOf(tno),tname,tpassword);
                String t3 = req.getContextPath()+"/teaproject";
                resp.sendRedirect(t3);
        }
    }
}
