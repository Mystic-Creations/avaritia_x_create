/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.justmili.axc.init;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;

import net.justmili.axc.AvaritiaXCreateMod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public class AvaritiaXCreateModItems {
	public static Item NEUTRONIUM_CASING;
	public static Item AUTOMATIC_NETHER_FARMER;
	public static Item AUTOMATIC_WITHER_FARMER;

	public static void load() {
		NEUTRONIUM_CASING = register("neutronium_casing", new BlockItem(AvaritiaXCreateModBlocks.NEUTRONIUM_CASING, new Item.Properties()));
		ItemGroupEvents.modifyEntriesEvent(AvaritiaXCreateModTabs.TAB_AVARITIA_X_CREATE).register(content -> content.accept(NEUTRONIUM_CASING));
		AUTOMATIC_NETHER_FARMER = register("automatic_nether_farmer", new BlockItem(AvaritiaXCreateModBlocks.AUTOMATIC_NETHER_FARMER, new Item.Properties()));
		ItemGroupEvents.modifyEntriesEvent(AvaritiaXCreateModTabs.TAB_AVARITIA_X_CREATE).register(content -> content.accept(AUTOMATIC_NETHER_FARMER));
		AUTOMATIC_WITHER_FARMER = register("automatic_wither_farmer", new BlockItem(AvaritiaXCreateModBlocks.AUTOMATIC_WITHER_FARMER, new Item.Properties()));
		ItemGroupEvents.modifyEntriesEvent(AvaritiaXCreateModTabs.TAB_AVARITIA_X_CREATE).register(content -> content.accept(AUTOMATIC_WITHER_FARMER));
	}

	public static void clientLoad() {
	}

	private static Item register(String registryName, Item item) {
		return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(AvaritiaXCreateMod.MODID, registryName), item);
	}

	private static void registerBlockingProperty(Item item) {
		ItemProperties.register(item, new ResourceLocation("blocking"), (ClampedItemPropertyFunction) ItemProperties.getProperty(Items.SHIELD, new ResourceLocation("blocking")));
	}
}
