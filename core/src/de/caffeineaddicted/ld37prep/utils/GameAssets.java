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
        load("raw/enemy_boss.png", Texture.class);
        load("raw/enemy_tank.png", Texture.class);
        load("raw/enemy_fast.png", Texture.class);
        load("raw/enemy_normal.png", Texture.class);

    }
}
