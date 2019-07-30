package com.dgy.tree;

import org.junit.Test;

import java.util.*;

/**
 * Date: 2019/7/30
 * Time: 10:50
 * Author: vincent-Dou
 * Description：
 */
public class TestMyMap {
    @Test
    public void test1(){
        MyMap<Integer, String> map = new MyMap<>();
//        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3, "I");
        map.put(1, "hello");
        map.put(2, "world");
        map.put(5, "豆光耀");
        map.put(4, "am");
        Iterator iterator = map.iterator();
        while (iterator.hasNext()){
            System.out.println(((MyMap.TreeNode)iterator.next()).getValue());
        }
    }



    @Test
    public void test2(){
        Random random = new Random();
        int sum = 65535;
        Map<Integer, String> map1 = new TreeMap<>();
        MyMap<Integer, String> map2 = new MyMap<>();
        int coun = 0;
        for (int i = 0; i < sum; i++){
            int key = random.nextInt(sum);
            String value = String.valueOf(key);
            map1.put(key, value);
            map2.put(key, value);
            System.out.println("成功添加："+(coun++)+"个");
        }
        Iterator iterator1 = map1.entrySet().iterator();
        Iterator iterator2 = map2.iterator();
        int count = 0;
        while (iterator1.hasNext() && iterator2.hasNext()){
            if (!iterator1.next().equals(iterator2.next())){
                System.out.println("不匹配有问题");
            }
            System.out.println("成功比对："+(count++)+"个");
        }
        System.out.println("成功完成所有元素对比");
    }


    class Student{
        Integer age;
        String name;

        public Student(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    @Test
    public void test3(){
        MyMap<Student, Integer> myMap = new MyMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (!(o1 instanceof Student  &&  o2 instanceof Student)){
                    throw new IllegalArgumentException("两个对象无法进行比较");
                }
                Student temp1 = (Student) o1;
                Student temp2 = (Student) o2;
                int flag = temp1.age.compareTo(temp2.age);
                if (flag == 0){
                    return temp1.name.compareTo(temp2.name);
                }
                return flag;
            }
        });
        Student student1 = new Student(20, "AA");
        Student student2 = new Student(25, "AA");
        Student student3 = new Student(19, "AA");
        Student student4 = new Student(23, "AA");
        Student student5 = new Student(23, "AA");
        myMap.put(student1,10);
        myMap.put(student2,10);
        myMap.put(student3,10);
        myMap.put(student4,10);
        myMap.put(student5,10);
        Iterator iterator = myMap.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(myMap.size());
    }
}
