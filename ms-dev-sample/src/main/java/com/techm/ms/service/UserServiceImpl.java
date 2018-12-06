package com.techm.ms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.techm.ms.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	
private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	static {
		users= populateDummyUsers();
	}

	@Override
	public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}

	@Override
	public User findByName(String name) {
		for(User user : users){
			if(user.getName() == name){
				return user;
			}
		}
		return null;
	}
	

	@Override
	public void saveUser(User user) {
		counter.incrementAndGet();
		users.add(user);
	}

	@Override
	public List<User> findAllUsers() {
		return users;
	}

	@Override
	public boolean isUserExist(User user) {
		return findByName(user.getName())!=null;
	}
	
	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(),"User1",45,10001));
		users.add(new User(counter.incrementAndGet(),"User2",46,10002));
		users.add(new User(counter.incrementAndGet(),"User3",47,10003));
		return users;
	}

	@Override
	public User createUser(User user) {
		
		user.setId(counter.incrementAndGet());
		users.add(user);
		return user;
	}


}
