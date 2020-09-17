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
public class Parqueadero {
    /**
     * Calcular la tarifa
     * @param prmVehiculo  @param prmTiempo Vehiculo sobre la cual se calcula la tarifa del parqueadero
     * @return tarifa del parqueadero
     */
    
    public double CalculateTarifaParqueadero(Vehiculo prmVehiculo, double prmTiempo) {

        if (prmVehiculo == null) {
            return -1;
        }
        //El parqueadero devuelve un instancia de la jerarquia 
        ITarifa  varTarifa = InstanciaVehiculo.getInstance().getInstanceVehicle(prmVehiculo.getAtrTipoVehiculoEnum());
        double varResultado = varTarifa.calcularTarifa(prmVehiculo, prmTiempo);
        return varResultado;
    }
    
    
    
}
