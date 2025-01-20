package es.studium.practicatema6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;



public class MiAdaptador extends BaseAdapter
{
    Context contexto;
    int distribucion;
    ArrayList<String> titulos;
    ArrayList<Integer> imagenes;


    public MiAdaptador(Context context, int layout, ArrayList<String> titulos, ArrayList<Integer> imagenes)
    {
        this.contexto = context;
        this.distribucion = layout;
        this.titulos = titulos;
        this.imagenes = imagenes;
    }

    @Override
    public int getCount()
    {
        return this.titulos.size();
    }
    @Override
    public Object getItem(int i)
    {
        return this.titulos.get(i);
    }
    @Override
    public long getItemId(int i)
    {
        return i;
    }
    @Override
    // Este método se llama una vez por cada elemento del ArrayList
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        // Copiamos la vista
        View v = view;

        // Inflamos la vista con nuestra propia distribución
        LayoutInflater layoutInflater = LayoutInflater.from(this.contexto);
        v = layoutInflater.inflate(R.layout.lista_item, null);

        // Obtener el valor actual según la posición
        String currentName = titulos.get(position);
        int imagenesResId = imagenes.get(position);

        // Referenciamos el elemento a modificar y lo rellenamos
        TextView textView = v.findViewById(R.id.titulo);
        ImageView imageView = v.findViewById(R.id.caratula);

        imageView.setImageResource(imagenesResId);
        textView.setText(currentName);

        // Devolvemos la vista inflada, rellena
        return v;
    }
}