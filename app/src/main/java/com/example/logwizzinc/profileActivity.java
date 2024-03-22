package com.example.logwizzinc;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class profileActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextPhoneNumber,editTextDOB, editTextClass,editTextInstitution,editTextAddress;
    ImageView profilePicture;
    Button buttonSave;

    AutoCompleteTextView Gender;
    AutoCompleteTextView Bloodgroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhoneNumber = findViewById(R.id.editTextPhone);
        editTextDOB = findViewById(R.id.editTextDOB);
        editTextClass = findViewById(R.id.editTextclass);
        profilePicture = findViewById(R.id.profile_picture);
        editTextInstitution = findViewById(R.id.editTextInstitution);
        editTextAddress = findViewById(R.id.editTextAddress);
        buttonSave = findViewById(R.id.buttonSave);

        String[] Gender = {"Male","female"};
        String[] Bloodgroup = {"A+", "A-", "B+", "B-", "AB+", "AB+", "AB-", "O+", "O-"};

        ArrayAdapter<String> genderadapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,Gender);
        AutoCompleteTextView genderautoCompleteTextView = findViewById(R.id.Gender);
         genderautoCompleteTextView.setAdapter(genderadapter);


        ArrayAdapter<String> bloodgroupadapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, Bloodgroup);
        AutoCompleteTextView bloodgroupautoCompleteTextView = findViewById(R.id.Bloodgroup);
        bloodgroupautoCompleteTextView.setAdapter(bloodgroupadapter);

        editTextDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        // Set the range of years for the date picker
        int minYear = 1900; // Change this according to your requirements
        int maxYear = 2100; // Change this according to your requirements

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                profileActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String dob = dayOfMonth + "/" + (month + 1) + "/" + year;
                        editTextDOB.setText(dob);
                    }
                },
                year, month, dayOfMonth
        );
        datePickerDialog.getDatePicker().setMinDate(getTimeInMillis(minYear, 0, 1));
        datePickerDialog.getDatePicker().setMaxDate(getTimeInMillis(maxYear, 11, 31));

        datePickerDialog.show();
    }

    // Utility method to convert date to milliseconds
    private long getTimeInMillis(int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);
        return calendar.getTimeInMillis();
    }
    private boolean areAllFieldsFilled() {

        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String phoneNumber = editTextPhoneNumber.getText().toString();
        String dob = editTextDOB.getText().toString();
        String classValue = editTextClass.getText().toString();
        String institution = editTextInstitution.getText().toString();
        String address = editTextAddress.getText().toString();
        String gender = Gender.getText().toString();
        String bloodgroup = Bloodgroup.getText().toString();


        if (name.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || dob.isEmpty() || classValue.isEmpty() || gender.isEmpty() || bloodgroup.isEmpty() || institution.isEmpty() || address.isEmpty()) {

            Toast.makeText(profileActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
    private void save() {
        Toast.makeText(profileActivity.this, "Save", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(profileActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}










