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
    private static int num = 0;
    private void randomSum(){
        mNumOneButton.setText(String.valueOf((int) (Math.random() * 100)));
        mNumTwoButton.setText(String.valueOf((int) (Math.random() * 100)));
    }
    private void toastShow(int n_1,int n_2){
        if( n_1 >= n_2){
            Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
            mPointText.setText(String.format(getResources().getString(R.string.point_text),++num));
        }
        else {
            Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
            mPointText.setText(String.format(getResources().getString(R.string.point_text),--num));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumOneButton = findViewById(R.id.num_1);
        mNumTwoButton = findViewById(R.id.num_2);
        mPointText = findViewById(R.id.text_1);
        mPointText.setText(String.format(getResources().getString(R.string.point_text),num));
        randomSum();
        mNumOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num_1 = Integer.parseInt(mNumOneButton.getText().toString());
                int num_2 = Integer.parseInt(mNumTwoButton.getText().toString());
                toastShow(num_1,num_2);
                randomSum();
            }
        });
        mNumTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num_1 = Integer.parseInt(mNumOneButton.getText().toString());
                int num_2 = Integer.parseInt(mNumTwoButton.getText().toString());
                toastShow(num_2,num_1);
                randomSum();
            }
        });
    }
}