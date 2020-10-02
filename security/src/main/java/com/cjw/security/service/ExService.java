package com.cjw.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjw.security.auth.MyUserDetail;
import com.cjw.security.entity.User;
import com.cjw.security.repository.ExRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExService implements UserDetailsService {
	private final ExRepository repository;

	@Transactional
	public void joinUser(User user){
		repository.saveUser(user);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repository.findUserByEmail(email);
		return new MyUserDetail(user);
	}
}
