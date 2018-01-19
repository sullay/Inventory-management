package com.sullay.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sullay.model.SysUser;
import com.sullay.repository.SysUserRepository;

public class CustomUserService implements UserDetailsService{
	@Autowired
	SysUserRepository userRespository;
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		SysUser user=userRespository.findByUsername(s);
		if(user==null) {
			 throw new UsernameNotFoundException("用户名不存在");
		}
		System.out.println("s:"+s);
		System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
		return user;
	}

}
