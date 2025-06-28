package net.cuppa.cuppasuselessfeatures;

import net.cuppa.cuppasuselessfeatures.datagen.loottable.ModBlockLootTableProvider;
import net.cuppa.cuppasuselessfeatures.datagen.loottable.ModChestLootTableProvider;
import net.cuppa.cuppasuselessfeatures.datagen.recipe.ModRecipeProvider;
import net.cuppa.cuppasuselessfeatures.datagen.tag.ModBlockTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class CuppasUselessFeaturesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModChestLootTableProvider::new);
	}
}
