package com.eraticate.game.mapobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 * Created by Ferenc on 5/21/2015.
 */
public class RoadField implements Drawable
{
    public RoadField(Texture texture)
    {
        this.texture = texture;
    }
    Texture texture;
    @Override
    public void draw(Batch batch, float x, float y, float width, float height)
    {
        batch.draw(texture, x, y, width, height);
    }
    @Override
    public float getLeftWidth()
    {
        return 0;
    }
    @Override
    public void setLeftWidth(float leftWidth)
    {

    }
    @Override
    public float getRightWidth()
    {
        return 0;
    }
    @Override
    public void setRightWidth(float rightWidth)
    {

    }
    @Override
    public float getTopHeight()
    {
        return 0;
    }
    @Override
    public void setTopHeight(float topHeight)
    {

    }
    @Override
    public float getBottomHeight()
    {
        return 0;
    }
    @Override
    public void setBottomHeight(float bottomHeight)
    {

    }
    @Override
    public float getMinWidth()
    {
        return 0;
    }
    @Override
    public void setMinWidth(float minWidth)
    {

    }
    @Override
    public float getMinHeight()
    {
        return 0;
    }
    @Override
    public void setMinHeight(float minHeight)
    {

    }
}
