package es.studium.practicatema6.ui.peliculas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import es.studium.practicatema6.R;

public class AdaptadorPeliculas extends BaseAdapter {
    private Context contexto;
    private int distribucion;
    private ArrayList<Pelicula> peliculas;

    public AdaptadorPeliculas(Context contexto, int distribucion, ArrayList<Pelicula> peliculas) {
        this.contexto = contexto;
        this.distribucion = distribucion;
        this.peliculas = peliculas;
    }

    @Override
    public int getCount() {
        return this.peliculas.size();
    }

    @Override
    public Object getItem(int position) {
        return this.peliculas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        // Inflamos la vista si es nula
        if (v == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.contexto);
            v = layoutInflater.inflate(distribucion, null);
        }

        // Obtener el elemento actual
        Pelicula pelicula = peliculas.get(position);

        // Referenciar elementos de la vista
        TextView textView = v.findViewById(R.id.titulo);
        ImageView imageView = v.findViewById(R.id.caratula);

        // Asignar valores
        textView.setText(pelicula.getTitulo());
        imageView.setImageResource(pelicula.getImagenResId());

        return v;
    }
}
