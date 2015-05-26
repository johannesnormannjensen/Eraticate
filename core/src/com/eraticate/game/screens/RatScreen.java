package com.eraticate.game.screens;

import com.badlogic.gdx.Screen;

/**
 * Created by Ferenc on 5/18/2015.
 */
public abstract class RatScreen implements Screen
{

    public abstract void update(float delta);
    public abstract void renderScreen(float delta);

    @Override
    public final void render(float delta)
    {
        update(delta);
        renderScreen(delta);
    }
}
