package com.example.bandi.lolhelp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PostDetailActivity extends AppCompatActivity {

    TextView  mTitleTv,mDetailTv,mFirstrTv,mFirstsp1Tv,mFirstsp2Tv,mFirstsp3Tv,mFirstsp4Tv,mSecondrTv,mSecondsp1Tv,mSecondsp2Tv;
    ImageView mImageTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        //ActionBar
        ActionBar actionBar = getSupportActionBar();
        //Title
        actionBar.setTitle("Details");
        //set back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //intialize views
        mTitleTv = findViewById(R.id.titleTv);
        mDetailTv = findViewById(R.id.descriptionTv);
        mFirstrTv = findViewById(R.id.firstruneTv);
        mFirstsp1Tv = findViewById(R.id.firstsp1Tv);
        mFirstsp2Tv = findViewById(R.id.firstsp2Tv);
        mFirstsp3Tv = findViewById(R.id.firstsp3Tv);
        mFirstsp4Tv = findViewById(R.id.firstsp4Tv);
        mSecondrTv = findViewById(R.id.secondruneTv);
        mSecondsp1Tv = findViewById(R.id.ssp1Tv);
        mSecondsp2Tv = findViewById(R.id.ssp2Tv);
        mImageTv = findViewById(R.id.imageView);

        //get data from intent
        byte[] bytes = getIntent().getByteArrayExtra("image");
        String title = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("description");
        String firstrune = getIntent().getStringExtra("firstrune");
        String firstsp1 = getIntent().getStringExtra("firstsp1");
        String firstsp2 = getIntent().getStringExtra("firstsp2");
        String firstsp3 = getIntent().getStringExtra("firstsp3");
        String firstsp4 = getIntent().getStringExtra("firstsp4");
        String secondrune = getIntent().getStringExtra("secondrune");
        String secondsp1 = getIntent().getStringExtra("secondsp1");
        String secondsp2 = getIntent().getStringExtra("secondsp2");
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes,0,bytes.length);

        //set data to views
        mTitleTv.setText(title);
        mDetailTv.setText(desc);
        mFirstrTv.setText(firstrune);
        mFirstsp1Tv.setText(firstsp1);
        mFirstsp2Tv.setText(firstsp2);
        mFirstsp3Tv.setText(firstsp3);
        mFirstsp4Tv.setText(firstsp4);
        mSecondrTv.setText(secondrune);
        mSecondsp1Tv.setText(secondsp1);
        mSecondsp2Tv.setText(secondsp2);
        mImageTv.setImageBitmap(bmp);

    }

    // Handle onBackPressed(go to previos pagee)


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}