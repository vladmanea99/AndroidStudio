package com.example.lab8;

import java.util.List;

public interface OnGetUsersCallback {

    void onSuccess(List<User> users);

    void onError();
}
