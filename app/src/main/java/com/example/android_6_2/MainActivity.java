package com.example.android_6_2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private SQLiteDatabase database;
    private Button btnShowDB;
    private ListView listDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowDB = (Button) findViewById(R.id.btnShowDB);
        listDB = (ListView) findViewById(R.id.listDB);
        dbHelper = new DBHelper(this);
        try {
            database = dbHelper.getWritableDatabase();
        }catch (SQLException e){
            throw e;
        }

    }

    public void onClick(View view){
        ArrayList<HashMap<String,String>> persons = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM persons", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            HashMap person = new HashMap<>();
            person.put("name", cursor.getString(1));
            person.put("achievement",cursor.getString(2));
            persons.add(person);
            cursor.moveToNext();
        }
        cursor.close();

        SimpleAdapter adapter = new SimpleAdapter(this, persons,R.layout.listview_item,
                new String[]{"name","achievement"},
                new int[]{R.id.textPerson, R.id.textAchievement});
        listDB.setAdapter(adapter);
    }
    public void onClick2(View view){
        ArrayList<HashMap<String,String>> persons = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM actress", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            HashMap person = new HashMap<>();
            person.put("name", cursor.getString(1));
            person.put("achievement",cursor.getString(2));
            persons.add(person);
            cursor.moveToNext();
        }
        cursor.close();

        SimpleAdapter adapter = new SimpleAdapter(this, persons,R.layout.listview_item,
                new String[]{"name","achievement"},
                new int[]{R.id.textPerson, R.id.textAchievement});
        listDB.setAdapter(adapter);
    }
    public void onClick3(View view){
        ArrayList<HashMap<String,String>> persons = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM actors", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            HashMap person = new HashMap<>();
            person.put("name", cursor.getString(1));
            person.put("achievement",cursor.getString(2));
            persons.add(person);
            cursor.moveToNext();
        }
        cursor.close();

        SimpleAdapter adapter = new SimpleAdapter(this, persons,R.layout.listview_item,
                new String[]{"name","achievement"},
                new int[]{R.id.textPerson, R.id.textAchievement});
        listDB.setAdapter(adapter);
    }
}