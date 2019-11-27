package com.gojek.parkinglot;

import java.io.*;

public class Start
{
    public static  void main(String[] args) throws IOException, FileNotFoundException, NoSuchMethodException {
        InputProcess inputProcess=new InputProcess();
        switch(args.length)
        {
            case 0:
                for(;;) {
                    System.out.println("Please Enter Input");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    String cmd = bufferedReader.readLine();
                    inputProcess.fileTextInputProcess(cmd);
                }

            case 1:
                InputProcess inputParser=new InputProcess();
                inputParser.fileInputProcess();

        }


    }

}
