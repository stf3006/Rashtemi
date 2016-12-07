package com.example.alex.rashtemirestaurant;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Rashtemir.db";
    private static final String TABLE_CLIENTS = "clients";
    private static final String TABLE_MENU = "menu";
    private static final String TABLE_CATEGORIES = "categories";
    private static final String TABLE_ADDRESSES = "addresses";
    private static final String TABLE_LOCATIONS = "locations";
    private static final String TABLE_ORDERS = "orders";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // CREATE CLIENTS TABLE
        db.execSQL("CREATE TABLE " + TABLE_CLIENTS +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "phone TEXT NOT NULL, " +
                "username TEXT NOT NULL, " +
                "password TEXT NOT NULL)");

        // CREATE CATEGORIES TABLE
        db.execSQL("CREATE TABLE " + TABLE_CATEGORIES +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "category TEXT NOT NULL)");

        // POPULATE CATEGORIES TABLE WITH DATA
        db.execSQL("INSERT INTO " + TABLE_CATEGORIES + " (category) VALUES (\"Breakfast\")"); // 1
        db.execSQL("INSERT INTO " + TABLE_CATEGORIES + " (category) VALUES (\"Pizza\")"); // 2
        db.execSQL("INSERT INTO " + TABLE_CATEGORIES + " (category) VALUES (\"Main dishes\")"); // 3
        db.execSQL("INSERT INTO " + TABLE_CATEGORIES + " (category) VALUES (\"Side dishes\")"); // 4
        db.execSQL("INSERT INTO " + TABLE_CATEGORIES + " (category) VALUES (\"Sandwiches\")"); // 5
        db.execSQL("INSERT INTO " + TABLE_CATEGORIES + " (category) VALUES (\"Pasta\")"); // 6
        db.execSQL("INSERT INTO " + TABLE_CATEGORIES + " (category) VALUES (\"Desserts\")"); // 7
        db.execSQL("INSERT INTO " + TABLE_CATEGORIES + " (category) VALUES (\"Beverages\")"); // 8

        // CREATE MENU TABLE
        db.execSQL("CREATE TABLE " + TABLE_MENU +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "price INTEGER NOT NULL, " +
                "category INTEGER NOT NULL, " +
                "weight INTEGER NOT NULL, " +
                "FOREIGN KEY(category) REFERENCES categories(id))");

        // POPULATE MENU TABLE WITH DATA
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Pizza Classic\", 28, 2, 450)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Pizza Quattro Formaggi\", 34, 2, 450)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Pizza Quattro Stagioni\", 27, 2, 450)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Pizza Primavera\", 30, 2, 450)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Pizza Diavola\", 29, 2, 450)");

        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Eggs Benedict\", 24, 1, 250)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"American Breakfast\", 25, 1, 350)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"American Pancakes\", 17, 1, 200)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"English Breakfast\", 28, 1, 350)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Sunny Side Up Eggs\", 14, 1, 250)");

        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Black Angus Burger\", 38, 3, 550)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"NY City Steak\",60, 3, 450)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Hot Chicken Wings\", 32, 3, 400)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Chicken Strips\", 27, 3, 300)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Fish and Chips\", 36, 3, 400)");

        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"French Fries\", 8, 4, 150)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Mashed Potatoes\", 9, 4, 150)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Green Salad\", 10, 4, 150)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Onion Rings\", 9, 4, 150)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Homemade Buns\", 5, 4, 100)");

        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Grilled Cheese\", 19, 5, 350)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"BBQ Pulled Pork\", 25, 5, 350)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Turkey Club\", 24, 5, 350)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Tuna Fantasy\", 27, 5, 300)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Chicken and Bacon\", 24, 5, 300)");


        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Pasta Carbonara\", 28, 6, 300)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Spaghetti Bolognese\", 28, 6, 350)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Pappardelle with Parmesan\", 30, 6, 300)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Fettuccine Alfredo\", 29, 6, 350)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Gnocchi with Pesto\", 27, 6, 350)");

        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Special Cheesecake\", 17, 7, 150)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Cherry Pie\", 28, 14, 200)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Chocolate Cake\", 15, 7, 180)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Caramel Cake\", 16, 7, 150)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Homemade Ice Cream\", 14, 7, 180)");

        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Coke\", 6, 8, 250)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Diet Coke\", 6, 8, 250)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Sprite\", 6, 8, 250)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Fanta\", 6, 8, 250)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Lemonade\", 1, 8, 250)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Berry Lemonade\", 12, 8, 250)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Tonic Water\", 6, 8, 250)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Still Water\", 7, 8, 250)");
        db.execSQL("INSERT INTO " + TABLE_MENU + " (name, price, category, weight) VALUES " +
                "(\"Gas Water\", 6, 8, 250)");


        // CREATE ADDRESSES TABLE
        db.execSQL("CREATE TABLE " + TABLE_ADDRESSES +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "clientid INTEGER NOT NULL, " +
                "address TEXT NOT NULL, " +
                "FOREIGN KEY(clientid) REFERENCES clients(id))");

        // CREATE LOCATIONS TABLE
        db.execSQL("CREATE TABLE " + TABLE_LOCATIONS +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "lat REAL NOT NULL, " +
                "long REAL NOT NULL, " +
                "address TEXT NOT NULL)");

        // POPULATE LOCATIONS TABLE WITH DATA
        db.execSQL("INSERT INTO " + TABLE_LOCATIONS + " (lat, long, address) VALUES (23.24, 55.25, \"Bl. Regina Elisabeta, Nr. 3-5\")");


        // CREATE ORDERS TABLE
        db.execSQL("CREATE TABLE " + TABLE_ORDERS +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "clientid INTEGER NOT NULL, " +
                "addressid INTEGER NOT NULL, " +
                "ordertext TEXT NOT NULL, " +
                "FOREIGN KEY(clientid) REFERENCES clients(id), " +
                "FOREIGN KEY(addressid) REFERENCES addresses(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADDRESSES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MENU);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENTS);

        onCreate(db);
    }

    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CATEGORIES, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            categories.add(new Category(cursor.getString(1), cursor.getInt(0)));
            cursor.moveToNext();
        }

        return categories;
    }

    public ArrayList<Product> getAllProductsByCategoryId(int categoryId) {
        ArrayList<Product> products = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_MENU + " WHERE category=" + categoryId, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            products.add(new Product(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4)));
            cursor.moveToNext();
        }

        return products;
    }

    public boolean login(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CLIENTS + " WHERE username='" + username + "' AND password='" + password + "'", null);
        cursor.moveToFirst();

        if(cursor.isAfterLast()) {
            return false;
        } else {
            return true;
        }
    }
}
