package net.cuppa.cuppasuselessfeatures;

import net.cuppa.cuppasuselessfeatures.block.ModBlocks;
import net.cuppa.cuppasuselessfeatures.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CuppasUselessFeatures implements ModInitializer {
	public static final String MOD_ID = "cuppasuselessfeatures";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.initialize();
		ModItems.initialize();
	}
}