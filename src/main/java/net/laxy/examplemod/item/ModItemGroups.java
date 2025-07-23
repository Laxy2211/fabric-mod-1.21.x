package net.laxy.examplemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.laxy.examplemod.ExampleMod;
import net.laxy.examplemod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MOON_GROUPS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ExampleMod.MOD_ID,"moon_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.MOON_INGOT))
                    .displayName(Text.translatable("itemgroup.examplemod.moon_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.MOONSTONE_ORE);
                        entries.add(ModItems.MOON_INGOT);

                    } )
                    .build());

        public static final ItemGroup RUBY_GROUPS = Registry.register(Registries.ITEM_GROUP,
                Identifier.of(ExampleMod.MOD_ID,"ruby_items"),
                FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RUBY_ORE))
                        .displayName(Text.translatable("itemgroup.examplemod.ruby_items"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.RUBY_ORE);

                        } )
                        .build());
    public static final ItemGroup RUBY_BLOCKS_GROUPS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ExampleMod.MOD_ID,"ruby_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.BLOCK_OF_RUBY))
                    .displayName(Text.translatable("itemgroup.examplemod.ruby_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.MINERAL_OF_RUBY);
                        entries.add(ModBlocks.BLOCK_OF_RUBY);

                    } )
                    .build());

    public static final ItemGroup MOON_BLOCKS_GROUPS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ExampleMod.MOD_ID,"moon_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.RAW_MOON_BLOCK))
                    .displayName(Text.translatable("itemgroup.examplemod.moon_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RAW_MOON_BLOCK);
                        entries.add(ModBlocks.MOON_BLOCK);
                        entries.add(ModBlocks.MINERAL_OF_MOON);
                        entries.add(ModBlocks.DEEPSLATE_MOON_ORE);
                    } )
                    .build());
    //prueba

    public static void registerItemGroups(){
        ExampleMod.LOGGER.info("Registering Item Groups for" + ExampleMod.MOD_ID);
    }
}
