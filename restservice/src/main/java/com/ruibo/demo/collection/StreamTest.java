package com.ruibo.demo.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        List<Integer> res = nums.stream().limit(2).collect(Collectors.toList());
        System.out.println(res);
    }
}
