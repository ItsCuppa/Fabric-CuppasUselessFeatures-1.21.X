package net.cuppa.cuppasuselessfeatures.datagen.loottable;

import net.cuppa.cuppasuselessfeatures.block.ModBlocks;
import net.cuppa.cuppasuselessfeatures.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ModBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MELON_BLOCK, LootTable.builder().pool(
                addSurvivesExplosionCondition(Items.MELON_SLICE, LootPool.builder()
                        .rolls(new UniformLootNumberProvider(
                                new ConstantLootNumberProvider(3),
                                new ConstantLootNumberProvider(7)))
                        .with(ItemEntry.builder(Items.MELON_SLICE)))
        ));
    }
}
