package ru.catstack.catengine.ecs;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.catstack.catengine.settings.Core;

public class World {
    public static Engine engine;
    private static OrthographicCamera camera;
    private static Entity cameraEntity;

    public static void init(SpriteBatch batch) {
        engine = new Engine();
        camera = new OrthographicCamera(Core.GAME_WIDTH, Core.GAME_HEIGHT);
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

    public static void setCamera(Entity entity) {
        cameraEntity = entity;
        camera = CatMappers.camera.get(entity).camera;
    }

    public static OrthographicCamera getCamera() {
        return camera;
    }

    public static Entity getCameraEntity() {
        return cameraEntity;
    }
}
