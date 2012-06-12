package com.androideity.googlemapstest;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class GoogleMapsTestActivity extends MapActivity {
	
	private MapView mapView;
	
	private static final int latitudeE6 = 19240000;
	private static final int longitudeE6 = -99120000;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mapView = (MapView) findViewById(R.id.map_view);       
        mapView.setBuiltInZoomControls(true);
        
        List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.icon);
		MyOverlay itemizedOverlay = new MyOverlay(drawable, this);
		
		GeoPoint point = new GeoPoint(latitudeE6, longitudeE6);
		OverlayItem overlayitem = new OverlayItem(point, "Hola", 
				"!Te saludamos desde Ciudad de M�xico!");
		
		itemizedOverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedOverlay);
		
		MapController mapController = mapView.getController();
		
		mapController.animateTo(point);
		mapController.setZoom(6);
        
    }

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
    
}