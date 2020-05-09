package ykl.billms.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ykl.billms.dao.UserDao;
import ykl.billms.model.User;

/**
 * 用于验证登录页面
 */
@WebServlet("/LoginCont")
public class LoginCont extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			User user = UserDao.checkPassword(request.getParameter("username"));
			if (user.getPassword().equals(request.getParameter("password"))) {
				request.getSession().setAttribute("loginstate", "logined");
				request.getSession().setAttribute("userid", user.getId());
				response.sendRedirect("index.jsp");
			} else {
				request.setAttribute("msg", "账号或密码错误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			request.setAttribute("msg", "账号或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
