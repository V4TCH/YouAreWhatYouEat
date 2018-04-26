package com.vatchproductions.vatch.youarewhatyoueat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper userDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userDB = new DatabaseHelper(this);

        Button buttonNewUser = findViewById(R.id.btnCreateAccount);

        buttonNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewUserActivity.class));
            }
        });
    }

}
