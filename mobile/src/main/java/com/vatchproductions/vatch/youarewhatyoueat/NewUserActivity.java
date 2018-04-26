package com.vatchproductions.vatch.youarewhatyoueat;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewUserActivity extends AppCompatActivity {
    DatabaseHelper userDB;
    EditText editFirstName, editLastName, editSex, editAge, editCity, editPostcode;
    Button btnAdd;
    Button btnViewAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        userDB = new DatabaseHelper(this);
        editFirstName = findViewById(R.id.editFirstName_name);
        editLastName = findViewById(R.id.editLastName_name);
        editSex = findViewById(R.id.editSex_name);
        editAge = findViewById(R.id.editAge_name);
        editCity = findViewById(R.id.editCity_name);
        editPostcode = findViewById(R.id.editPostcode_name);
        btnAdd = findViewById(R.id.btnAdd);
        btnViewAll = findViewById(R.id.btnViewAll);

        AddData();
        ViewAll();
    }
    public void AddData() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = userDB.insertData(editFirstName.getText().toString(), editLastName.getText().toString(), editSex.getText().toString(), editAge.getText().toString(), editCity.getText().toString(), editPostcode.getText().toString());
                if (isInserted = true) {
                    Toast.makeText(NewUserActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(NewUserActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void ViewAll() {
        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = userDB.getAllData();
                if (res.getCount() == 0) {
                    showMessage("Error", "Nothing found...");
                    return;
                }
                StringBuilder buffer = new StringBuilder();
                while (res.moveToNext()) {
                    buffer.append("ID: ").append(res.getString(0)).append("\n");
                    buffer.append("Name: ").append(res.getString(1)).append("\n");
                    buffer.append("Surname: ").append(res.getString(2)).append("\n");
                    buffer.append("Sex: ").append(res.getString(3)).append("\n");
                    buffer.append("Age: ").append(res.getString(4)).append("\n");
                    buffer.append("City: ").append(res.getString(5)).append("\n");
                    buffer.append("Postcode: ").append(res.getString(6)).append("\n");
                }
                showMessage("Data", buffer.toString());
            }
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}