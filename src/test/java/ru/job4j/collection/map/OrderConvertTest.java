package ru.job4j.collection.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenDublicateOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("5sde", "Pants"));
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> mapExpect = new HashMap<>();
        mapExpect.put("3sfe", new Order("3sfe", "Dress"));
        mapExpect.put("5sde", new Order("5sde", "Pants"));
        HashMap<String, Order> mapResult = OrderConvert.process(orders);
        assertThat(mapResult, is(mapExpect));
    }

}