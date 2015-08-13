package com.goeuro.parser;
import org.json.*;


/**
 * Created by sherif on 8/9/2015.
 */
public class Parser {

    /**
     * parses the json array in a string format to an array of parsedObjects
     * @param unparsed the string that represents a json array
     * @return an array of parsedObjects
     */
    public ParsedObject[] parse(String unparsed) {
        if (unparsed.length() == 0)
            return null;
        JSONArray JSONObjects;
        try {
            JSONObjects = new JSONArray(unparsed);
        }
        catch (Exception e)
        {
            //something went wrong with parsing the json, or unformatted json arary.
            e.printStackTrace();
            return null;
        }
        ParsedObject[] parsedArray = new ParsedObject[JSONObjects.length()];
        for (int i = 0; i < JSONObjects.length(); i++) {
            JSONObject currentObj = (JSONObject)JSONObjects.get(i);
            ParsedObject temp = new ParsedObject(currentObj.get("_id").toString(),
                    currentObj.get("name").toString(),
                    currentObj.get("type").toString(),
                    ((JSONObject) currentObj.get("geo_position")).get("latitude").toString(),
                    ((JSONObject) currentObj.get("geo_position")).get("longitude").toString());
            parsedArray[i] = temp;
        }
        return  parsedArray;
    }
}
