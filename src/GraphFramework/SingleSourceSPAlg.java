package GraphFramework;
import java.util.*;
public class SingleSourceSPAlg  extends ShortestPathAlgorhtim{
  // Initialize a MapSet to store finished vertices  
    Set<Vertex> AddedNodes;
    
  // Initialize a MapSet to store unadded vertices
    Set<Vertex> UnaddedNodes;
    
   // Initialize a HashMap to store vertices' keys
    HashMap<Vertex, Integer> keys;
    
   // Initialize a LinkedHashMap to store shortest path for each vertex
    LinkedHashMap<Vertex, LinkedList> path;
    
    public SingleSourceSPAlg(){}
   
    public HashMap<Vertex, LinkedList> computeDijkstraAlg(Graph graph, Vertex source) {
  // Create all previously initialized variables 
    AddedNodes = new HashSet<>();
    UnaddedNodes = new HashSet<>();
    keys = new HashMap<Vertex, Integer>();
    path = new LinkedHashMap<Vertex, LinkedList>();
    
   // Lopp in size of grap vertices number
    for(int i = 0; i < graph.verticesNo; i++){
      // Add vertices to keys and path HashMaps with starting values
        keys.put(graph.vertices[i], Integer.MAX_VALUE);
        path.put(graph.vertices[i], new LinkedList<Vertex>());}
    
   // Update source vertex's key to zero
    keys.put(source, 0);

  // Add source to the unadded HashSet
    UnaddedNodes.add(source);

  // Check if there are no unadded vertices 
    while (UnaddedNodes.size() != 0) {
      // Get minimum key vertex from unadded HashSet
        Vertex currentNode = getLowestDistanceNode(UnaddedNodes);
       
      // Remove the minimum key vertex for the unadded HashSet
        UnaddedNodes.remove(currentNode);
        
      // Loop in size of the minimum key vertex's adjacency list
        for (int i = 0; i < currentNode.getAdjlist().size(); i++) {
          // Get edge target
            Vertex target = currentNode.getAdjlist().get(i).getTarget();
            
          // Get edge weight 
            Integer weight = currentNode.getAdjlist().get(i).getWeight();
            
          // Check if target is not added to the finished HashSet
            if (!AddedNodes.contains(target)) {
               // If it is not, update target node key and path
                calculateMinimumDistance(target, weight, currentNode);
                
               // Add target node to unadded HashSet
                UnaddedNodes.add(target);
            }
        }
        
        // Add minimum key vertex to finished HashSet
        AddedNodes.add(currentNode);
    }
    
   // Return shortest path for all vertices from source
    return path;
}
    
   // Method to find the minimum key vertex 
    private Vertex getLowestDistanceNode(Set <Vertex> unsettledNodes) {
    // Create comparsion variables 
    Vertex lowestDistanceNode = null;
    int lowestDistance = Integer.MAX_VALUE;
    
   // Loop in size of the unadded HashSet
    for (Vertex vertex: unsettledNodes) {
       // Get vertex
        int nodeDistance = keys.get(vertex);
        
       // Compare current vertex's key with comparsion key
        if (nodeDistance < lowestDistance) {
           // If current key is smaller, update comparsion key and minimum key vvertex
            lowestDistance = nodeDistance;
            lowestDistanceNode = vertex;
        }
    }
    return lowestDistanceNode;
}
    
  // Method to update vertices' keys and shortest paths
    private void calculateMinimumDistance(Vertex evaluationNode, Integer edgeWeigh, Vertex sourceNode) {
   // Get source vertex's key
    Integer sourceDistance = keys.get(sourceNode);
    
  // Check if distance to target vertex is smaller than the target vertex's key
    if (sourceDistance + edgeWeigh < keys.get(evaluationNode)) {
      // If true, update target vertex's key in keys HashMaps 
        keys.put(evaluationNode,sourceDistance + edgeWeigh);
        
     // Add source's path and the source to the target vertex's shortest path
        LinkedList<Vertex> shortestPath = new LinkedList<>(path.get(sourceNode));
        shortestPath.add(sourceNode);
        path.put(evaluationNode,shortestPath);
    }
}
    }