package com.abadyyy.side_project.retrofit;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.abadyyy.side_project.retrofit.retrofit.Client;
import com.abadyyy.side_project.retrofit.retrofit.GitHubService;
import com.abadyyy.side_project.retrofit.retrofit.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GitHubService service = Client.getService();

        final Call<List<Repo>> repos = service.listRepos("octocat");
        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if (response.isSuccessful())
                    Log.i("Response is Success", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.e("Response is Success", t.toString());
            }
        });

    }


}
