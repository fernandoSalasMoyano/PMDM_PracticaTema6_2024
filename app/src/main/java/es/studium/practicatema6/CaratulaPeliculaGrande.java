package es.studium.practicatema6;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CaratulaPeliculaGrande extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caratula_pelicula_grande);

        ImageView imgCaratulaGrande = findViewById(R.id.imagenCaratulaGrande);

        // Recibir el recurso de imagen desde el Intent
        int imagenResId = getIntent().getIntExtra("imagenPelicula", 0);
        imgCaratulaGrande.setImageResource(imagenResId);

        // Cerrar la actividad al hacer clic en la imagen
        imgCaratulaGrande.setOnClickListener(view -> finish());
    }
}
