package com.example.lab8.Daos;

import com.example.lab8.Beans.Cancion;

import java.sql.*;
import java.util.ArrayList;


public class CancionDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1";


    public ArrayList<Cancion> CancionesPorBanda(String textoBuscar) {
        ArrayList<Cancion> listaCanciones = new ArrayList<>();

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/lab6sw1";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "select * from cancion where banda=? ";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1,textoBuscar.toUpperCase());

            try (ResultSet rs = preparedStatement.executeQuery();) {
                while (rs.next()) {
                    Cancion cancion = new Cancion();
                    cancion.setIdcancion(rs.getInt(1));
                    cancion.setCancion(rs.getString(2));
                    cancion.setBanda(rs.getString(3));
                    listaCanciones.add(cancion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaCanciones;
    }

    public ArrayList<Cancion> obtenerTodasCanciones() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Cancion> listaCanciones = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from cancion")) {
            while (rs.next()) {
                Cancion cancion = new Cancion();
                int id = rs.getInt(1);
                String nombre_cancion = rs.getString(2);
                String banda = rs.getString(3);
                cancion.setIdcancion(id);
                cancion.setCancion(nombre_cancion);
                cancion.setBanda(banda);
                listaCanciones.add(cancion);
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaCanciones;
    }

    public void favorito(String id) {

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/lab6sw1";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "UPDATE cancion SET favorito =? where idcancion = ?";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setInt(1, 1);
            pstmt.setInt(2, Integer.parseInt(id));

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Cancion> obtenerFavoritos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Cancion> listaCanciones = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from cancion where favorito='1'")) {
            while (rs.next()) {
                Cancion cancion = new Cancion();
                int id = rs.getInt(1);
                String nombre_cancion = rs.getString(2);
                String banda = rs.getString(3);
                cancion.setIdcancion(id);
                cancion.setCancion(nombre_cancion);
                cancion.setBanda(banda);
                listaCanciones.add(cancion);
            }
        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaCanciones;
    }

    public void no_favorito(String id) {

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/lab6sw1";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "UPDATE cancion SET favorito =? where idcancion = ?";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setInt(1, 0);
            pstmt.setInt(2, Integer.parseInt(id));

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void agregarCancionLista(int idCancion, int idListaP) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String sql = "UPDATE cancion SET id_listapersonalizada = ?  WHERE idcancion = ?";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setInt(1, idCancion);
            pstmt.setInt(2, idListaP);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Cancion buscarPorId(String id) {
        Cancion cancion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "select idcancion from cancion where idcancion = ? ";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery();) {

                if (rs.next()) {
                    cancion = new Cancion();
                    cancion.setIdcancion(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cancion;
    }


}
