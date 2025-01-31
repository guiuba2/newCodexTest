package com.codex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONObject;

/**This class queries a server to retrieve the current date and time, for both the
 * local time zone and UTC, using HttpURLConnection to send an HTTP request to
 * the server. The request returns a JSON or formatted response, as chosen by the user.
 * @author Guilherme de Magalhaes Andrade
 */

public class TimeQuery {
    static ZonedDateTime utcTime;
    static ZonedDateTime localTime;
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    /**
     * Method to fetch the date and time from the server
     * @return
     * @throws Exception
     */
    public static String fetchTimeFromServer() throws Exception {
        String urlString = "https://worldtimeapi.org/api/timezone/utc"; // unstable "http://worldclockapi.com/api/json/utc/now";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Check for successful response code
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Failed to fetch time from server. HTTP error code: " + responseCode);
        }

        // Read the response
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        // Return the JSON response as a string
        return content.toString();
    }

    /**
     * This method queries a server for current date/time
     * and stores variables with local and utc data.
     */
    public static void checkCurrentDateTime() {
        try {
            // Fetch the time data from the server
            String jsonResponse = fetchTimeFromServer();

            // Parse the JSON response
            JSONObject jsonObject = new JSONObject(jsonResponse);
            String utcDateTimeString = jsonObject.getString("datetime"); //currentDateTime

            // Convert the string to ZonedDateTime (UTC)
            utcTime = ZonedDateTime.parse(utcDateTimeString, DateTimeFormatter.ISO_DATE_TIME);

            // Convert to Local Time (System's Time Zone)
            localTime = utcTime.withZoneSameInstant(ZoneId.systemDefault());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * Method to display the output in a formatted response
     */
    static void displayCurrDayTimeLocUtc() {
        // Display UTC time
        System.out.println("UTC Time: " + utcTime.format(dtf));
        // Display Local Time
        System.out.println("Local Time: " + localTime.format(dtf));
        System.out.println();
    }



    /**
     * Method to display the output as a JSON
     */
    static void displayCurrDayTimeLocalInJsonFormat() {
        // Create a JSON object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("currentDateTimeUtc", utcTime.format(dtf));
        jsonObject.put("currentDateTimeLocal", localTime.format(dtf));

        // Print the JSON output
        System.out.println(jsonObject);
        System.out.println();

    }
}

