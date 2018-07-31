package com.example.nguyenphuc.demosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ProductManager {
    Context mContext;
    SQLiteDatabase mDB;

    public ProductManager(Context mContext) {
        this.mContext = mContext;
        //Khởi tạo DatabaseHelper để kết nối CSDL
        DatabaseHelper helper = new DatabaseHelper(mContext);
        //Từ Helper lấy đối tượng SQLiteDatabase để thao tác với dữ liệu
        mDB = helper.getWritableDatabase();
    }

    public ArrayList<Product> read() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product";
        Cursor cursor = mDB.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int quantity = cursor.getInt(2);
            double price = cursor.getDouble(3);
            String date = cursor.getString(4);

            Product p = new Product(id, name, quantity, price, date);
            list.add(p);
        }

        return list;
    }

    public void create(Product prod){
        // Có thể dùng ContentValue
        String sql = "INSERT INTO product(name, quantity, price, inputdate) VALUES ('"+prod.name+"', "+prod.quantity+", "+prod.price+", "+prod.inputdate+")";
        //Thực thi lệnh sql
        mDB.execSQL(sql);

    }

    public void update(Product p){

    }

    public void delete(int id){

    }
}
