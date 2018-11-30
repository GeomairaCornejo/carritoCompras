package com.geomi.carritocompras.modelo;

public class Producto
{
    int id;
    String title;
    String detalle;
    double precio;
    double rating;
   int image;

    public Producto(int id, String title, String detalle, double precio, double rating, int image) {
        this.id = id;
        this.title = title;
        this.detalle = detalle;
        this.precio = precio;
        this.rating = rating;
        this.image = image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getPrecio() {
        return precio;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
