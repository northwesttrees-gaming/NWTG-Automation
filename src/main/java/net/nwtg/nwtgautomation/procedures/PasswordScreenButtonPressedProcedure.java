package net.nwtg.nwtgautomation.procedures;

import net.nwtg.nwtgautomation.gui.BreakerPanelScreenGui;
import net.nwtg.nwtgautomation.block.BreakerPanelOnBlock;
import net.nwtg.nwtgautomation.block.BreakerPanelBlock;
import net.nwtg.nwtgautomation.NwtgAutomationModVariables;
import net.nwtg.nwtgautomation.NwtgAutomationModElements;
import net.nwtg.nwtgautomation.NwtgAutomationMod;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.state.Property;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.HashMap;

import io.netty.buffer.Unpooled;

@NwtgAutomationModElements.ModElement.Tag
public class PasswordScreenButtonPressedProcedure extends NwtgAutomationModElements.ModElement {
	public PasswordScreenButtonPressedProcedure(NwtgAutomationModElements instance) {
		super(instance, 77);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency entity for procedure PasswordScreenButtonPressed!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency guistate for procedure PasswordScreenButtonPressed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency world for procedure PasswordScreenButtonPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		IWorld world = (IWorld) dependencies.get("world");
		if ((BlockTags.getCollection()
				.getTagByID(new ResourceLocation(("forge:nwtg_automation/blocks/breaker_panel").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos(
						(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosX),
						(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosY),
						(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosZ)))).getBlock()))) {
			if ((((entity.getDisplayName().getString())).equals((new Object() {
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
					"Owner"))))) {
				if ((((new Object() {
					public String getText() {
						TextFieldWidget textField = (TextFieldWidget) guistate.get("text:password");
						if (textField != null) {
							return textField.getText();
						}
						return "";
					}
				}.getText())).length() > 0)) {
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
							_tileEntity.getTileData().putString("Password", (new Object() {
								public String getText() {
									TextFieldWidget textField = (TextFieldWidget) guistate.get("text:password");
									if (textField != null) {
										return textField.getText();
									}
									return "";
								}
							}.getText()));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
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
									return new StringTextComponent("BreakerPanelScreen");
								}

								@Override
								public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
									return new BreakerPanelScreenGui.GuiContainerMod(id, inventory,
											new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
								}
							}, _bpos);
						}
					}
				}
			} else {
				if (((((new Object() {
					public String getText() {
						TextFieldWidget textField = (TextFieldWidget) guistate.get("text:password");
						if (textField != null) {
							return textField.getText();
						}
						return "";
					}
				}.getText())).equals((new Object() {
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
						"Password")))) && (((new Object() {
							public String getText() {
								TextFieldWidget textField = (TextFieldWidget) guistate.get("text:password");
								if (textField != null) {
									return textField.getText();
								}
								return "";
							}
						}.getText())).length() > 0))) {
					if (((world.getBlockState(new BlockPos(
							(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosX),
							(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosY),
							(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosZ))))
											.getBlock() == BreakerPanelBlock.block.getDefaultState().getBlock())) {
						{
							BlockPos _bp = new BlockPos(
									(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosX),
									(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosY),
									(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosY));
							BlockState _bs = BreakerPanelOnBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_property != null && _bs.get(_property) != null)
									try {
										_bs = _bs.with(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							TileEntity _te = world.getTileEntity(_bp);
							CompoundNBT _bnbt = null;
							if (_te != null) {
								_bnbt = _te.write(new CompoundNBT());
								_te.remove();
							}
							world.setBlockState(_bp, _bs, 3);
							if (_bnbt != null) {
								_te = world.getTileEntity(_bp);
								if (_te != null) {
									try {
										_te.read(_bso, _bnbt);
									} catch (Exception ignored) {
									}
								}
							}
						}
						{
							TileEntity _ent = world.getTileEntity(new BlockPos(
									(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosX),
									(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosY),
									(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosZ)));
							if (_ent != null) {
								final int _sltid = (int) (0);
								final ItemStack _setstack = new ItemStack(Items.SNOWBALL, (int) (1));
								_setstack.setCount((int) 1);
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
					} else if (((world.getBlockState(new BlockPos(
							(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosX),
							(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosY),
							(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosZ))))
											.getBlock() == BreakerPanelOnBlock.block.getDefaultState().getBlock())) {
						{
							BlockPos _bp = new BlockPos(
									(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosX),
									(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosY),
									(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosY));
							BlockState _bs = BreakerPanelBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_property != null && _bs.get(_property) != null)
									try {
										_bs = _bs.with(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							TileEntity _te = world.getTileEntity(_bp);
							CompoundNBT _bnbt = null;
							if (_te != null) {
								_bnbt = _te.write(new CompoundNBT());
								_te.remove();
							}
							world.setBlockState(_bp, _bs, 3);
							if (_bnbt != null) {
								_te = world.getTileEntity(_bp);
								if (_te != null) {
									try {
										_te.read(_bso, _bnbt);
									} catch (Exception ignored) {
									}
								}
							}
						}
						{
							TileEntity _ent = world.getTileEntity(new BlockPos(
									(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosX),
									(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosY),
									(int) ((entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NwtgAutomationModVariables.PlayerVariables())).nwtgPosZ)));
							if (_ent != null) {
								final int _sltid = (int) (0);
								final ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
								_setstack.setCount((int) 1);
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).closeScreen();
				}
			}
		}
	}
}
