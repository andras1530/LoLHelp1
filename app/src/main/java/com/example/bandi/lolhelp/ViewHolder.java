package com.example.bandi.lolhelp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public ViewHolder(View itemView) {
        super(itemView);

        mView = itemView;

        // item Click

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        });
        //item Long click
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListener.onItemLongClick(view,getAdapterPosition());
                return true;
            }
        });
    }

    public void setDetails(Context ctx,String title,String description,String image,String firstrune,String firstsp1,String firstsp2,String firstsp3,String firstsp4,String secondrune,String secondsp1,String secondsp2,String phonenumber){

        TextView mTitleTv = mView.findViewById(R.id.rTitleTv);
        TextView mDetailTv = mView.findViewById(R.id.rDescription);
        TextView mFirstrTv = mView.findViewById(R.id.rfirstruneTv);
        TextView mFirstsp1Tv = mView.findViewById(R.id.rfirstsp1Tv);
        TextView mFirstsp2Tv = mView.findViewById(R.id.rfirstsp2Tv);
        TextView mFirstsp3Tv = mView.findViewById(R.id.rfirstsp3Tv);
        TextView mFirstsp4Tv = mView.findViewById(R.id.rfirstsp4Tv);
        TextView mSecondrTv = mView.findViewById(R.id.rsecondruneTv);
        TextView mSecondsp1Tv = mView.findViewById(R.id.rssp1Tv);
        TextView mSecondsp2Tv = mView.findViewById(R.id.rssp2Tv);
        ImageView mImageTv = mView.findViewById(R.id.rImageView);
        TextView mphonenumber = mView.findViewById(R.id.EditorTv);

        //set Data to Views
        mTitleTv.setText(title);
        mDetailTv.setText(description);
        mFirstrTv.setText(firstrune);
        mFirstsp1Tv.setText(firstsp1);
        mFirstsp2Tv.setText(firstsp2);
        mFirstsp3Tv.setText(firstsp3);
        mFirstsp4Tv.setText(firstsp4);
        mSecondrTv.setText(secondrune);
        mSecondsp1Tv.setText(secondsp1);
        mSecondsp2Tv.setText(secondsp2);
        Picasso.get().load(image).into(mImageTv);
        mphonenumber.setText(phonenumber);
    }

    private ViewHolder.ClickListener mClickListener;

    //interface to callBack

    public interface ClickListener{
        void onItemClick (View view,int position);
        void onItemLongClick(View view,int position);
    }

    public void setOnClickListener(ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }

}
