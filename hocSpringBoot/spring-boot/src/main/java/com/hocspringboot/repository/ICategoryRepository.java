package com.hocspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hocspringboot.entity.CategoryEntity;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findOneByCode(String code);
}
