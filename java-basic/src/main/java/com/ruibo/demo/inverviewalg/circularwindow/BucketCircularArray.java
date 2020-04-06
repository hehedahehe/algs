package com.ruibo.demo.inverviewalg.circularwindow;

import java.util.ArrayList;

public class BucketCircularArray {
    private volatile int size = 10;
    private static int maxSize = 60;
    private volatile int dataLength;
    private Bucket[] data;
    private int head;
    private int tail;

    public void addBucket(Bucket bucket) {
        data[tail] = bucket;
        incrementTail();
    }

    public void incrementTail() {
        if (dataLength == size) {
            head = (head + 1) % size;
            tail = (tail + 1) % size;
        } else {
            tail = (tail + 1) % size;
        }
        if (dataLength < size) {
            dataLength++;
        }
    }

    public Bucket tail() {
        if (dataLength == 0) {
            return null;
        }
        int index = (head + dataLength - 1) % dataLength;
        return data[index];
    }

    public Bucket[] toArray(){
        ArrayList<Bucket> list = new ArrayList<>();
        for (int i = 0; i < dataLength; i++) {
            int index = (head+i)%dataLength;
            Bucket tmp = data[index];
            if(tmp!=null){
                list.add(tmp);
            }
        }
        return list.toArray(new Bucket[list.size()]);
    }


}
