package com.eraticate.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.eraticate.game.mapobjects.GrassField;
import com.eraticate.game.mapobjects.RoadField;

import java.util.ArrayList;

/**
 * Created by Ferenc on 5/21/2015.
 */
public class Map
{
    public ArrayList<Drawable>[][] getFields()
    {
        return fields;
    }

    ArrayList<Drawable>[][] fields;
    private int fieldSize = 100;
    private int translateX = 0;
    private int translateY = 0;

    public int getTranslateX()
    {
        return translateX;
    }
    public void setTranslateX(int translateX)
    {
        this.translateX = translateX;
    }
    public int getTranslateY()
    {
        return translateY;
    }
    public void setTranslateY(int translateY)
    {
        this.translateY = translateY;
    }
    public Map(int width, int height)
    {
        fields = new ArrayList[height][width];
    }

    public void Draw(Batch batch, OrthographicCamera camera)
    {
        for (int i = 0; i < fields.length; i++)
        {
            for (int j = 0; j < fields[i].length; j++)
            {
                for (int k = 0; k < fields[i][j].size(); k++)
                {
                    fields[i][j].get(k).draw(batch, translateX + i * fieldSize, translateY + j * fieldSize, fieldSize, fieldSize);
                }
            }
        }
    }
    public void Default()
    {
        for (int i = 0; i < fields.length; i++)
        {
            for (int j = 0; j < fields[i].length; j++)
            {
                fields[i][j] = new ArrayList<Drawable>();
                fields[i][j].add(new GrassField());
            }
        }

        for (int i = 1; i < fields.length - 1; i++)
        {
            for (int j = 1; j < fields[i].length - 1; j++)
            {
                fields[i][j].remove(0);
                fields[i][j].add(new RoadField());
            }
        }
        for (int i = 2; i < fields.length - 2; i++)
        {
            for (int j = 2; j < fields[i].length - 2; j++)
            {

                fields[i][j].remove(0);
                fields[i][j].add(new GrassField());
            }
        }
    }
}
