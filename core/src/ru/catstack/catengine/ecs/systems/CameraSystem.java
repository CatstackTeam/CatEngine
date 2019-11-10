package ru.catstack.catengine.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import ru.catstack.catengine.ecs.CatMappers;
import ru.catstack.catengine.ecs.components.CameraComponent;
import ru.catstack.catengine.ecs.components.TransformComponent;

public class CameraSystem extends IteratingSystem {
    public CameraSystem() {
        super(Family.all(CameraComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        CameraComponent cameraComponent = CatMappers.camera.get(entity);
        TransformComponent transformComponent = CatMappers.transform.get(entity);

        cameraComponent.camera.position.set(transformComponent.worldPosition);
        cameraComponent.camera.update();
    }
}
