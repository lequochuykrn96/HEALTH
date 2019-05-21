package com.example.fg;

import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Messenger;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private DrawerLayout hienthi;
    private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hienthi = (DrawerLayout) findViewById(R.id.drawer);
//        Item Menu
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//        Menu
        mToggle = new ActionBarDrawerToggle(this,hienthi,R.string.open,R.string.close);
        hienthi.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        click item
        if (savedInstanceState == null){
        getSupportFragmentManager().beginTransaction().replace(R.id.Nen,
                new Exercises()).commit();
        navigationView.setCheckedItem(R.id.baitap);}
    }
//    Item list
        @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.baitap:
                getSupportFragmentManager().beginTransaction().replace(R.id.Nen,
                        new Exercises()).commit();
                break;
            case R.id.lichtap:
                getSupportFragmentManager().beginTransaction().replace(R.id.Nen,
                        new ThoiGian()).commit();
                break;
            case R.id.anuong:
                getSupportFragmentManager().beginTransaction().replace(R.id.Nen,
                        new Eating()).commit();
                break;
        }
        hienthi.closeDrawer(GravityCompat.START);
        return true;

        }
//    Menu list
        public boolean onOptionsItemSelected (MenuItem item){
            if (mToggle.onOptionsItemSelected(item)) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
}
