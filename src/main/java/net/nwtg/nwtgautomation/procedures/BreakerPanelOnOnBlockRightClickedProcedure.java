package net.nwtg.nwtgautomation.procedures;

import net.nwtg.nwtgautomation.item.MachineWrenchItem;
import net.nwtg.nwtgautomation.gui.PasswordScreenGui;
import net.nwtg.nwtgautomation.gui.BreakerPanelScreenGui;
import net.nwtg.nwtgautomation.NwtgAutomationModVariables;
import net.nwtg.nwtgautomation.NwtgAutomationModElements;
import net.nwtg.nwtgautomation.NwtgAutomationMod;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import java.util.Map;

import io.netty.buffer.Unpooled;

@NwtgAutomationModElements.ModElement.Tag
public class BreakerPanelOnOnBlockRightClickedProcedure extends NwtgAutomationModElements.ModElement {
	public BreakerPanelOnOnBlockRightClickedProcedure(NwtgAutomationModElements instance) {
		super(instance, 74);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("direction") == null) {
			if (!dependencies.containsKey("direction"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency direction for procedure BreakerPanelOnOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency entity for procedure BreakerPanelOnOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency x for procedure BreakerPanelOnOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency y for procedure BreakerPanelOnOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency z for procedure BreakerPanelOnOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency world for procedure BreakerPanelOnOnBlockRightClicked!");
			return;
		}
		Direction direction = (Direction) dependencies.get("direction");
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((entity.hasPermissionLevel((int) 3))
				&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(Items.NAME_TAG, (int) (1)).getItem()))) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putString("Owner",
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getDisplayName()
									.getString()));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("\u00A7e[NWTG Automation]: \u00A7fOwner has been set to: \u00A79")
						+ "" + ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getDisplayName()
								.getString())))),
						(false));
			}
		} else {
			if ((((new Object() {
				public String getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "Owner"))).equals((entity.getDisplayName().getString())))) {
				if ((entity.isSneaking())) {
					{
						String _setval = (String) (new Object() {
							public String getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getString(tag);
								return "";
							}
						}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "Owner"));
						entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.nwtgOwner = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = (String) (new Object() {
							public String getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getString(tag);
								return "";
							}
						}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "Password"));
						entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.nwtgPassword = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (double) x;
						entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.nwtgPosX = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (double) y;
						entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.nwtgPosY = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (double) z;
						entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.nwtgPosZ = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
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
				} else {
					if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == new ItemStack(MachineWrenchItem.block, (int) (1)).getItem())
							&& ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
									.getBoolean("HasSavedPosition")) == (false)))) {
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
								.putDouble("SavedPosX", x);
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
								.putDouble("SavedPosY", y);
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
								.putDouble("SavedPosZ", z);
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
								.putBoolean("HasSavedPosition", (true));
						(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
								.setDisplayName(new StringTextComponent((("Breaker Panel: [ \u00A7cX: ") + ""
										+ ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
												.getOrCreateTag().getDouble("SavedPosX")))
										+ "" + ("\u00A7f, \u00A7aY: ") + ""
										+ ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
												.getOrCreateTag().getDouble("SavedPosY")))
										+ "" + ("\u00A7f, \u00A79Z: ") + ""
										+ ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
												.getOrCreateTag().getDouble("SavedPosZ")))
										+ "" + (" \u00A7f]"))));
					} else {
						if (((((new Object() {
							public Direction getDirection(BlockPos pos) {
								try {
									BlockState _bs = world.getBlockState(pos);
									DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
									if (property != null)
										return _bs.get(property);
									return Direction.getFacingFromAxisDirection(
											_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
											Direction.AxisDirection.POSITIVE);
								} catch (Exception e) {
									return Direction.NORTH;
								}
							}
						}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.NORTH) || ((new Object() {
							public Direction getDirection(BlockPos pos) {
								try {
									BlockState _bs = world.getBlockState(pos);
									DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
									if (property != null)
										return _bs.get(property);
									return Direction.getFacingFromAxisDirection(
											_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
											Direction.AxisDirection.POSITIVE);
								} catch (Exception e) {
									return Direction.NORTH;
								}
							}
						}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.SOUTH))
								&& ((direction == Direction.NORTH) || (direction == Direction.SOUTH)))) {
							if (!world.isRemote()) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putBoolean("IsBlockOn", (false));
								if (world instanceof World)
									((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
						} else if (((((new Object() {
							public Direction getDirection(BlockPos pos) {
								try {
									BlockState _bs = world.getBlockState(pos);
									DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
									if (property != null)
										return _bs.get(property);
									return Direction.getFacingFromAxisDirection(
											_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
											Direction.AxisDirection.POSITIVE);
								} catch (Exception e) {
									return Direction.NORTH;
								}
							}
						}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.EAST) || ((new Object() {
							public Direction getDirection(BlockPos pos) {
								try {
									BlockState _bs = world.getBlockState(pos);
									DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
									if (property != null)
										return _bs.get(property);
									return Direction.getFacingFromAxisDirection(
											_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
											Direction.AxisDirection.POSITIVE);
								} catch (Exception e) {
									return Direction.NORTH;
								}
							}
						}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.WEST))
								&& ((direction == Direction.EAST) || (direction == Direction.WEST)))) {
							if (!world.isRemote()) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putBoolean("IsBlockOn", (false));
								if (world instanceof World)
									((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
						}
					}
				}
			} else {
				if ((((new Object() {
					public String getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getString(tag);
						return "";
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "PasswordState"))).equals("ENABLED"))) {
					if ((entity.isSneaking())) {
						{
							String _setval = (String) (new Object() {
								public String getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getString(tag);
									return "";
								}
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "Owner"));
							entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.nwtgOwner = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (String) (new Object() {
								public String getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getString(tag);
									return "";
								}
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "Password"));
							entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.nwtgPassword = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (double) x;
							entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.nwtgPosX = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (double) y;
							entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.nwtgPosY = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (double) z;
							entity.getCapability(NwtgAutomationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.nwtgPosZ = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							Entity _ent = entity;
							if (_ent instanceof ServerPlayerEntity) {
								BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
								NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
									@Override
									public ITextComponent getDisplayName() {
										return new StringTextComponent("PasswordScreen");
									}

									@Override
									public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
										return new PasswordScreenGui.GuiContainerMod(id, inventory,
												new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
									}
								}, _bpos);
							}
						}
					}
				} else {
					if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == new ItemStack(MachineWrenchItem.block, (int) (1)).getItem())
							&& ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
									.getBoolean("HasSavedPosition")) == (false)))) {
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
								.putDouble("SavedPosX", x);
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
								.putDouble("SavedPosY", y);
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
								.putDouble("SavedPosZ", z);
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
								.putBoolean("HasSavedPosition", (true));
						(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
								.setDisplayName(new StringTextComponent((("Breaker Panel: [ \u00A7cX: ") + ""
										+ ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
												.getOrCreateTag().getDouble("SavedPosX")))
										+ "" + ("\u00A7f, \u00A7aY: ") + ""
										+ ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
												.getOrCreateTag().getDouble("SavedPosY")))
										+ "" + ("\u00A7f, \u00A79Z: ") + ""
										+ ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
												.getOrCreateTag().getDouble("SavedPosZ")))
										+ "" + (" \u00A7f]"))));
					} else {
						if (((((new Object() {
							public Direction getDirection(BlockPos pos) {
								try {
									BlockState _bs = world.getBlockState(pos);
									DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
									if (property != null)
										return _bs.get(property);
									return Direction.getFacingFromAxisDirection(
											_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
											Direction.AxisDirection.POSITIVE);
								} catch (Exception e) {
									return Direction.NORTH;
								}
							}
						}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.NORTH) || ((new Object() {
							public Direction getDirection(BlockPos pos) {
								try {
									BlockState _bs = world.getBlockState(pos);
									DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
									if (property != null)
										return _bs.get(property);
									return Direction.getFacingFromAxisDirection(
											_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
											Direction.AxisDirection.POSITIVE);
								} catch (Exception e) {
									return Direction.NORTH;
								}
							}
						}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.SOUTH))
								&& ((direction == Direction.NORTH) || (direction == Direction.SOUTH)))) {
							if (!world.isRemote()) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putBoolean("IsBlockOn", (false));
								if (world instanceof World)
									((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
						} else if (((((new Object() {
							public Direction getDirection(BlockPos pos) {
								try {
									BlockState _bs = world.getBlockState(pos);
									DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
									if (property != null)
										return _bs.get(property);
									return Direction.getFacingFromAxisDirection(
											_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
											Direction.AxisDirection.POSITIVE);
								} catch (Exception e) {
									return Direction.NORTH;
								}
							}
						}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.EAST) || ((new Object() {
							public Direction getDirection(BlockPos pos) {
								try {
									BlockState _bs = world.getBlockState(pos);
									DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
									if (property != null)
										return _bs.get(property);
									return Direction.getFacingFromAxisDirection(
											_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
											Direction.AxisDirection.POSITIVE);
								} catch (Exception e) {
									return Direction.NORTH;
								}
							}
						}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.WEST))
								&& ((direction == Direction.EAST) || (direction == Direction.WEST)))) {
							if (!world.isRemote()) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putBoolean("IsBlockOn", (false));
								if (world instanceof World)
									((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
						}
					}
				}
			}
		}
	}
}
