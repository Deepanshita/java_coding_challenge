package com.model;

public class CashDonation extends Donation{
	private int cashDonationId;
	private double donationAmount;
	private String donationDate;

	public CashDonation() {
		super();
	}

	public CashDonation(int cashDonationId, double donationAmount, String donationDate) {
		super();
		this.cashDonationId = cashDonationId;
		this.donationAmount = donationAmount;
		this.donationDate = donationDate;
	}

	public CashDonation(double donationAmount2, String donationDate2) {
		// TODO Auto-generated constructor stub
	}

	public int getCashDonationId() {
		return cashDonationId;
	}

	public void setCashDonationId(int cashDonationId) {
		this.cashDonationId = cashDonationId;
	}

	public double getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(double donationAmount) {
		this.donationAmount = donationAmount;
	}

	public String getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(String donationDate) {
		this.donationDate = donationDate;
	}

	@Override
	public String toString() {
		return "CashDonation [cashDonationId=" + cashDonationId + ", donationAmount=" + donationAmount
				+ ", donationDate=" + donationDate + "]";
	}
}