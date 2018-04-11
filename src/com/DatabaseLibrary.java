package com;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public final class DatabaseLibrary {
    public static void DeleteRecord(Connection conn, Statement stmt, String tablename, Integer id) {
        String sql = "";
        try {
            System.out.println("Creating delete statement...");
            switch (tablename) {
                case "uganda.person":
                    sql = "DELETE FROM " + tablename + " WHERE Person_ID = " + id;
                    break;
                case "uganda.equipment":
                    sql = "DELETE FROM " + tablename + " WHERE Equipment_ID = " + id;
                    break;
            }
            // String sql = "DELETE FROM "+tablename+" WHERE "+tablename+"_ID = "+id;
            stmt.executeUpdate(sql);
        } catch (SQLException se) {
            System.out.println("Czapek na peronie zwalił delete"); //Gdy połączenie nie udane.}
            se.printStackTrace();
        }

       /* try {
            //conn.commit();
        } catch (SQLException se) {
            System.out.println("Czapek na peronie nie pchnął commita na delete");
            se.printStackTrace();
        }*/
    }

    public static void AddRecord(Connection conn, Statement stmt, String tablename, List<String> paramlist) {
        String sql = "";
        switch (tablename) {
            case "uganda.person":
                sql = "INSERT INTO " + tablename + " (Name, Surname, Height, Weight) VALUES (";
                break;
            case "uganda.soldier":
                sql = "INSERT INTO " + tablename + " (Kills, Rank, SupervisingUnit_ID, SupervisingSoldier_ID) VALUES (";
                break;
            case "uganda.commander":
                sql = "INSERT INTO " + tablename + " (SupervisedUnit_ID) VALUES (";
                paramlist.subList(1, paramlist.size()).clear();
                break;
            case "uganda.engineer":
                sql = "INSERT INTO " + tablename + " (FavouriteEnergyDrink, EngineerType) VALUES (";
                paramlist.subList(2, paramlist.size()).clear();
                break;
            case "uganda.marksman":
                sql = "INSERT INTO " + tablename + " (HeadshotPercent) VALUES (";
                paramlist.subList(1, paramlist.size()).clear();
                break;
            case "uganda.tanker":
                sql = "INSERT INTO " + tablename + " (Position) VALUES (";
                paramlist.subList(1, paramlist.size()).clear();
                break;
            case "uganda.medic":
                sql = "INSERT INTO " + tablename + " (Revives) VALUES (";
                paramlist.subList(1, paramlist.size()).clear();
                break;
            case "uganda.equipment":
                sql = "INSERT INTO " + tablename + " (Type, ProductionDate, Owner_ID) VALUES (";
                paramlist.subList(3, paramlist.size()).clear();
                break;
            case "uganda.weapon":
                sql = "INSERT INTO " + tablename + " (Caliber, MagazineCapacity, ModelName) VALUES (";
                paramlist.subList(3, paramlist.size()).clear();
                break;
            case "uganda.vehicle":
                sql = "INSERT INTO " + tablename + " (TypeofFuel, NumberOfSeats, ModelName) VALUES (";
                paramlist.subList(3, paramlist.size()).clear();
                break;
            case "uganda.`organisation unit`":
                sql = "INSERT INTO " + tablename + " (Name, Type, Supervisor_ID) VALUES (";
                paramlist.subList(3, paramlist.size()).clear();
                break;
        }
        try {
            System.out.println("Creating add statement...");
            //sql = sql + "INSERT INTO "+ tablename + " (...) "+"VALUES ("; //!!!!!!!!!!!!!!!!!!!!!

            for (int i = 0; i < paramlist.size(); i++) {
                if (i == 0) {
                    sql = sql + "'" + paramlist.get(i) + "'";
                } else {
                    sql = sql + ", " + "'" + paramlist.get(i) + "'";
                }
            }
            sql = sql + ")";

            stmt.executeUpdate(sql);

        } catch (SQLException se) {
            System.out.println("Czapek na peronie zwalił add"); //Gdy połączenie nie udane.}
            se.printStackTrace();
        }

    }
}