package net.laxy.examplemod.util;

import net.laxy.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ExampleMod.MOD_ID, name));
        }

    }
    public static class Items{
        public static final TagKey<Item> TRANSFORMABLE_ITEM = createTag("transformable_items");
        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(ExampleMod.MOD_ID, name));
        }
    }
}
