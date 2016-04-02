package lclark.mapplication;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, OnMapClickListener {

    private GoogleMap mMap;

    private DialogFragment mDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Toast.makeText(getApplicationContext(), "updated", Toast.LENGTH_SHORT).show();
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng point = new LatLng(44, 143);
        mMap.addMarker(new MarkerOptions()
                .position(point));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(point, 3));
    }

    @Override
    public void onMapClick(LatLng point) {
        // TODO: launch dialog fragment, get title and description, store in SQL

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.show(mDialogFragment);
        transaction.commit();

        Bitmap b = ((BitmapDrawable) ContextCompat.getDrawable(getApplicationContext(), R.drawable.barry_glass_head)).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 100, 130, false);
        //Bitmap barryBitmap = BitmapFactory.barryHead;

        mMap.addMarker(new MarkerOptions()
                .position(point)
                .icon(BitmapDescriptorFactory.fromBitmap(bitmapResized))
                        //.title()
                        //.snippet()
                .draggable(true));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(point, 3));
    }

}
