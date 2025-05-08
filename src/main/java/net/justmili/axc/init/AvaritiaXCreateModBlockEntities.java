
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.justmili.axc.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.justmili.axc.block.entity.AutomaticNetherFarmerBlockEntity;
import net.justmili.axc.AvaritiaXCreateMod;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

public class AvaritiaXCreateModBlockEntities {
	public static BlockEntityType<?> AUTOMATIC_NETHER_FARMER;

	public static void load() {
		AUTOMATIC_NETHER_FARMER = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(AvaritiaXCreateMod.MODID, "automatic_nether_farmer"),
				FabricBlockEntityTypeBuilder.create(AutomaticNetherFarmerBlockEntity::new, AvaritiaXCreateModBlocks.AUTOMATIC_NETHER_FARMER).build(null));
	}
}
