package com.example.medicare.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicare.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

public class Edit_Profile_Activity extends AppCompatActivity {
    final int PIC_CROP = 1;
    int gallery_PIC_REQUEST = 101;
    int CAMERA_PIC_REQUEST = 105;
    LinearLayout edit_layout;
    File newfile;
    ImageView profile_image;
    Button save_btn;
    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        profile_image = findViewById(R.id.profile_image);
        edit_layout = findViewById(R.id.edit_layout);


        findViewById(R.id.back).setOnClickListener(v -> {
            finish();
        });

        findViewById(R.id.change_pic)
                .setOnClickListener(v -> {
                    Attechmentfile();
                });
        findViewById(R.id.save_btn)
                .setOnClickListener(v -> {
                    finish();
                });


    }

    public void Attechmentfile() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.item_attechmentlayout, null);
        mPopupWindow = new PopupWindow(customView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        mPopupWindow.setElevation(5.0f);
        // Set a click listener for the popup window close button
        customView.findViewById(R.id.gallery).setOnClickListener(view -> {
            mPopupWindow.dismiss();
            Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, gallery_PIC_REQUEST);
        });
        customView.findViewById(R.id.camera).setOnClickListener(view -> {
            mPopupWindow.dismiss();
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(takePictureIntent, CAMERA_PIC_REQUEST);
        });
        mPopupWindow.showAtLocation(edit_layout, Gravity.CENTER, 0, 0);
        RelativeLayout closebtn = customView.findViewById(R.id.closebtn);
        closebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPopupWindow.dismiss();
            }
        });
    }

    @SuppressLint({"MissingSuperCall"})
    public void onActivityResult(int requestCode,
                                 int resultCode,
                                 @org.jetbrains.annotations.Nullable Intent data) {
        Bitmap imageBitmap;
        if (requestCode == CAMERA_PIC_REQUEST && resultCode == -1) {
            Object var7;
            label34:
            {
                if (data != null) {
                    Bundle var10000 = data.getExtras();
                    if (var10000 != null) {
                        var7 = var10000.get("data");
                        break label34;
                    }
                }
                var7 = null;
            }
            if (var7 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
            }
            imageBitmap = (Bitmap) var7;
            this.bitmapToFile(imageBitmap);
//            performCrop(Uri.fromFile(new File(newfile.getAbsolutePath())));
        } else if (requestCode == gallery_PIC_REQUEST && data != null) {
            try {
                imageBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                Intrinsics.checkExpressionValueIsNotNull(imageBitmap, "bitmap");
                this.bitmapToFile(imageBitmap);
//                performCrop(Uri.fromFile(new File(newfile.getAbsolutePath())));
            } catch (IOException var5) {
                var5.printStackTrace();
            }
        } else if (requestCode == PIC_CROP) {
            if (data != null) {
                // get the returned data
                Bundle extras = data.getExtras();
                // get the cropped bitmap
                Bitmap selectedBitmap = extras.getParcelable("data");
                profile_image.setImageBitmap(selectedBitmap);
            }
        }
    }

    private Uri bitmapToFile(Bitmap bitmap) {
        profile_image.setImageBitmap(bitmap);
        ContextWrapper wrapper = new ContextWrapper(Edit_Profile_Activity.this);
        this.newfile = wrapper.getDir("Images", 0);
        this.newfile = new File(this.newfile, UUID.randomUUID() + ".jpg");

        try {
            OutputStream stream = new FileOutputStream(this.newfile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            stream.flush();
            stream.close();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        File files = this.newfile;
        if (files == null) {
            Intrinsics.throwNpe();

        }
        Uri var5 = Uri.parse(files.getAbsolutePath());
        Intrinsics.checkExpressionValueIsNotNull(var5, "Uri.parse(newfile!!.absolutePath)");
        return var5;
    }

}