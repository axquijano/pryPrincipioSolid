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
public class CamionTarifa implements ITarifa{

    @Override
    public double calcularTarifa(Vehiculo prmVehiculo, double prmTiempo) {
        double tarifaFija = 15000;
        double tarifaMedioDia = 10000; 
        double fraccion;
        double horas;
        
        horas = prmTiempo/60;
        
        if( prmTiempo < 1 )
        {
            System.out.println("Tiempo negativo no es permitido");
            return 0;
        }
        else
        {
            if (ganoSorteo((int) (Math.random() * 1000 + 1))) {
                System.out.println("FELICIDADES! Ha ganado el sorteo no debe pagar nadita");
                return 0;
            } 
            else{
                if ( horas <= 12 ){
                    return tarifaMedioDia;
                }
                else if ( horas > 12 && horas <= 24){
                    return tarifaFija;
                }    
                else {
                    
                    fraccion =((horas - 24)*tarifaFija)/24;
                    double total = tarifaFija + fraccion;
                    double redondeo = Math.round(total/100)*100;
                    return redondeo;
                }
            }
        }
    }
    
    private boolean ganoSorteo(int parNumero) {
        int varNumero = (int) (Math.random() * 1000 + 1);
        return parNumero == varNumero;
    }
}
