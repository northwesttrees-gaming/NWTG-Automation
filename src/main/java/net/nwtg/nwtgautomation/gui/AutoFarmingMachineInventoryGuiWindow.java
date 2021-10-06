
package net.nwtg.nwtgautomation.gui;

import net.nwtg.nwtgautomation.procedures.MachineStateOnConditionProcedure;
import net.nwtg.nwtgautomation.procedures.MachineStateOffConditionProcedure;
import net.nwtg.nwtgautomation.procedures.MachineProcessWorkingConditionProcedure;
import net.nwtg.nwtgautomation.procedures.MachineProcessNoneConditionProcedure;
import net.nwtg.nwtgautomation.procedures.MachineProcessIdleConditionProcedure;
import net.nwtg.nwtgautomation.procedures.AutoFarmingMachineProgress9ConditionProcedure;
import net.nwtg.nwtgautomation.procedures.AutoFarmingMachineProgress8ConditionProcedure;
import net.nwtg.nwtgautomation.procedures.AutoFarmingMachineProgress7ConditionProcedure;
import net.nwtg.nwtgautomation.procedures.AutoFarmingMachineProgress6ConditionProcedure;
import net.nwtg.nwtgautomation.procedures.AutoFarmingMachineProgress5ConditionProcedure;
import net.nwtg.nwtgautomation.procedures.AutoFarmingMachineProgress4ConditionProcedure;
import net.nwtg.nwtgautomation.procedures.AutoFarmingMachineProgress3ConditionProcedure;
import net.nwtg.nwtgautomation.procedures.AutoFarmingMachineProgress2ConditionProcedure;
import net.nwtg.nwtgautomation.procedures.AutoFarmingMachineProgress1ConditionProcedure;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@OnlyIn(Dist.CLIENT)
public class AutoFarmingMachineInventoryGuiWindow extends ContainerScreen<AutoFarmingMachineInventoryGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = AutoFarmingMachineInventoryGui.guistate;
	public AutoFarmingMachineInventoryGuiWindow(AutoFarmingMachineInventoryGui.GuiContainerMod container, PlayerInventory inventory,
			ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("nwtg_automation:textures/auto_farming_machine_gui.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 20, 0, 0, 176, 126, 176, 126);
		if (MachineProcessWorkingConditionProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("nwtg_automation:textures/green_light.png"));
			this.blit(ms, this.guiLeft + 156, this.guiTop + 26, 0, 0, 5, 5, 5, 5);
		}
		if (MachineStateOnConditionProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("nwtg_automation:textures/green_light.png"));
			this.blit(ms, this.guiLeft + 165, this.guiTop + 26, 0, 0, 5, 5, 5, 5);
		}
		if (MachineProcessNoneConditionProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("nwtg_automation:textures/red_light.png"));
			this.blit(ms, this.guiLeft + 156, this.guiTop + 26, 0, 0, 5, 5, 5, 5);
		}
		if (MachineStateOffConditionProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("nwtg_automation:textures/red_light.png"));
			this.blit(ms, this.guiLeft + 165, this.guiTop + 26, 0, 0, 5, 5, 5, 5);
		}
		if (MachineProcessIdleConditionProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("nwtg_automation:textures/yellow_light.png"));
			this.blit(ms, this.guiLeft + 156, this.guiTop + 26, 0, 0, 5, 5, 5, 5);
		}
		if (AutoFarmingMachineProgress9ConditionProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("nwtg_automation:textures/auto_farming_machine_progress_bar_1.png"));
			this.blit(ms, this.guiLeft + 81, this.guiTop + 37, 0, 0, 15, 16, 15, 16);
		}
		if (AutoFarmingMachineProgress8ConditionProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("nwtg_automation:textures/auto_farming_machine_progress_bar_2.png"));
			this.blit(ms, this.guiLeft + 81, this.guiTop + 37, 0, 0, 15, 16, 15, 16);
		}
		if (AutoFarmingMachineProgress7ConditionProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("nwtg_automation:textures/auto_farming_machine_progress_bar_3.png"));
			this.blit(ms, this.guiLeft + 81, this.guiTop + 37, 0, 0, 15, 16, 15, 16);
		}
		if (AutoFarmingMachineProgress6ConditionProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("nwtg_automation:textures/auto_farming_machine_progress_bar_4.png"));
			this.blit(ms, this.guiLeft + 81, this.guiTop + 37, 0, 0, 15, 16, 15, 16);
		}
		if (AutoFarmingMachineProgress5ConditionProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("nwtg_automation:textures/auto_farming_machine_progress_bar_5.png"));
			this.blit(ms, this.guiLeft + 81, this.guiTop + 37, 0, 0, 15, 16, 15, 16);
		}
		if (AutoFarmingMachineProgress4ConditionProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("nwtg_automation:textures/auto_farming_machine_progress_bar_6.png"));
			this.blit(ms, this.guiLeft + 81, this.guiTop + 37, 0, 0, 15, 16, 15, 16);
		}
		if (AutoFarmingMachineProgress3ConditionProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("nwtg_automation:textures/auto_farming_machine_progress_bar_7.png"));
			this.blit(ms, this.guiLeft + 81, this.guiTop + 37, 0, 0, 15, 16, 15, 16);
		}
		if (AutoFarmingMachineProgress2ConditionProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("nwtg_automation:textures/auto_farming_machine_progress_bar_8.png"));
			this.blit(ms, this.guiLeft + 81, this.guiTop + 37, 0, 0, 15, 16, 15, 16);
		}
		if (AutoFarmingMachineProgress1ConditionProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("nwtg_automation:textures/auto_farming_machine_progress_bar_9.png"));
			this.blit(ms, this.guiLeft + 81, this.guiTop + 37, 0, 0, 15, 16, 15, 16);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Auto Farming Machine", 6, 24, -1);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
	}
}
