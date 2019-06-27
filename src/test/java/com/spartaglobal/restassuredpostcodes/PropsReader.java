package com.spartaglobal.restassuredpostcodes;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropsReader {

    private String apiKey;

    public PropsReader() {
        Properties props = new Properties();

        try {
            props.load(new FileReader("resources/app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        apiKey = props.getProperty("api_key");
    }

    public String getApiKey() {
        return apiKey;
    }
}
