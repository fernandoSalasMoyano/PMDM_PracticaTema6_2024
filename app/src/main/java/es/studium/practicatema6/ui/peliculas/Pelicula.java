package es.studium.practicatema6.ui.peliculas;

public class Pelicula {
    private String titulo;
    private int imagenResId;

    public Pelicula(String titulo, int imagenResId) {
        this.titulo = titulo;
        this.imagenResId = imagenResId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagenResId() {
        return imagenResId;
    }

    public void setImagenResId(int imagenResId) {
        this.imagenResId = imagenResId;
    }
}
