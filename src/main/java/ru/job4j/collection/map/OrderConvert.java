package ru.job4j.collection.map;

import  java.util.HashMap;
import java.util.List;

public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order value : orders) {
            map.put(value.getNumber(), value);
        }
        return map;
    }
}