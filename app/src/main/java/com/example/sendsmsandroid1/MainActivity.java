package com.example.sendsmsandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mToEmile;
    private EditText mSubject;
    private EditText mEdiTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToEmile = findViewById(R.id.emile_text);
        mSubject = findViewById(R.id.name_part);
        mEdiTextMessage = findViewById(R.id.name_text);
        Button buttonSend = findViewById(R.id.btn_send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });

    }

    private void sendMail() {
        String resultList = mToEmile.getText().toString();
        String[] recipients = resultList.split(",");

        String part =mSubject.getText().toString();
        String massage=mEdiTextMessage.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,part);
        intent.putExtra(Intent.EXTRA_TEXT,massage);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose here emile"));


    }
}