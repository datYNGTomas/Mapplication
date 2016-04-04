package lclark.mapplication;

import android.content.ContentValues;
import java.util.ArrayList;

/**
 * Created by larspmayrand on 4/3/16.
 */
public class User {

    private String name;
    private ArrayList<Pin> pins;

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PINS = "pins";

    public User(String name) {
        this.name = name;
    }

    public ContentValues getContentValues() {
        android.content.ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        return contentValues;

    }

}
