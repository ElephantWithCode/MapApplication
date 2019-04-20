package com.example.team.mapapplication.business.show_image;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.team.mapapplication.R;

public class ShowImageActivity extends AppCompatActivity {

    private ImageView mShowImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);


        Intent extraIntent = getIntent();
        mShowImageView = findViewById(R.id.act_si_iv);
    }
}
