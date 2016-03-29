package com.hakerjack.crackthecodinginterview;

import android.content.Context;
import android.util.Log;

import com.hakerjack.crackthecodinginterview.data.Problem;
import com.hakerjack.crackthecodinginterview.util.SharedPrefsUtil;
import com.orm.SugarApp;
import com.pixplicity.easyprefs.library.Prefs;

/**
 * Created by kjia on 3/26/16.
 */
public class MyApplication extends SugarApp {
    private Context mApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationContext = getApplicationContext();

        // Init SharedPrefs
        new Prefs.Builder()
                .setContext(mApplicationContext)
                .setPrefsName(getPackageName())
                .setMode(MODE_PRIVATE)
                .setUseDefaultSharedPreference(true)
                .build();

        boolean isFirstTime = Prefs.getBoolean(SharedPrefsUtil.PREFS_KEY_IS_FIRST_TIME, true);
        if (isFirstTime) {
            setUpDatabaseData();
        } else {
            Log.i("KJ", "first time false");
        }
    }

    private void setUpDatabaseData() {
        Problem p1 = new Problem.Builder()
                .setTitle("Number of Islands")
                .setContent("Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.")
                .build();
        long id = p1.save();

        Prefs.putBoolean(SharedPrefsUtil.PREFS_KEY_IS_FIRST_TIME, false);
    }
}
