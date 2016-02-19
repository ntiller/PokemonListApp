package edu.lclark.pokemonlistapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class PokemonRecyclerViewActivity extends AppCompatActivity implements PokemonRecyclerViewAdapter.OnPokemonRowClickListener, View.OnClickListener {


    public static final int CODE_POKEMON = 0;
    private RecyclerView mRecyclerView;
    private FloatingActionButton mFab;
    private Pokedex mPokedex;
    private PokemonRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_recycler_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.activity_pokemon_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFab = (FloatingActionButton) findViewById(R.id.activity_pokemon_fab);
        mFab.setOnClickListener(this);


        mPokedex = new Pokedex();
        mAdapter = new PokemonRecyclerViewAdapter(mPokedex.getPokemon(), this);
        mRecyclerView.setAdapter(mAdapter);

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

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.activity_pokemon_fab) {
            mAdapter.addPokemon(mPokedex.getPokemon());
        }
    }
}
