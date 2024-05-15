package Selenium;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

    public class ReadJson {

        public static void main(String[] args) throws IOException, ParseException {
            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject=(JSONObject) jsonParser.parse(new FileReader("C:\\Users\\Laxman Gole\\OneDrive\\Documents\\Report\\AutomationAagain\\package.json"));

            String id = (String) jsonObject.get("EmployeeId");
            String firstname = (String) jsonObject.get("FirstName");
            String lastname = (String) jsonObject.get("LastName");
            String country = (String) jsonObject.get("Country");

            System.out.println("Final data in the console:");
            System.out.println(id);
            System.out.println(firstname);
            System.out.println(lastname);
            System.out.println(country);



        }
    }

