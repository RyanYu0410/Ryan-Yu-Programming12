package com.zaremba.graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static ArrayList<Node> graph;
    public static ArrayList<Node> queue = new ArrayList<Node>();
    public static ArrayList<Integer> track = new ArrayList<Integer>();
    public static void main(String[] args) throws FileNotFoundException {
        setupTree();
        BFS();
    }

    private static void BFS() {
        //Your code here.  Feel free to modify signature or add helper functions.
        queue.add(graph.get(0));
        track.add(1);
        int i =0;
        while (queue.size() != 0) {
            Node node = queue.get(i);
            for (Integer extendNodes : node.getNodes()) {
                Node visitNode = graph.get(extendNodes-1);
                if (!visitNode.isVisited()) {
                    queue.add(graph.get(extendNodes-1));
                    track.add(visitNode.getKey());
                    visitNode.setVisited(true);
                }
            }
            node.setVisited(true);
            queue.remove(0);
        }
        System.out.println(queue);
        System.out.println(track);
    }

    private static void setupTree() throws FileNotFoundException {
        graph = new ArrayList<>();
        Scanner scan = new Scanner(new File("tree.txt"));
        while(scan.hasNext()){
            String line = scan.nextLine();
            parseLine(line);
        }
    }

    private static void parseLine(String line) {
        String[] keys = line.split(" ");
        int key = Integer.parseInt(keys[0]);
        ArrayList<Integer> points = new ArrayList<>();
        for(int i = 1; i < keys.length;i++){
            points.add(Integer.parseInt(keys[i]));
        }
        graph.add(new Node(key, points));
    }
}
