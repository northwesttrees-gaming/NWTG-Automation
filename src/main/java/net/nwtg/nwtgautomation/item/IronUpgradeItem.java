
package net.nwtg.nwtgautomation.item;

import net.nwtg.nwtgautomation.itemgroup.NWTGAutomationTabItemGroup;
import net.nwtg.nwtgautomation.NwtgAutomationModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@NwtgAutomationModElements.ModElement.Tag
public class IronUpgradeItem extends NwtgAutomationModElements.ModElement {
	@ObjectHolder("nwtg_automation:iron_upgrade")
	public static final Item block = null;
	public IronUpgradeItem(NwtgAutomationModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(NWTGAutomationTabItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("iron_upgrade");
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
