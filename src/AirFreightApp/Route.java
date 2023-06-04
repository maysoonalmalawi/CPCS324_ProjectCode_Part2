
package AirFreightApp;

import GraphFramework.Edge;
import GraphFramework.Vertex;
//--------------------------------------------------------------------------
public class Route extends Edge{

    //constructer
    public Route(int weight, Vertex source, Vertex target) {
        super(weight, source, target);
    }
    
//-------------------------------------------------------------------------- 
   //display
    @Override
    public void displayInfo() {
        super.displayInfo(); 
    }
    
}
