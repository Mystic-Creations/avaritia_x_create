package net.justmili.axc.procedures;

import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.justmili.axc.init.AvaritiaXCreateModBlocks;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;

public class NeutroniumNuggetAppliedToIronBlockProcedure {
	public NeutroniumNuggetAppliedToIronBlockProcedure() {
		UseBlockCallback.EVENT.register((player, level, hand, hitResult) -> {
			if (hand != player.getUsedItemHand())
				return InteractionResult.PASS;
			execute(level, hitResult.getBlockPos().getX(), hitResult.getBlockPos().getY(), hitResult.getBlockPos().getZ(), player);
			return InteractionResult.PASS;
		});
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;

		BlockPos blockPos = BlockPos.containing(x, y, z);

		Item neutronNugget = BuiltInRegistries.ITEM.get(
				ResourceLocation.tryParse("avaritia:neutron_nugget")
		);

		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.IRON_BLOCK
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == neutronNugget) {
			world.setBlock(BlockPos.containing(x, y, z), AvaritiaXCreateModBlocks.NEUTRONIUM_CASING.defaultBlockState(), 3);

			if (world instanceof Level _level) {
				_level.levelEvent(2001, blockPos, Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
			}

			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.metal.break")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.metal.break")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
					}
					return false;
				}
			}.checkGamemode(entity)) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(neutronNugget);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
		}
	}
}