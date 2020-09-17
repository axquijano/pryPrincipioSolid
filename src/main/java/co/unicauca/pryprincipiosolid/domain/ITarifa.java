/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.pryprincipiosolid.domain;

/**
 * Interface de Tarifa Utiliza el patrón de diseño Strategy
 * @author Mannuel Fernando Granoble, Michel Andrea Gutierrez, Nathalia Ruiz, Ximena Quijano
 */
public interface ITarifa {
    
    double calcularTarifa(Vehiculo prmVehiculo, double prmTiempo);
}
