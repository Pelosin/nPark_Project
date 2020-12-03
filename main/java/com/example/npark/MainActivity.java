package com.example.npark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button mainregisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainregisterButton = (Button) findViewById(R.id.buttonRegistar);

        mainregisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register_win = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(register_win);
            }
        });



    }
}