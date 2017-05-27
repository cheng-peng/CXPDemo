package com.cxp.getapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * 文 件 名: ListAdapter
 * 创 建 人: CXP
 * 创建日期: 2017-04-08 18:27
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private Context mContext;
    private List<AppInfo> mDatas;

    public ListAdapter(Context mContext, List<AppInfo> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListViewHolder holder = new ListViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_item_list, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, final int position) {
        holder.imgIcon.setImageDrawable(mDatas.get(position).appIcon);
        holder.tvName.setText(mDatas.get(position).appName);
        holder.tvPackName.setText(mDatas.get(position).packageName);

        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(mDatas.get(position).intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        LinearLayout ll;
        ImageView imgIcon;
        TextView tvName;
        TextView tvPackName;


        public ListViewHolder(View itemView) {
            super(itemView);
            ll= (LinearLayout) itemView.findViewById(R.id.item_list_ll);
            imgIcon = (ImageView) itemView.findViewById(R.id.item_list_img);
            tvName = (TextView) itemView.findViewById(R.id.item_list_name);
            tvPackName = (TextView) itemView.findViewById(R.id.item_list_packname);
        }
    }
}
