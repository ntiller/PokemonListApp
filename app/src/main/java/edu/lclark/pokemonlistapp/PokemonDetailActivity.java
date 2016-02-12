package edu.lclark.pokemonlistapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PokemonDetailActivity extends AppCompatActivity {

    public static final String ARG_POKEMON = "ArgPokemon";
    private Pokemon mPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        mPokemon = getIntent().getParcelableExtra(ARG_POKEMON);

        TextView nameTextView = (TextView) findViewById(R.id.activity_pokemon_detail_name_textview);
        TextView heightTextView = (TextView) findViewById(R.id.activity_pokemon_detail_height_textview);
        TextView weightTextView = (TextView) findViewById(R.id.activity_pokemon_detail_weight_textview);
        ImageView pokemonImageView = (ImageView) findViewById(R.id.activity_pokemon_detail_imageview);

        Picasso.with(this).load(mPokemon.getImageUrl()).fit().centerInside().into(pokemonImageView);

        nameTextView.setText(mPokemon.getName());
        heightTextView.setText(getString(R.string.height_label, mPokemon.getHeight()));
        weightTextView.setText(getString(R.string.weight_label, mPokemon.getWeight()));
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent();
        intent.putExtra(ARG_POKEMON, mPokemon);
        setResult(RESULT_OK, intent);
        finish();

    }
}
