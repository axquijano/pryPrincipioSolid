/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.pryprincipiosolid.domain;

import java.util.List;

/**
 *
 * @author Mannuel Fernando Granoble, Michel Andrea Gutierrez, Nathalia Ruiz, Ximena Quijano
 */
public interface IVehiculoRepositorio {
    
    boolean guardarVehiculo(Vehiculo prmVehiculo);
    List <Vehiculo> listarVehiculo();
}
