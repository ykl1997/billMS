package ykl.billms.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ykl.billms.dao.InsertRecording;
import ykl.billms.model.PaymentInstallments;

/**
 * 添加分期支付记录
 */
@WebServlet("/AddPayInstall")
public class AddPayInstall extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PaymentInstallments paymentInstallments = new PaymentInstallments();
		paymentInstallments.setMoney(Double.parseDouble(request.getParameter("money")));
		if (request.getParameter("pay_way").toString().equals("valeu1")) {
			paymentInstallments.setType("蚂蚁花呗");
		} else if (request.getParameter("pay_way").toString().equals("valeu2")) {
			paymentInstallments.setType("余额");
		} else {
			paymentInstallments.setType("信用卡");
		}
		paymentInstallments.setInstallment(Integer.parseInt(request.getParameter("installment")));
		InsertRecording.addPaymentInstallments(paymentInstallments,
				Integer.parseInt(request.getSession().getAttribute("userid").toString()));
		request.getSession().setAttribute("opt", "ok");
		response.sendRedirect("index.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
