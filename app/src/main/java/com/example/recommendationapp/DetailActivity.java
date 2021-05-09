package com.example.recommendationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private TextView tvUsername100;
    private TextView tvDescription100;
    private  TextView tvCategory100 ;
    private ImageView ivImage100;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvUsername100 = findViewById(R.id.tvUsername100);
        tvDescription100 = findViewById(R.id.tvDescription100);
        tvCategory100 = findViewById(R.id.tvCategory100);


        String username = getIntent().getStringExtra("username");
        String description = getIntent().getStringExtra("Description");
        String category = getIntent().getStringExtra("Category");
        //ParseFile image = getIntent().getStringExtra("Image");
        ParseFile image = getIntent().getParcelableExtra("Image");


        tvUsername100.setText(username);
        tvDescription100.setText(description);
        tvCategory100.setText(category);

    }
}