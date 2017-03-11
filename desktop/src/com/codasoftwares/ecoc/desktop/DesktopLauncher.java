package com.codasoftwares.ecoc.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.codasoftwares.ecoc.EcoClicker;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Eco Clicker";
		config.width = 340;
        config.height = 460;
		new LwjglApplication(new EcoClicker(), config);
	}
}
