package foxsay.ru.ncipbus.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import foxsay.ru.ncipbus.R;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    private MapView mapView;
    private GoogleMap gmap;
    MarkerOptions place1, place2, place3, place4, place5;

    private static final String MAP_VIEW_BUNDLE_KEY = "AIzaSyD3Kx94UnUwOfK3yxStfhjf62HjOorNBw4";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY);
        }

        mapView = view.findViewById(R.id.map_view);
        mapView.onCreate(mapViewBundle);
        mapView.getMapAsync(this);

        place1 = new MarkerOptions().position(new LatLng(55.748673, 52.417889)).title(getResources().getString(R.string.bus_stop_1));
        place2 = new MarkerOptions().position(new LatLng(55.745350, 52.423543)).title(getResources().getString(R.string.bus_stop_2));
        place3 = new MarkerOptions().position(new LatLng(55.743030, 52.427472)).title(getResources().getString(R.string.bus_stop_3));
        place4 = new MarkerOptions().position(new LatLng(55.739852, 52.432945)).title(getResources().getString(R.string.bus_stop_4));
        place5 = new MarkerOptions().position(new LatLng(55.738453, 52.449557)).title(getResources().getString(R.string.last_bus_stop));

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAP_VIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAP_VIEW_BUNDLE_KEY, mapViewBundle);
        }

        mapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gmap = googleMap;
        gmap.setMinZoomPreference(15);
        LatLng ny = new LatLng(55.748671, 52.417905);
        gmap.moveCamera(CameraUpdateFactory.newLatLng(ny));
        gmap.addMarker(place1);
        gmap.addMarker(place2);
        gmap.addMarker(place3);
        gmap.addMarker(place4);
        gmap.addMarker(place5);
    }
}
