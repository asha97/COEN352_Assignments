package com.coen352.assignment1;

public interface ADTList<E> {
    void clear();

    void insert(E item);

    void append(E item);

    E remove();

    void moveToStart();

    void moveToEnd();

    void prev();

    void next();

    int length();

    int currPos();

    void moveToPos(int position);

    E getValue();
}
