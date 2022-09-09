package com.codegym.task.task36.task3608.model;

import com.codegym.task.task36.task3608.bean.User;
import com.codegym.task.task36.task3608.model.service.UserService;
import com.codegym.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {

    private final DataModel dataModel = new DataModel();
    private final UserService userService = new UserServiceImpl();

    private List<User> getAllUsers() {
        return userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1, 100));
    }

    @Override
    public DataModel getDataModel() {
        return dataModel;
    }

    @Override
    public void loadUsers() {
        dataModel.setUsers(getAllUsers());
        dataModel.setDisplayDeletedUserList(false);
    }

    @Override
    public void loadDeletedUsers() {
        dataModel.setUsers(userService.getAllDeletedUsers());
        dataModel.setDisplayDeletedUserList(true);
    }

    @Override
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        dataModel.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        userService.deleteUser(id);
        dataModel.setUsers(getAllUsers());
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name, id, level);
        dataModel.setUsers(getAllUsers());
    }

}
