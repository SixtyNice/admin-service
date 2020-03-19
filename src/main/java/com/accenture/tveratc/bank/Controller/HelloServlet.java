package com.accenture.tveratc.bank.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("name");

        PrintWriter send = response.getWriter();
        String id = session.getId();
        send.println(id);
        try {
            if (name == null) {
                session.setAttribute("name", "Tom");
                send.println("Session data is set");
            } else {
                send.println("Name" + name);
                session.removeAttribute("name");
            }

        } finally {
            send.close();
        }
    }
}
