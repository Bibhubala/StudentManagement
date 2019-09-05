package com.java;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Process")
public class Process extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		// int psw = Integer.parseInt(password);

//		StudentDao st = new StudentDao();
//		st.setName(name);
//		st.setPassword(psw);
		if (name == null || "".equals(name) || password == null || "".equals(password)) {
			System.out.println("hello BROTHER");
			out.print("<font color='red'>ERROR: Mandatoy parametter missing</font>");
			request.getRequestDispatcher("log.html").include(request, response);

		} else {
			System.out.println("hello SUCCESSFUl");
			int psw = Integer.parseInt(password);
			StudentDao sd = JdbcConn.getAlStudent(psw, name);
			if (sd != null) {
				// System.out.println("hello boss");
				out.print("Hello " + sd.getName()
						+ ".. Welcome to this page you are succesfully registered and your passwors is "
						+ sd.getPassword() + "<br><br>");
				out.print("<table>");
				out.print("");
				out.print("<tr><td><a href= 'log.html' >click here to go back</a></td></tr> ");
				out.print("</table>");
				out.close();
			} else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
				;
			}
		}

	}
}
