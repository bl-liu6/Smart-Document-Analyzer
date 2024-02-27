import java.io.*;
import java.util.*;
public class Main {
public static String strLine;
public static int order = 1;
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
} }
