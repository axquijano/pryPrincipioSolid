/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.pryprincipiosolid.domain;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author Mannuel Fernando Granoble, Michel Andrea Gutierrez, Nathalia Ruiz, Ximena Quijano
 */
public class InstanciaVehiculo {
    private static InstanciaVehiculo var_Instance;
    private Map<TipoVehiculoEnum,ITarifa> TimeCostDictionary;

    private InstanciaVehiculo (){
        //si se requiere otro tipo de vehiculo , se abre un registro en entre diccionario
        //para no violar el principio 
        TimeCostDictionary = new EnumMap<>(TipoVehiculoEnum.class);
        TimeCostDictionary.put(TipoVehiculoEnum.CARRO, new CarroTarifa());    
        TimeCostDictionary.put(TipoVehiculoEnum.CAMION,new CamionTarifa());
        TimeCostDictionary.put(TipoVehiculoEnum.MOTO, new MotoTarifa());

    }

    /**
     * Funcion que se encarga de retornar  la instancia de la clase 
     * @return Retorna una instancia unica del vehiculo.
     */    
    public static InstanciaVehiculo getInstance(){

        if (var_Instance == null) {
            var_Instance = new InstanciaVehiculo();                    
        }
        return var_Instance;
    }

    /**
     * 
     * Funcion que se encarga de determinar para un vehiculo la clase que se encargara de calcular 
     * el costo del parqueadero
     * @param varTipoVeh parametro de tipo Vehiculo 
     * @return Retorna una instancia con algun tipo de vehiculo.
     */

    public ITarifa getInstanceVehicle(TipoVehiculoEnum varTipoVeh){
        ITarifa varResultado = null;

        if (TimeCostDictionary.containsKey(varTipoVeh)) {
            varResultado = TimeCostDictionary.get(varTipoVeh);
        }
        return varResultado;
    }
}
