package net.laxy.examplemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.laxy.examplemod.item.ModItems;
import net.laxy.examplemod.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider  extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEM)
                .add(ModItems.RUBY_ORE)
                .add(ModItems.MOON_INGOT)
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.APPLE);


    }
}
