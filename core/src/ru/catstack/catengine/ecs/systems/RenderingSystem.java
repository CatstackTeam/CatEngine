package ru.catstack.catengine.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import ru.catstack.catengine.ecs.CatMappers;
import ru.catstack.catengine.ecs.components.TextureComponent;
import ru.catstack.catengine.ecs.components.TransformComponent;

import java.util.Comparator;

public class RenderingSystem extends IteratingSystem {

    private SpriteBatch batch;
    private OrthographicCamera camera;

    private Array<Entity> renderQueue;
    private Comparator<Entity> comparator;

    public RenderingSystem(SpriteBatch batch, OrthographicCamera camera) {
        super(Family.all(TransformComponent.class, TextureComponent.class).get());

        this.batch = batch;
        this.camera = camera;

        renderQueue = new Array<>();

        comparator = new Comparator<Entity>() {
            @Override
            public int compare(Entity entityA, Entity entityB) {
                return (int) Math.signum(CatMappers.transform.get(entityB).worldPosition.z -
                        CatMappers.transform.get(entityA).worldPosition.z);
            }
        };


    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        renderQueue.sort(comparator);

        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        for (Entity entity : renderQueue) {
            TextureComponent textureComponent = CatMappers.texture.get(entity);
            TransformComponent transformComponent = CatMappers.transform.get(entity);

            if (textureComponent.texture == null || transformComponent.isHidden) {
                continue;
            }

            float width = textureComponent.texture.getRegionWidth();
            float height = textureComponent.texture.getRegionHeight();
            float halfWidth = width/2f;
            float halfHeight = height/2f;

            batch.setColor(1, 1, 1, textureComponent.alpha);
            batch.draw(textureComponent.texture,
                    transformComponent.worldPosition.x - halfWidth, transformComponent.worldPosition.y - halfHeight,
                    halfWidth, halfHeight,
                    width, height,
                    transformComponent.scale.x, transformComponent.scale.y,
                    transformComponent.worldRotation);
            batch.setColor(1, 1, 1, textureComponent.alpha);
        }

        batch.end();
        renderQueue.clear();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        renderQueue.add(entity);
    }
}
