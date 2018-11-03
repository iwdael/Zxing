package com.hacknife.demozxing;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * author  : hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
 * project : zxing
 */
public class ImageLoader implements com.hacknife.imagepicker.loader.ImageLoader {
    @Override
    public void displayFileImage(ImageView imageView, String s) {
        Glide.with(imageView.getContext())
                .load(s)
                .into(imageView);
    }

    @Override
    public void displayUserImage(ImageView imageView, String s) {
        Glide.with(imageView.getContext())
                .load(s)
                .into(imageView);
    }

    @Override
    public void displayFileVideo(String s) {

    }

    @Override
    public Class<?> displayFullImageClass() {
        return null;
    }
}
