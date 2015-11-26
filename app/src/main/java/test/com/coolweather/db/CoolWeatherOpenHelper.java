package test.com.coolweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Yang on 2015/11/26.
 */
public class CoolWeatherOpenHelper extends SQLiteOpenHelper {

    //create province table sql
    public static final  String CREATE_PROVINCE="create table Province ("
            + "id integer primary key autoincrement, "
            + "province_name text, "
            + "province_pyName text)";

    //create city table sql
    public static final  String CREATE_CITY="create table City ("
            + "id integer primary key autoincrement, "
            + "city_name text, "
            + "city_pyName text, "
            + "province_id integer)";
    //create county table sql
    public static final  String CREATE_COUNTY="create table County ("
            + "id integer primary key autoincrement, "
            + "county_name text, "
            + "county_pyName text, "
            + "city_id integer)";


    public CoolWeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROVINCE);
        db.execSQL(CREATE_CITY);
        db.execSQL(CREATE_COUNTY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
