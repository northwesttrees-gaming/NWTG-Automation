package net.nwtg.nwtgautomation.procedures;

public class AutoTreeFarmMachineOnUpdateTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					NwtgAutomationMod.LOGGER.warn("Failed to load dependency x for procedure AutoTreeFarmMachineOnUpdateTick!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					NwtgAutomationMod.LOGGER.warn("Failed to load dependency y for procedure AutoTreeFarmMachineOnUpdateTick!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					NwtgAutomationMod.LOGGER.warn("Failed to load dependency z for procedure AutoTreeFarmMachineOnUpdateTick!");
				return;
			}
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					NwtgAutomationMod.LOGGER.warn("Failed to load dependency world for procedure AutoTreeFarmMachineOnUpdateTick!");
				return;
			}

				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");
				IWorld world = (IWorld) dependencies.get("world");


		if (((new Object(){
	public double getValue(IWorld world, BlockPos pos, String tag) {
		TileEntity tileEntity=world.getTileEntity(pos);
		if(tileEntity != null) return tileEntity.getTileData().getDouble(tag);
		return -1;
	}
}.getValue(world, new BlockPos((int)x,(int)y,(int)z), "BlockVersion"))
<NwtgAutomationModVariables.MapVariables.get(world).nwtgAutomationModVersion)) {
	}

}
