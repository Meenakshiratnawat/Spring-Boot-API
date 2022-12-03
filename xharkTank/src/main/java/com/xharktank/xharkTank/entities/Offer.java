package com.xharktank.xharkTank.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//@Entity
public class Offer implements Serializable {

//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String investor;
	private float amount;
	private float equity;
	private String comment;

//	@ManyToOne(fetch = FetchType.LAZY, optional=false)
//	@JoinColumn(name="pitch_id", nullable=true)
//	private Pitch pitch;



	public Offer() {
		// TODO Auto-generated constructor stub
	}

	public Offer(String investor, float amount, float equity, String comment) {
		super();
		this.investor = investor;
		this.amount = amount;
		this.equity = equity;
		this.comment = comment;
	}

	public String getInvestor() {
		return investor;
	}

	public void setInvestor(String investor) {
		this.investor = investor;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getEquity() {
		return equity;
	}

	public void setEquity(float equity) {
		this.equity = equity;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
//	public void setPitch(Pitch pitch) {
//		this.pitch = pitch;
//	}
	
	public void setId(long id) {
		this.id = id;
	}

}
