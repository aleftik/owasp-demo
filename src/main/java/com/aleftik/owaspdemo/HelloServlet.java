package com.aleftik.owaspdemo;

import java.io.*;
import java.sql.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
       try {
           Connection connection = null;
           PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ATABLE WHERE F00 = ?");
           stmt.setString(1, request.getParameter("foo"));
       } catch (SQLException sqle) {
           sqle.printStackTrace(response.getWriter());
       }

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}