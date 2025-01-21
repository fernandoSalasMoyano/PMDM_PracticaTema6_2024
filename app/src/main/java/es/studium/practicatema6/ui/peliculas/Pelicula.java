package es.studium.practicatema6.ui.peliculas;

public class Pelicula {
    private String titulo;
    private int imagenResId;
    private String director;
    private float calificacion;
    private String reparto;
    private String sinopsis;

    public Pelicula(String titulo, int imagenResId, String director, float calificacion, String reparto, String sinopsis) {
        this.titulo = titulo;
        this.imagenResId = imagenResId;
        this.director = director;
        this.calificacion = calificacion;
        this.reparto = reparto;
        this.sinopsis = sinopsis;
    }

    public String getSinopsis()
    {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis)
    {
        this.sinopsis = sinopsis;
    }

    public String getReparto()
    {
        return reparto;
    }

    public void setReparto(String reparto)
    {
        this.reparto = reparto;
    }

    public float getCalificacion()
    {
        return calificacion;
    }

    public void setCalificacion(float calificacion)
    {
        this.calificacion = calificacion;
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

    public String getDirector()
    {
        return director;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }
}
