package com.goeuro.Runner;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by sherif on 8/13/2015.
 */
public class Utils {


    /**
     * Handles making the call request and returns the response in a String
     *
     * @param urlToQuery the url to get response from
     * @return The response in a String
     */
    public static String getHTML(String urlToQuery) {
        URL url;
        HttpURLConnection httpConnection;
        BufferedReader bufferedReader;
        String line;
        StringBuilder result = new StringBuilder();

        try {
            url = new URL(urlToQuery);
            httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod("GET");
            bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream(), "UTF-8"));
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }


    /**
     * Writes single String to a file in utf-8 format.
     *
     * @param filename     The path of the file
     * @param filetype     The type of the file (the .extension)
     * @param valueToWrite The string itself to write.
     * @return true if the file was written successfully, false if otherwise.
     */
    public static boolean writeToFile(String filename, String filetype, String valueToWrite) {


        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename + "." + filetype), "UTF-8"));
            writer.write("\ufeff"); //to make sure it writes in "UTF-8 BOM" encoding
            writer.write(valueToWrite);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {/*ignore*/}
        }

        return true;
    }
}
