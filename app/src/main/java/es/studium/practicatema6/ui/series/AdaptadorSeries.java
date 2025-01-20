package es.studium.practicatema6.ui.series;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import es.studium.practicatema6.R;

public class AdaptadorSeries extends BaseAdapter {
    private Context contexto;
    private int distribucion;
    private ArrayList<Serie> series;

    public AdaptadorSeries(Context contexto, int distribucion, ArrayList<Serie> series) {
        this.contexto = contexto;
        this.distribucion = distribucion;
        this.series = series;
    }

    @Override
    public int getCount() {
        return this.series.size();
    }

    @Override
    public Object getItem(int position) {
        return this.series.get(position);
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
        Serie serie = series.get(position);

        // Referenciar elementos de la vista
        TextView textView = v.findViewById(R.id.titulo);
        ImageView imageView = v.findViewById(R.id.caratula);

        // Asignar valores
        textView.setText(serie.getTitulo());
        imageView.setImageResource(serie.getImagenResId());

        return v;
    }
}
