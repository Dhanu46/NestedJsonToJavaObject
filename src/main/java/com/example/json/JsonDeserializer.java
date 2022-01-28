package com.example.json;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class JsonDeserializer {

    public static void main(String[] args) throws URISyntaxException, IOException {
        final var fileReader = getFileFromResource("data.json");
        ObjectMapper mapper = new ObjectMapper();
        final JsonDataNode node = mapper.readValue(fileReader, JsonDataNode.class);
        System.out.println(node);
        final List<JsonDataNode.Row> rows = node.getRows();
        rows.forEach(System.out::println);

    }

    private static FileReader getFileFromResource(String fileName) throws URISyntaxException, FileNotFoundException {

        ClassLoader classLoader = JsonDeserializer.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {

            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());

            return new FileReader(new File(resource.toURI()));
        }

    }
}