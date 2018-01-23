package com.last.jsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.last.jsp.factory.ServiceFactory;
import com.last.jsp.service.MenuService;
import com.last.jsp.service.UserService;

import util.URIParser;

/**
 * Servlet implementation class JspServlet
 */
@WebServlet("/view/*")
public class JspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger Log = Logger.getLogger(JspServlet.class);
	private ServiceFactory sf= ServiceFactory.getInstance();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JspServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, res);
	}

	public void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		Log.info(uri);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF" + uri + ".jsp");
		if (req.getServletContext().getAttribute("menuList") == null) {
			MenuService ms = (MenuService)sf.getService("menu");
			ms.getMenuList(req);
		}
		
		String command=URIParser.getCommand(uri,1);
		Log.debug(command);
		if(command.equals("list")) {
			uri=uri.replaceAll("/"+command,"");
			command=URIParser.getCommand(uri, 1);
			UserService s=(UserService)sf.getService(command);
			/*UserService ss=new UserServiceImpl();*/
			s.getUserList(req);
		}
		
		req.setAttribute("root", uri);
		rd.forward(req, res);
	}
}
