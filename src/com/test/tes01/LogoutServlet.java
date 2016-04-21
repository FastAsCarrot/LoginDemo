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

public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try (PrintWriter pw = response.getWriter()) {
            request.getRequestDispatcher("Link.html").include(request, response);
            Cookie co = new Cookie("name", "");
            co.setMaxAge(0);
            response.addCookie(co);

            pw.print("You've successfully logged out!");

        }
    }
}
