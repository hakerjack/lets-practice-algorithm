package com.hakerjack.crackthecodinginterview.ui.activity;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.hakerjack.crackthecodinginterview.R;
import com.hakerjack.crackthecodinginterview.ui.adapter.SidebarAdapter;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private LinearLayout mMainContainer;
    //private ListView mSidebarListView;
    private ImageView mSidebarIcon;
    private ImageView mInfoIcon;

    private SidebarAdapter mSidebarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setUpDrawer();
    }

    private void initViews() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mMainContainer = (LinearLayout) findViewById(R.id.main_container);
        //mSidebarListView = (ListView) findViewById(R.id.sidebar);

        mSidebarIcon = (ImageView) mMainContainer.findViewById(R.id.sidebar_menu_icon);
        mInfoIcon = (ImageView) mMainContainer.findViewById(R.id.info_icon);
    }

    private void setUpDrawer() {
        //mSidebarAdapter = new SidebarAdapter(this);
        //mSidebarListView.setAdapter(mSidebarAdapter);
        mSidebarIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }


}
