package com.feicuiedu.hybridappdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.feicuiedu.hybridappdemo.case1.Case1Activity;
import com.feicuiedu.hybridappdemo.case2.Case2Activity;
import com.feicuiedu.hybridappdemo.case3.Case3Activity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_case1)
    public void case1() {
        Intent intent = new Intent(this, Case1Activity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_case2)
    public void case2() {
        Intent intent = new Intent(this, Case2Activity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_case3)
    public void case3() {
        Intent intent = new Intent(this, Case3Activity.class);
        startActivity(intent);
    }
}
