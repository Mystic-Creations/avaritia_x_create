/*
 *	MCreator note:
 *
 *	If you lock base mod element files, you can edit this file and the proxy files
 *	and they won't get overwritten. If you change your mod package or modid, you
 *	need to apply these changes to this file MANUALLY.
 *
 *
 *	If you do not lock base mod element files in Workspace settings, this file
 *	will be REGENERATED on each build.
 *
 */
package net.justmili.axc;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.justmili.axc.init.AvaritiaXCreateModTabs;
import net.justmili.axc.init.AvaritiaXCreateModProcedures;
import net.justmili.axc.init.AvaritiaXCreateModMenus;
import net.justmili.axc.init.AvaritiaXCreateModItems;
import net.justmili.axc.init.AvaritiaXCreateModBlocks;
import net.justmili.axc.init.AvaritiaXCreateModBlockEntities;

import net.fabricmc.api.ModInitializer;

public class AvaritiaXCreateMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "avaritia_x_create";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing AvaritiaXCreateMod");

		AvaritiaXCreateModTabs.load();

		AvaritiaXCreateModBlocks.load();
		AvaritiaXCreateModItems.load();
		AvaritiaXCreateModBlockEntities.load();

		AvaritiaXCreateModProcedures.load();

		AvaritiaXCreateModMenus.load();

	}
}
