package com.hocspringboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

	@Override
	public void delete(long[] ids) {
		for(long item:ids) {
			newRepository.delete(item);
		}
	}

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll(pageable).getContent();
		for(NewEntity item:entities) {
			NewDTO newDTO = newConverter.toDTO(item);
			results.add(newDTO);
		}
		if(results.size() == 0) {
			return null;
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
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
