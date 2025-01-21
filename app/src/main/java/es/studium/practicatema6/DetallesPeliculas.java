package es.studium.practicatema6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetallesPeliculas extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalles_peliculas);

        TextView txtTitulo = findViewById(R.id.textViewTituloP);
        TextView txtDirector = findViewById(R.id.textViewDirectorP);
        ImageView imgPelicula = findViewById(R.id.imagenP);
        RatingBar calificacion = findViewById(R.id.ratingBar2);
        TextView txtReparto = findViewById(R.id.textViewRepartoP);
        TextView txtSinopsis = findViewById(R.id.textViewSinopsisP);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null)
        {
            txtTitulo.setText(bundle.getString("tituloPelicula"));
            txtDirector.setText(bundle.getString("autorPelicula"));
            imgPelicula.setImageResource(bundle.getInt("imagenPelicula"));
            calificacion.setRating(bundle.getFloat("calificacionPelicula"));
            txtReparto.setText(bundle.getString("repartoPelicula"));
            txtSinopsis.setText(bundle.getString("sinopsisPelicula"));
        }

        if(bundle!=null)
        {
        imgPelicula.setOnClickListener(view ->
        {
            Intent intentImagenCompleta = new Intent(DetallesPeliculas.this, CaratulaPeliculaGrande.class);
            intentImagenCompleta.putExtra("imagenPelicula", bundle.getInt("imagenPelicula"));
            startActivity(intentImagenCompleta);
        });
        }
    }


}