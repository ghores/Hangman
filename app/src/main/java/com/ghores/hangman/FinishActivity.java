package com.ghores.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FinishActivity extends AppCompatActivity {
    private TextView txt_result;
    private Button btn_exit;
    private Button btn_restart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        txt_result = findViewById(R.id.txt_result);
        btn_exit = findViewById(R.id.btn_exit);
        btn_restart = findViewById(R.id.btn_restart);

        String result = getIntent().getStringExtra("result");
        if (result !=null && result.equals("WON")) {
            txt_result.setText("You Won!");
        } else {
            txt_result.setText("Game Over!");
        }
        btn_exit.setOnClickListener(view -> finish());
        btn_restart.setOnClickListener(view -> {
            Intent intent = new Intent(FinishActivity.this, MainActivity.class);
            FinishActivity.this.startActivity(intent);
            finish();
        });
    }
}