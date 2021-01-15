package com.hocjspservlet.service;

import com.hocjspservlet.model.UserModel;

public interface IUserService {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
