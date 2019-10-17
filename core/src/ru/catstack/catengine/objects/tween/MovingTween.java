package ru.catstack.catengine.objects.tween;

import com.badlogic.ashley.core.Entity;
import ru.catstack.catengine.ecs.CatMappers;
import ru.catstack.catengine.ecs.components.TransformComponent;
import ru.catstack.catengine.objects.TweenBehavior;

public class MovingTween extends TweenBehavior {
    private float startX, startY;
    private float dx, dy;
    private float endX, endY;
    private boolean isInit = false;
    public MovingTween(float x, float y, float endTime) {
        super(endTime);
        endX = x;
        endY = y;
    }

    @Override
    public void update(Entity entity, float delta) {
        TransformComponent transformComponent = CatMappers.transform.get(entity);
        if (!isInit) {
            isInit = true;
            startX = transformComponent.worldPosition.x;
            startY = transformComponent.worldPosition.y;
            dx = Math.abs(startX - endX);
            dy = Math.abs(startY - endY);
        }

        float k = currentTime / endTime;

        float moveByXFromStart = dx * k;
        float moveByYFromStart = dy * k;

        if (startX > endX) moveByXFromStart *= -1;
        if (startY > endY) moveByYFromStart *= -1;

        if (!isFinished) {
            transformComponent.position.x = startX + moveByXFromStart;
            transformComponent.position.y = startY + moveByYFromStart;
        } else {
            transformComponent.position.x = endX;
            transformComponent.position.y = endY;
        }
    }
}
