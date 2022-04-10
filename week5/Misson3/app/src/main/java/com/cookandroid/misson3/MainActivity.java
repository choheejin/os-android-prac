package com.cookandroid.misson3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextPersonName2);
        textView = findViewById(R.id.textView3);

        Button sendButton = findViewById(R.id.button3);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editText.getText().toString();
                Toast.makeText(getApplicationContext(),"메세지\n\n"+message,Toast.LENGTH_LONG).show();
            }
        });
        Button closeButton = findViewById(R.id.button4);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                byte[] bytes = null;
                try {
                    bytes = charSequence.toString().getBytes("KSC5601");
                    int strCount = bytes.length;
                    textView.setText(strCount + " / 80바이트");
                } catch(UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String str = editable.toString();
                try {
                    byte[] strBytes = str.getBytes("KSC5601");
                    if(strBytes.length > 80) {
                        editable.delete(editable.length()-2, editable.length()-1);
                    }
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        editText.addTextChangedListener(textWatcher);
    }
}
