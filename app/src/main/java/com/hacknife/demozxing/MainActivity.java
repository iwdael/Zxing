package com.hacknife.demozxing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;
import com.hacknife.imagepicker.ImagePicker;
import com.hacknife.imagepicker.bean.ImageItem;
import com.hacknife.zxing.BaseCaptureActivity;
import com.hacknife.zxing.util.QRHelper;
import com.hacknife.zxing.widget.AutoScannerView;

import java.util.List;

public class MainActivity extends BaseCaptureActivity implements View.OnClickListener {
    SurfaceView surfaceView;
    TextView photo;
    AutoScannerView scanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surfaceView = findViewById(R.id.surface);
        scanner = findViewById(R.id.scanner);
        photo = findViewById(R.id.photo);
        photo.setOnClickListener(this);
    }

    @Override
    public SurfaceView getSurfaceView() {
        return surfaceView;
    }

    @Override
    protected void onResume() {
        super.onResume();
        scanner.setCameraManager(cameraManager);
    }

    @Override
    public void dealDecode(Result rawResult, Bitmap barcode, float scaleFactor) {
        Toast.makeText(MainActivity.this, rawResult.getText(), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) {
        ImagePicker.getInstance()
                .crop(false)
                .multiMode(false)
                .selectLimit(1)
                .imageLoader(new ImageLoader())
                .selectedListener(new ImagePicker.OnSelectedListener() {
                    @Override
                    public void onImageSelected(List<ImageItem> list) {
                        Result result = QRHelper.readQrImage(list.get(0).getImageUrl());
                        if (result != null && result.getText() != null)
                            Toast.makeText(MainActivity.this, result.getText(), Toast.LENGTH_SHORT).show();
                    }
                })
                .startImagePicker(this, null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImagePicker.getInstance().onActivityResult(requestCode, resultCode, data);
    }
}
