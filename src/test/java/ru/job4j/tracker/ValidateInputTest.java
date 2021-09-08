package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"4"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(4));
    }

    @Test
    public void whenManyValidInput() {
        Output out = new StubOutput();
        String[] inMassiv = new String[] {"4", "5", "6"};
        Input in = new StubInput(inMassiv);
        ValidateInput input = new ValidateInput(out, in);
        for (int i = 0; i < inMassiv.length; i++) {
            int selected = input.askInt("Enter menu:");
            assertThat(selected, is(Integer.parseInt(inMassiv[i])));
        }
  /*      int selected = input.askInt("Enter menu:");
        assertThat(selected, is(4));
        selected = input.askInt("Enter menu:");
        assertThat(selected, is(5));
        selected = input.askInt("Enter menu:");
        assertThat(selected, is(6));*/
    }

    @Test
    public void whenInputLessZero() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1", "6"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(out.toString(), is("Please enter validate data again."
                + System.lineSeparator()));
    }
}