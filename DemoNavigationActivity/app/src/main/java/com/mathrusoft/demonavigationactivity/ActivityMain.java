package com.mathrusoft.demonavigationactivity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mathrusoft.demonavigationactivity.fragment.FragmentCamera;
import com.mathrusoft.demonavigationactivity.fragment.FragmentGallery;
import com.mathrusoft.demonavigationactivity.fragment.FragmentSettings;
import com.mathrusoft.demonavigationactivity.fragment.FragmentSlideShow;
import com.mathrusoft.demonavigationactivity.fragment.FragmentStudentList;

public class ActivityMain extends AppCompatActivity {

    Context mContex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContex = this.getApplicationContext();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivityMain.this, "Fab clicked ", Toast.LENGTH_SHORT).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(mNavigationItemSelectedListener);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    NavigationView.OnNavigationItemSelectedListener mNavigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.nav_camera) {
                changeFragment(new FragmentCamera());
                Toast.makeText(mContex, "Camera clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_gallery) {
                changeFragment(new FragmentGallery());
                Toast.makeText(mContex, "nav_gallery clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_slideshow) {
                changeFragment(new FragmentSlideShow());
                Toast.makeText(mContex, "nav_slideshow clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_manage) {
                changeFragment(new FragmentSettings());
                Toast.makeText(mContex, "nav_manage clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_share) {
                Toast.makeText(mContex, "nav_share clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_send) {
                Toast.makeText(mContex, "nav_send clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_student_list){
                getSupportActionBar().setTitle("Student list");
                changeFragment(new FragmentStudentList());
            }



            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    };


    private void changeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_holder, fragment);
        fragmentTransaction.commit();
    }


}
