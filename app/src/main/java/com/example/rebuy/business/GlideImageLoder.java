package com.example.rebuy.business;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * @author YangZhaoxin.
 * @since 2019/4/2 19:03.
 * email yangzhaoxin@hrsoft.net.
 */

public class GlideImageLoder extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }
}
