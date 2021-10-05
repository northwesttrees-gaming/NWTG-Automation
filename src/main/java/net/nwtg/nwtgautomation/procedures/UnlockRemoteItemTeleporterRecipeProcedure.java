package net.nwtg.nwtgautomation.procedures;

import net.nwtg.nwtgautomation.block.AutoTreeFarmMachineOnBlock;
import net.nwtg.nwtgautomation.block.AutoTreeFarmMachineBlock;
import net.nwtg.nwtgautomation.block.AutoItemCollectorMachineOnBlock;
import net.nwtg.nwtgautomation.block.AutoItemCollectorMachineBlock;
import net.nwtg.nwtgautomation.block.AutoFarmingMachineOnBlock;
import net.nwtg.nwtgautomation.block.AutoFarmingMachineBlock;
import net.nwtg.nwtgautomation.block.AutoCraftingMachineOnBlock;
import net.nwtg.nwtgautomation.block.AutoCraftingMachineBlock;
import net.nwtg.nwtgautomation.NwtgAutomationMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

public class UnlockRemoteItemTeleporterRecipeProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency entity for procedure UnlockRemoteItemTeleporterRecipe!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(AutoFarmingMachineBlock.block))
				: false)
				|| ((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(AutoFarmingMachineOnBlock.block))
						: false))
				|| ((((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(AutoCraftingMachineBlock.block))
						: false)
						|| ((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(AutoCraftingMachineOnBlock.block))
								: false))
						|| ((((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(AutoItemCollectorMachineBlock.block))
								: false)
								|| ((entity instanceof PlayerEntity)
										? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(AutoItemCollectorMachineOnBlock.block))
										: false))
								|| (((entity instanceof PlayerEntity)
										? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(AutoTreeFarmMachineBlock.block))
										: false)
										|| ((entity instanceof PlayerEntity)
												? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(AutoTreeFarmMachineOnBlock.block))
												: false)))))) {
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity)
						.unlockRecipes(new ResourceLocation[]{new ResourceLocation("nwtg_automation:remote_item_teleporter_crafting_recipe")});
			}
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity)
						.unlockRecipes(new ResourceLocation[]{new ResourceLocation("nwtg_automation:breaker_panel_crafting_recipe")});
			}
		}
	}
}
