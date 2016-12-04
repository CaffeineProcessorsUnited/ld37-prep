package de.caffeineaddicted.ld37prep.wave;


import com.badlogic.gdx.math.Vector2;
import de.caffeineaddicted.ld37prep.actor.UnitEnemy;
import de.caffeineaddicted.ld37prep.screen.GameScreen;
import de.caffeineaddicted.sgl.SGL;
import de.caffeineaddicted.sgl.utils.MathUtils;

/**
 * @author Malte Heinzelmann
 */
abstract public class WaveGenerator {
    protected int remainingSpawns;
    private int minSpawn;
    private int maxSpawn;
    private int waveCount;
    private float tickWaitTimer, currentWaitTimer;
    private float tickDeferTimer, currentDeferTimer;
    private State state;
    private boolean autoSkipToNextWave = false;

    public WaveGenerator() {
        minSpawn = maxSpawn = 0;
        tickWaitTimer = -1;
        currentWaitTimer = 0;
        this.state = State.NEXTWAVE;
        waveCount = 0;
    }

    public void act(float delta) {
//        SGL.debug("+"+tickWaitTimer);
//        SGL.debug("++"+currentWaitTimer);
//        SGL.debug("-"+remainingSpawns);
//        SGL.debug("#"+tickDeferTimer);
//        SGL.debug("##"+currentDeferTimer);
        if (tickWaitTimer < 0)
            return;
        if(autoSkipToNextWave){
            int enemyCount = SGL.provide(GameScreen.class).getNumActorsOfType(UnitEnemy.class);
            if(enemyCount <= 0){
                skipToNextWave();
            }
        }
        if (state == State.NEXTWAVE) {
            currentWaitTimer += delta;
            if (currentWaitTimer > tickWaitTimer) {
                currentWaitTimer -= tickWaitTimer;
                remainingSpawns = MathUtils.random(getMinSpawn(), getMaxSpawn());

                state = State.DEFER;
                waveCount++;
            }
        } else if (state == State.DEFER) {
            currentDeferTimer += delta;
            if (currentDeferTimer > tickDeferTimer) {
                currentDeferTimer -= tickDeferTimer;
                spawn();
                if (remainingSpawns < 0)
                    state = State.NEXTWAVE;
            }
        }
    }

    protected void doSpawn(){
        UnitEnemy enemy = new UnitEnemy(UnitEnemy.Type.getRandom(getWaveCount()), 1 + 0.02f * getWaveCount());
        Vector2 pos = new Vector2(100,100);
        SGL.provide(GameScreen.class).addActor(enemy);
        enemy.setPosition(pos);
        SGL.debug("SPAWN");
    }

    abstract protected void spawn();

    public int getMinSpawn() {
        return minSpawn;
    }

    public void setMinSpawn(int minSpawn) {
        this.minSpawn = minSpawn;
    }

    public int getMaxSpawn() {
        return Math.max(minSpawn, maxSpawn);
    }

    public void setMaxSpawn(int maxSpawn) {
        this.maxSpawn = maxSpawn;
    }

    public float getTickWaitTimer() {
        return tickWaitTimer;
    }

    public void setTickWaitTimer(float tickWaitTimer) {
        this.tickWaitTimer = tickWaitTimer;
    }

    public float getCurrentWaitTimer() {
        return currentWaitTimer;
    }

    public void setCurrentWaitTimer(float currentWaitTimer) {
        this.currentWaitTimer = currentWaitTimer;
    }

    public float getCurrentDeferTimer() {
        return currentDeferTimer;
    }

    public void setCurrentDeferTimer(float currentDeferTimer) {
        this.currentDeferTimer = currentDeferTimer;
    }

    public float getTickDeferTimer() {
        return tickDeferTimer;
    }

    public void setTickDeferTimer(float tickDeferTimer) {
        this.tickDeferTimer = tickDeferTimer;
    }

    public boolean canAutoSkipToNextWave() {
        return autoSkipToNextWave;
    }

    public void setAutoSkipToNextWave(boolean autoSkipToNextWave) {
        this.autoSkipToNextWave = autoSkipToNextWave;
    }

    public float getRemainingTime() {
        if (state == State.NEXTWAVE) {
            return Math.max(0.f, getTickWaitTimer() - getCurrentWaitTimer() + getTickDeferTimer());
        }
        return Math.max(0.f, remainingSpawns * getTickDeferTimer() - getCurrentDeferTimer());
    }

    public int getWaveCount() {
        return waveCount;
    }

    public void skipToNextWave() {
        if (state == State.NEXTWAVE) {
            setCurrentWaitTimer(Math.max(getCurrentWaitTimer(), getTickWaitTimer() - 10));
        }
    }

    private enum State {
        NEXTWAVE,
        DEFER
    }
}
