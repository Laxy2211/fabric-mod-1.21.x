package net.laxy.examplemod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.laxy.examplemod.block.ModBlocks;
import net.laxy.examplemod.item.ModItemGroups;
import net.laxy.examplemod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	public static final String MOD_ID = "examplemod";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModItems.RUBY_ASHES,2000);

		LOGGER.info("Hello Fabric world!");
	}
}