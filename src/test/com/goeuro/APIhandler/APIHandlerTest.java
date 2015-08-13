package test.com.goeuro.APIhandler;

import com.goeuro.APIhandler.APIHandler;
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * APIHandler Tester.
 *
 * @author sherif
 * @version 1.0
 * @since <pre>08/12/2015</pre>
 */
public class APIHandlerTest extends TestCase {
    APIHandler apiHandler;

    public APIHandlerTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
        apiHandler = new APIHandler();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Method: retrieveCityInfo(String city)
     */
    public void testRetrieveCityInfo() throws Exception {

        //emtpy test
        Assert.assertEquals("", apiHandler.retrieveCityInfo(""));

        //City test
        String jsonOutput = "[{\"_id\":387820,\"key\":null,\"name\":\"Cairo Montenotte\",\"fullName\":\"Cairo Montenotte, Italy\",\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"Italy\",\"geo_position\":{\"latitude\":44.40314,\"longitude\":8.27455},\"locationId\":20028,\"inEurope\":true,\"countryCode\":\"IT\",\"coreCountry\":true,\"distance\":null},{\"_id\":439390,\"key\":null,\"name\":\"Cairon\",\"fullName\":\"Cairon, France\",\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"France\",\"geo_position\":{\"latitude\":49.24017,\"longitude\":-0.45046},\"locationId\":138874,\"inEurope\":true,\"countryCode\":\"FR\",\"coreCountry\":false,\"distance\":null},{\"_id\":446633,\"key\":null,\"name\":\"Gropello Cairoli\",\"fullName\":\"Gropello Cairoli, Italy\",\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"Italy\",\"geo_position\":{\"latitude\":45.17856,\"longitude\":8.99275},\"locationId\":146249,\"inEurope\":true,\"countryCode\":\"IT\",\"coreCountry\":true,\"distance\":null},{\"_id\":445551,\"key\":null,\"name\":\"Pieve del Cairo\",\"fullName\":\"Pieve del Cairo, Italy\",\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"Italy\",\"geo_position\":{\"latitude\":45.04996,\"longitude\":8.80415},\"locationId\":145160,\"inEurope\":true,\"countryCode\":\"IT\",\"coreCountry\":true,\"distance\":null},{\"_id\":314931,\"key\":null,\"name\":\"Cairo\",\"fullName\":\"Cairo (CAI), Egypt\",\"iata_airport_code\":\"CAI\",\"type\":\"airport\",\"country\":\"Egypt\",\"geo_position\":{\"latitude\":30.11139,\"longitude\":31.41389},\"locationId\":null,\"inEurope\":false,\"countryCode\":\"EG\",\"coreCountry\":false,\"distance\":null}]";
        Assert.assertEquals(jsonOutput, apiHandler.retrieveCityInfo("Cairo"));

        //city with space in between
        String cityNameWithSpaceJSONOutput = "[{\"_id\":387820,\"key\":null,\"name\":\"Cairo Montenotte\",\"fullName\":\"Cairo Montenotte, Italy\",\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"Italy\",\"geo_position\":{\"latitude\":44.40314,\"longitude\":8.27455},\"locationId\":20028,\"inEurope\":true,\"countryCode\":\"IT\",\"coreCountry\":true,\"distance\":null}]";
        Assert.assertEquals(cityNameWithSpaceJSONOutput, apiHandler.retrieveCityInfo("Cairo Montenotte"));

        //Unknown City
        Assert.assertEquals("[]", apiHandler.retrieveCityInfo("asdf"));

    }


    public static Test suite() {
        return new TestSuite(APIHandlerTest.class);
    }
} 
