package system.design.cache;

import java.util.*;

public class LRUCache {

    Map<Integer, Integer> lru;
    Deque<Integer> lastAccessed;
    int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        lru = new HashMap<>(capacity);
        lastAccessed = new ArrayDeque<>();
    }

    public int get(int key) {
        if(lru.containsKey(key)){
            //remove this key from deque not just last element
            lastAccessed.removeFirstOccurrence(key);
            lastAccessed.offerLast(key);
            return lru.get(key);
        }
        else return -1;
    }

    public void put(int key, int value) {
        //if key in cache just update value
        if (lru.containsKey(key)){
            lru.replace(key, value);
            //we want to make sure once we update value in map
            //to reset it in deque as well
            lastAccessed.removeFirstOccurrence(key);
            lastAccessed.offerLast(key);
            return;}

        //key not in cache -  check size if >= capacity
        //move to the head
        if(capacity <= lru.size()){
            int lruKey = lastAccessed.removeFirst();
            lru.remove(lruKey);
        }
        lru.put(key, value);
        lastAccessed.offerLast(key);
    }
}

class AppRunner{
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.capacity);
        cache.put(2,1);
        cache.put(1,1);
        cache.get(2);
        cache.put(3,3);
        System.out.println(cache.lastAccessed.size());
        System.out.println(cache.get(2));

    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
