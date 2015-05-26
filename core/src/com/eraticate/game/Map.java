package com.eraticate.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.eraticate.game.mapobjects.GrassField;
import com.eraticate.game.mapobjects.Rat;
import com.eraticate.game.mapobjects.RoadField;

import java.util.ArrayList;

/**
 * Created by Ferenc on 5/21/2015.
 */
public class Map
{
    private int fieldSize = 100;

    Drawable[][] fields;
    public Drawable[][] getFields()
    {
        return fields;
    }

    ArrayList<Rat> rats = new ArrayList<>();


    public int getFieldSize()
    {
        return fieldSize;
    }
    public void setFieldSize(int fieldSize)
    {
        this.fieldSize = fieldSize;
    }

    public Map(int width, int height)
    {
        fields = new Drawable[height][width];
    }

    public void Draw(Batch batch, OrthographicCamera camera)
    {
        for (int i = 0; i < fields.length; i++)
        {
            for (int j = 0; j < fields[i].length; j++)
            {
                fields[i][j].draw(batch, i * fieldSize, j * fieldSize, fieldSize, fieldSize);
            }
        }
        for (int i = 0; i < rats.size(); i++)
        {

        }
    }
    public void Default()
    {
        Texture grassTexture = new Texture(Gdx.files.internal("textures/map/grass/grass.png"));
        Texture roadTexture = new Texture(Gdx.files.internal("textures/map/road.png"));
        Texture ratTexture = new Texture(Gdx.files.internal("textures/map/road.png"));

        rats.add(new Rat(ratTexture, 1, 1));

        for (int i = 0; i < fields.length; i++)
        {
            for (int j = 0; j < fields[i].length; j++)
            {
                fields[i][j] = new GrassField(grassTexture);
            }
        }

        for (int i = 1; i < fields.length - 1; i++)
        {
            for (int j = 1; j < fields[i].length - 1; j++)
            {
                fields[i][j] = new RoadField(roadTexture);
            }
        }
        for (int i = 2; i < fields.length - 2; i++)
        {
            for (int j = 2; j < fields[i].length - 2; j++)
            {
                fields[i][j] = new GrassField(grassTexture);
            }
        }
    }
}
