package com.example.demo.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.data.UserEntity;
import com.example.demo.repo.UserRepository;
import com.example.demo.shared.UserDto;

@Service
public class UserServiceImp implements UsersService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public UserDto createUser(UserDto userDetails) {
		// TODO Auto-generated method stub
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class); 
		
		userRepository.save(userEntity);
		UserDto returnValue =  modelMapper.map(userEntity,UserDto.class);
		return returnValue;
	}
//	@Override
//	public UserDetails loadUserByUsername(String username) {
//		// TODO Auto-generated method stub
//		Optional<UserEntity> getUser = userRepository.findByEmail(username);
//		if(getUser.isPresent()) {
//			throw new UsernameNotFoundException(username);
//		}
//		UserEntity userEntity = getUser.get();
//		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(),true,true,true, true, new ArrayList<>()) ;
//	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		Optional<UserEntity> getUser = userRepository.findByEmail(username);
		if(!getUser.isPresent()) {
			throw new UsernameNotFoundException(username);
		}
		UserEntity userEntity = getUser.get();
		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(),true,true,true, true, new ArrayList<>()) ;
	}
	@Override
	public UserDto getUserDetailsByEmail(String email) { 
		Optional<UserEntity>userEntity = userRepository.findByEmail(email);
		
		if(!userEntity.isPresent()) {
			throw new UsernameNotFoundException(email);
		}   
		return new ModelMapper().map(userEntity.get(), UserDto.class);
	}
}
