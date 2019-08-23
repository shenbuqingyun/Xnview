package com.xnview.XnSketchBase;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.xnview.XnSketchBase.adapter.Utils;
import com.xnview.XnSketchBase.adapter.Xnview;
import com.xnview.XnSketchBase.adapter.XnviewAdapter1;
import com.xnview.XnSketchPro.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者    cpf
 * 时间    2019/8/23 14:30
 * 文件    Xnview
 * 描述
 */
public class XnviewActivity4 extends AppCompatActivity {

    private Bitmap paramBitmap1;
    private ImageView imageView;
    private RecyclerView recyclerView;
    private List<Xnview> xnviewList1 = new ArrayList<>();

    private void intSongs1() {
        for (int i = 0; i < 41; i++) {
            Xnview x_Hold = new Xnview("Hold", R.drawable.ic_launcher);
            xnviewList1.add(x_Hold);
            Xnview x_Dream = new Xnview("Dream", R.drawable.ic_launcher);
            xnviewList1.add(x_Dream);
        }
    }

    private int[] xnviewId = {R.drawable.bkg_txt, R.drawable.bkg_txt3, R.drawable.bkg_txt4, R.drawable.bkg_txt5,
            R.drawable.blackboard, R.drawable.blackstroes, R.drawable.blakchawkboard,R.drawable.bluetex,
            R.drawable.carbontexture, R.drawable.charcoal1, R.drawable.darklines,R.drawable.dollertexture,
            R.drawable.drawingtool1, R.drawable.drawingtool2, R.drawable.edge_burn,R.drawable.halfton4,
            R.drawable.halfton7, R.drawable.halfton8, R.drawable.halfton41,R.drawable.halfton82,
            R.drawable.halfton411, R.drawable.halftone, R.drawable.hatsh11,R.drawable.hefe_metal,
            R.drawable.hudson_background, R.drawable.marker, R.drawable.pencil,R.drawable.point_black,
            R.drawable.point_black2, R.drawable.sierra_vignette, R.drawable.sketch_1,R.drawable.sketch_3,
            R.drawable.sketch_5, R.drawable.sketch_6, R.drawable.sketch_7,R.drawable.sketch_8,
            R.drawable.sketch_9, R.drawable.sketch_texture, R.drawable.sketch_texture1,R.drawable.sketch_thumb_1,
            R.drawable.sketch_thumb_2, R.drawable.sketch_thumb_3, R.drawable.sketch_thumb_4,R.drawable.sketch_thumb_5,
            R.drawable.sketch_thumb_6, R.drawable.sketch_thumb_7, R.drawable.sketch_thumb_8,R.drawable.sketch_thumb_9,
            R.drawable.sketch_thumb_10, R.drawable.sketch_thumb_11, R.drawable.sketch_thumb_13,R.drawable.sketch_thumb_14,
            R.drawable.sketch_thumb_16, R.drawable.sketch_thumb_19, R.drawable.sketch_thumb_20,R.drawable.sketch_thumb_21,
            R.drawable.sketch_thumb_22, R.drawable.sketch_thumb_23, R.drawable.sketch_thumb_24,R.drawable.sketch_thumb_25,
            R.drawable.sketch_thumb_27, R.drawable.sketch_thumb_28, R.drawable.sketch_thumb_29,R.drawable.sketch_thumb_31,
            R.drawable.sketch_thumb_32, R.drawable.sketch_thumb_33, R.drawable.sketch_thumb_34,R.drawable.sketch_thumb_35,
            R.drawable.sketch_thumb_36, R.drawable.sketch5, R.drawable.sketch11,R.drawable.sutro_edge_burn,
            R.drawable.sutro_metal, R.drawable.texture_canvas1, R.drawable.theme_grung,R.drawable.theme12,
            R.drawable.toaster_metal, R.drawable.water, R.drawable.water2,R.drawable.water3,R.drawable.water5,R.drawable.water555};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xn_1);
        imageView = findViewById(R.id.imageView);
        recyclerView = findViewById(R.id.recyclerView);
        intSongs1();
        paramBitmap1 = BitmapFactory.decodeResource(getResources(),R.drawable.timg2);
        imageView.setImageBitmap(paramBitmap1);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 7);
        recyclerView.setLayoutManager(layoutManager);

        XnviewAdapter1 xnviewAdapter1 = new XnviewAdapter1(xnviewList1);
        xnviewAdapter1.setOnItemClickListener(new XnviewAdapter1.onRecyclerViewItemClick() {

            @Override
            public void onItemClick(View v, int pos) {
                doItemClick(pos);
                Toast.makeText(XnviewActivity4.this, String.valueOf(pos), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(xnviewAdapter1);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setBackgroundDrawable(null);
    }

    private void doItemClick(int pos){
        paramBitmap1 = BitmapFactory.decodeResource(getResources(),R.drawable.timg2);
        Bitmap xnviewBitmap = BitmapFactory.decodeResource(getResources(), xnviewId[pos]);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        xnviewBitmap = Utils.compressBySampleSize(xnviewBitmap, width, height, false);

        XnSketchActivity.invokeEffect(paramBitmap1, xnviewBitmap, 3, 25, 0, 100 - 48, 50, 0, 0, 1, Color.argb(0, 229, 170, 110));
        if (paramBitmap1 != null) {
            imageView.setImageBitmap(paramBitmap1);
        }
    }
}
