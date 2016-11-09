package com.example.iancu.hungryhungry;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by Iancu on 07/11/2016.
 */

public class CustomImageView extends ImageView {
    Paint paint = new Paint();

    public CustomImageView(Context context) {
        super(context);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Drawable img= getResources().getDrawable(R.drawable.ic_watermark_24dp);
//        Bitmap bitMap =((BitmapDrawable)img).getBitmap();

        paint.setColor(Color.BLACK);
        paint.setAlpha(50);
        paint.setTextSize(12);
        paint.setAntiAlias(true);
        canvas.drawText(getContext().getString(R.string.watermark),0,0,paint);
//        canvas.drawBitmap(bitMap,0,0,paint);
    }
}
