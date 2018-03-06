package com.example.dell.l_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterActivity extends AppCompatActivity {
    private ListView listView;
    private List<Map<String,Object>> mylist;
    private SimpleAdapter simpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
        listView=(ListView)findViewById(R.id.list_view);
        initdata();
        simpleAdapter=new SimpleAdapter(this,mylist,R.layout.list_item,new String[]{"image",
                "title","price","major","minor","pick"},new int[]{R.id.iv_menu,R.id.tv_title,
                R.id.tv_price,R.id.tv_major_material,R.id.tv_minor_material,R.id.cb_pick});
        listView.setAdapter(simpleAdapter);
    }

    private void initdata() {
        int[] images = {R.drawable.gongbaojiding, R.drawable.shuizhuroupian,
                R.drawable.xihucuyu, R.drawable.yuxiangrousi,
                R.drawable.suanlajidantang};
        String[] titles = {"宫保鸡丁", "水煮肉片", "西湖醋鱼", "鱼香肉丝", "酸辣鸡蛋汤"};
        String[] price = {"29.9", "39.0", "38.9", "26.9", "16.9"};
        String[] majorMaterial = {"主料：鸡胸肉 黄瓜 胡萝卜 花生米",
                "主料：猪里脊肉 大白菜",
                "主料：草鱼",
                "主料：猪里脊肉 胡萝卜 青椒",
                "主料：西红柿 肉末 木耳 豆腐  "};
        String[] minorMaterial = {"辅料：葱 姜 花椒 红干辣椒 蒜 酱油 盐 糖 醋 味精 淀粉 白胡椒粉",
                "辅料：油 盐 糖 料酒 淀粉 辣椒 鸡蛋 葱 姜 蒜 鸡精 韩式辣椒酱",
                "辅料：盐 生抽 大红浙醋 绍兴黄酒 糖 姜末 水淀粉 白胡椒粉",
                "辅料：葱末 姜丝 蒜末 豆瓣酱 甜面酱 醋 白糖 胡椒粉 植物油 生抽",
                "辅料：盐 鸡精 胡椒粉 老抽 陈醋"};
        mylist=new ArrayList<Map<String,Object>>();
        for(int  i=0;i<5;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("image",images[i]);
            map.put("title",titles[i]);
            map.put("price",price[i]);
            map.put("major",majorMaterial[i]);
            map.put("minor",minorMaterial[i]);
            map.put("pick",false);
            mylist.add(map);
        }
    }
}
