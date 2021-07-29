
package net.nwtg.nwtgautomation.itemgroup;

import net.nwtg.nwtgautomation.block.MachineBlockBlock;
import net.nwtg.nwtgautomation.NwtgAutomationModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@NwtgAutomationModElements.ModElement.Tag
public class NWTGAutomationTabItemGroup extends NwtgAutomationModElements.ModElement {
	public NWTGAutomationTabItemGroup(NwtgAutomationModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabnwtg_automation_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MachineBlockBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
