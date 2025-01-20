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

import es.studium.practicatema6.R;

public class FragmentSeries extends Fragment
{

    private FragmentSeriesViewModel mViewModel;

    ListView listaSeries;
    ArrayList<String> elementosSeries;

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
// Inicializar el ArrayList de series
        elementosSeries = new ArrayList<>();
        elementosSeries.add(getString(R.string.serie_breaking_bad));
        elementosSeries.add(getString(R.string.serie_game_of_thrones));
        elementosSeries.add(getString(R.string.serie_stranger_things));
        elementosSeries.add(getString(R.string.serie_the_office));
        elementosSeries.add(getString(R.string.serie_sherlock));
        elementosSeries.add(getString(R.string.serie_friends));
        elementosSeries.add(getString(R.string.serie_how_i_met_your_mother));
        elementosSeries.add(getString(R.string.serie_the_crown));

        // Crear un Adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_list_item_1, elementosSeries);

        // Asignar el adaptador a la ListView
        listaSeries.setAdapter(adaptador);

        // Configurar el evento onItemClick
        listaSeries.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(requireContext(), "Has elegido " + elementosSeries.get(position),
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