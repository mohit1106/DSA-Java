// find the path or journey from the given tickets(one way )
// find the starting point i.e the place that can't be reached from anywhere else, i.e it is not in (to)destinations but exist in (from) data

import java.util.*;

public class itineraryAndTickets {
    public static String getStart(HashMap<String, String> tickets){
        HashMap<String, String> revMap = new HashMap<>();

        for(String key : tickets.keySet()){
            revMap.put(tickets.get(key), key);
        }
        // starting will be the key which exist in tickets(from to map) but not in revMap(to from map)
        for(String key : tickets.keySet()){
            if(!revMap.containsKey(key)) return key;
        }
        return null;
    }
    public static void main(String[] args) {

        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("chennai", "bengaluru"); // ticket (from) chennai (to) bengaluru
        tickets.put("mumbai", "delhi");
        tickets.put("goa", "chennai");
        tickets.put("delhi", "goa");

        String start = getStart(tickets);
        System.out.print(start);
        for(String key : tickets.keySet()){
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }
        System.out.println();
    }
}
