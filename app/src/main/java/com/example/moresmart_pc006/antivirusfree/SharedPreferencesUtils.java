package com.example.moresmart_pc006.antivirusfree;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import java.util.Map;
import java.util.Set;

/**
 * Created by MoreSmart-PC006 on 2016/9/30.
 */
public class SharedPreferencesUtils {

    public final static String SP_NAME = "config";
    private static SharedPreferences sp;

    //保存bool类型的数据
    public static void  saveBoolean(Context context,String key, boolean value)
    {
        if( sp == null )
            sp = context.getSharedPreferences( SP_NAME, 0);
        sp.edit().putBoolean(key,value).commit();

    }

    public static void saveString( Context context, String key, String value )
    {
        if( sp == null )
            sp = context.getSharedPreferences( SP_NAME, 0);
        sp.edit().putString(key,value).commit();
    }
    public static void saveInt( Context context, String key, int value )
    {
        if( sp == null )
            sp = context.getSharedPreferences( SP_NAME, 0);
        sp.edit().putInt(key,value).commit();
    }

    public static boolean  getBoolean(Context context,String key, boolean value)
    {
        if( sp == null )
            sp = context.getSharedPreferences( SP_NAME, 0);
        return sp.getBoolean(key,value);

    }

    public static String getString( Context context, String key, String value )
    {
        if( sp == null )
            sp = context.getSharedPreferences( SP_NAME, 0);
        return sp.getString( key, value);
    }


}
