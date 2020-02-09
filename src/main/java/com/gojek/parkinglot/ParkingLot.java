package com.gojek.parkinglot;

import org.omg.PortableServer.POAPackage.ObjectAlreadyActive;
import sun.awt.image.IntegerComponentRaster;

import java.util.*;

public class ParkingLot
{
    int MAX_LOT_VALUE;
    List<Integer> remainingSlotList;
    public class Car
    {
        String regNo;
        String colour;

        public Car(String regNo, String colour) {
            this.regNo = regNo;
            this.colour = colour;
        }
    }
    //Map for slot and car
    Map<String,Car> scmap;

    //Map for RegNo and slot
    Map<String,String> rgslotMap;

    // Map of Color, List of RegNo
    Map<String, ArrayList<String>> map3;

    public void createParkingLot(String lotValue)
    {
        this.MAX_LOT_VALUE=Integer.parseInt(lotValue);
        this.remainingSlotList=new ArrayList<Integer>();
        for (int i=1;i<=MAX_LOT_VALUE;i++)
        {
            remainingSlotList.add(i);
        }
        this.scmap = new HashMap<String, Car>();
        this.rgslotMap = new HashMap<String, String>();
        this.map3 = new HashMap<String, ArrayList<String>>();

        System.out.println("Congratulation parking lot created for"+this.MAX_LOT_VALUE+"slot");
    }

    public void park(String regNo, String color)
    {
        //check parkinglot created or not
        if(this.MAX_LOT_VALUE == 0)
        {
            System.out.println("PARKINGLOT NOT CREATED");
        }
        // check parkinglot full or not
        else if(this.scmap.size() == this.MAX_LOT_VALUE)
        {
            System.out.println("PARKINGLOT FULL");

        }else {
            Car car = new Car(regNo, color);
            Collections.sort(remainingSlotList);
            String slot = remainingSlotList.get(0).toString();
            this.scmap.put(slot, car);
            this.rgslotMap.put(regNo,slot);
            if(map3.containsKey(color))
            {
                ArrayList<String> regNos=this.map3.get(color);
                this.map3.remove(color);
                regNos.add(regNo);
                this.map3.put(color,regNos);
            }else {
                ArrayList<String> nRegNo = new ArrayList<String>();
                nRegNo.add(regNo);
                this.map3.put(color, nRegNo);
            }
            System.out.println("Allocated slot number" + " " + slot);
            remainingSlotList.remove(0);
        }
    }

    public void leave(String leaveSlot)
    {
        if(this.MAX_LOT_VALUE <= 0)
        {
            System.out.println("Sorry,Parkinglot not created");
        }
        else if(this.scmap.size()>0) {
            Car carLeave = this.scmap.get(leaveSlot);
            if (carLeave != null) {
                this.scmap.remove(leaveSlot);
                this.rgslotMap.remove(carLeave.regNo);
                ArrayList<String> reglist = this.map3.get(carLeave.colour);
                if (reglist.contains(carLeave.regNo)) {
                    reglist.remove(carLeave.regNo);
                }
                //add the slot number to remaining slot list
                this.remainingSlotList.add(Integer.parseInt(leaveSlot));
                System.out.println("Slot number " + leaveSlot + " is free");
                System.out.println();
            }
            else {
                System.out.println("Slot number " + leaveSlot + " is already empty");
                System.out.println();
            }
        }
       else
           {
            System.out.println("Parking lot is empty");
            System.out.println();
            }
    }

    public void status()
    {
        if(this.MAX_LOT_VALUE <= 0)
        {
            System.out.println("Sorry,Parkinglot not created");
        } else if(this.scmap.size() > 0)
        {
        System.out.println("Slot" + " " + "Reg Num" + " " + "Color");
        Set<Map.Entry<String, Car>> entries = this.scmap.entrySet();

        for (Map.Entry<String, Car> singleEntry : entries) {
            String slotNum = singleEntry.getKey();
            Car car = singleEntry.getValue();
            String regNo = car.regNo;
            String color = car.colour;
            System.out.println(slotNum + " " + regNo + " " + color + " ");
        }
    }
    }
    public void getRegistrationNumbersFromColor(String color)
    {
        ArrayList<String> regNumbers= this.map3.get(color);
        for (String singleRegNum:regNumbers)
        {
            System.out.println(singleRegNum+"  ");
        }

    }

    public void getSlotNumbersWithGivenColor(String color)
    {
        ArrayList<String> regNumberList = this.map3.get(color);
        for (String regNo:regNumberList)
        {
          String slotNumber = this.rgslotMap.get(regNo);
            System.out.println(slotNumber+"  ");
        }
    }

    public void getSlotNumberForRegNo(String RegNo)
    {
        String slotNumber = this.rgslotMap.get(RegNo);
        System.out.println(slotNumber+"  ");
    }
}
