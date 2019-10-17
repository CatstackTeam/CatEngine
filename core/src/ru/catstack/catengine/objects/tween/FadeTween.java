package ru.catstack.catengine.objects.tween;

import com.badlogic.ashley.core.Entity;
import ru.catstack.catengine.ecs.CatMappers;
import ru.catstack.catengine.ecs.components.TextureComponent;
import ru.catstack.catengine.objects.TweenBehavior;

public class FadeTween extends TweenBehavior {
    private boolean fromStart;

    public FadeTween(boolean fromStart, float endTime) {
        super(endTime);
        this.fromStart = fromStart;
    }

    @Override
    public void update(Entity entity, float delta) {
        TextureComponent textureComponent = CatMappers.texture.get(entity);
        if (fromStart) {
            textureComponent.alpha = currentTime / endTime;
        } else {
            textureComponent.alpha = 1 - currentTime / endTime;
        }
    }
}
