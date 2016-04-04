package lclark.mapplication;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by larspmayrand on 4/3/16.
 */
public class Pin {

    private LatLng location;
    private String title;
    private String description;

    public Pin(LatLng location, String title, String description) {
        this.location = location;
        this.title = title;
        this.description = description;
    }

    public LatLng getLocation() {
        return location;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}
