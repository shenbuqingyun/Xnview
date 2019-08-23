package com.xnview.XnSketchBase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.xnview.XnSketchBase.adapter.XnviewAdapter1;
import com.xnview.XnSketchPro.R;

/**
 * 作者    cpf
 * 时间    2019/8/23 14:49
 * 文件    Xnview
 * 描述
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setBackgroundDrawable(null);
    }

    public void open0(View view){
        Intent intent0 = new Intent(MainActivity.this, ViewActivity.class);
        startActivity(intent0);
    }
    public void open1(View view){
        Intent intent1 = new Intent(MainActivity.this, XnviewActivity1.class);
        startActivity(intent1);
    }
    public void open2(View view){
        Intent intent2 = new Intent(MainActivity.this, XnviewActivity2.class);
        startActivity(intent2);
    }
    public void open3(View view){
        Intent intent3 = new Intent(MainActivity.this, XnviewActivity3.class);
        startActivity(intent3);
    }
    public void open4(View view){
        Intent intent4 = new Intent(MainActivity.this, XnviewActivity4.class);
        startActivity(intent4);
    }
    public void open5(View view){
        Intent intent5 = new Intent(MainActivity.this, XnviewActivity5.class);
        startActivity(intent5);
    }
    public void open6(View view){
        Intent intent6 = new Intent(MainActivity.this, XnviewActivity6.class);
        startActivity(intent6);
    }
    public void open7(View view){
        Intent intent7 = new Intent(MainActivity.this, XnviewActivity7.class);
        startActivity(intent7);
    }
    public void open8(View view){
        Intent intent8 = new Intent(MainActivity.this, XnviewActivity8.class);
        startActivity(intent8);
    }
}
