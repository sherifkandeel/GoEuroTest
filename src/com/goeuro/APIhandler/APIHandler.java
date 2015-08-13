package com.goeuro.APIhandler;
import java.io.*;
import java.net.*;
import com.goeuro.Runner.Utils;


/**
 * Created by sherif on 8/11/2015.
 */
public class APIHandler {
    private final String goEuroURL = "http://api.goeuro.com/api/v2/position/suggest/en/";
    public String retrieveCityInfo(String city)
    {
        if (city.length() == 0)
            return "";
        String cityURL = goEuroURL + city;
        String htmlResponse = "";
        try {
            htmlResponse = Utils.getHTML(cityURL);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return htmlResponse;
    }


}
