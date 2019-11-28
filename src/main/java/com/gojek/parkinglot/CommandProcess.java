package com.gojek.parkinglot;

import java.lang.reflect.Method;
import java.util.HashMap;

public class CommandProcess
{
    HashMap<String, Method> commandMap;
    public CommandProcess()  {
        commandMap = new HashMap<String, Method>();
        try {
            addDataToMAP();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
  //Creat the MAP to invoke method using command
    public void addDataToMAP() throws NoSuchMethodException
    {
        commandMap.put("create_parking_lot",ParkingLot.class.getMethod("createParkingLot", String.class));
        commandMap.put("park",ParkingLot.class.getMethod("park", String.class,String.class));
        commandMap.put("leave",ParkingLot.class.getMethod("leave", String.class));
    }
}
