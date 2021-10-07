package com.danicc.changesizetext;

import android.app.Application;

import com.danicc.changesizetext.model.User;

public class ChangeSizeApplication extends Application {
    private User user;
    @Override
    public void onCreate() {
        super.onCreate();
        user= new User("Dani","dcasadocarvajal@gmail.com");
    }

    public User getUser() {
        return user;
    }
}
