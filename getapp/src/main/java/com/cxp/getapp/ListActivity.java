package com.cxp.getapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * 文 件 名: ListActivity
 * 创 建 人: CXP
 * 创建日期: 2017-04-08 18:19
 * 描    述: 列表页面
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class ListActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    private static List<AppInfo> mDatas;

    private Context mContext;
    private ListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mRecyclerView= (RecyclerView) findViewById(R.id.list_recyclerview);

        mContext=this;
        adapter=new ListAdapter(mContext,mDatas);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);

    }

    //页面跳转
    public static void startActivity(Context context, List<AppInfo> appList) {
        Intent intent = new Intent(context, ListActivity.class);
        mDatas = appList;
        context.startActivity(intent);

    }
}
