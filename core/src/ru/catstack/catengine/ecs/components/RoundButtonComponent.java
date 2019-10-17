package ru.catstack.catengine.ecs.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class RoundButtonComponent implements Component {
    public TextureRegion onClicked;
    public TextureRegion released;
    public Runnable onClick;
    public boolean isClicked;
    public float radius = 0;

    public RoundButtonComponent(TextureRegion releasedTexture, TextureRegion onClickedTexture, Runnable onClick, float radius) {
        this.onClicked = onClickedTexture;
        this.released = releasedTexture;
        this.onClick = onClick;
        this.radius = radius;
    }

    public RoundButtonComponent(Texture releasedTexture, Texture onClickedTexture, Runnable onClick, float radius) {
        this.onClicked = new TextureRegion(onClickedTexture);
        this.released = new TextureRegion(releasedTexture);
        this.onClick = onClick;
        this.radius = radius;
    }
}
