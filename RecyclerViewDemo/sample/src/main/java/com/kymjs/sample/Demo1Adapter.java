package com.kymjs.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kymjs.view.recycler.data.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangTao on 7/4/16.
 */
public class Demo1Adapter extends RecyclerView.Adapter<Demo1Adapter.VH> {

    private List<Data> dataList;
    private Context context;

    public Demo1Adapter(Context context, ArrayList<Data> datas) {
        if (datas == null) {
            datas = new ArrayList<>();
        }
        this.dataList = datas;
        this.context = context;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH(View.inflate(context, android.R.layout.simple_list_item_2, null));
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.mTextView.setText(dataList.get(position).getNum());
        if (position % 2 == 0) {
            holder.mDescTextView.setVisibility(View.VISIBLE);
            holder.mDescTextView.setText(dataList.get(position).getTime());
        } else {
            holder.mDescTextView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class VH extends RecyclerView.ViewHolder {
        TextView mTextView;
        TextView mDescTextView;

        public VH(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(android.R.id.text1);
            mDescTextView = (TextView) itemView.findViewById(android.R.id.text2);
        }
    }
}
