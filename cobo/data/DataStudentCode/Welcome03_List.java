/*
 * Arrays of objects
 */

import core.data.*;
import java.util.Arrays;
// import java.util.Scanner;

public class Welcome03_List {
   public static void main(String[] args) {
      DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/index.xml").load();
      WeatherStation[] allstns = ds.fetchArray("WeatherStation", "station/station_name",
             "station/station_id", "station/state",
             "station/latitude", "station/longitude");
      System.out.println("Total stations: " + allstns.length);

      WeatherStation[] nystns = new WeatherStation[50];
      int count = 0;
      for(int i = allstns.length-1; i >= 0; i--){
        if(allstns[i].isLocatedInState("NY")){
          nystns[count] = allstns[i];
          count++;
        }
      }
      System.out.println(Arrays.toString(nystns));

      WeatherStation southern = allstns[allstns.length-1];
      for(int i = allstns.length-2; i >= 0; i--){
        if(allstns[i].getLat() < southern.getLat()){
          southern = allstns[i];
        }
      }
      System.out.println("Southern most station: " + southern);
    }
}

class WeatherStation {
   private String name;
   private String id;
   private String state;
   private double lat;
   private double lng;

   WeatherStation(String name, String id, String state, double lat, double lng) {
      this.name = name;
      this.id = id;
      this.lat = lat;
      this.lng = lng;
      this.state = state;
   }

   /* Produce the id of this station */
   public double getLat() {
      return lat;
   }


   /* Produce the id of this station */
   public String getId() {
      return id;
   }

   /* Produce the name of this station */
   public String getName() {
      return name;
   }

   /* Determine if this weather station is located in the given state */
   public boolean isLocatedInState(String st) {
      return this.state.equals(st);
   }

   public String toString(){
     return getName() + " - " + getId();
   }
}
