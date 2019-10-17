package ru.catstack.catengine.ecs.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureComponent implements Component {
    public TextureRegion texture = null;
    public float alpha = 1f;

    public TextureComponent(Texture texture) {
        if (texture != null) {
            this.texture = new TextureRegion(texture);
        }
    }
}
