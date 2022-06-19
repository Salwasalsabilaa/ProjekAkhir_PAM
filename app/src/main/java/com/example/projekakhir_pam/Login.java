package com.example.projekakhir_pam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText logNama, logPass;
    Button ButtonLog;
    TextView Regis;
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logNama=findViewById(R.id.lognama);
        logPass=findViewById(R.id.logpass);
        ButtonLog=findViewById(R.id.btnlog);
        Regis=findViewById(R.id.TextRegiss);

        Regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent it = new Intent(getApplicationContext(), register.class);
                startActivity(it);
            }
        });

        ButtonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nama = logNama.getText().toString();
                password = logPass.getText().toString();

                String name = "salwa";
                String pass = "123";

                if (nama.isEmpty() && password.isEmpty()){
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan  password wajib diisi!",
                            Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    if (nama.equals(name) && password.equals(pass)){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Berhasil",
                                Toast.LENGTH_LONG);

                        t.show();
                        Bundle b = new Bundle();
                        b.putString("a", nama.trim());
                        Intent i = new Intent(getApplicationContext(), Home.class);
                        i.putExtras(b);
                        startActivity(i);
                    }
                    else{
                        Toast t = Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_LONG);
                        t.show();
                    }
                }

            }
        });
    }
}