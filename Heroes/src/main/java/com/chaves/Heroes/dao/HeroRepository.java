package com.chaves.Heroes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chaves.Heroes.domain.Heroes;

public interface HeroRepository extends JpaRepository<Heroes, Long> {
	
	Heroes findByName(String name);
	
	@Query(value = "SELECT * FROM heroes where name LIKE CONCAT('%',UPPER(?1),'%')", nativeQuery = true)
	List<Heroes> findAllByName(String name);
}
