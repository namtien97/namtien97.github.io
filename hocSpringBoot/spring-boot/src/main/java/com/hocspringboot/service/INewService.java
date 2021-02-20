package com.hocspringboot.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.hocspringboot.dto.NewDTO;

public interface INewService {
	NewDTO save(NewDTO newDTO);

	void delete(long[] ids);
	
	// NewDTO update(NewDTO newDTO);
	
	List<NewDTO> findAll(Pageable pageable);
	
	int totalItem();
}
