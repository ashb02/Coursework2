package Controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccommodationDetailsController {

    public static void listAccommodationDetails(){
        try{
            PreparedStatement ps = db.prepareStatement("SELECT TripID, DayNumber, AccommodationID FROM AccommodationDetails");

            ResultSet results = ps.executeQuery();
            while(results.next()){
                int TripID = results.getInt(1);
                int DayNumber = results.getInt(2);
                int AccommodationID = results.getInt(3);
                System.out.println(TripID + " " + DayNumber + " " + AccommodationID);
            }
        } catch(Exception exception){
            System.out.println("Database error: " + exception.getMessage());
        }


        public static void insertAccommodationDetails(int TripID, int DayNumber, int AccommodationID){
            try {
                PreparedStatement ps = db.prepareStatement("INSERT INTO AccommodationDetails (TripID, Daynumber, AccommodationID) VALUES (?, ?, ?");
                ps.setInt(1, TripID);
                ps.setInt(2, DayNumber);
                ps.setInt(3, AccommodationID);
                ps.executeUpdate();
                System.out.println("Record added to AccommodationDetails");

            } catch (Exception exception) {
                System.out.println("Database error: " + exception.getMessage());
            }
        }


        public static void updateAccommodationDetails(int TripID, int DayNumber, int AccommodationID){
            try{
                PreparedStatement ps = db.prepareStatement("UPDATE AccommodationDetails SET TripID = ?, DayNumber = ?, AccommodationID = ?");
                ps.setInt(1, TripID);
                ps.setInt(2, DayNumber);
                ps.setInt(3, AccommodationID);

            } catch(Exception exception){
                System.out.println("Database error: " + exception.getMessage());
            }
        }


        public static void deleteAccommodationDetails(int TripID, int DayNumber,  int AccommodationID){
            try{
                PreparedStatement ps = db.prepareStatement("DELETE FROM Accommodation WHERE TripID = ?, DayNumber = ?, AccommodationID = ?");
                ps.setInt(1, TripID);
                ps.setInt(2, DayNumber);
                ps.setInt(3, AccommodationID);
                ps.executeUpdate();

            } catch(Exception exception){
                System.out.println("Database error: " + exception.getMessage());
            }
        }
}
