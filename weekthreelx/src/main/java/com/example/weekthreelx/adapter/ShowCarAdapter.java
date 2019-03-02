package com.example.weekthreelx.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.weekthreelx.R;
import com.example.weekthreelx.entity.ShowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class ShowCarAdapter extends RecyclerView.Adapter<ShowCarAdapter.ViewHolder> {
    private Context context;
    private List<ShowBean.ResultBean> showcardata;

    public ShowCarAdapter(Context context, List<ShowBean.ResultBean> showcardata) {
        this.context = context;
        this.showcardata = showcardata;
    }

    @NonNull
    @Override
    public ShowCarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.car_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ShowCarAdapter.ViewHolder viewHolder, int i) {
            viewHolder.simp_car.setImageURI(showcardata.get(i).getPic());
            viewHolder.title.setText(showcardata.get(i).getCommodityName());
            viewHolder.price.setText(showcardata.get(i).getPrice()+"");
            viewHolder.checkbox.setChecked(showcardata.get(i).isIschecked);
            //全选点击事件
            viewHolder.checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewHolder.checkbox.isChecked();
                    for (ShowBean.ResultBean showcardatum : showcardata) {
                        showcardatum.isIschecked=viewHolder.checkbox.isChecked();
                    }
                }
            });
           /* viewHolder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    viewHolder.checkbox.isChecked();
                    for (ShowBean.ResultBean cardatum : showcardata) {
                        cardatum.isIschecked=viewHolder.checkbox.isChecked();
                    }
                    notifyDataSetChanged();
                }
            });*/
    }

    @Override
    public int getItemCount() {
        return showcardata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CheckBox checkbox;
        private SimpleDraweeView simp_car;
        private TextView title;
        private TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkbox = itemView.findViewById(R.id.checkbox);
            simp_car = itemView.findViewById(R.id.simp_car);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }
    }
}
