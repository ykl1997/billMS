package ykl.billms.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ykl.billms.dao.UserDao;
import ykl.billms.model.User;

/**
 * 注册用户
 */
@WebServlet("/SignupCont")
public class SignupCont extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String idpass = request.getParameter("idpassword");
		user.setUsername(username);
		user.setPassword(password);
		if (!password.equals(idpass)) {
			request.setAttribute("msg2", "两次密码不一致");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		} else if (UserDao.SelectByname(username)) {
			request.setAttribute("msg1", "用户名已存在");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		} else {
			UserDao.addUesr(user);
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
