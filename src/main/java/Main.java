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
        carton.addObject(new Cloth("T shirt", 10));
        carton.addObject(new Cloth("Pantlon", 20));
        Carton carton1 = new Carton(10, TypeOfCarton.Carton);
        System.out.println(carton.getNumberOfObjectsInList());
        System.out.println(carton.getCartonType());
        carton.addObject(carton1);
        carton.addObject(new Cloth("test", 10));
        System.out.println(carton.getCartonType());
        System.out.println(carton.getNumberOfObjectsInList());
        
    }
}
