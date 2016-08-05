package com.project.vanswa.jsonfactory;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.provider.MediaStore;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;

import javax.xml.transform.Result;


/**
 * Created by vonstuben on 11/14/2015.
 */
public class DataFactory {

    private ArrayList<JData> dataList;
    private JSONArray jsonDataArray;
    private JData parsedData;
    private Parser parser;
    private JSONObject jsonData;
    private String[] dataLocation = {"https://solstice.applauncher.com/external/contacts.json"};


    public DataFactory(){;
        setDataList(new ArrayList<JData>());
    }

    private class Parser extends AsyncTask<String,Void,String>
    {

        protected Result onPostExecute(Result result){
            SystemClock.sleep(6500); //I am not sure of a better way to stop the UI from beating the data in, if you have any tips I would appreciate them. I should use the on finish method from the Async task, will implement if there is more time
        return null;
        }
        //downloading data while on the UI thread.
        @Override
        protected String doInBackground(String... dataLocation){
            try {
                URL url = new URL(dataLocation[0]);

                try {
                    //build data from the url into a string
                    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                    StringBuilder json = new StringBuilder();
                    String line;

                    while((line = in.readLine()) !=null){
                        json.append(line);
                    }
                    in.close();
                    try {
                        //create jsonDataArray to be parsed
                        jsonDataArray = new JSONArray(json.toString());
                        //here is where I would parse the big and small images for the contacts, as I was running low on time I decided to include them manually. I apologize in advance for this.
//                        JSONObject jdata = new JSONObject();
//                        for(int i =0; i <jsonDataArray.length();i++){
//                            jdata = jsonDataArray.getJSONObject(i);
//                            url = new URL(jdata.getString("smallImageUrl"));
//                            try {
//                                url.openStream();
//
//                            }catch(IOException io){
//                                io.printStackTrace();
//                            }
//                        }


                    }catch (JSONException je) {
                        je.printStackTrace();
                    }
                }catch(IOException io){
                    io.printStackTrace();
                }
            }catch(MalformedURLException mf){
                mf.printStackTrace();
            }
        return null;
        }
    }

    public void create() {
        //create jdata object
        parser = new Parser();
        //parse the data and add it to a hashmap inside the data.
        //the data is shipped from the factory to the contactDaoImpl for extraction and creation of contact items.
        parser.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, dataLocation[0]);
        parser.onPostExecute(null);
        for (int i = 0; i < jsonDataArray.length(); i++) {
            try {
                parsedData = new JData();
                jsonData = jsonDataArray.getJSONObject(i);
                parsedData.add("name", jsonData.getString("name"));
                parsedData.add("employeeId", jsonData.getString("employeeId"));
                parsedData.add("company", jsonData.getString("company"));
                parsedData.add("work",jsonData.getJSONObject("phone").getString("work"));
                dataList.add(parsedData);
            } catch (JSONException js) {
                js.printStackTrace();
            }
        }
    }

    public ArrayList<JData> getDataList(){
        return dataList;
    }

    public void setDataList(ArrayList<JData> dataList) {
        this.dataList = dataList;
    }


}

