package com.example.nitishatal.docapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class onlineconsult extends AppCompatActivity {
    Button chooseimage,choosevideo,upload;
    ImageView image;
    VideoView video;
    ProgressDialog progressDialog=null;
    Uri filePath=null,filepath2=null;
    int PICK_IMAGE_REQUEST=1,PICK_VIDEO_REQUEST=2;
    FirebaseStorage storage;
    StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onlineconsult);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference("images");
        chooseimage=(Button)findViewById(R.id.chooseimage);
        choosevideo=(Button)findViewById(R.id.choosevideo);
        upload=(Button)findViewById(R.id.upload);
        image=(ImageView)findViewById(R.id.image);
        image.setVisibility(View.INVISIBLE);
        video=(VideoView) findViewById(R.id.video);
        video.setVisibility(View.INVISIBLE);
        chooseimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseimage();
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upload();
            }
        });
        choosevideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosevideo();
            }
        });

    }
    private void chooseimage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }
    private void choosevideo() {
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Video"), PICK_VIDEO_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                image.setVisibility(View.VISIBLE);
                image.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else if(requestCode == PICK_VIDEO_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null){
               filepath2=data.getData();
               //Uri uri=MediaStore.Video.Media.getContentUri(getContentResolver(),filePath);
              // video.setVisibility(View.VISIBLE);
               //video.setVideoPath(filePath);
        }
    }
    private void upload() {

        if(filePath != null)
        {
            if(filepath2==null) {
             progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();
            }

            StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());
            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            if(filepath2==null) {
                                progressDialog.dismiss();
                            }
                            Toast.makeText(onlineconsult.this, "Image Uploaded", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            if(filepath2==null) {
                                progressDialog.dismiss();
                            }
                            Toast.makeText(onlineconsult.this, "Image upload Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            if(filepath2==null) {
                                progressDialog.setMessage("Image Uploaded " + (int) progress + "%");
                            }
                        }
                    });
        }
        if(filepath2 != null)
        {
            final ProgressDialog progressDialog2 = new ProgressDialog(this);
            progressDialog2.setTitle("Uploading...");
            progressDialog2.show();

            StorageReference ref = storageReference.child("video/"+ UUID.randomUUID().toString());
            ref.putFile(filepath2)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog2.dismiss();
                            Toast.makeText(onlineconsult.this, "Video Uploaded", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog2.dismiss();
                            Toast.makeText(onlineconsult.this, "Video upload Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            progressDialog2.setMessage("Video Uploaded "+(int)progress+"%");
                        }
                    });
        }
    }
}
