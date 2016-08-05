package com.roy.materialdemo;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView        mRecyclerView;
    //CardView     mCardView;
    ArrayList<ItemBean> mDatas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout col = (CollapsingToolbarLayout) findViewById(R.id.col_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        col.setTitleEnabled(false);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);
        mDatas = getDatas();

        RecyclerAdapter adapter = new RecyclerAdapter(this, mDatas);

        mRecyclerView.setAdapter(adapter);
    }


    private ArrayList<ItemBean> getDatas() {
        ArrayList<ItemBean> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                ItemBean item = new ItemBean();
                item.id = i;
                item.text = "New name " + i;
                item.img = "http://ww1.sinaimg.cn/mw600/66b3de17gw1f6i4i6bsaqj20eq0bhgmh.jpg";
                list.add(item);
            } else if (i % 3 == 0) {
                ItemBean item = new ItemBean();
                item.id = i;
                item.text = "Second name " + i;
                item.img = "http://ww2.sinaimg.cn/mw600/66b3de17gw1f6i4ebtgezj20ei0lwwhg.jpg";
                list.add(item);
            } else if (i % 5 == 0) {
                ItemBean item = new ItemBean();
                item.id = i;
                item.text = "Hot Girl " + i;
                item.img = "http://ww1.sinaimg.cn/mw600/66b3de17gw1f6hjgyzqmaj20gs0gsdgy.jpg";
                list.add(item);
            } else if (i % 7 == 0) {
                ItemBean item = new ItemBean();
                item.id = i;
                item.text = "beauty Girl " + i;
                item.img = "http://ww4.sinaimg.cn/mw600/6e5b2895gw1f6gaaea20pj20go0m1dk7.jpg";
                list.add(item);
            }
        }
        return list;
    }

}
