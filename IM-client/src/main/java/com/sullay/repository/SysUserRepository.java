package com.sullay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sullay.model.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
	SysUser findByUsername(String username);
}
