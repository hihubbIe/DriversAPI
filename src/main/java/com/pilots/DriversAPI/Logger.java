package com.pilots.DriversAPI;

import java.util.Date;

public class Logger {
    public static void logGET(String endpoint) {
        System.out.println((new Date()).toString() + "\tAPI - GET" + " " + endpoint);
    }
    public static void logPOST(String endpoint, String data) {
        System.out.println((new Date()).toString() + "\tAPI - POST" + " " + endpoint + " : " + data);
    }
    public static void logPUT(String endpoint, String data) {
        System.out.println((new Date()).toString() + "\tAPI - PUT" + " " + endpoint + " : " + data);
    }
    public static void logDELETE(String endpoint) {
        System.out.println((new Date()).toString() + "\tAPI - DELETE" + " " + endpoint);
    }
}
