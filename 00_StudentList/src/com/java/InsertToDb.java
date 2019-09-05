package com.java;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertToDb")
public class InsertToDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("one");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// StudentDao a = new StudentDao();

		String name = request.getParameter("name");
		System.out.println("1 : "+name);
		String userName = request.getParameter("username");
		System.out.println("1.1 : "+userName);
		String password = request.getParameter("psw");
		String uPassword = request.getParameter("rpsw");

		int psw = Integer.parseInt(password);
		int rPsw = Integer.parseInt(uPassword);

//		a.setName(name);
//		a.setUserName(userName);

		if (psw == rPsw) {
			StudentDao a = new StudentDao();

			a.setName(name);
			a.setUserName(userName);
			a.setPassword(psw);

			int result = JdbcConn.getInsertStd(a);
			if (result > 0) {
				out.print("<h5>Record inserted successsful</h5>");
				request.getRequestDispatcher("log.html").include(request, response);
			} else {
				out.print("Sorry..Unable to save record");
				request.getRequestDispatcher("registration.html").include(request, response);
			}

		} else {
			out.print("Please enter a valid SerialNumber.");
			request.getRequestDispatcher("registration.html").include(request, response);
		}
		// System.out.println("two");

	}
}
