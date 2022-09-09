package com.codegym.task.task36.task3608.model;

import com.codegym.task.task36.task3608.bean.User;

import java.util.Arrays;

public class FakeModel implements Model {

    private final DataModel dataModel = new DataModel();

    @Override
    public DataModel getDataModel() {
        return dataModel;
    }

    @Override
    public void loadUsers() {
        dataModel.setUsers(Arrays.asList(new User("Ashton", 1, 1), new User("Bella", 2, 2)));
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }

}
