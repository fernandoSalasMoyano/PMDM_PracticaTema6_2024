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

public class DetallesSeries extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_series);

        TextView txtTitulo = findViewById(R.id.textViewTituloS);
        TextView txtDirector = findViewById(R.id.textViewDirectorS);
        ImageView imgSerie = findViewById(R.id.imagenS);
        RatingBar calificacion = findViewById(R.id.ratingBarS);
        TextView txtReparto = findViewById(R.id.textViewRepartoS);
        TextView txtSinopsis = findViewById(R.id.textViewSinopsisS);
        TextView txtTemporadas = findViewById(R.id.textViewTemporadas);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null)
        {
            txtTitulo.setText(bundle.getString("tituloSerie"));
            txtDirector.setText(bundle.getString("autorSerie"));
            imgSerie.setImageResource(bundle.getInt("imagenSerie"));
            calificacion.setRating(bundle.getFloat("calificacionSerie"));
            txtReparto.setText(bundle.getString("repartoSerie"));
            txtSinopsis.setText(bundle.getString("sinopsisSerie"));
            txtTemporadas.setText(bundle.getString("temporadasSerie"));
        }

        if(bundle!=null)
        {
            imgSerie.setOnClickListener(view ->
            {
                Intent intentImagenCompleta = new Intent(DetallesSeries.this, CaratulaSerieGrande.class);
                intentImagenCompleta.putExtra("imagenSerie", bundle.getInt("imagenSerie"));
                startActivity(intentImagenCompleta);
            });
        }
    }
}