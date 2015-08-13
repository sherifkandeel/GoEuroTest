package test.com.goeuro.Runner;

import com.goeuro.Runner.Utils;
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

import java.nio.charset.Charset;

/**
 * Utils Tester.
 *
 * @author sherif
 * @version 1.0
 * @since <pre>08/13/2015</pre>
 */
public class UtilsTest extends TestCase {
    public UtilsTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Method: getHTML(String urlToQuery)
     */
    public void testGetHTML() throws Exception {
        //test empty
        String emptyResult = "[]";
        String emptyQueryingURL = "http://api.goeuro.com/api/v2/position/suggest/en/asdfasdf";
        Assert.assertEquals(emptyResult, Utils.getHTML(emptyQueryingURL));

        //test output
        String result = "[{\"_id\":379727,\"key\":null,\"name\":\"Paris\",\"fullName\":\"Paris, France\",\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"France\",\"geo_position\":{\"latitude\":48.85341,\"longitude\":2.3488},\"locationId\":11914,\"inEurope\":true,\"countryCode\":\"FR\",\"coreCountry\":false,\"distance\":null},{\"_id\":379354,\"key\":null,\"name\":\"Cormeilles-en-Parisis\",\"fullName\":\"Cormeilles-en-Parisis, France\",\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"France\",\"geo_position\":{\"latitude\":48.97111,\"longitude\":2.20491},\"locationId\":11541,\"inEurope\":true,\"countryCode\":\"FR\",\"coreCountry\":false,\"distance\":null},{\"_id\":379890,\"key\":null,\"name\":\"Seyssinet-Pariset\",\"fullName\":\"Seyssinet-Pariset, France\",\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"France\",\"geo_position\":{\"latitude\":45.17676,\"longitude\":5.69387},\"locationId\":12077,\"inEurope\":true,\"countryCode\":\"FR\",\"coreCountry\":false,\"distance\":null},{\"_id\":436776,\"key\":null,\"name\":\"Le Touquet-Paris-Plage\",\"fullName\":\"Le Touquet-Paris-Plage, France\",\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"France\",\"geo_position\":{\"latitude\":50.52432,\"longitude\":1.58571},\"locationId\":136260,\"inEurope\":true,\"countryCode\":\"FR\",\"coreCountry\":false,\"distance\":null},{\"_id\":315042,\"key\":null,\"name\":\"Paris Charles De Gaulle\",\"fullName\":\"Paris Charles De Gaulle (CDG), France\",\"iata_airport_code\":\"CDG\",\"type\":\"airport\",\"country\":\"France\",\"geo_position\":{\"latitude\":49.0029701,\"longitude\":2.577134},\"locationId\":null,\"inEurope\":true,\"countryCode\":\"FR\",\"coreCountry\":false,\"distance\":null},{\"_id\":315043,\"key\":null,\"name\":\"Paris Orly\",\"fullName\":\"Paris Orly (ORY), France\",\"iata_airport_code\":\"ORY\",\"type\":\"airport\",\"country\":\"France\",\"geo_position\":{\"latitude\":48.72613,\"longitude\":2.364111},\"locationId\":null,\"inEurope\":true,\"countryCode\":\"FR\",\"coreCountry\":false,\"distance\":null}]";
        String queryingURL = "http://api.goeuro.com/api/v2/position/suggest/en/Paris";
        Assert.assertEquals(result, Utils.getHTML(queryingURL));


    }

    /**
     * Method: writeToFile(String filename, String filetype, String valueToWrite)
     */
    public void testWriteToFile() throws Exception {
        //We could do some tests with Easy Mocks library but that seems unnecessary effort with such trivial method.
    }


    public static Test suite() {
        return new TestSuite(UtilsTest.class);
    }
} 
