package com.spartaglobal.restassuredpostcodes;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class MoviesHTTPManager {

    private String baseUri;
    private String apiKey;
    //maybe make movieSearch take an input to search for movies by title
    private String movieSearch;

    public MoviesHTTPManager() {
        PropsReader propsReader = new PropsReader();
        baseUri = "http://www.omdbapi.com/";
        apiKey = "?apikey=" + propsReader.getApiKey();
        movieSearch = "&t=c*";
    }
    //http://www.omdbapi.com/?apikey=[yourkey]&
    public String getMovie(){
        //we are preparing an empty object
        String jsonBody = null;

        //client for managing the call itself
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //httpget object structures our url and sets up the Get call
        HttpGet getMovie = new HttpGet(baseUri + apiKey + movieSearch);
        try {
            //The response is an object that contains all of the details within the http response message
            CloseableHttpResponse response = httpClient.execute(getMovie);
            //specifically uses the EntityUtils object to gain access to the response body
            jsonBody = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonBody;
    }
}
