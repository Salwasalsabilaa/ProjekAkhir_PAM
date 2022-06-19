package com.example.projekakhir_pam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button bStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bStart=findViewById(R.id.btnstart);
        bStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent it = new Intent(getApplicationContext(), Login.class);
                startActivity(it);
            }
        });
    }
}