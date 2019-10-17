package ru.catstack.catengine.ecs;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.catstack.catengine.ecs.systems.*;
import ru.catstack.catengine.game.ecs.systems.PlayerSystem;
import ru.catstack.catengine.settings.Core;

class SystemManager {
    static void addSystemsToEngine(Engine engine, SpriteBatch batch) {
        engine.addSystem(new PlayerSystem()); //not necessary

        OrthographicCamera camera = new OrthographicCamera(Core.GAME_WIDTH, Core.GAME_HEIGHT);

        engine.addSystem(new ParentSystem());
        engine.addSystem(new BoundsToTextureSystem());
        engine.addSystem(new DeleteByTimeSystem());
        engine.addSystem(new TweenSystem());
        engine.addSystem(new ButtonSystem(camera));
        engine.addSystem(new RoundButtonSystem(camera));
        engine.addSystem(new AnimationSystem());
        engine.addSystem(new RenderingSystem(batch, camera));
    }
}
