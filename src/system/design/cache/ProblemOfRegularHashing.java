package system.design.cache;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemOfRegularHashing {
    public static void main(String[] args) {
        /**
         * We have table of names we need to partition our table
         * such as each partition runs on it's own shard
         * Default we have 3 shards
         */
        String[] names = {"Nino", "Marina", "Anna", "Alan", "Bruno", "Test"};
        List<String> namesTable = new ArrayList<>(Arrays.asList(names));


        List<String> cacheShard1 = new ArrayList<>();
        List<String> cacheShard2 = new ArrayList<>();
        List<String> cacheShard3 = new ArrayList<>();


        List<List<String>> allServers = new ArrayList<>();
        allServers.add(cacheShard1);
        allServers.add(cacheShard2);
        allServers.add(cacheShard3);

        partitionTable(namesTable, allServers);

        /**
         * And it looks good: but hashFunction() deeply relays on totalNumberOfServers
         * What if we decide to scale up and add 2 more servers?
         *
         * We will need to re-hash all our values otherwise we will not be able to serve  /get  requests.
         * Let’s say we added additional shard and now we have  servers running:
         *    	http://.../getAge/name=”Bruno”
         * Now “Bruno” located in server 2 as previous shard.
         *
         * What we do is hash name param to find out which shard to redirect the request.
         *
         * OOOPS: But we do not have row with value name=”Bruno”

         * That’s where consistent hashing comes into the picture
         */
        System.out.println("Redirect to shard: " + hashFunction("Bruno", allServers.size() + 2));
        allServers.forEach(System.out::println);

    }

    /**
     * Partition data:
     * for each name call hashFunction and add name to the (partition) shard which corresponds
     * with the result of hashFunction()
     * We provide totalNumberOfServers all values will be in range of 0 -> totalNumberOfServers
     *
     * Example: hashFunction(Nino, 3) = 1 add Nino to allServers.get(1);
     */
    public static void partitionTable(List<String> namesTable, List<List<String>> allServers){
        namesTable.forEach(name -> {
        int server = hashFunction(name, allServers.size());
        allServers.get(server).add(name);
    });
    }


    public static int hashFunction(String value, int totalNumberOfServers){
        int sumOfChars = 0;
        int serverValueGoesTo;
        for (char c: value.toCharArray()){
            sumOfChars+=c;
        }
        serverValueGoesTo = sumOfChars%totalNumberOfServers;
        System.out.println(value + "-> hashed  " + serverValueGoesTo);
        return serverValueGoesTo;}
}
