package ru.catstack.catengine.objects.tween;

import com.badlogic.ashley.core.Entity;
import ru.catstack.catengine.ecs.CatMappers;
import ru.catstack.catengine.ecs.components.TransformComponent;
import ru.catstack.catengine.objects.TweenBehavior;

public class RotationTween extends TweenBehavior {

    private float startAngle;
    private float endAngle;
    private float deltaAngle;
    private boolean isInit = false;

    public RotationTween(float rotationAngle, float endTime) {
        super(endTime);
        endAngle = rotationAngle;
    }

    @Override
    public void update(Entity entity, float delta) {
        TransformComponent transformComponent = CatMappers.transform.get(entity);
        if (!isInit) {
            isInit = true;
            startAngle = transformComponent.worldRotation;
            deltaAngle = Math.abs(startAngle - endAngle);
        }

        float k = currentTime / endTime;

        float rotateFromStart = deltaAngle * k;

        if (startAngle > endAngle) rotateFromStart *= -1;

        if (!isFinished) {
            transformComponent.rotation = startAngle + rotateFromStart;
        } else {
            transformComponent.rotation = endAngle;
        }
    }
}
