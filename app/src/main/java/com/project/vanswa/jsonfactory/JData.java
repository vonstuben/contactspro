package com.project.vanswa.jsonfactory;

import java.util.HashMap;

/**
 * Created by vonstuben on 11/14/2015.
 */
public class JData implements Data {
    // figure out how the api will return the data to you and create the class based on it
   HashMap Data = new HashMap();

    @Override
    public void get(String key){
        Data.get(key);
    }

    @Override
    public void add(String key, String value) {
        Data.put(key,value);
    }
}
