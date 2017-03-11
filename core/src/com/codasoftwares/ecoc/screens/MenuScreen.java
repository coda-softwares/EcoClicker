package com.codasoftwares.ecoc.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.codasoftwares.ecoc.EcoClicker;

/**
 * Created by jeffbustercase on 10/03/17.
 */
public class MenuScreen extends ScreenAdapter {
    private EcoClicker controller;
    private Stage stage;
    public MenuScreen(EcoClicker _controller) {
        super();
        this.controller = _controller;


        ScreenViewport screenViewport = new ScreenViewport();
        stage = new Stage(screenViewport);

        // Top Left Button
        Image gameButton = new Image(new Texture("badlogic.jpg"));
        gameButton.setSize( 60 , 60 );
        gameButton.setPosition( 20 , stage.getHeight() - 20 - gameButton.getHeight());

        // TODO: Impossible to get out of MenuScreen
        gameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                pause();
                controller.changeScreen("GameScreen");
            }
        });


        // Game Label
        // Create param
        FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param.size = 16;

        // Get font from assets
        BitmapFont sfMonoFont = EcoClicker.GameAssets.getFont("SFMono-Regular.otf", param);

        Label menuLabel = new Label("Menu",
                new Label.LabelStyle(sfMonoFont, Color.CYAN));

        menuLabel.setPosition(
                stage.getWidth()/2 - menuLabel.getWidth()/2,
                stage.getHeight() - (menuLabel.getHeight() * 2)
        );

        stage.addActor(gameButton);
        stage.addActor(menuLabel);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose(){
        super.dispose();
    }
}
