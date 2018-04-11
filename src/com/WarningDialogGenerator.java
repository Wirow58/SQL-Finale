package com;

import javax.swing.*;

public final class WarningDialogGenerator {
    private static String[] personString = {"Name to long","Surname to long","Height not numeric","Weight not numeric","Height not in range","Weight not in range"};
    public static void personWarning(boolean[] c){
        String problemString = "";
        for(int i =0; i< c.length; i++){
            if(!c[i])
                problemString = problemString + personString[i];
        }
        JOptionPane.showMessageDialog(null,
                "Wrong data input \nPlease correct entered data\nProblem occurred in: " + problemString,
                "Warning",
                JOptionPane.WARNING_MESSAGE);
    }
    private static String[] soldierString = {"Soldier ID not numeric","Soldier ID not correct ID","Kills not numeric","Incorrect Rank","Incorrect Organisation unit","Supervising Soldier ID not numeric","Supervising Soldier ID not correct ID"};
    public static void soldierWarning(boolean[] c){
        String problemString = "";
        for(int i =0; i< c.length; i++){
            if(!c[i])
                problemString = problemString + soldierString[i];
        }
        JOptionPane.showMessageDialog(null,
                "Wrong data input \nPlease correct entered data\nProblems: " + problemString,
                "Warning",
                JOptionPane.WARNING_MESSAGE);
    }
    private static String[] commanderString = {"Commander ID not numeric" , "Commander ID not correct ID", "Incorrect Supervised Organisation Unit"};
    public static void commanderWarning(boolean[] c){
        String problemString = "";
        for(int i =0; i< c.length; i++){
            if(!c[i])
                problemString = problemString + commanderString[i];
        }
        JOptionPane.showMessageDialog(null,
                "Wrong data input \nPlease correct entered data\nProblems: " + problemString,
                "Warning",
                JOptionPane.WARNING_MESSAGE);
    }
    private static String[] engineerString = {"Engineer ID not numeric" , "Engineer ID not correct ID", "Incorrect Energy Drink", "Incorrect Engineer Type"};
    public static void engineerWarning(boolean[] c){
        String problemString = "";
        for(int i =0; i< c.length; i++){
            if(!c[i])
                problemString = problemString + engineerString[i];
        }
        JOptionPane.showMessageDialog(null,
                "Wrong data input \nPlease correct entered data\nProblems: " + problemString,
                "Warning",
                JOptionPane.WARNING_MESSAGE);
    }
    private static String[] marksmanString = {"Marksman ID not numeric" , "Marksman ID not correct ID", "Headshot percent not nuemric","Headshot percent not in range"};
    public static void marksmanWarning(boolean[] c){
        String problemString = "";
        for(int i =0; i< c.length; i++){
            if(!c[i])
                problemString = problemString + marksmanString[i];
        }
        JOptionPane.showMessageDialog(null,
                "Wrong data input \nPlease correct entered data\nProblems: " + problemString,
                "Warning",
                JOptionPane.WARNING_MESSAGE);
    }
    private static String[] tankerString = {"Tanker ID not numeric" , "Tanker ID not correct ID", "Incorrect tanker position"};
    public static void tankerWarning(boolean[] c){
        String problemString = "";
        for(int i =0; i< c.length; i++){
            if(!c[i])
                problemString = problemString + tankerString[i];
        }
        JOptionPane.showMessageDialog(null,
                "Wrong data input \nPlease correct entered data\nProblems: " + problemString,
                "Warning",
                JOptionPane.WARNING_MESSAGE);
    }

    private static String[] medicString = {"Medic ID not numeric" , "Medic ID not correct ID", "Revives not numeric"};
    public static void medicWarning(boolean[] c){
        String problemString = "";
        for(int i =0; i< c.length; i++){
            if(!c[i])
                problemString = problemString + medicString[i];
        }
        JOptionPane.showMessageDialog(null,
                "Wrong data input \nPlease correct entered data\nProblems: " + problemString,
                "Warning",
                JOptionPane.WARNING_MESSAGE);
    }
    private static String[] equipmentString = {"Incorrect Equipment type","Owner ID not numeric" , "Owner ID not correct ID"};
    public static void equipmentWarning(boolean[] c){
        String problemString = "";
        for(int i =0; i< c.length; i++){
            if(!c[i])
                problemString = problemString + equipmentString[i];
        }
        JOptionPane.showMessageDialog(null,
                "Wrong data input \nPlease correct entered data\nProblems: " + problemString,
                "Warning",
                JOptionPane.WARNING_MESSAGE);
    }
    private static String[] vehicleString = {"Vehicle ID not numeric" , "Vehicle ID not correct ID", "Incorrect fuel type", "Number of seats not numeric","ModelName to long"};
    public static void vehicleWarning(boolean[] c){
        String problemString = "";
        for(int i =0; i< c.length; i++){
            if(!c[i])
                problemString = problemString + vehicleString[i];
        }
        JOptionPane.showMessageDialog(null,
                "Wrong data input \nPlease correct entered data\nProblems: " + problemString,
                "Warning",
                JOptionPane.WARNING_MESSAGE);
    }
    private static String[] weaponString = {"Weapon ID not numeric" , "Weapon ID not correct ID", "Incorrect Caliber", "Magazine capacity not numeric","ModelName to long"};
    public static void weaponWarning(boolean[] c){
        String problemString = "";
        for(int i =0; i< c.length; i++){
            if(!c[i])
                problemString = problemString + weaponString[i] + " ";
        }
        JOptionPane.showMessageDialog(null,
                "Wrong data input \nPlease correct entered data\nProblems: " + problemString,
                "Warning",
                JOptionPane.WARNING_MESSAGE);
    }
}
