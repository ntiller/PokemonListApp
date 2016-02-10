package edu.lclark.pokemonlistapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ntille on 2/9/16.
 */
public class PokemonRecyclerViewAdapter extends RecyclerView.Adapter<PokemonRecyclerViewAdapter.PokemonViewHolder> {

    private final OnPokemonRowClickListener mListener;

    public interface OnPokemonRowClickListener {
        void onPokemonRowClick(int position);
    }

    private final ArrayList<Pokemon> mPokemons;

    public PokemonRecyclerViewAdapter(ArrayList<Pokemon> pokemons, OnPokemonRowClickListener listener) {
        mPokemons = pokemons;
        mListener = listener;
    }


    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.row_pokemon, parent, false);
        return new PokemonViewHolder(row);
    }

    @Override
    public void onBindViewHolder(final PokemonViewHolder holder, int position) {
        Pokemon pokemon = mPokemons.get(position);
        holder.name.setText(pokemon.getName());
        holder.id.setText(pokemon.getId());


        Context context = holder.name.getContext();
        String weight = context.getString(R.string.weight_label, pokemon.getWeight());

        holder.weight.setText(weight);

        String height = context.getString(R.string.height_label, pokemon.getHeight());
        holder.height.setText(height);

        holder.fullView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onPokemonRowClick(holder.getAdapterPosition());
                }
            }
        });

    }

    public void removePokemon(int position) {
        mPokemons.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return mPokemons.size();
    }


    static class PokemonViewHolder extends RecyclerView.ViewHolder {

        TextView name, id, weight, height;
        View fullView;

        public PokemonViewHolder(View itemView) {
            super(itemView);
            fullView = itemView;
            name = (TextView) itemView.findViewById(R.id.row_pokemon_name_textview);
            id = (TextView) itemView.findViewById(R.id.row_pokemon_id_textview);
            weight = (TextView) itemView.findViewById(R.id.row_pokemon_weight_textview);
            height = (TextView) itemView.findViewById(R.id.row_pokemon_height_textview);
        }
    }
}
