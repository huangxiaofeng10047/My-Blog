package com.site.blog.my.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tests {
    public static void main(String[] args) {
       Solution solution=new Solution();
       int[] nums={2,11,7,5};
       System.out.println(solution.twoSum(nums,9)[1]);
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        while(true){
            for(int i=0;i<nums.length;i++){
                for(int j=i+1;j<nums.length;j++){
                    if(nums[i]+nums[j]==target){
                        result[0]=i;
                        result[1]=j;
                        return result;
                    }
                }
            }
            break;
        }
        return result;
    }
}