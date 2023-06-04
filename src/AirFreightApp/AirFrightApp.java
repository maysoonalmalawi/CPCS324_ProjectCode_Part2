
package AirFreightApp;
import GraphFramework.DBAllSourceSPAlg;
import java.io.File;
import java.io.FileNotFoundException;

//--------------------------------------------------------------------------
public class AirFrightApp {

    public static final String RED = "\033[0;31m";     // RED
    static public AFRouteMap aFRouteMap = new AFRouteMap(0, 0, true);
//--------------------------------------------------------------------------
    
    
    public static void main(String[] args) throws FileNotFoundException {

        // to read the file and chck if its exist
        File inputFile = new File("inputfile.txt");
        if (!inputFile.exists()) {
            System.out.println(inputFile.getName() + " file not found.");

            System.exit(0);
        }
        
        
        
        // the graphs generatores

      //  aFRouteMap.readGraphFromFile(inputFile);
            aFRouteMap.makeGraph(6000, 30000);

            
            // calling the dijkstra algorthim
        
        DBAllSourceSPAlg temp = new DBAllSourceSPAlg();
        
        long startTimeD = System.currentTimeMillis();
        temp.computeDijkstraBasedSPAlg(aFRouteMap);
        long endTimeD = System.currentTimeMillis();
        
        long elapsedTimeD = endTimeD - startTimeD;
        System.out.println(RED+"Elapsed time in milliseconds: " + elapsedTimeD);

    }

}
