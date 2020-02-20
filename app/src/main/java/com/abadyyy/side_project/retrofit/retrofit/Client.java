package com.abadyyy.side_project.retrofit.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    public static GitHubService getService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        return service;
    }
}
