package net.laxy.examplemod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.laxy.examplemod.datagen.ModBlockTagProvider;
import net.laxy.examplemod.datagen.ModItemTagProvider;
import net.laxy.examplemod.datagen.ModLootTableProvider;
import net.laxy.examplemod.datagen.ModModelProvider;
import net.laxy.examplemod.item.ModItems;

public class ExampleModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModLootTableProvider::new);

	}
}
