package net.nwtg.nwtgautomation.procedures;

import net.nwtg.nwtgautomation.NwtgAutomationModElements;
import net.nwtg.nwtgautomation.NwtgAutomationMod;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BlockItem;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

@NwtgAutomationModElements.ModElement.Tag
public class AutoTreeFarmMachineOnMainScriptProcedure extends NwtgAutomationModElements.ModElement {
	public AutoTreeFarmMachineOnMainScriptProcedure(NwtgAutomationModElements instance) {
		super(instance, 276);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency x for procedure AutoTreeFarmMachineOnMainScript!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency y for procedure AutoTreeFarmMachineOnMainScript!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency z for procedure AutoTreeFarmMachineOnMainScript!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NwtgAutomationMod.LOGGER.warn("Failed to load dependency world for procedure AutoTreeFarmMachineOnMainScript!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double posX = 0;
		double posY = 0;
		double posZ = 0;
		boolean stopScript = false;
		posX = (double) (x - 8);
		posY = (double) y;
		posZ = (double) (z - 8);
		for (int index0 = 0; index0 < (int) (32); index0++) {
			for (int index1 = 0; index1 < (int) (17); index1++) {
				for (int index2 = 0; index2 < (int) (17); index2++) {
					if (((ItemTags.getCollection()
							.getTagByID(
									new ResourceLocation(("forge:nwtg_automation/items/auto_tree_farm/logs").toLowerCase(java.util.Locale.ENGLISH)))
							.contains((new Object() {
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
							}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem())) && (ItemTags.getCollection()
									.getTagByID(new ResourceLocation(
											("forge:nwtg_automation/items/auto_tree_farm/leaves").toLowerCase(java.util.Locale.ENGLISH)))
									.contains((new Object() {
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
									}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem())))) {
						if (((BlockTags.getCollection()
								.getTagByID(new ResourceLocation(
										("forge:nwtg_automation/blocks/auto_tree_farm/logs").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ)))).getBlock()))
								&& ((world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
										.getBlock() == /* @BlockState */(new Object() {
											public BlockState toBlock(ItemStack _stk) {
												if (_stk.getItem() instanceof BlockItem) {
													return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
												}
												return Blocks.AIR.getDefaultState();
											}
										}.toBlock((new Object() {
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
										}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))))).getBlock()))) {
							if (((!((new Object() {
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
							}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == new ItemStack(Blocks.AIR, (int) (1))
									.getItem()))
									&& ((BlockTags.getCollection()
											.getTagByID(new ResourceLocation(
													("forge:nwtg_automation/blocks/auto_tree_farm/soil").toLowerCase(java.util.Locale.ENGLISH)))
											.contains((world.getBlockState(new BlockPos((int) (posX), (int) ((posY) - 1), (int) (posZ)))).getBlock()))
											&& (ItemTags.getCollection().getTagByID(new ResourceLocation(
													("forge:nwtg_automation/items/auto_tree_farm/saplings").toLowerCase(java.util.Locale.ENGLISH)))
													.contains((new Object() {
														public ItemStack getItemStack(BlockPos pos, int sltid) {
															AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
															TileEntity _ent = world.getTileEntity(pos);
															if (_ent != null) {
																_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																		.ifPresent(capability -> {
																			_retval.set(capability.getStackInSlot(sltid).copy());
																		});
															}
															return _retval.get();
														}
													}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem()))))) {
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
								}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2)))
										.getItem() == new ItemStack(Blocks.WARPED_FUNGUS, (int) (1)).getItem()) && (((new Object() {
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
										}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3)))
												.getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()) || (((new Object() {
													public ItemStack getItemStack(BlockPos pos, int sltid) {
														AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
														TileEntity _ent = world.getTileEntity(pos);
														if (_ent != null) {
															_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																	.ifPresent(capability -> {
																		_retval.set(capability.getStackInSlot(sltid).copy());
																	});
														}
														return _retval.get();
													}
												}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == (new ItemStack(
														(world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ)))).getBlock()))
																.getItem())
														&& ((new Object() {
															public int getAmount(IWorld world, BlockPos pos, int sltid) {
																AtomicInteger _retval = new AtomicInteger(0);
																TileEntity _ent = world.getTileEntity(pos);
																if (_ent != null) {
																	_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																			.ifPresent(capability -> {
																				_retval.set(capability.getStackInSlot(sltid).getCount());
																			});
																}
																return _retval.get();
															}
														}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3))) < 64))))) {
									{
										TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
										if (_ent != null) {
											final int _sltid = (int) (3);
											final ItemStack _setstack = (new ItemStack(
													(world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ)))).getBlock()));
											_setstack.setCount((int) ((new Object() {
												public int getAmount(IWorld world, BlockPos pos, int sltid) {
													AtomicInteger _retval = new AtomicInteger(0);
													TileEntity _ent = world.getTileEntity(pos);
													if (_ent != null) {
														_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																.ifPresent(capability -> {
																	_retval.set(capability.getStackInSlot(sltid).getCount());
																});
													}
													return _retval.get();
												}
											}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3))) + 1));
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												if (capability instanceof IItemHandlerModifiable) {
													((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
												}
											});
										}
									}
									{
										BlockPos _bp = new BlockPos((int) (posX), (int) ((posY) - 1), (int) (posZ));
										BlockState _bs = Blocks.WARPED_NYLIUM.getDefaultState();
										world.setBlockState(_bp, _bs, 3);
									}
									{
										BlockPos _bp = new BlockPos((int) (posX), (int) (posY), (int) (posZ));
										BlockState _bs = /* @BlockState */(new Object() {
											public BlockState toBlock(ItemStack _stk) {
												if (_stk.getItem() instanceof BlockItem) {
													return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
												}
												return Blocks.AIR.getDefaultState();
											}
										}.toBlock((new Object() {
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
										}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2)))));
										world.setBlockState(_bp, _bs, 3);
									}
									{
										TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
										if (_ent != null) {
											final int _sltid = (int) (2);
											final int _amount = (int) 1;
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												if (capability instanceof IItemHandlerModifiable) {
													ItemStack _stk = capability.getStackInSlot(_sltid).copy();
													_stk.shrink(_amount);
													((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
												}
											});
										}
									}
									stopScript = (boolean) (true);
									break;
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
								}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2)))
										.getItem() == new ItemStack(Blocks.CRIMSON_FUNGUS, (int) (1)).getItem()) && (((new Object() {
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
										}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3)))
												.getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()) || (((new Object() {
													public ItemStack getItemStack(BlockPos pos, int sltid) {
														AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
														TileEntity _ent = world.getTileEntity(pos);
														if (_ent != null) {
															_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																	.ifPresent(capability -> {
																		_retval.set(capability.getStackInSlot(sltid).copy());
																	});
														}
														return _retval.get();
													}
												}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == (new ItemStack(
														(world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ)))).getBlock()))
																.getItem())
														&& ((new Object() {
															public int getAmount(IWorld world, BlockPos pos, int sltid) {
																AtomicInteger _retval = new AtomicInteger(0);
																TileEntity _ent = world.getTileEntity(pos);
																if (_ent != null) {
																	_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																			.ifPresent(capability -> {
																				_retval.set(capability.getStackInSlot(sltid).getCount());
																			});
																}
																return _retval.get();
															}
														}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3))) < 64))))) {
									{
										TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
										if (_ent != null) {
											final int _sltid = (int) (3);
											final ItemStack _setstack = (new ItemStack(
													(world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ)))).getBlock()));
											_setstack.setCount((int) ((new Object() {
												public int getAmount(IWorld world, BlockPos pos, int sltid) {
													AtomicInteger _retval = new AtomicInteger(0);
													TileEntity _ent = world.getTileEntity(pos);
													if (_ent != null) {
														_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																.ifPresent(capability -> {
																	_retval.set(capability.getStackInSlot(sltid).getCount());
																});
													}
													return _retval.get();
												}
											}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3))) + 1));
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												if (capability instanceof IItemHandlerModifiable) {
													((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
												}
											});
										}
									}
									{
										BlockPos _bp = new BlockPos((int) (posX), (int) ((posY) - 1), (int) (posZ));
										BlockState _bs = Blocks.CRIMSON_NYLIUM.getDefaultState();
										world.setBlockState(_bp, _bs, 3);
									}
									{
										BlockPos _bp = new BlockPos((int) (posX), (int) (posY), (int) (posZ));
										BlockState _bs = /* @BlockState */(new Object() {
											public BlockState toBlock(ItemStack _stk) {
												if (_stk.getItem() instanceof BlockItem) {
													return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
												}
												return Blocks.AIR.getDefaultState();
											}
										}.toBlock((new Object() {
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
										}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2)))));
										world.setBlockState(_bp, _bs, 3);
									}
									{
										TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
										if (_ent != null) {
											final int _sltid = (int) (2);
											final int _amount = (int) 1;
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												if (capability instanceof IItemHandlerModifiable) {
													ItemStack _stk = capability.getStackInSlot(_sltid).copy();
													_stk.shrink(_amount);
													((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
												}
											});
										}
									}
									stopScript = (boolean) (true);
									break;
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
								}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == new ItemStack(Blocks.AIR, (int) (1))
										.getItem()) || (((new Object() {
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
										}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == (new ItemStack(
												(world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ)))).getBlock())).getItem())
												&& ((new Object() {
													public int getAmount(IWorld world, BlockPos pos, int sltid) {
														AtomicInteger _retval = new AtomicInteger(0);
														TileEntity _ent = world.getTileEntity(pos);
														if (_ent != null) {
															_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																	.ifPresent(capability -> {
																		_retval.set(capability.getStackInSlot(sltid).getCount());
																	});
														}
														return _retval.get();
													}
												}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3))) < 64)))) {
									{
										TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
										if (_ent != null) {
											final int _sltid = (int) (3);
											final ItemStack _setstack = (new ItemStack(
													(world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ)))).getBlock()));
											_setstack.setCount((int) ((new Object() {
												public int getAmount(IWorld world, BlockPos pos, int sltid) {
													AtomicInteger _retval = new AtomicInteger(0);
													TileEntity _ent = world.getTileEntity(pos);
													if (_ent != null) {
														_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																.ifPresent(capability -> {
																	_retval.set(capability.getStackInSlot(sltid).getCount());
																});
													}
													return _retval.get();
												}
											}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3))) + 1));
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												if (capability instanceof IItemHandlerModifiable) {
													((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
												}
											});
										}
									}
									{
										BlockPos _bp = new BlockPos((int) (posX), (int) (posY), (int) (posZ));
										BlockState _bs = /* @BlockState */(new Object() {
											public BlockState toBlock(ItemStack _stk) {
												if (_stk.getItem() instanceof BlockItem) {
													return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
												}
												return Blocks.AIR.getDefaultState();
											}
										}.toBlock((new Object() {
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
										}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2)))));
										world.setBlockState(_bp, _bs, 3);
									}
									{
										TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
										if (_ent != null) {
											final int _sltid = (int) (2);
											final int _amount = (int) 1;
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												if (capability instanceof IItemHandlerModifiable) {
													ItemStack _stk = capability.getStackInSlot(_sltid).copy();
													_stk.shrink(_amount);
													((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
												}
											});
										}
									}
									stopScript = (boolean) (true);
									break;
								}
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
							}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == new ItemStack(Blocks.AIR, (int) (1))
									.getItem()) || (((new Object() {
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
									}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == (new ItemStack(
											(world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ)))).getBlock())).getItem())
											&& ((new Object() {
												public int getAmount(IWorld world, BlockPos pos, int sltid) {
													AtomicInteger _retval = new AtomicInteger(0);
													TileEntity _ent = world.getTileEntity(pos);
													if (_ent != null) {
														_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																.ifPresent(capability -> {
																	_retval.set(capability.getStackInSlot(sltid).getCount());
																});
													}
													return _retval.get();
												}
											}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3))) < 64)))) {
								{
									TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
									if (_ent != null) {
										final int _sltid = (int) (3);
										final ItemStack _setstack = (new ItemStack(
												(world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ)))).getBlock()));
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
										}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (3))) + 1));
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											if (capability instanceof IItemHandlerModifiable) {
												((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
											}
										});
									}
								}
								{
									BlockPos _bp = new BlockPos((int) (posX), (int) (posY), (int) (posZ));
									BlockState _bs = Blocks.AIR.getDefaultState();
									world.setBlockState(_bp, _bs, 3);
								}
								world.setBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ)), Blocks.AIR.getDefaultState(), 3);
								stopScript = (boolean) (true);
								break;
							}
						}
						if (((BlockTags.getCollection()
								.getTagByID(new ResourceLocation(
										("forge:nwtg_automation/blocks/auto_tree_farm/leaves").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ)))).getBlock()))
								&& ((((world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
										.getBlock() == /* @BlockState */(new Object() {
											public BlockState toBlock(ItemStack _stk) {
												if (_stk.getItem() instanceof BlockItem) {
													return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
												}
												return Blocks.AIR.getDefaultState();
											}
										}.toBlock((new Object() {
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
										}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))))).getBlock())
										|| ((world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
												.getBlock() == Blocks.SHROOMLIGHT.getDefaultState().getBlock()))
										&& (((new Object() {
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
										}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4)))
												.getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()) || (((new Object() {
													public ItemStack getItemStack(BlockPos pos, int sltid) {
														AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
														TileEntity _ent = world.getTileEntity(pos);
														if (_ent != null) {
															_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																	.ifPresent(capability -> {
																		_retval.set(capability.getStackInSlot(sltid).copy());
																	});
														}
														return _retval.get();
													}
												}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == (new ItemStack(
														(world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ)))).getBlock()))
																.getItem())
														&& ((new Object() {
															public int getAmount(IWorld world, BlockPos pos, int sltid) {
																AtomicInteger _retval = new AtomicInteger(0);
																TileEntity _ent = world.getTileEntity(pos);
																if (_ent != null) {
																	_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																			.ifPresent(capability -> {
																				_retval.set(capability.getStackInSlot(sltid).getCount());
																			});
																}
																return _retval.get();
															}
														}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4))) < 64)))))) {
							{
								TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
								if (_ent != null) {
									final int _sltid = (int) (4);
									final ItemStack _setstack = (new ItemStack(
											(world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ)))).getBlock()));
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
									}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (4))) + 1));
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable) {
											((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
										}
									});
								}
							}
							world.setBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ)), Blocks.AIR.getDefaultState(), 3);
							stopScript = (boolean) (true);
							break;
						}
					}
					posX = (double) ((posX) + 1);
				}
				if (((stopScript) == (true))) {
					break;
				}
				posX = (double) (x - 8);
				posZ = (double) ((posZ) + 1);
			}
			if (((stopScript) == (true))) {
				break;
			}
			posX = (double) (x - 8);
			posZ = (double) (z - 8);
			posY = (double) ((posY) + 1);
		}
	}
}
