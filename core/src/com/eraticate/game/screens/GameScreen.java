package com.eraticate.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.eraticate.game.Eraticate;
import com.eraticate.game.Map;

/**
 * Created by Ferenc on 5/21/2015.
 */
public class GameScreen extends RatScreen implements InputProcessor
{
    private final Eraticate game;
    private Batch batch;
    private Map map;
    OrthographicCamera camera;
    public GameScreen(Eraticate game)
    {
        this.game = game;
        batch = game.getBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.translate(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 0);
        Gdx.input.setInputProcessor(this);
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
        camera.update();
    }
    @Override
    public void renderScreen(float delta)
    {
        Gdx.gl.glClearColor(0, 0.5f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.setProjectionMatrix(camera.combined);
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

    @Override
    public boolean keyDown(int keycode)
    {

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        return false;
    }
    @Override
    public boolean keyUp(int keycode)
    {
        return false;
    }
    @Override
    public boolean keyTyped(char character)
    {
        return false;
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        lastPos.set(screenX, screenY);
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        return false;
    }
    Vector2 lastPos = new Vector2();
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        camera.translate(lastPos.x - screenX, screenY - lastPos.y, 0);
        lastPos.set(screenX, screenY);
        return false;
    }
    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        return false;
    }
    @Override
    public boolean scrolled(int amount)
    {
        return false;
    }
}
