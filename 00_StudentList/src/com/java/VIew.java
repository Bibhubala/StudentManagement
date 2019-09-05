package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VIew")
public class VIew extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VIew() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		List<StudentDao> sd = JdbcConn.getStudent();

		out.print("<table border='1' width='100'>");
		out.print("<tr><th>RollNo</th><th>Name</th><th>Address</th></tr>");

		for (StudentDao st : sd) {
			out.print("<tr><td>" + st.getPassword() + "</td><td>" + st.getName() + "</td><td>" + st.getUserName()
					+ "</td></tr>");
		}
		out.print("</table>");
		out.print("<b>login Page :</b><a href='log.html'>Click here</a>");
	}

}
