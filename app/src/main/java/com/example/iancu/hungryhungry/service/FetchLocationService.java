package com.example.iancu.hungryhungry.service;

import android.app.IntentService;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;

import com.example.iancu.hungryhungry.Constants;
import com.example.iancu.hungryhungry.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Iancu on 01/11/2016.
 */

public class FetchLocationService extends IntentService {
    private static final String TAG = "fetch-location-intent-service";
    protected ResultReceiver mReceiver;
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public FetchLocationService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String errorMessage = "";
        Log.e("BOOP","In service");
        mReceiver = intent.getParcelableExtra(Constants.LOCATION_RECEIVER);

        // Check if receiver was properly registered.
        if (mReceiver == null) {
            Log.wtf(TAG, "No receiver received. There is nowhere to send the results.");
            return;
        }
        // Get the location passed to this service through an extra.
        String location = intent.getStringExtra(Constants.LOCATION_DATA_ADDRESS);
        // Make sure that the location data was really sent over through an extra. If it wasn't,
        // send an error error message and return.
        if (location==null) {
            errorMessage = "no_location_data_provided";
            Log.wtf(TAG, errorMessage);
            ArrayList<String> temp=new ArrayList<>();
            temp.add(errorMessage);
            deliverResultToReceiver(Constants.FAILURE_RESULT, temp);
            return;
        }

        // Errors could still arise from using the Geocoder (for example, if there is no
        // connectivity, or if the Geocoder is given illegal location data). Or, the Geocoder may
        // simply not have an address for a location. In all these cases, we communicate with the
        // receiver using a resultCode indicating failure. If an address is found, we use a
        // resultCode indicating success.

        // The Geocoder used in this sample. The Geocoder's responses are localized for the given
        // Locale, which represents a specific geographical or linguistic region. Locales are used
        // to alter the presentation of information such as numbers or dates to suit the conventions
        // in the region they describe.
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        // Address found using the Geocoder.
        List<Address> addresses = null;

        try {
            // Using getFromLocation() returns an array of Addresses for the area immediately
            // surrounding the given latitude and longitude. The results are a best guess and are
            // not guaranteed to be accurate.
            addresses = geocoder.getFromLocationName(location,1);
        } catch (IOException ioException) {
            // Catch network or other I/O problems.
            errorMessage = "service_not_available";
            Log.e("ERR", errorMessage, ioException);
        } catch (IllegalArgumentException illegalArgumentException) {
            // Catch invalid latitude or longitude values.
            errorMessage = "invalid_lat_long_used";
            Log.e("ERR", errorMessage + ". " + location, illegalArgumentException);
        }

        // Handle case where no address was found.
        if (addresses == null || addresses.size()  == 0) {
            if (errorMessage.isEmpty()) {
                errorMessage = "no_address_found";
                Log.e("ERR", errorMessage);
            }
            ArrayList<String> temp=new ArrayList<>();
            temp.add(errorMessage);
            deliverResultToReceiver(Constants.FAILURE_RESULT, temp);
        } else {
            Address address = addresses.get(0);
            ArrayList<String> addressFragments = new ArrayList<String>();

            // Fetch the address lines using {@code getAddressLine},
            // join them, and send them to the thread. The {@link android.location.address}
            // class provides other options for fetching address details that you may prefer
            // to use. Here are some examples:
            // getLocality() ("Mountain View", for example)
            // getAdminArea() ("CA", for example)
            // getPostalCode() ("94043", for example)
            // getCountryCode() ("US", for example)
            // getCountryName() ("United States", for example)
            for(int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                addressFragments.add(""+address.getLatitude());
                addressFragments.add(""+address.getLongitude());
            }
            Log.i("YAAAAY","address_found");
            deliverResultToReceiver(Constants.SUCCESS_RESULT, addressFragments);
        }

    }
    private void deliverResultToReceiver(int resultCode, ArrayList<String> message) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(Constants.RESULT_DATA_KEY, message);
        mReceiver.send(resultCode, bundle);
    }
}