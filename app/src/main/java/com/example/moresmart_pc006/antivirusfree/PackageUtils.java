package com.example.moresmart_pc006.antivirusfree;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by MoreSmart-PC006 on 2016/9/13.
 */
public class PackageUtils {

    /**
     * 返回版本号
     * @param context
     * @return
     */

    public static String getVersionName(Context context )
    {
        try {

            PackageManager packageManager =  context.getPackageManager();

            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(),0);

            String versionName = packageInfo.versionName;

            return versionName;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取本地的版本号
     * @param context
     * @return
     */
    public static int getVersionCode( Context context)
    {
        try {
            PackageManager packageManager = context.getPackageManager();

            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(),0);

            int versionCode = packageInfo.versionCode;
            return versionCode;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }

}
