/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetnfp1013;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author riidaali
 */
public class Saca {

    public ArrayList<Avion> Avions;

    Saca() {
        Avions = new ArrayList<Avion>();
    }

    public void Receive() throws IOException, ClassNotFoundException {
        int port = 4444;
        ServerSocket ss = null;
        ss = new ServerSocket(port);

        while (true) {
            //Recevoir les subscriptions des nouveaux avions
            Socket socket = ss.accept();
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            //Recevoir l'objet avion envoye par le socket
            Avion avion = (Avion) is.readObject();
            //Sauvegarder l'addresse Ip et le port de l'avion pour pouvoir l'acceder
            avion.setIp(socket.getRemoteSocketAddress().toString());
            avion.setPort(socket.getPort());
            //Ajouter le nouveau avion a la liste des avions pour pouvoir acceder cet avion pour control et radar
            AjouterAvion(avion);
            os.writeObject(avion);
            //Lister les avions
            ListAvions();
        }
    }

    public static void Send(Avion avion) throws IOException, ClassNotFoundException {
        //Contacter un certain avoin part son address Ip et son port afin d'envoyer des changement dans la position, vitesse ou angle.
        Socket socket = new Socket(avion.Ip, avion.Port);        
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        os.writeObject(avion);
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        socket.close();
    }

    public void ListAvions() {
        for (Avion avion : this.Avions) {
            System.out.println(avion.ToString());
        }
    }

    public void AjouterAvion(Avion Avion) {
        Avions.add(Avion);
    }

}
