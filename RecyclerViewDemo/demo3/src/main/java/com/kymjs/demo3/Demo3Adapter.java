package com.kymjs.demo3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kymjs.view.recycler.data.Data;
import com.kymjs.view.recycler.data.DataUtils;

import java.util.ArrayList;

/**
 * Created by ZhangTao on 7/4/16.
 */
public class Demo3Adapter extends RecyclerView.Adapter<Demo3Adapter.VH> {

    private final Context mContext;
    private ArrayList<Data> mTitles;

    public Demo3Adapter(Context context) {
        ArrayList<Data> datas = DataUtils.getDatas();
        if (datas == null) {
            datas = new ArrayList<>();
        }
        mTitles = datas;
        mContext = context;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH(View.inflate(mContext, R.layout.item_text3, null), this);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.mTextView.setText(mTitles.get(position).getNum());
    }

    @Override
    public int getItemCount() {
        return mTitles.size();
    }

    /**
     * 返回值设置为int类型,可以做多种类型的支持,若只想支持两种状态,也可以是boolean
     */
    public int isFeatureItem(int position) {
        if (position % 4 == 0) {
            return 1;
        } else {
            return 0;
        }
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
        Demo3Adapter mAdapter;

        VH(View view, Demo3Adapter adapter) {
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
