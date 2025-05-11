package net.justmili.axc.world.inventory;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.Container;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.justmili.axc.network.AutoWitherFarmerGUISlotMessage;
import net.justmili.axc.init.AvaritiaXCreateModMenus;
import net.justmili.axc.AvaritiaXCreateMod;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import java.util.HashMap;

public class AutoWitherFarmerGUIMenu extends AbstractContainerMenu {
	public final static HashMap<String, Object> guistate = new HashMap<>();
	public final Level world;
	public final Player entity;
	public int x, y, z;
	private BlockPos pos;
	private final Container inventory;
	private boolean bound = false;

	public AutoWitherFarmerGUIMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		this(id, inv, new SimpleContainer(8));
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
		}
	}

	public AutoWitherFarmerGUIMenu(int id, Inventory inv, Container container) {
		super(AvaritiaXCreateModMenus.AUTO_WITHER_FARMER_GUI, id);
		this.entity = inv.player;
		this.world = inv.player.level();
		this.inventory = container;
		this.addSlot(new Slot(inventory, 0, 16, 17) {
			private final int slot = 0;

			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(0, 0, 0);
			}

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Items.WITHER_SKELETON_SKULL == stack.getItem();
			}
		});
		this.addSlot(new Slot(inventory, 1, 34, 17) {
			private final int slot = 1;

			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(1, 0, 0);
			}

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Items.WITHER_SKELETON_SKULL == stack.getItem();
			}
		});
		this.addSlot(new Slot(inventory, 2, 52, 17) {
			private final int slot = 2;

			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(2, 0, 0);
			}

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Items.WITHER_SKELETON_SKULL == stack.getItem();
			}
		});
		this.addSlot(new Slot(inventory, 3, 16, 35) {
			private final int slot = 3;

			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(3, 0, 0);
			}

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Blocks.SOUL_SAND.asItem() == stack.getItem();
			}
		});
		this.addSlot(new Slot(inventory, 4, 34, 35) {
			private final int slot = 4;

			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(4, 0, 0);
			}

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Blocks.SOUL_SAND.asItem() == stack.getItem();
			}
		});
		this.addSlot(new Slot(inventory, 5, 52, 35) {
			private final int slot = 5;

			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(5, 0, 0);
			}

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Blocks.SOUL_SAND.asItem() == stack.getItem();
			}
		});
		this.addSlot(new Slot(inventory, 6, 34, 53) {
			private final int slot = 6;

			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(6, 0, 0);
			}

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Blocks.SOUL_SAND.asItem() == stack.getItem();
			}
		});
		this.addSlot(new Slot(inventory, 7, 124, 35) {
			private final int slot = 7;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return false;
			}
		});
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 8 + sj * 18, 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 8 + si * 18, 142));
	}

	@Override
	public boolean stillValid(Player player) {
		return this.inventory.stillValid(player);
	}

	@Override
	public ItemStack quickMoveStack(Player player, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < 8) {
				if (!this.moveItemStackTo(itemstack1, 8, this.slots.size(), true))
					return ItemStack.EMPTY;
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 8, false)) {
				if (index < 8 + 27) {
					if (!this.moveItemStackTo(itemstack1, 8 + 27, this.slots.size(), true))
						return ItemStack.EMPTY;
				} else {
					if (!this.moveItemStackTo(itemstack1, 8, 8 + 27, false))
						return ItemStack.EMPTY;
				}
				return ItemStack.EMPTY;
			}
			if (itemstack1.isEmpty())
				slot.set(ItemStack.EMPTY);
			else
				slot.setChanged();
			if (itemstack1.getCount() == itemstack.getCount())
				return ItemStack.EMPTY;
			slot.onTake(player, itemstack1);
		}
		return itemstack;
	}

	@Override
	public void removed(Player playerIn) {
		super.removed(playerIn);
	}

	private void slotChanged(int slotid, int ctype, int meta) {
		if (this.world != null && this.world.isClientSide())
			ClientPlayNetworking.send(new ResourceLocation(AvaritiaXCreateMod.MODID, "autowitherfarmergui_slot_" + slotid), new AutoWitherFarmerGUISlotMessage(slotid, x, y, z, ctype, meta));
	}

	public static void screenInit() {
		ServerPlayNetworking.registerGlobalReceiver(new ResourceLocation(AvaritiaXCreateMod.MODID, "autowitherfarmergui_slot_0"), AutoWitherFarmerGUISlotMessage::apply);
		ServerPlayNetworking.registerGlobalReceiver(new ResourceLocation(AvaritiaXCreateMod.MODID, "autowitherfarmergui_slot_1"), AutoWitherFarmerGUISlotMessage::apply);
		ServerPlayNetworking.registerGlobalReceiver(new ResourceLocation(AvaritiaXCreateMod.MODID, "autowitherfarmergui_slot_2"), AutoWitherFarmerGUISlotMessage::apply);
		ServerPlayNetworking.registerGlobalReceiver(new ResourceLocation(AvaritiaXCreateMod.MODID, "autowitherfarmergui_slot_3"), AutoWitherFarmerGUISlotMessage::apply);
		ServerPlayNetworking.registerGlobalReceiver(new ResourceLocation(AvaritiaXCreateMod.MODID, "autowitherfarmergui_slot_4"), AutoWitherFarmerGUISlotMessage::apply);
		ServerPlayNetworking.registerGlobalReceiver(new ResourceLocation(AvaritiaXCreateMod.MODID, "autowitherfarmergui_slot_5"), AutoWitherFarmerGUISlotMessage::apply);
		ServerPlayNetworking.registerGlobalReceiver(new ResourceLocation(AvaritiaXCreateMod.MODID, "autowitherfarmergui_slot_6"), AutoWitherFarmerGUISlotMessage::apply);
	}
}