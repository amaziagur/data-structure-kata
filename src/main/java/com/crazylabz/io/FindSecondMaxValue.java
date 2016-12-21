package com.crazylabz.io;

public class FindSecondMaxValue {

    private final int[] array;

    public FindSecondMaxValue(int[] array) {
        this.array = array;
    }

    public int find() {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        if(array.length <= 1){
            return secondMax;
        } else {
            for (int i = 0; i < array.length; i++) {
                if(array[i] > max){
                    secondMax = max;
                    max = array[i];
                } else if(array[i] > secondMax){
                    secondMax = array[i];
                }
            }
        }

        return secondMax;
    }
}
