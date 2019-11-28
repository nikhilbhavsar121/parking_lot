package com.gojek.parkinglot;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InputProcess
{
    CommandProcess commandprocess;
    ParkingLot parkingLot;

    public InputProcess()  {

        commandprocess=new CommandProcess();
            parkingLot=new ParkingLot();

    }
    public void fileTextInputProcess(String command)
    {
       String[] cmdArray=command.split(" ");
        switch (cmdArray.length)
        {
            //One element in command
            case 1:
                Method method1 =commandprocess.commandMap.get(cmdArray[0]);

                try {
                    if(method1 != null)
                    {
                        method1.invoke(parkingLot);
                    }else
                    {
                        System.out.println("Invalid input");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
                //Two element in command
            case 2:
                Method method2 =commandprocess.commandMap.get(cmdArray[0]);
                try {
                    if(method2 != null)
                    {
                        method2.invoke(parkingLot, cmdArray[1]);
                    }else
                    {
                        System.out.println("Invalid input");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
                //Three element in command
                case 3:
                  Method  method3 = commandprocess.commandMap.get(cmdArray[0]);
                    try {
                        if(method3 != null)
                        {
                            method3.invoke(parkingLot, cmdArray[1],cmdArray[2]);
                        }
                        else
                        {
                            System.out.println("Invalid input");
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

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
