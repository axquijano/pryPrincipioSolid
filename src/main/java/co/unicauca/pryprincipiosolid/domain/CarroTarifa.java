/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.pryprincipiosolid.domain;

/**
 *
 * @author Mannuel Fernando Granoble, Michel Andrea Gutierrez, Nathalia Ruiz, Ximena Quijano
 */
public class CarroTarifa implements ITarifa{

    @Override
    public double calcularTarifa(Vehiculo prmVehiculo, double prmTiempo) {
        double tarifaFija = 2000;
        double tarifaHora = 1000; 
        double fraccion;
       
        if(prmTiempo < 1 )
        {
            return 0;
        }
        else
        {
            if (prmTiempo < 61){
                return tarifaFija;
            }
            else{
                fraccion = ((prmTiempo - 60)*tarifaHora)/60;
                double total = tarifaFija + fraccion;
                double redondeo = Math.round(total/100)*100;
                return redondeo;
            }
        }
    }
    
}
