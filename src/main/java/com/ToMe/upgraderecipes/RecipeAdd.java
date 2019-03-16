package com.ToMe.upgraderecipes;

//import java.lang.reflect.Field;
import java.util.ArrayList;
//import java.util.HashMap;

//import com.brandon3055.draconicevolution.api.fusioncrafting.FusionRecipeAPI;
//import com.brandon3055.draconicevolution.api.fusioncrafting.IFusionRecipe;
//import com.brandon3055.draconicevolution.api.fusioncrafting.SimpleFusionRecipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipeAdd {
	
	private static ArrayList<String> Tiers = new ArrayList<String>();
	//private static ArrayList<String> ToolTiers = new ArrayList<String>();
	//private static ArrayList<String> ArmorTiers = new ArrayList<String>();
	
	/**
	 * Adds the Recipes for all Items that should get a new Recipe.
	 */
	public static void addRecipes() {
		initTiersLists();
		
		for(Materials mat:Materials.values()) {
			//mat.addRecipes();
			//if(Loader.isModLoaded(mat.getMod())) {
			//if(Loader.isModLoaded(mat.getMod()) || Loader.isModLoaded(mat.getMod().toLowerCase())) {
			//if(UpgradeRecipesCommonProxy.isModLoaded(mat.getMod())) {
			if(mat.isModLoaded()) {
				mat.addRecipes();
			}
		}
		/*if(Config.tools) {
			for(String s:UpgradeRecipesCommonProxy.toChange) {
				if(UpgradeRecipesCommonProxy.ToolMap.containsKey(s + ":pickaxe") || UpgradeRecipesCommonProxy.ToolMap.containsKey(s + ":sword") || UpgradeRecipesCommonProxy.ToolMap.containsKey(s + ":bow")) {
					if(!UpgradeRecipesCommonProxy.customCrafting.containsKey(s)) {
						addPickaxeRecipe(s);
						addAxeRecipe(s);
						addShovelRecipe(s);
						addHoeRecipe(s);
						addSwordRecipe(s);
						addBowRecipe(s);
					}
					else {
						if(UpgradeRecipesCommonProxy.customCrafting.get(s).equalsIgnoreCase("crafting")) {
							if(s.equalsIgnoreCase("wyvern")) {
								createWyvernToolRecipe("pickaxe");
								createWyvernToolRecipe("axe");
								createWyvernToolRecipe("shovel");
								createWyvernToolRecipe("hoe");
								createWyvernToolRecipe("sword");
								createWyvernToolRecipe("bow");
							}
						}
						else if(UpgradeRecipesCommonProxy.customCrafting.get(s).equalsIgnoreCase("fusion")) {
							if(s.equalsIgnoreCase("draconic")) {
								FusionRecipeHandler.createDraconicToolRecipe("pickaxe");
								FusionRecipeHandler.createDraconicToolRecipe("axe");
								FusionRecipeHandler.createDraconicToolRecipe("shovel");
								FusionRecipeHandler.createDraconicToolRecipe("hoe");
								FusionRecipeHandler.createDraconicToolRecipe("sword");
								FusionRecipeHandler.createDraconicToolRecipe("bow");
							}
						}
						else if(UpgradeRecipesCommonProxy.customCrafting.get(s).equalsIgnoreCase("dire")) {
							if(s.equalsIgnoreCase("skullfire")) {
								DireRecipeHandler.createSkullfireSwordRecipe();
							}
							else if(s.equalsIgnoreCase("infinity")) {
								DireRecipeHandler.createInfinityPickaxeRecipe();
								DireRecipeHandler.createInfinityAxeRecipe();
								DireRecipeHandler.createInfinityShovelRecipe();
								DireRecipeHandler.createInfinitySwordRecipe();
								DireRecipeHandler.createInfinityBowRecipe();
							}
						}
					}
				}
				//if(!UpgradeRecipesCommonProxy.customCrafting.containsKey(s)) {
					//addPickaxeRecipe(s);
					//addAxeRecipe(s);
					//addShovelRecipe(s);
					//addHoeRecipe(s);
					//addSwordRecipe(s);
					//addBowRecipe(s);
				//}
				//addPickaxeRecipe(s, false);
				//addAxeRecipe(s, false);
				//addPickaxeRecipe(s);
				//addAxeRecipe(s);
				//addShovelRecipe(s);
				//addHoeRecipe(s);
				//addSwordRecipe(s);
				//if(UpgradeRecipesCommonProxy.customCrafting.containsKey(s)) {
				//else if(UpgradeRecipesCommonProxy.customCrafting.containsKey(s)) {
				//else {
					//if(UpgradeRecipesCommonProxy.customCrafting.get(s).equalsIgnoreCase("crafting")) {
						//if(s.equalsIgnoreCase("wyvern")) {
							//createWyvernToolRecipe("pickaxe");
							//createWyvernToolRecipe("axe");
							//createWyvernToolRecipe("shovel");
							//createWyvernToolRecipe("hoe");
							//createWyvernToolRecipe("sword");
							//createWyvernToolRecipe("bow");
						//}
					//}
					//else if(UpgradeRecipesCommonProxy.customCrafting.get(s).equalsIgnoreCase("fusion")) {
						//if(s.equalsIgnoreCase("draconic")) {
							//createDraconicToolRecipe("pickaxe");
							//createDraconicToolRecipe("axe");
							//createDraconicToolRecipe("shovel");
							//createDraconicToolRecipe("hoe");
							//createDraconicToolRecipe("sword");
							//FusionRecipeHandler.createDraconicToolRecipe("pickaxe");
							//FusionRecipeHandler.createDraconicToolRecipe("axe");
							//FusionRecipeHandler.createDraconicToolRecipe("shovel");
							//FusionRecipeHandler.createDraconicToolRecipe("hoe");
							//FusionRecipeHandler.createDraconicToolRecipe("sword");
							//FusionRecipeHandler.createDraconicToolRecipe("bow");
						//}
					//}
					//else if(UpgradeRecipesCommonProxy.customCrafting.get(s).equalsIgnoreCase("dire")) {
						//if(s.equalsIgnoreCase("skullfire")) {
							//DireRecipeHandler.createSkullfireSwordRecipe();
						//}
						//else if(s.equalsIgnoreCase("infinity")) {
							//DireRecipeHandler.createInfinityPickaxeRecipe();
							//DireRecipeHandler.createInfinityAxeRecipe();
							//DireRecipeHandler.createInfinityShovelRecipe();
							//DireRecipeHandler.createInfinitySwordRecipe();
							//DireRecipeHandler.createInfinityBowRecipe();
						//}
					//}
				//}
			}
		}
		
		if(Config.armor) {
			for(String s:UpgradeRecipesCommonProxy.toChange) {
				if(UpgradeRecipesCommonProxy.ArmorMap.containsKey(s + ":helmet")) {
					if(!UpgradeRecipesCommonProxy.customCrafting.containsKey(s)) {
						addHelmetRecipe(s);
						addChestplateRecipe(s);
						addLeggingsRecipe(s);
						addBootsRecipe(s);
					}
					else {
						if(UpgradeRecipesCommonProxy.customCrafting.get(s).equalsIgnoreCase("crafting")) {
							if(s.equalsIgnoreCase("wyvern")) {
								createWyvernArmorRecipe("helmet");
								createWyvernArmorRecipe("chestplate");
								createWyvernArmorRecipe("leggings");
								createWyvernArmorRecipe("boots");
							}
						}
						else if(UpgradeRecipesCommonProxy.customCrafting.get(s).equalsIgnoreCase("fusion")) {
							if(s.equalsIgnoreCase("draconic")) {
								FusionRecipeHandler.createDraconicArmorRecipe("helmet");
								FusionRecipeHandler.createDraconicArmorRecipe("chestplate");
								FusionRecipeHandler.createDraconicArmorRecipe("leggings");
								FusionRecipeHandler.createDraconicArmorRecipe("boots");
							}
						}
						else if(UpgradeRecipesCommonProxy.customCrafting.get(s).equalsIgnoreCase("dire")) {
							if(s.equalsIgnoreCase("infinity")) {
								DireRecipeHandler.createInfinityHelmetRecipe();
								DireRecipeHandler.createInfinityChestplateRecipe();
								DireRecipeHandler.createInfinityLeggingsRecipe();
								DireRecipeHandler.createInfinityBootsRecipe();
							}
						}
					}
				}
				//if(!UpgradeRecipesCommonProxy.customCrafting.containsKey(s)) {
					//addHelmetRecipe(s);
					//addChestplateRecipe(s);
					//addLeggingsRecipe(s);
					//addBootsRecipe(s);
				//}
				//else {
					//if(UpgradeRecipesCommonProxy.customCrafting.get(s).equalsIgnoreCase("crafting")) {
						//if(s.equalsIgnoreCase("wyvern")) {
							//createWyvernArmorRecipe("helmet");
							//createWyvernArmorRecipe("chestplate");
							//createWyvernArmorRecipe("leggings");
							//createWyvernArmorRecipe("boots");
						//}
					//}
					//else if(UpgradeRecipesCommonProxy.customCrafting.get(s).equalsIgnoreCase("fusion")) {
						//if(s.equalsIgnoreCase("draconic")) {
							//FusionRecipeHandler.createDraconicArmorRecipe("helmet");
							//FusionRecipeHandler.createDraconicArmorRecipe("chestplate");
							//FusionRecipeHandler.createDraconicArmorRecipe("leggings");
							//FusionRecipeHandler.createDraconicArmorRecipe("boots");
						//}
					//}
				//}
			}
		}*/
		
		//if(Config.avaritia) {
			
		//}
		
		//if(Config.draconicevolution) {
			//if(Config.wyvern) {
				//if(Config.tools) {
					//if(Config.wyvern_pickaxe) {
						//ResourceLocation wyvern_pickaxe = new ResourceLocation("draconicevolution:wyvern_pickaxe");
						//if(Item.REGISTRY.containsKey(wyvern_pickaxe)) {
							//if(Config.wyvern_blocks) {
								//GameRegistry.addRecipe(new ItemStack(Item.REGISTRY.getObject(wyvern_pickaxe)), new Object[] {
									
								//});
							//}
						//}
						//if(Config.wyvern_blocks) {
							//ResourceLocation wyvern_pickaxe = new ResourceLocation("draconicevolution:wyvern_pickaxe");
							//if(Item.REGISTRY.containsKey(wyvern_pickaxe)) {
								
							//}
						//}
					//}
				//}
			//}
		//}
	}
	
	/**
	 * adds a standard Pickaxe upgrade recipe.
	 * @param material
	 */
	//protected static void addPickaxeRecipe(String material, boolean blocks) {
	protected static void addPickaxeRecipe(String material) {
		if(!Config.tools) {
			return;
		}
		String ItemType = "Pickaxe";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_" + "blocks");
				//Field f = Config.class.getDeclaredField(material + "_" + "blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = getBlockOreDict(material);
					//Mat = getBlockOreDict(UpgradeRecipesCommonProxy.ToolMaterialMap.get(material));
					//if(Config.debug) {
						//UpgradeRecipesMod.log.info("Use Block " + Mat + " for the Recipe!");
					//}
				}
				//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						"MMM",
						" U ",
						" S ",
						'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
						//'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType)),
						'U', Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? "stickWood" : Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)),
						'S', "stickWood"
					//}));
					}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//Item upgrade = Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType));
					//if(upgrade != null) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							//"MMM",
							//" U ",
							//" S ",
							//'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							//'U', upgrade,
							//'S', "stickWood"
						//}));
						//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//}
					//else {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							//"MMM",
							//" S ",
							//" S ",
							//'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							//'S', "stickWood"
						//}));
						//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//}
					if(Config.debug) {
						UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
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
		/**try {
			Field f = Config.class.getDeclaredField(material + "_" + "blocks");
			if(!f.getBoolean(UpgradeRecipesMod.cfg) == true) {
				Field fi = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
				if(fi.getBoolean(UpgradeRecipesMod.cfg) == true) {
					String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
					ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
					if(Item.REGISTRY.containsKey(item)) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							"MMM",
							" U ",
							" S ",
							//'M', UpgradeRecipesCommonProxy.ToolMaterialMap.get(material),
							'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType)),
							'S', "stickWood"
						//}));
						}).setRegistryName(material + "_" + ItemType.toLowerCase()));
						if(Config.debug) {
							UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
						}
					}
				}
			}
			else {
				Field fi = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
				if(fi.getBoolean(UpgradeRecipesMod.cfg) == true) {
					//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material).replaceAll("ingot", "block").replaceAll("gem", "block");
					//if(!Mat.contains("block")) {
						//if(Mat.contains(":")) {
							//Mat = Mat.replaceAll(":", ":block");
						//}
						//else {
							//Mat = "block" + Mat;
							//Mat = "block" + Mat.substring(0, 1).toUpperCase() + Mat.substring(1);
						//}
					//}
					//String Mat = getBlockOreDict(UpgradeRecipesCommonProxy.ToolMaterialMap.get(material));
					String Mat = getBlockOreDict(material);
					ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
					if(Item.REGISTRY.containsKey(item)) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							"MMM",
							" U ",
							" S ",
							//'M', UpgradeRecipesCommonProxy.ToolMaterialMap.get(material).replaceAll("ingot", "block").replaceAll("gem", "block"),
							'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType)),
							'S', "stickWood"
						//}));
						}).setRegistryName(material + "_" + ItemType.toLowerCase()));
						if(Config.debug) {
							UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			UpgradeRecipesMod.log.catching(e);
		}*/
	}
	
	/**
	 * adds a standard Axe upgrade recipe.
	 * @param material
	 */
	//protected static void addAxeRecipe(String material, boolean blocks) {
	protected static void addAxeRecipe(String material) {
		if(!Config.tools) {
			return;
		}
		String ItemType = "Axe";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_" + "blocks");
				//Field f = Config.class.getDeclaredField(material + "_" + "blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = getBlockOreDict(material);
				}
				//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						"MM",
						"MU",
						" S",
						'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
						//'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType)),
						'U', Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? "stickWood" : Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)),
						'S', "stickWood"
					//}));
					}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//Item upgrade = Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType));
					//if(upgrade != null) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							//"MM",
							//"MU",
							//" S",
							//'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							//'U', upgrade,
							//'S', "stickWood"
						//}));
						//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//}
					//else {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							//"MM",
							//"MS",
							//" S",
							//'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							//'S', "stickWood"
						//}));
						//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//}
					if(Config.debug) {
						UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
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
		/**try {
			Field f = Config.class.getDeclaredField(material + "_" + "blocks");
			if(!f.getBoolean(UpgradeRecipesMod.cfg) == true) {
				Field fi = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
				if(fi.getBoolean(UpgradeRecipesMod.cfg) == true) {
					String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
					ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
					if(Item.REGISTRY.containsKey(item)) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							"MM",
							"MU",
							" S",
							//'M', UpgradeRecipesCommonProxy.ToolMaterialMap.get(material),
							'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType)),
							'S', "stickWood"
						//}));
						}).setRegistryName(material + "_" + ItemType.toLowerCase()));
						if(Config.debug) {
							UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
						}
					}
				}
			}
			else {
				Field fi = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
				if(fi.getBoolean(UpgradeRecipesMod.cfg) == true) {
					//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material).replaceAll("ingot", "block").replaceAll("gem", "block");
					//if(!Mat.contains("block")) {
						//if(Mat.contains(":")) {
							//Mat = Mat.replaceAll(":", ":block");
						//}
						//else {
							//Mat = "block" + Mat;
						//}
					//}
					//String Mat = getBlockOreDict(UpgradeRecipesCommonProxy.ToolMaterialMap.get(material));
					String Mat = getBlockOreDict(material);
					ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
					if(Item.REGISTRY.containsKey(item)) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							"MM",
							"MU",
							" S",
							//'M', UpgradeRecipesCommonProxy.ToolMaterialMap.get(material).replaceAll("ingot", "block").replaceAll("gem", "block"),
							'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType)),
							'S', "stickWood"
						//}));
						}).setRegistryName(material + "_" + ItemType.toLowerCase()));
						if(Config.debug) {
							UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			UpgradeRecipesMod.log.catching(e);
		}*/
	}
	
	/**
	 * adds a standard Shovel upgrade recipe.
	 * @param material
	 */
	protected static void addShovelRecipe(String material) {
		if(!Config.tools) {
			return;
		}
		String ItemType = "Shovel";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_" + "blocks");
				//Field f = Config.class.getDeclaredField(material + "_" + "blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = getBlockOreDict(material);
				}
				//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						"M",
						"U",
						"S",
						'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
						//'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType)),
						'U', Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? "stickWood" : Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)),
						'S', "stickWood"
					//}));
					}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//Item upgrade = Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType));
					//if(upgrade != null) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							//"M",
							//"U",
							//"S",
							//'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							//'U', upgrade,
							//'S', "stickWood"
						//}));
						//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//}
					//else {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							//"M",
							//"S",
							//"S",
							//'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							//'S', "stickWood"
						//}));
						//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//}
					if(Config.debug) {
						UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
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
		/**try {
			Field f = Config.class.getDeclaredField(material + "_" + "blocks");
			if(!f.getBoolean(UpgradeRecipesMod.cfg) == true) {
				Field fi = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
				if(fi.getBoolean(UpgradeRecipesMod.cfg) == true) {
					String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
					ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
					if(Item.REGISTRY.containsKey(item)) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							"M",
							"U",
							"S",
							//'M', UpgradeRecipesCommonProxy.ToolMaterialMap.get(material),
							'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType)),
							'S', "stickWood"
						//}));
						}).setRegistryName(material + "_" + ItemType.toLowerCase()));
						if(Config.debug) {
							UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
						}
					}
				}
			}
			else {
				Field fi = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
				if(fi.getBoolean(UpgradeRecipesMod.cfg) == true) {
					//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material).replaceAll("ingot", "block").replaceAll("gem", "block");
					//if(!Mat.contains("block")) {
						//if(Mat.contains(":")) {
							//Mat = Mat.replaceAll(":", ":block");
						//}
						//else {
							//Mat = "block" + Mat;
						//}
					//}
					//String Mat = getBlockOreDict(UpgradeRecipesCommonProxy.ToolMaterialMap.get(material));
					String Mat = getBlockOreDict(material);
					ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
					if(Item.REGISTRY.containsKey(item)) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							"M",
							"U",
							"S",
							//'M', UpgradeRecipesCommonProxy.ToolMaterialMap.get(material).replaceAll("ingot", "block").replaceAll("gem", "block"),
							'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType)),
							'S', "stickWood"
						//}));
						}).setRegistryName(material + "_" + ItemType.toLowerCase()));
						if(Config.debug) {
							UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			UpgradeRecipesMod.log.catching(e);
		}*/
	}
	
	/**
	 * adds a standard Hoe upgrade recipe.
	 * @param material
	 */
	protected static void addHoeRecipe(String material) {
		if(!Config.tools) {
			return;
		}
		String ItemType = "Hoe";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_" + "blocks");
				//Field f = Config.class.getDeclaredField(material + "_" + "blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = getBlockOreDict(material);
				}
				//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						"MM",
						" U",
						" S",
						'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
						//'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType)),
						'U', Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? "stickWood" : Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)),
						'S', "stickWood"
					//}));
					}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//Item upgrade = Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType));
					//if(upgrade != null) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							//"MM",
							//" U",
							//" S",
							//'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							//'U', upgrade,
							//'S', "stickWood"
						//}));
						//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//}
					//else {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							//"MM",
							//" S",
							//" S",
							//'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							//'S', "stickWood"
						//}));
						//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//}
					if(Config.debug) {
						UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
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
		/**try {
			Field f = Config.class.getDeclaredField(material + "_" + "blocks");
			if(!f.getBoolean(UpgradeRecipesMod.cfg) == true) {
				Field fi = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
				if(fi.getBoolean(UpgradeRecipesMod.cfg) == true) {
					String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
					ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
					if(Item.REGISTRY.containsKey(item)) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							"MM",
							" U",
							" S",
							//'M', UpgradeRecipesCommonProxy.ToolMaterialMap.get(material),
							'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType)),
							'S', "stickWood"
						//}));
						}).setRegistryName(material + "_" + ItemType.toLowerCase()));
						if(Config.debug) {
							UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
						}
					}
				}
			}
			else {
				Field fi = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
				if(fi.getBoolean(UpgradeRecipesMod.cfg) == true) {
					//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material).replaceAll("ingot", "block").replaceAll("gem", "block");
					//if(!Mat.contains("block")) {
						//if(Mat.contains(":")) {
							//Mat = Mat.replaceAll(":", ":block");
						//}
						//else {
							//Mat = "block" + Mat;
						//}
					//}
					//String Mat = getBlockOreDict(UpgradeRecipesCommonProxy.ToolMaterialMap.get(material));
					String Mat = getBlockOreDict(material);
					ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
					if(Item.REGISTRY.containsKey(item)) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							"MM",
							" U",
							" S",
							//'M', UpgradeRecipesCommonProxy.ToolMaterialMap.get(material).replaceAll("ingot", "block").replaceAll("gem", "block"),
							'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType)),
							'S', "stickWood"
						//}));
						}).setRegistryName(material + "_" + ItemType.toLowerCase()));
						if(Config.debug) {
							UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			UpgradeRecipesMod.log.catching(e);
		}*/
	}
	
	/**
	 * adds a standard Sword upgrade recipe.
	 * @param material
	 */
	protected static void addSwordRecipe(String material) {
		if(!Config.tools) {
			return;
		}
		String ItemType = "Sword";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_" + "blocks");
				//Field f = Config.class.getDeclaredField(material + "_" + "blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = getBlockOreDict(material);
				}
				//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						"M",
						"M",
						"U",
						'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
						//'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType))
						'U', Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? "stickWood" : Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)),
					//}));
					}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//Item upgrade = Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType));
					//if(upgrade != null) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							//"M",
							//"M",
							//"U",
							//'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							//'U', upgrade
						//}));
						//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//}
					//else {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							//"M",
							//"M",
							//"S",
							//'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							//'S', "stickWood"
						//}));
						//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//}
					if(Config.debug) {
						UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
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
		/**try {
			Field f = Config.class.getDeclaredField(material + "_" + "blocks");
			if(!f.getBoolean(UpgradeRecipesMod.cfg) == true) {
				Field fi = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
				if(fi.getBoolean(UpgradeRecipesMod.cfg) == true) {
					ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
					if(Item.REGISTRY.containsKey(item)) {
						String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							"M",
							"M",
							"U",
							//'M', UpgradeRecipesCommonProxy.ToolMaterialMap.get(material),
							'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType))
						//}));
						}).setRegistryName(material + "_" + ItemType.toLowerCase()));
						if(Config.debug) {
							UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
						}
					}
				}
			}
			else {
				Field fi = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
				if(fi.getBoolean(UpgradeRecipesMod.cfg) == true) {
					//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material).replaceAll("ingot", "block").replaceAll("gem", "block");
					//if(!Mat.contains("block")) {
						//if(Mat.contains(":")) {
							//Mat = Mat.replaceAll(":", ":block");
						//}
						//else {
							//Mat = "block" + Mat;
						//}
					//}
					//String Mat = getBlockOreDict(UpgradeRecipesCommonProxy.ToolMaterialMap.get(material));
					String Mat = getBlockOreDict(material);
					ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
					if(Item.REGISTRY.containsKey(item)) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							"M",
							"M",
							"U",
							//'M', UpgradeRecipesCommonProxy.ToolMaterialMap.get(material).replaceAll("ingot", "block").replaceAll("gem", "block"),
							'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType))
						//}));
						}).setRegistryName(material + "_" + ItemType.toLowerCase()));
						if(Config.debug) {
							UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			UpgradeRecipesMod.log.catching(e);
		}*/
	}
	
	/**
	 * adds a standard Bow upgrade recipe.
	 * @param material
	 */
	protected static void addBowRecipe(String material) {
		if(!Config.tools) {
			return;
		}
		String ItemType = "Bow";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_" + "blocks");
				//Field f = Config.class.getDeclaredField(material + "_" + "blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = getBlockOreDict(material);
				}
				//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						" MS",
						"M U",
						" MS",
						'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
						//'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType)),
						'U', Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? "string" : Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)),
						'S', "string"
					//}));
					}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//Item upgrade = Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType));
					//if(upgrade != null) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							//" MS",
							//"M U",
							//" MS",
							//'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							//'U', upgrade,
							//'S', "string"
						//}));
						//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//}
					//else {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							//" MS",
							//"M S",
							//" MS",
							//'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							//'S', "string"
						//}));
						//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//}
					if(Config.debug) {
						UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
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
	 * adds a standard Wyvern Tool upgrade recipe.
	 * @param ItemType the ItemType.(Pickaxe / Axe / Shovel / Hoe / Sword / Bow)
	 */
	//public static void createWyvernRecipe(String ItemType) {
	public static void createWyvernToolRecipe(String ItemType) {
		if(!Config.tools) {
			return;
		}
		String material = "wyvern";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				//String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_" + "blocks");
				//Field f = Config.class.getDeclaredField(material + "_" + "blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = getBlockOreDict(material);
				}
				ItemStack wyvern_core = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:wyvern_core")));
				ItemStack wyvern_energy_core = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:wyvern_energy_core")));
				//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						" C ",
						"MUM",
						" E ",
						'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
						//'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType)),
						'U', Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Item.REGISTRY.getObject(new ResourceLocation(ItemType.equalsIgnoreCase("bow") ? "bow" : ("diamond_" + ItemType))) : Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)),
						'C', wyvern_core,
						'E', wyvern_energy_core
					//}));
					}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//Item upgrade = Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType));
					//if(upgrade != null) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							//" C ",
							//"MUM",
							//" E ",
							//'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							//'U', upgrade,
							//'C', wyvern_core,
							//'E', wyvern_energy_core
						//}));
						//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//}
					//else {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							//" C ",
							//"MUM",
							//" E ",
							//'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							//'U', Item.REGISTRY.getObject(new ResourceLocation("diamond_" + ItemType)),
							//'C', wyvern_core,
							//'E', wyvern_energy_core
						//}));
						//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//}
					if(Config.debug) {
						UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
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
	 * adds a standard Wyvern Armor upgrade recipe.
	 * @param ItemType the ItemType.(Helmet / Chestplate / Leggings / Boots)
	 */
	public static void createWyvernArmorRecipe(String ItemType) {
		if(!Config.armor) {
			return;
		}
		String material = "wyvern";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_" + "blocks");
				//Field f = Config.class.getDeclaredField(material + "_" + "blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = getBlockOreDict(material);
				}
				ItemStack wyvern_core = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:wyvern_core")));
				ItemStack wyvern_energy_core = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:wyvern_energy_core")));
				//ResourceLocation item = UpgradeRecipesCommonProxy.ArmorMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						"MCM",
						"MUM",
						"MEM",
						'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
						//'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType)),
						'U', Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)) == null ? Item.REGISTRY.getObject(new ResourceLocation("diamond_" + ItemType)) : Item.REGISTRY.getObject(RecipeAdd.getUpgradeMaterial(material, ItemType)),
						'C', wyvern_core,
						'E', wyvern_energy_core
					//}));
					}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//Item upgrade = Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType));
					//if(upgrade != null) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							//"MCM",
							//"MUM",
							//"MEM",
							//'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							//'U', upgrade,
							//'C', wyvern_core,
							//'E', wyvern_energy_core
						//}));
						//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//}
					//else {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							//"MCM",
							//"MUM",
							//"MEM",
							//'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							//'U', Item.REGISTRY.getObject(new ResourceLocation("diamond_" + ItemType)),
							//'C', wyvern_core,
							//'E', wyvern_energy_core
						//}));
						//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					//}
					if(Config.debug) {
						UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
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
	 * adds a standard Draconic Tool upgrade recipe.
	 * @param ItemType the ItemType.(Pickaxe / Axe / Shovel / Hoe / Sword / Bow / Helmet / Chestplate / Leggings / Boots)
	 */
	/*public static void createDraconicToolRecipe(String ItemType) {
		String material = "draconic";
		try {
			Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				String Mat = UpgradeRecipesCommonProxy.ToolMaterialMap.get(material);
				f = Config.class.getDeclaredField(material + "_awakened_blocks");
				if(f.getBoolean(UpgradeRecipesMod.cfg)) {
					Mat = getBlockOreDict(material);
				}
				ItemStack awakened_core = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:awakened_core")));
				ItemStack awakened_energy_core = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:draconic_energy_core")));
				//Item awakened_core = Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:awakened_core"));
				//Item awakened_energy_core = Item.REGISTRY.getObject(new ResourceLocation("draconicevolution:draconic_energy_core"));
				ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					//FusionRecipeAPI.registry.add(new SimpleFusionRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType))), 64000, 2, new Object[] {
					FusionRecipeAPI.registry.add(new SimpleFusionRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType))), 16000, 2, new Object[] {
					//FusionRecipeAPI.registry.add(new SimpleFusionRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new ItemStack(Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType))), 64, 2, new Object[] {
						//awakened_core, awakened_energy_core, Mat, Mat
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
	}*/
	
	/**
	 * adds a standard Helmet upgrade recipe.
	 * @param material
	 */
	protected static void addHelmetRecipe(String material) {
		if(!Config.armor) {
			return;
		}
		String ItemType = "Helmet";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_" + "blocks");
				//Field f = Config.class.getDeclaredField(material + "_" + "blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = getBlockOreDict(material);
				}
				//ResourceLocation item = UpgradeRecipesCommonProxy.ArmorMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//	"MMM",
					//	"MUM",
					//	'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
					//	'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType))
					//}));
					//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					Item upgrade = Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType));
					if(upgrade != null) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							"MMM",
							"MUM",
							'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							'U', upgrade
						//}));
						}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					}
					else {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							"MMM",
							"M M",
							'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat
						//}));
						}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					}
					if(Config.debug) {
						UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
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
	 * adds a standard Chestplate upgrade recipe.
	 * @param material
	 */
	protected static void addChestplateRecipe(String material) {
		if(!Config.armor) {
			return;
		}
		String ItemType = "Chestplate";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_" + "blocks");
				//Field f = Config.class.getDeclaredField(material + "_" + "blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = getBlockOreDict(material);
				}
				//ResourceLocation item = UpgradeRecipesCommonProxy.ArmorMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//	"MUM",
					//	"MMM",
					//	"MMM",
					//	'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
					//	'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType))
					//}));
					//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					Item upgrade = Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType));
					if(upgrade != null) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							"MUM",
							"MMM",
							"MMM",
							'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							'U', upgrade
						//}));
						}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					}
					else {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							"M M",
							"MMM",
							"MMM",
							'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat
						//}));
						}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					}
					if(Config.debug) {
						UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
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
	 * adds a standard Leggings upgrade recipe.
	 * @param material
	 */
	protected static void addLeggingsRecipe(String material) {
		if(!Config.armor) {
			return;
		}
		String ItemType = "Leggings";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_" + "blocks");
				//Field f = Config.class.getDeclaredField(material + "_" + "blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = getBlockOreDict(material);
				}
				//ResourceLocation item = UpgradeRecipesCommonProxy.ArmorMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//	"MMM",
					//	"MUM",
					//	"M M",
					//	'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
					//	'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType))
					//}));
					//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					Item upgrade = Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType));
					if(upgrade != null) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							"MMM",
							"MUM",
							"M M",
							'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							'U', upgrade
						//}));
						}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					}
					else {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							"MMM",
							"M M",
							"M M",
							'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat
						//}));
						}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					}
					if(Config.debug) {
						UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
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
	 * adds a standard Boots upgrade recipe.
	 * @param material
	 */
	protected static void addBootsRecipe(String material) {
		if(!Config.armor) {
			return;
		}
		String ItemType = "Boots";
		try {
			//Field f = Config.class.getDeclaredField(material + "_" + ItemType.toLowerCase());
			//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
				//f = Config.class.getDeclaredField(material + "_" + "blocks");
				//Field f = Config.class.getDeclaredField(material + "_" + "blocks");
				//if(f.getBoolean(UpgradeRecipesMod.cfg)) {
				if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
					Mat = getBlockOreDict(material);
				}
				//ResourceLocation item = UpgradeRecipesCommonProxy.ArmorMap.get(material + ":" + ItemType.toLowerCase());
				ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
				if(Item.REGISTRY.containsKey(item)) {
					//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//	"MUM",
					//	"M M",
					//	'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
					//	'U', Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType))
					//}));
					//}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					Item upgrade = Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType));
					if(upgrade != null) {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							"MUM",
							"M M",
							'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
							'U', upgrade
						//}));
						}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					}
					else {
						//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
							"M M",
							"M M",
							'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat
						//}));
						}).setRegistryName(material + "_" + ItemType.toLowerCase()));
					}
					if(Config.debug) {
						UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
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
	 * adds a standard Tritanium Helmet upgrade recipe.
	 * @param material
	 */
	protected static void addTritaniumHelmetRecipe() {
		if(!Config.armor) {
			return;
		}
		String material = "tritanium";
		String ItemType = "Helmet";
		try {
			String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
			if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
				Mat = getBlockOreDict(material);
			}
			ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
			if(Item.REGISTRY.containsKey(item)) {
				Item circuit = null;
				if(Item.REGISTRY.containsKey(new ResourceLocation("mo", "isolinear_circuit"))) {
					circuit = Item.REGISTRY.getObject(new ResourceLocation("mo", "isolinear_circuit"));
				}
				else {
					circuit = Item.REGISTRY.getObject(new ResourceLocation("matteroverdrive", "isolinear_circuit"));
				}
				Item upgrade = Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType));
				if(upgrade != null) {
					//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						"MCM",
						"MUM",
						'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
						//'C', new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("mo", "isolinear_circuit")), 1, 1),
						//'C', circuit,
						'C', new ItemStack(circuit, 1, 1),
						'U', upgrade
					//}));
					}).setRegistryName(material + "_" + ItemType.toLowerCase()));
				}
				else {
					//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						"MCM",
						"M M",
						'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
						//'C', new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("mo", "isolinear_circuit")), 1, 1)
						//'C', circuit
						'C', new ItemStack(circuit, 1, 1),
					//}));
					}).setRegistryName(material + "_" + ItemType.toLowerCase()));
				}
				if(Config.debug) {
					UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			if(Config.debug) {
				UpgradeRecipesMod.log.catching(e);
			}
		}
	}
	
	/**
	 * adds a standard Tritanium Chestplate upgrade recipe.
	 * @param material
	 */
	protected static void addTritaniumChestplateRecipe() {
		if(!Config.armor) {
			return;
		}
		String material = "tritanium";
		String ItemType = "Chestplate";
		try {
			String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
			if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
				Mat = getBlockOreDict(material);
			}
			ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
			if(Item.REGISTRY.containsKey(item)) {
				Item circuit = null;
				if(Item.REGISTRY.containsKey(new ResourceLocation("mo", "isolinear_circuit"))) {
					circuit = Item.REGISTRY.getObject(new ResourceLocation("mo", "isolinear_circuit"));
				}
				else {
					circuit = Item.REGISTRY.getObject(new ResourceLocation("matteroverdrive", "isolinear_circuit"));
				}
				Item upgrade = Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType));
				if(upgrade != null) {
					//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						"MUM",
						"MCM",
						"MMM",
						'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
						//'C', new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("mo", "isolinear_circuit")), 1, 1),
						//'C', circuit,
						'C', new ItemStack(circuit, 1, 1),
						'U', upgrade
					//}));
					}).setRegistryName(material + "_" + ItemType.toLowerCase()));
				}
				else {
					//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						"M M",
						"MCM",
						"MMM",
						'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
						//'C', new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("mo", "isolinear_circuit")), 1, 1)
						//'C', circuit
						'C', new ItemStack(circuit, 1, 1),
					//}));
					}).setRegistryName(material + "_" + ItemType.toLowerCase()));
				}
				if(Config.debug) {
					UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			if(Config.debug) {
				UpgradeRecipesMod.log.catching(e);
			}
		}
	}
	
	/**
	 * adds a standard Tritanium Leggings upgrade recipe.
	 * @param material
	 */
	protected static void addTritaniumLeggingsRecipe() {
		if(!Config.armor) {
			return;
		}
		String material = "tritanium";
		String ItemType = "Leggings";
		try {
			String Mat = UpgradeRecipesCommonProxy.MaterialMap.get(material);
			if(UpgradeRecipesMod.cfg.blockEnabled(material, "")) {
				Mat = getBlockOreDict(material);
			}
			ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(material + ":" + ItemType.toLowerCase());
			if(Item.REGISTRY.containsKey(item)) {
				Item circuit = null;
				if(Item.REGISTRY.containsKey(new ResourceLocation("mo", "isolinear_circuit"))) {
					circuit = Item.REGISTRY.getObject(new ResourceLocation("mo", "isolinear_circuit"));
				}
				else {
					circuit = Item.REGISTRY.getObject(new ResourceLocation("matteroverdrive", "isolinear_circuit"));
				}
				Item upgrade = Item.REGISTRY.getObject(getUpgradeMaterial(material, ItemType));
				if(upgrade != null) {
					//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						"MCM",
						"MUM",
						"M M",
						'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
						//'C', new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("mo", "isolinear_circuit")), 1, 1),
						//'C', circuit,
						'C', new ItemStack(circuit, 1, 1),
						'U', upgrade
					//}));
					}).setRegistryName(material + "_" + ItemType.toLowerCase()));
				}
				else {
					//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					//GameRegistry.addRecipe(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
					ForgeRegistries.RECIPES.register(new ShapedOreRecipe(null, new ItemStack(Item.REGISTRY.getObject(item)), new Object[] {
						"MCM",
						"M M",
						"M M",
						'M', Mat.contains(":") ? Item.REGISTRY.getObject(new ResourceLocation(Mat)) : Mat,
						//'C', new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("mo", "isolinear_circuit")), 1, 1)
						//'C', circuit
						'C', new ItemStack(circuit, 1, 1),
					//}));
					}).setRegistryName(material + "_" + ItemType.toLowerCase()));
				}
				if(Config.debug) {
					UpgradeRecipesMod.log.info("Added Recipe for " + item.getResourcePath() + "!");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			if(Config.debug) {
				UpgradeRecipesMod.log.catching(e);
			}
		}
	}
	
	/**
	 * Initializes the Material Tier Lists.
	 */
	//public static void initTiersLists() {
	protected static void initTiersLists() {
		for(Materials mat:Materials.values()) {
			if(mat.isEnabled()) {
				Tiers.add(mat.getName().toLowerCase());
			}
		}
		/*if(Config.tools) {
			//boolean gem = false;
			for(Materials mat:Materials.values()) {
				if(mat.isEnabled()) {
					ToolTiers.add(mat.getName().toLowerCase());
					//if(mat.isGem()) {
						//gem = true;
					//}
				}
			}
			//ToolTiers.add("wood");//Wood and Diamond being registered without checking if they enabled because they are needed.
			*//*ToolTiers.add("wood");//Wood is being registered without checking if Wood is enabled because Wood is needed.
			//if(Config.stone) {
				//ToolTiers.add("stone");
			//}
			if(Config.vanilla) {
				if(Config.stone) {
					ToolTiers.add("stone");
				}
				if(Config.iron) {
					ToolTiers.add("iron");
				}
				if(Config.gold) {
					ToolTiers.add("gold");
				}
			}
			if(Config.trigems) {
				if(Config.topaz) {
					ToolTiers.add("topaz");
					gem = true;
				}
				if(Config.rubyt) {
					ToolTiers.add("rubyt");
					gem = true;
				}
			}
			if(Config.rubymod) {
				if(Config.rubyr) {
					ToolTiers.add("rubyr");
					gem = true;
				}
			}
			if(Config.vanilla) {
				if(Config.diamond) {
					ToolTiers.add("diamond");
					gem = true;
				}
			}
			//ToolTiers.add("diamond");//Wood and Diamond being registered without checking if they enabled because they are needed.
			if(Config.trigems) {
				if(Config.sapphire) {
					ToolTiers.add("sapphire");
					gem = true;
				}
				if(Config.emeraldt) {
					ToolTiers.add("emeraldt");
					gem = true;
				}
			}
			if(Config.rubymod) {
				if(Config.emeraldr) {
					ToolTiers.add("emeraldr");
					gem = true;
				}
			}
			if(!gem) {
				ToolTiers.add("diamond");//Diamond is being registered without checking if Diamond is enabled if no other gem is enabled.
			}
			//if(Config.avaritia) {
				//if(Config.skullfire) {
					//ToolTiers.add("skullfire");//oops the Skullfire Sword is stronger...
				//}
			//}
			if(Config.weapons) {
				if(Config.redcrystal) {
					ToolTiers.add("redcrystal");
				}
			}
			if(Config.stars) {
				if(Config.netherstar) {
					ToolTiers.add("netherstar");
				}
			}
			if(Config.avaritia) {
				if(Config.skullfire) {
					ToolTiers.add("skullfire");
				}
			}
			//if(Config.wyvern) {
				//ToolTiers.add("wyvern");
			//}
			if(Config.draconicevolution) {
				if(Config.wyvern) {
					ToolTiers.add("wyvern");
				}
				if(Config.draconic) {
					ToolTiers.add("draconic");
				}
			}
			if(Config.avaritia) {
				if(Config.infinity) {
					ToolTiers.add("infinity");
				}
			}*//*
		}
		if(Config.armor) {
			boolean gem = false;
			//ArmorTiers.add("leather");//Leather and Diamond being registered without checking if they enabled because they are needed.
			ArmorTiers.add("leather");//Leather is being registered without checking if Leather is enabled because Leather is needed.
			if(Config.vanilla) {
				if(Config.chain) {
					ArmorTiers.add("chain");
				}
				if(Config.iron) {
					ArmorTiers.add("iron");
				}
				if(Config.gold) {
					ArmorTiers.add("gold");
				}
			}
			if(Config.trigems) {
				if(Config.topaz) {
					ArmorTiers.add("topaz");
					gem = true;
				}
				if(Config.rubyt) {
					ArmorTiers.add("rubyt");
					gem = true;
				}
			}
			if(Config.rubymod) {
				if(Config.rubyr) {
					ArmorTiers.add("rubyr");
					gem = true;
				}
			}
			if(Config.vanilla) {
				if(Config.diamond) {
					ArmorTiers.add("diamond");
					gem = true;
				}
			}
			//ArmorTiers.add("diamond");//Leather and Diamond being registered without checking if they enabled because they are needed.
			if(Config.trigems) {
				if(Config.sapphire) {
					ArmorTiers.add("sapphire");
					gem = true;
				}
				if(Config.emeraldt) {
					ArmorTiers.add("emeraldt");
					gem = true;
				}
			}
			if(Config.rubymod) {
				if(Config.emeraldr) {
					ArmorTiers.add("emeraldr");
					gem = true;
				}
			}
			if(!gem) {
				ArmorTiers.add("diamond");//Diamond is being registered without checking if Diamond is enabled if no other gem is enabled.
			}
			if(Config.weapons) {
				if(Config.redcrystal) {
					ArmorTiers.add("redcrystal");
				}
			}
			if(Config.stars) {
				if(Config.netherstar) {
					ArmorTiers.add("netherstar");
				}
			}
			if(Config.draconicevolution) {
				if(Config.wyvern) {
					ArmorTiers.add("wyvern");
				}
				if(Config.draconic) {
					ArmorTiers.add("draconic");
				}
			}
			if(Config.avaritia) {
				if(Config.infinity) {
					ArmorTiers.add("infinity");
				}
			}
		}*/
	}
	
	/**
	 * This method gets the Material to use as Ingredient for the given other with the given ItemType.
	 * @param UpgradetMaterial the Material after upgrading.
	 * @param ItemType the ItemType.(Pickaxe / Axe / Shovel / Hoe / Sword / Bow / Helmet / Chestplate / Leggings / Boots)
	 * @return
	 */
	//private static String getUpgradeMaterial(String UpgradetMaterial) {
	//private static String getUpgradeMaterial(String UpgradetMaterial, String ItemType) {
	//private static ResourceLocation getUpgradeMaterial(String UpgradetMaterial, String ItemType) {
	protected static ResourceLocation getUpgradeMaterial(String UpgradetMaterial, String ItemType) {
		ResourceLocation ret = null;
		int i = 0;
		while(i < Tiers.size()) {
			if(Tiers.get(i).equalsIgnoreCase(UpgradetMaterial)) {
				try {
					int ii = 1;
					while(ii <= i) {
						try {
							//Materials mat = Materials.valueOf(UpgradetMaterial.toUpperCase());
							//Materials mat = Materials.valueOf(Tiers.get(i - ii));
							Materials mat = Materials.valueOf(Tiers.get(i - ii).toUpperCase());
							//if(mat == null) {
								//ii++;
							//}
							//else {
							if(mat != null) {
								if(UpgradeRecipesCommonProxy.ArrayContains(mat.getTypes(), ItemType.toLowerCase())) {
									if(UpgradeRecipesMod.cfg.isToolEnabled(mat.getName(), ItemType.toLowerCase(), mat.getMod())) {
										String key = Tiers.get(i - ii) + ":" + ItemType.toLowerCase();
										//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(key);
										ResourceLocation item = UpgradeRecipesCommonProxy.ItemMap.get(key);
										if(Item.REGISTRY.containsKey(item)) {
											//ret = UpgradeRecipesCommonProxy.ToolMap.get(key);
											ret = UpgradeRecipesCommonProxy.ItemMap.get(key);
											if(Config.debug) {
												UpgradeRecipesMod.log.info("Upgrade Material: " + ret.getResourcePath() + "!");
											}
											break;
										}
										//else {
											//ii++;
										//}
									}
									//else {
										//ii++;
									//}
								}
								//else {
									//ii++;
								//}
							}
						} catch (Exception e) {
							// TODO: handle exception
							if(Config.debug) {
								UpgradeRecipesMod.log.catching(e);
							}
						}
						ii++;
						/*boolean bool = false;
						if(Tiers.get(i - ii).equals("wood") || Tiers.get(i - ii).equals("diamond")) {
							bool = true;
						}
						try {
							Field f = Config.class.getDeclaredField(Tiers.get(i - ii));
							if(f.getBoolean(UpgradeRecipesMod.cfg)) {
								bool = true;
							}
						} catch (Exception e) {
							// TODO: handle exception
							if(Config.debug) {
								UpgradeRecipesMod.log.catching(e);
							}
						}
						if(bool) {
							String key = Tiers.get(i - ii) + ":" + ItemType.toLowerCase();
							bool = false;
							if(Tiers.get(i - ii).equals("wood") || Tiers.get(i - ii).equals("diamond")) {
								bool = true;
							}
							try {
								Field f = Config.class.getDeclaredField(key.replaceAll(":", "_"));
								if(f.getBoolean(UpgradeRecipesMod.cfg)) {
									bool = true;
								}
							} catch (Exception e) {
								// TODO: handle exception
								if(Config.debug) {
									UpgradeRecipesMod.log.catching(e);
								}
							}
							if(bool) {
								ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(key);
								if(Item.REGISTRY.containsKey(item)) {
									ret = UpgradeRecipesCommonProxy.ToolMap.get(key);
									if(Config.debug) {
										UpgradeRecipesMod.log.info("Upgrade Material: " + ret.getResourcePath() + "!");
									}
									break;
								}
							}
						}
						ii++;*/
					}
				} catch (Exception e) {
					// TODO: handle exception
					if(Config.debug) {
						UpgradeRecipesMod.log.catching(e);
					}
				}
			}
			i++;
		}
		return ret;
		//String ret = "";
		//ResourceLocation ret;
		/*ResourceLocation ret = null;
		int i = 0;
		if(ItemType.equalsIgnoreCase("Pickaxe") || ItemType.equalsIgnoreCase("Axe") || ItemType.equalsIgnoreCase("Shovel") || ItemType.equalsIgnoreCase("Hoe") || ItemType.equalsIgnoreCase("Sword") || ItemType.equalsIgnoreCase("Bow")) {
			while(i < ToolTiers.size()) {
				if(ToolTiers.get(i).equalsIgnoreCase(UpgradetMaterial)) {
					try {
						int ii = 1;
						while(ii <= i) {
							boolean bool = false;
							if(ToolTiers.get(i - ii).equals("wood") || ToolTiers.get(i - ii).equals("diamond")) {
								bool = true;
							}
							try {
								Field f = Config.class.getDeclaredField(ToolTiers.get(i - ii));
								if(f.getBoolean(UpgradeRecipesMod.cfg)) {
									bool = true;
								}
							} catch (Exception e) {
								// TODO: handle exception
								if(Config.debug) {
									UpgradeRecipesMod.log.catching(e);
								}
							}
							//Field f = Config.class.getDeclaredField("debug");
							//try {
								//f = Config.class.getDeclaredField(ToolTiers.get(i - ii));
							//} catch (Exception e) {
								// TODO: handle exception
								//UpgradeRecipesMod.log.catching(e);
								//if(Config.debug) {
									//UpgradeRecipesMod.log.catching(e);
								//}
							//}
							//Field f = Config.class.getDeclaredField(ToolTiers.get(i - ii));
							//if(f.getBoolean(UpgradeRecipesMod.cfg) == true || ToolTiers.get(i - 1).equalsIgnoreCase("wood") || ToolTiers.get(i - 1).equalsIgnoreCase("diamod")) {
							if(bool) {
								String key = ToolTiers.get(i - ii) + ":" + ItemType.toLowerCase();
								//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(ToolTiers.get(i - ii) + ":" + ItemType.toLowerCase());
								//ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(key);
								//if(Item.REGISTRY.containsKey(item)) {
									//ret = UpgradeRecipesCommonProxy.ToolMap.get(key);
									//break;
								//}
								bool = false;
								if(ToolTiers.get(i - ii).equals("wood") || ToolTiers.get(i - ii).equals("diamond")) {
									bool = true;
								}
								try {
									Field f = Config.class.getDeclaredField(key.replaceAll(":", "_"));
									if(f.getBoolean(UpgradeRecipesMod.cfg)) {
										bool = true;
									}
								} catch (Exception e) {
									// TODO: handle exception
									if(Config.debug) {
										UpgradeRecipesMod.log.catching(e);
									}
								}
								//try {
									//f = Config.class.getDeclaredField(key.replaceAll(":", "_"));
								//} catch (Exception e) {
									// TODO: handle exception
									//UpgradeRecipesMod.log.catching(e);
									//if(Config.debug) {
										//UpgradeRecipesMod.log.catching(e);
									//}
								//}
								//Field fi = Config.class.getDeclaredField(key.replaceAll(":", "_"));
								//if(fi.getBoolean(UpgradeRecipesMod.cfg) == true || ToolTiers.get(i - ii).equals("wood") || ToolTiers.get(i - ii).equals("diamod")) {
								//if(f.getBoolean(UpgradeRecipesMod.cfg) == true || ToolTiers.get(i - ii).equals("wood") || ToolTiers.get(i - ii).equals("diamod")) {
								if(bool) {
									ResourceLocation item = UpgradeRecipesCommonProxy.ToolMap.get(key);
									if(Item.REGISTRY.containsKey(item)) {
										ret = UpgradeRecipesCommonProxy.ToolMap.get(key);
										if(Config.debug) {
											UpgradeRecipesMod.log.info("Upgrade Material: " + ret.getResourcePath() + "!");
										}
										break;
									}
								}
							}
							ii++;
						}
						//Field f = Config.class.getDeclaredField(ToolTiers.get(i - 1));
						//if(f.getBoolean(UpgradeRecipesMod.cfg) == true || ToolTiers.get(i - 1).equalsIgnoreCase("wood") || ToolTiers.get(i - 1).equalsIgnoreCase("diamod")) {
							//ResourceLocation item = new ResourceLocation(UpgradeRecipesCommonProxy.materialMap.get(ToolTiers.get(i - 1)) + ItemType.toLowerCase());
							//if(Item.REGISTRY.containsKey(item)) {
								//ret = UpgradeRecipesCommonProxy.materialMap.get(ToolTiers.get(i - 1));
							//}
						//}
					} catch (Exception e) {
						// TODO: handle exception
						//e.printStackTrace();
						//UpgradeRecipesMod.log.catching(e);
						//return e.getMessage();
						if(Config.debug) {
							UpgradeRecipesMod.log.catching(e);
						}
					}
				}
				i++;
			}
		}
		else if(ItemType.equalsIgnoreCase("Helmet") || ItemType.equalsIgnoreCase("Chestplate") || ItemType.equalsIgnoreCase("Leggings") || ItemType.equalsIgnoreCase("Boots")) {
			while(i < ArmorTiers.size()) {
				if(ArmorTiers.get(i).equalsIgnoreCase(UpgradetMaterial)) {
					try {
						int ii = 1;
						while(ii <= i) {
							boolean bool = false;
							if(ArmorTiers.get(i - ii).equals("leather") || ArmorTiers.get(i - ii).equals("diamond")) {
								bool = true;
							}
							try {
								Field f = Config.class.getDeclaredField(ArmorTiers.get(i - ii));
								if(f.getBoolean(UpgradeRecipesMod.cfg)) {
									bool = true;
								}
							} catch (Exception e) {
								// TODO: handle exception
								if(Config.debug) {
									UpgradeRecipesMod.log.catching(e);
								}
							}
							if(bool) {
								String key = ArmorTiers.get(i - ii) + ":" + ItemType.toLowerCase();
								bool = false;
								if(ArmorTiers.get(i - ii).equals("leather") || ArmorTiers.get(i - ii).equals("diamond")) {
									bool = true;
								}
								try {
									Field f = Config.class.getDeclaredField(key.replaceAll(":", "_"));
									if(f.getBoolean(UpgradeRecipesMod.cfg)) {
										bool = true;
									}
								} catch (Exception e) {
									// TODO: handle exception
									if(Config.debug) {
										UpgradeRecipesMod.log.catching(e);
									}
								}
								if(bool) {
									ResourceLocation item = UpgradeRecipesCommonProxy.ArmorMap.get(key);
									if(Item.REGISTRY.containsKey(item)) {
										ret = UpgradeRecipesCommonProxy.ArmorMap.get(key);
										if(Config.debug) {
											UpgradeRecipesMod.log.info("Upgrade Material: " + ret.getResourcePath() + "!");
										}
										break;
									}
								}
							}
							ii++;
						}
					} catch (Exception e) {
						// TODO: handle exception
						//e.printStackTrace();
						//UpgradeRecipesMod.log.catching(e);
						if(Config.debug) {
							UpgradeRecipesMod.log.catching(e);
						}
					}
				}
				i++;
			}
			i++;
		}
		return ret;*/
	}
	
	/**
	 * Generates the Block OreDict from the given Item OreDict.
	 * Can also non OreDict, but not good.
	 * @param itemOreDict
	 * @return
	 */
	protected static String getBlockOreDict(String itemOreDict) {
		String Block = itemOreDict;
		//if(UpgradeRecipesCommonProxy.ToolMaterialMap.containsKey(itemOreDict)) {
		if(UpgradeRecipesCommonProxy.MaterialMap.containsKey(itemOreDict)) {
			//Block = UpgradeRecipesCommonProxy.ToolMaterialMap.get(itemOreDict).replaceAll("ingot", "block").replaceAll("gem", "block");
			//Block = UpgradeRecipesCommonProxy.ToolMaterialMap.get(itemOreDict);
			Block = UpgradeRecipesCommonProxy.MaterialMap.get(itemOreDict);
			if(OreDictionary.getOres(itemOreDict, false).isEmpty() && !Item.REGISTRY.containsKey(new ResourceLocation(itemOreDict))) {
				itemOreDict = UpgradeRecipesCommonProxy.MaterialMap.get(itemOreDict);
			}
		}
		//String Block = UpgradeRecipesCommonProxy.ToolMaterialMap.get(itemOreDict).replaceAll("ingot", "block").replaceAll("gem", "block");
		//Block = Block.replaceAll("ingot", "block").replaceAll("gem", "block");
		//if(!OreDictionary.getOres(Block, false).isEmpty()) {
			//Block = Block.replaceAll("ingot", "block").replaceAll("gem", "block");
		//}
		//if(OreDictionary.getOres(itemOreDict, false).isEmpty() && Item.REGISTRY.containsKey(new ResourceLocation(itemOreDict))) {//NOT OREDICT
		if(OreDictionary.getOres(Block, false).isEmpty() && Item.REGISTRY.containsKey(new ResourceLocation(Block))) {//NOT OREDICT
			String[][] tries = new String[][] {{"block", "block"}, {"Block", "Block"}, {"ingotBlock", "gemBlock"}, {"IngotBlock", "GemBlock"}, {"blockIngot", "blockGem"}, {"BlockIngot", "BlockGem"}};//{ingot Replacement, gem Replacement}
			for(String[] sarr:tries) {
				if(sarr.length < 2) {
					break;
				}
				if(!Block.contains(":")) {
					Block = "minecraft:" + Block;
				}
				//Block = itemOreDict.replaceAll("ingot", sarr[0]).replaceAll("gem", sarr[1]);
				//Block = Block.replaceAll("ingot", sarr[0]).replaceAll("gem", sarr[1]);
				Block = Block.replaceAll("ingot", sarr[0]).replaceAll("gem", sarr[1]).replaceAll("plank", "log");
				//if(!Block.contains("block")) {
				if(!Block.contains("block") && !Block.contains("log")) {
					String Mat = Block.replaceAll(":", ":block");
					if(!Item.REGISTRY.containsKey(new ResourceLocation(Mat))) {
						Mat = Block + "block";
						if(!Item.REGISTRY.containsKey(new ResourceLocation(Mat))) {
							Mat = Block + "_block";
							if(!Item.REGISTRY.containsKey(new ResourceLocation(Mat))) {
								Mat = Block + "Block";
								if(!Item.REGISTRY.containsKey(new ResourceLocation(Mat))) {
									Mat = Block + "_Block";
									if(!Item.REGISTRY.containsKey(new ResourceLocation(Mat))) {
										Mat = Block.replaceAll(":", ":block_");
										if(!Item.REGISTRY.containsKey(new ResourceLocation(Mat))) {
											if(Config.debug) {
												UpgradeRecipesMod.log.warn("Couldn't get a Valid Block ID for Item ID " + itemOreDict + ".");
											}
										}
										else {
											Block = Mat;
											break;
										}
										//if(Config.debug) {
											//UpgradeRecipesMod.log.warn("Couldn't get a Valid Block ID for Item ID " + itemOreDict + ".");
										//}
									}
									else {
										Block = Mat;
										break;
									}
								}
								else {
									Block = Mat;
									break;
								}
							}
							else {
								Block = Mat;
								break;
							}
						}
						else {
							Block = Mat;
							break;
						}
					}
					else {
						Block = Mat;
						break;
					}
				}
			}
			if(Config.debug) {
				UpgradeRecipesMod.log.info("Processed " + itemOreDict + " as Item(not OreDict)!");
			}
		}
		else {//OREDICT!
			//Block = Block.replaceAll("ingot", "block").replaceAll("gem", "block");
			Block = Block.replaceAll("ingot", "block").replaceAll("gem", "block").replaceAll("plank", "log");
			//if(!Block.contains("block")) {
			if(!Block.contains("block") && !Block.contains("log")) {
				String Mat = "block" + Block;
				if(OreDictionary.getOres(Mat, false).isEmpty()) {
					Mat = "block" + Block.substring(0, 1).toUpperCase() + Block.substring(1);
					if(OreDictionary.getOres(Mat, false).isEmpty()) {
						Mat = "block" + Block.substring(0, 1).toUpperCase() + Block.substring(1).toLowerCase();
						if(OreDictionary.getOres(Mat, false).isEmpty()) {
							Mat = "block" + Block.toLowerCase();
							if(OreDictionary.getOres(Mat, false).isEmpty()) {
								if(Config.debug) {
									UpgradeRecipesMod.log.warn("Couldn't get a Valid Block OreDictionary Entry for Item OreDictionary " + itemOreDict + ".");
								}
							}
							else {
								Block = Mat;
							}
						}
						else {
							Block = Mat;
						}
					}
					else {
						Block = Mat;
					}
				}
				else {
					Block = Mat;
				}
			}
			if(Config.debug) {
				UpgradeRecipesMod.log.info("Processed " + itemOreDict + " as OreDict!");
			}
		}
		//if(!Block.contains("block")) {
			//if(Block.contains(":")) {//OreDict or not?
			//if(OreDictionary.getOres(itemOreDict, false).isEmpty() && Item.REGISTRY.containsKey(new ResourceLocation(itemOreDict))) {//NOT OREDICT
				//String[][] tries = new String[][] {{"block", "block"}, {"Block", "Block"}, {"ingotBlock", "gemBlock"}, {"IngotBlock", "GemBlock"}, {"blockIngot", "blockGem"}, {"BlockIngot", "BlockGem"}};//{ingot Replacement, gem Replacement}
				//for(String[] sarr:tries) {
					//if(sarr.length < 2) {
						//break;
					//}
					//Block = itemOreDict.replaceAll("ingot", sarr[0]).replaceAll("gem", sarr[1]);
					//String Mat = Block.replaceAll(":", ":block");
					//if(!Item.REGISTRY.containsKey(new ResourceLocation(Mat))) {
						//Mat = Block + "block";
						//if(!Item.REGISTRY.containsKey(new ResourceLocation(Mat))) {
							//Mat = Block + "_block";
							//if(!Item.REGISTRY.containsKey(new ResourceLocation(Mat))) {
								//Mat = Block + "Block";
								//if(!Item.REGISTRY.containsKey(new ResourceLocation(Mat))) {
									//if(Config.debug) {
										//UpgradeRecipesMod.log.warn("Couldn't get a Valid Block ID for Item ID " + itemOreDict + ".");
									//}
								//}
								//else {
									//Block = Mat;
								//}
							//}
							//else {
								//Block = Mat;
							//}
						//}
						//else {
							//Block = Mat;
						//}
					//}
					//else {
						//Block = Mat;
					//}
				//}
				//Block = Block.replaceAll(":", ":block");
				//String Mat = Block.replaceAll(":", ":block");
				//if(!Item.REGISTRY.containsKey(new ResourceLocation(Mat))) {
					//Mat = Block + "block";
					//if(!Item.REGISTRY.containsKey(new ResourceLocation(Mat))) {
						//Mat = Block + "_block";
						//if(!Item.REGISTRY.containsKey(new ResourceLocation(Mat))) {
							//Mat = Block + "Block";
							//if(!Item.REGISTRY.containsKey(new ResourceLocation(Mat))) {
								//if(Config.debug) {
									//UpgradeRecipesMod.log.warn("Couldn't get a Valid Block ID for Item ID " + itemOreDict + ".");
								//}
							//}
							//else {
								//Block = Mat;
							//}
							//if(Config.debug) {
								//UpgradeRecipesMod.log.warn("Couldn't get a Valid Block ID for Item ID " + itemOreDict + ".");
							//}
						//}
						//else {
							//Block = Mat;
						//}
					//}
					//else {
						//Block = Mat;
					//}
				//}
				//else {
					//Block = Mat;
				//}
				//Block = Mat;
			//}
			//else {//OREDICT!
				//Block = Block.replaceAll("ingot", "block").replaceAll("gem", "block");
				//String Mat = "block" + Block;
				//if(OreDictionary.getOres(Mat, false).isEmpty()) {
					//Mat = "block" + Block.substring(0, 1).toUpperCase() + Block.substring(1);
					//if(OreDictionary.getOres(Mat, false).isEmpty()) {
						//Mat = "block" + Block.substring(0, 1).toUpperCase() + Block.substring(1).toLowerCase();
						//if(OreDictionary.getOres(Mat, false).isEmpty()) {
							//Mat = "block" + Block.toLowerCase();
							//if(OreDictionary.getOres(Mat, false).isEmpty()) {
								//if(Config.debug) {
									//UpgradeRecipesMod.log.warn("Couldn't get a Valid Block OreDictionary Entry for Item OreDictionary " + itemOreDict + ".");
								//}
							//}
							//else {
								//Block = Mat;
							//}
							//if(Config.debug) {
								//UpgradeRecipesMod.log.warn("Couldn't get a Valid Block OreDictionary entry.");
								//UpgradeRecipesMod.log.warn("Couldn't get a Valid Block OreDictionary Entry for Item OreDictionary " + itemOreDict + ".");
							//}
						//}
						//else {
							//Block = Mat;
						//}
					//}
					//else {
						//Block = Mat;
					//}
				//}
				//else {
					//Block = Mat;
				//}
				//Block = Mat;
			//}
		//}
		if(Config.debug) {
			//UpgradeRecipesMod.log.info("Block OreDict = " + Block + ".");
			//UpgradeRecipesMod.log.info("Block OreDict = " + Block + " for Item OreDict " + itemOreDict + ".");
			//UpgradeRecipesMod.log.info("Block OreDict = " + Block + "; Item OreDict = " + UpgradeRecipesCommonProxy.ToolMaterialMap.get(itemOreDict) + ".");
			//UpgradeRecipesMod.log.info("Block OreDict = " + Block + "; Item OreDict = " + UpgradeRecipesCommonProxy.MaterialMap.get(itemOreDict) + ".");
			UpgradeRecipesMod.log.info("Block OreDict = " + Block + "; Item OreDict = " + itemOreDict + ".");
		}
		return Block;
	}
	
}