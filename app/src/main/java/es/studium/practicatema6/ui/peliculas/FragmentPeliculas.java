package es.studium.practicatema6.ui.peliculas;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import es.studium.practicatema6.R;

public class FragmentPeliculas extends Fragment
{
    private FragmentPeliculasViewModel mViewModel;
    ListView listaPeliculas;
    ArrayList<String> elementosPeliculas;

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

        // Inicializar el ArrayList de películas
        elementosPeliculas = new ArrayList<>();
        elementosPeliculas.add(getString(R.string.pelicula_el_padrino));
        elementosPeliculas.add(getString(R.string.pelicula_titanic));
        elementosPeliculas.add(getString(R.string.pelicula_casablanca));
        elementosPeliculas.add(getString(R.string.pelicula_gladiator));
        elementosPeliculas.add(getString(R.string.pelicula_forrest_gump));
        elementosPeliculas.add(getString(R.string.pelicula_el_senor_de_los_anillos));
        elementosPeliculas.add(getString(R.string.pelicula_pulp_fiction));
        elementosPeliculas.add(getString(R.string.pelicula_star_wars));

        // Crear un Adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_list_item_1, elementosPeliculas);

        // Asignar el adaptador a la ListView
        listaPeliculas.setAdapter(adaptador);

        // Configurar el evento onItemClick
        listaPeliculas.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(requireContext(), "Has elegido " + elementosPeliculas.get(position),
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
