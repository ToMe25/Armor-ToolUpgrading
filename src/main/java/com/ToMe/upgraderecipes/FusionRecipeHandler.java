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
	
	public static final ItemStack EMPTYSTACK = null;//Will be ItemStack.EMPTY in 1.11+
	
	/**
	 * Removes all Fusion Crafting Recipes with the given Result.
	 * @param result the ItemStack to get the Item from.
	 * @param useDamage use / ignore the Item Damage
	 */
	public static void removeFusionRecipe(ItemStack result, boolean useDamage) {
		List<IFusionRecipe> recipes = FusionRecipeAPI.getRecipes();
		for(IFusionRecipe recipe:recipes) {
			//UpgradeRecipesMod.log.info(recipe.getClass().toString());
			//if(recipe.getRecipeOutput(null) != null) {
			//if(recipe.getRecipeOutput(null) != ItemStack.EMPTY) {
			if(recipe.getRecipeOutput(EMPTYSTACK) != null) {
			//if(recipe.getRecipeOutput(null) != ItemStack.EMPTY && recipe.getRecipeOutput(null) != null) {
			//if((recipe != null ? (recipe instanceof SimpleFusionRecipe ? ((SimpleFusionRecipe) recipe).getRecipeOutput(null) != ItemStack.EMPTY: false) : false)) {
				//Item outItem = recipe.getRecipeOutput(null).getItem();
				//Item outItem = recipe.getRecipeOutput(ItemStack.EMPTY).getItem();
				Item outItem = recipe.getRecipeOutput(EMPTYSTACK).getItem();
				Item inItem = result.getItem();
				if(outItem.equals(inItem)) {
					if(useDamage) {
						int outDmg = 0;
						try {
							//outDmg = recipe.getRecipeOutput(null).getItemDamage();
							//outDmg = recipe.getRecipeOutput(ItemStack.EMPTY).getItemDamage();
							outDmg = recipe.getRecipeOutput(EMPTYSTACK).getItemDamage();
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
	 * adds a standard Wyvern Tool upgrade recipe.
	 * @param ItemType the ItemType.(Pickaxe / Axe / Shovel / Hoe / Sword / Bow)
	 */
	public static void createWyvernToolRecipe(String ItemType) {
		if(!Config.tools) {
			return;
		}
		String material = "wyvern";
		try {
			String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
			if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
				Mat = RecipeAdd.getBlockOreDict(material);
			}
			ItemStack wyvern_core = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:wyvern_core")));
			ItemStack wyvern_energy_core = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:wyvern_energy_core")));
			ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
			if(Item.REGISTRY.containsKey(item)) {
				//FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Item.REGISTRY.getObject(new ResourceLocation(ItemType.equalsIgnoreCase("hoe") ? ("diamond_" + ItemType) : ("diamond_" + ItemType.toLowerCase()))) : Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 32000, 1, new Object[] {
				//FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Item.REGISTRY.getObject(new ResourceLocation(ItemType.equalsIgnoreCase("hoe") ? ("diamond_" + ItemType) : ("diamond_" + ItemType.toLowerCase()))) : Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 16000, 1, new Object[] {
				FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Item.REGISTRY.getObject(new ResourceLocation(ItemType.equalsIgnoreCase("hoe") ? ("diamond_" + ItemType) : ("diamond_" + ItemType.toLowerCase()))) : Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 4000, 1, new Object[] {
					wyvern_core, Mat, wyvern_energy_core, Mat
				}));
				if(Config.debug) {
					UpgradeRecipesMod.log.info("Added Fusion Recipe for " + item.getResourcePath() + "!");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			//UpgradeRecipesMod.log.catching(e);
			if(Config.debug) {
				UpgradeRecipesMod.log.catching(e);
			}
		}
	}
	
	/**
	 * adds a standard Wyvern Armor upgrade recipe.
	 * @param ItemType the ItemType.(Helmet / Chestplate / Leggings / Boots)
	 */
	public static void createWyvernArmorRecipe(String ItemType) {
		if(!Config.armor) {
			return;
		}
		String material = "wyvern";
		try {
			String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
			if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
				Mat = RecipeAdd.getBlockOreDict(material);
			}
			ItemStack wyvern_core = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:wyvern_core")));
			ItemStack wyvern_energy_core = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:wyvern_energy_core")));
			ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
			if(Item.REGISTRY.containsKey(item)) {
				//FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Item.REGISTRY.getObject(new ResourceLocation("diamond_" + ItemType.toLowerCase())) : Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 32000, 1, new Object[] {
				FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Item.REGISTRY.getObject(new ResourceLocation("diamond_" + ItemType.toLowerCase())) : Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 16000, 1, new Object[] {
					//Mat, Mat, Mat, wyvern_core, Mat, Mat, Mat, wyvern_energy_core
					Mat, Mat, Mat, wyvern_core, Mat, wyvern_energy_core, Mat, Mat
				}));
				if(Config.debug) {
					UpgradeRecipesMod.log.info("Added Fusion Recipe for " + item.getResourcePath() + "!");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			//UpgradeRecipesMod.log.catching(e);
			if(Config.debug) {
				UpgradeRecipesMod.log.catching(e);
			}
		}
	}
	
	/**
	 * adds a standard Draconic Tool upgrade recipe.
	 * @param ItemType the ItemType.(Pickaxe / Axe / Shovel / Hoe / Sword / Bow)
	 */
	public static void createDraconicToolRecipe(String ItemType) {
		if(!Config.tools) {
			return;
		}
		String material = "draconic";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_awakened_blocks");
				//Field f = Config.class.getDeclaredField(material + "_awakened_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "awakened_")) {
					Mat = RecipeAdd.getBlockOreDict(material);
				}
				ItemStack awakened_core = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:awakened_core")));
				ItemStack awakened_energy_core = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:draconic_energy_core")));
				//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					//FusionRecipeAPI.registry.add(new SimpleFusionRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 16000, 2, new Object[] {
					//FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 16000, 2, new Object[] {
					//FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:wyvern_" + ItemType)) : Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 320000, 2, new Object[] {
					//FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Item.REGISTRY.getObject(new ResourceLocation(ItemType.equalsIgnoreCase("hoe") ? ("diamond_" + ItemType) : ("draconicevolution:wyvern_" + ItemType.toLowerCase().replaceAll("pickaxe", "pick")))) : Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 320000, 2, new Object[] {
					//FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Item.REGISTRY.getObject(new ResourceLocation(ItemType.equalsIgnoreCase("hoe") ? ("diamond_" + ItemType) : ("draconicevolution:wyvern_" + ItemType.toLowerCase().replaceAll("pickaxe", "pick")))) : Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 64000, 2, new Object[] {
					FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Item.REGISTRY.getObject(new ResourceLocation(ItemType.equalsIgnoreCase("hoe") ? ("diamond_" + ItemType) : ("draconicevolution:wyvern_" + ItemType.toLowerCase().replaceAll("pickaxe", "pick")))) : Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 16000, 2, new Object[] {
						awakened_core, Mat, awakened_energy_core, Mat
					}));
					if(Config.debug) {
						UpgradeRecipesMod.log.info("Added Fusion Recipe for " + item.getResourcePath() + "!");
					}
				}
			//}
		} catch (Exception e) {
			// TODO: handle exception
			//UpgradeRecipesMod.log.catching(e);
			if(Config.debug) {
				UpgradeRecipesMod.log.catching(e);
			}
		}
	}
	
	/**
	 * adds a standard Draconic Armor upgrade recipe.
	 * @param ItemType the ItemType.(Helmet / Chestplate / Leggings / Boots)
	 */
	public static void createDraconicArmorRecipe(String ItemType) {
		if(!Config.armor) {
			return;
		}
		String material = "draconic";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_awakened_blocks");
				//Field f = Config.class.getDeclaredField(material + "_awakened_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "awakened_")) {
					Mat = RecipeAdd.getBlockOreDict(material);
				}
				ItemStack awakened_core = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:awakened_core")));
				ItemStack awakened_energy_core = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:draconic_energy_core")));
				//ResourceLocation item = UpgradeRecipesCommonProxy.ArmorMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					//FusionRecipeAPI.registry.add(new SimpleFusionRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 320000, 2, new Object[] {
					//FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 320000, 2, new Object[] {
					//FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 16000, 2, new Object[] {
					//FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:wyvern_" + ItemType)) : Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 320000, 2, new Object[] {
					FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:wyvern_" + ItemType.toLowerCase().replaceAll("helmet", "helm").replaceAll("chestplate", "chest").replaceAll("leggings", "legs"))) : Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))), 320000, 2, new Object[] {
						Mat, awakened_core, Mat, awakened_energy_core
					}));
					//Item upgrade = Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType));
					//if(upgrade != null) {
						//FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(upgrade), 320000, 2, new Object[] {
							//Mat, awakened_core, Mat, awakened_energy_core
						//}));
					//}
					//else {
						//FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:wyvern_" + ItemType))), 320000, 2, new Object[] {
							//Mat, awakened_core, Mat, awakened_energy_core
						//}));
					//}
					if(Config.debug) {
						UpgradeRecipesMod.log.info("Added Fusion Recipe for " + item.getResourcePath() + "!");
					}
				}
			//}
		} catch (Exception e) {
			// TODO: handle exception
			//UpgradeRecipesMod.log.catching(e);
			if(Config.debug) {
				UpgradeRecipesMod.log.catching(e);
			}
		}
	}
	
	/**
	 * adds a standard Draconic Staff of Power upgrade recipe.
	 */
	public static void createDraconicStaffRecipe() {
		if(!Config.tools) {
			return;
		}
		String material = "draconic";
		String ItemType = "staff";
		try {
			String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
			if(UpgradeRecipesMod.cfg.blockEnabled(material, "awakened_")) {
				Mat = RecipeAdd.getBlockOreDict(material);
			}
			ItemStack awakened_core = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:awakened_core")));
			ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
			if(Item.REGISTRY.containsKey(item)) {
				//FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution", "draconic_pick"))), 16000, 2, new Object[] {
					//Mat, Mat, Mat, Mat, Mat, awakened_core, new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution", "draconic_shovel"))), new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution", "draconic_sword")))
				//}));
				if(Config.draconic_staff_all_tools) {
					FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution", "draconic_pick"))), 12800, 2, new Object[] {
						Mat, Mat, Mat, Mat, Mat, awakened_core, new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution", "draconic_shovel"))), new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution", "draconic_sword"))), new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution", "draconic_hoe"))), new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution", "draconic_axe")))
					}));
				}
				else {
					FusionRecipeAPI.registry.add(new ToolUpgradeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution", "draconic_pick"))), 16000, 2, new Object[] {
						Mat, Mat, Mat, Mat, Mat, awakened_core, new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution", "draconic_shovel"))), new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution", "draconic_sword")))
					}));
				}
				if(Config.debug) {
					UpgradeRecipesMod.log.info("Added Fusion Recipe for " + item.getResourcePath() + "!");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			//UpgradeRecipesMod.log.catching(e);
			if(Config.debug) {
				UpgradeRecipesMod.log.catching(e);
			}
		}
	}
	
}