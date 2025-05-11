package net.justmili.axc.block.entity;

import org.jetbrains.annotations.Nullable;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.justmili.axc.world.inventory.AutoWitherFarmerGUIMenu;
import net.justmili.axc.init.AvaritiaXCreateModBlockEntities;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;

import java.util.stream.IntStream;

public class AutomaticWitherFarmerBlockEntity extends RandomizableContainerBlockEntity implements ExtendedScreenHandlerFactory, WorldlyContainer {
	private NonNullList<ItemStack> stacks = NonNullList.withSize(8, ItemStack.EMPTY);

	public AutomaticWitherFarmerBlockEntity(BlockPos pos, BlockState state) {
		super(AvaritiaXCreateModBlockEntities.AUTOMATIC_WITHER_FARMER, pos, state);
	}

	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
		if (!this.tryLoadLootTable(compound))
			this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compound, this.stacks);
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
		if (!this.trySaveLootTable(compound))
			ContainerHelper.saveAllItems(compound, this.stacks);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public CompoundTag getUpdateTag() {
		return this.saveWithoutMetadata();
	}

	@Override
	public int getContainerSize() {
		return this.stacks.size();
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemstack : this.stacks)
			if (!itemstack.isEmpty())
				return false;
		return true;
	}

	@Override
	public Component getDefaultName() {
		return Component.literal("automatic_wither_farmer");
	}

	@Override
	public int getMaxStackSize() {
		return 1;
	}

	@Override
	public AbstractContainerMenu createMenu(int id, Inventory inventory) {
		return new AutoWitherFarmerGUIMenu(id, inventory, this);
	}

	@Override
	public Component getDisplayName() {
		return Component.literal("Automatic Wither Farmer");
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return stacks;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> items) {
		this.stacks = items;
	}

	@Override
	public boolean canPlaceItem(int index, ItemStack stack) {
		return canPlaceItemThroughFace(index, stack, null);
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		return IntStream.range(0, this.getContainerSize()).toArray();
	}

	@Override
	public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction side) {
		if (index >= 0 && index <= 2) {
			return stack.getItem() == net.minecraft.world.item.Items.WITHER_SKELETON_SKULL;
		}
		if (index >= 3 && index <= 6) {
			return stack.getItem() == net.minecraft.world.level.block.Blocks.SOUL_SAND.asItem();
		}
		return false;
	}

	@Override
	public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
		return true;
	}

	@Override
	public void writeScreenOpeningData(ServerPlayer player, FriendlyByteBuf buf) {
		buf.writeBlockPos(worldPosition);
	}
}
