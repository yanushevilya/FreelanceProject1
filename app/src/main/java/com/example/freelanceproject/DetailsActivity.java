package com.example.freelanceproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static com.example.freelanceproject.NetworkUtils.getResponseFromURL;

public class DetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerViewUserRepos;
    private UserReposAdapter userReposAdapter;
    private ArrayList<UserRepos> userReposList = new ArrayList<UserRepos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        userReposList = MainActivity.getUserReposList();

        recyclerViewUserRepos = findViewById(R.id.rv_userRepos);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewUserRepos.setLayoutManager(layoutManager);

        recyclerViewUserRepos.setHasFixedSize(true);
        // помещаем наш List в адаптер для RecyclerView
        userReposAdapter = new UserReposAdapter(this, userReposList); //
        recyclerViewUserRepos.setAdapter(userReposAdapter);
    }

}