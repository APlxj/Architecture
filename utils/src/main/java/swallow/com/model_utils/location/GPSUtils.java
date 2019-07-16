package com.reconova.utils.location;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.text.TextUtils;

import java.util.List;

public class GPSUtils {

    public static String getAddressStr(Context context, Location location) {
        if (null == location) return "";
        Geocoder geocoder = new Geocoder(context);
        List places = null;

        try {
            places = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String placename = "";
        if (places != null && places.size() > 0) {
            String ad1 = ((Address) places.get(0)).getAddressLine(0);
            String ad2 = ((Address) places.get(0)).getAddressLine(1);
            String ad3 = ((Address) places.get(0)).getAddressLine(2);
            placename = (TextUtils.isEmpty(ad1) ? "" : ad1)
                    + (TextUtils.isEmpty(ad2) ? "" : ad2)
                    + (TextUtils.isEmpty(ad3) ? "" : ad3);
        }

        return placename;
    }
}
