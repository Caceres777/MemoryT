package com.example.owen.pruebasliderfragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

import com.parse.ParseException;
import com.parse.ParseFile;

/**
 * Created by Owen on 04/02/2015.
 */
public class ImageHelper {


    public Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap
                .getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }


    public Bitmap parseFiletoBitmap(ParseFile data){
        Bitmap bitmap = null;
        if(data != null) {
            try {
                byte[] img = data.getData();
                bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
                bitmap = Bitmap.createScaledBitmap(bitmap, 180, 180, true);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return bitmap;
    }

}
