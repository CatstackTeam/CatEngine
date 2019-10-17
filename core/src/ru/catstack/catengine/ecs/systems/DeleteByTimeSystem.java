package ru.catstack.catengine.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import ru.catstack.catengine.ecs.CatMappers;
import ru.catstack.catengine.ecs.World;
import ru.catstack.catengine.ecs.components.DeleteByTimeComponent;
import ru.catstack.catengine.ecs.components.ParentComponent;

public class DeleteByTimeSystem extends IteratingSystem {
    public DeleteByTimeSystem() {
        super(Family.all(DeleteByTimeComponent.class, ParentComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        DeleteByTimeComponent deleteByTimeComponent = CatMappers.deleteByTime.get(entity);

        deleteByTimeComponent.time += deltaTime;
        if (deleteByTimeComponent.time >= deleteByTimeComponent.deleteTime) {
            deleteAllChildren(entity);
            World.engine.removeEntity(entity);
        }
    }

    private void deleteAllChildren(Entity entity) {
        ParentComponent parentComponent = CatMappers.parent.get(entity);
        for (Entity child : parentComponent.children) {
            deleteAllChildren(child);
        }
        World.engine.removeEntity(entity);
    }
}
