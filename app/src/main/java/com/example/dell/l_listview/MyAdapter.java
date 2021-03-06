package com.example.dell.l_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseAdapter {
    //Alt+Enter
    private List<Map<String,Object>> mylist;
    private Context context;
    public MyAdapter(Context context,List<Map<String,Object>> mylist){
        this.context=context;
        this.mylist=mylist;
    }
    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int position) {
        return mylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.list_item,null);
            viewHolder.ivMenu=(ImageView) convertView.findViewById(R.id.iv_menu);
            viewHolder.tvTitle=(TextView)convertView.findViewById(R.id.tv_title);
            viewHolder.tvMajorMaterial=(TextView) convertView.findViewById(R.id.tv_major_material);
            viewHolder.tvMinorMaterial=(TextView)convertView.findViewById(R.id.tv_minor_material);
            viewHolder.tvPrice=(TextView)convertView.findViewById(R.id.tv_price);
            viewHolder.cbPick=(CheckBox)convertView.findViewById(R.id.cb_pick);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }

        viewHolder.ivMenu.setImageResource((int)mylist.get(position).get("image"));
        viewHolder.tvTitle.setText((String)mylist.get(position).get("title"));
        viewHolder.tvMajorMaterial.setText((String)mylist.get(position).get("major"));
        viewHolder.tvMinorMaterial.setText((String)mylist.get(position).get("minor"));
        viewHolder.tvPrice.setText((String)mylist.get(position).get("price"));
        viewHolder.cbPick.setChecked((boolean)mylist.get(position).get("pick"));

        viewHolder.cbPick.setOnCheckedChangeListener(new MyOnCheckedChangeListener(position));
        return convertView;
    }
    private class ViewHolder{
        ImageView ivMenu;
        TextView tvTitle;
        TextView tvMajorMaterial;
        TextView tvMinorMaterial;
        TextView tvPrice;
        CheckBox cbPick;
    }

    private class MyOnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
        private int postion;

        public MyOnCheckedChangeListener(int position){
            this.postion=position;
        }
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Toast.makeText(context,"信息："+postion+":"+isChecked,Toast.LENGTH_SHORT).show();
        }
    }

}
