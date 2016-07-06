package com.kymjs.sample;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.kymjs.recycler.Divider;

public class Demo4Activity extends Activity {

    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
//        recyclerview.setLayoutManager(new GridLayoutManager(this, 3));
//        recyclerview.setLayoutManager(new LinearLayoutManager(this,
//                LinearLayoutManager.VERTICAL, false));
        recyclerview.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));

        Divider divider = new Divider(new ColorDrawable(0xffff0000), OrientationHelper.VERTICAL);
        //单位:px
        divider.setMargin(50, 50, 50, 50);
        divider.setHeight(20);
        recyclerview.addItemDecoration(divider);
        recyclerview.setAdapter(new Demo3Adapter(this));
    }
}
