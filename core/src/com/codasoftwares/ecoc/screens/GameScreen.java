package com.codasoftwares.ecoc.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.codasoftwares.ecoc.EcoClicker;

/**
 * Created by jeffbustercase on 10/03/17.
 */
public class GameScreen implements Screen {
    private Stage stage;
    private Array<Image> clickableObjects;
    private float timer = 0f;
    private float waitTime = 1.5f; // Tempo de espera para um objeto aparecer na tela
    @Override
    public void show() {

        ScreenViewport screenViewport = new ScreenViewport();
        stage = new Stage(screenViewport);

        /*
         * TODO: create thread task to at each second/level generate a obj ou...
         * TODO: Na verdade, não irá precisar de tasks
         * TODO: No mais Simples, os objetos aparecem na tela
         * TODO: Mas a meta é que eles apareçam como se fossem uma pedra jogada em um rio
         * TODO: quicando na água, enquanto é vista por cima
         */
        clickableObjects = new Array<Image>();



        // Localizado do lado esquerdo superior da tela.
        Image menuButton = new Image(new Texture("badlogic.jpg"));

        menuButton.setSize( 60 , 60 ); // Bem pequeno

        menuButton.setPosition(20, stage.getHeight()-20-menuButton.getHeight());

        menuButton.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                //Leia a documentacao
                EcoClicker.getInstance().changeScreen("MenuScreen");
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
    public void render(float delta) {
        update(delta);

        stage.act();
        stage.draw();
    }
    private void update(float delta){
        timer += delta;
        for(Image obj : clickableObjects){
            /*
             * TODO: Por enquanto só Mover. Depois utilizar animação mas elaborada
             * com um efeito do objeto sendo jogado no chão
             *
             * TODO( No geral ): Mover em direção a uma parte do centro até parar
             */


        }
        if( timer%waitTime == 0){
            Image obj = new Image(new Texture("badlogic.jpg"));
            obj.setSize(obj.getWidth()/2.5f, obj.getHeight()/2.5f);
            /* Objeto é jogado vindo de 4 possiveis direções
             * top left right e bottom
             * com variações [random(direction), random(pos(x|y))]
             * dentro de um contexto de que
             * top: obj.y >= {ScreenHeight}+obj.getHeight()
             * bottom: obj.y <= -obj.getHeight()
             * left: obj.x <= -obj.getWidth()
             * right: obj.x >= {ScreenWidth}+obj.geWidth()
             *
             * Posição Inicial:
             */
            switch ((int)Math.floor(Math.random()*4)){
                case 3://right
                    obj.setX( stage.getWidth()+obj.getWidth() );
                    obj.setY( (float)Math.floor( Math.random()*stage.getHeight() ) );
                    break;
                case 2://left
                    obj.setX( -obj.getWidth() );
                    obj.setY( (float)Math.floor( Math.random()*stage.getHeight() ) );
                    break;
                case 1://top
                    obj.setX( (float)Math.floor( Math.random()*stage.getWidth() ) );
                    obj.setY( stage.getHeight()+obj.getHeight() );
                default://bottom - 0
                    obj.setX( (float)Math.floor( Math.random()*stage.getWidth() ) );
                    obj.setY( -obj.getHeight() );
            }
            clickableObjects.add(obj);
            stage.addActor(obj);
        }
    }
    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
}
