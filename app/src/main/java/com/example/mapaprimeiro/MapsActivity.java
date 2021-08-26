package com.example.mapaprimeiro;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mapaprimeiro.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    double latitude, longitude;
    String local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     * / **
     * * Manipula o mapa quando disponível.
     * * Este retorno de chamada é acionado quando o mapa está pronto para ser usado.
     * * Aqui é onde podemos adicionar marcadores ou linhas, adicionar ouvintes ou mover a câmera. Nesse caso,
     * * acabamos de adicionar um marcador perto de Sydney, Austrália.
     * * Se o Google Play Services não estiver instalado no dispositivo, o usuário será solicitado a instalar
     * * dentro do SupportMapFragment. Este método só será acionado quando o usuário tiver
     * * instalou o Google Play Services e voltou ao aplicativo.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
//normal - a visualização do roteiro padrão. Este é o tipo de mapa padrão.
//satellite - exibe imagens de satélite do Google Terra.
//hybrid - exibe uma mistura de visualizações normais e de satélite.
//terrain - exibe um mapa físico com base nas informações do terreno.
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        latitude = -22.981150116303127;
        longitude = -45.794577476283365;
        local = "Sítio!";

        // Add a marker in Sydney and move the camera
        LatLng position = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions()
                .position(position)
                .title(local)
                .snippet("O do Pica Pau Amarelo")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.moray)));

        //A Acrescentar:Outras Opções de Marcação
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 12.5f));

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                double latitude, longitude;

                latitude = latLng.latitude;

                longitude = latLng.longitude;

                Toast.makeText(MapsActivity.this, "Clique Curto-Latitude:" + latitude + " " + "e Longitude:" + longitude, Toast.LENGTH_SHORT).show();
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Fez um Pequeno Clique")
                        .snippet("Gera-se assim um ícone de uma Invenção Milenar")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.locomotiva))
                );

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));


            }
        });

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                double latitude, longitude;

                latitude = latLng.latitude;
                longitude = latLng.longitude;

                Toast.makeText(MapsActivity.this, "Clique Longo - Latitude:" + latitude + " " + "Longitude:" + longitude, Toast.LENGTH_SHORT).show();
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Clique Longo")
                        .snippet("Um Animal Noturno")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.coruja))
                );
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));


            }
        });
    }
}









