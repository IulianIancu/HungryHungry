package com.example.iancu.hungryhungry;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by Iancu on 07/11/2016.
 */

public class CustomImageView extends ImageView {

    public CustomImageView(Context context) {
        super(context);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable img= getResources().getDrawable(R.drawable.ic_watermark_24dp);
        Bitmap bitMap =((BitmapDrawable)img).getBitmap();
        canvas.drawBitmap(bitMap,0,0,null);
    }
}
