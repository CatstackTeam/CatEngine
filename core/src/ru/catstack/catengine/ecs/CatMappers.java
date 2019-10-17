package ru.catstack.catengine.ecs;

import com.badlogic.ashley.core.ComponentMapper;
import ru.catstack.catengine.ecs.components.*;
import ru.catstack.catengine.game.ecs.components.PlayerComponent;

public class CatMappers {
    public static ComponentMapper<TextureComponent> texture = ComponentMapper.getFor(TextureComponent.class);
    public static ComponentMapper<TransformComponent> transform = ComponentMapper.getFor(TransformComponent.class);
    public static ComponentMapper<ParentComponent> parent = ComponentMapper.getFor(ParentComponent.class);
    public static ComponentMapper<DeleteByTimeComponent> deleteByTime = ComponentMapper.getFor(DeleteByTimeComponent.class);
    public static ComponentMapper<AnimationComponent> animation = ComponentMapper.getFor(AnimationComponent.class);
    public static ComponentMapper<ButtonComponent> button = ComponentMapper.getFor(ButtonComponent.class);
    public static ComponentMapper<RoundButtonComponent> roundButton = ComponentMapper.getFor(RoundButtonComponent.class);
    public static ComponentMapper<BoundsComponent> bounds = ComponentMapper.getFor(BoundsComponent.class);
    public static ComponentMapper<TweenComponent> tween = ComponentMapper.getFor(TweenComponent.class);

    public static ComponentMapper<PlayerComponent> player = ComponentMapper.getFor(PlayerComponent.class);
}
