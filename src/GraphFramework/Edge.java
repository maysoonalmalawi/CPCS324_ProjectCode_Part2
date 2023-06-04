package GraphFramework;

public class Edge {
//--------------------------------------------------------------------------
    //Variables

    int weight;
    public Vertex source;
    public Vertex target;
    private Edge next;
//--------------------------------------------------------------------------
    //Constructers

    public Edge(int weight, Vertex source, Vertex target) {
        this.weight = weight;
        this.source = source;
        this.target = target;
    }
//--------------------------------------------------------------------------
//Setters

    public void setSource(Vertex source) {
        this.source = source;
    }

    public void setTarget(Vertex target) {
        this.target = target;
    }

    public void setNext(Edge next) {
        this.next = next;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
//--------------------------------------------------------------------------
    //getters

    public Vertex getSource() {
        return source;
    }

    public Vertex getTarget() {
        return target;
    }

    public int getWeight() {
        return weight;
    }

    public Edge getNext() {
        return next;
    }
//--------------------------------------------------------------------------
  // the super method to display
    public void displayInfo() {
    }

}
