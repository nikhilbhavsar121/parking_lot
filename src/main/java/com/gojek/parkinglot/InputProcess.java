package com.gojek.parkinglot;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InputProcess
{
    CommandProcess commandprocess;
    ParkingLot parkingLot;
    public InputProcess()  {
        try {
        commandprocess=new CommandProcess();
            parkingLot=new ParkingLot();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }


    public void fileTextInputProcess(String command)
    {
       String[] cmdArray=command.split(" ");
        switch (cmdArray.length)
        {
            //One element in command
            case 1:
                //Two element in command
            case 2:
                Method method =commandprocess.commandMap.get(cmdArray[0]);

                try {
                    if(method != null)
                    {
                        method.invoke(parkingLot, cmdArray[1]);
                    }else
                    {
                        System.out.println("Invalid input");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                //Three element in command
                case 3:
                    Method method1 = commandprocess.commandMap.get(cmdArray[0]);



        }

    }

    public void fileInputProcess() throws IOException
    {
        File file = new File("E://ParkingLot//Inputfile//input.txt");
        FileReader filereader = new FileReader(file);
        BufferedReader br = new BufferedReader(filereader);
        String line;
        while((line=br.readLine())!= null)
        {
            fileTextInputProcess(line.trim());
        }



    }
}
