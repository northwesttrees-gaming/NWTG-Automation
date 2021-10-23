package net.nwtg.nwtgautomation.procedures;

import net.nwtg.nwtgautomation.particle.SparksParticle;
import net.nwtg.nwtgautomation.NwtgAutomationMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Map;

public class SolarPanelClientDisplayRandomTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency x for procedure SolarPanelClientDisplayRandomTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency y for procedure SolarPanelClientDisplayRandomTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency z for procedure SolarPanelClientDisplayRandomTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency world for procedure SolarPanelClientDisplayRandomTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double particleZ = 0;
		if (((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.FIRE)
				|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
						.getMaterial() == net.minecraft.block.material.Material.WATER)
						|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
								.getMaterial() == net.minecraft.block.material.Material.LAVA)))
				|| (((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)))
						.getMaterial() == net.minecraft.block.material.Material.FIRE)
						|| (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)))
								.getMaterial() == net.minecraft.block.material.Material.WATER)
								|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)))
										.getMaterial() == net.minecraft.block.material.Material.LAVA)))
						|| (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)))
								.getMaterial() == net.minecraft.block.material.Material.FIRE)
								|| (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)))
										.getMaterial() == net.minecraft.block.material.Material.WATER)
										|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)))
												.getMaterial() == net.minecraft.block.material.Material.LAVA))))
						|| ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))))
								.getMaterial() == net.minecraft.block.material.Material.FIRE)
								|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))))
										.getMaterial() == net.minecraft.block.material.Material.WATER)
										|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))))
												.getMaterial() == net.minecraft.block.material.Material.LAVA)))
								|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))))
										.getMaterial() == net.minecraft.block.material.Material.FIRE)
										|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))))
												.getMaterial() == net.minecraft.block.material.Material.WATER)
												|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))))
														.getMaterial() == net.minecraft.block.material.Material.LAVA))))))) {
			for (int index0 = 0; index0 < (int) (10); index0++) {
				particleZ = (double) (x + (Math.random() * 3));
				particleZ = (double) (y + (Math.random() * 3));
				particleZ = (double) (z + (Math.random() * 3));
				world.addParticle(SparksParticle.particle, particleZ, particleZ, particleZ, 0, (-0.1), 0);
			}
		}
	}
}
