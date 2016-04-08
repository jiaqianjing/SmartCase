package com.chi_a.jing.smartcase.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.chi_a.jing.smartcase.R;

public class IndexActivity extends ActionBarActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        intent = new Intent();
    }

    public void goLogin(View view) {
        intent.setClass(this,LoginActivity.class);
        startActivity(intent);
    }

    public void goRegist(View view) {
        intent.setClass(this,RegistActivity.class);
        startActivity(intent);
    }
}
