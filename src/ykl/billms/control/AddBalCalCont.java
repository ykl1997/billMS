package ykl.billms.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ykl.billms.dao.InsertRecording;
import ykl.billms.model.BalanceCalculation;

/**
 * 添加余额记录
 */
@WebServlet("/addBalCalCont")
public class AddBalCalCont extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BalanceCalculation balanceCalculation = new BalanceCalculation();
		balanceCalculation.setBaseMoney(Double.parseDouble(request.getParameter("baseMoney")));
		balanceCalculation.setDinner(Double.parseDouble(request.getParameter("dinner")));
		balanceCalculation.setEating(Double.parseDouble(request.getParameter("eating")));
		balanceCalculation.setHydropower(Double.parseDouble(request.getParameter("hydropower")));
		balanceCalculation.setIncome(Double.parseDouble(request.getParameter("income")));
		balanceCalculation.setKtv(Double.parseDouble(request.getParameter("ktv")));
		balanceCalculation.setRent(Double.parseDouble(request.getParameter("rent")));
		InsertRecording.addBalanceCalculation(balanceCalculation,
				Integer.parseInt(request.getSession().getAttribute("userid").toString()));
		request.getSession().setAttribute("opt", "ok");
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
