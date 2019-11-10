package ru.catstack.catengine.ecs.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraComponent implements Component {
    public OrthographicCamera camera = null;

    public CameraComponent(OrthographicCamera camera) {
        this.camera = camera;
    }
}
