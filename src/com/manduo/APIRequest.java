package com.manduo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;

/**
 * Created by manduo dong on 10/9/16.
 *
 */
public class APIRequest {
    private String baseUrl = ("http://192.168.1.3/api/<key>/lights");
    private String requestType = "put";
    //private String path = "/1/state";
    private JSONObject jsonBody;
    private int[] ids;

    APIRequest(int id, JSONObject jsonBody) {
        this.ids = new int[] {id}; // = String.format("/%d/state", id);
        this.jsonBody = jsonBody;
    }

    APIRequest(int[] ids, JSONObject jsonBody) {
        this.ids = ids;
        this.jsonBody = jsonBody;
    }

    APIRequest(String baseUrl, String requestType, String path) {
        this.baseUrl = baseUrl;
        this.requestType = requestType;
        //this.path = path;
    }

    public void call() {
        for (int id : ids) {
            ClientConfig clientConfig = new DefaultClientConfig();
            Client client = Client.create(clientConfig);
            //client.addFilter(new LoggingFilter());
            WebResource webResource = client.resource(baseUrl + String.format("/%d/state", id));
            webResource.header("Content-Type", "application/json");
            webResource.header("Accept ", "application/json");
            //webResource.path(path);


            switch (requestType) {
                case "get":
                    webResource.get(ClientResponse.class);
                    break;
                case "put":
                    //System.out.println(jsonBody.toString());
                    //System.out.println(webResource.getURI());
                    webResource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, jsonBody.toString());
                    break;
                default:
                    webResource.post(ClientResponse.class);
                    break;
            }

        }
    }
}
