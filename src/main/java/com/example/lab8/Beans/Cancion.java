package com.example.lab8.Beans;

public class Cancion {
    private int idcancion;
    private String cancion;
    private String banda;
    private int favorito;

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    public int getIdcancion() {
        return idcancion;
    }

    public void setIdcancion(int idcancion) {
        this.idcancion = idcancion;
    }

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }
}
