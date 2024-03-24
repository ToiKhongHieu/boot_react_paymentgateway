package thi.backend.ecomerce.service;

import thi.backend.ecomerce.exception.UserException;
import thi.backend.ecomerce.model.User;

public interface UserService {
    public User findUserById(Long userId) throws UserException;

    public User findUserProfileByJwt(String jwt) throws UserException;
}
