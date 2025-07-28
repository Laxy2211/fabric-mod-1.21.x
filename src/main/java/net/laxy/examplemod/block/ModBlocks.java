package net.laxy.examplemod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.laxy.examplemod.ExampleMod;
import net.laxy.examplemod.block.custom.MagicBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block MOON_BLOCK =registerBlock("moon_block",new Block(AbstractBlock.Settings.create().strength(3f)
            .requiresTool().sounds(BlockSoundGroup.ANVIL)));

    public static final Block RAW_MOON_BLOCK = registerBlock("raw_moon_block", new Block(AbstractBlock.Settings.create().strength(3f)
            .requiresTool().sounds(BlockSoundGroup.CALCITE)));

    public static final Block MINERAL_OF_MOON = registerBlock("mineral_of_moon",
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(2, 5),
            AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block MINERAL_OF_RUBY = registerBlock("mineral_of_ruby",
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(2, 3),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLOCK_OF_RUBY = registerBlock("block_of_ruby",
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(2, 3),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 3),
                    AbstractBlock.Settings.create().mapColor(MapColor.DEEPSLATE_GRAY).strength(3f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));


    public static final Block DEEPSLATE_MOON_ORE = registerBlock("deepslate_moon_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
            AbstractBlock.Settings.create().mapColor(MapColor.DEEPSLATE_GRAY).strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block MAGIC_BLOCK = registerBlock("magic_block",new MagicBlock(AbstractBlock.Settings.create().requiresTool().sounds(BlockSoundGroup.CALCITE).strength(1f)));


    private static Block registerBlock(String name,Block block){
        registerBlockItems(name,block);
        return Registry.register(Registries.BLOCK, Identifier.of(ExampleMod.MOD_ID, name), block);
    }
    private static void registerBlockItems(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(ExampleMod.MOD_ID,name), new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBlocks(){
        ExampleMod.LOGGER.info("Registering Mod Blocks for" + ExampleMod.MOD_ID );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
                entries.add(ModBlocks.MOON_BLOCK);
                entries.add(ModBlocks.RAW_MOON_BLOCK);
                entries.add(ModBlocks.MINERAL_OF_MOON);
                entries.add(ModBlocks.DEEPSLATE_MOON_ORE);
                entries.add(ModBlocks.MINERAL_OF_RUBY);
                entries.add(ModBlocks.BLOCK_OF_RUBY);
                entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
          } );
    }
}
