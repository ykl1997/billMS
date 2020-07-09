package ykl.billms.model;

public class BalanceCalculation {
	private Integer id;
	private double baseMoney;
	private double income;
	private double rent;
	private double hydropower;
	private double eating;
	private double dinner;
	private double balance;
	private String date;
	private double ktv;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getBalance() {
		setBalance();
		return Double.valueOf(String.format("%.2f", balance));
	}

	public void setBalance() {
		this.balance = baseMoney + income - rent - hydropower - dinner - eating;
	}

	public double getEating() {
		return eating;
	}

	public void setEating(double eating) {
		this.eating = eating;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getBaseMoney() {
		return baseMoney;
	}

	public void setBaseMoney(double baseMoney) {
		this.baseMoney = baseMoney;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public double getHydropower() {
		return hydropower;
	}

	public void setHydropower(double hydropower) {
		this.hydropower = hydropower;
	}

	public double getDinner() {
		return dinner;
	}

	public void setDinner(double dinner) {
		this.dinner = dinner;
	}

	public double getKtv() {
		return ktv;
	}

	public void setKtv(double ktv) {
		this.ktv = ktv;
	}

}
