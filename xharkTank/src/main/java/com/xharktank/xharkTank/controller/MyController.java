package com.xharktank.xharkTank.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.xharktank.xharkTank.entities.Offer;
import com.xharktank.xharkTank.entities.OnlyId;
import com.xharktank.xharkTank.entities.Pitch;
import com.xharktank.xharkTank.services.PitchService;

@RestController
public class MyController {
	
	@Autowired
	private PitchService pitchService;
	
	@GetMapping("/pitches")
	public List<Pitch> getPitches() {
		List<Pitch> p = this.pitchService.getPitches();
		Collections.reverse(p);
		return p;
	}
	
	@GetMapping("/pitches/{pitchId}")
	public Pitch getPitch (@PathVariable String pitchId) {
	    Pitch p = this.pitchService.getPitch(Long.parseLong(pitchId));
	    if(p==null) {
	    	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	    }
	    return p;
	}
	
	@PostMapping("/pitches")
	@ResponseStatus(code = HttpStatus.CREATED)
	public OnlyId addPitch(@RequestBody Pitch pitch) {
		if(pitch==null || pitch.getPitchTitle() == null || pitch.getPitchIdea() == null ||
				  pitch.getEntrepreneur() == null || pitch.getAskAmount()<=0 || pitch.getEquity()<=0 ||
				pitch.getEquity() > 100) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Pitch p = this.pitchService.addPitch(pitch);
		return new OnlyId(p.getId());
	}
	
	@PostMapping("/pitches/{pitchId}/makeOffer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public OnlyId makeOffer(@RequestBody Offer offer, @PathVariable String pitchId) {
		if(offer==null || offer.getInvestor() == null || offer.getComment() == null || offer.getEquity() <= 0 ||
				offer.getAmount() <= 0 || offer.getEquity() > 100) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Pitch p = this.pitchService.makeOffer(offer, Long.parseLong(pitchId));
		if(p==null) {
	    	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	    }
		return new OnlyId(p.getId());
	}

}
