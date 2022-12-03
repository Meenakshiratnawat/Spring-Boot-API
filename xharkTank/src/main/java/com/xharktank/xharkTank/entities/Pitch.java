package com.xharktank.xharkTank.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pitch implements Serializable{
	
	@Id
	@GeneratedValue //(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String entrepreneur;
	private String pitchTitle; 
	private String pitchIdea;
	private float askAmount;
	private float equity;
	
//	@OneToMany(mappedBy="pitch", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
	@ElementCollection
	private List<Offer> offers = new ArrayList<>();
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Pitch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEntrepreneur() {
		return entrepreneur;
	}

	public void setEntrepreneur(String entrepreneur) {
		this.entrepreneur = entrepreneur;
	}

	public String getPitchTitle() {
		return pitchTitle;
	}

	public void setPitchTitle(String pitchTitle) {
		this.pitchTitle = pitchTitle;
	}

	public String getPitchIdea() {
		return pitchIdea;
	}

	public void setPitchdea(String pitchIdea) {
		this.pitchIdea = pitchIdea;
	}

	public float getAskAmount() {
		return askAmount;
	}

	public void setAskAmount(float askAmount) {
		this.askAmount = askAmount;
	}

	public float getEquity() {
		return equity;
	}

	public void setEquity(float equity) {
		this.equity = equity;
	}

	public Pitch(long id, String entrepreneur, String pitchTitle, String pitchIdea, float askAmount, float equity, List<Offer> offers) {
		super();
		this.id = id;
		this.entrepreneur = entrepreneur;
		this.pitchTitle = pitchTitle;
		this.pitchIdea = pitchIdea;
		this.askAmount = askAmount;
		this.equity = equity;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	

}
