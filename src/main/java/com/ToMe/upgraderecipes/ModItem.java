package com.ToMe.upgraderecipes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModItem extends Item {
	
	private String suffix;
	
	public ModItem(String unlocalizedName) {
		this(unlocalizedName, unlocalizedName);
	}
	
	public ModItem(String registryName, String unlocalizedName) {
		this(registryName, unlocalizedName, "");
		//super();
		//if(registryName.indexOf(':') > 0) {
			//registryName = registryName.substring(registryName.indexOf(':'), registryName.length());
		//}
		//this.setRegistryName(registryName);
		//this.setUnlocalizedName(unlocalizedName);
		//ForgeRegistries.ITEMS.register(this);
		//setCreativeTab(UpgradeRecipesCommonProxy.UpgradeRecipesTab);
	}
	
	public ModItem(String registryName, String unlocalizedName, String suffix) {
		super();
		this.suffix = suffix;
		this.setRegistryName(registryName);
		this.setUnlocalizedName(unlocalizedName);
		ForgeRegistries.ITEMS.register(this);
		setCreativeTab(UpgradeRecipesCommonProxy.UpgradeRecipesTab);
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		return suffix == null || suffix == "" ? super.getItemStackDisplayName(stack) : String.format(super.getItemStackDisplayName(stack), suffix);
	}
	
	public void RegisterTextur() {
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("upgraderecipes:" + this.getUnlocalizedName().substring(5), "inventory"));
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("upgraderecipes:" + this.getUnlocalizedName().substring(5), "inventory"));
	}
	
}