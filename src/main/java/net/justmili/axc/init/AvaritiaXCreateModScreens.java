
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.justmili.axc.init;

import net.minecraft.client.gui.screens.MenuScreens;

import net.justmili.axc.client.gui.AutomaticNetherFarmerGUIScreen;
import net.justmili.axc.client.gui.AutoWitherFarmerGUIScreen;

public class AvaritiaXCreateModScreens {
	public static void load() {
		MenuScreens.register(AvaritiaXCreateModMenus.AUTOMATIC_NETHER_FARMER_GUI, AutomaticNetherFarmerGUIScreen::new);
		MenuScreens.register(AvaritiaXCreateModMenus.AUTO_WITHER_FARMER_GUI, AutoWitherFarmerGUIScreen::new);
	}
}
