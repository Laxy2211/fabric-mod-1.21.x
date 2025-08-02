package net.laxy.examplemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.laxy.examplemod.block.ModBlocks;
import net.laxy.examplemod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;


public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }
    @Override
    public void generate() {
        addDrop(ModBlocks.MOON_BLOCK);
        addDrop(ModBlocks.RAW_MOON_BLOCK);
        addDrop(ModBlocks.BLOCK_OF_RUBY);
        addDrop(ModBlocks.MAGIC_BLOCK);

        addDrop(ModBlocks.MINERAL_OF_MOON, oreDrops(ModBlocks.MINERAL_OF_MOON, ModItems.MOONSTONE_ORE));
        addDrop(ModBlocks.DEEPSLATE_MOON_ORE, oreDrops(ModBlocks.DEEPSLATE_MOON_ORE, ModItems.MOONSTONE_ORE));
        addDrop(ModBlocks.MINERAL_OF_RUBY, multipleOreDrops(ModBlocks.MINERAL_OF_RUBY, ModItems.RUBY_ORE, 1, 3));
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RUBY_ORE, 1, 3));
    }

        public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops){
            RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
            return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                    ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                    .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));

        }
    }

