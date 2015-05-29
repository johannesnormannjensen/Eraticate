package com.eraticate.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Created by Johannes on 27-05-2015.
 */
public class Sidemenu
{
    private Skin skin = new Skin(Gdx.files.internal("textures/sidemenu/gameSkin.json"),
            new TextureAtlas(Gdx.files.internal("textures/sidemenu/gameSkin.pack")));

    private ImageButton bombButton = new ImageButton(skin, "bomb");
    private ImageButton spikesButton = new ImageButton(skin, "spikes");
    private ImageButton zoomInButton = new ImageButton(skin, "zoomIn");
    private ImageButton zoomOutButton = new ImageButton(skin, "zoomOut");

    private Table table = new Table(skin);

    private Label title = new Label("Eraticate", skin);

    private Stage stage;

    public Sidemenu()
    {
        this.stage = new Stage(new StretchViewport(200, 480));

        table.setColor(Color.BLUE);
//        table.add(buttonMusic).expand().right().top().row();
        table.add(title).padBottom(40).row();
        table.add(bombButton).size(150, 60).padBottom(20).row();
        table.add(spikesButton).size(150, 60).padBottom(20).row();
        table.add(zoomInButton).size(150, 60).padBottom(20).row();

        table.setFillParent(true);
        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);

    }

    public void Draw(Batch batch, OrthographicCamera camera)
    {
        stage.act();
        stage.draw();
    }
}
