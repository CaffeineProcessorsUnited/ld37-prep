package de.caffeineaddicted.ld37prep.screen;

import de.caffeineaddicted.ld37prep.LD37Prep;
import de.caffeineaddicted.ld37prep.actor.UnitPlayer;
import de.caffeineaddicted.ld37prep.message.FireEverythingMessage;
import de.caffeineaddicted.ld37prep.wave.WaveGenerator;
import de.caffeineaddicted.sgl.SGL;
import de.caffeineaddicted.sgl.etities.Actor;
import de.caffeineaddicted.sgl.etities.Group;
import de.caffeineaddicted.sgl.messages.Message;
import de.caffeineaddicted.sgl.messages.MessageReceiver;
import de.caffeineaddicted.sgl.ui.screens.SGLScreen;
import de.caffeineaddicted.sgl.ui.screens.SGLStagedScreen;

import java.util.ArrayList;

/**
 * @author Malte Heinzelmann
 */
public class GameScreen extends SGLStagedScreen<LD37Prep> {

    private WaveGenerator waveGenerator;
    public ArrayList<Actor> deleteLater = new ArrayList<Actor>();
    private UnitPlayer player;


    public void act(float delta) {
        for (Actor a: deleteLater) {
            stage.removeActor(a);
        }
        super.act(delta);
    }

    @Override
    public void onBeauty() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void onDispose() {

    }

    @Override
    public void onCreate() {
        player = new UnitPlayer();
        SGL.registerMessageReceiver(FireEverythingMessage.class, new MessageReceiver() {
            @Override
            public void receiveMessage(Message message) {

            }
        });
    }

    @Override
    public void onHide() {

    }

    @Override
    public void onShow() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    public void loseGame() {

    }

    public void addActor(Actor actor) {
        stage.addActor(actor);
    }

    public UnitPlayer getPlayer() {
        return player;
    }

    public static class Z_INDEX {
        public static int Enemy = 5;
        public static int Projectile = 10;
    }
}