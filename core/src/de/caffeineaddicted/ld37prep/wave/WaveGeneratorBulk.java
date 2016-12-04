package de.caffeineaddicted.ld37prep.wave;

/**
 * @author Malte Heinzelmann
 */
public class WaveGeneratorBulk extends WaveGenerator {

    @Override
    protected void spawn() {
        while (remainingSpawns >= 0) {
            doSpawn();
            remainingSpawns--;
        }
    }
}
