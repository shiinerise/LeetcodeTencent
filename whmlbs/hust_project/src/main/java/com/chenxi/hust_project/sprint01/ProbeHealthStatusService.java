package com.chenxi.hust_project.sprint01;

import com.fasterxml.jackson.databind.util.JSONPObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ProbeHealthStatusService {

    private static String URL = "http://data.whmlbs.com:5002/api/v1/timeStamp/probe";

    public String getProbeHealthStatus(String[] timeStampArray, int sendInterval) {
        return null;
    }

    public static String loadJson(String url) {
        StringBuffer json = new StringBuffer();
        try {
            URL urlObject = new URL(url);
            URLConnection urlConnection = urlObject.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                json.append(inputLine);
            }
            reader.close();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json.toString();
    }

    public static String[] getTimeStampArray() {
        String json = loadJson(URL);
        System.out.println(json);
        JSONObject jsonObject = JSONObject.fromObject(json);
        JSONArray dataArray = jsonObject.getJSONArray("data");
        for(int i=0;i<dataArray.size();i++) {
            JSONObject jsonObject1 = dataArray.getJSONObject(i);
            JSONObject key = jsonObject1.getJSONObject("key");
            JSONArray timeStampArray = jsonObject1.getJSONArray("time_stamp_array");

        }

//        System.out.println(data);
        return null;
    }

    public static void main(String[] args) {
        getTimeStampArray();
    }
}
