package project;
import java.util.Random;
import java.util.*;
import javax.swing.*;

public class SearchingAlgorithms {
    // Veri oluşturma
    public static int[] rastgeleVeriOlustur(int boyut) {
        Random random = new Random();
        int[] veriSeti = new int[boyut];
        for (int i = 0; i < boyut; i++) {
            veriSeti[i] = random.nextInt(100) + 1; // 1'den 100'e kadar rastgele sayılar
        }
        return veriSeti;
    }
    // Linear Search
    public static boolean linearSearch(int[] dizi, int aranan) {
        for (int eleman : dizi) {
            if (eleman == aranan) {
                return true;
            }
        }
        return false;
    }
    // Binary Search
    public static boolean binarySearch(int[] dizi, int aranan) {
        int sol = 0;
        int sag = dizi.length - 1;
        while (sol <= sag) {
            int orta = sol + (sag - sol) / 2;
            if (dizi[orta] == aranan) {
                return true;
            }
            if (dizi[orta] < aranan) {
                sol = orta + 1;
            } else {
                sag = orta - 1;
            }
        }
        return false;
    }
    // İnterpolation Search
    public static boolean interpolationSearch(int[] dizi, int aranan) {
        int sol = 0;
        int sag = dizi.length - 1;
        while (sol <= sag && aranan >= dizi[sol] && aranan <= dizi[sag]) {
            if (sol == sag) {
                if (dizi[sol] == aranan) {
                    return true;
                }
                return false;
            }
            int pozisyon = sol + ((aranan - dizi[sol]) * (sag - sol) / (dizi[sag] - dizi[sol]));
            if (dizi[pozisyon] == aranan) {
                return true;
            }
            if (dizi[pozisyon] < aranan) {
                sol = pozisyon + 1;
            } else {
                sag = pozisyon - 1;
            }
        }
        return false;
    }
    // Graph Algorithm
    public static class Graph {
        private int vertices;
        private LinkedList<Edge>[] adjacencyList;

        public static class Edge {
            int target;
            int weight;

            Edge(int target, int weight) {
                this.target = target;
                this.weight = weight;
            }
        }

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int target, int weight) {
            adjacencyList[source].add(new Edge(target, weight));
            adjacencyList[target].add(new Edge(source, weight));  // For undirected graph
        }

        public void dijkstra(int startVertex, JTextArea outputArea) {
            int[] distances = new int[vertices];
            boolean[] visited = new boolean[vertices];

            for (int i = 0; i < vertices; i++) {
                distances[i] = Integer.MAX_VALUE;
            }
            distances[startVertex] = 0;

            PriorityQueue<Edge> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(edge -> edge.weight));
            pq.add(new Edge(startVertex, 0));

            while (!pq.isEmpty()) {
                int currentVertex = pq.poll().target;

                if (visited[currentVertex]) continue;
                visited[currentVertex] = true;

                for (Edge edge : adjacencyList[currentVertex]) {
                    int neighbor = edge.target;
                    int newDist = distances[currentVertex] + edge.weight;

                    if (!visited[neighbor] && newDist < distances[neighbor]) {
                        distances[neighbor] = newDist;
                        pq.add(new Edge(neighbor, newDist));
                    }
                }
            }

            StringBuilder result = new StringBuilder("Vertex\tDistance from Source\n");
            for (int i = 0; i < vertices; i++) {
                result.append(i).append("\t").append(distances[i]).append("\n");
            }
            outputArea.setText(result.toString());
        }
    }
    // Constant time search
    public static boolean constantTimeSearch(Map<Integer, Integer> map, int key) {
        return map.containsKey(key);
    }
    public static Map<Integer, Integer> arrayToHashMap(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : array) {
            map.put(value, value);
        }
        return map;
    }
    //Floyd-Warshall algorithm
    public static void floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        // Başlangıçta graph matrisinin değerlerini dist matrisine kopyala
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Floyd-Warshall algoritması
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Sonuç matrisini yazdır
        printSolution(dist);
    }
    public static void printSolution(int[][] dist) {
        int V = dist.length;
        System.out.println("Köşeler arasındaki en kısa mesafeler:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

}
