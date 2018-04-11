package com;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public final class DataControl {
    public static boolean CheckIfIDExists(Statement stmt, String tablename, Integer id){
        String sql = "";
        switch (tablename) {
            case "uganda.person":
                sql = "SELECT Person_ID FROM " + tablename;
                try {
                    ResultSet rs = stmt.executeQuery(sql);

                    List<Integer> idlist = new ArrayList<Integer>();
                    while (rs.next()) {
                        idlist.add(rs.getInt("Person_ID"));
                    }
                    if (idlist.indexOf(id)==-1)
                        return false;
                    else
                        return true;

                }catch (SQLException se) {
                    System.out.println("Czapek na peronie"); //Gdy połączenie nie udane.
                    se.printStackTrace();
                }
                break;
            case "uganda.soldier":
                sql = "SELECT Person_ID FROM " + tablename;
                try {
                    ResultSet rs = stmt.executeQuery(sql);

                    List<Integer> idlist = new ArrayList<Integer>();
                    while (rs.next()) {
                        idlist.add(rs.getInt("Soldier_ID"));
                    }
                    if (idlist.indexOf(id)==-1)
                        return false;
                    else
                        return true;

                }catch (SQLException se) {
                    System.out.println("Czapek na peronie"); //Gdy połączenie nie udane.
                    se.printStackTrace();
                }
                break;
            case "uganda.commander":
                sql = "SELECT Person_ID FROM " + tablename;
                try {
                    ResultSet rs = stmt.executeQuery(sql);

                    List<Integer> idlist = new ArrayList<Integer>();
                    while (rs.next()) {
                        idlist.add(rs.getInt("Commander_ID"));
                    }
                    if (idlist.indexOf(id)==-1)
                        return false;
                    else
                        return true;

                }catch (SQLException se) {
                    System.out.println("Czapek na peronie"); //Gdy połączenie nie udane.
                    se.printStackTrace();
                }
                break;
            case "uganda.engineer":
                sql = "SELECT Person_ID FROM " + tablename;
                try {
                    ResultSet rs = stmt.executeQuery(sql);

                    List<Integer> idlist = new ArrayList<Integer>();
                    while (rs.next()) {
                        idlist.add(rs.getInt("Engineer_ID"));
                    }
                    if (idlist.indexOf(id)==-1)
                        return false;
                    else
                        return true;

                }catch (SQLException se) {
                    System.out.println("Czapek na peronie"); //Gdy połączenie nie udane.
                    se.printStackTrace();
                }
                break;
            case "uganda.marksman":
                sql = "SELECT Person_ID FROM " + tablename;
                try {
                    ResultSet rs = stmt.executeQuery(sql);

                    List<Integer> idlist = new ArrayList<Integer>();
                    while (rs.next()) {
                        idlist.add(rs.getInt("Marksman_ID"));
                    }
                    if (idlist.indexOf(id)==-1)
                        return false;
                    else
                        return true;

                }catch (SQLException se) {
                    System.out.println("Czapek na peronie"); //Gdy połączenie nie udane.
                    se.printStackTrace();
                }
                break;
            case "uganda.tanker":
                sql = "SELECT Person_ID FROM " + tablename;
                try {
                    ResultSet rs = stmt.executeQuery(sql);

                    List<Integer> idlist = new ArrayList<Integer>();
                    while (rs.next()) {
                        idlist.add(rs.getInt("Tanker_ID"));
                    }
                    if (idlist.indexOf(id)==-1)
                        return false;
                    else
                        return true;

                }catch (SQLException se) {
                    System.out.println("Czapek na peronie"); //Gdy połączenie nie udane.
                    se.printStackTrace();
                }
                break;
            case "uganda.medic":
                sql = "SELECT Person_ID FROM " + tablename;
                try {
                    ResultSet rs = stmt.executeQuery(sql);

                    List<Integer> idlist = new ArrayList<Integer>();
                    while (rs.next()) {
                        idlist.add(rs.getInt("Medic_ID"));
                    }
                    if (idlist.indexOf(id)==-1)
                        return false;
                    else
                        return true;

                }catch (SQLException se) {
                    System.out.println("Czapek na peronie"); //Gdy połączenie nie udane.
                    se.printStackTrace();
                }
                break;
            case "uganda.equipment":
                sql = "SELECT Person_ID FROM " + tablename;
                try {
                    ResultSet rs = stmt.executeQuery(sql);

                    List<Integer> idlist = new ArrayList<Integer>();
                    while (rs.next()) {
                        idlist.add(rs.getInt("Equipment_ID"));
                    }
                    if (idlist.indexOf(id)==-1)
                        return false;
                    else
                        return true;

                }catch (SQLException se) {
                    System.out.println("Czapek na peronie"); //Gdy połączenie nie udane.
                    se.printStackTrace();
                }
                break;
            case "uganda.weapon":
                sql = "SELECT Person_ID FROM " + tablename;
                try {
                    ResultSet rs = stmt.executeQuery(sql);

                    List<Integer> idlist = new ArrayList<Integer>();
                    while (rs.next()) {
                        idlist.add(rs.getInt("Weapon_ID"));
                    }
                    if (idlist.indexOf(id)==-1)
                        return false;
                    else
                        return true;

                }catch (SQLException se) {
                    System.out.println("Czapek na peronie"); //Gdy połączenie nie udane.
                    se.printStackTrace();
                }
                break;
            case "uganda.vehicle":
                sql = "SELECT Person_ID FROM " + tablename;
                try {
                    ResultSet rs = stmt.executeQuery(sql);

                    List<Integer> idlist = new ArrayList<Integer>();
                    while (rs.next()) {
                        idlist.add(rs.getInt("Vehicle_ID"));
                    }
                    if (idlist.indexOf(id)==-1)
                        return false;
                    else
                        return true;

                }catch (SQLException se) {
                    System.out.println("Czapek na peronie"); //Gdy połączenie nie udane.
                    se.printStackTrace();
                }
                break;

            /*case "uganda.`organisation unit`":
                sql = "INSERT INTO " + tablename + " (Name, Type, Supervisor_ID) VALUES (";             //Do wyjebania
                paramlist.subList(3, paramlist.size()).clear();
                break;*/
        }
        return false;
    }

    public static boolean CheckIfNumeric (String argument) {
        if (StringUtils.isNumeric(argument) == true)
            return true;
        else
            return false;

    }

    public static boolean LengthControl (String argument, int length){
        if (argument.length()<=length)
            return true;
        else
            return false;

    }

    public static boolean isTankerPosition (String value){
        return com.resources.RestrictedValuesStrings.tankerPosition.contains(value);
    }
    public static boolean isEngineerType (String value){
        return com.resources.RestrictedValuesStrings.engineerType.contains(value);
    }
    public static boolean isEngineerDrink (String value){
        return com.resources.RestrictedValuesStrings.engineerDrink.contains(value);
    }
    public static boolean isSoldierRank (String value){
        return com.resources.RestrictedValuesStrings.soldierRank.contains(value);
    }
    public static boolean isWeaponCaliber (String value){
        return com.resources.RestrictedValuesStrings.equipmentType.contains(value);
    }
    public static boolean isEquipmentType (String value){
        return com.resources.RestrictedValuesStrings.weaponCaliber.contains(value);
    }


    public static boolean isHeightRange(String height){
        if(Integer.parseInt(height) >= 100 && Integer.parseInt(height) <= 300)
            return true;
        else
            return false;
    }

    public static boolean isWeightRange(String weight){
        if(Integer.parseInt(weight) >= 30 && Integer.parseInt(weight) <= 250)
            return true;
        else
            return false;
    }
    public static boolean isHeadshotPercentRange(String weight){
        if(Integer.parseInt(weight) >= 0 && Integer.parseInt(weight) <= 100)
            return true;
        else
            return false;
    }
    public static boolean isOrgUnitRange(String oid){
        if(Integer.parseInt(oid) >= 0 && Integer.parseInt(oid) <= 14)
            return true;
        else
            return false;
    }


}