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
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try(PrintWriter pw = response.getWriter()) {
            request.getRequestDispatcher("Link.html").include(request, response);

            Cookie co[] = request.getCookies();

            if(co!=null) {
                String name = co[1].getValue();
                if(!name.equals("")||name!=null){
                    pw.print("<b>Welcome to Profile</b>");
                    pw.print("<br>Welcome, "+name);
                }
            }else{
                pw.print("Please login first");
                request.getRequestDispatcher("login.html").include(request, response);
            }
        }
    }
}
