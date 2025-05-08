
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.justmili.axc.init;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.justmili.axc.world.inventory.AutomaticNetherFarmerGUIMenu;
import net.justmili.axc.world.inventory.AutoWitherFarmerGUIMenu;
import net.justmili.axc.AvaritiaXCreateMod;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;

public class AvaritiaXCreateModMenus {
	public static MenuType<AutomaticNetherFarmerGUIMenu> AUTOMATIC_NETHER_FARMER_GUI;
	public static MenuType<AutoWitherFarmerGUIMenu> AUTO_WITHER_FARMER_GUI;

	public static void load() {
		AUTOMATIC_NETHER_FARMER_GUI = Registry.register(BuiltInRegistries.MENU, new ResourceLocation(AvaritiaXCreateMod.MODID, "automatic_nether_farmer_gui"), new ExtendedScreenHandlerType<>(AutomaticNetherFarmerGUIMenu::new));
		AutomaticNetherFarmerGUIMenu.screenInit();
		AUTO_WITHER_FARMER_GUI = Registry.register(BuiltInRegistries.MENU, new ResourceLocation(AvaritiaXCreateMod.MODID, "auto_wither_farmer_gui"), new ExtendedScreenHandlerType<>(AutoWitherFarmerGUIMenu::new));
		AutoWitherFarmerGUIMenu.screenInit();
	}
}
