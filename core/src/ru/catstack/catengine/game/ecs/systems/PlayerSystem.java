package ru.catstack.catengine.game.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import ru.catstack.catengine.ecs.CatMappers;
import ru.catstack.catengine.ecs.components.DeleteByTimeComponent;
import ru.catstack.catengine.ecs.components.TransformComponent;
import ru.catstack.catengine.game.ecs.components.PlayerComponent;

public class PlayerSystem extends IteratingSystem {

    public PlayerSystem() {
        super(Family.all(PlayerComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TransformComponent transformComponent = CatMappers.transform.get(entity);
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            transformComponent.position.x -= deltaTime * 200;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            transformComponent.position.x += deltaTime * 200;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            transformComponent.position.y += deltaTime * 200;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            transformComponent.position.y -= deltaTime * 200;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            transformComponent.rotation += deltaTime * 50;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            transformComponent.rotation -= deltaTime * 50;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            transformComponent.rotation = 0;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.F)) {
            entity.add(new DeleteByTimeComponent(5));
        }
    }
}
