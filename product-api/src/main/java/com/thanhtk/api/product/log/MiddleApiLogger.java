package com.thanhtk.api.product.log;


import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MiddleApiLogger {
    private MiddleApiLogger() {}

    private static final Gson GSON = new Gson();

    public static final Logger json = LogManager.getLogger("JSON");


    public static void log(Object object){
        String logMessage = GSON.toJson(object);
        json.info(logMessage);

    }
}
