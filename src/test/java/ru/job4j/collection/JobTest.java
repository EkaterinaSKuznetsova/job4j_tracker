package ru.job4j.collection;
import org.junit.Test;
import ru.job4j.poly.PolyUsage;
import ru.job4j.tracker.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new SortJobByNameDec().thenComparing(
                new SortJobIdByPriorityDec());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriorityInc() {
        Comparator<Job> cmpNamePriority = new SortJobByNameInc().thenComparing(
                new SortJobIdByPriorityInc());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameInc() {
        List<Job> in =   Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Testing", 3),
                new Job("Impl task", 0)

        );
        List<Job> out = List.of(
                new Job("Fix bug", 1),
                new Job("Impl task", 0),
                new Job("Testing", 3)
        );
        Collections.sort(in, new SortJobByNameInc());
        assertThat(in.get(0).getName(), is(out.get(0).getName()));
        assertThat(in.get(1).getName(), is(out.get(1).getName()));
        assertThat(in.get(2).getName(), is(out.get(2).getName()));

    }

    @Test
    public void whenComparatorByNameDec() {
        List<Job> in =   Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Testing", 3),
                new Job("Impl task", 0)

        );
        List<Job> out = List.of(
                new Job("Testing", 3),
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        Collections.sort(in, new SortJobByNameDec());
        assertThat(in.get(0).getName(), is(out.get(0).getName()));
        assertThat(in.get(1).getName(), is(out.get(1).getName()));
        assertThat(in.get(2).getName(), is(out.get(2).getName()));

    }

    @Test
    public void whenComparatorByPriorityDec() {
        List<Job> in =   Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Testing", 3),
                new Job("Impl task", 0)

        );
        List<Job> out = List.of(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Testing", 3)
        );
        Collections.sort(in, new SortJobIdByPriorityDec());
        assertThat(in.get(0).getPriority(), is(out.get(0).getPriority()));
        assertThat(in.get(1).getPriority(), is(out.get(1).getPriority()));
        assertThat(in.get(2).getPriority(), is(out.get(2).getPriority()));

    }

    @Test
    public void whenComparatorByPriorityInc() {
        List<Job> in =   List.of(
                new Job("Fix bug", 1),
                new Job("Testing", 3),
                new Job("Impl task", 0)

        );
        List<Job> out = List.of(
                new Job("Testing", 3),
                new Job("Fix bug", 1),
                new Job("Impl task", 0)

        );
        Collections.sort(in, new SortJobIdByPriorityInc());
        assertThat(in.get(0).getPriority(), is(out.get(0).getPriority()));
        assertThat(in.get(1).getPriority(), is(out.get(1).getPriority()));
        assertThat(in.get(2).getPriority(), is(out.get(2).getPriority()));
    }

}