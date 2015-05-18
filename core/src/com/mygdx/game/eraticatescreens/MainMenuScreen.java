package com.mygdx.game.eraticatescreens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.Eraticate;

/**
 * Created by Ferenc on 5/18/2015.
 */
public class MainMenuScreen implements Screen
{

    final Eraticate game;

    OrthographicCamera camera;

    public MainMenuScreen(Eraticate game)
    {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }
    @Override
    public void show()
    {

    }
    @Override
    public void render(float delta)
    {

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
