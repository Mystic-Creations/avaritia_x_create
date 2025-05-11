
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.justmili.axc.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.justmili.axc.block.NeutroniumCasingBlock;
import net.justmili.axc.block.AutomaticWitherFarmerBlock;
import net.justmili.axc.block.AutomaticNetherFarmerBlock;
import net.justmili.axc.AvaritiaXCreateMod;

public class AvaritiaXCreateModBlocks {
	public static Block AUTOMATIC_NETHER_FARMER;
	public static Block NEUTRONIUM_CASING;
	public static Block AUTOMATIC_WITHER_FARMER;

	public static void load() {
		AUTOMATIC_NETHER_FARMER = register("automatic_nether_farmer", new AutomaticNetherFarmerBlock());
		NEUTRONIUM_CASING = register("neutronium_casing", new NeutroniumCasingBlock());
		AUTOMATIC_WITHER_FARMER = register("automatic_wither_farmer", new AutomaticWitherFarmerBlock());
	}

	public static void clientLoad() {
		AutomaticNetherFarmerBlock.clientInit();
		NeutroniumCasingBlock.clientInit();
		AutomaticWitherFarmerBlock.clientInit();
	}

	private static Block register(String registryName, Block block) {
		return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(AvaritiaXCreateMod.MODID, registryName), block);
	}
}
