package recruitBackEnd.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recruitBackEnd.service.SimpleJobManager;

public class PdfServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		SimpleJobManager jobManager = new SimpleJobManager();
	    
	    response.getOutputStream().write(jobManager.getPdf(Integer.parseInt(request.getParameter("id"))));       
	}
}
