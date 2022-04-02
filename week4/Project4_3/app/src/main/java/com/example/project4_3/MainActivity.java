package com.example.project4_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit1,edit2;
    Button btnAdd,btnMin,btnMul,btnDiv;
    String num1,num2;
    TextView res;
    Integer textres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기 (수정)");
        edit1=(EditText)findViewById(R.id.edit1);
        edit2=(EditText)findViewById(R.id.edit2);
        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnMin=(Button)findViewById(R.id.btnMin);
        btnMul=(Button)findViewById(R.id.btnMul);
        btnDiv=(Button)findViewById(R.id.btnDiv);
        res=(TextView)findViewById(R.id.TextRes);
        View.OnClickListener Listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId())
                {
                    case R.id.btnAdd:
                        num1=edit1.getText().toString();
                        num2=edit2.getText().toString();
                        textres=Integer.parseInt(num1)+Integer.parseInt(num2);
                        res.setText("계산결과:"+textres);
                        break;
                    case R.id.btnMin:
                        num1=edit1.getText().toString();
                        num2=edit2.getText().toString();
                        textres=Integer.parseInt(num1)-Integer.parseInt(num2);
                        res.setText("계산결과:"+textres);
                        break;
                    case R.id.btnMul:
                        num1=edit1.getText().toString();
                        num2=edit2.getText().toString();
                        textres=Integer.parseInt(num1)*Integer.parseInt(num2);
                        res.setText("계산결과:"+textres);
                        break;
                    case R.id.btnDiv:
                        num1=edit1.getText().toString();
                        num2=edit2.getText().toString();
                        textres=Integer.parseInt(num1)/Integer.parseInt(num2);
                        res.setText("계산결과:"+textres);
                        break;
                }
            }
        };
        btnAdd.setOnClickListener(Listener);
        btnMin.setOnClickListener(Listener);
        btnMul.setOnClickListener(Listener);
        btnDiv.setOnClickListener(Listener);
    }
}
