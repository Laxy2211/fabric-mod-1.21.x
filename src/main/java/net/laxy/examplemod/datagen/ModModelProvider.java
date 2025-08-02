package net.laxy.examplemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.laxy.examplemod.block.ModBlocks;
import net.laxy.examplemod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_MOON_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MINERAL_OF_MOON);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOON_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_MOON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MINERAL_OF_RUBY);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCK_OF_RUBY);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RUBY_ORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOONSTONE_ORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOON_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOON_WIND, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSHROOM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_ASHES, Models.GENERATED);


    }
}
