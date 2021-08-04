package com.co.sofka.web.controllers;

import com.co.sofka.web.datos.DatosBase;
import java.sql.*;

public class ConexionBD {
    Connection connection = null;
    Statement statement;
    ResultSet resulset;

    public void establecerConexionBD(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://sofka-training.cpxphmd1h1ok.us-east-1.rds.amazonaws.com/DB_SauceDemo","sofka_training","BZenX643bQHw");
        } catch (Exception e) {
            System.err.println("Error:" +e);
        }
    }

    public void ejecutarConsulta(String query, String username, String password, DatosBase datosBase) throws SQLException {

        try {
            statement = connection.createStatement();
            resulset = statement.executeQuery(query);

            while (resulset.next()){
                datosBase.setUsuario(resulset.getString(username));
                datosBase.setContrasena(resulset.getString(password));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            connection.close();
        }
    }
}
