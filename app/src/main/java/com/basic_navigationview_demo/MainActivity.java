package com.basic_navigationview_demo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SONU on 21/03/16.
 */
public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;
    private FragmentManager fragmentManager;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //according to boolean value set content view
        setContentView(R.layout.activity_main);
        initViews();
        setUpHeaderView();
        onMenuItemSelected();

        //At start check home menu if required
        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.home);
        }
    }

    /*  Init all views  */
    private void initViews() {
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.slider_menu);
        fragmentManager = getSupportFragmentManager();
        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout, toolbar, // nav menu toggle icon
                R.string.drawer_open, // nav drawer open - description for
                // accessibility
                R.string.drawer_close // nav drawer close - description for
                // accessibility
        ) {
            public void onDrawerClosed(View view) {
            }

            public void onDrawerOpened(View drawerView) {

            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggle
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    /**
     * For using header view use this method
     **/
    private void setUpHeaderView() {
        View headerView = navigationView.inflateHeaderView(R.layout.header_view);
        TextView textOne = headerView.findViewById(R.id.username);
        TextView textTwo = headerView.findViewById(R.id.email_address);
    }


    /*  Method for Navigation View item selection  */
    private void onMenuItemSelected() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                //Check and un-check menu item if they are checkable behaviour
                if (item.isCheckable()) {
                    if (item.isChecked()) item.setChecked(false);
                    else item.setChecked(true);
                }

                //Closing drawer on item click
                mDrawerLayout.closeDrawers();

                switch (item.getItemId()) {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "You Clicked on \"" + item.getTitle().toString() + "\" menu item.", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.my_account:
                        Toast.makeText(MainActivity.this, "You Clicked on \"" + item.getTitle().toString() + "\" menu item.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.chat:
                        Toast.makeText(MainActivity.this, "You Clicked on \"" + item.getTitle().toString() + "\" menu item.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.notifications:
                        Toast.makeText(MainActivity.this, "You Clicked on \"" + item.getTitle().toString() + "\" menu item.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.share_app:
                        Toast.makeText(MainActivity.this, "You Clicked on \"" + item.getTitle().toString() + "\" menu item.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rate_app:
                        Toast.makeText(MainActivity.this, "You Clicked on \"" + item.getTitle().toString() + "\" menu item.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settings:
                        Toast.makeText(MainActivity.this, "You Clicked on \"" + item.getTitle().toString() + "\" menu item.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.help:
                        Toast.makeText(MainActivity.this, "You Clicked on \"" + item.getTitle().toString() + "\" menu item.", Toast.LENGTH_SHORT).show();
                        break;

                }

                return false;
            }
        });
    }

    //On back press check if drawer is open and closed
    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START))
            mDrawerLayout.closeDrawers();
        else
            super.onBackPressed();
    }
}
