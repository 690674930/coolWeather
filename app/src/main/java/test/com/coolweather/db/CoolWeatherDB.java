package test.com.coolweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import test.com.coolweather.model.City;
import test.com.coolweather.model.County;
import test.com.coolweather.model.Province;

/**
 * Created by Yang on 2015/11/26.
 */
public class CoolWeatherDB {
    public static final  String DB_NAME="COOL_WEATHER";
    public static final  int DB_VERSION=1;
    private static CoolWeatherDB coolWeatherDB;
    private SQLiteDatabase db;

    private CoolWeatherDB(Context context){
        CoolWeatherOpenHelper dbHelper= new CoolWeatherOpenHelper(context,DB_NAME,null,DB_VERSION);
        db=dbHelper.getReadableDatabase();
    }

    public synchronized static CoolWeatherDB getInstance(Context context){
        if (coolWeatherDB==null){
            coolWeatherDB=new CoolWeatherDB(context);
        }
        return coolWeatherDB;
    }


    public void SaveProvince(Province province){
     if (null !=province){
         ContentValues contentValues = new ContentValues();
         contentValues.put("province_name",province.getProvinceName());
         contentValues.put("province_pyName",province.getProvincePyName());
         db.insert("Province",null,contentValues);
     }
    }

    public void SaveCity(City city){
        if (null !=city){
            ContentValues contentValues = new ContentValues();
            contentValues.put("city_name",city.getCityName());
            contentValues.put("city_pyName",city.getCityPyName());
            db.insert("City",null,contentValues);
        }
    }


    public void SaveCounty(County county){
        if (null !=county){
            ContentValues contentValues = new ContentValues();
            contentValues.put("county_name",county.getCountyName());
            contentValues.put("county_pyName",county.getCountPyName());
            db.insert("County",null,contentValues);
        }
    }


    public List<Province> LoadProvince() {
        List<Province> list = new ArrayList<Province>();
        Cursor cursor=db.query("Province",null,null,null,null,null,null);
        if (cursor.moveToNext()){
            do {
                Province province=new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProvincePyName(cursor.getString(cursor.getColumnIndex("province_pyName")));
                list.add(province);
            }while (cursor.moveToFirst());
        }
       return list;
    }

    public List<City> LoadCity(int provinceId) {
        List<City> list = new ArrayList<City>();
        Cursor cursor=db.query("City",null,"province_id=?",new String[]{String.valueOf(provinceId)},null,null,null);
        if (cursor.moveToNext()){
            do {
                City city=new City();
                city.setId(cursor.getInt(cursor.getColumnIndex("id")));
                city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
                city.setCityPyName(cursor.getString(cursor.getColumnIndex("city_pyName")));
                city.setProvinceId(provinceId);
                list.add(city);
            }while (cursor.moveToFirst());
        }
        return list;
    }

    public List<County> LoadCounty(int cityId) {
        List<County> list = new ArrayList<County>();
        Cursor cursor=db.query("County",null,"city_id=?",new String[]{String.valueOf(cityId)},null,null,null);
        if (cursor.moveToNext()){
            do {
                County county=new County();
                county.setId(cursor.getInt(cursor.getColumnIndex("id")));
                county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
                county.setCountPyName(cursor.getString(cursor.getColumnIndex("county_pyName")));
                county.setCityId(cityId);
                list.add(county);
            }while (cursor.moveToFirst());
        }
        return list;
    }






}
