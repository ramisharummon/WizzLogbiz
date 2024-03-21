package com.example.logwizzinc;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.logwizzinc.R;

public class profileActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextPhoneNumber, editTextClass,editTextInstitution,editTextAddress;
    ImageView profilePicture;
    Button buttonSave;
    AutoCompleteTextView Gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhoneNumber = findViewById(R.id.editTextPhone);
        editTextClass = findViewById(R.id.editTextclass);
        profilePicture = findViewById(R.id.profile_picture);
        editTextInstitution = findViewById(R.id.editTextInstitution);
        editTextAddress = findViewById(R.id.editTextAddress);
        buttonSave = findViewById(R.id.buttonSave);

        String[] Gender = {"Male","female"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,Gender);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.Gender);
         autoCompleteTextView.setAdapter(adapter);


        buttonSave.setOnClickListener(v -> {

        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String phoneNumber = editTextPhoneNumber.getText().toString();
        String classValue = editTextClass.getText().toString();
        String institution  = editTextInstitution.getText().toString();
        String address = editTextAddress.getText().toString();
            String gender = autoCompleteTextView.getText().toString();

        if (name.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || classValue.isEmpty() ||  gender.isEmpty()|| institution.isEmpty()|| address.isEmpty()) {

        Toast.makeText(profileActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
        } else {

        String profileInfo = "Name: " + name + "\nEmail: " + email + "\nPhone Number: " + phoneNumber + "\nClass: " + classValue +"\nGender: " + gender +"\nInstitution: " + institution + "\naddress: " +address;
        Toast.makeText(profileActivity.this, "Profile information saved:\n" + profileInfo, Toast.LENGTH_LONG).show();
        }
        });
        }
        }