package com.example.ec530;

import java.util.Objects;
import java.io.*;
import java.util.*;
public static String strLine;
public static int order = 1;

public class SFU {
    // Secure File Uploader/Ingester
    static String login(String username, String password) {
        //if user is found open a new session
        if (Objects.equals(username, "001") && Objects.equals(password, "pw")) {
            return "100 Success";
        }
        return "401 Login failed, username or password not found/incorrect";
    }
    static String uploadFile(String path, boolean uploadFlag, String fileType) {
        //if path found, upload file to user specified path
        if (Objects.equals(path, "path")) {
            if (uploadFlag && Objects.equals(fileType, "txt")) {
                return "Successfully uploaded the file!";
            } else {
                return "403 Failed to upload file 404 Unknown file type";
            }
        }
        return "402 Path Not Found";
    }
    static class FileManager {
        // a class that has several file modification methods
        String openFile(String path, boolean fileFlag) {
            if (Objects.equals(path, "path") && fileFlag) {
                return "100 Success";
            } else if (Objects.equals(path, "path") && !fileFlag) {
                return "407 Failed to open file";
            }
            return "402 Path not found";
        }
        String updateFile(String path, boolean fileFlag) {
            if (Objects.equals(path, "path") && fileFlag) {
                return "100 Success";
            } else if (Objects.equals(path, "path") && !fileFlag) {
                return "406 File not found";
            }
            return "402 Path not found";
        }
        String deleteFile(String path) {
            if (Objects.equals(path, "path")) {
                return "100 Success";
            }
            return "408 Failed to delete file";
        }
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
