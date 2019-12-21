package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    TextView textView;

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        System.out.println("onRestoreInstanceState"+savedInstanceState);
        count=savedInstanceState.getInt("data");
        textView.setText(String.valueOf(count));
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println("onSaveInstanceState"+count);
        outState.putInt("data",count);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("onCreate"+savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                textView.setText(String.valueOf(count));

                Intent in = new Intent(MainActivity.this,newAc.class);
                in.putExtra("data",new String[]{
                        "ooo",
                        "mmm",
                        "hhh"
                });
                startActivity(in);

            }
        });
    }

}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        String[] st=getIntent().getStringArrayExtra("data");


        LinearLayout layout=findViewById(R.id.p);

        for (String s : st) {
            TextView textView = new TextView(this);
            textView.setText(s);
            layout.addView(textView);
        }

    }

}
