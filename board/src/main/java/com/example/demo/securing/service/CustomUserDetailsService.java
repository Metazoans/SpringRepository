package com.example.demo.securing.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.securing.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 단건조회
		UserDTO userDTO = userMapper.getUser(username);
		
		if(userDTO == null) {
			throw new UsernameNotFoundException("id check");
		}
		
//		UserDTO에 UserDetails 상속 OR CustomUser.java생성 후 UserDetails 상속 및 UserDTO 사용
//		List<GrantedAuthority> role = new ArrayList<>();
//		userDTO.getRoles().forEach(r -> role.add(new SimpleGrantedAuthority(r.getRoleName())) );
//		return new User(userDTO.getLoginId(), userDTO.getPassword(), role);
		
//		UserDTO에 상속시
//		return userDTO;
		
//		CustomUser 생성시
		return new CustomUser(userDTO);
	}

}
