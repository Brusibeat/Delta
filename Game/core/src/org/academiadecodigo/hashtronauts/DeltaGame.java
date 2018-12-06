package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import org.academiadecodigo.hashtronauts.characters.player.PlatformPlayer;
import org.academiadecodigo.hashtronauts.levels.PlatformLevel;

import java.awt.*;

public class DeltaGame extends ApplicationAdapter {
<<<<<<< HEAD
	private SpriteBatch batch;
	private OrthographicCamera camera;

	private PlatformLevel level;
	private PlatformPlayer player;

	@Override
	public void create () {
		batch = new SpriteBatch();
		level = new PlatformLevel();
		level.levelInit();
		player = level.getPlatformPlayer();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(player.getTexture(), player.getPosX(), player.getPosY());

		player.move();
		player.jump();

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
=======
    private SpriteBatch batch;
    private OrthographicCamera camera;

    private PlatformLevel level;
    private PlatformPlayer player;

    @Override
    public void create() {
        batch = new SpriteBatch();
        level = new PlatformLevel();
        level.levelInit();
        player = level.getPlatformPlayer();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(player.getTexture(), player.getPosX(), player.getPosY());

        if (player.isJumping()) {
            if (TimeUtils.nanoTime() - player.getLastJumpTime() < 250000000) {
                player.setPosY((int) (player.getPosY() + (Configurations.PLAYER_JUMP * Gdx.graphics.getDeltaTime())));
            }

            if (TimeUtils.nanoTime() - player.getLastJumpTime() > 300000000) {
                player.stopJump();
            }
        } else {
            player.setPosY((int) (player.getPosY() - (Configurations.PLAYER_FALL * Gdx.graphics.getDeltaTime())));
        }

        player.move();
        player.jump();

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
>>>>>>> bdd3b52ca78bd1846930f1f1bff3047fa2a3c5b7
}
