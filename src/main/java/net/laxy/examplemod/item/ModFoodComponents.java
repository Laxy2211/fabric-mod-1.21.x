package net.laxy.examplemod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent MUSHROOM = new FoodComponent.Builder().nutrition(3).saturationModifier(0.50f).
            statusEffect(new StatusEffectInstance(StatusEffects.SPEED,200), 100f).build();
}
