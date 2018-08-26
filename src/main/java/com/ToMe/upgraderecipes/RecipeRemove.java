package com.ToMe.upgraderecipes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//import com.brandon3055.draconicevolution.api.fusioncrafting.FusionRecipeAPI;
//import com.brandon3055.draconicevolution.api.fusioncrafting.IFusionRecipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class RecipeRemove {
	
	/**
	 * Removes the Recipes for all Items that should get a new Recipe.
	 */
	public static void removeRecipes() {
		if(Config.tools) {
			for(String s:UpgradeRecipesCommonProxy.toChange) {
				if(UpgradeRecipesCommonProxy.ToolMap.containsKey(s + ":pickaxe") || UpgradeRecipesCommonProxy.ToolMap.containsKey(s + ":sword") || UpgradeRecipesCommonProxy.ToolMap.containsKey(s + ":bow")) {
					if(!UpgradeRecipesCommonProxy.customCrafting.containsKey(s) || UpgradeRecipesCommonProxy.customCrafting.get(s).equalsIgnoreCase("crafting")) {
						removeToolOrArmorRecipe(s, "pickaxe");
						removeToolOrArmorRecipe(s, "axe");
						removeToolOrArmorRecipe(s, "shovel");
						removeToolOrArmorRecipe(s, "hoe");
						removeToolOrArmorRecipe(s, "sword");
						removeToolOrArmorRecipe(s, "bow");
					}
					if(UpgradeRecipesCommonProxy.customCrafting.containsKey(s)) {
						if(UpgradeRecipesCommonProxy.customCrafting.get(s).equalsIgnoreCase("fusion")) {
							removeToolOrArmorFusionRecipe(s, "pickaxe");
							removeToolOrArmorFusionRecipe(s, "axe");
							removeToolOrArmorFusionRecipe(s, "shovel");
							removeToolOrArmorFusionRecipe(s, "sword");
							removeToolOrArmorFusionRecipe(s, "hoe");
							removeToolOrArmorFusionRecipe(s, "bow");
						}
						else if(UpgradeRecipesCommonProxy.customCrafting.get(s).equalsIgnoreCase("dire")) {
							removeToolOrArmorDireRecipe(s, "pickaxe");
							removeToolOrArmorDireRecipe(s, "axe");
							removeToolOrArmorDireRecipe(s, "shovel");
							removeToolOrArmorDireRecipe(s, "hoe");
							removeToolOrArmorDireRecipe(s, "sword");
							removeToolOrArmorDireRecipe(s, "bow");
						}
					}
				}
				//if(!UpgradeRecipesCommonProxy.customCrafting.containsKey(s) || UpgradeRecipesCommonProxy.customCrafting.get(s).equalsIgnoreCase("crafting")) {
					//removeToolOrArmorRecipe(s, "sword");
					//removeToolOrArmorRecipe(s, "pickaxe");
					//removeToolOrArmorRecipe(s, "axe");
					//removeToolOrArmorRecipe(s, "shovel");
					//removeToolOrArmorRecipe(s, "hoe");
					//removeToolOrArmorRecipe(s, "sword");
					//removeToolOrArmorRecipe(s, "bow");
				//}
				//removeToolOrArmorRecipe(s, "sword");
				//removeToolOrArmorRecipe(s, "pickaxe");
				//removeToolOrArmorRecipe(s, "axe");
				//removeToolOrArmorRecipe(s, "shovel");
				//removeToolOrArmorRecipe(s, "hoe");
				//if(UpgradeRecipesCommonProxy.customCrafting.containsKey(s)) {
					//if(UpgradeRecipesCommonProxy.customCrafting.get(s).equals("fusion")) {
						//removeToolOrArmorFusionRecipe(s, "sword");
						//removeToolOrArmorFusionRecipe(s, "pickaxe");
						//removeToolOrArmorFusionRecipe(s, "axe");
						//removeToolOrArmorFusionRecipe(s, "shovel");
						//removeToolOrArmorFusionRecipe(s, "sword");
						//removeToolOrArmorFusionRecipe(s, "hoe");
						//removeToolOrArmorFusionRecipe(s, "bow");
					//}
					//else if(UpgradeRecipesCommonProxy.customCrafting.get(s).equals("dire")) {
						//removeToolOrArmorDireRecipe(s, "sword");
						//removeToolOrArmorDireRecipe(s, "pickaxe");
						//removeToolOrArmorDireRecipe(s, "axe");
						//removeToolOrArmorDireRecipe(s, "shovel");
						//removeToolOrArmorDireRecipe(s, "hoe");
						//removeToolOrArmorDireRecipe(s, "sword");
						//removeToolOrArmorDireRecipe(s, "bow");
					//}
				//}
			}
		}
		if(Config.armor) {
			for(String s:UpgradeRecipesCommonProxy.toChange) {
				if(UpgradeRecipesCommonProxy.ArmorMap.containsKey(s + ":helmet")) {
					if(!UpgradeRecipesCommonProxy.customCrafting.containsKey(s) || UpgradeRecipesCommonProxy.customCrafting.get(s).equalsIgnoreCase("crafting")) {
						removeToolOrArmorRecipe(s, "helmet");
						removeToolOrArmorRecipe(s, "chestplate");
						removeToolOrArmorRecipe(s, "leggings");
						removeToolOrArmorRecipe(s, "boots");
					}
					if(UpgradeRecipesCommonProxy.customCrafting.containsKey(s)) {
						if(UpgradeRecipesCommonProxy.customCrafting.get(s).equalsIgnoreCase("fusion")) {
							removeToolOrArmorFusionRecipe(s, "helmet");
							removeToolOrArmorFusionRecipe(s, "chestplate");
							removeToolOrArmorFusionRecipe(s, "leggings");
							removeToolOrArmorFusionRecipe(s, "boots");
						}
						else if(UpgradeRecipesCommonProxy.customCrafting.get(s).equalsIgnoreCase("dire")) {
							removeToolOrArmorDireRecipe(s, "helmet");
							removeToolOrArmorDireRecipe(s, "chestplate");
							removeToolOrArmorDireRecipe(s, "leggings");
							removeToolOrArmorDireRecipe(s, "boots");
						}
					}
				}
				//if(!UpgradeRecipesCommonProxy.customCrafting.containsKey(s) || UpgradeRecipesCommonProxy.customCrafting.get(s).equalsIgnoreCase("crafting")) {
					//removeToolOrArmorRecipe(s, "helmet");
					//removeToolOrArmorRecipe(s, "chestplate");
					//removeToolOrArmorRecipe(s, "leggings");
					//removeToolOrArmorRecipe(s, "boots");
				//}
				//if(UpgradeRecipesCommonProxy.customCrafting.containsKey(s)) {
					//if(UpgradeRecipesCommonProxy.customCrafting.get(s).equals("fusion")) {
						//removeToolOrArmorFusionRecipe(s, "helmet");
						//removeToolOrArmorFusionRecipe(s, "chestplate");
						//removeToolOrArmorFusionRecipe(s, "leggings");
						//removeToolOrArmorFusionRecipe(s, "boots");
					//}
				//}
			}
		}
		/**if(Config.avaritia) {
			
		}
		
		if(Config.draconicevolution) {
			if(Config.wyvern) {
				//if(Config.wyvern_pickaxe) {
					//ResourceLocation wyvern_pickaxe = new ResourceLocation("draconicevolution:wyvern_pickaxe");
					//if(Item.REGISTRY.containsKey(wyvern_pickaxe)) {
						//removeRecipe(new ItemStack(Item.REGISTRY.getObject(wyvern_pickaxe)));
						//removeRecipe(new ItemStack(Item.REGISTRY.getObject(wyvern_pickaxe)), false);
					//}
					//removeRecipe(new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:wyvern_pickaxe"))));
				//}
				if(Config.tools) {
					if(Config.wyvern_pickaxe) {
						ResourceLocation wyvern_pickaxe = new ResourceLocation("draconicevolution:wyvern_pickaxe");
						if(Item.REGISTRY.containsKey(wyvern_pickaxe)) {
							removeRecipe(new ItemStack(Item.REGISTRY.getObject(wyvern_pickaxe)), false);
						}
					}
				}
			}
		}
		
		if(Config.vanilla) {
			if(Config.stone) {
				if(Config.tools) {
					if(Config.stone_pickaxe) {
						ResourceLocation stone_pickaxe = new ResourceLocation("minecraft:stone_pickaxe");
						if(Item.REGISTRY.containsKey(stone_pickaxe)) {
							//removeRecipe(new ItemStack(Item.REGISTRY.getObject(stone_pickaxe)));
							removeRecipe(new ItemStack(Item.REGISTRY.getObject(stone_pickaxe)), false);
						}
					}
					if(Config.stone_axe) {
						ResourceLocation stone_axe = new ResourceLocation("minecraft:stone_axe");
						if(Item.REGISTRY.containsKey(stone_axe)) {
							removeRecipe(new ItemStack(Item.REGISTRY.getObject(stone_axe)), false);
						}
					}
					if(Config.stone_shovel) {
						ResourceLocation stone_shovel = new ResourceLocation("minecraft:stone_shovel");
						if(Item.REGISTRY.containsKey(stone_shovel)) {
							removeRecipe(new ItemStack(Item.REGISTRY.getObject(stone_shovel)), false);
						}
					}
					if(Config.stone_hoe) {
						ResourceLocation stone_hoe = new ResourceLocation("minecraft:stone_hoe");
						if(Item.REGISTRY.containsKey(stone_hoe)) {
							removeRecipe(new ItemStack(Item.REGISTRY.getObject(stone_hoe)), false);
						}
					}
					if(Config.stone_sword) {
						ResourceLocation stone_sword = new ResourceLocation("minecraft:stone_sword");
						if(Item.REGISTRY.containsKey(stone_sword)) {
							removeRecipe(new ItemStack(Item.REGISTRY.getObject(stone_sword)), false);
						}
					}
				}
			}
		}*/
	}
	
	/**
	 * Removes the Recipe for the Tool or Armor with the same material and ItemType from Avaritias Dire Crafting.
	 * Removes the Recipe only if it is Enabled in the Config File.
	 * @param material the Tool Material.
	 * @param ItemType the ItemType.(Pickaxe / Axe / Shovel / Hoe / Sword / Bow / Helmet / Chestplate / Leggings / Boots)
	 */
	protected static void removeToolOrArmorDireRecipe(String material, String ItemType) {
		try {
			Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			if(f.getBoolean(UpgradeRecipesMod.cfg) == true) {
				ResourceLocation item = new ResourceLocation("minecraft:air");
				//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				if(UpgradeRecipesCommonProxy.ToolMap.containsKey(material + ":" + ItemType.toLowerCase())) {
					item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				}
				else if(UpgradeRecipesCommonProxy.ArmorMap.containsKey(material + ":" + ItemType.toLowerCase())) {
					item = UpgradeRecipesCommonProxy.ArmorMap.get(material + ":" + ItemType.toLowerCase());
				}
				if(Item.REGISTRY.containsKey(item)) {
					DireRecipeHandler.removeDireRecipe(new ItemStack(Item.REGISTRY.getObject(item)), false);
				}
				else {
					if(Config.debug) {
						//UpgradeRecipesMod.log.warn("Couldn't remove Dire Recipe for " + material + "_" + ItemType.toLowerCase() + " as it wasn't found in the Item Registry.");
						UpgradeRecipesMod.log.warn("Couldn't remove Dire Recipe for " + item.getResourcePath() + " as it wasn't found in the Item Registry.");
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//UpgradeRecipesMod.log.catching(e);
			if(Config.debug) {
				UpgradeRecipesMod.log.catching(e);
			}
		}
	}
	
	/**
	 * Removes the Recipe for the Tool or Armor with the same material and ItemType from Draconic Evolutions Fusion Crafting.
	 * Removes the Recipe only if it is Enabled in the Config File.
	 * @param material the Tool Material.
	 * @param ItemType the ItemType.(Pickaxe / Axe / Shovel / Hoe / Sword / Bow / Helmet / Chestplate / Leggings / Boots)
	 */
	protected static void removeToolOrArmorFusionRecipe(String material, String ItemType) {
		try {
			Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			if(f.getBoolean(UpgradeRecipesMod.cfg) == true) {
				ResourceLocation item = new ResourceLocation("minecraft:air");
				//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				if(UpgradeRecipesCommonProxy.ToolMap.containsKey(material + ":" + ItemType.toLowerCase())) {
					item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				}
				else if(UpgradeRecipesCommonProxy.ArmorMap.containsKey(material + ":" + ItemType.toLowerCase())) {
					item = UpgradeRecipesCommonProxy.ArmorMap.get(material + ":" + ItemType.toLowerCase());
				}
				if(Item.REGISTRY.containsKey(item)) {
					//removeFusionRecipe(new ItemStack(Item.REGISTRY.getObject(item)), false);
					FusionRecipeHandler.removeFusionRecipe(new ItemStack(Item.REGISTRY.getObject(item)), false);
				}
				else {
					if(Config.debug) {
						//UpgradeRecipesMod.log.warn("Couldn't remove Fusion Recipe for " + material + "_" + ItemType.toLowerCase() + " as it wasn't found in the Item Registry.");
						UpgradeRecipesMod.log.warn("Couldn't remove Fusion Recipe for " + item.getResourcePath() + " as it wasn't found in the Item Registry.");
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//UpgradeRecipesMod.log.catching(e);
			if(Config.debug) {
				UpgradeRecipesMod.log.catching(e);
			}
		}
	}
	
	/**
	 * Removes the Recipe for the Tool or Armor with the same material and ItemType.
	 * Removes the Recipe only if it is Enabled in the Config File.
	 * @param material the Tool Material.
	 * @param ItemType the ItemType.(Pickaxe / Axe / Shovel / Hoe / Sword / Bow / Helmet / Chestplate / Leggings / Boots)
	 */
	protected static void removeToolOrArmorRecipe(String material, String ItemType) {
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType);
			Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			if(f.getBoolean(UpgradeRecipesMod.cfg) == true) {
				ResourceLocation item = new ResourceLocation("minecraft:air");
				//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType);
				//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				if(UpgradeRecipesCommonProxy.ToolMap.containsKey(material + ":" + ItemType.toLowerCase())) {
					item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				}
				else if(UpgradeRecipesCommonProxy.ArmorMap.containsKey(material + ":" + ItemType.toLowerCase())) {
					item = UpgradeRecipesCommonProxy.ArmorMap.get(material + ":" + ItemType.toLowerCase());
				}
				if(Item.REGISTRY.containsKey(item)) {
					removeRecipe(new ItemStack(Item.REGISTRY.getObject(item)), false);
				}
				else {
					if(Config.debug) {
						//UpgradeRecipesMod.log.warn("Couldn't remove Recipe for " + material + "_" + ItemType.toLowerCase() + " as it wasn't found in the Item Registry.");
						UpgradeRecipesMod.log.warn("Couldn't remove Recipe for " + item.getResourcePath() + " as it wasn't found in the Item Registry.");
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//UpgradeRecipesMod.log.catching(e);
			if(Config.debug) {
				UpgradeRecipesMod.log.catching(e);
			}
		}
	}
	
	/**
	 * Removes all Fusion Crafting Recipes with the given Result.
	 * @param result the ItemStack to get the Item from.
	 * @param useDamage use / ignore the Item Damage
	 */
	/*public static void removeFusionRecipe(ItemStack result, boolean useDamage) {
		List<IFusionRecipe> recipes = FusionRecipeAPI.getRecipes();
		//List<IFusionRecipe> recipes_copy = new ArrayList<IFusionRecipe>();
		//for(IFusionRecipe rec:recipes) {
			//recipes_copy.add(rec);
		//}
		for(IFusionRecipe recipe:recipes) {
		//for(IFusionRecipe recipe:recipes_copy) {
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
							//recipes.remove(recipe);
							FusionRecipeAPI.registry.remove(recipe);
							if(Config.debug) {
								UpgradeRecipesMod.log.info("Removed Fusion Recipe for " + result.getDisplayName() + "!");
							}
						}
					}
					else {
						//recipes.remove(recipe);
						FusionRecipeAPI.registry.remove(recipe);
						if(Config.debug) {
							UpgradeRecipesMod.log.info("Removed Fusion Recipe for " + result.getDisplayName() + "!");
						}
					}
				}
			}
		}
	}*/
	
	/**
	 * Removes all Crafting Recipes with the given Result.
	 * @param result the ItemStack to get the Item from.
	 * @param useDamage use / ignore the Item Damage
	 */
	//public static void removeRecipe(ItemStack result) {
	public static void removeRecipe(ItemStack result, boolean useDamage) {
		//List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		//List<IRecipe> recipes = CraftingManager.REGISTRY.getRecipeList();
		//List<IRecipe> recipes = ForgeRegistries.RECIPES.getValues();
		IForgeRegistryModifiable<IRecipe> registry = (IForgeRegistryModifiable<IRecipe>) ForgeRegistries.RECIPES;
		//Collection<IRecipe> recipes = registry.getValuesCollection();
		List<IRecipe> recipes = registry.getValues();
		List<IRecipe> recipes_copy = new ArrayList<IRecipe>();
		//List<IRecipe> remove = new ArrayList<IRecipe>();
		for(IRecipe rec:recipes) {
			recipes_copy.add(rec);
		}
		//for(IRecipe recipe:recipes) {
		for(IRecipe recipe:recipes_copy) {
			if(recipe.getRecipeOutput() != null) {
				Item outItem = recipe.getRecipeOutput().getItem();
				//int outDmg = recipe.getRecipeOutput().getItemDamage();
				//int outDmg = 0;
				//try {
					//outDmg = recipe.getRecipeOutput().getItemDamage();
				//} catch (Exception e) {
					// TODO: handle exception
				//}
				Item inItem = result.getItem();
				//int inDmg = result.getItemDamage();
				//int inDmg = 0;
				//try {
					//inDmg = result.getItemDamage();
				//} catch (Exception e) {
					// TODO: handle exception
				//}
				if(outItem.equals(inItem)) {
				//if(outItem.equals(inItem) && outDmg == inDmg) {
					//recipes.remove(recipe);
					//remove.add(recipe);
					if(useDamage) {
						int outDmg = 0;
						try {
							outDmg = recipe.getRecipeOutput().getItemDamage();
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
							//remove.add(recipe);
							//recipes.remove(recipe);
							registry.remove(recipe.getRegistryName());
							if(Config.debug) {
								UpgradeRecipesMod.log.info("Removed Recipe for " + result.getDisplayName() + "!");
							}
						}
					}
					else {
						//remove.add(recipe);
						//recipes.remove(recipe);
						registry.remove(recipe.getRegistryName());
						if(Config.debug) {
							UpgradeRecipesMod.log.info("Removed Recipe for " + result.getDisplayName() + "!");
						}
					}
				}
			}
			//if(recipe.getRecipeOutput().equals(result)) {
				//recipes.remove(recipe);
			//}
			//for(IRecipe r:remove) {
				//recipes.remove(r);
			//}
		}
	}
	
}