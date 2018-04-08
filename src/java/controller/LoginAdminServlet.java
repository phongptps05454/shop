/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Users;
import tools.MD5;

/**
 *
 * @author ThuongIT
 */
public class LoginAdminServlet extends HttpServlet {
    UsersDAO usersDAO = new UsersDAO();
    
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("/shop/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Users users = new Users();
        String url = "";

        users = usersDAO.login(request.getParameter("account"), MD5.encryption(request.getParameter("password")));
        if (users != null && users.isUserRole()) {
            session.setAttribute("userAdmin", users);
            url = "/admin/index.jsp";
        } else if (users != null && !users.isUserRole()){
            request.setAttribute("error", "Bạn không có quyền truy cập trang quản trị");
            url = "/admin/login.jsp";
        }else if (users == null){
            request.setAttribute("error", "Sai email hoặc mật khẩu!");
            url = "/admin/login.jsp";
        }
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

}
