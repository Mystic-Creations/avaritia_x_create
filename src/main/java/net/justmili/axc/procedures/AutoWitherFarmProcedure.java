package net.justmili.axc.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;

public class AutoWitherFarmProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> stack = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					stack.set(((RandomizableContainerBlockEntity) _ent).getItem(slotid).copy());
				return stack.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == Items.WITHER_SKELETON_SKULL && (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> stack = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					stack.set(((RandomizableContainerBlockEntity) _ent).getItem(slotid).copy());
				return stack.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 1)).getItem() == Items.WITHER_SKELETON_SKULL && (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> stack = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					stack.set(((RandomizableContainerBlockEntity) _ent).getItem(slotid).copy());
				return stack.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 2)).getItem() == Items.WITHER_SKELETON_SKULL && (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> stack = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					stack.set(((RandomizableContainerBlockEntity) _ent).getItem(slotid).copy());
				return stack.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 3)).getItem() == Blocks.SOUL_SAND.asItem() && (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> stack = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					stack.set(((RandomizableContainerBlockEntity) _ent).getItem(slotid).copy());
				return stack.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 4)).getItem() == Blocks.SOUL_SAND.asItem() && (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> stack = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					stack.set(((RandomizableContainerBlockEntity) _ent).getItem(slotid).copy());
				return stack.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 5)).getItem() == Blocks.SOUL_SAND.asItem() && (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> stack = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					stack.set(((RandomizableContainerBlockEntity) _ent).getItem(slotid).copy());
				return stack.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 6)).getItem() == Blocks.SOUL_SAND.asItem()) {
			if ((blockstate.getBlock().getStateDefinition().getProperty("processing") instanceof BooleanProperty _getbp15 && blockstate.getValue(_getbp15)) == false) {
				BlockEntity _ent16 = world.getBlockEntity(BlockPos.containing(x, y, z));
				if (_ent16 != null) {
					((RandomizableContainerBlockEntity) _ent16).removeItem(0, 1);
				}
				BlockEntity _ent17 = world.getBlockEntity(BlockPos.containing(x, y, z));
				if (_ent17 != null) {
					((RandomizableContainerBlockEntity) _ent17).removeItem(1, 1);
				}
				BlockEntity _ent18 = world.getBlockEntity(BlockPos.containing(x, y, z));
				if (_ent18 != null) {
					((RandomizableContainerBlockEntity) _ent18).removeItem(2, 1);
				}
				BlockEntity _ent19 = world.getBlockEntity(BlockPos.containing(x, y, z));
				if (_ent19 != null) {
					((RandomizableContainerBlockEntity) _ent19).removeItem(3, 1);
				}
				BlockEntity _ent20 = world.getBlockEntity(BlockPos.containing(x, y, z));
				if (_ent20 != null) {
					((RandomizableContainerBlockEntity) _ent20).removeItem(4, 1);
				}
				BlockEntity _ent21 = world.getBlockEntity(BlockPos.containing(x, y, z));
				if (_ent21 != null) {
					((RandomizableContainerBlockEntity) _ent21).removeItem(5, 1);
				}
				BlockEntity _ent22 = world.getBlockEntity(BlockPos.containing(x, y, z));
				if (_ent22 != null) {
					((RandomizableContainerBlockEntity) _ent22).removeItem(6, 1);
				}
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("processing") instanceof BooleanProperty _booleanProp)
						world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
				}
				new Object() {
					private int ticks = 0;

					public void startDelay(LevelAccessor world) {
						ServerTickEvents.END_SERVER_TICK.register((server) -> {
							this.ticks++;
							if (this.ticks == 500) {
								{
									BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
									ItemStack stack = new ItemStack(Items.NETHER_STAR);
									stack.setCount((int) (new Object() {
										public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
											AtomicInteger count = new AtomicInteger(0);
											BlockEntity _ent = world.getBlockEntity(pos);
											RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
											if (_ent != null)
												count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
											return count.get();
										}
									}.getAmount(world, (BlockPos.containing(x, y, z)), 7) + 1));
									if (_ent != null) {
										((RandomizableContainerBlockEntity) _ent).setItem(7, stack);
									}
								}
								{
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("processing") instanceof BooleanProperty _booleanProp)
										world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
								}
								return;
							}
						});
					}
				}.startDelay(world);
			}
		}
	}
}
