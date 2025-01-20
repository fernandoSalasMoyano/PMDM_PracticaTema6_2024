package es.studium.practicatema6.ui.series;

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
import es.studium.practicatema6.R;
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
        series.add(new Serie(getString(R.string.serie_breaking_bad), R.drawable.breaking_bad));
        series.add(new Serie(getString(R.string.serie_game_of_thrones), R.drawable.game_of_thrones));
        series.add(new Serie(getString(R.string.serie_stranger_things), R.drawable.stranger_things));
        series.add(new Serie(getString(R.string.serie_the_office), R.drawable.the_office));
        series.add(new Serie(getString(R.string.serie_sherlock), R.drawable.sherlock));
        series.add(new Serie(getString(R.string.serie_friends), R.drawable.friends));
        series.add(new Serie(getString(R.string.serie_how_i_met_your_mother), R.drawable.how_i_met_your_mother));
        series.add(new Serie(getString(R.string.serie_the_crown), R.drawable.the_crown));

        // Crear un Adaptador
        AdaptadorSeries adaptador = new AdaptadorSeries(requireContext(),
                R.layout.lista_item, series);

        // Asignar el adaptador a la ListView
        listaSeries.setAdapter(adaptador);

        // Configurar el evento onItemClick
        listaSeries.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(requireContext(), "Has elegido " + series.get(position).getTitulo(),
                        Toast.LENGTH_LONG).show()
        );

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FragmentSeriesViewModel.class);
        // TODO: Usar el ViewModel si es necesario
    }
}
