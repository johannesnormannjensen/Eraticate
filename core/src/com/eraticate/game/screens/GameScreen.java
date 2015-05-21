package com.eraticate.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.eraticate.game.Eraticate;
import com.eraticate.game.Map;

/**
 * Created by Ferenc on 5/21/2015.
 */
public class GameScreen implements RatScreen
{
    private final Eraticate game;
    private Batch batch;
    private Map map;
    public GameScreen(Eraticate game)
    {
        this.game = game;
        batch= game.getBatch();
    }
    @Override
    public void show()
    {
        map = new Map(5, 5);
        map.Default();
    }

    @Override
    public void update(float delta)
    {

    }
    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0, 0.5f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        map.Draw(batch, new OrthographicCamera());
        batch.end();
    }
    @Override
    public void resize(int width, int height)
    {

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
    public void hide()
    {

    }
    @Override
    public void dispose()
    {

    }
}
