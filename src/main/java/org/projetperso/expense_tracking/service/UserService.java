package org.projetperso.expense_tracking.service;

import org.projetperso.expense_tracking.model.User;

public interface UserService {
    void registerUser(String username, String email, String password) throws Exception;
    boolean validateUser(String email, String password);
    User getUserById(Long userId) throws Exception;
    void deleteUser(Long userId) throws Exception;
}
