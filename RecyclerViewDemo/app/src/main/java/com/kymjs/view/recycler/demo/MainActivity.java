package com.kymjs.view.recycler.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kymjs.view.recycler.data.DataUtils;

public class MainActivity extends Activity {

    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new GridLayoutManager(this, 3));
//        recyclerview.setLayoutManager(new LinearLayoutManager(this,
//                LinearLayoutManager.VERTICAL, false));
//        recyclerview.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));

        recyclerview.setAdapter(new DemoAdapter(this, DataUtils.getDatas()));
    }
}
