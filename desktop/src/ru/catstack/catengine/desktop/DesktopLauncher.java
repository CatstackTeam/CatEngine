package ru.catstack.catengine.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.catstack.catengine.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 504;
		config.height = 896;
		config.foregroundFPS = 0;
		config.vSyncEnabled = false;

		new LwjglApplication(new MyGdxGame(), config);
	}
}
