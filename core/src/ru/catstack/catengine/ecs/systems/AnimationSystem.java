package ru.catstack.catengine.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import ru.catstack.catengine.ecs.CatMappers;
import ru.catstack.catengine.ecs.components.AnimationComponent;
import ru.catstack.catengine.ecs.components.TextureComponent;

public class AnimationSystem extends IteratingSystem {

    public AnimationSystem() {
        super(Family.all(AnimationComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        AnimationComponent animationComponent = CatMappers.animation.get(entity);
        TextureComponent textureComponent = CatMappers.texture.get(entity);

        animationComponent.animation.update(deltaTime);

        textureComponent.texture = animationComponent.animation.getCurrentFrameRegion();
    }
}
