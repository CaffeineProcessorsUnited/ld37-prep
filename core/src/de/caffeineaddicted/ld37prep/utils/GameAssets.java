package de.caffeineaddicted.ld37prep.utils;

import com.badlogic.gdx.graphics.Texture;
import de.caffeineaddicted.sgl.utils.Assets;

public class GameAssets extends Assets {
    @Override
    public void setup() {

    }

    @Override
    public void preload() {

    }

    @Override
    public void load() {
        load("raw/player.png", Texture.class);
    }
}
