package com.dranser.microbuses;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.osmdroid.ResourceProxy;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.util.ResourceProxyImpl;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.MinimapOverlay;
import org.osmdroid.views.overlay.ScaleBarOverlay;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

/**
 * Created by Dranser on 16/04/2017.
 */

public class MapFragment extends Fragment {

    private MapView mMapView;
    private MyLocationNewOverlay mLocationOverlay;
    private CompassOverlay mCompassOverlay;
    private MinimapOverlay mMinimapOverlay;
    private ScaleBarOverlay mScaleBarOverlay;
    private ResourceProxy mResourceProxy;

    private LocationManager locationManager;
    private Location lastLocation;

    @Nullable



    

    public void moveToCurrentPosition(){
        GeoPoint gp = mLocationOverlay.getMyLocation();
        if(gp != null)
            mMapView.getController().animateTo(gp);
        else {
            if(lastLocation != null){
                gp = new GeoPoint(lastLocation.getLatitude(), lastLocation.getLongitude());
                mMapView.getController().animateTo(gp);
            }
        }
    }
}
