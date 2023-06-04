
package GraphFramework;

import java.util.LinkedList;
//--------------------------------------------------------------------------
public class Vertex {
    public int Label;
    boolean isVisited;
    private LinkedList<Edge> adjlist = new LinkedList<>();
//--------------------------------------------------------------------------
    public Vertex(int Label, boolean isVisited) {
        this.Label = Label;
        this.isVisited = isVisited;
    }

    public Vertex() {
        Label = 0;
    }

    public Vertex(int label) {
        this.Label = label;
    }
//--------------------------------------------------------------------------
   //Setters
    public void setAdjlist(LinkedList<Edge> adjlist) {
        this.adjlist = adjlist;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public void setLabel(int Label) {
        this.Label = Label;
    }

    public LinkedList<Edge> getAdjlist() {
        return adjlist;
    }
//--------------------------------------------------------------------------
   //Getters
    public int getLabel() {
        return Label;
    }

    public boolean getIsVisited() {
        return isVisited;
    }

    public boolean isIsVisited() {
        return isVisited;
    }

    public LinkedList<Edge> getLinkedList() {
        return this.adjlist;
    }

 //-------------------------------------------------------------------------- 
  
    // two method to display the first is to print baesd om read graph method 
    
    public void displayInfo() {
        for (int i = 0; i < adjlist.size(); i++) {
            adjlist.get(i).displayInfo();
        }

    }
   // the second is to display the random graphs 
    public void displayInfo1(){
        
    }

}

