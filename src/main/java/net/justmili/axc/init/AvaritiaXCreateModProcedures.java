
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.justmili.axc.init;

import net.justmili.axc.procedures.NeutroniumNuggetAppliedToIronBlockProcedure;
import net.justmili.axc.procedures.AutoWitherFarmProcedure;
import net.justmili.axc.procedures.AutoNetherGenProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class AvaritiaXCreateModProcedures {
	public static void load() {
		new AutoNetherGenProcedure();
		new AutoWitherFarmProcedure();
		new NeutroniumNuggetAppliedToIronBlockProcedure();
	}
}
