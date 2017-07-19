package com.sapuglha.espressotips;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HelloActivity extends AppCompatActivity {

    @BindView(R.id.hello_activity_text_name)
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (null != bundle) {
            String param = (String) bundle.get("name");
            name.setText(param);
        }
    }
}