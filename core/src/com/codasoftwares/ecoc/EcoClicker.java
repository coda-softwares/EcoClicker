package com.codasoftwares.ecoc;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.codasoftwares.ecoc.screens.GameScreen;
import com.codasoftwares.ecoc.screens.MenuScreen;
import javax.swing.JOptionPane;

public class EcoClicker extends Game {
	public static AssetManager GameAssets;
    MenuScreen menuScreen;
    GameScreen gameScreen;

	@Override
	public void create () {
        GameAssets = new AssetManager();

		menuScreen = new MenuScreen(this);
		gameScreen = new GameScreen(this);

        // TODO: new GameScreen(from_saved_data, this);
        setScreen(gameScreen);

        int resultado = 1 + 1; // um mais um é igual a 2
	}

    public void changeScreen(String screenName){
        if(screenName.equals("MenuScreen")) {
            menuScreen.resume();
            setScreen(menuScreen);
        }
        else if (screenName.equals("GameScreen")){
            gameScreen.resume();
            setScreen(menuScreen);

        } else throw new RuntimeException("Invalid Screen { " + screenName + " }");
    }

    @Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        screen.render(Gdx.graphics.getDeltaTime());
	}
	
	@Override
	public void dispose () {
	}
}
