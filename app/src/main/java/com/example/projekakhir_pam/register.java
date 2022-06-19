package com.example.projekakhir_pam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class register extends AppCompatActivity {

    EditText edtNama, edtEmail, edtPassword, edtrepass;
    TextView log;
    Button reg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtNama =findViewById(R.id.editNama);
        edtEmail =findViewById(R.id.editEmail);
        edtPassword =findViewById(R.id.editPass);
        edtrepass =findViewById(R.id.editRepass);
        reg =findViewById(R.id.btnreg);
        log =findViewById(R.id.textlogin);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent it = new Intent(getApplicationContext(), Login.class);
                startActivity(it);
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //membuat kondisi untuk mengecek EditText wajib diisi
                if (edtNama.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty() ||
                        edtrepass.getText().toString().isEmpty())
                {
                    //Menampilkan pesan notifikasi jika seluruh EditText wajib diisi
                    Snackbar.make(view, "ISI SEMUA DATA", Snackbar.LENGTH_LONG).show();
                }
                else
                {

                    if (edtPassword.getText().toString().equals(edtrepass.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil",
                                Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(getApplicationContext(), Login.class);
                        startActivity(i);
                    }
                    else
                    {
                        Snackbar.make(view, "Password dan Repassword harus sama",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}