

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MainServlet/*")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {
        super();
        System.out.println("costruttore");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getPathInfo();
		System.out.println(path);
		switch (path) {
		case "/testhtml": {
			response.setContentType("text/html"); // Set the content type to HTML
	        try (InputStream is = getServletContext().getResourceAsStream("/WEB-INF/NewFile.html");
	             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
	            String s;
	            while ((s = br.readLine()) != null) {
	                response.getWriter().print(s);
	            }
	        }
			break;
		}
		case "/albero.jpg": {
			response.setContentType("image/jpeg");
			try (InputStream is = getServletContext().getResourceAsStream("/WEB-INF/albero.jpg")) {
        		BufferedImage image = ImageIO.read(is);
        		ImageIO.write(image, "jpg", response.getOutputStream());
	        }
			break;
		}
		case "/somma":{
			int a = Integer.parseInt(request.getParameter("a"));
			response.getWriter().append(a+"\n");
			int b = Integer.parseInt(request.getParameter("b"));
			response.getWriter().append(b+"\n");
			response.getWriter().append((a+b)+"\n");
			break;
		}
		default:
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
