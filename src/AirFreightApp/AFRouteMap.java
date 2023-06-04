package AirFreightApp;

import GraphFramework.Edge;
import GraphFramework.Graph;
import GraphFramework.Vertex;
//--------------------------------------------------------------------------

public class AFRouteMap extends Graph {

    public AFRouteMap(int veticesNo, int edgeNo, boolean isDigraph) {
        super(veticesNo, edgeNo, isDigraph);
    }
    //--------------------------------------------------------------------------    
    // the overriden method create edge to creat the new line object

    @Override
    public Edge createEdge(Vertex v, Vertex u, int w) {
        return new Route(w, v, u);
    }
    // the overriden method create vertex to creat the new office object

    @Override
    public Vertex createVertex(int label) {
        Vertex Location = isFound(label);
        return Location;

    }
    //--------------------------------------------------------------------------   
    // method to return the office to be created

    public Vertex isFound(int label) {
        Vertex found = null;
        int k = 0;
        while (k < getVeticesNo()) {
            if (getVertex(k) != null) {
                if (getVertex(k).getLabel() == label) {
                    found = getVertex(k);
                    break;
                }
            } else {
                found = new Location(label);
                vertices[k] = found;
                break;
            }
            k++;
        }

        return found;
    }

}
