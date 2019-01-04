package com.example.bandi.lolhelp;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.UUID;

public class AccountFragment extends Fragment implements View.OnClickListener {


    public Button buttonLogout;
    TextView myTextView;
    TextView myTextView2;
    TextView myTextView3;
    ImageView myImageView;
    FirebaseDatabase database;
    DatabaseReference myRef;
    FirebaseAuth mAuth;
    String fname;
    String lsname;
    String phnumber;
    String image;
    String kep;
    private String phonenumber;
    private Button btnChoose, btnUpload;
    private ImageView imageView;

    private Uri filePath;

    private final int PICK_IMAGE_REQUEST = 71;

    //Firebase
    FirebaseStorage storage;
    StorageReference storageReference;

    //private String currentUserId;
    //private DatabaseReference profileUserRef;
    //private FirebaseAuth mAuth;


    public AccountFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container, false);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("users");
        Button btnlogout = (Button) view.findViewById(R.id.buttonLogout);
        myTextView = (TextView) view.findViewById(R.id.frname);
        myTextView2 = (TextView) view.findViewById(R.id.lstname);
        myTextView3 = (TextView) view.findViewById(R.id.phnumber);
        myImageView = (ImageView) view.findViewById(R.id.imgView) ;
        Button btnread = (Button) view.findViewById(R.id.btnread);

        // int phonenm = this.getArguments().getInt("phone_key");

        btnChoose = (Button) view.findViewById(R.id.btnChoose);
        btnUpload = (Button) view.findViewById(R.id.btnUpload);
        imageView = (ImageView) view.findViewById(R.id.imgView);

        SharedPreferences mSettings = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor = mSettings.edit();
        editor.apply();

        final String phnum = mSettings.getString("telefon", "ures");
        phonenumber = phnum;
        Log.d("masodik", "Profile telefonszam:" + phonenumber);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();


/*
        myRef = FirebaseDatabase.getInstance().getReference().child("firstname");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String fname = dataSnapshot.getValue().toString();

                myTextView.setText(fname);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
*/


        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference mchild = myRef.child(phonenumber);

                mchild.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        fname = dataSnapshot.child("firstname").getValue(String.class);
                        lsname = dataSnapshot.child("lastname").getValue(String.class);
                        phnumber = dataSnapshot.child("phonenumber").getValue(String.class);
                        image = dataSnapshot.child("image").getValue(String.class);
                        //fname = String.valueOf(dataSnapshot.child(phonenumber).getValue());
                        //String fname = ds.child("firstname").getValue(String.class);
                        //Log.d("referencia",);
                        //Toast.makeText(getActivity().getApplicationContext(), "ide megy", Toast.LENGTH_LONG).show();
                        Log.d("lastname", "megkapja az adatot " + lsname);
                        Log.d("telefonnn", "megkapja az adatot " + phnumber);
                        Log.d("IDEMEGY", "megkapja az adatot " + fname);
                        Log.d("kep","megkapja a kepet:" + image);
                        //System.out.println("You ight... Character Name is: " + fname);
                        myTextView.setText(fname);
                        myTextView2.setText(lsname);
                        myTextView3.setText(phnumber);
                        Picasso.get().load(image).into(imageView);

                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getActivity(), "hiba", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        //readFromDatabase();


        btnlogout.setOnClickListener(this);

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });


        return view;
    }


    /*
        public void readFromDatabase(){
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String fname = dataSnapshot.getValue(String.class);
                        Log.d("adat", "Value is" + fname);

                        myTextView.setText(fname);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

        }
        */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonLogout:
                Intent in = new Intent(getActivity(), LoginActivity.class);
                in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
                FirebaseAuth.getInstance().signOut();
                if (getActivity() != null) {
                    getActivity().finish();
                }
                break;
        }
    }

    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == getActivity().RESULT_OK
                && data != null && data.getData() != null) {
            filePath = data.getData();

            Picasso.get().load(filePath).into(imageView);
            /*
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getApplicationContext().getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
*/
        }
    }

    private String getFileExtension(Uri uri){
        ContentResolver cR = getActivity().getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }
    private void uploadImage(){
        if(filePath != null){
            final StorageReference fileReference = storageReference.child(System.currentTimeMillis() +
                    "." + getFileExtension(filePath));
            fileReference.putFile(filePath).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if(!task.isSuccessful()){
                        throw task.getException();
                    }
                    return fileReference.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if(task.isSuccessful()){
                        Uri downloadUri = task.getResult();
                        System.out.println("tag1 profile pic: \t" + downloadUri.toString());
                        System.out.println("tag2 profile pic: \t" + fname + lsname);
                        User user = new User(lsname,fname,phnumber,downloadUri.toString());
                        myRef.child(phnumber).setValue(user);


                        Picasso.get().load(downloadUri).into(imageView);
                        //kep = downloadUri.toString();
                        //Log.d("kepfeltoltes","a kepem linke" + kep.toString());
                        // User user = new User(image,
                        //         downloadUri.toString());
                        // myRef.child(phnumber).setValue(user);
                    }else
                    {
                        Toast.makeText(getActivity(), "upload failed: " + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

/*
    private void uploadImage() {

        if(filePath != null)
        {
            final ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());
            //String kep = ref.toString();
            //Log.d("kep","feltoltott kep url ja:",kep);

            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(getActivity().getApplicationContext(), "Uploaded", Toast.LENGTH_SHORT).show();
                            //Uri downloadurl = taskSnapshot.getResult();
                           // Uri downuri = filePath.get
                            //String downloadurl = filePath.toString();

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(getActivity().getApplicationContext(), "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });
        }

    }*/
}