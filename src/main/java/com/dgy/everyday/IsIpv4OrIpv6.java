package com.dgy.everyday;

import org.omg.PortableServer.IdAssignmentPolicyValue;
import sun.security.util.Length;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

/**
 * Date: 2019/9/16
 * Time: 21:09
 * Author: vincent-Dou
 * Description：
 */
public class IsIpv4OrIpv6 {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            if (isIpv4(str)){
                System.out.println("IPv4");
            }else if (isIpv6(str)){
                System.out.println("IPv6");
            }else{
                System.out.println("Neither");
            }
        }
    }

    public static boolean isIpv6(String str){
        if(str.contains("::")){
            String[] arr = str.split(":");
            if (arr.length > 7 || arr.length < 1) return  false;
            for (int i = 0; i < arr.length; i++){
                if (arr[i].equals("")) continue;
                if (arr[i].length() > 4) return false;
                for (int j = 0; j < arr[i].length(); j++){
                    char temp = arr[i].charAt(j);
                    if ((temp >= '0' && temp <= '9') || (temp >= 'A' && temp <= 'F') || (temp >= 'a' && temp <= 'f'))
                        continue;
                    else
                        return false;
                }
            }
        }else if(!str.contains("::")){
            String[] strings = str.split(":");
            if (strings.length != 8) return false;
            for (int i = 0; i < strings.length; i++){
                if (strings[i].trim().length() > 4) return false;
                for (int j = 0; j < strings [i].length(); j++){
                    char temp = strings[i].charAt(j);
                    if ((temp >= '0' && temp <= '9') || (temp >= 'A' && temp <= 'F') || (temp >= 'a' && temp <= 'f'))
                        continue;
                    else
                        return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isIpv4(String str){
        String[] strings = str.split(".");
        if (strings.length != 4) return false;
        for (int i = 0; i < strings.length; i++){
            if(strings[i].charAt(0) == '0') return false;
            if(Integer.parseInt(strings [i].trim()) < 0 || Integer.parseInt(strings [i].trim()) > 255) return false;
        }
        return true;
    }
}
