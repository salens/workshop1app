package com.company.stanislavsencanski.workshopapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.company.stanislavsencanski.workshopapp.activity.NewUserActivity;
import com.company.stanislavsencanski.workshopapp.adapter.UserAdapter;
import com.company.stanislavsencanski.workshopapp.dao.mock.UserDao;
import com.company.stanislavsencanski.workshopapp.model.User;
import com.company.stanislavsencanski.workshopapp.protocol.UserSelectedListener;

public class MainActivity extends AppCompatActivity implements UserSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        final UserAdapter userAdapter = new UserAdapter(this, UserDao.fetchUsers(),this);
        recyclerView.setAdapter(userAdapter);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent (MainActivity.this, NewUserActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void userSelected(User user) {

    }
}
