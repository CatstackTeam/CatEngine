package ru.catstack.catengine.screens;

import com.badlogic.gdx.Screen;
import ru.catstack.catengine.MyGdxGame;
import ru.catstack.catengine.ecs.World;
import ru.catstack.catengine.game.MainGame;


public class GameScreen implements Screen {

    private MyGdxGame game;
    private MainGame mainGame = new MainGame();

    public GameScreen(MyGdxGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        World.init(game.batch);

        mainGame.create(game.batch);
    }

    @Override
    public void render(float delta) {
        World.engine.update(delta);

        mainGame.update(delta);
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
        World.dispose();
    }
}
