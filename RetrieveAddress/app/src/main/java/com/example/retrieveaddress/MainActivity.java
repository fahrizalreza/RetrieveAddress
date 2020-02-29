package com.example.retrieveaddress;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView addressTxt;
    Geocoder geocoder;
    List<Address> addresses;

    // Static latitude and longitude data
    Double latitude = 18.944620;
    Double longitude = 72.822278;

    Double bataviaLatitude = -6.2107224;
    Double bataviaLongitude = 106.8134621;

    String fullAddress, address, area, city, country, postalCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addressTxt = (TextView) findViewById(R.id.addressTxt);

        geocoder = new Geocoder(this, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(bataviaLatitude, bataviaLongitude, 1);

            address = addresses.get(0).getAddressLine(0);
            area = addresses.get(0).getLocality();
            city = addresses.get(0).getAdminArea();
            country = addresses.get(0).getCountryName();
            postalCode = addresses.get(0).getPostalCode();
            fullAddress = address + ", - " + area + ", - " + city + ", - " + country + ", - " + postalCode;

            addressTxt.setText(fullAddress);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
