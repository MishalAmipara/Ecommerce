package com.example.ecommerceapp;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btn,getData;
    String permissions[]={Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, permissions, 1);
        if (isNetworkConnected()) {
            findViewById(R.id.btnGetData).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, ViewData_Activity.class);
                    startActivity(intent);
                }
            });
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Turn On your Internet");
            builder.setPositiveButton("Turn On", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
//                    WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
//                    wifi.setWifiEnabled(true);

                }
            });
//            builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    finish();
//                }
//            });
            builder.show();
        }
        imageView = findViewById(R.id.ImageView);
        //Glide.with(this).lodad("data:image/jpeg;base64,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).into(imageView").into(imageView);
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults[0]!= PackageManager.PERMISSION_GRANTED || grantResults[1]!=PackageManager.PERMISSION_GRANTED || grantResults[2]!=PackageManager.PERMISSION_GRANTED)
            {
                finish();
            }
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start picker to get image for cropping and then use the image in cropping activity
                CropImage.activity()
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .start(MainActivity.this);
            }
//
//// start cropping activity for pre-acquired image saved on the device
//                CropImage.activity(imageUri)
//                        .start(this);
//
//// for fragment (DO NOT use `getActivity()`)
//                CropImage.activity()
//                        .start(getContext(), this);
//            }
        });

    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {

                Uri resultUri = result.getUri();
                imageView.setImageURI(resultUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}