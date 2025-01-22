package es.studium.practicatema6.ui.series;

public class Serie {
    private String titulo;
    private int imagenResId;
    private String director;
    private float calificacion;
    private String reparto;
    private String sinopsis;
    private int temporadas;

    public String getDirector()
    {
        return director;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

    public float getCalificacion()
    {
        return calificacion;
    }

    public void setCalificacion(float calificacion)
    {
        this.calificacion = calificacion;
    }

    public String getReparto()
    {
        return reparto;
    }

    public void setReparto(String reparto)
    {
        this.reparto = reparto;
    }

    public String getSinopsis()
    {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis)
    {
        this.sinopsis = sinopsis;
    }

    public int getTemporadas()
    {
        return temporadas;
    }

    public void setTemporadas(int temporadas)
    {
        this.temporadas = temporadas;
    }

    public Serie(String titulo, int imagenResId, String director, float calificacion, String reparto, String sinopsis, int temporadas) {
        this.titulo = titulo;
        this.imagenResId = imagenResId;
        this.director = director;
        this.calificacion = calificacion;
        this.reparto = reparto;
        this.sinopsis = sinopsis;
        this.temporadas = temporadas;
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
