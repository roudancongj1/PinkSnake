package com.gao.util;

import com.gao.pojo.JsonTree;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;


public class mainUtil {

    public static void main(String[] args) {
        int[] a = {2,7,11,15};
        int b = 9;
        twoSum(a,b);
    }
    public static Integer[] twoSum(int[] nums, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length - i; j++) {

                if (nums[i] + nums[j] == target){
                    list.add((Integer) i);
                    list.add((Integer)j);
                }
            }
        }
        Integer[] array = list.toArray(list.toArray(new Integer[0]));
        Arrays.stream(array).forEach(System.out::println);

        return        array;
    }


}
