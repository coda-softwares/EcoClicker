package com.codasoftwares.ecoc.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.codasoftwares.ecoc.EcoClicker;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Eco Clicker";
        config.resizable = false;
		config.height = (int) Math.round(1920 * 0.4);
        config.width = (int) Math.round(1080 * 0.4);
		new LwjglApplication(new EcoClicker(), config);
	}
}
