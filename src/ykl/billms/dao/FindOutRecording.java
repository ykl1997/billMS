package ykl.billms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ykl.billms.DBtool.ConnTool;
import ykl.billms.model.BalanceCalculation;
import ykl.billms.model.Bookkeeping;
import ykl.billms.model.ManageFinances;
import ykl.billms.model.PaymentInstallments;

public class FindOutRecording {
	public static List<BalanceCalculation> findBC(String date, int userid) {
		List<BalanceCalculation> lists = new ArrayList<BalanceCalculation>();
		String sql = "select * from t_balance_calculation where date <='" + date + "' and userId=" + userid;
		try {
			Statement statement = ConnTool.getCon().createStatement();
			ResultSet query = statement.executeQuery(sql);
			while (query.next()) {
				BalanceCalculation balanceCalculation = new BalanceCalculation();
				balanceCalculation.setBaseMoney(query.getDouble("baseMoney"));
				balanceCalculation.setDinner(query.getDouble("dinner"));
				balanceCalculation.setEating(query.getDouble("eating"));
				balanceCalculation.setHydropower(query.getDouble("hydropower"));
				balanceCalculation.setIncome(query.getDouble("income"));
				balanceCalculation.setKtv(query.getDouble("ktv"));
				balanceCalculation.setRent(query.getDouble("rent"));
				balanceCalculation.setDate(query.getString("date"));
				lists.add(balanceCalculation);
			}
			return lists;
		} catch (SQLException e) {
			return null;
		}
	}

	public static List<Bookkeeping> findBK(String date, int userid) {
		List<Bookkeeping> lists = new ArrayList<Bookkeeping>();
		String sql = "select * from t_bookkeeping where date <='" + date + "' and userId=" + userid;
		try {
			Statement statement = ConnTool.getCon().createStatement();
			ResultSet query = statement.executeQuery(sql);
			while (query.next()) {
				Bookkeeping bookkeeping = new Bookkeeping();
				bookkeeping.setDate(query.getDate("date"));
				bookkeeping.setIncome(query.getDouble("income"));
				bookkeeping.setMoney(query.getDouble("money"));
				bookkeeping.setRent(query.getDouble("rent"));
				lists.add(bookkeeping);
			}
			return lists;
		} catch (SQLException e) {
			return null;
		}
	}

	public static List<ManageFinances> findMF(String date, int userid) {
		List<ManageFinances> lists = new ArrayList<ManageFinances>();
		String sql = "select * from t_manage_finances where date <='" + date + "' and userId=" + userid;
		try {
			Statement statement = ConnTool.getCon().createStatement();
			ResultSet query = statement.executeQuery(sql);
			while (query.next()) {
				ManageFinances manageFinances = new ManageFinances();
				manageFinances.setDays(query.getInt("days"));
				manageFinances.setMoney(query.getDouble("money"));
				manageFinances.setType(query.getString("type"));
				manageFinances.setDate(query.getString("date"));
				lists.add(manageFinances);
			}
			return lists;
		} catch (SQLException e) {
			return null;
		}
	}

	public static List<PaymentInstallments> findPI(String date, int userid) {
		List<PaymentInstallments> lists = new ArrayList<PaymentInstallments>();
		String sql = "select * from t_payment_installments where date <='" + date + "' and userId=" + userid;

		try {
			Statement statement = ConnTool.getCon().createStatement();
			ResultSet query = statement.executeQuery(sql);
			while (query.next()) {
				PaymentInstallments paymentInstallments = new PaymentInstallments();
				paymentInstallments.setInstallment(query.getInt("installment"));
				paymentInstallments.setMoney(query.getDouble("money"));
				paymentInstallments.setType(query.getString("type"));
				paymentInstallments.setDate(query.getString("date"));
				lists.add(paymentInstallments);
			}
			return lists;
		} catch (SQLException e) {
			return null;
		}
	}

	public static String getResultMap(String date, int userid) {
		String resultString = "";
		List<BalanceCalculation> findBC = findBC(date, userid);
		if (findBC.size() > 0) {
			resultString += "<h3>余额记录</h3>";
			for (BalanceCalculation balanceCalculation : findBC) {
				resultString += "  基础现金：" + balanceCalculation.getBalance() + "  收入：" + balanceCalculation.getIncome()
						+ "  房租：" + balanceCalculation.getRent() + "  水电：" + balanceCalculation.getHydropower()
						+ "  伙食：" + balanceCalculation.getEating() + "  请客：" + balanceCalculation.getDinner() + "  ktv："
						+ balanceCalculation.getKtv() + "  结余：" + balanceCalculation.getBalance() + "  日期"
						+ balanceCalculation.getDate() + "<br>";
			}
		}

		List<Bookkeeping> findBK = findBK(date, userid);
		if (findBK.size() > 0) {
			resultString += "<h3>记账</h3>";
			for (Bookkeeping bookkeeping : findBK) {
				resultString += "  记账金额：" + bookkeeping.getIncome() + "  收入：" + bookkeeping.getIncome() + "  房租："
						+ bookkeeping.getRent() + "  日期：" + bookkeeping.getDate() + "<br>";
			}
		}

		List<ManageFinances> findMF = findMF(date, userid);
		if (findMF.size() > 0) {
			resultString += "<h3>用于理财</h3>";
			for (ManageFinances manageFinances : findMF) {
				resultString += "  理财金额：" + manageFinances.getMoney() + "  产品：" + manageFinances.getType() + "  理财天数："
						+ manageFinances.getDays() + "  日期：" + manageFinances.getDate() + "<br>";
			}
		}

		List<PaymentInstallments> findPI = findPI(date, userid);
		if (findPI.size() > 0) {
			resultString += "<h3>分期支付</h3>";
			for (PaymentInstallments paymentInstallments : findPI) {
				resultString += "  支付金额" + paymentInstallments.getMoney() + "  类型：" + paymentInstallments.getType()
						+ "  分期次数：" + paymentInstallments.getInstallment() + "  日期：" + paymentInstallments.getDate()
						+ "<br>";
			}
		}
		if (resultString.length() <= 0) {
			resultString += "您在当前日期之前还没有消费记录！<br>";
		}
		resultString += "  <a href=\"index.jsp\"><h4 style=\"font-size:18px;\">返回</h4></a>";
		return resultString;

	}

}
