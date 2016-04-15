package edu.lclark.pokemonlistapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    PokemonArrayAdapter mAdapter;

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = (ListView) findViewById(R.id.activity_main_pokemon_listview);

        Pokedex pokedex = new Pokedex();

        mAdapter = new PokemonArrayAdapter(this, R.layout.row_pokemon, pokedex.getPokemons());

        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(this);




    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//        mAdapter.removePokemon(position);
//        Log.d(TAG, "onItemClick(): Removed pokemon at position: " + position);
//
//        mAdapter.notifyDataSetChanged();

        Intent intent = new Intent(this, PokemonDetailActivity.class);
        intent.putExtra(PokemonDetailActivity.ARG_POKEMON, mAdapter.getItem(position));
        startActivity(intent);
    }
}
