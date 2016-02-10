package edu.lclark.pokemonlistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ntille on 2/4/16.
 */
public class PokemonListAdapter extends BaseAdapter {

    private static class ViewHolder {
        TextView name, id, weight, height;
    }


    private ArrayList<Pokemon> mPokemons;
    private Context mContext;

    public PokemonListAdapter(Context context, ArrayList<Pokemon> pokemons) {
        mPokemons = pokemons;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mPokemons.size();
    }

    @Override
    public Object getItem(int position) {
        return mPokemons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void removePokemon(int position) {
        mPokemons.remove(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(mContext);

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_pokemon, parent, false);

            TextView nameTextView = (TextView) convertView.findViewById(R.id.row_pokemon_name_textview);
            TextView idTextView = (TextView) convertView.findViewById(R.id.row_pokemon_id_textview);
            TextView weightTextView = (TextView) convertView.findViewById(R.id.row_pokemon_weight_textview);
            TextView heightTextView = (TextView) convertView.findViewById(R.id.row_pokemon_height_textview);

            viewHolder = new ViewHolder();
            viewHolder.name = nameTextView;
            viewHolder.id = idTextView;
            viewHolder.height = heightTextView;
            viewHolder.weight = weightTextView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Pokemon pokemon = mPokemons.get(position);

        viewHolder.name.setText(pokemon.getName());
        viewHolder.id.setText(pokemon.getId());

        String weight = mContext.getString(R.string.weight_label, pokemon.getWeight());

        viewHolder.weight.setText(weight);

        String height = mContext.getString(R.string.height_label, pokemon.getHeight());
        viewHolder.height.setText(height);


        return convertView;
    }
}
