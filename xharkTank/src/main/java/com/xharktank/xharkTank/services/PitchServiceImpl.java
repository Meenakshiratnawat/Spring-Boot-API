package com.xharktank.xharkTank.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xharktank.xharkTank.dao.PitchDao;
import com.xharktank.xharkTank.entities.Offer;
import com.xharktank.xharkTank.entities.Pitch;

@Service
public class PitchServiceImpl implements PitchService {

	@Autowired
	private PitchDao pitchDao;
//	@Autowired
//	private OfferDao offerDao;
	
	public PitchServiceImpl() {
		
	}
                 

	@Override
	public List<Pitch> getPitches() {
		return pitchDao.findAll();
	}
	
	@Override
	public Pitch getPitch(long pitchId) {
		return pitchDao.findByPitchId(pitchId);
	}


	@Override
	public Pitch addPitch(Pitch pitch) {
		pitchDao.save(pitch);
		return pitch;
	}
	

	@Override
	public Pitch makeOffer(Offer offer, long pitchId) {
		Pitch p = getPitch(pitchId);
		if(p==null) return p;
		offer.setId(pitchId);
		p.getOffers().add(offer);
		pitchDao.save(p);
		return p;
	}

}
