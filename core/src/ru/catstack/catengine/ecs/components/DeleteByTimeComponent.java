package ru.catstack.catengine.ecs.components;

import com.badlogic.ashley.core.Component;

public class DeleteByTimeComponent implements Component {
    public float deleteTime;
    public float time = 0f;

    public DeleteByTimeComponent(float deleteTime) {
        this.deleteTime = deleteTime;
    }
}
