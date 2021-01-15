package com.hocspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hocspringboot.entity.NewEntity;

public interface INewRepository extends JpaRepository<NewEntity, Long> {

	
}
