package edu.lclark.pokemonlistapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    PokemonListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = (ListView) findViewById(R.id.activity_main_pokemon_listview);

        Pokedex pokedex = new Pokedex();

        mAdapter = new PokemonListAdapter(this, pokedex.getPokemons());

        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        mAdapter.removePokemon(position);
        mAdapter.notifyDataSetChanged();
    }
}
