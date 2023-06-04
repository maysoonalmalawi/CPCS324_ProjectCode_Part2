/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphFramework;

import java.util.*;

public class DBAllSourceSPAlg extends ShortestPathAlgorhtim {

    public DBAllSourceSPAlg() {

    }

    public void computeDijkstraBasedSPAlg(Graph g) {
        SingleSourceSPAlg dij = new SingleSourceSPAlg();

        // loop through all vertices of the graph      
        for (int i = 0; i < g.verticesNo; i++) {
            // find the shortest path for vertex i
            HashMap<Vertex, LinkedList> shortestPath = dij.computeDijkstraAlg(g, g.vertices[i]);
            
            if(g.vertices.length > 10){
                // print starting point location header
                System.out.println("\nThe starting point location is " + g.vertices[i].getLabel());
                // print routes header
                System.out.println("\nThe routes from location " + g.vertices[i].getLabel() + " to the rest of the locations are:");
                
            }else{
                // print starting point location header
                System.out.println("\nThe starting point location is " + String.valueOf((char) ((g.vertices[i].getLabel() - 1) + 65)));
                // print routes header
                System.out.println("\nThe routes from location " + String.valueOf((char) ((g.vertices[i].getLabel() - 1) + 65)) + " to the rest of the locations are:");
            }
            

            int empty = 0;
            // loop through the entrySet of the shortest path previously computed
            for (Map.Entry<Vertex, LinkedList> entry : shortestPath.entrySet()) {
                // if the current vertex has a linkedlist (meaning a path to it exists)
                if (!entry.getValue().isEmpty()) {
                    empty++;
                    // get the linkedlist of 
                    LinkedList<Vertex> list = entry.getValue();
                    // initialize route length
                    int totalCost = 0;
                    Vertex temp = list.get(0);
                    for (int k = 0; k < list.size(); k++) {
                        if(g.vertices.length > 10){
                            list.get(k).displayInfo1();
                        }else{
                            list.get(k).displayInfo();
                        }
                        System.out.print(" - ");
                        if (k + 1 != list.size()) {
                            totalCost += findEdge(temp, list.get(k + 1));
                            temp = list.get(k + 1);
                        }
                    }

                    totalCost += findEdge(list.get(list.size() - 1), entry.getKey());
                    if(g.vertices.length > 10){
                        entry.getKey().displayInfo1();
                    }else{
                        entry.getKey().displayInfo();
                    }

                    System.out.println(" --- route length: " + totalCost);
                }
            }
            if (empty == 0) {
                System.out.println("There are no locations that can be reached from this location.");
            }

            System.out.println("\n------------------------------------------------------------------");
        }

    }

    public int findEdge(Vertex v, Vertex u) {
        int weight = 0;

        for (Edge edge : v.getAdjlist()) {
            if (edge.getTarget() == u) {
                weight = edge.getWeight();
            }
        }

        return weight;
    }

}
