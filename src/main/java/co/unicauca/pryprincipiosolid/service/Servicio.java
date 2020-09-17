/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.pryprincipiosolid.service;

import co.unicauca.pryprincipiosolid.domain.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Mannuel Fernando Granoble, Michel Andrea Gutierrez, Nathalia Ruiz, Ximena Quijano
 */
public class Servicio {
    private VehiculoRepositorio repository;

    /**
     * Constructor por defecto de la clase Service.
     */
    public Servicio() {
        repository = new VehiculoRepositorio();
    }

    /**
     * Lógica de acceso a datos
     *
     * @param par_newVehicle , Vehiculo a ser almacenado en la Base de datos.
     * @return true si fue posible guardar el producto, false en caso contrario.
     */
    public boolean guardarVehiculo(Vehiculo par_newVehicle) {

        if (par_newVehicle == null || par_newVehicle.getAtrPlaca().isEmpty() || par_newVehicle.getAtrMarca().isEmpty() || par_newVehicle.getAtrColor().isEmpty()) {
            return false;
        }
        repository.guardarVehiculo(par_newVehicle);
        return true;
    }

    /**
     * Funcion encargada de recibir lista de los vehiculos almacenados en la
     * base de datos.
     *
     * @return Retorna lista de vehiculos almacenados en la base de datos.
     */
    public List<Vehiculo> listaVehiculo() {
        List<Vehiculo> lstVehicle = new ArrayList<>();
        lstVehicle = repository.listarVehiculo();
        return lstVehicle;
    }
}
