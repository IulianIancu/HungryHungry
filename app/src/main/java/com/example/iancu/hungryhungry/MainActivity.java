package com.example.iancu.hungryhungry;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.iancu.hungryhungry.fragments.RestaurantContent;
import com.example.iancu.hungryhungry.fragments.RestaurantList;
import com.example.iancu.hungryhungry.fragments.UserProfile;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        RestaurantList.OnFragmentInteractionListener,
        RestaurantContent.OnFragmentInteractionListener {
    @BindView(R.id.mySearchView)
    SearchView search;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    Menu menu;
    RestaurantList list;
//    @BindView(R.id.content_frame)
//    FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list = new RestaurantList();
                FragmentTransaction fm2 = getSupportFragmentManager().beginTransaction();
                fm2.replace(R.id.content_frame, list);
                fm2.commit();
            }
        });

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        CircleImageView myFace = (CircleImageView) header.findViewById(R.id.imageView);
        myFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserProfile profile = new UserProfile();
                FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.content_frame, profile);
                fm.commit();
                drawer.closeDrawer(GravityCompat.START);
            }
        });


//        UserProfile profile =new UserProfile();
//        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
//        fm.replace(R.id.content_frame,profile);
//        fm.commit();

        list = new RestaurantList();
        FragmentTransaction fm2 = getSupportFragmentManager().beginTransaction();
        fm2.replace(R.id.content_frame, list);
        fm2.commit();

//        RestaurantContent content =new RestaurantContent();
//        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
//        fm.replace(R.id.content_frame,content);
//        fm.commit();


        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                list.setTest(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        menu = navigationView.getMenu();
        menu.clear();
        menu.add("Specific Restaurant");


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
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        String id = item.getTitle().toString();
        if (id.equals("Specific Restaurant")) {
            RestaurantContent content = new RestaurantContent();
            FragmentTransaction fm3 = getSupportFragmentManager().beginTransaction();
            fm3.replace(R.id.content_frame, content);
            fm3.commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(int x) {
        Log.i("DUDUDU", "" + x);
    }

    @Override
    public void onFragmentInteraction() {

    }
}
