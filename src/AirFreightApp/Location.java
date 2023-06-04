
package AirFreightApp;

import GraphFramework.Vertex;

//--------------------------------------------------------------------------
public class Location extends Vertex{
    //varibles
   private String City;
 
//--------------------------------------------------------------------------
   // constructer 
   public Location(int label2) {
        super(label2);
        this.City = String.valueOf((char)((label2-1) +65));//To change body of generated methods, choose Tools | Templates.
    }

   public Location(int Label, boolean isVisited) {
        super(Label, isVisited);
    }
 //--------------------------------------------------------------------------   
   //display methods
   @Override
    public void displayInfo() {
        System.out.print("loc. "+ City +": city "+Label); //To change body of generated methods, choose Tools | Templates.
    }
    
   @Override
    public void displayInfo1(){
        System.out.print("city "+Label);
    }
    
}
