package com.example.daniel.listview_lab2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by daniel on 4/6/2017.
 */

public class MainActivity extends Activity {
    private ListView lvProduct;
    private ProductListAdapter adapter;
    private List<Group> mProductList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProduct = (ListView)findViewById(R.id.listview_product);

        mProductList = new ArrayList<>();
        //Add sample data for list
        //We can get data from DB, webservice here
        mProductList.add(new Group(1, "grupo1", 200));
        mProductList.add(new Group(2, "grupo2", 250));
        mProductList.add(new Group(3, "grupo3", 300));
        mProductList.add(new Group(4, "grupo4", 350));

        //Init adapter
        adapter = new ProductListAdapter(getApplicationContext(), mProductList);
        lvProduct.setAdapter(adapter);

        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Do something
                //Ex: display msg with product id get from view.getTag
                Toast.makeText(getApplicationContext(), "Clicked product id =" + view.getTag(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
