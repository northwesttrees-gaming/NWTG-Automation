
package net.nwtg.nwtgautomation.item;

@NwtgAutomationModElements.ModElement.Tag
public class MachineWrenchItem extends NwtgAutomationModElements.ModElement {

	@ObjectHolder("nwtg_automation:machine_wrench")
	public static final Item block = null;

	public MachineWrenchItem(NwtgAutomationModElements instance) {
		super(instance, 1);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(NWTGAutomationTabItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("machine_wrench");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
