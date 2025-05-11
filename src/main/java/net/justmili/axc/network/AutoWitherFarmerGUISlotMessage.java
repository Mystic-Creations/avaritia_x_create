package net.justmili.axc.network;

import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.block.state.BlockState;

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

    public static void apply(MinecraftServer server, ServerPlayer entity,
                             ServerGamePacketListenerImpl handler, FriendlyByteBuf buf,
                             PacketSender responseSender) {
        int slot = buf.readInt();
        int x = buf.readInt();
        int y = buf.readInt();
        int z = buf.readInt();
        int changeType = buf.readInt();
        int meta = buf.readInt();
        server.execute(() -> {
            Level world = entity.level();
            // ← Define blockstate here:
            BlockPos pos = new BlockPos(x, y, z);
            BlockState blockstate = world.getBlockState(pos);

            // Your existing guistate fetch:
            @SuppressWarnings("unchecked")
            HashMap<String, Object> guistate = AutoWitherFarmerGUIMenu.guistate;

            // Now call your procedure with the actual blockstate
            if (changeType == 0) {
                switch (slot) {
                    case 0, 1, 2, 3, 4, 5, 6:
                        AutoWitherFarmProcedure.execute(world, x, y, z, blockstate);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}