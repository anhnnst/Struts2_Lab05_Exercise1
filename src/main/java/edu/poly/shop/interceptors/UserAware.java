package edu.poly.shop.interceptors;

import edu.poly.shop.domain.User;

public interface UserAware {

	void setUser(User user);
}