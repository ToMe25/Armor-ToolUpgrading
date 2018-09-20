package com.ToMe.upgraderecipes;

import java.lang.reflect.Field;
import java.util.List;

import com.brandon3055.draconicevolution.api.fusioncrafting.FusionRecipeAPI;
import com.brandon3055.draconicevolution.api.fusioncrafting.IFusionRecipe;
import com.brandon3055.draconicevolution.api.fusioncrafting.SimpleFusionRecipe;
import com.brandon3055.draconicevolution.lib.ToolUpgradeRecipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * Handles Draconic Evolutions Fusion Crafting System.
 * @author ToMe25
 *
 */
public class FusionRecipeHandler {
	
	/**
	 * Removes all Fusion Crafting Recipes with the given Result.
	 * @param result the ItemStack to get the Item from.
	 * @param useDamage use / ignore the Item Damage
	 */
	public static void removeFusionRecipe(ItemStack result, boolean useDamage) {
		List<IFusionRecipe> recipes = FusionRecipeAPI.getRecipes();
		for(IFusionRecipe recipe:recipes) {
			//UpgradeRecipesMod.log.info(recipe.getClass().toString());
			if(recipe.getRecipeOutput(null) != null) {
				Item outItem = recipe.getRecipeOutput(null).getItem();
				Item inItem = result.getItem();
				if(outItem.equals(inItem)) {
					if(useDamage) {
						int outDmg = 0;
						try {
							outDmg = recipe.getRecipeOutput(null).getItemDamage();
						} catch (Exception e) {
							// TODO: handle exception
							if(Config.debug) {
								UpgradeRecipesMod.log.catching(e);
							}
						}
						int inDmg = 0;
						try {
							inDmg = result.getItemDamage();
						} catch (Exception e) {
							// TODO: handle exception
							if(Config.debug) {
								UpgradeRecipesMod.log.catching(e);
							}
						}
						if(outDmg == inDmg) {
							FusionRecipeAPI.registry.remove(recipe);
							if(Config.debug) {
								UpgradeRecipesMod.log.info("Removed Fusion Recipe for " + result.getDisplayName() + "!");
							}
						}
					}
					else {
						FusionRecipeAPI.registry.remove(recipe);
						if(Config.debug) {
							UpgradeRecipesMod.log.info("Removed Fusion Recipe for " + result.getDisplayName() + "!");
						}
					}
				}
			}
		}
	}
	
	/**
	 * adds a standard Draconic Tool upgrade recipe.
	 * @param ItemType the ItemType.(Pickaxe / Axe / Shovel / Hoe / Sword / Bow)
	 */
	public static void createDraconicToolRecipe(String ItemType) {
		String material = "draconic";
		try {
			Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				f = Config.class.getDeclaredField(material + "_awakened_blocks");
				if(f.getBoolean(UpgradeRecipesMod.cfg)) {
					Mat = RecipeAdd.getBlockOreDict(material);
				}
				ItemStack awakened_core = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:awakened_core")));
				ItemStack awakened_energy_core = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:draconic_energy_core")));
				ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					//FusionRecipeAPI.registry.add(new SimpleFusionRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 16000, 2, new Object[] {
					FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 16000, 2, new Object[] {
						awakened_core, Mat, awakened_energy_core, Mat
					}));
					if(Config.debug) {
						UpgradeRecipesMod.log.info("Added Fusion Recipe for " + item.getResourcePath() + "!");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			UpgradeRecipesMod.log.catching(e);
		}
	}
	
	/**
	 * adds a standard Draconic Armor upgrade recipe.
	 * @param ItemType the ItemType.(Helmet / Chestplate / Leggings / Boots)
	 */
	public static void createDraconicArmorRecipe(String ItemType) {
		String material = "draconic";
		try {
			Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				f = Config.class.getDeclaredField(material + "_awakened_blocks");
				if(f.getBoolean(UpgradeRecipesMod.cfg)) {
					Mat = RecipeAdd.getBlockOreDict(material);
				}
				ItemStack awakened_core = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:awakened_core")));
				ItemStack awakened_energy_core = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:draconic_energy_core")));
				ResourceLocation item = UpgradeRecipesCommonProxy.ArmorMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					//FusionRecipeAPI.registry.add(new SimpleFusionRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 320000, 2, new Object[] {
					FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 320000, 2, new Object[] {
						Mat, awakened_core, Mat, awakened_energy_core
					}));
					if(Config.debug) {
						UpgradeRecipesMod.log.info("Added Fusion Recipe for " + item.getResourcePath() + "!");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			UpgradeRecipesMod.log.catching(e);
		}
	}
	
}