package com.example.lab8.Daos;

import com.example.lab8.Beans.Banda;

import java.util.ArrayList;
import java.sql.*;

public class BandaDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1";

    //En este caso se usa preparedStatement
    public ArrayList<Banda> obtenerListarecomendado(){
        ArrayList<Banda> listabandas = new ArrayList<>();

        String sql = "select idcancion, nombre_cancion, banda from cancion c, reproduccion r where c.idcancion=r.cancion_idcancion group by cancion_idcancion having count(*) >2 order by count(*) desc";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                Banda banda = new Banda();
                banda.setId(rs.getInt(1));
                banda.setNombre_cancion(rs.getString(2));
                banda.setNombre_banda(rs.getString(3));
                listabandas.add(banda);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listabandas;
    }


}
