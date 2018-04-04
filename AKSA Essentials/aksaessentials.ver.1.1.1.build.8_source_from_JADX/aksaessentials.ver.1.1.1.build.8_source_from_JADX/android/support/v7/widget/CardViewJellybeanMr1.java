package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

class CardViewJellybeanMr1 extends CardViewEclairMr1 {

    class C03111 implements RoundRectHelper {
        C03111() {
        }

        public void drawRoundRect(Canvas canvas, RectF bounds, float cornerRadius, Paint paint) {
            canvas.drawRoundRect(bounds, cornerRadius, cornerRadius, paint);
        }
    }

    CardViewJellybeanMr1() {
    }

    public void initStatic() {
        RoundRectDrawableWithShadow.sRoundRectHelper = new C03111();
    }
}
