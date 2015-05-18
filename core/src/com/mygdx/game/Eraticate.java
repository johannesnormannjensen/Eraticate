package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.eraticatescreens.MainMenuScreen;

public class Eraticate extends Game
{
	SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
	}

    public void dispose() {
        batch.dispose();
    }
}
