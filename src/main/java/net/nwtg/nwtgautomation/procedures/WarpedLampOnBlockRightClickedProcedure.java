package net.nwtg.nwtgautomation.procedures;

import net.nwtg.nwtgautomation.item.MachineWrenchItem;
import net.nwtg.nwtgautomation.block.WarpedLampOnBlock;
import net.nwtg.nwtgautomation.block.WarpedLampBlock;
import net.nwtg.nwtgautomation.NwtgAutomationMod;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import java.util.Map;

public class WarpedLampOnBlockRightClickedProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency entity for procedure WarpedLampOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency x for procedure WarpedLampOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency y for procedure WarpedLampOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency z for procedure WarpedLampOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency world for procedure WarpedLampOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean playTripwireSound = false;
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == MachineWrenchItem.block)) {
			if (((entity.isSneaking()) == (true))) {
				if (((new Object() {
					public boolean getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getBoolean(tag);
						return false;
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "BreakerPanelLinked")) == (true))) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("BreakerPanelLinked", (false));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					playTripwireSound = (boolean) (true);
				}
			} else {
				if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
						.getBoolean("HasSavedPosition")) == (true))) {
					if ((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
							.getString("SavedDevice"))).equals("Breaker Panel"))) {
						if (!world.isRemote()) {
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							TileEntity _tileEntity = world.getTileEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getTileData().putDouble("BreakerPanelX",
										(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
												.getOrCreateTag().getDouble("SavedPosX")));
							if (world instanceof World)
								((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
						}
						if (!world.isRemote()) {
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							TileEntity _tileEntity = world.getTileEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getTileData().putDouble("BreakerPanelY",
										(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
												.getOrCreateTag().getDouble("SavedPosY")));
							if (world instanceof World)
								((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
						}
						if (!world.isRemote()) {
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							TileEntity _tileEntity = world.getTileEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getTileData().putDouble("BreakerPanelZ",
										(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
												.getOrCreateTag().getDouble("SavedPosZ")));
							if (world instanceof World)
								((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
						}
						if (!world.isRemote()) {
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							TileEntity _tileEntity = world.getTileEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getTileData().putBoolean("BreakerPanelLinked", (true));
							if (world instanceof World)
								((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
						}
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
								.putBoolean("HasSavedPosition", (false));
						(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
								.setDisplayName(new StringTextComponent("\u00A7fMachine Wrench"));
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(
									new StringTextComponent((("\u00A7f[\u00A7eAutomation\u00A7f]: \u00A77The Breaker Panel at ") + ""
											+ ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
													.getOrCreateTag().getDouble("SavedPosX")))
											+ "" + (", ") + ""
											+ ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
													.getOrCreateTag().getDouble("SavedPosY")))
											+ "" + (", ") + ""
											+ ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
													.getOrCreateTag().getDouble("SavedPosZ")))
											+ "" + (" \u00A77is now linked to the Oak Lamp."))),
									(false));
						}
						playTripwireSound = (boolean) (true);
					} else {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
									"\u00A7f[\u00A7eAutomation\u00A7f]: \u00A77This block does not support the saved device!"), (false));
						}
					}
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent("\u00A7f[\u00A7eAutomation\u00A7f]: \u00A77This block does link to anything!"), (false));
					}
				}
			}
		} else {
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == WarpedLampBlock.block)) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					BlockState _bs = WarpedLampOnBlock.block.getDefaultState();
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
				playTripwireSound = (boolean) (true);
			} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == WarpedLampOnBlock.block)) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					BlockState _bs = WarpedLampBlock.block.getDefaultState();
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
				playTripwireSound = (boolean) (true);
			}
		}
		if ((playTripwireSound == (true))) {
			if ((!(world.isRemote()))) {
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.tripwire.attach")),
							SoundCategory.BLOCKS, (float) 1, (float) 0.8);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.tripwire.attach")),
							SoundCategory.BLOCKS, (float) 1, (float) 0.8, false);
				}
			}
		}
	}
}
