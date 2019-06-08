package com.codingblocks.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etVar1 = findViewById(R.id.etVar1);
        final EditText etVar2 = findViewById(R.id.etVar2);
        Button button = findViewById(R.id.button);
        final TextView textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.valueOf(etVar1.getText().toString());
                int b = Integer.valueOf(etVar2.getText().toString());

                int c = a + b;

                textView.setText(String.valueOf(c));
            }
        });



    }
}
