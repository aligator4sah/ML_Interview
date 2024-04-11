package com.class99;

import java.util.LinkedHashMap;
import java.util.Map;

public class LInkedHashmapSample {
    public static void main(String[] args) {
        LinkedHashMap<String, String> accessOrderedMap = new LinkedHashMap<>(16, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest){
                return size() > 3;
            }
        };
        accessOrderedMap.put("Project1", "Valhalla"); 
        accessOrderedMap.put("Project2", "Panama");
        accessOrderedMap.put("Project3", "Loom");
        accessOrderedMap.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
        accessOrderedMap.get("Project2");
        accessOrderedMap.get("Project2");
        accessOrderedMap.get("Project3");
        System.out.println("Iterate over should not be affected");
        accessOrderedMap.forEach((k,v) -> {
            System.out.println(k + ": " + v);}
        );
        accessOrderedMap.put("Project4", "Mission Control");
        System.out.println("Oldest entry should be removed");
        accessOrderedMap.forEach((k,v) -> {
            System.out.println(k + ": " + v);
        });
        
    }
    
}
