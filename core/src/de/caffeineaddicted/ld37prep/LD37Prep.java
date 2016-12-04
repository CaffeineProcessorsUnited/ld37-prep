package de.caffeineaddicted.ld37prep;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

import de.caffeineaddicted.ld37prep.screen.GameScreen;
import de.caffeineaddicted.ld37prep.utils.GameAssets;
import de.caffeineaddicted.sgl.ApplicationConfiguration;
import de.caffeineaddicted.sgl.AttributeList;
import de.caffeineaddicted.sgl.SGLGame;
import de.caffeineaddicted.sgl.ui.screens.SGLRootScreen;
import de.caffeineaddicted.sgl.utils.Assets;

public class LD37Prep extends SGLGame {

    private static final ApplicationConfiguration applicationConfiguration =
            new ApplicationConfiguration()
                    .set(AttributeList.WIDTH, 1280)
                    .set(AttributeList.HEIGHT, 720)
                    .set(AttributeList.RESIZABLE, true);
    private boolean paused;

    @Override
    protected void initGame() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        supply(Assets.class, new GameAssets());
    }

    @Override
    protected void initScreens() {
        provide(SGLRootScreen.class).loadScreen(new GameScreen());

    }

    @Override
    protected void startGame() {
        provide(Assets.class).setup();
        provide(Assets.class).preload();
        provide(Assets.class).load();
        provide(Assets.class).finishLoading();
        provide(SGLRootScreen.class).showScreen(GameScreen.class, SGLRootScreen.ZINDEX.NEAR);
    }

    @Override
    public String getAppName() {
        return "LD37Prep";
    }

    @Override
    public ApplicationConfiguration config() {
        return applicationConfiguration;
    }

    @Override
    public void onPause() {
        paused = true;
    }

    @Override
    public void onResume() {
        paused = false;
    }

    @Override
    public boolean isPaused() {
        return paused;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDispose() {

    }

    public static class CONSTANTS {

        public final static String PREFERENCE_NAME = "profile";

        /*
        Preferences keys
         */
        public final static String PREF_KEY_HIGHSCORE = "highscore";
        public final static int PREF_DEF_HIGHSCORE = 0;
        /*
        Bundle keys
         */
        public static final String BUNDLE_SCORE = "score";
        public static final String BUNDLE_HARDCORE = "hardcore";
    }
}
