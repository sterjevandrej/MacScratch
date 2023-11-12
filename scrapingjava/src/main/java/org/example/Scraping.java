package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

public class Scraping {

    public static void main(String[] args) {
        try {
            String overpassQuery = "[out:json];area['ISO3166-1'='MK'][admin_level=2]->.searchArea;("
                    + "node['tourism'='museum'](area.searchArea);"
                    + "node['amenity'='place_of_worship'](area.searchArea);"
                    + "node['historic'='memorial'](area.searchArea);"
                    + "node['historic'='archaeological_site'](area.searchArea);"
                    + "node['historic'='monument'](area.searchArea);"
                    + "node['landuse'='cemetery'](area.searchArea);"
                    + ");out;";

            String osmApiResponse = sendGetRequest("https://overpass-api.de/api/interpreter?data=" + overpassQuery);

            parseAndWriteToFile(osmApiResponse);

            System.out.println("Data has been successfully written to the file.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String sendGetRequest(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
                response.append(inputLine).append("\n");
            }

            in.close();
            return response.toString();
        } else {
            throw new IOException("GET request failed. Response Code: " + responseCode);
        }


    }

    private static void parseAndWriteToFile(String jsonData) throws IOException {
        try (FileWriter writer = new FileWriter("localities_in_north_macedonia.txt")) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonData);
            JsonNode elementsNode = rootNode.get("elements");
            HashMap<String, Node> database = new HashMap<>();

            if (elementsNode.isArray()) {
                Iterator<JsonNode> elementsIterator = elementsNode.elements();
                while (elementsIterator.hasNext()) {
                    JsonNode elementNode = elementsIterator.next();
                    processNode(elementNode, database);
                }
            }

            //Ovde se pecatat na konzola ama treba da go smenime da pecati vo nekoj dokument

            String filePath = "example.csv";
            writeToCSV(database,filePath);

//            for (String key : database.keySet()) {
//                System.out.println(database.get(key));
//            }

            //Ova ne treba, samo za proverka e napraeno
            writer.write(jsonData);
            writer.flush();
        }
    }

//    public static void processFileData(InputStream is) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//
//        System.out.println(br.readLine());
//
//    }

    public static void writeToCSV(HashMap<String, Node> db, String filepath){
        try {
            // Create a BufferedWriter
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));

            // Write header to the CSV file
            writer.write("Име,Име на англиски,Религија на која припаѓа објектот,Веб страна,Работно време,Телефон,Емаил,Ид,Лат,Лон");
            writer.newLine();

            // Write data to the CSV file
            for (String key : db.keySet()) {
                writer.write(String.valueOf(db.get(key)));
                writer.newLine();
            }

            // Close the writer
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void processNode(JsonNode elementNode, HashMap<String, Node> db) {
        JsonNode tagsNode = elementNode.path("tags");
        String name = tagsNode.path("name").asText();
        String enName = tagsNode.path("name:en").asText();
        String phone = tagsNode.path("phone").asText();
        String email = tagsNode.path("email").asText();
        String website = tagsNode.path("website").asText();
        String opening_hours = tagsNode.path("opening_hours").asText();
        String religion = tagsNode.path("religion").asText();
        String id = elementNode.path("id").asText();
        String lat = elementNode.path("lat").asText();
        String lon = elementNode.path("lon").asText();


        if (name.isEmpty()) {
            if (enName.isEmpty()) {
//                new Node("prazno");
                return;
            } else {
                name = enName;
                enName = "";
            }
        }

        Node newNode = new Node(name, enName, phone, email, website, opening_hours, id, lat, lon, religion);

        if (db.containsKey(name)) {
            db.get(name).lon = lon;
            db.get(name).lat = lat;
        } else {
            db.put(name, newNode);
        }

    }

}
