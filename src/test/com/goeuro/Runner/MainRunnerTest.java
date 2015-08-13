package test.com.goeuro.Runner;

import com.goeuro.Runner.MainRunner;
import com.goeuro.parser.ParsedObject;
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * MainRunner Tester.
 *
 * @author sherif
 * @version 1.0
 * @since <pre>08/13/2015</pre>
 */
public class MainRunnerTest extends TestCase {

    String emptyEntryString = "You didn't Enter anything. Try entering name of a city, Ex: \"New York\"";
    String emptyResult = "Your input didn't yeild any output, please make sure you're entering a valid city name";
    String successMessage = "Your result has been outputted to file, for input: ";

    public MainRunnerTest(String name) {
        super(name);
    }

    MainRunner mainRunner;

    public void setUp() throws Exception {
        super.setUp();
        mainRunner = new MainRunner();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Method: processUserInput(String input)
     */
    public void testProcessUserInput() throws Exception {
        //empty entry
        Assert.assertEquals(emptyEntryString, mainRunner.processUserInput(""));

        //wrong city (unavailable city)
        Assert.assertEquals(emptyResult, mainRunner.processUserInput("asdf"));

        //right test
        Assert.assertEquals(successMessage+"paris", mainRunner.processUserInput("paris"));

        //right test two words
        Assert.assertEquals(successMessage+"new york", mainRunner.processUserInput("new york"));
    }

    public void testgenerateCSVResults() throws Exception {
        String headline = "_id, name, type, latitude, longitude\n";
        ParsedObject[] parsedObjectList = new ParsedObject[0];

        //empty test
        Assert.assertEquals(headline, mainRunner.generateCSVResults(parsedObjectList));

        //filled test
        parsedObjectList = new ParsedObject[1];
        ParsedObject temp = new ParsedObject("1", "cityname", "citytype", "citylatitude", "citylongitude");
        parsedObjectList[0] = temp;
        Assert.assertEquals(headline+ temp.toString()+"\n", mainRunner.generateCSVResults(parsedObjectList));

    }


    public static Test suite() {
        return new TestSuite(MainRunnerTest.class);
    }
} 
