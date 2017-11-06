package com.jcg.examples.services;

import com.jcg.examples.models.User;

import java.util.List;

public interface UserService {
	User findByLog(String log);
    void save(User user);
    //void save();
	void deleteById(Long id);
	List<User> selectAll();

}

