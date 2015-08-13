package com.goeuro.parser;

import javax.lang.model.element.Name;

/**
 * Created by sherif on 8/10/2015.
 */
public class ParsedObject {
    //_id, name, type, latitude, longitude
    String id;
    String name;
    String type;
    String latitude;
    String longitude;

    public ParsedObject(String id, String name, String type, String latitude, String longitude) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public ParsedObject() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

//    to easily convert that to csv

    /**
      * Easily converts the object into a csv formatted string.
      * @return
     */
    @Override public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append(id+", ");
        resultString.append(name+", ");
        resultString.append(type+", ");
        resultString.append(latitude+", ");
        resultString.append(longitude);
        return resultString.toString();
    }

}
