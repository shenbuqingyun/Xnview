package com.xnview.XnSketchBase.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xnview.XnSketchPro.R;

import java.util.List;

/**
 * 作者    cpf
 * 时间    2019/8/22 17:12
 * 文件    Test1
 * 描述
 */
public class XnviewAdapter1 extends RecyclerView.Adapter<XnviewAdapter1.ViewHolder> {

    private List<Xnview> mXnviewList;

    //静态内部类 构造出ViewHolder
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView songImage;
        TextView songName;
        FrameLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            songImage = (ImageView) itemView.findViewById(R.id.song_image);
            songName = (TextView) itemView.findViewById(R.id.song_name);
            linearLayout = (FrameLayout) itemView.findViewById(R.id.root);
        }
    }

    public XnviewAdapter1(List<Xnview> xnviewList) {
        mXnviewList = xnviewList;
    }

    //重写RecyclerView.Adapter的三个构造方法
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //第一个构造方法用来加载布局
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_item, parent, false);
        ViewHolder holder = new ViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //第二个构造方法用来赋值数据
        Xnview xnview = mXnviewList.get(position);
        holder.songImage.setImageResource(xnview.getImageId());
        holder.songName.setText(xnview.getName());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        //第三个构造方法用来提示长度
        return mXnviewList.size();
    }

    private onRecyclerViewItemClick itemClickListener;

    public interface onRecyclerViewItemClick {
        void onItemClick(View v, int pos);
    }

    public void setOnItemClickListener(onRecyclerViewItemClick itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
