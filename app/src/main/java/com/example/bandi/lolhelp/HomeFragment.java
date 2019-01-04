package com.example.bandi.lolhelp;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;

public class HomeFragment extends Fragment {

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return inflater.inflate(R.layout.fragment_home, container, false);
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        //ActionBar
        //ActionBar actionBar = getSupportActionBar();
        //setTitle
        //actionBar.setTitle("Post");

        //RecyclerView
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);


        // LinearLayout-ra Alitas

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        //send Query to firebase

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Data");

        return view;
    }

    // load data into RecyvlerView onstart

/*
    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Model,ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(
                        Model.class,
                        R.layout.row,
                        ViewHolder.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {

                        viewHolder.setDetails(getActivity(),model.getTitle(),model.getDescription(),model.getImage());

                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }*/
@Override
public void onStart() {
    super.onStart();
    FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter =
            new FirebaseRecyclerAdapter<Model, ViewHolder>(
                    Model.class,
                    R.layout.row,
                    ViewHolder.class,
                    mRef
            ) {
                @Override
                protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {

                    viewHolder.setDetails(getActivity(), model.getTitle(), model.getDescription(), model.getImage(),model.getFirstrune(),model.getFirstsp1(),model.getFirstsp2(),model.getFirstsp3(),model.getFirstsp4(),model.getSecondrune(),model.getSecondsp1(),model.getSecondsp2(),model.getPhonenumber());

                }


                @Override
                public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                    ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);

                    viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            //Views
                            TextView mTitleTv = view.findViewById(R.id.rTitleTv);
                            TextView mDescTv = view.findViewById(R.id.rDescription);
                            TextView mFirstrTv = view.findViewById(R.id.rfirstruneTv);
                            TextView mFirstsp1Tv = view.findViewById(R.id.rfirstsp1Tv);
                            TextView mFirstsp2Tv = view.findViewById(R.id.rfirstsp2Tv);
                            TextView mFirstsp3Tv = view.findViewById(R.id.rfirstsp3Tv);
                            TextView mFirstsp4Tv = view.findViewById(R.id.rfirstsp4Tv);
                            TextView mSecondrTv = view.findViewById(R.id.rsecondruneTv);
                            TextView mSecondsp1Tv = view.findViewById(R.id.rssp1Tv);
                            TextView mSecondsp2Tv = view.findViewById(R.id.rssp2Tv);
                            ImageView mImageView = view.findViewById(R.id.rImageView);
                            TextView mphonenumber = view.findViewById(R.id.EditorTv);

                            //get data from views
                            String mTitle = mTitleTv.getText().toString();
                            String mDesc = mDescTv.getText().toString();
                            String mFirstr = mFirstrTv.getText().toString();
                            String mFirstsp1 = mFirstsp1Tv.getText().toString();
                            String mFirstsp2 = mFirstsp2Tv.getText().toString();
                            String mFirstsp3 = mFirstsp3Tv.getText().toString();
                            String mFirstsp4 = mFirstsp4Tv.getText().toString();
                            String mSecondr = mSecondrTv.getText().toString();
                            String mSecondsp1 = mSecondsp1Tv.getText().toString();
                            String mSecondsp2 = mSecondsp2Tv.getText().toString();
                            String mphn = mphonenumber.getText().toString();
                            Drawable mDrawable = mImageView.getDrawable();
                            Bitmap mBitmap = ((BitmapDrawable) mDrawable).getBitmap();


                            //pass this data to new Activity
                            Intent intent = new Intent(view.getContext(), PostDetailActivity.class);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                            byte[] bytes = stream.toByteArray();
                            //put bitmap image as arrayl of bytes
                            intent.putExtra("image", bytes);
                            //put title
                            intent.putExtra("title", mTitle);
                            //put description
                            intent.putExtra("description", mDesc);

                            intent.putExtra("firstrune ", mFirstr);

                            intent.putExtra("firstsp1", mFirstsp1);

                            intent.putExtra("firstsp2", mFirstsp2);

                            intent.putExtra("firstsp3", mFirstsp3);

                            intent.putExtra("firstsp4", mFirstsp4);

                            intent.putExtra("secondrune", mSecondr);

                            intent.putExtra("secondsp1", mSecondsp1);

                            intent.putExtra("secondsp2", mSecondsp2);

                            intent.putExtra("phonenumber", mphn);





                            startActivity(intent);//Start activity

                        }

                        @Override
                        public void onItemLongClick(View view, int position) {

                        }
                    });

                    return viewHolder;
                }



            };
    mRecyclerView.setAdapter(firebaseRecyclerAdapter);

}
}
