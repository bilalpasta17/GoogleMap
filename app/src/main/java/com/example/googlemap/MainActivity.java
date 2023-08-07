package com.example.googlemap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private BottomSheetDialog bottomSheetDialog;
    private GoogleMap my_map;
    private CoordinatorLayout bottomSheetView;
    private BottomSheetBehavior<View> bottomSheetBehavior;
    private Marker marker1, marker2;
    private MapView mapView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        my_map = googleMap;

//     specific location   LatLng sydney = new LatLng(-34, 151);
//        my_map.addMarker(new MarkerOptions().position(sydney).title("Sydney"));
//        my_map.moveCamera(CameraUpdateFactory.newLatLng(defaultL));

        //default location
        LatLng defaultLocation = new LatLng(37.7749, -122.4194);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, 12));
//

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                                               @Override
                                               public boolean onMarkerClick(Marker marker) {


                                                   AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                   builder.setTitle(marker.getTitle())
                                                           .setMessage(marker.getSnippet())
                                                           .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                               @Override
                                                               public void onClick(DialogInterface dialogInterface, int i) {
                                                                   // Handle OK button click if needed
                                                                   // Show the bottom sheet
//                                showBottomSheet();

                                                                   AlertDialog dialog = builder.create();
                                                                   dialog.show();
                                                               }

                                                           });
                                                   return false;



//    @SuppressLint("SetTextI18n")
//    private void showBottomSheet() {
//
//        // Set up the bottom sheet behavior
//        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);
//        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetView);
//        bottomSheetBehavior.setPeekHeight(300); // Set the desired peek height
//
//        // Show the bottom sheet
//        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//
//        // Set the title in the bottom sheet
//        TextView titleTextView = bottomSheetView.findViewById(R.id.bottom_sheet_title);
//        titleTextView.setText("Bottom Sheet Title");
//
//        // Create and show the bottom sheet dialog
//        bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
//        bottomSheetDialog.setContentView(bottomSheetView);
//        bottomSheetDialog.show();