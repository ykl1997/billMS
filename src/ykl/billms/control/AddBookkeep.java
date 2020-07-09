package ykl.billms.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ykl.billms.dao.InsertRecording;
import ykl.billms.model.Bookkeeping;

/**
 * 用于添加记账记录
 */
@WebServlet("/AddBookkeep")
public class AddBookkeep extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Bookkeeping bookkeeping = new Bookkeeping();
		bookkeeping.setDate(java.sql.Date.valueOf(request.getParameter("date").toString()));
		bookkeeping.setIncome(Double.parseDouble(request.getParameter("income")));
		bookkeeping.setMoney(Double.parseDouble(request.getParameter("money")));
		bookkeeping.setRent(Double.parseDouble(request.getParameter("rent")));
		InsertRecording.addBookkeeping(bookkeeping,
				Integer.parseInt(request.getSession().getAttribute("userid").toString()));
		request.getSession().setAttribute("opt", "ok");
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
