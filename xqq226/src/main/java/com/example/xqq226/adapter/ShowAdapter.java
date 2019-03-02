package com.example.xqq226.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xqq226.R;
import com.example.xqq226.entity.ShowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder> {
    private Context context;
    private List<ShowBean.ResultBean> showdata;

    public ShowAdapter(Context context, List<ShowBean.ResultBean> showdata) {
        this.context = context;
        this.showdata = showdata;
    }

    @NonNull
    @Override
    public ShowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.show_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowAdapter.ViewHolder viewHolder, int i) {
        viewHolder.simp_img.setImageURI(showdata.get(i).getImageUrl());
        viewHolder.title.setText(showdata.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return showdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private SimpleDraweeView simp_img;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            simp_img = itemView.findViewById(R.id.simp_img);
            title = itemView.findViewById(R.id.title);
        }
    }
}
