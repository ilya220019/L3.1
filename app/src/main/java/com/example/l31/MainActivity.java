package com.example.l31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText address;
        EditText subject;
        EditText emailtext;
        Button send;
            address = findViewById(R.id.et_gmail);
            subject = findViewById(R.id.et_theme);
            emailtext = findViewById(R.id.et_text);
            send = findViewById(R.id.btn_send);
            send.setOnClickListener(view -> {


                        String to = address.getText().toString();
                        String subject1 = subject.getText().toString();
                        String message = emailtext.getText().toString();

                        Intent email = new Intent(Intent.ACTION_SEND);
                        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                        email.putExtra(Intent.EXTRA_SUBJECT, subject1);
                        email.putExtra(Intent.EXTRA_TEXT, message);

                        //для того чтобы запросить email клиент устанавливаем тип
                        email.setType("message/rfc822");

                        startActivity(Intent.createChooser(email, "Выберите email клиент :"));

                    });
    }}

