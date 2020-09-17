/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.pryprincipiosolid.main;

import co.unicauca.pryprincipiosolid.domain.*;
import java.text.ParseException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 *
 * @author Mannuel Fernando Granoble, Michel Andrea Gutierrez, Nathalia Ruiz, Ximena Quijano
 */
public class ClienteMainTest {
    
    public ClienteMainTest() {
    }
    /**
     * Test de la clase Vehiculo
     * @throws java.text.ParseException
     */
    @Test
    public void Vehiculo()throws ParseException{
        System.out.println("Vehiculo Carro");
        Vehiculo objCarro = new Vehiculo(TipoVehiculoEnum.CARRO,"QWE231","Mazda","Violeta"); 
        //falta comparacion para tipo de vehiiculo
        assertEquals("CARRO",objCarro.getAtrTipoVehiculoEnum().toString());
        assertEquals("Mazda",objCarro.getAtrMarca());
        assertEquals("Violeta",objCarro.getAtrColor());
        assertEquals("QWE231", objCarro.getAtrPlaca());

        Vehiculo objMoto = new Vehiculo(TipoVehiculoEnum.MOTO,"UIY897","Honda","Negra");   
        assertEquals("MOTO", objMoto.getAtrTipoVehiculoEnum().toString());
        assertEquals("Honda", objMoto.getAtrMarca());
        assertEquals("Negra", objMoto.getAtrColor());
        assertEquals("UIY897", objMoto.getAtrPlaca());

        Vehiculo objCamion = new Vehiculo(TipoVehiculoEnum.CAMION,"ASW675","Bughati","Blanco");
        assertEquals("CAMION", objCamion.getAtrTipoVehiculoEnum().toString());
        assertEquals("Bughati", objCamion.getAtrMarca());
        assertEquals("Blanco", objCamion.getAtrColor());
        assertEquals("ASW675", objCamion.getAtrPlaca());  
        
    }

    
    @Test
    public void Parqueadero() throws ParseException{
        Parqueadero objParqueadero= new Parqueadero();

        Vehiculo objCarro = new Vehiculo(TipoVehiculoEnum.CARRO,"QWE231","Mazda","Violeta"); 
        double  tarifaCarro = objParqueadero.CalculateTarifaParqueadero(objCarro,90);
        assertEquals(tarifaCarro, 2500.0,00.1);

        tarifaCarro = objParqueadero.CalculateTarifaParqueadero(objCarro,60);
        assertEquals(tarifaCarro, 2000.0, 000.1);

        tarifaCarro = objParqueadero.CalculateTarifaParqueadero(objCarro,105);
        assertEquals(tarifaCarro, 2800.0, 000.1);

        Vehiculo objCamion = new Vehiculo(TipoVehiculoEnum.CAMION,"ASW675","Bughati","Blanco");
        double tarifaCamion= objParqueadero.CalculateTarifaParqueadero(objCamion,600);
        assertEquals(tarifaCamion, 10000.0,00.1);



        Vehiculo objMoto = new Vehiculo(TipoVehiculoEnum.MOTO,"UIY897","Honda","Negra");
        double tarifaMoto= objParqueadero.CalculateTarifaParqueadero(objMoto,60);
        assertEquals(tarifaMoto, 1000.0,0.001);

        tarifaMoto= objParqueadero.CalculateTarifaParqueadero(objMoto, 89);
        assertEquals(tarifaMoto, 1200.0, 0.001);

    }
    
}
