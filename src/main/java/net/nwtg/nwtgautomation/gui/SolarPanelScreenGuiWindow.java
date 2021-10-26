
package net.nwtg.nwtgautomation.gui;

import net.nwtg.nwtgautomation.procedures.SolarPanelScreenRedLightConditionProcedure;
import net.nwtg.nwtgautomation.procedures.SolarPanelSceenGreenLightConditionProcedure;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@OnlyIn(Dist.CLIENT)
public class SolarPanelScreenGuiWindow extends ContainerScreen<SolarPanelScreenGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = SolarPanelScreenGui.guistate;
	public SolarPanelScreenGuiWindow(SolarPanelScreenGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("nwtg_automation:textures/solar_panel_gui.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 33, 0, 0, 176, 100, 176, 100);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("nwtg_automation:textures/upgrade_box_gui.png"));
		this.blit(ms, this.guiLeft + 181, this.guiTop + 61, 0, 0, 32, 32, 32, 32);
		if (SolarPanelScreenRedLightConditionProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("nwtg_automation:textures/red_light.png"));
			this.blit(ms, this.guiLeft + 165, this.guiTop + 39, 0, 0, 5, 5, 5, 5);
		}
		if (SolarPanelSceenGreenLightConditionProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("nwtg_automation:textures/green_light.png"));
			this.blit(ms, this.guiLeft + 165, this.guiTop + 39, 0, 0, 5, 5, 5, 5);
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
		this.font.drawString(ms, "Solar Panel", 7, 39, -1);
		this.font.drawString(ms, "AE: " + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "Energy")) + "", 97, 39, -16711681);
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
