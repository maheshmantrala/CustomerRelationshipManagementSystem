package com.mahesh.capstone.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahesh.capstone.entity.Interaction;

@Repository
public interface InteractionRepository extends JpaRepository<Interaction, Long> {

	List<Interaction> findByCustomerId(Long customerId);
}
