package by.htp.shop.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.shop.bean.User;
import by.htp.shop.controller.command.Command;

public class SignIn implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		
		String login;
		String password;
		
		login = request.getParameter("login");
		password = request.getParameter("password");
		
		//service
		User user = new User();
		user.setName("Vasya");		
		
		//request.setAttribute("user", user);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("user", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// log
			dispatcher = request.getRequestDispatcher("error.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException |IOException e1) {
				//log
			}
			
		}
		
		
		
	}

}
