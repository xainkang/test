package com.example.listview_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    List<Country> countryList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        initView();

    }

    private void initDatas(){


        countryList.add(new Country("删除",R.drawable.shanchu));
        countryList.add(new Country("图片",R.drawable.tupian));
        countryList.add(new Country("添加",R.drawable.tianjia));


    }

    private void initView(){

        listView = (ListView)findViewById(R.id.list_view);

        // 设置适配器
        final SlowCountryAdapter adapter = new SlowCountryAdapter(this,R.layout.item_country,countryList);
//        final CountryAdapter adapter = new CountryAdapter(this,R.layout.item_country,countryList);
        listView.setAdapter(adapter);

        // 设置Item点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),countryList.get(i).getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
