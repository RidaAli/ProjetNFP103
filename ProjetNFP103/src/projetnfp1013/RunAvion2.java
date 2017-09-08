/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetnfp1013;

import java.io.IOException;
import projetnfp1013.Avion;
import projetnfp1013.Position;

/**
 *
 * @author riidaali
 */
public class RunAvion2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
    Avion avion = new Avion("",0,"Avion2","abc",new Position(14,2,6),2.4,4.1);
    avion.Send();
    
    }
    
}
