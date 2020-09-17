/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.pryprincipiosolid.main;

import co.unicauca.pryprincipiosolid.domain.*;
import co.unicauca.pryprincipiosolid.service.Servicio;

/**
 *
 * @author Mannuel Fernando Granoble, Michel Andrea Gutierrez, Nathalia Ruiz, Ximena Quijano
 */
public class ClienteMain {
    public static void main(String[] args) {
        //MAIN PARA PRIMER PROTOTIPO
        // TODO code application logic here
        
Servicio objServicio = new Servicio();
        Parqueadero objParqueadero= new Parqueadero();

        // Crear dos productos y grabarlos
        Vehiculo objCarro = new Vehiculo(TipoVehiculoEnum.CARRO,"QWE231","Mazda","Violeta");         
        objServicio.guardarVehiculo(objCarro);

        double  tarifaCarro = objParqueadero.CalculateTarifaParqueadero(objCarro,90);

        Vehiculo objCamion = new Vehiculo(TipoVehiculoEnum.CAMION,"ASW675","Bughati","Blanco");
        objServicio.guardarVehiculo(objCamion);

        double tarifaCamion= objParqueadero.CalculateTarifaParqueadero(objCamion,2160);

        Vehiculo objMoto = new Vehiculo(TipoVehiculoEnum.MOTO,"UIY897","Honda","Negra");
        objServicio.guardarVehiculo(objMoto);

        double tarifaMoto= objParqueadero.CalculateTarifaParqueadero(objMoto,150);


        System.out.println("valor Carro :"+tarifaCarro);

        System.out.println("valor Camion:"+tarifaCamion);

        System.out.println("valor Moto: "+tarifaMoto);

        // Listar los productos
        for(Vehiculo objVehiculo: objServicio.listaVehiculo()){
            System.out.println(objVehiculo);
        }
    }
}
