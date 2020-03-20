package com.accenture.tveratc.bank.Controller;

import com.accenture.tveratc.bank.Model.LoginDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        String login = request.getParameter("login");
        String password = request.getParameter("password");

        HttpSession session = request.getSession(false);

        if (LoginDAO.validate(login, password)) {
            session.setAttribute("login", login);
            session.setAttribute("authorized", true);
//            String path = request.getContextPath() + "/";
//            response.sendRedirect(path);
//

        }


//        } else {
//            String path = request.getContextPath() + "/login.html";
//            response.sendRedirect(path);
//        }


    }
}
