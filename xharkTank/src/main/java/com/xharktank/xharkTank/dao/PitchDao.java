package com.xharktank.xharkTank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xharktank.xharkTank.entities.Offer;
import com.xharktank.xharkTank.entities.Pitch;

public interface PitchDao extends JpaRepository<Pitch, Long>{

	 @Query(value = "select * from pitch where id = ?1", nativeQuery = true)
	 Pitch findByPitchId(Long id);

}
