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
public class Vehiculo {
    
    private String atrPlaca;
    private String atrMarca;
    private String atrColor;
    private TipoVehiculoEnum atrTipoVehiculoEnum;

    public Vehiculo(TipoVehiculoEnum atrTipoVehiculoEnum, String atrPlaca, String atrMarca, String atrColor) {
        this.atrTipoVehiculoEnum = atrTipoVehiculoEnum;
        this.atrPlaca = atrPlaca;
        this.atrMarca = atrMarca;
        this.atrColor = atrColor;
    }

    Vehiculo() {
       
    }
    
    public String getAtrPlaca() {
        return atrPlaca;
    }

    public void setAtrPlaca(String atrPlaca) {
        this.atrPlaca = atrPlaca;
    }

    public String getAtrMarca() {
        return atrMarca;
    }

    public void setAtrMarca(String atrMarca) {
        this.atrMarca = atrMarca;
    }

    public String getAtrColor() {
        return atrColor;
    }

    public void setAtrColor(String atrColor) {
        this.atrColor = atrColor;
    }
    
    public TipoVehiculoEnum getAtrTipoVehiculoEnum() {
        return atrTipoVehiculoEnum;
    }

    public void setAtrTipoVehiculoEnum(TipoVehiculoEnum atrTipoVehiculoEnum) {
        this.atrTipoVehiculoEnum = atrTipoVehiculoEnum;
    }
    
    @Override
    public String toString()
    {
        return " Vehiculo" + " Marca: "+atrMarca + " Color: "+atrColor + " Placa: " + atrPlaca; 
    }
}
