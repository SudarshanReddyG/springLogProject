package com.sudarshan.service;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public boolean isPresent(String name) {
		return true;
	}

	@Override
	public String getNameById(Integer id) {
		return getName(id);
	}
	
	private String getName(Integer id) {
		return "Sudarshan";
	}

}
