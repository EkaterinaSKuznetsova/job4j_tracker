package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SortItemReversByIdTest {

    @Test
    public  void sortRevers() {
        Item first = new Item(1, "first");
        Item second = new Item(2, "second");
        Item third = new Item(3, "third");
        List<Item> in =   Arrays.asList(first, third, second);
        List<Item> out = Arrays.asList(third, second, first);
        Collections.sort(in, new SortItemReversById());
        assertThat(in, is(out));
    }

}