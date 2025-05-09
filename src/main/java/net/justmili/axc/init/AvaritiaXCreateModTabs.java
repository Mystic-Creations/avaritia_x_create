
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.justmili.axc.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.justmili.axc.AvaritiaXCreateMod;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

public class AvaritiaXCreateModTabs {
	public static ResourceKey<CreativeModeTab> TAB_AVARITIA_X_CREATE = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(AvaritiaXCreateMod.MODID, "avaritia_x_create"));

	public static void load() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TAB_AVARITIA_X_CREATE,
				FabricItemGroup.builder().title(Component.translatable("item_group." + AvaritiaXCreateMod.MODID + ".avaritia_x_create")).icon(() -> new ItemStack(AvaritiaXCreateModBlocks.AUTOMATIC_NETHER_FARMER)).build());
	}
}
