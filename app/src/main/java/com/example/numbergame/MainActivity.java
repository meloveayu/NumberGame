package com.example.numbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mNumOneButton;
    private Button mNumTwoButton;
    private TextView mPointText;
    public static int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumOneButton = (Button) findViewById(R.id.num_1);
        mNumOneButton.setText(String.valueOf((int) (Math.random() * 100)));
        mNumTwoButton = (Button) findViewById(R.id.num_2);
        mNumTwoButton.setText(String.valueOf((int) (Math.random() * 100)));
        mPointText = (TextView) findViewById(R.id.text_1);
        mPointText.setText("Your point:"+String.valueOf(num));
        mNumOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( Integer.parseInt(mNumOneButton.getText().toString()) >= Integer.parseInt(mNumTwoButton.getText().toString())){
                    Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                    mPointText.setText("Your point:"+String.valueOf(++num));
                }
                else {
                    Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                    mPointText.setText("Your point:"+String.valueOf(--num));
                }
                mNumOneButton.setText(String.valueOf((int) (Math.random() * 100)));
                mNumTwoButton.setText(String.valueOf((int) (Math.random() * 100)));
            }
        });
        mNumTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(mNumOneButton.getText().toString()) <= Integer.parseInt(mNumTwoButton.getText().toString())){
                    Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                    mPointText.setText("Your point:"+String.valueOf(++num));
                }
                else {
                    Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                    mPointText.setText("Your point:"+String.valueOf(--num));
                }
                mNumOneButton.setText(String.valueOf((int) (Math.random() * 100)));
                mNumTwoButton.setText(String.valueOf((int) (Math.random() * 100)));
            }
        });
    }
}
