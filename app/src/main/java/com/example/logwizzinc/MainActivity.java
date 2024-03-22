package com.example.logwizzinc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editTextName, editTextEmail, editTextPhone, editTextPassword, editTextUsername;
    CheckBox checkBox;

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), this::onApplyWindowInsets);
    }

    private WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);


        checkBox = findViewById(R.id.checkboxID);

        button = findViewById(R.id.signbtn);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);


        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked && areAllFieldsFilled()) {
                button.setVisibility(View.VISIBLE);
            } else {
                button.setVisibility(View.GONE);
            }
        });
        button.setOnClickListener((View buttonView) -> signup());
        return insets;

    }

    private boolean areAllFieldsFilled() {
        String name = editTextPhone.getText().toString();
        String email = editTextEmail.getText().toString();
        String phone = editTextPhone.getText().toString();
        String password = editTextPassword.getText().toString();
        String username = editTextUsername.getText().toString();


        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || username.isEmpty()) {
            Toast.makeText(MainActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
    private void signup() {
        Toast.makeText(MainActivity.this, "Sign Up Done", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, profileActivity.class);
        startActivity(intent);
    }
}


