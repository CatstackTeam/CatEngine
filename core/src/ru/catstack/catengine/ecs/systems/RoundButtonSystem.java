package ru.catstack.catengine.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import ru.catstack.catengine.ecs.CatMappers;
import ru.catstack.catengine.ecs.World;
import ru.catstack.catengine.ecs.components.RoundButtonComponent;
import ru.catstack.catengine.ecs.components.TextureComponent;
import ru.catstack.catengine.ecs.components.TransformComponent;

public class RoundButtonSystem extends IteratingSystem {
    public RoundButtonSystem() {
        super(Family.all(RoundButtonComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        RoundButtonComponent buttonComponent = CatMappers.roundButton.get(entity);
        TextureComponent textureComponent = CatMappers.texture.get(entity);
        TransformComponent transformComponent = CatMappers.transform.get(entity);

        Vector3 mPos = World.getCamera().unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

        float dst = Vector2.dst(mPos.x, mPos.y, transformComponent.position.x, transformComponent.position.y);

        if (Gdx.input.isTouched()) {
            if (dst <= buttonComponent.radius) {
                if (!buttonComponent.isClicked) {
                    buttonComponent.isClicked = true;
                    textureComponent.texture = buttonComponent.onClicked;
                }
            } else {
                buttonComponent.isClicked = false;
                textureComponent.texture = buttonComponent.released;
            }
        } else if (!Gdx.input.isTouched() && buttonComponent.isClicked) {
            if (dst <= buttonComponent.radius) {
                buttonComponent.isClicked = false;
                textureComponent.texture = buttonComponent.released;
                buttonComponent.onClick.run();
            }
        }
    }
}
