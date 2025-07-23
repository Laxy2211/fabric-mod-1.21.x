package net.laxy.examplemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.laxy.examplemod.ExampleMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
public static final Item MOONSTONE_ORE = registerItem("moonstone_ore", new Item(new Item.Settings()));
public static final Item MOON_INGOT = registerItem("moon_ingot",new Item(new Item.Settings()));
public static final Item RUBY_ORE = registerItem("ruby_ore",new Item(new Item.Settings()));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(ExampleMod.MOD_ID,name),item);
    }
    public static void registerModItems(){
        ExampleMod.LOGGER.info("Registering mod items for " + ExampleMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->{
            entries.add(MOONSTONE_ORE);
            entries.add(MOON_INGOT);
            entries.add(RUBY_ORE);

        } );
    }
}
