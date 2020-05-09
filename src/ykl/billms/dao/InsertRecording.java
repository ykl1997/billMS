package ykl.billms.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ykl.billms.DBtool.ConnTool;
import ykl.billms.model.BalanceCalculation;
import ykl.billms.model.Bookkeeping;
import ykl.billms.model.ManageFinances;
import ykl.billms.model.PaymentInstallments;

public class InsertRecording {

	public static void addBalanceCalculation(BalanceCalculation balanceCalculation, Integer userid) {
		try {
			String sql = "insert into t_balance_calculation(baseMoney,income,rent,hydropower,"
					+ "eating,dinner,ktv,balance,userId,date) value(?,?,?,?,?,?,?,?,?,now())";
			PreparedStatement prepareStatement = ConnTool.getCon().prepareStatement(sql);
			prepareStatement.setDouble(1, balanceCalculation.getBaseMoney());
			prepareStatement.setDouble(2, balanceCalculation.getIncome());
			prepareStatement.setDouble(3, balanceCalculation.getRent());
			prepareStatement.setDouble(4, balanceCalculation.getHydropower());
			prepareStatement.setDouble(5, balanceCalculation.getEating());
			prepareStatement.setDouble(6, balanceCalculation.getDinner());
			prepareStatement.setDouble(7, balanceCalculation.getKtv());
			prepareStatement.setDouble(8, balanceCalculation.getBalance());
			prepareStatement.setInt(9, userid);
			prepareStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void addBookkeeping(Bookkeeping bookkeeping, Integer userid) {
		String sql = "insert into t_bookkeeping(money,income,rent,userid,date) value(?,?,?,?,?)";
		try {
			PreparedStatement prepareStatement = ConnTool.getCon().prepareStatement(sql);
			prepareStatement.setDouble(1, bookkeeping.getMoney());
			prepareStatement.setDouble(2, bookkeeping.getIncome());
			prepareStatement.setDouble(3, bookkeeping.getRent());
			prepareStatement.setInt(4, userid);
			prepareStatement.setDate(5, bookkeeping.getDate());
			prepareStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void addManageFinances(ManageFinances manageFinances, int userid) {
		String sql = "insert into t_manage_finances(money,type,days,userId,date) value(?,?,?,?,now())";
		try {
			PreparedStatement prepareStatement = ConnTool.getCon().prepareStatement(sql);
			prepareStatement.setDouble(1, manageFinances.getMoney());
			prepareStatement.setString(2, manageFinances.getType());
			prepareStatement.setDouble(3, manageFinances.getDays());
			prepareStatement.setInt(4, userid);
			prepareStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void addPaymentInstallments(PaymentInstallments paymentInstallments, int userid) {
		String sql = "insert into t_payment_installments(money,type,installment,userId,date) value(?,?,?,?,now())";
		try {
			PreparedStatement prepareStatement = ConnTool.getCon().prepareStatement(sql);
			prepareStatement.setDouble(1, paymentInstallments.getMoney());
			prepareStatement.setString(2, paymentInstallments.getType());
			prepareStatement.setDouble(3, paymentInstallments.getInstallment());
			prepareStatement.setInt(4, userid);
			prepareStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
