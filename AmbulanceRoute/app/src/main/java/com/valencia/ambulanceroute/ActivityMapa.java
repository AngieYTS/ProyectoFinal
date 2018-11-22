package com.valencia.ambulanceroute;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class ActivityMapa extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private MarkerOptions marcador;
    private MarkerOptions marcador2;
    private MarkerOptions marcador3;
    private MarkerOptions marcador4;
    private MarkerOptions marcador5;
    private MarkerOptions marcador6;
    private MarkerOptions marcador7;
    private MarkerOptions marcador8;
    private MarkerOptions marcador9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;
        LatLng posicion = new LatLng(2.437454, -76.619238);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mMap.setMyLocationEnabled(true);


            marcador = new MarkerOptions();
            marcador.position(posicion);
            marcador.title("Hospital Susana López de Valencia");

            LatLng posicion2 = new LatLng(2.450243, -76.599859);
            marcador2 = new MarkerOptions();
            marcador2.position(posicion2);
            marcador2.title("Hospital Universitario San José Ese");

            mMap = googleMap;
            LatLng posicion3 = new LatLng(2.452139, -76.603121);

            marcador3 = new MarkerOptions();
            marcador3.position(posicion);
            marcador3.title("Cruz Roja Colombiana Seccional Cauca");

            mMap = googleMap;
            LatLng posicion4 = new LatLng(2.449082, -76.608457);

            marcador4 = new MarkerOptions();


            marcador4.position(posicion);
            marcador4.title("Cuerpo de Bomberos Voluntarios de Popayán");

            mMap = googleMap;
            LatLng posicion5 = new LatLng(2.450880, -76.597454);

            marcador5 = new MarkerOptions();
            marcador5.position(posicion);
            marcador5.title("Clínica La Estancia");

            mMap = googleMap;
            LatLng posicion6 = new LatLng(2.459515, -76.602754);

            marcador6 = new MarkerOptions();
            marcador6.position(posicion);
            marcador6.title("Clínica Santa Gracia");

            mMap = googleMap;
            LatLng posicion7 = new LatLng(2.436183, -76.608031);

            marcador7 = new MarkerOptions();
            marcador7.position(posicion);
            marcador7.title("Ambulancias S.P.A.M");

            mMap = googleMap;
            LatLng posicion8 = new LatLng(2.445192, -76.608390);

            marcador8 = new MarkerOptions();
            marcador8.position(posicion);
            marcador8.title("IPS Comfacauca Popayán");

            mMap = googleMap;
            LatLng posicion9 = new LatLng(2.485853, -76.563675);

            marcador9 = new MarkerOptions();
            marcador9.position(posicion);
            marcador9.title("Hospital del Norte Toribio Maya");

            mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_marcador)).anchor(0.0f, 1.0f).position(posicion).title("Hospital Susana López de Valencia"));
            mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_marcador)).anchor(0.0f, 1.0f).position(posicion2).title("Hospital Universitario San José Ese"));
            mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_marcador)).anchor(0.0f, 1.0f).position(posicion3).title("Cruz Roja Colombiana Seccional Cauca"));
            mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_marcador)).anchor(0.0f, 1.0f).position(posicion4).title("Cuerpo de Bomberos Voluntarios de Popayán"));
            mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_marcador)).anchor(0.0f, 1.0f).position(posicion5).title("Clínica La Estancia"));
            mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_marcador)).anchor(0.0f, 1.0f).position(posicion6).title("Clínica Santa Gracia"));
            mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_marcador)).anchor(0.0f, 1.0f).position(posicion7).title("Ambulancias S.P.A.M"));
            mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_marcador)).anchor(0.0f, 1.0f).position(posicion8).title("IPS Comfacauca Popayán"));
            mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_marcador)).anchor(0.0f, 1.0f).position(posicion9).title("Hospital del Norte Toribio Maya"));

            mMap.setOnMarkerClickListener(this);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(posicion, 16));
        }

        @Override
        public boolean onMarkerClick (Marker marker){

        if (marker.getTitle().equalsIgnoreCase(marcador.getTitle())){

            Intent siguiente = new Intent(ActivityMapa.this, ActivityImagen.class);
            startActivity(siguiente);

        }else if (marker.getTitle().equalsIgnoreCase(marcador2.getTitle())){

            Intent siguiente = new Intent(ActivityMapa.this, ActivityImagen.class);
            startActivity(siguiente);
        }else if (marker.getTitle().equalsIgnoreCase(marcador3.getTitle())){

            Intent siguiente = new Intent(ActivityMapa.this, ActivityImagen.class);
            startActivity(siguiente);
        }else if (marker.getTitle().equalsIgnoreCase(marcador4.getTitle())){

            Intent siguiente = new Intent(ActivityMapa.this, ActivityImagen.class);
            startActivity(siguiente);
        }else if (marker.getTitle().equalsIgnoreCase(marcador5.getTitle())){

            Intent siguiente = new Intent(ActivityMapa.this, ActivityImagen.class);
            startActivity(siguiente);
        }else if (marker.getTitle().equalsIgnoreCase(marcador6.getTitle())){

            Intent siguiente = new Intent(ActivityMapa.this, ActivityImagen.class);
            startActivity(siguiente);
        }else if (marker.getTitle().equalsIgnoreCase(marcador7.getTitle())){

            Intent siguiente = new Intent(ActivityMapa.this, ActivityImagen.class);
            startActivity(siguiente);
        }else if (marker.getTitle().equalsIgnoreCase(marcador8.getTitle())){

            Intent siguiente = new Intent(ActivityMapa.this, ActivityImagen.class);
            startActivity(siguiente);
        }else if (marker.getTitle().equalsIgnoreCase(marcador9.getTitle())){

            Intent siguiente = new Intent(ActivityMapa.this, ActivityImagen.class);
            startActivity(siguiente);
        }

            return false;
        }
    }
