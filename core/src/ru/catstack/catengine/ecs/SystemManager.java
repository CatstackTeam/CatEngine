package ru.catstack.catengine.ecs;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.catstack.catengine.ecs.systems.*;
import ru.catstack.catengine.game.ecs.systems.PlayerSystem;

class SystemManager {
    static void addSystemsToEngine(Engine engine, SpriteBatch batch) {
        engine.addSystem(new PlayerSystem()); //not necessary
        engine.addSystem(new ParentSystem());
        engine.addSystem(new BoundsToTextureSystem());
        engine.addSystem(new DeleteByTimeSystem());
        engine.addSystem(new TweenSystem());
        engine.addSystem(new ButtonSystem());
        engine.addSystem(new RoundButtonSystem());
        engine.addSystem(new AnimationSystem());
        engine.addSystem(new CameraSystem());
        engine.addSystem(new RenderingSystem(batch));
    }
}
