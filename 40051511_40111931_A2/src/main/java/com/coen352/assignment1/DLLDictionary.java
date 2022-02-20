package com.coen352.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DLLDictionary<Key, E extends Comparable<E>> implements ADTDictionary<Key, E> {
    private final DoubleLinkedList<KVpair<Key, E>> list;

    //constructors
    public DLLDictionary() {
        list = new DoubleLinkedList<>();
    }

    public DLLDictionary(DLLDictionary dllDictionary) {
        this.list = dllDictionary.list;
    }

    //reset list
    public void clear() {
        list.clear();
    }

   //appends an element to the list
    public void insert(Key k, E e) {
        KVpair<Key, E> temp = new KVpair<Key, E>(k, e);
        list.append(temp);
    }

    //get element to remove from list
    public E remove(Key k) {
        E temp = find(k);
        if (temp != null)
            list.remove();
        return temp;
    }

  //remove an arbitrary element, chose the last element fpr example
    public E removeAny() {

        if (size() != 0) {
            list.moveToEnd();
            KVpair<Key, E> e = list.remove();
            return e.value();
        } else
            return null;
    }

    //returns record with key value
    public E find(Key k) {
        this.list.moveToStart();
        for (int i = 0; i < this.list.length(); i++) {
            KVpair<Key, E> temp = this.list.getValue();
            if (k.equals(temp.key())) {
                return temp.value();
            }
            this.list.next();
        }
        return null;
    }

   //returns size of list
    public int size() {
        return list.length();
    }

    @Override
    public int[] createIndex() {  
        List<KVpair<Key, E>> kvplist = new ArrayList<>();
        int i = 0;
        for (this.list.moveToStart(); this.list.currPos() != null; this.list.next()) {
            kvplist.add(new KVpair<Key, E>((Key) Integer.valueOf(i), this.list.currPos().getData().value()));
            i++;
        }

        // Asymptotic Analysis using quicksort for createIndex(): best and average case is O(nlogn), and worst case is O(n^2)
        quicksort(kvplist, 0, kvplist.size() - 1);
        int[] sortedIndex = new int[i];
        i = 0;
        for (KVpair<Key,E> kv : kvplist) {
            sortedIndex[i] = (int)kv.key();
            i++;
        }
        return sortedIndex;
    }

    public void quicksort(List<KVpair<Key, E>> list, int left, int right) {
        int q;
        if (right > left) {
            q = partition(list, left, right);
            quicksort(list, left, q - 1);
            quicksort(list, q + 1, right);
        }
    }

    int partition(List<KVpair<Key, E>> list, int left, int right) {
        E P = list.get(left).value();
        int i = left;
        int j = right + 1;
        for (;;) {
            while (list.get(++i).value().compareTo(P) < 0)
                if (i >= right)
                    break;
            while (list.get(--j).value().compareTo(P) > 0)
                if (j <= left)
                    break;
            if (i >= j)
                break;
            else
                Collections.swap(list, i, j);
        }
        if (j == left)
            return j;
        Collections.swap(list, left, j);
        return j;
    }


}
