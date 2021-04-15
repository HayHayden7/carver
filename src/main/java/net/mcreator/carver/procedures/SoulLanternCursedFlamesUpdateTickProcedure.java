package net.mcreator.carver.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Block;

import net.mcreator.carver.CarverModElements;
import net.mcreator.carver.CarverMod;

import java.util.Map;

@CarverModElements.ModElement.Tag
public class SoulLanternCursedFlamesUpdateTickProcedure extends CarverModElements.ModElement {
	public SoulLanternCursedFlamesUpdateTickProcedure(CarverModElements instance) {
		super(instance, 799);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CarverMod.LOGGER.warn("Failed to load dependency x for procedure SoulLanternCursedFlamesUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CarverMod.LOGGER.warn("Failed to load dependency y for procedure SoulLanternCursedFlamesUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CarverMod.LOGGER.warn("Failed to load dependency z for procedure SoulLanternCursedFlamesUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CarverMod.LOGGER.warn("Failed to load dependency world for procedure SoulLanternCursedFlamesUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)).isSolid()))) {
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			}
		}
	}
}
