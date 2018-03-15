package com.sullay.service.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sullay.model.finance.Daily;
import com.sullay.repository.finance.DailyRepository;


@Service
public class DailyService {
	@Autowired
	DailyRepository dailyRepository;
	public void create(Daily daily){
		dailyRepository.save(daily);
	}
	public void detele(Daily daily){
		dailyRepository.delete(daily);
	}
	public void update(Daily daily){
		dailyRepository.save(daily);
	}
	public Page<Daily> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size, new Sort(Direction.DESC, "date"));
		return dailyRepository.findAll(pageable);
	}
}
