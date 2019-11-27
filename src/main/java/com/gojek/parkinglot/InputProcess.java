package com.gojek.parkinglot;

import java.io.*;

public class InputProcess
{
    public void fileTextInputProcess(String command)
    {
       String[] cmdArray=command.split(" ");




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
