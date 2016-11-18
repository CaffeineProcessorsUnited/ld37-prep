package de.caffeineaddicted.ld37prep.wave;

import com.badlogic.gdx.math.Vector2;

/**
 * @author Malte Heinzelmann
 */
public class WaveGeneratorBulk extends WaveGenerator {

    @Override
    protected void spawn() {
        while (remainingSpawns >= 0) {
            // TODO
            remainingSpawns--;
        }
    }
}
