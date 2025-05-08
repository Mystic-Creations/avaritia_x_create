
package net.justmili.axc.network;

import net.minecraft.world.level.Level;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.FriendlyByteBuf;

import net.justmili.axc.world.inventory.AutoWitherFarmerGUIMenu;
import net.justmili.axc.procedures.AutoWitherFarmProcedure;

import net.fabricmc.fabric.api.networking.v1.PacketSender;

import java.util.HashMap;

import io.netty.buffer.Unpooled;

public class AutoWitherFarmerGUISlotMessage extends FriendlyByteBuf {
	public AutoWitherFarmerGUISlotMessage(int slot, int x, int y, int z, int changeType, int meta) {
		super(Unpooled.buffer());
		writeInt(slot);
		writeInt(x);
		writeInt(y);
		writeInt(z);
		writeInt(changeType);
		writeInt(meta);
	}

	public static void apply(MinecraftServer server, ServerPlayer entity, ServerGamePacketListenerImpl handler, FriendlyByteBuf buf, PacketSender responseSender) {
		int slot = buf.readInt();
		double x = buf.readInt();
		double y = buf.readInt();
		double z = buf.readInt();
		int changeType = buf.readInt();
		int meta = buf.readInt();
		server.execute(() -> {
			Level world = entity.level();
			HashMap guistate = AutoWitherFarmerGUIMenu.guistate;
			if (slot == 0 && changeType == 0) {

				AutoWitherFarmProcedure.execute(world, x, y, z);
			}
			if (slot == 1 && changeType == 0) {

				AutoWitherFarmProcedure.execute(world, x, y, z);
			}
			if (slot == 2 && changeType == 0) {

				AutoWitherFarmProcedure.execute(world, x, y, z);
			}
			if (slot == 3 && changeType == 0) {

				AutoWitherFarmProcedure.execute(world, x, y, z);
			}
			if (slot == 4 && changeType == 0) {

				AutoWitherFarmProcedure.execute(world, x, y, z);
			}
			if (slot == 5 && changeType == 0) {

				AutoWitherFarmProcedure.execute(world, x, y, z);
			}
			if (slot == 6 && changeType == 0) {

				AutoWitherFarmProcedure.execute(world, x, y, z);
			}
		});
	}
}
