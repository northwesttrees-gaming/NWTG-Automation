package net.nwtg.nwtgautomation.procedures;

import net.nwtg.nwtgautomation.block.RemoteItemTeleporterBlock;
import net.nwtg.nwtgautomation.block.BreakerPanelOnBlock;
import net.nwtg.nwtgautomation.block.BreakerPanelBlock;
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

public class UnlockMachineWrenchRecipeProcedure {
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
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency entity for procedure UnlockMachineWrenchRecipe!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(RemoteItemTeleporterBlock.block))
				: false)
				|| (((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(BreakerPanelBlock.block))
						: false)
						|| ((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(BreakerPanelOnBlock.block))
								: false)))) {
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity)
						.unlockRecipes(new ResourceLocation[]{new ResourceLocation("nwtg_automation:machine_wrench_crafting_recipe")});
			}
		}
	}
}
