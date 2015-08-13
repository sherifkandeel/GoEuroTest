package test.com.goeuro.parser;

import com.goeuro.parser.ParsedObject;
import com.goeuro.parser.Parser;
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Parser Tester.
 *
 * @author sherif
 * @version 1.0
 * @since <pre>08/11/2015</pre>
 */
public class ParserTest extends TestCase {
    Parser parser;

    public ParserTest(String name) {
        super(name);
        parser = new Parser();
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Method: parse(String unparsed)
     */
    public void testParse() throws Exception {
        //emtpy input
        Assert.assertEquals(null, parser.parse(""));

        //single input length
        String singleinputjsonobj = "[{\"_id\":387820,\"key\":null,\"name\":\"Cairo Montenotte\",\"fullName\":\"Cairo Montenotte, Italy\",\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"Italy\",\"geo_position\":{\"latitude\":44.40314,\"longitude\":8.27455},\"locationId\":20028,\"inEurope\":true,\"countryCode\":\"IT\",\"coreCountry\":true,\"distance\":null}]";
        Assert.assertEquals(1, parser.parse(singleinputjsonobj).length);

        // content
        ParsedObject singleObj = new ParsedObject();
        singleObj.setId("387820");
        singleObj.setName("Cairo Montenotte");
        singleObj.setType("location");
        singleObj.setLatitude("44.40314");
        singleObj.setLongitude("8.27455");
        Assert.assertEquals(singleObj.toString(), parser.parse(singleinputjsonobj)[0].toString());
    }


    public static Test suite() {
        return new TestSuite(ParserTest.class);
    }
} 
