package ru.catstack.catengine.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import ru.catstack.catengine.ecs.CatMappers;
import ru.catstack.catengine.ecs.components.ParentComponent;
import ru.catstack.catengine.ecs.components.TransformComponent;

public class ParentSystem extends IteratingSystem
{
    public ParentSystem() {
        super(Family.all(ParentComponent.class, TransformComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TransformComponent transform = CatMappers.transform.get(entity);
        ParentComponent parentComponent = CatMappers.parent.get(entity);

        Entity parent = parentComponent.parent;

        if (parent == null) {
            transform.worldPosition.set(transform.position);
            transform.worldRotation = transform.rotation;
        } else {
            TransformComponent parentTransform = CatMappers.transform.get(parent);

            transform.worldRotation = parentTransform.worldRotation + transform.rotation;

            transform.worldPosition.x = parentTransform.worldPosition.x + transform.position.x;
            transform.worldPosition.y = parentTransform.worldPosition.y + transform.position.y;
            transform.worldPosition.z = transform.position.z;

            float sin = (float) Math.sin(Math.toRadians(parentTransform.worldRotation));
            float cos = (float) Math.cos(Math.toRadians(parentTransform.worldRotation));

            float x = transform.worldPosition.x;
            float y = transform.worldPosition.y;
            float x0 = parentTransform.worldPosition.x;
            float y0 = parentTransform.worldPosition.y;

            transform.worldPosition.x = x0 + (x - x0) * cos - (y - y0) * sin;
            transform.worldPosition.y = y0 + (y - y0) * cos + (x - x0) * sin;
        }
    }
}
