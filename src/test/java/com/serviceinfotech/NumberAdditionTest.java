package com.serviceinfotech;

import org.junit.Assert;
import org.junit.Test;

public class NumberAdditionTest {

    @Test
    public void shouldAddTwoNumbers() throws Exception {

        int number1 = 2;
        int number2 = 2;
        NumberAddition numberAddition = new NumberAddition(number1, number2);
        int result = numberAddition.add();
        Assert.assertEquals(4, result);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionWhenNullNumbers() throws Exception {
        new NumberAddition(null, null).add();
    }
}
