package com.geomi.carritocompras.modelo;

public class Producto
{
    int id;
    String title;
    String detalle;
    double precio;
    double rating;
    String image;

    public Producto(String id, String title, String detalle, String precio, String rating, String image) {
        id = id;
        this.title = title;
        this.detalle = detalle;
        precio = precio;
        rating = rating;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
