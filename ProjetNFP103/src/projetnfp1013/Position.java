/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetnfp1013;

import java.io.Serializable;

/**
 *
 * @author riidaali
 */
public class Position implements Serializable {

    public double X;
    public double Y;
    public double Z;

    Position(double X, double Y, double Z) {
        this.X = X;
        this.Y = Y;
        this.Z = Z;
    }

    public void setX(double X) {
        this.X = X;

    }

    public void setY(double Y) {
        this.Y = Y;

    }

    public void setZ(double Z) {
        this.Z = Z;

    }

    public double getX() {
        return this.X;
    }

    public double getY() {
        return this.Y;
    }

    public double getZ() {
        return this.Z;
    }
}
