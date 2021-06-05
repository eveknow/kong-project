package com.thanhtk.api.product.log;

import com.google.gson.Gson;
import com.thanhtk.api.product.exception.HandledException;
import lombok.extern.java.Log;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LogUtil {

    public static Consumer<LogModel> HandlerLog = p -> {
        p.end();
        MiddleApiLogger.log(p);
    };


    public static <T> T log(LogModel logModel, Supplier<T> supplier){
        try {
            T object = supplier.get();
            String response = new Gson().toJson(object);
            logModel.setResponse(response);
            return object;
        } catch (HandledException e) {
            logModel.setResponse(e.getMessage());
            throw e;
        }catch (Exception e) {
            logModel.setResponse(e.getMessage());
            throw e;
        }finally {
            HandlerLog.accept(logModel);
        }
    }
}
