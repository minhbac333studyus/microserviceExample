package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CreateUserRequestModel;
import com.example.demo.service.UserServiceImp;
import com.example.demo.shared.UserDto;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private Environment env;
	@Autowired
	private UserServiceImp userService;

	@GetMapping("/status/check")
	public String status() {
		return "working on port " + env.getProperty("local.server.port");
	}

	@PostMapping
	public String createUser(@RequestBody CreateUserRequestModel userDetail) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userDetail,UserDto.class);
		userService.createUser(userDto);
		return "Create user method is call";
	}
}
