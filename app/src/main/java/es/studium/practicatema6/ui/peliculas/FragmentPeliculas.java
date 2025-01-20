package es.studium.practicatema6.ui.peliculas;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import es.studium.practicatema6.MiAdaptador;
import es.studium.practicatema6.ui.peliculas.Pelicula;
import es.studium.practicatema6.R;

public class FragmentPeliculas extends Fragment {
    private FragmentPeliculasViewModel mViewModel;
    ListView listaPeliculas;
    ArrayList<Pelicula> peliculas;

    public static FragmentPeliculas newInstance() {
        return new FragmentPeliculas();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View root = inflater.inflate(R.layout.fragment_fragment_peliculas, container, false);

        // Inicializar la ListView
        listaPeliculas = root.findViewById(R.id.miLista);

        // Inicializar la lista de películas
        peliculas = new ArrayList<>();
        peliculas.add(new Pelicula(getString(R.string.pelicula_el_padrino), R.drawable.el_padrino));
        peliculas.add(new Pelicula(getString(R.string.pelicula_titanic), R.drawable.titanic));
        peliculas.add(new Pelicula(getString(R.string.pelicula_casablanca), R.drawable.casablanca));
        peliculas.add(new Pelicula(getString(R.string.pelicula_gladiator), R.drawable.gladiator));
        peliculas.add(new Pelicula(getString(R.string.pelicula_forrest_gump), R.drawable.forrest_gump));
        peliculas.add(new Pelicula(getString(R.string.pelicula_el_senor_de_los_anillos), R.drawable.el_senor_de_los_anillos));
        peliculas.add(new Pelicula(getString(R.string.pelicula_pulp_fiction), R.drawable.pulp_fiction));
        peliculas.add(new Pelicula(getString(R.string.pelicula_star_wars), R.drawable.star_wars));

        // Crear un Adaptador
        AdaptadorPeliculas adaptador = new AdaptadorPeliculas(requireContext(),
                R.layout.lista_item, peliculas);

        // Asignar el adaptador a la ListView
        listaPeliculas.setAdapter(adaptador);

        // Configurar el evento onItemClick
        listaPeliculas.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(requireContext(), "Has elegido " + peliculas.get(position).getTitulo(),
                        Toast.LENGTH_LONG).show()
        );

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FragmentPeliculasViewModel.class);
        // TODO: Usar el ViewModel si es necesario
    }
}
