package com.albeedev.jee01;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuilder html = new StringBuilder();

        try {
            String name = request.getParameter("nome");
            html.append("<h1>Benvenuto ").append(name).append("</h1>");
            int eta = Integer.parseInt(request.getParameter("eta"));
            html.append("<h2>").append(eta).append("</h2>");
        } catch (Exception e) {

        }

        response.getWriter().append(html);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
    }
}