// Using Session
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class BookServlet extends HttpServlet {
	
	private String names[] = {"low", "kastrato", "lion"};
	
	public void doPost( HttpServletRequest request,
						HttpServletResponse response )
		throws ServletException, IOException {
		PrintWriter output;
		String address;

		HttpSession session  = request.getSession(false);
		
		String books = request.getParameter("book"); 
		String qt = request.getParameter("qt"); 
		
		
		if ( ( books != null )  && ( qt != null ) ) {
			Cookie cbook = new Cookie(books, qt);
			cbook.setMaxAge(300);
			response.addCookie(cbook);
	
			response.sendRedirect("http://localhost:8080/bobcat/Hipster");
					
		}
		else {
			response.sendRedirect("http://localhost:8080/bobcat/Hipster");
        }
   }

   	public void doGet( HttpServletRequest request,
						HttpServletResponse response )
		throws ServletException, IOException {


			HttpSession session = request.getSession(false);
			String address;
			
			if ( session == null ){

				response.sendRedirect("http://localhost:8080/bobcat/");
			}			
			else if ( ( session.getAttribute("fname")==null ) || ( session.getAttribute("sname")==null ) ){

				response.sendRedirect("http://localhost:8080/bobcat/");
			}
			else {
				
				if ( request.getParameter("accept")!=null ){
					address ="/WEB-INF/final.jsp";
						RequestDispatcher dispatcher =
					request.getRequestDispatcher(address);
					dispatcher.forward(request, response);
				
					
					Cookie killMyCookie[] = request.getCookies();
				

					for ( int i=0 ; i < ( killMyCookie.length ) ; i++){
						if ( killMyCookie[i].getName().equals("1") || killMyCookie[i].getName().equals("2") || killMyCookie[i].getName().equals("3") || killMyCookie[i].getName().equals("4") || killMyCookie[i].getName().equals("5") || killMyCookie[i].getName().equals("6") ){
							killMyCookie[i].setMaxAge(0);
							response.addCookie(killMyCookie[i]);
						}
					}
					
					session.invalidate();
				}
				
			

				if ( request.getParameter("reset")!=null ){
				
					Cookie killMyCookie[] = request.getCookies();
				
					for ( int i=0 ; i < ( killMyCookie.length ) ; i++){
						if ( killMyCookie[i].getName().equals("1") || killMyCookie[i].getName().equals("2") || killMyCookie[i].getName().equals("3") || killMyCookie[i].getName().equals("4") || killMyCookie[i].getName().equals("5") || killMyCookie[i].getName().equals("6") ){
							killMyCookie[i].setMaxAge(0);
							response.addCookie(killMyCookie[i]);
						}
					}
			
					response.sendRedirect("http://localhost:8080/bobcat/Hipster");
			
				}

				

			}
	
	}


}
