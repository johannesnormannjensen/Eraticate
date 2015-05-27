package com.eraticate.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.eraticate.game.Eraticate;
import com.eraticate.game.Map;
import com.eraticate.game.Sidemenu;
import com.sun.media.sound.EmergencySoundbank;

/**
 * Created by Ferenc on 5/21/2015.
 */
public class GameScreen extends RatScreen implements InputProcessor
{
    private final Eraticate game; //Instance of the game class so we are able to access its methods (setScreen primarily)
    private Batch batch; //The object handling the render
    OrthographicCamera camera; //To select a part of our map to look at
    float xMin, xMax, yMin, yMax; //Boundaries of the map
    Viewport viewport; //The image "taken" by the camera needs to be handled
    float aspectRatio;

    private Map map;
    private Sidemenu sidemenu;
    private int numberOfFieldsInLine = 6; //The size of what we see

    public GameScreen(Eraticate game)
    {
        this.game = game;
        batch = game.getBatch();
        camera = new OrthographicCamera();
        aspectRatio = (float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth();
        viewport = new FillViewport(Gdx.graphics.getWidth(), Gdx.graphics.getWidth() * aspectRatio, camera);
        viewport.apply();


        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);

//        camera.translate(camera.viewportWidth, camera.viewportHeight / 2, 0);
        Gdx.input.setInputProcessor(this);
    }
    @Override
    public void show()
    {
        map = new Map(15, 15);
        map.Default();
        map.setFieldSize((int) (viewport.getScreenWidth() * aspectRatio / numberOfFieldsInLine));

        calcCameraBoundaries();
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
        sidemenu.Draw(batch, new OrthographicCamera());
        batch.end();
    }
    @Override
    public void resize(int width, int height)
    {
        //Camera settings
        viewport.update(width, height);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);

        calcCameraBoundaries();
        //Texture controller
        map.setFieldSize(height / numberOfFieldsInLine);
    }
    private void calcCameraBoundaries()
    {
        xMin = camera.viewportWidth / 2;
        xMax = map.getFields()[0].length * map.getFieldSize() - camera.viewportWidth / 2;
        yMin = camera.viewportHeight / 2;
        yMax = map.getFields().length * map.getFieldSize() - camera.viewportHeight / 2;
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

    // Map movements
    private void zoomIn()
    {
        numberOfFieldsInLine--;
        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
    private void zoomOut()
    {
        numberOfFieldsInLine++;
        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    private void cameraMoveTo(float x, float y)
    {

        if (x < xMin) x = xMin;
        if (x > xMax) x = xMax;

        if (y < yMin) y = yMin;
        if (y > yMax) y = yMax;
        camera.position.set(x, y, 0);
    }

    @Override
    public boolean keyDown(int keycode)
    {
        if (keycode == Keys.PLUS)
        {
            zoomIn();
        }
        if (keycode == Keys.MINUS)
        {
            zoomOut();
        }

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
        cameraMoveTo(camera.position.x + lastPos.x - screenX, camera.position.y + screenY - lastPos.y);

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
