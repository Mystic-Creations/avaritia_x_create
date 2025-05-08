
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.justmili.axc.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.justmili.axc.block.AutomaticNetherFarmerBlock;
import net.justmili.axc.AvaritiaXCreateMod;

public class AvaritiaXCreateModBlocks {
	public static Block AUTOMATIC_NETHER_FARMER;

	public static void load() {
		AUTOMATIC_NETHER_FARMER = register("automatic_nether_farmer", new AutomaticNetherFarmerBlock());
	}

	public static void clientLoad() {
		AutomaticNetherFarmerBlock.clientInit();
	}

	private static Block register(String registryName, Block block) {
		return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(AvaritiaXCreateMod.MODID, registryName), block);
	}
}
