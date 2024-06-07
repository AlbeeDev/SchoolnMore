package com.example.esservlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MiaServlet/*")
public class MiaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    ArrayList<Messaggio> lista = new ArrayList<Messaggio>();

    public MiaServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename=null;
        String path = request.getPathInfo();
        switch (path){
            case "/home":
                filename="home";
                break;
            case "/inserisci":
                filename="inserisci";
                break;
            case "/cerca":
                if (request.getParameter("fname") == null) {
                    filename = "cerca";
                }
                else{
                    response.setContentType("text/html");
                    response.getWriter().println("<ul>");
                    for(Messaggio m : lista) {
                        if(m.utente.equals(request.getParameter("fname"))) {
                            response.getWriter().println("<li>");
                            response.getWriter().println(m.messaggio);
                            response.getWriter().println("</li>");
                        }
                    }
                    response.getWriter().println("</ul>");
                    response.getWriter().println("<button><a href=\"home\">Back</a></button>");
                    return;
                }
            default:
                break;
        }
        response.setContentType("text/html"); // Set the content type to HTML
        try (InputStream is = getServletContext().getResourceAsStream("/WEB-INF/"+filename+".html");
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String s;
            while ((s = br.readLine()) != null) {
                response.getWriter().print(s);
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lista.add(new Messaggio(request.getParameter("fname"), request.getParameter("lname")));
        //response.getWriter().println("<h1>Messaggio inserito</h1>");
        response.sendRedirect("home");
    }
}

class Messaggio {
    String utente, messaggio;
    public Messaggio(String utente, String messaggio) {
        this.utente = utente;
        this.messaggio = messaggio;
    }
}