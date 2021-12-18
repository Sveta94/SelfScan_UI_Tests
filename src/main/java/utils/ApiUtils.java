package utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.openqa.selenium.remote.http.HttpClient.USER_AGENT;

public class ApiUtils {

    public String scanEnterQR(String token) throws IOException {
        String url = "https://ssoboy.5ka.ru/sg-stage/main/basket";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // Setting basic post request
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept", "*/*");
        con.setRequestProperty("App-Version",  "1.22.0");
        con.setRequestProperty("Device-Type",  "mobileAndroid");
        con.setRequestProperty("Device-Id",  "4b3953324a583398");
        con.setRequestProperty("Authorization", "Bearer " + token);
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Encoding", " gzip, deflate, br");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Connection", "keep-alive");
        con.setRequestProperty("Content-Length", "57");
        String postJsonData = "{\n" +
                "\t\"storeKey\": \"6e71f27f-f65d-48f2-b2c6-9b5ed535c64a\"\n" +
                "}";
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(postJsonData);
        wr.flush();
        wr.close();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();
        while ((output = in.readLine()) != null) {
            response.append(output);
        }
        in.close();
        //printing result from response
        String resp = response.toString();
        return resp;
    }

    public String authorizationAPI() throws IOException {
        String url = "https://ssoboy.5ka.ru/sg-stage/auth/login/trusted";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // Setting basic post request
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Content-Type", "application/json");
        String postJsonData = "{\n" +
                "\t\"type\": \"phone\",\n" +
                "\t\"value\": \"+79152932655\"\n" +
                "}";
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(postJsonData);
        wr.flush();
        wr.close();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();
        while ((output = in.readLine()) != null) {
            response.append(output);
        }
        in.close();
        //printing result from response
        String resp = response.toString();
        String[] split = resp.split(":");
        String[] newSplit = split[1].split(",");
        String tok = newSplit[0];
        String token = tok.replace("\"", "");
        return token;
    }

    public String scanExitQR(String token) throws IOException {
        String url = "https://ssoboy.5ka.ru/sg-stage/main/basket/storeEndKeyCheck";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // Setting basic post request
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept", "*/*");
        con.setRequestProperty("App-Version",  "1.22.0");
        con.setRequestProperty("Device-Type",  "mobileAndroid");
        con.setRequestProperty("Device-Id",  "4b3953324a583398");
        con.setRequestProperty("Authorization", "Bearer " + token);
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Encoding", " gzip, deflate, br");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Connection", "keep-alive");
        con.setRequestProperty("Content-Length", "57");
        String postJsonData = "{\"storeEndKey\": \"e50bb057-bacf-45d6-8bee-e6af2f542b94\"}";
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(postJsonData);
        wr.flush();
        wr.close();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();
        while ((output = in.readLine()) != null) {
            response.append(output);
        }
        in.close();
        //printing result from response
        String resp = response.toString();
        return resp;
    }
}