package com.ex01_241122.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex01_241122.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
