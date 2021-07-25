package net.nwtg.nwtgautomation.procedures;

import net.nwtg.nwtgautomation.gui.PasswordScreenGui;
import net.nwtg.nwtgautomation.NwtgAutomationModVariables;
import net.nwtg.nwtgautomation.NwtgAutomationModElements;
import net.nwtg.nwtgautomation.NwtgAutomationMod;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import io.netty.buffer.Unpooled;

@NwtgAutomationModElements.ModElement.Tag
public class BreakerPanelScreenSetButtonProcedure extends NwtgAutomationModElements.ModElement {
	public BreakerPanelScreenSetButtonProcedure(NwtgAutomationModElements instance) {
		super(instance, 79);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency entity for procedure BreakerPanelScreenSetButton!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency world for procedure BreakerPanelScreenSetButton!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
		{
			Entity _ent = entity;
			if (_ent instanceof ServerPlayerEntity) {
				BlockPos _bpos = new BlockPos(
						(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosX),
						(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosY),
						(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosZ));
				NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return new StringTextComponent("PasswordScreen");
					}

					@Override
					public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
						return new PasswordScreenGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
	}
}
