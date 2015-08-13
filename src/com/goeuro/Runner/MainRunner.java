package com.goeuro.Runner;

import com.goeuro.APIhandler.APIHandler;
import com.goeuro.parser.ParsedObject;
import com.goeuro.parser.Parser;

/**
 * Created by sherif on 8/13/2015.
 */
public class MainRunner {
    private APIHandler apiHandler;
    private Parser parser;

    //List of possible message to output to the user in all possible cases.
    private final String emptyEntryString = "You didn't Enter anything. Try entering name of a city, Ex: \"New York\"";
    private final String emptyResult = "Your input didn't yeild any output, please make sure you're entering a valid city name";
    private final String successMessage = "Your result has been outputted to file, for input: ";
    private final String errorWritingResultsTofile = "An Error happened while trying ot write results to file";
    private final String parsingError = "An Error happened while trying to parse the response.";

    public MainRunner() {
        this.apiHandler = new APIHandler();
        this.parser = new Parser();
    }


    /**
     * The entry point of the program's functionality`
     *
     * @param input the city's name
     * @return an informative string with either a success or faliure of the query.
     */
    public String processUserInput(String input) {

        if (input.length() == 0)
            return emptyEntryString;

        else {
            String jsonResult = apiHandler.retrieveCityInfo(input);
            if (jsonResult.equals("[]"))
                return emptyResult;
            else {
                ParsedObject[] parsedObjects = parser.parse(jsonResult);

                //if some error happened at the parsing stage:
                if (parsedObjects == null)
                    return parsingError;

                //writing csv results to a string
                String valuessToBeWrittenToFile = generateCSVResults(parsedObjects);
                boolean success = Utils.writeToFile("output", "csv", valuessToBeWrittenToFile.toString());
                if (success)
                    return successMessage+ input;
                else
                    return errorWritingResultsTofile;

            }

        }

    }

    public String generateCSVResults(ParsedObject[] parsedObjects)
    {
        StringBuilder generatedValuesString = new StringBuilder();
        generatedValuesString.append("_id, name, type, latitude, longitude\n");
        for (int i = 0; i < parsedObjects.length; i++) {
            generatedValuesString.append(parsedObjects[i].toString());
            generatedValuesString.append("\n");
        }
        return generatedValuesString.toString();
    }


}
