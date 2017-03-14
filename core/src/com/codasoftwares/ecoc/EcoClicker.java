package com.codasoftwares.ecoc;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.codasoftwares.ecoc.screens.GameScreen;
import com.codasoftwares.ecoc.screens.MenuScreen;

public class EcoClicker extends Game {
	public static AssetManager GameAssets;
	private static EcoClicker instance;
    private MenuScreen menuScreen;
    private GameScreen gameScreen;

	@Override
	public void create () {
	    instance = this;
        GameAssets = new AssetManager();

		menuScreen = new MenuScreen();
		gameScreen = new GameScreen();

        // TODO: Carregar ultimo estado - sqlite ou server
        setScreen(gameScreen);
	}

    public void changeScreen(String screenName){
        if(screenName.equalsIgnoreCase("MenuScreen")) {
            // Chama o metodo Show <- ( pode apagar se quiser )
            setScreen(menuScreen);
        }
        else if (screenName.equalsIgnoreCase("GameScreen")){
            setScreen(gameScreen);
        } else
            throw new RuntimeException("Invalid Screen { " + screenName + " }");
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

	public static EcoClicker getInstance() {
        if (instance == null) {
            instance = new EcoClicker();
        }
        return instance;
    }
}
