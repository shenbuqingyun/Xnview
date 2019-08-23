package com.xnview.XnSketchBase;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.xnview.XnSketchBase.adapter.Xnview;
import com.xnview.XnSketchBase.adapter.XnviewAdapter1;
import com.xnview.XnSketchBase.adapter.Utils;
import com.xnview.XnSketchBase.adapter.XnviewAdapter2;
import com.xnview.XnSketchPro.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者    cpf
 * 时间    2019/8/22 16:07
 * 文件    Test1
 * 描述
 */
public class ViewActivity extends AppCompatActivity {

    private Bitmap paramBitmap1,paramBitmap11;
    private Bitmap paramBitmap2, paramBitmap3, paramBitmap4,
            paramBitmap5, paramBitmap6, paramBitmap7, paramBitmap8, paramBitmap9;
    private ImageView imageView, imageView2;
    private RecyclerView recyclerView1,recyclerView2;
    private List<Xnview> xnviewList1 = new ArrayList<>();
    private List<Xnview> xnviewList2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xn_sketch);
        intSongs1();
        intSongs2();
        initBitmaps();
        initViews();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setBackgroundDrawable(null);
    }

    private void intSongs1() {
        for (int i = 0; i < 2; i++) {
            Xnview x_Hold = new Xnview("Hold", R.drawable.ic_launcher);
            xnviewList1.add(x_Hold);
            Xnview x_Dream = new Xnview("Dream", R.drawable.ic_launcher);
            xnviewList1.add(x_Dream);
            Xnview x_Cocoom = new Xnview("Cocoom", R.drawable.ic_launcher);
            xnviewList1.add(x_Cocoom);
            Xnview x_Million = new Xnview("Millio", R.drawable.ic_launcher);
            xnviewList1.add(x_Million);
            Xnview x_See = new Xnview("See", R.drawable.ic_launcher);
            xnviewList1.add(x_See);
            Xnview x_Need = new Xnview("Need", R.drawable.ic_launcher);
            xnviewList1.add(x_Need);
            Xnview x_Show = new Xnview("Show", R.drawable.ic_launcher);
            xnviewList1.add(x_Show);
            Xnview x_Super = new Xnview("Super", R.drawable.ic_launcher);
            xnviewList1.add(x_Super);
        }
    }

    private void intSongs2() {
        for (int i = 0; i < 2; i++) {
            Xnview x_Hold = new Xnview("1", R.drawable.ic_launcher2);
            xnviewList2.add(x_Hold);
            Xnview x_Dream = new Xnview("2", R.drawable.ic_launcher2);
            xnviewList2.add(x_Dream);
            Xnview x_Cocoom = new Xnview("3", R.drawable.ic_launcher2);
            xnviewList2.add(x_Cocoom);
            Xnview x_Million = new Xnview("4", R.drawable.ic_launcher2);
            xnviewList2.add(x_Million);
        }
    }

    private void initBitmaps(){
        paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
        paramBitmap11 = BitmapFactory.decodeResource(getResources(), R.drawable.timg2);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        paramBitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.sketch_thumb_25); /*0*/
        paramBitmap2 = Utils.compressBySampleSize(paramBitmap2, width, height, false);

        paramBitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.sketch_thumb_27); /*1*/
        paramBitmap3 = Utils.compressBySampleSize(paramBitmap3, width, height, false);

        paramBitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.sketch_thumb_28); /*2*/
        paramBitmap4 = Utils.compressBySampleSize(paramBitmap4, width, height, false);

        paramBitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.sketch_thumb_29); /*3*/
        paramBitmap5 = Utils.compressBySampleSize(paramBitmap5, width, height, false);

        paramBitmap6 = BitmapFactory.decodeResource(getResources(), R.drawable.sketch_thumb_31); /*4*/
        paramBitmap6 = Utils.compressBySampleSize(paramBitmap6, width, height, false);

        paramBitmap7 = BitmapFactory.decodeResource(getResources(), R.drawable.sketch_thumb_32); /*5*/
        paramBitmap7 = Utils.compressBySampleSize(paramBitmap7, width, height, false);

        paramBitmap8 = BitmapFactory.decodeResource(getResources(), R.drawable.sketch_thumb_33); /*6*/
        paramBitmap8 = Utils.compressBySampleSize(paramBitmap8, width, height, false);

        paramBitmap9 = BitmapFactory.decodeResource(getResources(), R.drawable.sketch_thumb_34); /*7*/
        paramBitmap9 = Utils.compressBySampleSize(paramBitmap9, width, height, false);
    }

    private void initViews(){
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        recyclerView1 = findViewById(R.id.recyclerView);
        recyclerView2 = findViewById(R.id.recyclerView2);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 6);
        recyclerView1.setLayoutManager(layoutManager);

        XnviewAdapter1 xnviewAdapter1 = new XnviewAdapter1(xnviewList1);
        xnviewAdapter1.setOnItemClickListener(new XnviewAdapter1.onRecyclerViewItemClick() {

            @Override
            public void onItemClick(View v, int pos) {
                doItemClick(pos);
                Toast.makeText(ViewActivity.this, String.valueOf(pos), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView1.setAdapter(xnviewAdapter1);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(layoutManager2);

        XnviewAdapter2 xnviewAdapter2 = new XnviewAdapter2(xnviewList2);
        xnviewAdapter2.setOnItemClickListener(new XnviewAdapter2.onRecyclerViewItemClick() {

            @Override
            public void onItemClick(View v, int pos) {
                doItemClick2(pos);
                Toast.makeText(ViewActivity.this, String.valueOf(pos), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView2.setAdapter(xnviewAdapter2);
    }
    private void doItemClick(int position) {
        switch (position) {
            case 0:
                XnSketchActivity.invokeEffect(paramBitmap1, null, 1, 25, 1, 48, 0, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 15:
                XnSketchActivity.invokeEffect(paramBitmap1, null, 13, 0, 0, 0, 0, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 14:
                XnSketchActivity.invokeEffect(paramBitmap1, null, 20, 0, 0, 0, 0, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 13:
                XnSketchActivity.invokeEffect(paramBitmap1, null, 21, 0, 0, 0, 0, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 12:
                XnSketchActivity.invokeEffect(paramBitmap1, null, 19, 0, 0, 0, 0, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 11:
                XnSketchActivity.invokeEffect(paramBitmap1, null, 18, 25, 0, 0, 0, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 10:
                XnSketchActivity.invokeEffect(paramBitmap1, null, 12, 0, 0, 0, 0, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 9:
                XnSketchActivity.invokeEffect(paramBitmap1, null, 10, 0, 0, 0, 0, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 8:
                XnSketchActivity.invokeEffect(paramBitmap1, null, 16, 0, 0, 0, 0, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 7:
                XnSketchActivity.invokeEffect(paramBitmap1, null, 15, 0, 0, 0, 0, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 6:
                XnSketchActivity.invokeEffect(paramBitmap1, null, 3, 25, 0, 100 - 48, 50, 0, 0, 1, 48);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 5:
                XnSketchActivity.invokeEffect(paramBitmap1, null, 3, 25, 0, 100 - 48, 50, 1, Color.argb(0, 144, 112, 80), 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 4:
                XnSketchActivity.invokeEffect(paramBitmap1, null, 3, 25, 0, 100 - 48, 50, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 3:
                XnSketchActivity.invokeEffect(paramBitmap1, null, 3, 25, 0, 100 - 48, 50, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 2:
                XnSketchActivity.invokeEffect(paramBitmap1, null, 2, 25, 1, 48, 0, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 1:
                XnSketchActivity.invokeEffect(paramBitmap1, null, 0, 25, 1, 48, 0, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            /*盖一层*/
            case 16:
                XnSketchActivity.invokeEffect(paramBitmap1, paramBitmap2, 3, 25, 0, 100 - 48, 0, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 17:
                XnSketchActivity.invokeEffect(paramBitmap1, paramBitmap3, 3, 25, 0, 100 - 48, 50, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 18:
                XnSketchActivity.invokeEffect(paramBitmap1, paramBitmap4, 3, 25, 0, 100 - 48, 50, 1, Color.argb(0, 144, 112, 80), 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 19:
                XnSketchActivity.invokeEffect(paramBitmap1, paramBitmap5, 3, 25, 0, 100 - 48, 50, 0, 0, 1, Color.argb(0, 229, 170, 110));
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 20:
                XnSketchActivity.invokeEffect(paramBitmap1, paramBitmap2, 9, 0, 0, 0, 0, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 21:
                XnSketchActivity.invokeEffect(paramBitmap1, paramBitmap3, 17, 0, 0, 0, 0, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 22:
                XnSketchActivity.invokeEffect(paramBitmap1, paramBitmap4, 11, 0, 1, 0, 0, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
            case 23:
                XnSketchActivity.invokeEffect(paramBitmap1, paramBitmap5, 17, 0, 1, 0, 0, 0, 0, 0, 0);
                if (paramBitmap1 != null) {
                    imageView.setImageBitmap(paramBitmap1);
                }
                paramBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                break;
        }
    }

    private void doItemClick2(int position) {
        switch (position) {
            /*加入覆蓋圖*/
            case 0:
                XnSketchActivity.invokeEffect(paramBitmap11, paramBitmap2, 3, 25, 0, 100 - 48, 0, 0, 0, 0, 0);
                if (paramBitmap11 != null) {
                    imageView2.setImageBitmap(paramBitmap11);
                }
                paramBitmap11 = BitmapFactory.decodeResource(getResources(), R.drawable.timg2);
                break;
            case 1:
                XnSketchActivity.invokeEffect(paramBitmap11, paramBitmap3, 3, 25, 0, 100 - 48, 50, 0, 0, 0, 0);
                if (paramBitmap11 != null) {
                    imageView2.setImageBitmap(paramBitmap11);
                }
                paramBitmap11 = BitmapFactory.decodeResource(getResources(), R.drawable.timg2);
                break;
            case 2:
                XnSketchActivity.invokeEffect(paramBitmap11, paramBitmap4, 3, 25, 0, 100 - 48, 50, 1, Color.argb(0, 144, 112, 80), 0, 0);
                if (paramBitmap11 != null) {
                    imageView2.setImageBitmap(paramBitmap11);
                }
                paramBitmap11 = BitmapFactory.decodeResource(getResources(), R.drawable.timg2);
                break;
            case 3:
                XnSketchActivity.invokeEffect(paramBitmap11, paramBitmap5, 3, 25, 0, 100 - 48, 50, 0, 0, 1, Color.argb(0, 229, 170, 110));
                if (paramBitmap11 != null) {
                    imageView2.setImageBitmap(paramBitmap11);
                }
                paramBitmap11 = BitmapFactory.decodeResource(getResources(), R.drawable.timg2);
                break;
            case 4: /*实测 4 5 7号算法表现最好*/
                XnSketchActivity.invokeEffect(paramBitmap11, paramBitmap6, 9, 0, 0, 0, 0, 0, 0, 0, 0);
                if (paramBitmap11 != null) {
                    imageView2.setImageBitmap(paramBitmap11);
                }
                paramBitmap11 = BitmapFactory.decodeResource(getResources(), R.drawable.timg2);
                break;
            case 5:
                XnSketchActivity.invokeEffect(paramBitmap11, paramBitmap7, 17, 0, 0, 0, 0, 0, 0, 0, 0);
                if (paramBitmap11 != null) {
                    imageView2.setImageBitmap(paramBitmap11);
                }
                paramBitmap11 = BitmapFactory.decodeResource(getResources(), R.drawable.timg2);
                break;
            case 6:
                XnSketchActivity.invokeEffect(paramBitmap11, paramBitmap8, 11, 0, 1, 0, 0, 0, 0, 0, 0);
                if (paramBitmap11 != null) {
                    imageView2.setImageBitmap(paramBitmap11);
                }
                paramBitmap11 = BitmapFactory.decodeResource(getResources(), R.drawable.timg2);
                break;
            case 7:
                XnSketchActivity.invokeEffect(paramBitmap11, paramBitmap9, 17, 0, 1, 0, 0, 0, 0, 0, 0);
                if (paramBitmap11 != null) {
                    imageView2.setImageBitmap(paramBitmap11);
                }
                paramBitmap11 = BitmapFactory.decodeResource(getResources(), R.drawable.timg2);
                break;
        }
    }
}
