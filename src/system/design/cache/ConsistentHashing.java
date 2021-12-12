package system.design.cache;


import java.util.*;
import java.util.stream.Stream;

public class ConsistentHashing {

    public static void main(String[] args) {
        String[] servers = {"127.0.0.145","127.0.0.453", "127.0.0.657"};
        String[] values = {"Nino", "Marina", "Anna", "Alan", "Bruno", "Test"};
        Map<Integer, String> hashedServers = new HashMap<>();
        SortedSet<Integer> serversAngles = new TreeSet<>();


        String[] hashRing = new String[365];

        /**
         * Add servers to hash ring by hashing they ip address
         * My hashFunction is not very smart
         * so severs are very close to each other on the hash ring
         * 127.0.0.145-> hashed  94
         * 127.0.0.453-> hashed  179
         * 127.0.0.657-> hashed  320
         *
         * Ideally they should be evenly distributed on the hash circle
         */
        Stream.of(servers).forEach(server -> {
            int serverAngle = hashFunction(server);
            hashedServers.put(serverAngle, server);
            serversAngles.add(serverAngle);
        });

       /**   Hash values
        Nino-> hashed  39
        Marina-> hashed  235
        Anna-> hashed  17
        Alan-> hashed  15
        Bruno-> hashed  153
        Test-> hashed  51*/
        Stream.of(values).forEach(value -> {
          int hasehdValue = hashFunction(value);
          /**  Find next largest num in set
          Which represents next server clockwise in the hash ring
          binary search can be used here
          but for simplicity i'll use iterative search*/
            boolean isValueAdded = false;
            for (int server: serversAngles){
                if (server >= hasehdValue){
                    System.out.println(value + " : added to server " + hashedServers.get(server));
                    isValueAdded = true;
                    break;
                }
            }
            /**if there no Server with hash code > value hash code
            we need to wrap around, taking the first one from the list*/
            int fistServerOnTheHashRing = serversAngles.iterator().next();
            if (!isValueAdded) System.out.println(value + " : added to server " + hashedServers.get(fistServerOnTheHashRing));
        });


    }

    /**
     * No need to add to hash ring
     * The ring is abstract
     * @param value
     * @param hashRing
     */
    public static void addToHashRing(String value, String[] hashRing){
        hashRing[hashFunction(value)] = value;
    }


    public static int hashFunction(String value){
        int hashRingSize = 365;
        int sumOfChars = 0;
        int serverValueGoesTo;
        for (char c: value.toCharArray()){
            sumOfChars+=c;
        }
        serverValueGoesTo = sumOfChars%hashRingSize;
        //System.out.println(value + "-> hashed  " + serverValueGoesTo);
        return serverValueGoesTo;}
}



