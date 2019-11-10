package ru.catstack.catengine.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import ru.catstack.catengine.ecs.CatMappers;
import ru.catstack.catengine.ecs.World;
import ru.catstack.catengine.ecs.components.BoundsComponent;
import ru.catstack.catengine.ecs.components.ButtonComponent;
import ru.catstack.catengine.ecs.components.TextureComponent;

public class ButtonSystem extends IteratingSystem {
    public ButtonSystem() {
        super(Family.all(ButtonComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        ButtonComponent buttonComponent = CatMappers.button.get(entity);
        TextureComponent textureComponent = CatMappers.texture.get(entity);
        BoundsComponent boundsComponent = CatMappers.bounds.get(entity);

        Rectangle bounds = boundsComponent.bounds;
        Vector3 mPos = World.getCamera().unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

        if (Gdx.input.isTouched()) {
            if (bounds.contains(new Vector2(mPos.x, mPos.y))) {
                if (!buttonComponent.isClicked) {
                    buttonComponent.isClicked = true;
                    textureComponent.texture = buttonComponent.onClicked;
                }
            } else {
                buttonComponent.isClicked = false;
                textureComponent.texture = buttonComponent.released;
            }
        } else if (!Gdx.input.isTouched() && buttonComponent.isClicked) {
            if (bounds.contains(new Vector2(mPos.x, mPos.y))) {
                buttonComponent.isClicked = false;
                textureComponent.texture = buttonComponent.released;
                buttonComponent.onClick.run();
            }
        }
    }
}
