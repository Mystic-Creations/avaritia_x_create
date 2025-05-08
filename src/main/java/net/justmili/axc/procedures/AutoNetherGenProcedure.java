package net.justmili.axc.procedures;

import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicInteger;

public class AutoNetherGenProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.SOUL_SOIL && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.NETHER_BRICKS) {
			{
				BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
				ItemStack stack = new ItemStack(Items.BONE);
				stack.setCount((int) (new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicInteger count = new AtomicInteger(0);
						BlockEntity _ent = world.getBlockEntity(pos);
						RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
						if (_ent != null)
							count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
						return count.get();
					}
				}.getAmount(world, (BlockPos.containing(x, y, z)), 0) + Math.random() * 4 + 1));
				if (_ent != null) {
					((RandomizableContainerBlockEntity) _ent).setItem(0, stack);
				}
			}
			if (Math.random() < 0.6667) {
				{
					BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
					ItemStack stack = new ItemStack(Items.COAL);
					stack.setCount((int) (new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger count = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
							if (_ent != null)
								count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
							return count.get();
						}
					}.getAmount(world, (BlockPos.containing(x, y, z)), 1) + Math.random() * 3 + 1));
					if (_ent != null) {
						((RandomizableContainerBlockEntity) _ent).setItem(1, stack);
					}
				}
			}
			if (Math.random() < 0.1) {
				{
					BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
					ItemStack stack = new ItemStack(Items.WITHER_SKELETON_SKULL);
					stack.setCount((int) (new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger count = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
							if (_ent != null)
								count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
							return count.get();
						}
					}.getAmount(world, (BlockPos.containing(x, y, z)), 2) + 1));
					if (_ent != null) {
						((RandomizableContainerBlockEntity) _ent).setItem(2, stack);
					}
				}
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.BLUE_ICE && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.SOUL_SOIL) {
			{
				BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
				ItemStack stack = new ItemStack(Items.GHAST_TEAR);
				stack.setCount((int) (new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicInteger count = new AtomicInteger(0);
						BlockEntity _ent = world.getBlockEntity(pos);
						RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
						if (_ent != null)
							count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
						return count.get();
					}
				}.getAmount(world, (BlockPos.containing(x, y, z)), 0) + Math.random() * 3 + 1));
				if (_ent != null) {
					((RandomizableContainerBlockEntity) _ent).setItem(0, stack);
				}
			}
			{
				BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
				ItemStack stack = new ItemStack(Items.GUNPOWDER);
				stack.setCount((int) (new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicInteger count = new AtomicInteger(0);
						BlockEntity _ent = world.getBlockEntity(pos);
						RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
						if (_ent != null)
							count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
						return count.get();
					}
				}.getAmount(world, (BlockPos.containing(x, y, z)), 1) + Math.random() * 4 + 1));
				if (_ent != null) {
					((RandomizableContainerBlockEntity) _ent).setItem(1, stack);
				}
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.LAVA && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.NETHER_BRICKS) {
			{
				BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
				ItemStack stack = new ItemStack(Items.BLAZE_ROD);
				stack.setCount((int) (new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicInteger count = new AtomicInteger(0);
						BlockEntity _ent = world.getBlockEntity(pos);
						RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
						if (_ent != null)
							count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
						return count.get();
					}
				}.getAmount(world, (BlockPos.containing(x, y, z)), 0) + Math.random() * 3 + 1));
				if (_ent != null) {
					((RandomizableContainerBlockEntity) _ent).setItem(0, stack);
				}
			}
		}
	}
}
