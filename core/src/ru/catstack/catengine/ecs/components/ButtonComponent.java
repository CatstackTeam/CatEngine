package ru.catstack.catengine.ecs.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ButtonComponent implements Component {
    public TextureRegion onClicked;
    public TextureRegion released;
    public Runnable onClick;
    public boolean isClicked;

    public ButtonComponent(TextureRegion releasedTexture, TextureRegion onClickedTexture, Runnable onClick) {
        this.onClicked = onClickedTexture;
        this.released = releasedTexture;
        this.onClick = onClick;
    }

    public ButtonComponent(Texture releasedTexture, Texture onClickedTexture, Runnable onClick) {
        this.onClicked = new TextureRegion(onClickedTexture);
        this.released = new TextureRegion(releasedTexture);
        this.onClick = onClick;
    }
}
