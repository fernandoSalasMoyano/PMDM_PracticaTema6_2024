package es.studium.practicatema6.ui.series;

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

public class FragmentSeries extends Fragment
{

    private FragmentSeriesViewModel mViewModel;
    ListView listaSeries;
    ArrayList<String> titulosSeries;
    ArrayList<Integer> imagenesSeries;

    public static FragmentSeries newInstance()
    {
        return new FragmentSeries();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        // Inflar el diseño del fragmento
        View root = inflater.inflate(R.layout.fragment_fragment_series, container, false);

        // Inicializar la ListView
        listaSeries = root.findViewById(R.id.miLista2);

        // Inicializar el ArrayList titulos de series
        titulosSeries = new ArrayList<>();
        titulosSeries.add(getString(R.string.serie_breaking_bad));
        titulosSeries.add(getString(R.string.serie_game_of_thrones));
        titulosSeries.add(getString(R.string.serie_stranger_things));
        titulosSeries.add(getString(R.string.serie_the_office));
        titulosSeries.add(getString(R.string.serie_sherlock));
        titulosSeries.add(getString(R.string.serie_friends));
        titulosSeries.add(getString(R.string.serie_how_i_met_your_mother));
        titulosSeries.add(getString(R.string.serie_the_crown));

        // Inicializar el ArrayList de imagenes de series
        imagenesSeries = new ArrayList<>();
        imagenesSeries.add(R.drawable.breaking_bad);
        imagenesSeries.add(R.drawable.game_of_thrones);
        imagenesSeries.add(R.drawable.stranger_things);
        imagenesSeries.add(R.drawable.the_office);
        imagenesSeries.add(R.drawable.sherlock);
        imagenesSeries.add(R.drawable.friends);
        imagenesSeries.add(R.drawable.how_i_met_your_mother);
        imagenesSeries.add(R.drawable.the_crown);

        // Crear un Adaptador
        // Crear un Adaptador
        MiAdaptador adaptador = new MiAdaptador(requireContext(),
                R.layout.lista_item, titulosSeries, imagenesSeries);

        // Asignar el adaptador a la ListView
        listaSeries.setAdapter(adaptador);

        // Asignar el adaptador a la ListView
        listaSeries.setAdapter(adaptador);

        // Configurar el evento onItemClick
        listaSeries.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(requireContext(), "Has elegido " + titulosSeries.get(position),
                        Toast.LENGTH_LONG).show()
        );

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FragmentSeriesViewModel.class);
        // TODO: Use the ViewModel
    }

}