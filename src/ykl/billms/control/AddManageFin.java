package ykl.billms.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ykl.billms.dao.InsertRecording;
import ykl.billms.model.ManageFinances;

/**
 * 用于添加理财服务
 */
@WebServlet("/AddManageFin")
public class AddManageFin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ManageFinances manageFinances = new ManageFinances();
		manageFinances.setMoney(Double.parseDouble(request.getParameter("money")));
		if (request.getParameter("licai").toString().equals("value1")) {
			manageFinances.setType("余额宝");
		} else {
			manageFinances.setType("余利宝");
		}
		manageFinances.setDays(Integer.parseInt(request.getParameter("days")));
		InsertRecording.addManageFinances(manageFinances,
				Integer.parseInt(request.getSession().getAttribute("userid").toString()));
		request.getSession().setAttribute("opt", "ok");
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
