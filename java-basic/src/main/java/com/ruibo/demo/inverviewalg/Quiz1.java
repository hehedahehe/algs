package com.ruibo.demo.inverviewalg;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2020/03/18 n1
 *
 * //评测题目: 无
 * 1. 输入一个英文语句，翻转句子中单词的顺序，但单词内字符的顺序不变
 * 2. 动物园有1000只动物，有熊、长颈鹿、大猩猩；饲养员给每个动物喂饭，先喂年纪最小的10个动物。
 * 要求：面向对象；考虑时间复杂度
 */
public class Quiz1 {

    public static void main(String[] args) {
        String testCase = "I am teacher too.";
        System.out.println(convertSentence(testCase));
    }

    public static String convertRecursion(String sentence){
        String[] words = sentence.split(" ",-1);
        return doC(words,0,words.length);
    }

    private static String doC(String[] words,int begin,int end){
        return "";
    }

    public  static String convertSentence(String sentence){
        if(sentence==null||"".equals(sentence)){
            return "";
        }
        String[] words = sentence.split(" ",-1);

        for(int i=0,j=words.length-1;i<j;i++,j--){
            String iTemp = words[i];
            String jTemp = words[j];
            words[i] = jTemp;
            words[j] = iTemp;
        }
        return String.join(" ",words);
    }


    public static List<Animal> getTopN(List<Animal> animals, int n){
        if(n<=0||(animals==null)){
            throw new RuntimeException();
        }
        if(n>animals.size()){
            throw new RuntimeException();
        }
        Comparator<Animal> cp = (a1, a2) ->{
            if(a1.getAge() < a2.getAge()){
                return -1;
            }else if(a1.getAge() == a2.getAge()){
                return 0;
            }else{
                return 1;
            }
        };
        //TODO 不好的写法
//        animals.sort(cp);
//        List<Animal> res = new ArrayList<>();
//        for(int i=0;i<n){
//            res.add(animals.get(i));
//        }
        return animals.stream().sorted(cp).limit(n).collect(Collectors.toList());

    }


    public static class Animal{
        private int age;
        private String id;
        public Animal(String id){
            this.id = id;
        }

        public String getId(){
            return id;
        }
        public void setAge(int age){
            this.age = age;
        }
        public int getAge(){
            return age;
        }
    }
}
