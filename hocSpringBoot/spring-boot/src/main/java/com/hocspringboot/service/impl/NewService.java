package com.hocspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hocspringboot.converter.NewConverter;
import com.hocspringboot.dto.NewDTO;
import com.hocspringboot.entity.CategoryEntity;
import com.hocspringboot.entity.NewEntity;
import com.hocspringboot.repository.ICategoryRepository;
import com.hocspringboot.repository.INewRepository;
import com.hocspringboot.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private INewRepository newRepository;

	@Autowired
	private ICategoryRepository categoryRepository;

	@Autowired
	private NewConverter newConverter;

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity=new NewEntity();
		if(newDTO.getId()!=null) {
			NewEntity oldNewEntity = newRepository.findOne(newDTO.getId());
			newEntity = newConverter.toEntity(newDTO, oldNewEntity);
		}else {
			newEntity = newConverter.toEntity(newDTO);
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}

	/*
	 * @Override public NewDTO update(NewDTO newDTO) { NewEntity oldNewEntity =
	 * newRepository.findOne(newDTO.getId()); NewEntity newEntity =
	 * newConverter.toEntity(newDTO, oldNewEntity); CategoryEntity categoryEntity =
	 * categoryRepository.findOneByCode(newDTO.getCategoryCode());
	 * newEntity.setCategory(categoryEntity); newEntity =
	 * newRepository.save(newEntity); return newConverter.toDTO(newEntity); }
	 */
}
