package ru.catstack.catengine.assets;

import com.badlogic.gdx.assets.AssetManager;

public class AssetsManager {
    public static AssetManager manager = null;

    public static void init() {
        manager = new AssetManager();
    }

    public static void load() {
        Textures.load(manager);
    }

    public static void dispose() {
        manager.dispose();
        manager = null;
    }
}
