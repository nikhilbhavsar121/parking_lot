package com.gojek.parkinglot;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InputProcess
{
    CommandProcess commandprocess;
    static ParkingLot parkingLot;

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
                        System.out.println("Invalid Command");
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

                    }else if(Integer.parseInt(cmdArray[1]) < 0)
                    {
                        System.out.println("please provide positive slot number");
                    }
                    else
                    {
                        System.out.println("Invalid Command");
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
                            System.out.println("Invalid Command");
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

        }

    }

    public void fileInputProcess(String filePath)
    {
        File inputFile = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    fileTextInputProcess(line.trim());
                }
            } catch (IOException ex) {
                System.out.println("Error in reading the input file.");
                ex.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found in the path specified.");
            e.printStackTrace();
        }
    }
}
