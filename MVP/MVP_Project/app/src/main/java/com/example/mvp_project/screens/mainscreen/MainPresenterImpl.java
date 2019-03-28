package com.example.mvp_project.screens.mainscreen;

public class MainPresenterImpl implements MainContract.MainPresenter {

    MainContract.MainView activity;

    public MainPresenterImpl(MainContract.MainView activity){
        this.activity = activity;
    }

    @Override
    public void login(String username) {
        activity.showMessage("Hi "+username);
    }
}
