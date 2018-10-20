package it.colbys;

import it.colbys.IOC.IOC;
import it.colbys.map.HashMap;
import it.colbys.map.IMap;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        String name = "list";
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        IOC.register(name, list);

        List resolvedList = IOC.resolve("list");
        System.out.println(resolvedList.get(0));

        IMap<String, Integer> map = new HashMap<>();

        boolean isMapEmpty = map.isEmpty();

        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("10", 10);
        map.put("11", 11);
        map.put("12", 12);
        map.put("13", 13);
        map.put("14", 14);
        map.put("15", 15);
        map.put("16", 16);
        map.put("17", 17);
        map.put("18", 19);

        int value = map.get("18");
        int size = map.getSize();

        int deletedValue = map.remove("18");

        Integer missingValue = map.get("18");
        int newSize = map.getSize();

        boolean isEmpty = map.isEmpty();

        System.out.println(value);
    }
}
