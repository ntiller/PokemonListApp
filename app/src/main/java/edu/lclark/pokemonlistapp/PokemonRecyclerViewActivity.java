package edu.lclark.pokemonlistapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class PokemonRecyclerViewActivity extends AppCompatActivity implements PokemonRecyclerViewAdapter.OnPokemonRowClickListener {


    public static final int CODE_POKEMON = 0;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_recycler_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.activity_pokemon_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Pokedex pokedex = new Pokedex();
        PokemonRecyclerViewAdapter adapter = new PokemonRecyclerViewAdapter(pokedex.getPokemons(), this);
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onPokemonRowClick(Pokemon pokemon) {
        Intent intent = new Intent(PokemonRecyclerViewActivity.this, PokemonDetailActivity.class);
        intent.putExtra(PokemonDetailActivity.ARG_POKEMON, pokemon);
        startActivityForResult(intent, CODE_POKEMON);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CODE_POKEMON && resultCode == RESULT_OK) {
            Pokemon pokemon = data.getParcelableExtra(PokemonDetailActivity.ARG_POKEMON);
            Snackbar.make(mRecyclerView, "I saw " + pokemon.getName(), Snackbar.LENGTH_LONG).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
