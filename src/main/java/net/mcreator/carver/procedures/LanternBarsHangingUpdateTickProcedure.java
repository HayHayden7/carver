package net.mcreator.carver.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.block.Blocks;

import net.mcreator.carver.block.LanternBarsBlock;
import net.mcreator.carver.CarverModElements;
import net.mcreator.carver.CarverMod;

import java.util.Map;

@CarverModElements.ModElement.Tag
public class LanternBarsHangingUpdateTickProcedure extends CarverModElements.ModElement {
	public LanternBarsHangingUpdateTickProcedure(CarverModElements instance) {
		super(instance, 732);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CarverMod.LOGGER.warn("Failed to load dependency x for procedure LanternBarsHangingUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CarverMod.LOGGER.warn("Failed to load dependency y for procedure LanternBarsHangingUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CarverMod.LOGGER.warn("Failed to load dependency z for procedure LanternBarsHangingUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CarverMod.LOGGER.warn("Failed to load dependency world for procedure LanternBarsHangingUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)).isSolid()))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(LanternBarsBlock.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 0);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
