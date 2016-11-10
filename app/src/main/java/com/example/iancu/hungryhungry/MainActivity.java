package com.example.iancu.hungryhungry;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.iancu.hungryhungry.fragment.RestaurantContent;
import com.example.iancu.hungryhungry.fragment.RestaurantList;
import com.example.iancu.hungryhungry.fragment.UserProfile;
import com.example.iancu.hungryhungry.interfaces.MainActivityIntf;
import com.example.iancu.hungryhungry.model.Categories;
import com.example.iancu.hungryhungry.model.Category;
import com.example.iancu.hungryhungry.model.NearbyRestaurant;
import com.example.iancu.hungryhungry.model.Restaurant;
import com.example.iancu.hungryhungry.model.ReviewSearch;
import com.example.iancu.hungryhungry.presenter.MainPresenterImpl;
import com.example.iancu.hungryhungry.service.FetchAddressService;
import com.example.iancu.hungryhungry.service.FetchLocationService;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        RestaurantList.OnFragmentInteractionListener,
        RestaurantContent.OnFragmentInteractionListener,
        MainActivityIntf, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {
    @BindView(R.id.mySearchView)
    SearchView search;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    //    @BindView(R.id.fab)
//    FloatingActionButton fab;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    TextView userName;
    TextView userSubtitle;
    Menu menu;
    RestaurantList list;
    MainPresenterImpl presenter;
    List<NearbyRestaurant> theActualList = new ArrayList<>();
    Restaurant managedRestaurant;

    protected GoogleApiClient mGoogleApiClient;
    protected Location mLastLocation;
    private AddressResultReceiver mResultReceiver;
    private LocationResultReceiver mLocationReciever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");


//        Set userName to the correct one
        try {

            View header = navigationView.getHeaderView(0);
            userName = (TextView) header.findViewById(R.id.username);
            userSubtitle =(TextView) header.findViewById(R.id.user_subtitle);
            userName.setText(getIntent().getExtras().getString("TwitName"));
            userSubtitle.setText(getIntent().getExtras().getString("FullName"));

        } catch (Exception e) {
            Log.e("ERROR", e.toString());
        }


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                list = new RestaurantList();
////                FragmentTransaction fm2 = getSupportFragmentManager().beginTransaction();
////                fm2.replace(R.id.content_frame, list);
////                fm2.commit();
//                Log.i("@(O_O)@", "" + theActualList.size());
//                list.setRestaurantList(theActualList);
//            }
//        });

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


//        Get google API going
        mResultReceiver = new AddressResultReceiver(new Handler());
        mLocationReciever = new LocationResultReceiver(new Handler());
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
        if (mGoogleApiClient.isConnected() && mLastLocation != null) {
            startIntentService();
            Log.e("BOOP", "Located");
        }

//        connect the presenter to the activity
        presenter = new MainPresenterImpl(this);
        presenter.getCats(getBaseContext());


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
//                list = new RestaurantList();
//                FragmentTransaction fm2 = getSupportFragmentManager().beginTransaction();
//                fm2.replace(R.id.content_frame, list);
//                fm2.commit();
//                Log.i("EeeeEEEeeE", "call me maybe");
//                presenter.getNearbyRes(mLastLocation, getBaseContext());
                startSecondIntentService(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        menu = navigationView.getMenu();
        menu.clear();


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

    /**
     * Does something when a specific items is clicked
     *
     * @param item
     * @return
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        String id = item.getTitle().toString();
//        if (id.equals("Specific Restaurant")) {
//            RestaurantContent content = new RestaurantContent();
//            getSupportFragmentManager().popBackStack();
//            FragmentTransaction fm3 = getSupportFragmentManager().beginTransaction();
//            fm3.replace(R.id.content_frame, content);
//            fm3.commit();
//        }
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Fragment interaction listener for the restaurant list fragment,
     * gets triggered when the user clicks on a restaurant
     *
     * @param restaurant is the restaurant to be displayed
     */
    @Override
    public void onFragmentInteraction(Restaurant restaurant) {
        Log.i("HAAAAAaaaAAAaaAaAAaAa", restaurant.getName());
        managedRestaurant = restaurant;
        presenter.getReviews(restaurant.getR().getResId(), getBaseContext());
    }

    /**
     * Fragment interaction listener for the Restaurant description fragment
     */
    @Override
    public void onFragmentInteraction() {

    }

    /**
     * Recieves revies from presenter
     * @param reviewSearch
     */
    @Override
    public void recieveReviews(ReviewSearch reviewSearch) {
        RestaurantContent content = new RestaurantContent();
        content.setTheRestaurant(managedRestaurant);
        content.setReviews(reviewSearch);
        getSupportFragmentManager().popBackStack();
        FragmentTransaction fm3 = getSupportFragmentManager().beginTransaction();
        fm3.replace(R.id.content_frame, content);
        fm3.commit();
    }

    /**
     * This method listens to the presenter, and takes the categories of restaurants from it
     *
     * @param cats the categories of restaurants
     */
    @Override
    public void recieveCategories(List<Category> cats) {
        for (Category cat : cats) {
            Categories catt = cat.getCategories();
            menu.add(catt.getName());
        }
    }

    /**
     * This method listens to the presenter and takes the list of restaurants from it
     *
     * @param rests the list of restaurants
     */
    @Override
    public void recieveRestaurants(List<NearbyRestaurant> rests) {
//        for (NearbyRestaurant rest:rests) {
//            Restaurant re= rest.getRestaurant();
//            menu.add(re.getName());
//
//        }
        theActualList = rests;
        list.setRestaurantList(theActualList);


    }

    /**
     * This connects to the google API and returns the location
     *
     * @param bundle
     */
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.e("Boop", "Got Connected");
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation != null) {
            //call request to get nearby restaurants
            presenter.getNearbyRes(mLastLocation, getBaseContext());
            // Determine whether a Geocoder is available.
            if (!Geocoder.isPresent()) {
                Toast.makeText(this, "no_geocoder_available", Toast.LENGTH_LONG).show();
                return;
            }
            // It is possible that the user presses the button to get the address before the
            // GoogleApiClient object successfully connects. In such a case, mAddressRequested
            // is set to true, but no attempt is made to fetch the address (see
            // fetchAddressButtonHandler()) . Instead, we start the intent service here if the
            // user has requested an address, since we now have a connection to GoogleApiClient.

            startIntentService();

//            THIS SENDS ALONG THE LOCATIO TO GET THE RESTAURANTS
//            presenter.getNearbyRes(mLastLocation,getBaseContext());

        }

    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i("WAIT", "Connection suspended");
        mGoogleApiClient.connect();
    }

    /**
     * This starts an intent service that returns the postcode of the current location
     */
    protected void startIntentService() {
        // Create an intent for passing to the intent service responsible for fetching the address.
        Intent intent = new Intent(this, FetchAddressService.class);

        // Pass the result receiver as an extra to the service.
        intent.putExtra(Constants.RECEIVER, mResultReceiver);

        // Pass the location data as an extra to the service.
        intent.putExtra(Constants.LOCATION_DATA_EXTRA, mLastLocation);

        // Start the service. If the service isn't already running, it is instantiated and started
        // (creating a process for it if needed); if it is running then it remains running. The
        // service kills itself automatically once all intents are processed.
        startService(intent);
    }

    /**
     * This starts an intent service that returns the location for a given search()
     */
    protected void startSecondIntentService(String search) {
        // Create an intent for passing to the intent service responsible for fetching the address.
        Intent intent = new Intent(this, FetchLocationService.class);

        // Pass the result receiver as an extra to the service.
        intent.putExtra(Constants.LOCATION_RECEIVER, mLocationReciever);

        // Pass the location data as an extra to the service.
        intent.putExtra(Constants.LOCATION_DATA_ADDRESS, search);

        // Start the service. If the service isn't already running, it is instantiated and started
        // (creating a process for it if needed); if it is running then it remains running. The
        // service kills itself automatically once all intents are processed.
        startService(intent);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.i("OOPS", "Connection failed: " + connectionResult.getErrorCode());
    }

    class AddressResultReceiver extends ResultReceiver {
        public AddressResultReceiver(Handler handler) {
            super(handler);
        }

        /**
         * Receives data sent from FetchAddressIntentService and updates the UI in MainActivity.
         */
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            Log.e("Boop", "The address");
            // Display the address string or an error message sent from the intent service.
            String address = resultData.getString(Constants.RESULT_DATA_KEY);
            menu.add(address);
            search.setQuery(address, false);
            menu.add(mLastLocation.getLatitude() + "  " + mLastLocation.getLongitude());
            Log.i("LAT AND LONG", mLastLocation.getLatitude() + "  " + mLastLocation.getLongitude());

        }

    }

    class LocationResultReceiver extends ResultReceiver {
        public LocationResultReceiver(Handler handler) {
            super(handler);
        }

        /**
         * Receives data sent from FetchAddressIntentService and updates the UI in MainActivity.
         */
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            Log.i("Boop", "The Location");
            // Display the address string or an error message sent from the intent service.
            if (resultCode == Constants.SUCCESS_RESULT) {
                ArrayList<String> address = resultData.getStringArrayList(Constants.RESULT_DATA_KEY);
                menu.add(address.get(0));
                list = new RestaurantList();
                FragmentTransaction fm2 = getSupportFragmentManager().beginTransaction();
                fm2.replace(R.id.content_frame, list);
                fm2.commit();
                presenter.getNearbyRes2(Double.parseDouble(address.get(0)),
                        Double.parseDouble(address.get(1)),
                        getBaseContext());
            } else {
                Log.e("Problem", "Did not return coords from intentService");
            }


        }

    }
}
