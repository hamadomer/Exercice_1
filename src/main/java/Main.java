/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Main {

    public static void main(String[] args) {
        Carton carton = new Carton(100, TypeOfCarton.Cloth);
        carton.addObject(new Cloth("BasketBall", 27));
        carton.getUsedCartonHeight();
        carton.toString();
    }
}
