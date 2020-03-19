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

@WebServlet("/loginServlet")
public class Login extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        try(PrintWriter send = response.getWriter()){
//            send.println("login");
//        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter send = response.getWriter();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        session.setAttribute("login", login);

        if (LoginDAO.validate(login, password)) {
            send.println(login + password);
        } else {
            send.println("Wrong");
        }
        send.close();
    }
}
