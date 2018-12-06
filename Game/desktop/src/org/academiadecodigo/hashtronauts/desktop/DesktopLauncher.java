package org.academiadecodigo.hashtronauts.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.hashtronauts.Configurations;
import org.academiadecodigo.hashtronauts.DeltaGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Configurations.WINDOW_WIDTH;
		config.height = Configurations.WINDOW_HEIGHT;
		new LwjglApplication(new DeltaGame(), config);
	}
}
