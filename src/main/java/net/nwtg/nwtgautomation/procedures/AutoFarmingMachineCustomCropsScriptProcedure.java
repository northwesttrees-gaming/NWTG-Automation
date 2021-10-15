package net.nwtg.nwtgautomation.procedures;

import net.nwtg.nwtgautomation.item.StoneUpgradeItem;
import net.nwtg.nwtgautomation.item.NetheriteUpgradeItem;
import net.nwtg.nwtgautomation.item.IronUpgradeItem;
import net.nwtg.nwtgautomation.item.GoldenUpgradeItem;
import net.nwtg.nwtgautomation.item.DiamondUpgradeItem;
import net.nwtg.nwtgautomation.NwtgAutomationMod;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

public class AutoFarmingMachineCustomCropsScriptProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency x for procedure AutoFarmingMachineCustomCropsScript!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency y for procedure AutoFarmingMachineCustomCropsScript!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency z for procedure AutoFarmingMachineCustomCropsScript!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency world for procedure AutoFarmingMachineCustomCropsScript!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean RunScript = false;
		ItemStack seeds = ItemStack.EMPTY;
		ItemStack crop = ItemStack.EMPTY;
		double posX = 0;
		double posY = 0;
		double posZ = 0;
		double particlePosX = 0;
		double particlePosY = 0;
		double particlePosZ = 0;
		double seedsCount = 0;
		double cropCount = 0;
		double randomNum = 0;
		double ageReset = 0;
		String blockGroup = "";
		String cropGroup = "";
		String seedGroup = "";
		String cropHarvest = "";
		String seedHarvest = "";
		String replacement = "";
		posX = (double) (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "CropPosX"));
		posY = (double) (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "CropPosY"));
		posZ = (double) (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "CropPosZ"));
		particlePosX = (double) (posX + 0.5);
		particlePosY = (double) (posY + 0.5);
		particlePosZ = (double) (posZ + 0.5);
		blockGroup = (String) (new Object() {
			public String getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(world, new BlockPos((int) posX, (int) posY, (int) posZ), "autoFarmingGroupName"));
		cropGroup = (String) ((new Object() {
			public ItemStack getItemStack(BlockPos pos, int sltid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
				}
				return _retval.get();
			}
		}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getOrCreateTag().getString("autoFarmingGroupName"));
		seedGroup = (String) ((new Object() {
			public ItemStack getItemStack(BlockPos pos, int sltid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
				}
				return _retval.get();
			}
		}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getOrCreateTag().getString("autoFarmingGroupName"));
		if ((((blockGroup).equals(seedGroup)) && ((blockGroup).equals(cropGroup)))) {
			cropHarvest = (String) ((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getOrCreateTag().getString("autoFarmingCropHarvestMode"));
			seedHarvest = (String) ((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getOrCreateTag().getString("autoFarmingSeedHarvestMode"));
			seeds = (new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1)));
			crop = (new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2)));
			randomNum = (double) Math.random();
			if (((cropHarvest).equals("berry"))) {
				if ((randomNum <= 0.5)) {
					cropCount = (double) 2;
				} else {
					cropCount = (double) 3;
				}
			} else if (((cropHarvest).equals("cocoa"))) {
				cropCount = (double) 3;
			} else if (((cropHarvest).equals("melon"))) {
				if ((randomNum <= 0.2)) {
					cropCount = (double) 3;
				} else if ((randomNum <= 0.4)) {
					cropCount = (double) 4;
				} else if ((randomNum <= 0.6)) {
					cropCount = (double) 5;
				} else if ((randomNum <= 0.8)) {
					cropCount = (double) 6;
				} else {
					cropCount = (double) 7;
				}
			} else if (((cropHarvest).equals("netherwart"))) {
				if ((randomNum <= 0.33)) {
					cropCount = (double) 2;
				} else if ((randomNum <= 0.66)) {
					cropCount = (double) 3;
				} else {
					cropCount = (double) 4;
				}
			} else if (((cropHarvest).equals("potato"))) {
				if ((randomNum <= 0.078)) {
					cropCount = (double) 0;
				} else if ((randomNum <= 0.393)) {
					cropCount = (double) 1;
				} else if ((randomNum <= 0.813)) {
					cropCount = (double) 2;
				} else {
					cropCount = (double) 3;
				}
				cropCount = (double) (cropCount + 2);
			} else if (((cropHarvest).equals("sugarcane"))) {
				cropCount = (double) 1;
			} else if (((cropHarvest).equals("wheat"))) {
				if ((randomNum <= 0.078)) {
					cropCount = (double) 0;
				} else if ((randomNum <= 0.393)) {
					cropCount = (double) 1;
				} else if ((randomNum <= 0.813)) {
					cropCount = (double) 2;
				} else {
					cropCount = (double) 3;
				}
			} else {
				cropCount = (double) 1;
			}
			randomNum = (double) Math.random();
			if (((seedHarvest).equals("berry"))) {
				if ((randomNum <= 0.5)) {
					seedsCount = (double) 2;
				} else {
					seedsCount = (double) 3;
				}
			} else if (((seedHarvest).equals("cocoa"))) {
				seedsCount = (double) 3;
			} else if (((seedHarvest).equals("melon"))) {
				if ((randomNum <= 0.2)) {
					seedsCount = (double) 3;
				} else if ((randomNum <= 0.4)) {
					seedsCount = (double) 4;
				} else if ((randomNum <= 0.6)) {
					seedsCount = (double) 5;
				} else if ((randomNum <= 0.8)) {
					seedsCount = (double) 6;
				} else {
					seedsCount = (double) 7;
				}
			} else if (((seedHarvest).equals("netherwart"))) {
				if ((randomNum <= 0.33)) {
					seedsCount = (double) 2;
				} else if ((randomNum <= 0.66)) {
					seedsCount = (double) 3;
				} else {
					seedsCount = (double) 4;
				}
			} else if (((seedHarvest).equals("potato"))) {
				if ((randomNum <= 0.078)) {
					seedsCount = (double) 0;
				} else if ((randomNum <= 0.393)) {
					seedsCount = (double) 1;
				} else if ((randomNum <= 0.813)) {
					seedsCount = (double) 2;
				} else {
					seedsCount = (double) 3;
				}
				seedsCount = (double) (seedsCount + 2);
			} else if (((seedHarvest).equals("sugarcane"))) {
				seedsCount = (double) 1;
			} else if (((seedHarvest).equals("wheat"))) {
				if ((randomNum <= 0.078)) {
					seedsCount = (double) 0;
				} else if ((randomNum <= 0.393)) {
					seedsCount = (double) 1;
				} else if ((randomNum <= 0.813)) {
					seedsCount = (double) 2;
				} else {
					seedsCount = (double) 3;
				}
			} else {
				seedsCount = (double) 1;
			}
			if ((((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getOrCreateTag()
					.getBoolean("autoFarmingSeedBonusYield")) == (true))) {
				if ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == StoneUpgradeItem.block) || ((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == IronUpgradeItem.block))) {
					seedsCount = (double) (seedsCount + 1);
				} else if ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == GoldenUpgradeItem.block) || ((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == DiamondUpgradeItem.block))) {
					seedsCount = (double) (seedsCount + 2);
				} else if (((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == NetheriteUpgradeItem.block)) {
					seedsCount = (double) (seedsCount + 3);
				}
			}
			if ((((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getOrCreateTag()
					.getBoolean("autoFarmingCropBonusYield")) == (true))) {
				if ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == StoneUpgradeItem.block) || ((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == IronUpgradeItem.block))) {
					cropCount = (double) (cropCount + 1);
				} else if ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == GoldenUpgradeItem.block) || ((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == DiamondUpgradeItem.block))) {
					cropCount = (double) (cropCount + 2);
				} else if (((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == NetheriteUpgradeItem.block)) {
					cropCount = (double) (cropCount + 3);
				}
			}
			if (((((new Object() {
				public int getAmount(IWorld world, BlockPos pos, int sltid) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).getCount());
						});
					}
					return _retval.get();
				}
			}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (1))) > 0) && (((new Object() {
				public int getAmount(IWorld world, BlockPos pos, int sltid) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).getCount());
						});
					}
					return _retval.get();
				}
			}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (1))) <= (64 - seedsCount)) && ((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == (seeds).getItem()))) && (((new Object() {
				public int getAmount(IWorld world, BlockPos pos, int sltid) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).getCount());
						});
					}
					return _retval.get();
				}
			}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (2))) > 0) && (((new Object() {
				public int getAmount(IWorld world, BlockPos pos, int sltid) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).getCount());
						});
					}
					return _retval.get();
				}
			}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (2))) <= (64 - cropCount)) && ((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == (crop).getItem()))))) {
				replacement = (String) ((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getOrCreateTag().getString("autoFarmingReplaceMode"));
				if (((replacement).equals("air"))) {
					{
						BlockPos _bp = new BlockPos((int) posX, (int) posY, (int) posZ);
						BlockState _bs = Blocks.AIR.getDefaultState();
						world.setBlockState(_bp, _bs, 3);
					}
				} else if (((replacement).equals("stage"))) {
					ageReset = (double) ((new Object() {
						public ItemStack getItemStack(BlockPos pos, int sltid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
							}
							return _retval.get();
						}
					}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getOrCreateTag().getDouble("autoFarmingAgeReset"));
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) posX, (int) posY, (int) posZ);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("autoFarmingAge", ageReset);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				} else if (((replacement).equals("water"))) {
					{
						BlockPos _bp = new BlockPos((int) posX, (int) posY, (int) posZ);
						BlockState _bs = Blocks.WATER.getDefaultState();
						world.setBlockState(_bp, _bs, 3);
					}
				} else {
					{
						BlockPos _bp = new BlockPos((int) posX, (int) posY, (int) posZ);
						BlockState _bs = Blocks.AIR.getDefaultState();
						world.setBlockState(_bp, _bs, 3);
					}
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							(((("particle nwtg_automation:farming_particle ") + ""
									+ ((((((new java.text.DecimalFormat("##.##").format(particlePosX))) + "" + (" "))) + ""
											+ ((((new java.text.DecimalFormat("##.##").format(particlePosY))) + "" + (" "))) + ""
											+ ((((new java.text.DecimalFormat("##.##").format(particlePosZ))) + "" + (" ")))))
									+ "" + ("0.33 0.33 0.33 ") + "" + ("0 8 ")))
									+ ""
									+ ((("force @a[") + "" + ("x=") + "" + ((new java.text.DecimalFormat("##.##").format((particlePosX - 30)))) + ""
											+ (",y=") + "" + ((new java.text.DecimalFormat("##.##").format((particlePosY - 30)))) + "" + (",z=") + ""
											+ ((new java.text.DecimalFormat("##.##").format((particlePosZ - 30)))) + "" + (",dx=") + ""
											+ ((new java.text.DecimalFormat("##").format(61))) + "" + (",dy=") + ""
											+ ((new java.text.DecimalFormat("##").format(61))) + "" + (",dz=") + ""
											+ ((new java.text.DecimalFormat("##").format(61))) + "" + ("]")))));
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (1);
						final ItemStack _setstack = (seeds);
						_setstack.setCount((int) ((new Object() {
							public int getAmount(IWorld world, BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (1))) + seedsCount));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (2);
						final ItemStack _setstack = (crop);
						_setstack.setCount((int) ((new Object() {
							public int getAmount(IWorld world, BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (2))) + cropCount));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				RunScript = (boolean) (true);
			}
			if ((RunScript == (true))) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("HarvestCrop", (false));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		} else if (((blockGroup).equals(seedGroup))) {
			seedHarvest = (String) ((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getOrCreateTag().getString("autoFarmingSeedHarvestMode"));
			seeds = (new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1)));
			randomNum = (double) Math.random();
			if (((seedHarvest).equals("berry"))) {
				if ((randomNum <= 0.5)) {
					seedsCount = (double) 2;
				} else {
					seedsCount = (double) 3;
				}
			} else if (((seedHarvest).equals("cocoa"))) {
				seedsCount = (double) 3;
			} else if (((seedHarvest).equals("melon"))) {
				if ((randomNum <= 0.2)) {
					seedsCount = (double) 3;
				} else if ((randomNum <= 0.4)) {
					seedsCount = (double) 4;
				} else if ((randomNum <= 0.6)) {
					seedsCount = (double) 5;
				} else if ((randomNum <= 0.8)) {
					seedsCount = (double) 6;
				} else {
					seedsCount = (double) 7;
				}
			} else if (((seedHarvest).equals("netherwart"))) {
				if ((randomNum <= 0.33)) {
					seedsCount = (double) 2;
				} else if ((randomNum <= 0.66)) {
					seedsCount = (double) 3;
				} else {
					seedsCount = (double) 4;
				}
			} else if (((seedHarvest).equals("potato"))) {
				if ((randomNum <= 0.078)) {
					seedsCount = (double) 0;
				} else if ((randomNum <= 0.393)) {
					seedsCount = (double) 1;
				} else if ((randomNum <= 0.813)) {
					seedsCount = (double) 2;
				} else {
					seedsCount = (double) 3;
				}
				seedsCount = (double) (seedsCount + 2);
			} else if (((seedHarvest).equals("sugarcane"))) {
				seedsCount = (double) 1;
			} else if (((seedHarvest).equals("wheat"))) {
				if ((randomNum <= 0.078)) {
					seedsCount = (double) 0;
				} else if ((randomNum <= 0.393)) {
					seedsCount = (double) 1;
				} else if ((randomNum <= 0.813)) {
					seedsCount = (double) 2;
				} else {
					seedsCount = (double) 3;
				}
			} else {
				seedsCount = (double) 1;
			}
			if ((((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getOrCreateTag()
					.getBoolean("autoFarmingSeedBonusYield")) == (true))) {
				if ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == StoneUpgradeItem.block) || ((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == IronUpgradeItem.block))) {
					seedsCount = (double) (seedsCount + 1);
				} else if ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == GoldenUpgradeItem.block) || ((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == DiamondUpgradeItem.block))) {
					seedsCount = (double) (seedsCount + 2);
				} else if (((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == NetheriteUpgradeItem.block)) {
					seedsCount = (double) (seedsCount + 3);
				}
			}
			if ((((new Object() {
				public int getAmount(IWorld world, BlockPos pos, int sltid) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).getCount());
						});
					}
					return _retval.get();
				}
			}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (1))) > 0) && (((new Object() {
				public int getAmount(IWorld world, BlockPos pos, int sltid) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).getCount());
						});
					}
					return _retval.get();
				}
			}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (1))) <= (64 - seedsCount)) && ((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == (seeds).getItem())))) {
				replacement = (String) ((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getOrCreateTag().getString("autoFarmingReplaceMode"));
				if (((replacement).equals("air"))) {
					{
						BlockPos _bp = new BlockPos((int) posX, (int) posY, (int) posZ);
						BlockState _bs = Blocks.AIR.getDefaultState();
						world.setBlockState(_bp, _bs, 3);
					}
				} else if (((replacement).equals("stage"))) {
					ageReset = (double) ((new Object() {
						public ItemStack getItemStack(BlockPos pos, int sltid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
							}
							return _retval.get();
						}
					}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getOrCreateTag().getDouble("autoFarmingAgeReset"));
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) posX, (int) posY, (int) posZ);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("autoFarmingAge", ageReset);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				} else if (((replacement).equals("water"))) {
					{
						BlockPos _bp = new BlockPos((int) posX, (int) posY, (int) posZ);
						BlockState _bs = Blocks.WATER.getDefaultState();
						world.setBlockState(_bp, _bs, 3);
					}
				} else {
					{
						BlockPos _bp = new BlockPos((int) posX, (int) posY, (int) posZ);
						BlockState _bs = Blocks.AIR.getDefaultState();
						world.setBlockState(_bp, _bs, 3);
					}
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							(((("particle nwtg_automation:farming_particle ") + ""
									+ ((((((new java.text.DecimalFormat("##.##").format(particlePosX))) + "" + (" "))) + ""
											+ ((((new java.text.DecimalFormat("##.##").format(particlePosY))) + "" + (" "))) + ""
											+ ((((new java.text.DecimalFormat("##.##").format(particlePosZ))) + "" + (" ")))))
									+ "" + ("0.33 0.33 0.33 ") + "" + ("0 8 ")))
									+ ""
									+ ((("force @a[") + "" + ("x=") + "" + ((new java.text.DecimalFormat("##.##").format((particlePosX - 30)))) + ""
											+ (",y=") + "" + ((new java.text.DecimalFormat("##.##").format((particlePosY - 30)))) + "" + (",z=") + ""
											+ ((new java.text.DecimalFormat("##.##").format((particlePosZ - 30)))) + "" + (",dx=") + ""
											+ ((new java.text.DecimalFormat("##").format(61))) + "" + (",dy=") + ""
											+ ((new java.text.DecimalFormat("##").format(61))) + "" + (",dz=") + ""
											+ ((new java.text.DecimalFormat("##").format(61))) + "" + ("]")))));
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (1);
						final ItemStack _setstack = (seeds);
						_setstack.setCount((int) ((new Object() {
							public int getAmount(IWorld world, BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (1))) + seedsCount));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				RunScript = (boolean) (true);
			}
			if ((RunScript == (true))) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("HarvestCrop", (false));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putBoolean("HarvestCrop", (false));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
	}
}
