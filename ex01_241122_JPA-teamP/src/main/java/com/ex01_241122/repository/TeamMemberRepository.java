package com.ex01_241122.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex01_241122.entity.TeamMember;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Integer> {

}
