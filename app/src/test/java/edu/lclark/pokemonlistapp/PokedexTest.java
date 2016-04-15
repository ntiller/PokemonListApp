package edu.lclark.pokemonlistapp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by ntille on 4/14/16.
 */
public class PokedexTest {
    Pokedex mPokedex;

    @Before
    public void setup() {
        mPokedex = new Pokedex();
    }

    @Test
    public void testPokedexCount() {
        Assert.assertEquals(721, mPokedex.getPokemons().size());

    }
}
