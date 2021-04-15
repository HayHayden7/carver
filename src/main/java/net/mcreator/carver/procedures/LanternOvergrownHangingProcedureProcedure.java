package net.mcreator.carver.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.entity.Entity;

import net.mcreator.carver.block.LanternOvergrownHangingBlock;
import net.mcreator.carver.block.LanternOvergrownBlock;
import net.mcreator.carver.CarverModElements;
import net.mcreator.carver.CarverMod;

import java.util.Map;

@CarverModElements.ModElement.Tag
public class LanternOvergrownHangingProcedureProcedure extends CarverModElements.ModElement {
	public LanternOvergrownHangingProcedureProcedure(CarverModElements instance) {
		super(instance, 783);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CarverMod.LOGGER.warn("Failed to load dependency entity for procedure LanternOvergrownHangingProcedure!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CarverMod.LOGGER.warn("Failed to load dependency x for procedure LanternOvergrownHangingProcedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CarverMod.LOGGER.warn("Failed to load dependency y for procedure LanternOvergrownHangingProcedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CarverMod.LOGGER.warn("Failed to load dependency z for procedure LanternOvergrownHangingProcedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CarverMod.LOGGER.warn("Failed to load dependency world for procedure LanternOvergrownHangingProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
				entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.DOWN)
				&& ((!(world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z))))
						&& (world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)).isSolid())))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), LanternOvergrownHangingBlock.block.getDefaultState(), 3);
		} else if ((((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
				entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.UP)
				&& ((!(world.isAirBlock(new BlockPos((int) x, (int) (y - 1), (int) z))))
						&& (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)).isSolid())))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), LanternOvergrownBlock.block.getDefaultState(), 3);
		}
	}
}
