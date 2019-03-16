package com.ToMe.upgraderecipes;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
//import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBlock extends Block {
	
	public ModBlock(String name) {
		super(Material.IRON);
		setHardness(5F);
		setResistance(20F);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		ForgeRegistries.BLOCKS.register(this);
		ForgeRegistries.ITEMS.register(new ItemBlock(this).setRegistryName(name).setUnlocalizedName(name));
		setCreativeTab(UpgradeRecipesCommonProxy.UpgradeRecipesTab);
	}
	
	public void RegisterTextur() {
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(this), 0, new ModelResourceLocation("upgraderecipes:" + this.getUnlocalizedName().substring(5), "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation("upgraderecipes:" + this.getUnlocalizedName().substring(5), "inventory"));
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
		return true;
	}
	
}