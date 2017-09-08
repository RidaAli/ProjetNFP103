/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetnfp1013;
import java.io.IOException;

/**
 *
 * @author riidaali
 */
public class RunAvion1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
    Avion avion = new Avion("",0,"Avion1","abc",new Position(3,2,1),2.1,3.2);
    avion.Send();
    
    }
    
}
