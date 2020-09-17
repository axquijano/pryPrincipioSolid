/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.pryprincipiosolid.domain;

import co.unicauca.pryprincipiosolid.service.Servicio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mannuel Fernando Granoble, Michel Andrea Gutierrez, Nathalia Ruiz, Ximena Quijano
 */
public class VehiculoRepositorio implements IVehiculoRepositorio {
    private Connection conn;

    /**
     * Constructor por defecto de la clase VehicleRepository.
     */
    public VehiculoRepositorio() {
        initDatabase();
    }

    /**
     * Funcion encargada de insertar un vehiculo en la Base de datos.
     *
     * @param prmVehiculo Vehiculo a ser Insertado en la Base de datos.
     * @return Retorna false si el proceso para insertar el vehiculo en la BD y retorna True si
     * el proceso es exitoso.
     */
    @Override
    public boolean guardarVehiculo(Vehiculo prmVehiculo) {
        try {
            if (prmVehiculo == null ||prmVehiculo.getAtrPlaca().isEmpty() || prmVehiculo.getAtrMarca().isEmpty() || prmVehiculo.getAtrColor().isEmpty()) {
                return false;
            }
            String sql = "INSERT INTO Vehiculo ( Marca, Color, Placa ) " + "VALUES ( ?, ?, ? )";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, prmVehiculo.getAtrMarca());
            pstmt.setString(2, prmVehiculo.getAtrColor());
            pstmt.setString(3, prmVehiculo.getAtrPlaca());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Funcion encargada de obtener los vehiculos de la Base de datos.
     *
     * @return Retorna lista de vehiculos para poder ser mostrados al usuario.
     */    
    @Override
    public List<Vehiculo> listarVehiculo() {

        List<Vehiculo> lstVehicle = new ArrayList<>();
        try {
            String sql = "SELECT Marca, Color, Placa FROM Vehiculo";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehiculo varVehiculo = new Vehiculo();
                varVehiculo.setAtrMarca(rs.getString("Marca"));
                varVehiculo.setAtrColor(rs.getString("Color"));
                varVehiculo.setAtrPlaca(rs.getString("Placa"));

                lstVehicle.add(varVehiculo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstVehicle;
    }

    /**
     * Funcion para crear la tabla Vehicle y la base de datos (en memoria).
     */    
    private void initDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS Vehiculo (\n"
                + "	Placa text PRIMARY KEY,\n"
                + "	Color text NOT NULL,\n"
                + "	Marca text NOT NULL\n"
                + ");";
        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Funcion que conecta la aplicacion con la base de datos.
     */
    public void connect() {
        //String url = "jdbc:sqlite:./mydatabase.db";
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Funcion que desconecta la aplicacion de la base de datos.
     */
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
