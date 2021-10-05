package net.nwtg.nwtgautomation.procedures;

public class BreakerPanelScreenToggleButtonProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency entity for procedure BreakerPanelScreenToggleButton!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency world for procedure BreakerPanelScreenToggleButton!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");

		if ((((new Object() {
			public String getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(world,
				new BlockPos(
						(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosX),
						(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosY),
						(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosZ)),
				"PasswordState"))).equals("ENABLED"))) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos(
						(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosX),
						(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosY),
						(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosZ));
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putString("PasswordState", "DISABLED");

				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else if ((((new Object() {
			public String getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(world,
				new BlockPos(
						(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosX),
						(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosY),
						(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosZ)),
				"PasswordState"))).equals("DISABLED"))) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos(
						(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosX),
						(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosY),
						(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosZ));
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putString("PasswordState", "ENABLED");

				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
	}

}
