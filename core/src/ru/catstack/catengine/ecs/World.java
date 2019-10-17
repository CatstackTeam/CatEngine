package ru.catstack.catengine.ecs;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class World {
    public static Engine engine;

    public static void init(SpriteBatch batch) {
        engine = new Engine();
        SystemManager.addSystemsToEngine(engine, batch);
    }

    public static void dispose() {
        engine.removeAllEntities();

        for (EntitySystem system : engine.getSystems()) {
            engine.removeSystem(system);
        }
    }

    public static Entity createEntity() {
        Entity entity = new Entity();
        engine.addEntity(entity);
        return entity;
    }
}
