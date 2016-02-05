package edu.lclark.pokemonlistapp;

/**
 * Created by ntille on 2/3/16.
 */
public class Pokemon {


    // id,identifier,species_id,height,weight

    private String mName, mId, mSpeciesId, mHeight, mWeight;


    public Pokemon(String csvStr) {
        String[] split = csvStr.trim().split(",");

        mId = split[0];
        mName = split[1];
        mSpeciesId = split[2];
        mHeight = split[3];
        mWeight = split[4];
    }


    public String getName() {
        return mName;
    }

    public String getId() {
        return mId;
    }

    public String getSpeciesId() {
        return mSpeciesId;
    }

    public String getHeight() {
        return mHeight;
    }

    public String getWeight() {
        return mWeight;
    }
}
