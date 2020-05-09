package ykl.billms.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ykl.billms.dao.FindOutRecording;

/**
 * 筛选账单
 */
@WebServlet("/LookUpCont")
public class LookUpCont extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;utf-8");
		response.setCharacterEncoding("UTF-8");
		String date = request.getParameter("date");
		int userid = Integer.parseInt(request.getSession().getAttribute("userid").toString());
		response.getWriter().print(FindOutRecording.getResultMap(date, userid));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
