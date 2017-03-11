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
public class GameScreen extends ScreenAdapter {
    public EcoClicker controller;
    private Stage stage;
    public GameScreen(EcoClicker _controller) {
        super();

        this.controller = _controller;

        ScreenViewport screenViewport = new ScreenViewport();
        stage = new Stage(screenViewport);
        /*
         * TODO: create thread task to at each second/level generate a obj
         * TODO: No mais Simples, os objetos aparecem na tela
         * TODO: Mas a meta é que eles apareçam como se fossem uma pedra jogada em um rio
         * TODO: quicando na água, enquanto é vista por cima
         */

        // Localizado do lado esquerdo superior da tela.
        Image menuButton = new Image(new Texture("badlogic.jpg"));

        menuButton.setSize( 60 , 60 ); // Bem pequeno

        // TODO: Utilizar Table-Rows
        menuButton.setPosition(20, stage.getHeight()-20-menuButton.getHeight());

        menuButton.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {

                super.clicked(event, x, y);
                pause();
                controller.changeScreen("MenuScreen");
            }

        });


        // Game Label
        // Create param
        FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param.size = 16;

        // Get font from assets
        BitmapFont sfMonoFont = EcoClicker.GameAssets.getFont("SFMono-Regular.otf", param);

        Label gameLabel = new Label("EcoClicker",
                new Label.LabelStyle(sfMonoFont, Color.CYAN));

        gameLabel.setPosition(
                stage.getWidth()/2 - gameLabel.getWidth()/2,
                stage.getHeight() - (gameLabel.getHeight() * 2)
        );

        stage.addActor(menuButton);
        stage.addActor(gameLabel);

        Gdx.input.setInputProcessor(stage);
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
    public void dispose() {
        super.dispose();
        stage.dispose();
    }
}
