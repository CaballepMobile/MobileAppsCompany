package com.example.admin.week4daily1.presenter;

import com.example.admin.week4daily1.model.MyData;
import com.example.admin.week4daily1.model.User;
import com.example.admin.week4daily1.service.RepositoryService;
import com.example.admin.week4daily1.service.UserService;
import com.example.admin.week4daily1.view.RepositoryView;
import com.example.admin.week4daily1.view.UserView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter {

    private UserView userView;
    private UserService userService;

    private RepositoryView repositoryView;
    private RepositoryService repositoryService;

    public Presenter(UserView view) {
        this.userView = view;

        if (this.userService == null) {
            this.userService = new UserService();
        }
    }

    public Presenter(RepositoryView view) {
        this.repositoryView = view;

        if(this.repositoryService == null){
            this.repositoryService = new RepositoryService();
        }
    }

    public void getUser(String userName) {

        userService
                .getAPI()
                .getUser(userName)
                .enqueue(new Callback<MyData>() {
                    @Override
                    public void onResponse(Call<MyData> call, Response<MyData> response) {
                        MyData data = response.body();

                        if (data != null && data.getRestResponse() != null) {
                            User result = data.getRestResponse().getUserResult();
                            userView.userReady(result);
                        }
                    }


                    @Override
                    public void onFailure(Call<MyData> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                });
    }
}
