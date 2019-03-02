package com.example.weekthreelx.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weekthreelx.R;

public class AddSubtractView extends LinearLayout {
    private TextView subtract;
    private TextView teNum;
    private TextView add;
    private int num=1;

    public AddSubtractView(Context context) {
        this(context, null);
    }

    public AddSubtractView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AddSubtractView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(context);
    }

    private void initData(Context context) {
        LayoutInflater.from(context).inflate(R.layout.addsubtract_layout, this, true);
        initView();
    }

    private void initView() {
        subtract = (TextView) findViewById(R.id.subtract);
        teNum = (TextView) findViewById(R.id.te_num);
        add = (TextView) findViewById(R.id.add);
        teNum.setText("1");

        //添加
        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                num=Integer.parseInt(teNum.getText().toString());
                num++;
                teNum.setText(num+"");
                if (addSubtractCallback!=null){
                    addSubtractCallback.numCallback(num);
                }
            }
        });
        //减少
        subtract.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                num=Integer.parseInt(teNum.getText().toString());
                num--;
                if (num==0){
                    num=1;
                    Toast.makeText(getContext(),"不能再减了",Toast.LENGTH_SHORT).show();
                    return;
                }
                teNum.setText(num+"");
                if (addSubtractCallback!=null){
                    addSubtractCallback.numCallback(num);
                }
            }
        });

    }

    private AddSubtractCallback addSubtractCallback;
    private void setAddSubtractCallback(AddSubtractCallback addSubtractCallback){
        this.addSubtractCallback=addSubtractCallback;
    }
    public interface AddSubtractCallback{
        void numCallback(int num);
    }
}
