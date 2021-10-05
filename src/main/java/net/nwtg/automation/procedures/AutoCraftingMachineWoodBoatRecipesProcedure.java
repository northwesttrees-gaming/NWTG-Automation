package net.nwtg.nwtgautomation.procedures;

public class AutoCraftingMachineWoodBoatRecipesProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency x for procedure AutoCraftingMachineWoodBoatRecipes!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency y for procedure AutoCraftingMachineWoodBoatRecipes!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency z for procedure AutoCraftingMachineWoodBoatRecipes!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency world for procedure AutoCraftingMachineWoodBoatRecipes!");
			return;
		}

		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		{
			Map<String, Object> $_dependencies = new HashMap<>();

			$_dependencies.put("world", world);

			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);

			AutoCraftingMachineOakBoatRecipeProcedure.executeProcedure($_dependencies);
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();

			$_dependencies.put("world", world);

			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);

			AutoCraftingMachineSpruceBoatRecipeProcedure.executeProcedure($_dependencies);
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();

			$_dependencies.put("world", world);

			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);

			AutoCraftingMachineBirchBoatRecipeProcedure.executeProcedure($_dependencies);
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();

			$_dependencies.put("world", world);

			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);

			AutoCraftingMachineJungleBoatRecipeProcedure.executeProcedure($_dependencies);
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();

			$_dependencies.put("world", world);

			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);

			AutoCraftingMachineAcaciaBoatRecipeProcedure.executeProcedure($_dependencies);
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();

			$_dependencies.put("world", world);

			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);

			AutoCraftingMachineDarkOakBoatRecipeProcedure.executeProcedure($_dependencies);
		}

	}

}
