package com.example.ec530;

import java.util.Objects;
import java.io.*;
import java.util.*;
public static String strLine;
public static int order = 1;

public class NLP {
    // Text NLP Analysis
    static String translate(String filename) {
        if (Objects.equals(filename, "file")) {
            return "100 Analyze succeed" + "translated content";
        }
        return "400 Failed to analyze/modify";
        // readable text message
    }
    static String getTag(String tagName) {
        if (Objects.equals(tagName, "tag")) {
            return "100 Analyze succeed" + "doc content";
        }
        return "400 Failed to analyze/modify";
    }
    static String getTopic(String topicName) {
        if (Objects.equals(topicName, "topic")) {
            return "100 Analyze succeed" + "All topics";
        }
        return "400 Failed to analyze/modify";
    }
    static String analyze(String keyword) {
        if (Objects.equals(keyword, "key")) {
            return "100 Analyze succeed" + "doc content";
        }
        return "400 Failed to analyze/modify";
    }
    static String modify(String keyword) {
        if (Objects.equals(keyword, "key")) {
            return "100 Analyze succeed" + "modified content";
        }
        return "400 Failed to analyze/modify";
    }
    public static void main(String[] args) {
    Queue<String> queue = new PriorityQueue<Integer>();
    try{
        FileReader fr = new FileReader("File.txt");
        BufferedReader br = new BufferedReader(fr);
        while ((strLine = br.readLine()) != null)   {
            queue.offer(Integer.parseInt(strLine));
        }
        br.close();
    } catch (IOException e){
        System.out.println("File not found");
    }
     while (!queue.isEmpty()){
        System.out.println(order + ".Number: " + queue.poll());
        order++;
    }
}
