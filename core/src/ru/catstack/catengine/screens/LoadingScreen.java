package ru.catstack.catengine.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import ru.catstack.catengine.MyGdxGame;
import ru.catstack.catengine.assets.AssetsManager;

public class LoadingScreen implements Screen {

    private MyGdxGame game;

    public LoadingScreen(MyGdxGame game) {
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        AssetManager manager = AssetsManager.manager;
        if (manager.update()) {
            manager.finishLoading();
            game.setScreen(new GameScreen(game));
        }

        System.out.println(manager.getProgress());
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
