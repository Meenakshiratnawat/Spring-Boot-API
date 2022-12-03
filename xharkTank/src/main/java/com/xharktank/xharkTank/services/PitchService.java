package com.xharktank.xharkTank.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.xharktank.xharkTank.entities.Offer;
import com.xharktank.xharkTank.entities.Pitch;

public interface PitchService {

	public List<Pitch> getPitches();

	public Pitch getPitch(long PitchId);
	
	public Pitch addPitch(Pitch pitch);
	
	public Pitch makeOffer(Offer offer, long PitchId);
}
 