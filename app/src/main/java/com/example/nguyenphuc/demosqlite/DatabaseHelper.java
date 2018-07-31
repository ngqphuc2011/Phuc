package com.example.nguyenphuc.demosqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "shop.sqlite";
    private static final int DATABASE_VERSION = 1;

    private String TBLPRODUCT = "CREATE TABLE product (\n" +
            "    id        INTEGER      PRIMARY KEY AUTOINCREMENT,\n" +
            "    name      VARCHAR (32) NOT NULL,\n" +
            "    quantity  INTEGER,\n" +
            "    price     DOUBLE       DEFAULT (0),\n" +
            "    inputdate DATE\n" +
            ");\n";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Phương thức sẽ được gọi lần đầu tiên khi cài đặt ứng dụng hoặc khi csdl không tồn tại
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng Product
        db.execSQL(TBLPRODUCT);

        String sqlin = "INSERT INTO product(name, quantity, price, inputdate) VALUES (?, ?, ?, ?)";
        db.execSQL(sqlin);

//        sqlin = "INSERT INTO product(name, quantity, price, inputdate) VALUES ('Man hinh', 8, 22000, '2018-03-05')";
//        db.execSQL(sqlin);
    }

    /**
     * Được gọi khi ứng dụng trên thiết bị (của người dùng) có tồn tại csdl X NHƯNG sai khác phiên bản thì gọi để thực hiện nâng cấp CSDL
     * @param sqLiteDatabase
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
