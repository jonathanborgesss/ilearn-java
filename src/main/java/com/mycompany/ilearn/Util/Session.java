package com.mycompany.ilearn.Util;

import com.mycompany.ilearn.Model.UserModel;

public class Session {
    private static UserModel currentUser;

    public static void start(UserModel user) {
        currentUser = user;
    }

    public static UserModel getCurrentUser() {
        return currentUser;
    }

    public static void end() {
        currentUser = null;
    }

    public static boolean isLoggedIn() {
        return currentUser != null;
    }
}
