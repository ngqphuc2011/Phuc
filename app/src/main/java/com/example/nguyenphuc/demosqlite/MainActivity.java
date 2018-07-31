package com.example.nguyenphuc.demosqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
    }

    private void loadData() {
        ProductManager manager = new ProductManager(MainActivity.this);
        ArrayList<Product> lstProd = manager.read();

        String arrProd[] = new String[lstProd.size()];
        for (int i = 0; i < arrProd.length; i++) {
            arrProd[i] = lstProd.get(i).name;
        }

        ListView listView = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrProd);
        listView.setAdapter(adapter);
    }
}
