package com.dgy.NiuKe;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Date: 2019/8/18
 * Time: 17:37
 * Author: vincent-Dou
 * Description：https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 题目描述
 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class NiuKe08183 {
    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i), ++time);
            }
            else {
                map.put(str.charAt(i), 1);
            }
        }
        int pos = -1;
        int i=0;
        for(;i<str.length();i++){
            char c = str.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return pos;
    }

    public int FirstNotRepeatingChar1(String str) {
        HashMap<Character, Integer> map= new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            if (map.containsKey(str.charAt(i))){
                int tmep = map.get(str.charAt(i));
                map.put(str.charAt(i), ++tmep);
            }else {
                map.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < str.length(); i++){
            if (map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
