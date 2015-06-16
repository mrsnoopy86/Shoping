package ua.kh.tremtyachiy.shoping.util;

import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import ua.kh.tremtyachiy.shoping.R;

/**
 * Created by User on 16.06.2015.
 */
public class Maps implements OnMapReadyCallback {
    private GoogleMap mMap;
    private MapFragment mMapFragment;

    public void initMap(AppCompatActivity activity) {
        try {
            if(mMap == null){
                mMap = ((MapFragment) activity.getFragmentManager().findFragmentById(R.id.map)).getMap();
                mMapFragment = (MapFragment) activity.getFragmentManager().findFragmentById(R.id.map);
            }
        } catch (NullPointerException exception){
            exception.printStackTrace();
        }
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setBuildingsEnabled(true);
        mMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(49.994399, 36.236583), 18));
    }

    public GoogleMap getMap() {
        return mMap;
    }
}
