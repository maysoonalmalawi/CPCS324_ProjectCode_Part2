package GraphFramework;

public abstract class ShortestPathAlgorhtim {

    Graph graph;
    Edge MSTResulList[];
    //--------------------------------------------------------------------------
  //Getters
    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public void setMSTResulList(Edge[] MSTResulList) {
        this.MSTResulList = MSTResulList;
    }
//--------------------------------------------------------------------------
 //Setters
    public Graph getGraph() {
        return graph;
    }

    public Edge[] getMSTResulList() {
        return MSTResulList;
    }
    //--------------------------------------------------------------------------

}
