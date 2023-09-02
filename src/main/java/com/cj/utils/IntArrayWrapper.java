package com.cj.utils;

import java.util.Arrays;

public class IntArrayWrapper {
    public int[] array;

    public IntArrayWrapper(int[] array) {
        this.array = array;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IntArrayWrapper) {
            IntArrayWrapper other = (IntArrayWrapper) obj;
            return Arrays.equals(array, other.array);
        }
        return false;
    }
}