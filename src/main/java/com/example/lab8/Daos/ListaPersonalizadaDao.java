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

    public void crearLista(String nombre_lista) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "INSERT INTO lista_personalizada (nombre_lista) VALUES (?)";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, nombre_lista);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Cancion> verCanciones(String id_lista) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Cancion> listaCanciones = new ArrayList<>();

        String sql = "select idcancion, nombre_cancion, banda, l.nombre_lista from cancion c, lista_personalizada l\n" +
                "where c.id_listapersonalizada=l.idlista_personalizada\n" +
                "      and c.id_listapersonalizada = ?";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setInt(1, Integer.parseInt(id_lista));
            try (ResultSet rs = pstmt.executeQuery();) {

                if (rs.next()) {
                    Cancion cancion = new Cancion();
                    cancion.setIdcancion(rs.getInt(1));
                    cancion.setCancion(rs.getString(2));
                    cancion.setBanda(rs.getString(3));
                    cancion.setNombre_lista(rs.getString(4));
                    listaCanciones.add(cancion);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCanciones;
    }
}
