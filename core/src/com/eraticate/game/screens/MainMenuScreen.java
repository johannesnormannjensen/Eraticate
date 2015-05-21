package com.eraticate.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.eraticate.game.Eraticate;


public class MainMenuScreen implements Screen
{
    private final Eraticate game;
    private Batch batch;

    private Stage stage;
    private Table table = new Table();

    private Skin skin = new Skin(Gdx.files.internal("textures/mainmenu/menuSkin.json"),
            new TextureAtlas(Gdx.files.internal("textures/mainmenu/menuSkin.pack")));

    private Label title = new Label("game", skin);

    private TextButton buttonPlay = new TextButton("Play", skin),
            buttonQuit = new TextButton("Quit", skin);

    private Texture bgImg = new Texture(Gdx.files.internal("textures/mainmenu/bg.jpg"));


    public MainMenuScreen(Eraticate eraticate)
    {
        this.game = eraticate;
        this.batch = eraticate.getBatch();
        this.stage = new Stage(new StretchViewport(800, 480), eraticate.getBatch());
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(bgImg, 0, 0, 800, 480);
        batch.end();

        stage.act();
        stage.draw();

    }

    @Override
    public void resize(int width, int height)
    {
    }

    @Override
    public void show()
    {
        buttonPlay.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                game.setScreen(new GameScreen(game));
            }
        });
        buttonQuit.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                Gdx.app.exit();
            }
        });

        //The elements are displayed in the order you add them.
        //The first appear on top, the last at the bottom.
        table.add(title).padBottom(40).row();
        table.add(buttonPlay).size(150, 60).padBottom(20).row();
        table.add(buttonQuit).size(150, 60).padBottom(20).row();

        table.setFillParent(true);
        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide()
    {
        dispose();
    }

    @Override
    public void pause()
    {
    }

    @Override
    public void resume()
    {
    }

    @Override
    public void dispose()
    {
        stage.dispose();
        skin.dispose();
    }

}