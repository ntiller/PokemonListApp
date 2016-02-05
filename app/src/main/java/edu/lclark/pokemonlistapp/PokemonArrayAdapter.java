package edu.lclark.pokemonlistapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by ntille on 2/4/16.
 */
public class PokemonArrayAdapter extends ArrayAdapter<Pokemon> {


    public PokemonArrayAdapter(Context context, int resource, List<Pokemon> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        getItem(position);
        return super.getView(position, convertView, parent);
    }
}
