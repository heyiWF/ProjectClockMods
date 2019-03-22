package com.iwf.clockmodstest;

import android.app.Activity;
import android.content.Intent;
import android.hardware.input.InputManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mBtnNext;
    private EditText mEtColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtColor = findViewById(R.id.et_color);
        mBtnNext = findViewById(R.id.btn_next);

        setTouchListener(this);
/*        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FullscreenActivity.class);
                startActivity(intent);
            }
        });
*/    }

    private static void setTouchListener(final Activity context){
        context.getWindow().getDecorView().setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm= (InputMethodManager) context.getSystemService(context.INPUT_METHOD_SERVICE);
                if(context.getCurrentFocus()!=null){
                    imm.hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(),0);
                }
                else{
                    imm.hideSoftInputFromWindow(context.findViewById(android.R.id.content).getWindowToken(),0);
                }
                return false;
            }
        });
    }

}
