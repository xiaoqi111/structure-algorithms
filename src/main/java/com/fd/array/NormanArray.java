package com.fd.array;

public class NormanArray<T> extends AbstractArray {

    public NormanArray(int length) {
        super(length);
    }

    @Override
    public Object find(int index) {
        return getElement(index);
    }

    @Override
    public boolean delete(int index) {
        checkIndex(index);
        return moveForward(index);
    }

}
