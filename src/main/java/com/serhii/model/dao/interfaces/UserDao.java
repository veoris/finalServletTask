package com.serhii.model.dao.interfaces;

import com.serhii.model.dto.userdto.LoginUserDTO;
import com.serhii.model.entity.Role;
import com.serhii.model.entity.User;

import java.util.Set;

public interface UserDao extends CRUDDao<User> {
    User findUserByLoginAndPassword(LoginUserDTO user);

    Set<Role> findUserRolesByID(int id);
}
