package com.lenny;

import java.text.MessageFormat;
import java.util.HashMap;

/**
 * 二分查找法
 */
public class BinarySearch {

    private static final String KEY_INDEX="index";//索引
    private static final String KEY_COUNT="count";//查找次数

    public static int binarySearch(int[] arr,int key)
    {
        int low = 0;
        int high = arr.length-1;
        int middle =0;

        if (key<arr[low]||key>arr[high]||low>high){
            return -1;
        }

        while (low<=high){
            middle = (low+high)/2;
            if (arr[middle]>key){
                high = middle -1;
            }else if (arr[middle]<key){
                low = middle +1 ;
            }else{
                return middle;
            }
        }
        return middle;
    }

    public static HashMap<String,Integer> binarySearchWithSearchCount(int[] arr,int key)
    {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        int low = 0;
        int high = arr.length-1;
        int middle =0;

        if (key<arr[low]||key>arr[high]||low>high){
            hashMap.put(KEY_INDEX,-1);
            hashMap.put(KEY_COUNT,-1);

            return hashMap;
        }

        int count =0;
        while (low<=high){
            //count++;
            ++count;
            //System.out.println(count);
            middle = (low+high)/2;
            if (arr[middle]>key){
                high = middle -1;
            }else if (arr[middle]<key){
                low = middle +1 ;
            }else{
                hashMap.put(KEY_INDEX,middle);
                hashMap.put(KEY_COUNT,count);

                return hashMap;
            }
        }
        hashMap.put(KEY_INDEX,middle);
        hashMap.put(KEY_COUNT,count);

        return hashMap;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{5,10,19,21,31,37,42,48,50,55};
        //1、查找索引 - binarySearch
        //int i = binarySearch(arr,5);
        //System.out.println(i);

        //2、索引及查找次数 - binarySearchWithSearchCount
        HashMap<String, Integer> hashMap = null;
        String tmp="数字：{0}，索引：{1}，查找次数：{2}{3}";
        String print="";
        for (int num:arr) {
            hashMap= binarySearchWithSearchCount(arr,num);
            print= MessageFormat.format(tmp,num,hashMap.get(KEY_INDEX),hashMap.get(KEY_COUNT),"\r");
            System.out.println(print);
        }
    }



}
