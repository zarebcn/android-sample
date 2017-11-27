package com.zarebcn.simpleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EnterTextActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_text);

        initView();
    }

    private void initView() {

        EditText input = findViewById(R.id.input);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            String text = input.getText().toString();

            Intent data = new Intent();
            data.putExtra(EXTRA_TEXT, text);

            setResult(RESULT_OK, data);

            finish();
        });
    }
}
