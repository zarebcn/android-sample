package com.zarebcn.simpleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> lines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lines = new ArrayList<>();

        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        TextView text = findViewById(R.id.text);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> {

            Intent intent = new Intent(this, EnterTextActivity.class);

            startActivityForResult(intent, 1);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {

            String text = data.getStringExtra(EnterTextActivity.EXTRA_TEXT);
            lines.add(text);

            TextView textView = findViewById(R.id.text);
            textView.setText(lines.toString());
        }
    }
}
