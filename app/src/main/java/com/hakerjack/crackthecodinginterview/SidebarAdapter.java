package com.hakerjack.crackthecodinginterview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by kjia on 3/5/16.
 */
public class SidebarAdapter extends ArrayAdapter<String> {
    private static final int ITEM_ROW_RESOURCE_ID = R.layout.sidebar_item_row;
    private static final String[] DEFAULT_SECTION_TITLES = {"See All Questions", "Settings"};

    public SidebarAdapter(Context context) {
        super(context, ITEM_ROW_RESOURCE_ID, DEFAULT_SECTION_TITLES);
    }

    public SidebarAdapter(Context context, @LayoutRes int resource, @NonNull String[] sectionItems) {
        super(context, resource, sectionItems);
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//
//        }
//    }
}
