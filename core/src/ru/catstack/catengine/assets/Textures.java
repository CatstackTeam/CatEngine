package ru.catstack.catengine.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public enum Textures {
    BASIC("badlogic.jpg"),
    FAVORITE("favorite.png"),
    BUTTON1("Button1.png"),
    RBUTTON1("B1.png"),
    BUTTON2("Button2.png"),
    RBUTTON2("B2.png"),
    ;

    private String path;
    Textures(String path) {
        this.path = path;
    }

    public Texture get() {
        return AssetsManager.manager.get(path);
    }

    static void load(AssetManager manager) {
        for (Textures texture : Textures.values()) {
            manager.load(texture.path, Texture.class);
        }
    }
}
