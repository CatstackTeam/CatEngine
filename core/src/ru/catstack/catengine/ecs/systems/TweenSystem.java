package ru.catstack.catengine.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import ru.catstack.catengine.ecs.CatMappers;
import ru.catstack.catengine.ecs.components.TweenComponent;
import ru.catstack.catengine.objects.TweenBehavior;

public class TweenSystem extends IteratingSystem {
    public TweenSystem() {
        super(Family.all(TweenComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TweenComponent tweenComponent = CatMappers.tween.get(entity);

        boolean isAllRemoved = false;
        while (!isAllRemoved) {
            isAllRemoved = true;
            for (TweenBehavior tween : tweenComponent.tweens) {
                if (tween.isFinished()) {
                    tweenComponent.tweens.remove(tween);
                    isAllRemoved = false;
                    break;
                }
            }
        }

        for (TweenBehavior tween : tweenComponent.tweens) {
            tween.tick(entity, deltaTime);
        }
    }
}
