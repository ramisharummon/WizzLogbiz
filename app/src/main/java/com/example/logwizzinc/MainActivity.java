package com.example.logwizzinc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox;

    Button button;
    AutoCompleteTextView bloodgroup;

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

        String[] bloodgroup = {"A+", "A-", "B+", "B-", "AB+", "AB+", "AB-", "O+", "O-"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, bloodgroup);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.bloodgroup);
        autoCompleteTextView.setAdapter(adapter);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b == true) {
                    button.setVisibility(View.VISIBLE);
                } else {
                    button.setVisibility(View.INVISIBLE);
                }

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Sign Up Done", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, profileActivity.class);
                startActivity(intent);
            }
        });



        return insets;


    }
}

