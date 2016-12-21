package com.crazylabz.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindSecondMaxValueTest {

    FindSecondMaxValue findSecondMaxValue;

    private void workWith(int[] array){
        findSecondMaxValue = new FindSecondMaxValue(array);
    }

    @Test
    public void shouldReturnMinIntegerValueGivenEmptyArray() throws Exception {
        workWith(new int[]{});
        assertThat(findSecondMaxValue.find(), is(Integer.MIN_VALUE));
    }

    @Test
    public void shouldReturnMinIntegerValueGivenSingleItemArray(){
        workWith(new int[]{1});
        assertThat(findSecondMaxValue.find(), is(Integer.MIN_VALUE));
    }

    @Test
    public void shouldReturnValue1(){
        workWith(new int[]{2, 1});
        assertThat(findSecondMaxValue.find(), is(1));
    }

    @Test
    public void shouldReturnValue2(){
        workWith(new int[]{2, 1, 3});
        assertThat(findSecondMaxValue.find(), is(2));
    }

    @Test
    public void shouldReturnValue77(){
        workWith(new int[]{2,1, 3, 10, 0, 99, 77});
        assertThat(findSecondMaxValue.find(), is(77));
    }
}
