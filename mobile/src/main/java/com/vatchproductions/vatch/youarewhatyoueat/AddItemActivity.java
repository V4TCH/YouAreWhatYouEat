package com.vatchproductions.vatch.youarewhatyoueat;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseHelper databaseHelper;
    private User user;

    private final AppCompatActivity activity = AddItemActivity.this;

    private TextInputEditText textInputEditFoodItemName;
    private TextInputEditText textInputEditFoodType;
    private TextInputEditText textInputEditFoodCalCount;
    private TextInputEditText textInputEditFoodWeight;
    private AppCompatButton appCompatButtonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();
    }

    private void initViews() {

        textInputEditFoodItemName = findViewById(R.id.textInputEditFoodItemName);
        textInputEditFoodType = findViewById(R.id.textInputEditFoodType);
        textInputEditFoodCalCount = findViewById(R.id.textInputEditFoodCalCount);
        textInputEditFoodWeight = findViewById(R.id.textInputEditFoodWeight);

        appCompatButtonAdd = findViewById(R.id.appCompatButtonAdd);
    }
    private void initListeners() {
        appCompatButtonAdd.setOnClickListener(this);
    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        user = new User();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appCompatButtonAdd:
                postDataToSQLite();
                break;
        }
    }

    private void postDataToSQLite() {

        user.setFoodName(textInputEditFoodItemName.getText().toString().trim());
        user.setFoodType(textInputEditFoodType.getText().toString().trim());
        user.setFoodCalCount(textInputEditFoodCalCount.getText().toString().trim());
        user.setFoodWeight(textInputEditFoodWeight.getText().toString().trim());

        databaseHelper.updateUser(user);

        Toast.makeText(getApplicationContext(), "Added to Account!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(AddItemActivity.this, UsersListActivity.class));
    }
}
