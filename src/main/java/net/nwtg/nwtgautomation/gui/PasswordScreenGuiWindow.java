
package net.nwtg.nwtgautomation.gui;

import net.nwtg.nwtgautomation.NwtgAutomationModVariables;
import net.nwtg.nwtgautomation.NwtgAutomationMod;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class PasswordScreenGuiWindow extends ContainerScreen<PasswordScreenGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	TextFieldWidget password;
	public PasswordScreenGuiWindow(PasswordScreenGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 80;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		password.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("nwtg_automation:textures/password_menu_screen.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 80, 176, 80);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (password.isFocused())
			return password.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		password.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "PASSWORD REQUIRED", 6, 6, -1);
		this.font.drawString(ms, "OWNER: " + ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgOwner) + "", 6, 16, -6684877);
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
		password = new TextFieldWidget(this.font, this.guiLeft + 6, this.guiTop + 29, 162, 20, new StringTextComponent("Password")) {
			{
				setSuggestion("Password");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("Password");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("Password");
				else
					setSuggestion(null);
			}
		};
		PasswordScreenGui.guistate.put("text:password", password);
		password.setMaxStringLength(32767);
		this.children.add(this.password);
		this.addButton(new Button(this.guiLeft + 51, this.guiTop + 53, 72, 20, new StringTextComponent("SET / ENTER"), e -> {
			if (true) {
				NwtgAutomationMod.PACKET_HANDLER.sendToServer(new PasswordScreenGui.ButtonPressedMessage(0, x, y, z));
				PasswordScreenGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
