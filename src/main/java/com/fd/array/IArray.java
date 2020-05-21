package com.fd.array;

public interface IArray {

    Object find(int index);

    boolean delete(int index);

    void update(int index,Object obj);

    void insert(int index,Object obj);
    void insert(Object obj);

    int size();

    boolean exits(Object number);

    boolean isEmpty();

    void display();



}
