package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import org.json.JSONObject;
import org.json.JSONException;

public class PostLoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_login);

        Intent intent = getIntent();
        String userInformation = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        try {
            JSONObject jsonObject = new JSONObject(userInformation);
            String username = jsonObject.getString("username");
            String email = jsonObject.getString("email");

            TextView usernameTextView = findViewById(R.id.usernameTextView);
            TextView emailTextView = findViewById(R.id.emailTextView);

            usernameTextView.setText(username);
            emailTextView.setText(email);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}