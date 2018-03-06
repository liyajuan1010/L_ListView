package com.example.dell.l_listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.SimpleAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSimpleAdapter,btnBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBaseAdapter=(Button)findViewById(R.id.btn_base_adapter);
        btnSimpleAdapter=(Button)findViewById(R.id.btn_simple_adapter);
        btnSimpleAdapter.setOnClickListener(this);
        btnBaseAdapter.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_base_adapter:
                startActivity(new Intent(MainActivity.this, BaseAdapterActivity.class));
                break;
            case R.id.btn_simple_adapter:
                startActivity(new Intent(MainActivity.this, SimpleAdapterActivity.class));
                break;
        }
    }
}
