package com.example.testing.REST_example;

public class BillResponse {
	
	private String customerName;
    private double totalBillAmount;
    
	public BillResponse(String customerName, double totalBillAmount) {
		super();
		this.customerName = customerName;
		this.totalBillAmount = totalBillAmount;
	}

	@Override
	public String toString() {
		return "BillResponse [customerName=" + customerName + ", totalBillAmount=" + totalBillAmount + "]";
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getTotalBillAmount() {
		return totalBillAmount;
	}

	public void setTotalBillAmount(double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}

	public BillResponse() {
		// TODO Auto-generated constructor stub
	}

}
