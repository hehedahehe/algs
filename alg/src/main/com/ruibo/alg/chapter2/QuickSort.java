package com.ruibo.alg.chapter2;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

public class QuickSort {

    public static void main(String[] args) {

    }

    public static void sort(int[] nums,int low,int high){

        int p = partition(nums,low,high);
        if(p==low){
            return;
        }else {
            sort(nums,low,p-1);
            sort(nums,p+1,high);
        }

    }

    private static int partition(int[] nums,int low,int high){
        int v = nums[low];
        int i = low;
        int j = high;
        while (true){
            while (less(nums[i],v)){
                if(i==high){break;}
                i++;
            }
            while (less(v,nums[j])){
                if(j==low){break;}
                j--;
            }
            if(i>=j){
                exchange(nums,low,j);
                break;
            }else {
                exchange(nums,i,j);
            }
        }
        return j;
    }

    private static void exchange(int[] nums,int aIndex,int bIndex){

    }

    private static boolean less(int a,int b){
        return a<b;
    }
}
