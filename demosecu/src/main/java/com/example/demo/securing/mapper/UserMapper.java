package com.example.demo.securing.mapper;

import java.util.List;

import com.example.demo.securing.service.RoleDTO;
import com.example.demo.securing.service.UserDTO;

public interface UserMapper {
	public UserDTO getUser(String loginId);
	public List<RoleDTO> getRole(Long id);
}
