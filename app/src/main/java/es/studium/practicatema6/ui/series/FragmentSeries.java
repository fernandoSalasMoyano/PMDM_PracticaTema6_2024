package es.studium.practicatema6.ui.series;

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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import es.studium.practicatema6.DetallesPeliculas;
import es.studium.practicatema6.DetallesSeries;
import es.studium.practicatema6.MiAdaptador;
import es.studium.practicatema6.R;
import es.studium.practicatema6.ui.peliculas.Pelicula;
import es.studium.practicatema6.ui.series.Serie;

public class FragmentSeries extends Fragment {

    private FragmentSeriesViewModel mViewModel;
    ListView listaSeries;
    ArrayList<Serie> series;


    public static FragmentSeries newInstance() {
        return new FragmentSeries();

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View root = inflater.inflate(R.layout.fragment_fragment_series, container, false);

        // Inicializar la ListView
        listaSeries = root.findViewById(R.id.miLista2);

        // Inicializar la lista de series
        series = new ArrayList<>();
        series.add(new Serie(
                getString(R.string.serie_breaking_bad),
                R.drawable.breaking_bad,
                getString(R.string.creador_breaking_bad),
                4,
                getString(R.string.reparto_breaking_bad),
                getString(R.string.sinopsis_breaking_bad),
                5 // Número de temporadas totales
        ));
        series.add(new Serie(
                getString(R.string.serie_game_of_thrones),
                R.drawable.game_of_thrones,
                getString(R.string.creador_game_of_thrones),
                3,
                getString(R.string.reparto_game_of_thrones),
                getString(R.string.sinopsis_game_of_thrones),
                8 // Número de temporadas totales
        ));
        series.add(new Serie(
                getString(R.string.serie_stranger_things),
                R.drawable.stranger_things,
                getString(R.string.creador_stranger_things),
                4,
                getString(R.string.reparto_stranger_things),
                getString(R.string.sinopsis_stranger_things),
                4 // Número de temporadas actuales (actualizable si es necesario)
        ));
        series.add(new Serie(
                getString(R.string.serie_the_office),
                R.drawable.the_office,
                getString(R.string.creador_the_office),
                5,
                getString(R.string.reparto_the_office),
                getString(R.string.sinopsis_the_office),
                9 // Número de temporadas totales
        ));
        series.add(new Serie(
                getString(R.string.serie_sherlock),
                R.drawable.sherlock,
                getString(R.string.creador_sherlock),
                5,
                getString(R.string.reparto_sherlock),
                getString(R.string.sinopsis_sherlock),
                4 // Número de temporadas totales
        ));
        series.add(new Serie(
                getString(R.string.serie_friends),
                R.drawable.friends,
                getString(R.string.creador_friends),
                4,
                getString(R.string.reparto_friends),
                getString(R.string.sinopsis_friends),
                10 // Número de temporadas totales
        ));
        series.add(new Serie(
                getString(R.string.serie_how_i_met_your_mother),
                R.drawable.how_i_met_your_mother,
                getString(R.string.creador_how_i_met_your_mother),
                5,
                getString(R.string.reparto_how_i_met_your_mother),
                getString(R.string.sinopsis_how_i_met_your_mother),
                9 // Número de temporadas totales
        ));
        series.add(new Serie(
                getString(R.string.serie_the_crown),
                R.drawable.the_crown,
                getString(R.string.creador_the_crown),
                2,
                getString(R.string.reparto_the_crown),
                getString(R.string.sinopsis_the_crown),
                6 // Número de temporadas actuales (actualizable si es necesario)
        ));



        // Crear un Adaptador
        AdaptadorSeries adaptador = new AdaptadorSeries(requireContext(),
                R.layout.lista_item, series);

        // Asignar el adaptador a la ListView
        listaSeries.setAdapter(adaptador);

        // Configurar el evento onItemClick
        listaSeries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtener la película seleccionada
                Serie serieSeleccionada = series.get(position);

                // Crear el intent para DetallesPeliculas
                Intent visorDetalles = new Intent(requireContext(), DetallesSeries.class);

                // Pasar los datos de la película al intent
                visorDetalles.putExtra("tituloSerie", serieSeleccionada.getTitulo());
                visorDetalles.putExtra("autorSerie", serieSeleccionada.getDirector());
                visorDetalles.putExtra("imagenSerie", serieSeleccionada.getImagenResId());
                visorDetalles.putExtra("calificacionSerie", serieSeleccionada.getCalificacion());
                visorDetalles.putExtra("repartoSerie", serieSeleccionada.getReparto());
                visorDetalles.putExtra("sinopsisSerie", serieSeleccionada.getSinopsis());

                // Iniciar la actividad DetallesPeliculas
                startActivity(visorDetalles);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FragmentSeriesViewModel.class);
        // TODO: Usar el ViewModel si es necesario
    }
}
