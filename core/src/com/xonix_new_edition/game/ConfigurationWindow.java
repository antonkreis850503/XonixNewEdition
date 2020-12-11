package com.xonix_new_edition.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class ConfigurationWindow implements Screen {
    private Stage stage;
    private XonixNewEdition xonixNewEdition;
    private Button startButton;
    private Button backButton;
    private Button plusButton1;
    private Button minusButton1;
    private Button plusButton2;
    private Button minusButton2;
    private SpriteBatch batch;
    private Texture background;
    private OrthographicCamera camera;
    private BitmapFont textFont;
    private String timeout;
    private String areaToWin;

    ConfigurationWindow(final XonixNewEdition xonixNewEdition, final String nicknameBlue, final String nicknameRed){
        this.xonixNewEdition = xonixNewEdition;
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        batch = new SpriteBatch();
        background = new Texture("configure_background.png");

        startButton = new Button(xonixNewEdition, "start_button.png",
                "rect_button_down.png", 1000, 200);
        backButton = new Button(xonixNewEdition, "back_button.png",
                "rect_button_down.png", 1000, 100);
        plusButton1 = new Button(xonixNewEdition, "plus_button.png",
                "square_button_down.png", 150, 360);
        minusButton1 = new Button(xonixNewEdition, "minus_button.png",
                "square_button_down.png", 500, 360);
        plusButton2 = new Button(xonixNewEdition, "plus_button.png",
                "square_button_down.png", 150, 460);
        minusButton2 = new Button(xonixNewEdition, "minus_button.png",
                "square_button_down.png", 500, 460);

        startButton.textButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                xonixNewEdition.setScreen(new GameWindow(xonixNewEdition, timeout, areaToWin, nicknameBlue, nicknameRed));
            }
        });
        stage.addActor(startButton.textButton);

        backButton.textButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                xonixNewEdition.setScreen(new MainWindow(xonixNewEdition, nicknameBlue, nicknameRed));
            }
        });
        stage.addActor(backButton.textButton);

        plusButton1.textButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                switch (timeout){
                    case "2 minutes": timeout = "3 minutes"; break;
                    case "3 minutes": timeout = "4 minutes"; break;
                    case "4 minutes": timeout = "5 minutes"; break;
                }
            }
        });
        stage.addActor(plusButton1.textButton);

        minusButton1.textButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                switch (timeout){
                    case "5 minutes": timeout = "4 minutes"; break;
                    case "4 minutes": timeout = "3 minutes"; break;
                    case "3 minutes": timeout = "2 minutes"; break;
                }
            }
        });
        stage.addActor(minusButton1.textButton);

        plusButton2.textButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                switch (areaToWin){
                    case "20 %": areaToWin = "30 %"; break;
                    case "30 %": areaToWin = "40 %"; break;
                    case "40 %": areaToWin = "50 %"; break;
                    case "50 %": areaToWin = "60 %"; break;
                }
            }
        });
        stage.addActor(plusButton2.textButton);

        minusButton2.textButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                switch (areaToWin){
                    case "60 %": areaToWin = "50 %"; break;
                    case "50 %": areaToWin = "40 %"; break;
                    case "40 %": areaToWin = "30 %"; break;
                    case "30 %": areaToWin = "20 %"; break;
                }
            }
        });
        stage.addActor(minusButton2.textButton);

        timeout = "2 minutes";
        areaToWin = "20 %";
        textFont = new BitmapFont(Gdx.files.internal("font2.fnt"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background, 0, 0);
        textFont.setColor(Color.BLACK);
        textFont.draw(batch, timeout, 280, 415);
        textFont.draw(batch, areaToWin, 325, 515);
        batch.end();

        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {

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

    @Override
    public void dispose() {
        batch.dispose();
    }
}