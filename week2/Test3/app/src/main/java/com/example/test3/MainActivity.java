package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn1, btn2;
    RadioGroup rdg;
    RadioButton rdbtn1, rdbtn2;
    ImageView image1,image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        rdg = (RadioGroup) findViewById(R.id.radg);
        rdbtn1 = (RadioButton) findViewById(R.id.rdbtn1);
        rdbtn2 = (RadioButton) findViewById(R.id.rdbtn2);
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);


        editText.getText();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "안녕하세요? 2020039021 조희진입니다.", Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(editText.getText().toString()));
                startActivity(mIntent);
            }
        });


        rdg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rdbtn1.isChecked() == true) {
                    image1.setVisibility(View.VISIBLE);
                    image2.setVisibility(View.INVISIBLE);
                } else if (rdbtn2.isChecked() == true) {
                    image1.setVisibility(View.INVISIBLE);
                    image2.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}