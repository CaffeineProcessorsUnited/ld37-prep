package de.caffeineaddicted.ld37prep.wave;

/**
 * @author Malte Heinzelmann
 */
public class WaveGeneratorDefer extends WaveGenerator {

    @Override
    protected void spawn() {
        if (remainingSpawns >= 0) {
            // TODO
            remainingSpawns -= 1;
        }
    }
}
