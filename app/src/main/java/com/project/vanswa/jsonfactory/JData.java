package com.project.vanswa.jsonfactory;

import java.util.HashMap;

/**
 * Created by vonstuben on 11/14/2015.
 */
public class JData implements Data {
    // figure out how the api will return the data to you and create the class based on it
    private HashMap Data = new HashMap();

    @Override
    public String getData(String key){return (String) Data.get(key);}

    @Override
    public void add(String key, String value) {
        Data.put(key,value);
    }
}
