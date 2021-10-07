package ru.job4j.tracker;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void sortItem() {
        Item first = new Item(1, "first");
        Item second = new Item(2, "second");
        Item third = new Item(3, "third");
        List<Item> in =  Arrays.asList(third, first, second);
        List<Item> out = Arrays.asList(first, second, third);
        Collections.sort(in);
        assertThat(in, is(out));
    }

}