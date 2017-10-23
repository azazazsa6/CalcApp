package jp.azusatechacademy.sugimoto.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    double result;
    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v) {
        try{
            String text1 = mEditText1.getText().toString();

        double value1 = Double.parseDouble(text1);
        String text2 = mEditText2.getText().toString();
        double value2 = Double.parseDouble(text2);
        if (v.getId() == R.id.button1) {
            result = value1 + value2;
        } else if (v.getId() == R.id.button2) {
            result = value1 - value2;
        } else if (v.getId() == R.id.button3) {
            result = value1 * value2;
        } else if (v.getId() == R.id.button4) {
            if (value2 == 0) {
                Toast.makeText(this, "数値を入力してください。", Toast.LENGTH_LONG).show();
                return;
            }
            result = value1 / value2;
        }
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
        }catch (Exception e) {
            Toast.makeText(this, "数値を入力してください。", Toast.LENGTH_LONG).show();
        }
    }
}
