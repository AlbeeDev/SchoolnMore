import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/*")
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Main() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename=null;
        String path = request.getPathInfo();
        if(path==null) filename="inserisci";
        else {
        	switch (path){
            case "/inserisci":
                filename="inserisci";
                break;
            case "/paginacarte":
            	String imagepath = null;
                Object selectedImage = request.getSession().getAttribute("selectedImage");

                if (selectedImage != null && !selectedImage.isEmpty()) {
                    response.getWriter().println("<!DOCTYPE html>");
                    response.getWriter().println("<html>");
                    response.getWriter().println("<head>");
                    response.getWriter().println("<title>Pagina Colorata</title>");
                    response.getWriter().println("</head>");
                    response.getWriter().println("<body style='background-color: " + preferredColor + ";'>");
                    response.getWriter().println("<h1>Questa è la tua pagina colorata preferita!</h1>");
                    response.getWriter().println("</body>");
                    response.getWriter().println("</html>");
                } else {
                    response.getWriter().println("Nessun colore preferito impostato.");
                }
            default:
                break;
        	}
        }
        response.setContentType("text/html"); 
        try (InputStream is = getServletContext().getResourceAsStream("/WEB-INF/"+filename+".html");
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String s;
            while ((s = br.readLine()) != null) {
                response.getWriter().print(s);
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String selectedImage = request.getParameter("selectedImage");
        HttpSession session = request.getSession();
        session.setAttribute("image",selectedImage);
        
        //response.sendRedirect("");
        response.getOutputStream().println("immagine inserita");
    }
}