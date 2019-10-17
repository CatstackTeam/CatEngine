package ru.catstack.catengine.objects;

import com.badlogic.ashley.core.Entity;

public abstract class TweenBehavior {
    protected boolean isFinished = false;
    protected float endTime = 0f;
    protected float currentTime = 0f;

    public TweenBehavior(float endTime) {
        this.endTime = endTime;
    }

    public void tick(Entity entity, float delta) {
        if (!isFinished) {
            if (currentTime < endTime) {
                currentTime += delta;
            }
            if (currentTime > endTime) {
                isFinished = true;
                currentTime = endTime;
            }
            update(entity, delta);
        }
    }

    public abstract void update(Entity entity, float delta);

    public boolean isFinished() {
        return isFinished;
    }
}
