package com.example.ec530;

import java.util.Objects;

/**
 * EC530 SP23
 * Bolun Liu
 * Project2 Phase1
 * Implement a stub-API using actions and unit test
 */
public class Project2 {
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

    // News Feed Ingester
    static String fetchNews(String URL, boolean newsFlag) {
        if (Objects.equals(URL, "url") && newsFlag) {
            return "100 Fetch succeed" + "news content";
        } else if (Objects.equals(URL, "url") && !newsFlag) {
            return "403 Desired news not found";
        }
        return "401 Invalid URL";
    }
    static String filter(String keyword, boolean newsFlag) {
        if (Objects.equals(keyword, "key") && newsFlag) {
            return "100 Fetch succeed" + "news content";
        } else if (Objects.equals(keyword, "key") && !newsFlag) {
            return "403 Desired news not found";
        }
        return "401 Invalid keyword";
    }

    // unit test/ driver function
    public static void main(String[] args) {
        // initialization
        FileManager fileManager = new FileManager();
        String username = "001";
        String password = "pw";
        String path = "path";
        boolean uploadFlag = true;
        boolean fileFlag = true;
        boolean newsFlag = true;
        String fileType = "txt";
        String filename = "file";
        String tagName = "tag";
        String topicName = "topic";
        String keyword = "key";
        String URL = "url";

        // execution
        String login = login(username, password);
        String upload = uploadFile(path, uploadFlag, fileType);
        String open = fileManager.openFile(path, fileFlag);
        String update = fileManager.updateFile(path, fileFlag);
        String delete = fileManager.deleteFile(path);
        String translate = translate(filename);
        String tag = getTag(tagName);
        String topic = getTopic(topicName);
        String analyze = analyze(keyword);
        String modify = modify(keyword);
        String fetch = fetchNews(URL, newsFlag);
        String filter = filter(keyword, newsFlag);

        // display result
        System.out.println("SUCCESS CASES DEMO");
        System.out.println(login);
        System.out.println(upload);
        System.out.println(open);
        System.out.println(update);
        System.out.println(delete);
        System.out.println(translate);
        System.out.println(tag);
        System.out.println(topic);
        System.out.println(analyze);
        System.out.println(modify);
        System.out.println(fetch);
        System.out.println(filter);
    }
}
