package edu.lclark.pokemonlistapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class PokemonRecyclerViewActivity extends AppCompatActivity implements PokemonRecyclerViewAdapter.OnPokemonRowClickListener {


    private PokemonRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_recycler_view);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activity_pokemon_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Pokedex pokedex = new Pokedex();
        mAdapter = new PokemonRecyclerViewAdapter(pokedex.getPokemons(), this);
        recyclerView.setAdapter(mAdapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onPokemonRowClick(int position) {
        mAdapter.removePokemon(position);
    }
}
