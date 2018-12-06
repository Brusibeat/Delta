package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hashtronauts.characters.player.PlatformPlayer;
import org.academiadecodigo.hashtronauts.levels.PlatformLevel;

import java.awt.*;

public class DeltaGame extends ApplicationAdapter {
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
		batch.end();

		player.move();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
