package es.studium.practicatema6.ui.peliculas;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

import es.studium.practicatema6.DetallesPeliculas;
import es.studium.practicatema6.ui.peliculas.AdaptadorPeliculas;
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
        peliculas.add(new Pelicula(getString(R.string.pelicula_el_padrino), R.drawable.el_padrino, getString(R.string.director_el_padrino), 5, getString(R.string.reparto_el_padrino), getString(R.string.sinopsis_el_padrino)));
        peliculas.add(new Pelicula(getString(R.string.pelicula_titanic), R.drawable.titanic, getString(R.string.director_titanic), 2, getString(R.string.reparto_titanic), getString(R.string.sinopsis_titanic)));
        peliculas.add(new Pelicula(getString(R.string.pelicula_casablanca), R.drawable.casablanca, getString(R.string.director_casablanca), 4, getString(R.string.reparto_casablanca), getString(R.string.sinopsis_casablanca)));
        peliculas.add(new Pelicula(getString(R.string.pelicula_gladiator), R.drawable.gladiator, getString(R.string.director_gladiator), 3, getString(R.string.reparto_gladiator), getString(R.string.sinopsis_gladiator)));
        peliculas.add(new Pelicula(getString(R.string.pelicula_forrest_gump), R.drawable.forrest_gump, getString(R.string.director_forrest_gump), 4, getString(R.string.reparto_forrest_gump), getString(R.string.sinopsis_forrest_gump)));
        peliculas.add(new Pelicula(getString(R.string.pelicula_el_senor_de_los_anillos), R.drawable.el_senor_de_los_anillos, getString(R.string.director_el_senor_de_los_anillos), 3, getString(R.string.reparto_el_senor_de_los_anillos), getString(R.string.sinopsis_el_senor_de_los_anillos)));
        peliculas.add(new Pelicula(getString(R.string.pelicula_pulp_fiction), R.drawable.pulp_fiction, getString(R.string.director_pulp_fiction), 5, getString(R.string.reparto_pulp_fiction), getString(R.string.sinopsis_pulp_fiction)));
        peliculas.add(new Pelicula(getString(R.string.pelicula_star_wars), R.drawable.star_wars, getString(R.string.director_star_wars), 4, getString(R.string.reparto_star_wars), getString(R.string.sinopsis_star_wars)));

        // Crear un Adaptador
        AdaptadorPeliculas adaptador = new AdaptadorPeliculas(requireContext(), R.layout.lista_item, peliculas);

        // Asignar el adaptador a la ListView
        listaPeliculas.setAdapter(adaptador);

        // Configurar el evento onItemClick
        listaPeliculas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtener la película seleccionada
                Pelicula peliculaSeleccionada = peliculas.get(position);

                // Crear el intent para DetallesPeliculas
                Intent visorDetalles = new Intent(requireContext(), DetallesPeliculas.class);

                // Pasar los datos de la película al intent
                visorDetalles.putExtra("tituloPelicula", peliculaSeleccionada.getTitulo());
                visorDetalles.putExtra("autorPelicula", peliculaSeleccionada.getDirector());
                visorDetalles.putExtra("imagenPelicula", peliculaSeleccionada.getImagenResId());
                visorDetalles.putExtra("calificacionPelicula", peliculaSeleccionada.getCalificacion());
                visorDetalles.putExtra("repartoPelicula", peliculaSeleccionada.getReparto());
                visorDetalles.putExtra("sinopsisPelicula", peliculaSeleccionada.getSinopsis());

                // Iniciar la actividad DetallesPeliculas
                startActivity(visorDetalles);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FragmentPeliculasViewModel.class);
        // TODO: Usar el ViewModel si es necesario
    }
}
