package es.studium.practicatema6.ui.peliculas;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import es.studium.practicatema6.MiAdaptador;
import es.studium.practicatema6.R;

public class FragmentPeliculas extends Fragment
{
    private FragmentPeliculasViewModel mViewModel;
    ListView listaPeliculas;
    ArrayList<String> titulosPeliculas;
    ArrayList<Integer> imagenesPeliculas;

    public static FragmentPeliculas newInstance()
    {
        return new FragmentPeliculas();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        // Inflar el diseño del fragmento
        View root = inflater.inflate(R.layout.fragment_fragment_peliculas, container, false);

        // Inicializar la ListView
        listaPeliculas = root.findViewById(R.id.miLista);

        // Inicializar el ArrayList de titulos de películas
        titulosPeliculas = new ArrayList<>();
        titulosPeliculas.add(getString(R.string.pelicula_el_padrino));
        titulosPeliculas.add(getString(R.string.pelicula_titanic));
        titulosPeliculas.add(getString(R.string.pelicula_casablanca));
        titulosPeliculas.add(getString(R.string.pelicula_gladiator));
        titulosPeliculas.add(getString(R.string.pelicula_forrest_gump));
        titulosPeliculas.add(getString(R.string.pelicula_el_senor_de_los_anillos));
        titulosPeliculas.add(getString(R.string.pelicula_pulp_fiction));
        titulosPeliculas.add(getString(R.string.pelicula_star_wars));

        // Inicializar el ArrayList de imagenes de películas
        imagenesPeliculas = new ArrayList<>();
        imagenesPeliculas.add(R.drawable.el_padrino);
        imagenesPeliculas.add(R.drawable.titanic);
        imagenesPeliculas.add(R.drawable.casablanca);
        imagenesPeliculas.add(R.drawable.gladiator);
        imagenesPeliculas.add(R.drawable.forrest_gump);
        imagenesPeliculas.add(R.drawable.el_senor_de_los_anillos);
        imagenesPeliculas.add(R.drawable.pulp_fiction);
        imagenesPeliculas.add(R.drawable.star_wars);



        // Crear un Adaptador
        MiAdaptador adaptador = new MiAdaptador(requireContext(),
                R.layout.lista_item, titulosPeliculas, imagenesPeliculas);

        // Asignar el adaptador a la ListView
        listaPeliculas.setAdapter(adaptador);

        // Configurar el evento onItemClick
        listaPeliculas.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(requireContext(), "Has elegido " + titulosPeliculas.get(position),
                        Toast.LENGTH_LONG).show()
        );

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FragmentPeliculasViewModel.class);
        // TODO: Usar el ViewModel si es necesario
    }
}
