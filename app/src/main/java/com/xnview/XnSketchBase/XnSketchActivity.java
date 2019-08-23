package com.xnview.XnSketchBase;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xnview.XnSketchPro.R;

public class XnSketchActivity extends AppCompatActivity {

    static
    {
        System.loadLibrary("sketch-library");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xn_sketch);
    }

    public static native int invokeEffect(Bitmap paramBitmap1, Bitmap paramBitmap2,
                                          int paramInt1, int paramInt2, int paramInt3,
                                          int paramInt4, int paramInt5, int paramInt6,
                                          int paramInt7, int paramInt8, int paramInt9);

}
