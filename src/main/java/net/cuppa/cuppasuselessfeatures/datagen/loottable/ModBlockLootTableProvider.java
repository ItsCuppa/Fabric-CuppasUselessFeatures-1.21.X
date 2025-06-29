package net.cuppa.cuppasuselessfeatures.datagen.loottable;

import net.cuppa.cuppasuselessfeatures.block.ModBlocks;
import net.cuppa.cuppasuselessfeatures.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.property.Properties;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ModBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        LootTable.Builder builder = LootTable.builder();

        // Bites = 0: 3–7 slices
        builder.pool(LootPool.builder()
                .with(ItemEntry.builder(Items.MELON_SLICE))
                .rolls(UniformLootNumberProvider.create(3, 7))
                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.MELON_BLOCK)
                        .properties(StatePredicate.Builder.create().exactMatch(Properties.BITES, 0)))
                .conditionally(SurvivesExplosionLootCondition.builder())
        );

        builder.pool(LootPool.builder()
                .with(ItemEntry.builder(Items.GLISTERING_MELON_SLICE))
                .rolls(UniformLootNumberProvider.create(3, 7))
                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.GLISTERING_MELON_BLOCK)
                        .properties(StatePredicate.Builder.create().exactMatch(Properties.BITES, 0)))
                .conditionally(SurvivesExplosionLootCondition.builder())
        );

        // Bites = 1: 3–5 slices
        builder.pool(LootPool.builder()
                .with(ItemEntry.builder(Items.MELON_SLICE))
                .rolls(UniformLootNumberProvider.create(3, 5))
                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.MELON_BLOCK)
                        .properties(StatePredicate.Builder.create().exactMatch(Properties.BITES, 1)))
                .conditionally(SurvivesExplosionLootCondition.builder())
        );

        builder.pool(LootPool.builder()
                .with(ItemEntry.builder(Items.GLISTERING_MELON_SLICE))
                .rolls(UniformLootNumberProvider.create(3, 5))
                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.GLISTERING_MELON_BLOCK)
                        .properties(StatePredicate.Builder.create().exactMatch(Properties.BITES, 1)))
                .conditionally(SurvivesExplosionLootCondition.builder())
        );

        // Bites = 2: 2–4 slices
        builder.pool(LootPool.builder()
                .with(ItemEntry.builder(Items.MELON_SLICE))
                .rolls(UniformLootNumberProvider.create(2, 4))
                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.MELON_BLOCK)
                        .properties(StatePredicate.Builder.create().exactMatch(Properties.BITES, 2)))
                .conditionally(SurvivesExplosionLootCondition.builder())
        );

        builder.pool(LootPool.builder()
                .with(ItemEntry.builder(Items.GLISTERING_MELON_SLICE))
                .rolls(UniformLootNumberProvider.create(2, 4))
                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.GLISTERING_MELON_BLOCK)
                        .properties(StatePredicate.Builder.create().exactMatch(Properties.BITES, 2)))
                .conditionally(SurvivesExplosionLootCondition.builder())
        );

        // Bites = 3: 1–2 slices
        builder.pool(LootPool.builder()
                .with(ItemEntry.builder(Items.MELON_SLICE))
                .rolls(UniformLootNumberProvider.create(1, 2))
                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.MELON_BLOCK)
                        .properties(StatePredicate.Builder.create().exactMatch(Properties.BITES, 3)))
                .conditionally(SurvivesExplosionLootCondition.builder())
        );

        builder.pool(LootPool.builder()
                .with(ItemEntry.builder(Items.GLISTERING_MELON_SLICE))
                .rolls(UniformLootNumberProvider.create(1, 2))
                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.GLISTERING_MELON_BLOCK)
                        .properties(StatePredicate.Builder.create().exactMatch(Properties.BITES, 3)))
                .conditionally(SurvivesExplosionLootCondition.builder())
        );

        addDrop(ModBlocks.MELON_BLOCK, builder);
        addDrop(ModBlocks.GLISTERING_MELON_BLOCK, builder);
    }
}