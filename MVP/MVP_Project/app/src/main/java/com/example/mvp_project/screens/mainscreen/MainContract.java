package com.example.mvp_project.screens.mainscreen;

public interface MainContract {
    interface MainView {
        void showMessage(String message);
    }

    interface MainPresenter {
        void login(String username);
    }
}
