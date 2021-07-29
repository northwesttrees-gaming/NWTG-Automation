package net.nwtg.nwtgautomation.procedures;

import net.nwtg.nwtgautomation.block.GrassBlockSlabUpperBlock;
import net.nwtg.nwtgautomation.block.GrassBlockSlabLowerBlock;
import net.nwtg.nwtgautomation.NwtgAutomationModElements;
import net.nwtg.nwtgautomation.NwtgAutomationMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;
import java.util.HashMap;

@NwtgAutomationModElements.ModElement.Tag
public class UnlockMachineBlockRecipeProcedure extends NwtgAutomationModElements.ModElement {
	public UnlockMachineBlockRecipeProcedure(NwtgAutomationModElements instance) {
		super(instance, 63);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency entity for procedure UnlockMachineBlockRecipe!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Items.IRON_INGOT, (int) (1))) : false)
				|| ((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Items.REDSTONE, (int) (1)))
						: false))) {
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity)
						.unlockRecipes(new ResourceLocation[]{new ResourceLocation("nwtg_automation:machine_block_crafting_recipe")});
			}
		}
		if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.GRASS_BLOCK, (int) (1))) : false)
				|| (((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(GrassBlockSlabLowerBlock.block, (int) (1)))
						: false)
						|| ((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(GrassBlockSlabUpperBlock.block, (int) (1)))
								: false)))) {
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity)
						.unlockRecipes(new ResourceLocation[]{new ResourceLocation("nwtg_automation:lower_grass_block_slab_crafting_recipe_1")});
			}
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity)
						.unlockRecipes(new ResourceLocation[]{new ResourceLocation("nwtg_automation:lower_grass_block_slab_crafting_recipe_2")});
			}
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity)
						.unlockRecipes(new ResourceLocation[]{new ResourceLocation("nwtg_automation:upper_grass_block_slab_crafting_recipe_1")});
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
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
			this.executeProcedure(dependencies);
		}
	}
}
