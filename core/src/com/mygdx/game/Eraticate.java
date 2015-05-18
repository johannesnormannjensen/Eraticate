package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Eraticate extends Game
{
	SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
	}

    public void dispose() {
        batch.dispose();
    }
}
