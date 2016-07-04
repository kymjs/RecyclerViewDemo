package com.kymjs.demo2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kymjs.view.recycler.data.Data;
import com.kymjs.view.recycler.data.DataUtils;

import java.util.ArrayList;

public class Demo2Adapter extends RecyclerView.Adapter<Demo2Adapter.VH> {
    private final Context mContext;
    private ArrayList<Data> mTitles;

    public Demo2Adapter(Context context) {
        ArrayList<Data> datas = DataUtils.getDatas();
        if (datas == null) {
            datas = new ArrayList<>();
        }
        mTitles = datas;
        mContext = context;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH(View.inflate(mContext, R.layout.item_text, null), this);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.mTextView.setText(mTitles.get(position).getNum());
    }

    @Override
    public int getItemCount() {
        return mTitles.size();
    }

    public void addTitle(String title) {
        Data data = new Data();
        data.setNum(title);
        mTitles.add(1, data);
        notifyItemInserted(1);
    }

    public void remove(int position) {
        mTitles.remove(position);
        notifyItemRemoved(position);
    }

    public static class VH extends RecyclerView.ViewHolder {
        TextView mTextView;
        Demo2Adapter mAdapter;

        VH(View view, Demo2Adapter adapter) {
            super(view);
            mAdapter = adapter;
            mTextView = (TextView) view.findViewById(R.id.text_view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getLayoutPosition() == 2) {
                        mAdapter.remove(getLayoutPosition());
                    } else {
                        mAdapter.addTitle("test" + getLayoutPosition());
                    }
                }
            });
        }
    }
}
