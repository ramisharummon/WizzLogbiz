package com.example.logwizzinc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.logwizzinc.R;

public class profileActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextPhoneNumber, editTextClass;
    ImageView profilePicture;
    Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhoneNumber = findViewById(R.id.editTextphone);
        editTextClass = findViewById(R.id.editTextclass);
        profilePicture = findViewById(R.id.profile_picture);


        buttonSave = findViewById(R.id.buttonSave);


        buttonSave.setOnClickListener(v -> {

        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String phoneNumber = editTextPhoneNumber.getText().toString();
        String classValue = editTextClass.getText().toString();
        if (name.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || classValue.isEmpty()) {

        Toast.makeText(profileActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
        } else {

        String profileInfo = "Name: " + name + "\nEmail: " + email + "\nPhone Number: " + phoneNumber + "\nClass: " + classValue;
        Toast.makeText(profileActivity.this, "Profile information saved:\n" + profileInfo, Toast.LENGTH_LONG).show();
        }
        });
        }
        }