/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetnfp1013;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author riidaali
 */
public class Avion implements Serializable {

    public String Ip;
    public int Port;
    public String Nom;
    public String Model;
    public Position Position;
    public double Vitesse;
    public double Angle;

    Avion(String Id, int Port, String Nom, String Model, Position Position, double Vitesse, double Angle) {
        this.Ip = Id;
        this.Port = Port;
        this.Nom = Nom;
        this.Model = Model;
        this.Position = Position;
        this.Vitesse = Vitesse;
        this.Angle = Angle;
    }

    public String getIp() {
        return this.Ip;
    }

    public int getPort() {
        return this.Port;
    }

    public String getNom() {
        return this.Nom;
    }

    public String getModel() {
        return this.Model;
    }

    public Position getPosition() {
        return this.Position;
    }

    public double getVitesse() {
        return this.Vitesse;
    }

    public double getAngle() {
        return this.Angle;
    }

    public void setIp(String Ip) {
        this.Ip = Ip;
    }

    public void setPort(int Port) {
        this.Port = Port;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public void setPosition(Position Position) {
        this.Position = Position;
    }

    public void setVitesse(double Vitesse) {
        this.Vitesse = Vitesse;
    }

    public void setAngle(double Angle) {
        this.Angle = Angle;
    }

    public String ToString(){
    return this.Nom + " - " + this.Model + " - " + this.Position.X 
            + " - " + this.Position.Y + " - " + this.Position.Z + " - " 
            + this.Angle + " - " + this.Vitesse;
    }
    public void Send() throws IOException, ClassNotFoundException {

        Socket socket = new Socket("localhost", 4444);
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        os.writeObject(this);
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        //Recevoir l'objet avion contenant l'address ip et le port pour etre utilises par recevoir les donnees envoyees du Control
        Avion avion = (Avion) is.readObject();
        this.Ip = avion.Ip;
        this.Port = avion.Port;
        System.out.println("Avion " + avion.Nom + " ajoute!");
        socket.close();
        this.Receive();
    }

    public void Receive() throws IOException, ClassNotFoundException {
        
        ServerSocket ss = null;
        //Utiliser le port assigner a cet avion pour recevoir les donnees du Control
        ss = new ServerSocket(this.Port);

        while (true) {
            Socket socket = ss.accept();
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            //Recevoir les donnees envoyees par le control qui peuvent etres des changement dans la Position, la vitesse our l'angle de l'avion    
            Avion avion = (Avion) is.readObject();
            avion.setIp(socket.getInetAddress().toString());
            avion.setPort(socket.getPort());
            os.writeObject(avion);
            System.out.println(avion);
        }
        

    }
}
