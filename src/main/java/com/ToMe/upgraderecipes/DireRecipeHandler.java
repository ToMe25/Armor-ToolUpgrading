package com.ToMe.upgraderecipes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraftforge.oredict.OreDictionary;
//import scala.collection.immutable.HashMap;

/**
 * Handles Avaritias Dire Crafting System.
 * @author ToMe25
 * I can't find a Avaritia 1.10.2 maven download or a deobf jar. Thats why this all uses Reflection.
 */
public class DireRecipeHandler {
	
	/**
	 * Removes all Dire Crafting Recipes with the given Result.
	 * @param result the ItemStack to get the Item from.
	 * @param useDamage use / ignore the Item Damage
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws NoSuchMethodException 
	 * @throws ClassNotFoundException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void removeDireRecipe(ItemStack result, boolean useDamage) throws Exception {
		Class<?> extremeCraftingManager = Class.forName("morph.avaritia.recipe.extreme.ExtremeCraftingManager");
		Method getInstance = extremeCraftingManager.getDeclaredMethod("getInstance", new Class<?>[] {});
		//System.out.println("getInstance():" + getInstance.invoke(null, (Object) null));
		//System.out.println("getInstance():" + getInstance.invoke(null));
		//Method getInstance = extremeCraftingManager.getDeclaredMethod("getInstance", (Class<?>) null);
		//Field recipeList = extremeCraftingManager.getField("recipes");
		//recipeList.setAccessible(true);
		//List<IRecipe> recipes = (List<IRecipe>) recipeList.get(getInstance.invoke(null, (Class<?>) null));
		Method getRecipeList = extremeCraftingManager.getDeclaredMethod("getRecipeList", new Class<?>[] {});
		//List<IRecipe> recipes = (List<IRecipe>) getRecipeList.invoke(getInstance.invoke(null, (Class<?>) null), (Class<?>) null);
		@SuppressWarnings("unchecked")
		List<IRecipe> recipes = (List<IRecipe>) getRecipeList.invoke(getInstance.invoke(null));
		//List<IRecipe> recipes = new ArrayList<IRecipe>();
		//Object list = getRecipeList.invoke(getInstance.invoke(null));
		//if(list instanceof List) {
		//if(list instanceof List<?>) {
			//recipes = (List<IRecipe>) list;
		//}
		//try {
			//recipes = (List<IRecipe>) getRecipeList.invoke(getInstance.invoke(null));
		//} catch (Exception e) {
			//here can't be a Exception.
		//}
		List<IRecipe> recipes_copy = new ArrayList<IRecipe>();
		for(IRecipe rec:recipes) {
			recipes_copy.add(rec);
		}
		for(IRecipe recipe:recipes_copy) {
			if(recipe.getRecipeOutput() != null) {
				Item outItem = recipe.getRecipeOutput().getItem();
				Item inItem = result.getItem();
				if(outItem.equals(inItem)) {
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
							recipes.remove(recipe);
							if(Config.debug) {
								UpgradeRecipesMod.log.info("Removed Dire Recipe for " + result.getDisplayName() + "!");
							}
						}
					}
					else {
						recipes.remove(recipe);
						if(Config.debug) {
							UpgradeRecipesMod.log.info("Removed Dire Recipe for " + result.getDisplayName() + "!");
						}
					}
				}
			}
		}
	}
	
	/**
	 * adds a standard Infinity Pickaxe upgrade recipe.
	 */
	public static void createInfinityPickaxeRecipe() {
		if(!Config.tools) {
			return;
		}
		String material = "infinity";
		String ItemType = "Pickaxe";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_blocks");
				//Field f = Config.class.getDeclaredField(material + "_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = RecipeAdd.getBlockOreDict(material);
				}
				String Neutronium = "ingotCosmicNeutronium";
				//f = Config.class.getDeclaredField(material + "_neutronium_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "neutronium_")) {
					Neutronium = RecipeAdd.getBlockOreDict(Neutronium);
				}
				String CrystalMatrix = "blockCrystalMatrix";
				//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					ItemStack result = new ItemStack(Item.REGISTRY.getObject(item));
					result.addEnchantment(Enchantments.FORTUNE, 10);
					addExtremeShapedOreRecipe(result, new Object[] {
						" IIIIIII ",
						"IIIICIIII",
						"II  U  II",
						"    N    ",
						"    N    ",
						"    N    ",
						"    N    ",
						"    N    ",
						"    N    ",
						'I', Mat,
						'C', CrystalMatrix,
						'N', Neutronium,
						//'U', new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)))
						//'U', new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))) == null ? Neutronium : new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)))
						//'U', new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))) == null ? Neutronium : new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)))
						'U', Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Neutronium : new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)))
					});
					//Class<?> extremeCraftingManager = Class.forName("morph.avaritia.recipe.extreme.ExtremeCraftingManager");
					//Method getInstance = extremeCraftingManager.getDeclaredMethod("getInstance", new Class<?>[] {});
					//Method addShapedOreRecipe = extremeCraftingManager.getDeclaredMethod("addExtremeShapedOreRecipe", new Class<?>[] {ItemStack.class, Object[].class});
					//ItemStack result = new ItemStack(Item.REGISTRY.getObject(item));
					//result.addEnchantment(Enchantments.FORTUNE, 10);
					//addShapedOreRecipe.invoke(getInstance.invoke(null), new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//addShapedOreRecipe.invoke(getInstance.invoke(null), result, new Object[] {
						//" IIIIIII ",
						//"IIIICIIII",
						//"II  N  II",
						//"    N    ",
						//"    N    ",
						//"    N    ",
						//"    N    ",
						//"    N    ",
						//"    N    ",
						//'I', Mat,
						//'C', CrystalMatrix,
						//'N', Neutronium
					//});
					//if(Config.debug) {
						//UpgradeRecipesMod.log.info("Added Dire Recipe for " + item.getResourcePath() + "!");
					//}
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
	 * adds a standard Infinity Axe upgrade recipe.
	 */
	public static void createInfinityAxeRecipe() {
		if(!Config.tools) {
			return;
		}
		String material = "infinity";
		String ItemType = "Axe";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_blocks");
				//Field f = Config.class.getDeclaredField(material + "_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = RecipeAdd.getBlockOreDict(material);
				}
				String Neutronium = "ingotCosmicNeutronium";
				//f = Config.class.getDeclaredField(material + "_neutronium_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "neutronium_")) {
					Neutronium = RecipeAdd.getBlockOreDict(Neutronium);
				}
				//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					ItemStack result = new ItemStack(Item.REGISTRY.getObject(item));
					//result.addEnchantment(Enchantments.FORTUNE, 10);
					addExtremeShapedOreRecipe(result, new Object[] {
						"   I     ",
						"  IIIII  ",
						"   IIII  ",
						"     IU  ",
						"      N  ",
						"      N  ",
						"      N  ",
						"      N  ",
						"      N  ",
						'I', Mat,
						'N', Neutronium,
						//'U', new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)))
						'U', Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Neutronium : new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)))
					});
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
	 * adds a standard Infinity Shovel upgrade recipe.
	 */
	public static void createInfinityShovelRecipe() {
		if(!Config.tools) {
			return;
		}
		String material = "infinity";
		String ItemType = "Shovel";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_blocks");
				//Field f = Config.class.getDeclaredField(material + "_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = RecipeAdd.getBlockOreDict(material);
				}
				String Neutronium = "ingotCosmicNeutronium";
				//f = Config.class.getDeclaredField(material + "_neutronium_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "neutronium_")) {
					Neutronium = RecipeAdd.getBlockOreDict(Neutronium);
				}
				String InfinityBlock = "blockInfinity";
				//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					ItemStack result = new ItemStack(Item.REGISTRY.getObject(item));
					//result.addEnchantment(Enchantments.FORTUNE, 10);
					addExtremeShapedOreRecipe(result, new Object[] {
						"      III",
						"     IIBI",
						"      III",
						"     U I ",
						"    N    ",
						"   N     ",
						"  N      ",
						" N       ",
						"N        ",
						'I', Mat,
						'B', InfinityBlock,
						'N', Neutronium,
						//'U', new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)))
						'U', Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Neutronium : new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)))
					});
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
	 * adds a standard Infinity Hoe upgrade recipe.
	 */
	public static void createInfinityHoeRecipe() {
		if(!Config.tools) {
			return;
		}
		String material = "infinity";
		String ItemType = "Hoe";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_blocks");
				//Field f = Config.class.getDeclaredField(material + "_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = RecipeAdd.getBlockOreDict(material);
				}
				String Neutronium = "ingotCosmicNeutronium";
				//f = Config.class.getDeclaredField(material + "_neutronium_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "neutronium_")) {
					Neutronium = RecipeAdd.getBlockOreDict(Neutronium);
				}
				//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					ItemStack result = new ItemStack(Item.REGISTRY.getObject(item));
					//result.addEnchantment(Enchantments.FORTUNE, 10);
					addExtremeShapedOreRecipe(result, new Object[] {
						"     N   ",
						" IIIIII  ",
						"IIIIIII  ",
						"I    II  ",
						"     U   ",
						"     N   ",
						"     N   ",
						"     N   ",
						"     N   ",
						'I', Mat,
						'N', Neutronium,
						//'U', new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)))
						'U', Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Neutronium : new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)))
					});
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
	 * adds a standard Infinity Sword upgrade recipe.
	 */
	public static void createInfinitySwordRecipe() {
		if(!Config.tools) {
			return;
		}
		String material = "infinity";
		String ItemType = "Sword";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_blocks");
				//Field f = Config.class.getDeclaredField(material + "_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = RecipeAdd.getBlockOreDict(material);
				}
				String Neutronium = "ingotCosmicNeutronium";
				//f = Config.class.getDeclaredField(material + "_neutronium_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "neutronium_")) {
					Neutronium = RecipeAdd.getBlockOreDict(Neutronium);
				}
				String CrystalMatrix = "ingotCrystalMatrix";
				//f = Config.class.getDeclaredField(material + "_crystalmatrix_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "crystalmatrix_")) {
					CrystalMatrix = RecipeAdd.getBlockOreDict(CrystalMatrix);
				}
				//ItemStack Catalyst = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("avaritia:infinity_catalyst")));
				ItemStack Catalyst = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("avaritia:resource")), 1, 5);
				//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					ItemStack result = new ItemStack(Item.REGISTRY.getObject(item));
					//result.addEnchantment(Enchantments.FORTUNE, 10);
					addExtremeShapedOreRecipe(result, new Object[] {
						"       II",
						"      III",
						"     III ",
						"    III  ",
						" C III   ",
						"  CII    ",
						"  UC     ",
						" N  C    ",
						"X        ",
						'I', Mat,
						'C', CrystalMatrix,
						'N', Neutronium,
						'X', Catalyst,
						//'U', new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)))
						'U', Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Neutronium : new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)))
					});
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
	 * adds a standard Infinity Bow upgrade recipe.
	 */
	public static void createInfinityBowRecipe() {
		if(!Config.tools) {
			return;
		}
		String material = "infinity";
		String ItemType = "Bow";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_blocks");
				//Field f = Config.class.getDeclaredField(material + "_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = RecipeAdd.getBlockOreDict(material);
				}
				String CrystalMatrix = "blockCrystalMatrix";
				//ItemStack Wool = new ItemStack(Blocks.WOOL);
				//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					ItemStack result = new ItemStack(Item.REGISTRY.getObject(item));
					//result.addEnchantment(Enchantments.FORTUNE, 10);
					addExtremeShapedOreRecipe(result, new Object[] {
						"   II    ",
						"  I W    ",
						" I  W    ",
						"I   W    ",
						"C   U    ",
						"I   W    ",
						" I  W    ",
						"  I W    ",
						"   II    ",
						'I', Mat,
						'C', CrystalMatrix,
						//'W', Wool,
						'W', Config.oreDictWool ? "wool" : new ItemStack(Blocks.WOOL),
						//'U', new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)))
						'U', Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Config.oreDictWool ? "wool" : new ItemStack(Blocks.WOOL) : new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)))
					});
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
	 * adds a standard Infinity Helmet upgrade recipe.
	 */
	public static void createInfinityHelmetRecipe() {
		if(!Config.armor) {
			return;
		}
		String material = "infinity";
		String ItemType = "Helmet";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_blocks");
				//Field f = Config.class.getDeclaredField(material + "_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = RecipeAdd.getBlockOreDict(material);
				}
				String Neutronium = "ingotCosmicNeutronium";
				//f = Config.class.getDeclaredField(material + "_neutronium_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "neutronium_")) {
					Neutronium = RecipeAdd.getBlockOreDict(Neutronium);
				}
				ItemStack Catalyst = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("avaritia:resource")), 1, 5);
				//ResourceLocation item = UpgradeRecipesCommonProxy.ArmorMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					ItemStack result = new ItemStack(Item.REGISTRY.getObject(item));
					addExtremeShapedOreRecipe(result, new Object[] {
						"  NNNNN  ",
						" NIIIIIN ",
						" N XIX N ",
						" NIIIIIN ",
						" NIIIIIN ",
						" NI I IN ",
						"    U    ",
						'I', Mat,
						'X', Catalyst,
						'N', Neutronium,
						'U', new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)))
					});
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
	 * adds a standard Infinity Chestplate upgrade recipe.
	 */
	public static void createInfinityChestplateRecipe() {
		if(!Config.armor) {
			return;
		}
		String material = "infinity";
		String ItemType = "Chestplate";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_blocks");
				//Field f = Config.class.getDeclaredField(material + "_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = RecipeAdd.getBlockOreDict(material);
				}
				String Neutronium = "ingotCosmicNeutronium";
				//f = Config.class.getDeclaredField(material + "_neutronium_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "neutronium_")) {
					Neutronium = RecipeAdd.getBlockOreDict(Neutronium);
				}
				String CrystalMatrix = "blockCrystalMatrix";
				//ResourceLocation item = UpgradeRecipesCommonProxy.ArmorMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					ItemStack result = new ItemStack(Item.REGISTRY.getObject(item));
					addExtremeShapedOreRecipe(result, new Object[] {
						" NN   NN ",
						"NNN   NNN",
						"NNN U NNN",
						" NIIIIIN ",
						" NIICIIN ",
						" NIIIIIN ",
						" NIIIIIN ",
						" NIIIIIN ",
						"  NNNNN  ",
						'I', Mat,
						'C', CrystalMatrix,
						'N', Neutronium,
						'U', new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)))
					});
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
	 * adds a standard Infinity Leggings upgrade recipe.
	 */
	public static void createInfinityLeggingsRecipe() {
		if(!Config.armor) {
			return;
		}
		String material = "infinity";
		String ItemType = "Leggings";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_blocks");
				//Field f = Config.class.getDeclaredField(material + "_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = RecipeAdd.getBlockOreDict(material);
				}
				String Neutronium = "ingotCosmicNeutronium";
				//f = Config.class.getDeclaredField(material + "_neutronium_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "neutronium_")) {
					Neutronium = RecipeAdd.getBlockOreDict(Neutronium);
				}
				String CrystalMatrix = "blockCrystalMatrix";
				ItemStack Catalyst = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("avaritia:resource")), 1, 5);
				//ResourceLocation item = UpgradeRecipesCommonProxy.ArmorMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					ItemStack result = new ItemStack(Item.REGISTRY.getObject(item));
					addExtremeShapedOreRecipe(result, new Object[] {
						"NNNNNNNNN",
						"NIIIXIIIN",
						"NINNXNNIN",
						"NIN U NIN",
						"NCN   NCN",
						"NIN   NIN",
						"NIN   NIN",
						"NIN   NIN",
						"NNN   NNN",
						'I', Mat,
						'C', CrystalMatrix,
						'N', Neutronium,
						'U', new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType))),
						'X', Catalyst
					});
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
	 * adds a standard Infinity Boots upgrade recipe.
	 */
	public static void createInfinityBootsRecipe() {
		if(!Config.armor) {
			return;
		}
		String material = "infinity";
		String ItemType = "Boots";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_blocks");
				//Field f = Config.class.getDeclaredField(material + "_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = RecipeAdd.getBlockOreDict(material);
				}
				String Neutronium = "ingotCosmicNeutronium";
				//f = Config.class.getDeclaredField(material + "_neutronium_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "neutronium_")) {
					Neutronium = RecipeAdd.getBlockOreDict(Neutronium);
				}
				//ResourceLocation item = UpgradeRecipesCommonProxy.ArmorMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					ItemStack result = new ItemStack(Item.REGISTRY.getObject(item));
					addExtremeShapedOreRecipe(result, new Object[] {
						" NNNUNNN ",
						" NIN NIN ",
						" NIN NIN ",
						"NNIN NINN",
						"NIIN NIIN",
						"NNNN NNNN",
						'I', Mat,
						'N', Neutronium,
						'U', new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)))
					});
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
	 * adds a standard Skullfire Sword upgrade recipe.
	 */
	public static void createSkullfireSwordRecipe() {
		if(!Config.tools) {
			return;
		}
		String material = "skullfire";
		String ItemType = "Sword";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_crystalmatrix_blocks");
				//Field f = Config.class.getDeclaredField(material + "_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = RecipeAdd.getBlockOreDict(material);
				}
				String Netherstar = "netherStar";
				//f = Config.class.getDeclaredField(material + "_netherstar_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "netherstar_")) {
					Netherstar = RecipeAdd.getBlockOreDict(Netherstar);
				}
				String Bone = "bone";
				//f = Config.class.getDeclaredField(material + "_bone_blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg) && Config.oreDictBoneBlock) {
				//if(f.getBoolean(UpgradeRecipesMod.cfg) && !OreDictionary.getOres("blockBone", false).isEmpty()) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "bone_")) {
					//Bone = RecipeAdd.getBlockOreDict(Bone);
					if(OreDictionary.getOres("blockBone", false).isEmpty()) {
						Bone = "minecraft:bone_block";
					}
					else {
						Bone = RecipeAdd.getBlockOreDict(Bone);
					}
				}
				String Wood = "logWood";
				ItemStack BlazePowder = new ItemStack(Items.BLAZE_POWDER);
				//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					ItemStack result = new ItemStack(Item.REGISTRY.getObject(item));
					//result.addEnchantment(Enchantments.FORTUNE, 10);
					addExtremeShapedOreRecipe(result, new Object[] {
						"       CX",
						"      CXC",
						"     CXC ",
						"    CXC  ",
						" B CXC   ",
						"  BXC    ",
						"  UB     ",
						" W  B    ",
						"N        ",
						'C', Mat,
						'X', BlazePowder,
						//'B', Bone,
						'B', Bone.contains(":") ? new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(Bone))) : Bone,
						'W', Wood,
						'N', Netherstar,
						//'U', new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)))
						'U', Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Wood : new ItemStack(Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)))
					});
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
	 * Just a redirect to Avaritias addExtremeShapedOreRecipe Method.
	 */
	private static void addExtremeShapedOreRecipe(ItemStack result, Object[] recipe) {
		try {
			Class<?> extremeCraftingManager = Class.forName("morph.avaritia.recipe.extreme.ExtremeCraftingManager");//1.10/1.11
			//Class<?> avaritiaRecipeManager = Class.forName("morph.avaritia.recipe.AvaritiaRecipeManager");//1.12
			Class<?> extremeShapedRecipe = Class.forName("morph.avaritia.recipe.extreme.ExtremeShapedOreRecipe");//1.10/1.11
			//Class<?> extremeShapedRecipe = Class.forName("morph.avaritia.recipe.extreme.ExtremeShapedRecipe");//1.12
			Method getInstance = extremeCraftingManager.getDeclaredMethod("getInstance", new Class<?>[] {});//1.10/1.11
			Object instance = getInstance.invoke(null);//1.10/1.11
			//Method addExtremeShapedOreRecipe = extremeCraftingManager.getDeclaredMethod("addExtremeShapedOreRecipe", new Class<?>[] {ItemStack.class, Object[].class});
			Constructor<?> newExtremeShapedRecipe = extremeShapedRecipe.getConstructor(ItemStack.class, Object[].class);//1.10/1.11
			//Constructor<?> newExtremeShapedRecipe = extremeShapedRecipe.getConstructor(ItemStack.class, ShapedPrimer.class);//1.12
			//addExtremeShapedOreRecipe.invoke(getInstance.invoke(null), result, recipe);
			Field extremeRecipes = extremeCraftingManager.getDeclaredField("recipes");//1.10/1.11
			//Field extremeRecipes = avaritiaRecipeManager.getDeclaredField("EXTREME_RECIPES");//1.12
			extremeRecipes.setAccessible(true);
			List<IRecipe> EXTREME_RECIPES = (List<IRecipe>) extremeRecipes.get(instance);//1.10/1.11
			//Map<ResourceLocation, Object> EXTREME_RECIPES = (Map<ResourceLocation, Object>) extremeRecipes.get(null);//1.12
			Object extremeRecipe = newExtremeShapedRecipe.newInstance(result, recipe);//1.10/1.11
			//Object extremeRecipe = newExtremeShapedRecipe.newInstance(result, CraftingHelper.parseShaped(recipe));//1.12
			//ResourceLocation recipeName = new ResourceLocation(UpgradeRecipesMod.MODID + ":" + result.getDisplayName());//1.12
			//EXTREME_RECIPES.put(new ResourceLocation(UpgradeRecipesMod.MODID + ":" + result.getDisplayName()), extremeRecipe);
			EXTREME_RECIPES.add((IRecipe) extremeRecipe);//1.10/1.11
			//EXTREME_RECIPES.put(recipeName, extremeRecipe);//1.12
			//Field REGISTRY = extremeCraftingManager.getDeclaredField("REGISTRY");
			//RegistryNamespaced ExtremeRegistry = (RegistryNamespaced) REGISTRY.get(null);
			//ExtremeRegistry.putObject(recipeName, extremeRecipe);
			if(Config.debug) {
				UpgradeRecipesMod.log.info("Added Dire Recipe for " + result.getDisplayName() + "!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			//UpgradeRecipesMod.log.catching(e);
			if(Config.debug) {
				UpgradeRecipesMod.log.catching(e);
			}
			//try {
				//Class<?> avaritiaRecipeManager = Class.forName("morph.avaritia.recipe.AvaritiaRecipeManager");
				//Class<?> extremeShapedRecipe = Class.forName("morph.avaritia.recipe.extreme.ExtremeShapedRecipe");
				//Constructor<?> newExtremeShapedRecipe = extremeShapedRecipe.getConstructor(ItemStack.class, ShapedPrimer.class);
				//Field extremeRecipes = avaritiaRecipeManager.getDeclaredField("EXTREME_RECIPES");
				//Map<ResourceLocation, Object> EXTREME_RECIPES = (Map<ResourceLocation, Object>) extremeRecipes.get(null);
				//Object extremeRecipe = newExtremeShapedRecipe.newInstance(result, CraftingHelper.parseShaped(recipe));
				//ResourceLocation recipeName = new ResourceLocation(UpgradeRecipesMod.MODID + ":" + result.getDisplayName());
				//EXTREME_RECIPES.put(recipeName, extremeRecipe);
				//if(Config.debug) {
					//UpgradeRecipesMod.log.info("Added Dire Recipe for " + result.getDisplayName() + "!");
				//}
			//} catch (Exception e1) {
				// TODO: handle exception
				//UpgradeRecipesMod.log.catching(e);
				//UpgradeRecipesMod.log.catching(e1);
			//}
		}
	}
	
}