package com.example.lab8.Daos;

import com.example.lab8.Beans.Cancion;
import com.example.lab8.Beans.ListaPersonalizada;

import java.sql.*;
import java.util.ArrayList;

public class ListaPersonalizadaDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1";

    public ArrayList<ListaPersonalizada> obtenerListas() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<ListaPersonalizada> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM lista_personalizada;")) {
            while (rs.next()) {
                ListaPersonalizada listaPersonalizada = new ListaPersonalizada();
                int id = rs.getInt(1);
                String nombre_lista = rs.getString(2);
                listaPersonalizada.setIdLista(id);
                listaPersonalizada.setNombre_lista(nombre_lista);
                lista.add(listaPersonalizada);
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return lista;
    }
}
