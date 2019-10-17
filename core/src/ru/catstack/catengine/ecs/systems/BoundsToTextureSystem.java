package ru.catstack.catengine.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector3;
import ru.catstack.catengine.ecs.CatMappers;
import ru.catstack.catengine.ecs.components.BoundsComponent;
import ru.catstack.catengine.ecs.components.BoundsToTextureComponent;
import ru.catstack.catengine.ecs.components.TextureComponent;
import ru.catstack.catengine.ecs.components.TransformComponent;

public class BoundsToTextureSystem extends IteratingSystem {
    public BoundsToTextureSystem() {
        super(Family.all(BoundsToTextureComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TextureComponent texture = CatMappers.texture.get(entity);
        BoundsComponent bounds = CatMappers.bounds.get(entity);
        TransformComponent transform = CatMappers.transform.get(entity);

        Vector3 pos = transform.worldPosition;
        int width = (int) (texture.texture.getRegionWidth() * transform.scale.x);
        int height = (int) (texture.texture.getRegionHeight() * transform.scale.y);

        bounds.bounds.set((int) (pos.x - width / 2), (int) (pos.y - height / 2), width, height);
    }
}
