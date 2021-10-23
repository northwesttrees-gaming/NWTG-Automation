package net.nwtg.nwtgautomation.procedures;

import net.nwtg.nwtgautomation.NwtgAutomationMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.HashMap;

public class SolarPanelUpdateTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency x for procedure SolarPanelUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency y for procedure SolarPanelUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency z for procedure SolarPanelUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency world for procedure SolarPanelUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double randomNumber = 0;
		double particleX = 0;
		double particleY = 0;
		double particleZ = 0;
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("world", world);
			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);
			SolarPanelUpdateTickOnScriptProcedure.executeProcedure($_dependencies);
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("world", world);
			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);
			SolarPanelUpdateTickOffScriptProcedure.executeProcedure($_dependencies);
		}
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
			particleX = (double) (Math.round(((x - 1) + (Math.random() * 2))) + 0.5);
			particleY = (double) (Math.round(((y - 1) + (Math.random() * 2))) + 0.5);
			particleZ = (double) (Math.round(((z - 1) + (Math.random() * 2))) + 0.5);
			if (((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "SparkTimer")) > 0)) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("SparkTimer", ((new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "SparkTimer")) - 1));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							(((("particle nwtg_automation:sparks ") + ""
									+ ((((((new java.text.DecimalFormat("##.##").format(particleX))) + "" + (" "))) + ""
											+ ((((new java.text.DecimalFormat("##.##").format(particleY))) + "" + (" "))) + ""
											+ ((((new java.text.DecimalFormat("##.##").format(particleZ))) + "" + (" ")))))
									+ "" + ("0.33 0.33 0.33 ") + "" + ("0 3 ")))
									+ ""
									+ ((("force @a[") + "" + ("x=") + "" + ((new java.text.DecimalFormat("##.##").format((particleX - 30)))) + ""
											+ (",y=") + "" + ((new java.text.DecimalFormat("##.##").format((particleY - 30)))) + "" + (",z=") + ""
											+ ((new java.text.DecimalFormat("##.##").format((particleZ - 30)))) + "" + (",dx=") + ""
											+ ((new java.text.DecimalFormat("##").format(61))) + "" + (",dy=") + ""
											+ ((new java.text.DecimalFormat("##").format(61))) + "" + (",dz=") + ""
											+ ((new java.text.DecimalFormat("##").format(61))) + "" + ("]")))));
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("FlameTimer", ((new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "FlameTimer")) + 1));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("SparkTimer", 20);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
			if (((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "FlameTimer")) >= 30)) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			} else if (((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "FlameTimer")) >= 7)) {
				if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
						.getMaterial() == net.minecraft.block.material.Material.AIR)) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
						BlockState _bs = Blocks.FIRE.getDefaultState();
						world.setBlockState(_bp, _bs, 3);
					}
				}
			}
		} else {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("FlameTimer", 0);
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("SparkTimer", 0);
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
	}
}
