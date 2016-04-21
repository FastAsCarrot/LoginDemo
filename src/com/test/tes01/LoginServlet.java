package com.test.tes01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by vrama on 10.04.2016.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
       try(PrintWriter pw = response.getWriter()) {
            request.getRequestDispatcher("Link.html").include(request,response);

            String name = request.getParameter("userName");
            String password = request.getParameter("userPassword");

            if(password.equals("1234")) {
                pw.print("You are successfully logged in!");
                pw.print("<br>Welcome, " + name);

                Cookie cookie = new Cookie("name",name);
                response.addCookie(cookie);
            } else {
                pw.print("Wrong password");
                request.getRequestDispatcher("Login.html").include(request, response);
            }
       }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
