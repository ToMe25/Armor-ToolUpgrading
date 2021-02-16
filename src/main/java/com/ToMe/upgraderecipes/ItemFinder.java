package com.ToMe.upgraderecipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ItemFinder {

	public static List<ItemArmor> Armors = new ArrayList<ItemArmor>();
	public static List<ItemArmor> Helmets = new ArrayList<ItemArmor>();
	public static List<ItemArmor> Chestplates = new ArrayList<ItemArmor>();
	public static List<ItemArmor> Leggings = new ArrayList<ItemArmor>();
	public static List<ItemArmor> Boots = new ArrayList<ItemArmor>();
	public static List<Item> Tools = new ArrayList<Item>();
	// public static List<ItemTool> Tools = new ArrayList<ItemTool>();
	public static List<Item> Pickaxes = new ArrayList<Item>();
	// public static List<ItemTool> Pickaxes = new ArrayList<ItemTool>();
	public static List<Item> Axes = new ArrayList<Item>();
	// public static List<ItemTool> Axes = new ArrayList<ItemTool>();
	public static List<Item> Shovels = new ArrayList<Item>();
	// public static List<ItemTool> Shovels = new ArrayList<ItemTool>();
	public static List<Item> Hoes = new ArrayList<Item>();
	// public static List<ItemTool> Hoes = new ArrayList<ItemTool>();
	// Key Wrong Names
	private static Map<String, Map<String, List<String>>> types = new HashMap<String, Map<String, List<String>>>();

	/**
	 * find all Armors and Tools to be used
	 */
	public static void findItems() {
		// Init types Map
		// Helmet
		// Map<String, List<String>> helmet = new HashMap<String, List<String>>();
		// List<String> helmetNames = new ArrayList<String>();
		// helmetNames.add("helmet");
		// helmetNames.add("helm");
		// helmet.put("", helmetNames);
		// types.put("helmet", helmet);

		// Chestplate
		// Map<String, List<String>> chestplate = new HashMap<String, List<String>>();
		// List<String> chestplateNames = new ArrayList<String>();
		// chestplateNames.add("chestplate");
		// chestplateNames.add("chest");
		// chestplateNames.add("plate");
		// chestplate.put("", chestplateNames);
		// types.put("chestplate", chestplate);

		// Leggings
		// Map<String, List<String>> leggings = new HashMap<String, List<String>>();
		// List<String> leggingsNames = new ArrayList<String>();
		// leggingsNames.add("leggings");
		// leggingsNames.add("legs");
		// leggings.put("", leggingsNames);
		// types.put("leggings", leggings);

		// Boots
		// Map<String, List<String>> boots = new HashMap<String, List<String>>();
		// List<String> bootsNames = new ArrayList<String>();
		// bootsNames.add("boots");
		// bootsNames.add("feet");
		// boots.put("", bootsNames);
		// types.put("boots", boots);

		// Pickaxe
		// Map<String, List<String>> pickaxe = new HashMap<String, List<String>>();
		// List<String> pickaxeNames = new ArrayList<String>();
		// pickaxeNames.add("pickaxe");
		// pickaxeNames.add("pick");
		// pickaxe.put("", pickaxeNames);
		// types.put("pickaxe", pickaxe);

		// Axe
		// Map<String, List<String>> axe = new HashMap<String, List<String>>();
		// List<String> axeNames = new ArrayList<String>();
		// axeNames.add("axe");
		// axeNames.add("hatchet");
		// axe.put("pickaxe", axeNames);
		// types.put("axe", axe);

		// Shovel
		// Map<String, List<String>> shovel = new HashMap<String, List<String>>();
		// List<String> shovelNames = new ArrayList<String>();
		// shovelNames.add("shovel");
		// shovelNames.add("spade");
		// shovel.put("", shovelNames);
		// types.put("shovel", shovel);

		// Hoe
		// Map<String, List<String>> hoe = new HashMap<String, List<String>>();
		// List<String> hoeNames = new ArrayList<String>();
		// hoeNames.add("hoe");
		// hoe.put("", pickaxeNames);
		// types.put("hoe", hoe);

		// Find Items
		for (Item item : ForgeRegistries.ITEMS.getValues()) {
			if (item instanceof ItemArmor) {
				ItemArmor armor = (ItemArmor) item;
				Armors.add(armor);
				// if (isTool(armor, "helmet", "helm")) {
				// Helmets.add(armor);
				// } else if (isTool(armor, "chestplate", "chest")) {
				// Chestplates.add(armor);
				// } else if (isTool(armor, "leggings", "legs")) {
				// Leggings.add(armor);
				// } else if (isTool(armor, "boots", "feet")) {
				// Boots.add(armor);
				// }
				if (isTool(armor, "helmet")) {
					Helmets.add(armor);
				} else if (isTool(armor, "chestplate")) {
					Chestplates.add(armor);
				} else if (isTool(armor, "leggings")) {
					Leggings.add(armor);
				} else if (isTool(armor, "boots")) {
					Boots.add(armor);
				}
			} // else if (item instanceof ItemTool) {
				// ItemTool tool = (ItemTool) item;
				// Tools.add(tool);
				// if (tool instanceof ItemPickaxe || isTool(tool, "pickaxe", "pick")) {
				// Pickaxes.add(tool);
				// } else if (tool instanceof ItemAxe || isTool(tool.getRegistryName(), "axe",
				// "hatchet", "pickaxe")) {
				// Axes.add(tool);
				// } else if (tool instanceof ItemSpade || isTool(tool, "shovel", "spade")) {
				// Shovels.add(tool);
				// }
				// else if(tool instanceof ItemHoe || isTool(tool, "hoe", "???")) {
				// Hoes.add(item);
				// }
				// if (tool instanceof ItemPickaxe || isTool(tool, "pickaxe")) {
				// Pickaxes.add(tool);
				// } else if (tool instanceof ItemAxe || isTool(tool, "axe")) {
				// Axes.add(tool);
				// } else if (tool instanceof ItemSpade || isTool(tool, "shovel")) {
				// Shovels.add(tool);
				// }
				// } else if (item instanceof ItemHoe || isTool(item, "hoe", "???")) {
				// } else if (item instanceof ItemHoe || isTool(item, "hoe")) {
				// Hoes.add(item);
				// }
				// Tools.add(item);
			if (item instanceof ItemPickaxe || isTool(item, "pickaxe")) {
				Pickaxes.add(item);
				Tools.add(item);
			} else if (item instanceof ItemAxe || isTool(item, "axe")) {
				Axes.add(item);
				Tools.add(item);
			} else if (item instanceof ItemSpade || isTool(item, "shovel")) {
				Shovels.add(item);
				Tools.add(item);
			} else if (item instanceof ItemHoe || isTool(item, "hoe")) {
				Hoes.add(item);
				Tools.add(item);
			}
		}
	}

	public static void initTypes() {
		// Helmet
		Map<String, List<String>> helmet = new HashMap<String, List<String>>();
		List<String> helmetNames = new ArrayList<String>();
		helmetNames.add("helmet");
		helmetNames.add("helm");
		helmet.put("", helmetNames);
		types.put("helmet", helmet);

		// Chestplate
		Map<String, List<String>> chestplate = new HashMap<String, List<String>>();
		List<String> chestplateNames = new ArrayList<String>();
		chestplateNames.add("chestplate");
		chestplateNames.add("chest");
		chestplateNames.add("plate");
		chestplate.put("", chestplateNames);
		types.put("chestplate", chestplate);

		// Leggings
		Map<String, List<String>> leggings = new HashMap<String, List<String>>();
		List<String> leggingsNames = new ArrayList<String>();
		leggingsNames.add("leggings");
		leggingsNames.add("legs");
		leggings.put("", leggingsNames);
		types.put("leggings", leggings);

		// Boots
		Map<String, List<String>> boots = new HashMap<String, List<String>>();
		List<String> bootsNames = new ArrayList<String>();
		bootsNames.add("boots");
		bootsNames.add("feet");
		boots.put("", bootsNames);
		types.put("boots", boots);

		// Pickaxe
		Map<String, List<String>> pickaxe = new HashMap<String, List<String>>();
		List<String> pickaxeNames = new ArrayList<String>();
		pickaxeNames.add("pickaxe");
		pickaxeNames.add("pick");
		pickaxe.put("", pickaxeNames);
		types.put("pickaxe", pickaxe);

		// Axe
		Map<String, List<String>> axe = new HashMap<String, List<String>>();
		List<String> axeNames = new ArrayList<String>();
		axeNames.add("axe");
		axeNames.add("hatchet");
		axe.put("pickaxe", axeNames);
		types.put("axe", axe);

		// Shovel
		Map<String, List<String>> shovel = new HashMap<String, List<String>>();
		List<String> shovelNames = new ArrayList<String>();
		shovelNames.add("shovel");
		shovelNames.add("spade");
		shovel.put("", shovelNames);
		types.put("shovel", shovel);

		// Hoe
		Map<String, List<String>> hoe = new HashMap<String, List<String>>();
		List<String> hoeNames = new ArrayList<String>();
		hoeNames.add("hoe");
		hoe.put("", hoeNames);
		types.put("hoe", hoe);
	}

	/**
	 * Checks whether the Resource Name fits to the given Tool or Armor Type
	 * 
	 * @param item
	 *            the Tool or Armor Item
	 * @param name1
	 *            one possible name for Tools of that type
	 * @param name2
	 *            another possible name for Tools of that type
	 * @return
	 */
	// private static boolean isTool(Item item, String name1, String name2) {
	// return isTool(item.getRegistryName(), name1, name2);
	// }

	/**
	 * Checks whether the Resource Name fits to the given Tool or Armor Type
	 * 
	 * @param registryName
	 *            the Tool or Armor registryName
	 * @param name1
	 *            one possible name for Tools of that type
	 * @param name2
	 *            another possible name for Tools of that type
	 * @return
	 */
	// private static boolean isTool(ResourceLocation registryName, String name1,
	// String name2) {
	// return isTool(registryName, name1, name2, null);
	// }

	/**
	 * Checks whether the Resource Name fits to the given Tool or Armor Type
	 * 
	 * @param tool
	 *            the Tool or Armor
	 * @param type
	 *            the Tool Type to check
	 * @return
	 */
	// private static boolean isTool(ResourceLocation registryName, String name1,
	// String name2, String wrong) {
	// private static boolean isTool(ResourceLocation registryName, String type) {
	private static boolean isTool(Item tool, String type) {
		ResourceLocation registryName = tool.getRegistryName();
		// String resourcePath = registryName.getResourcePath();
		String resourcePath = registryName.getResourcePath().toLowerCase();// many 1.10.2 Mods use uppercase Chars in
																			// their Item Names :(
		String wrong = null;
		for (String key : types.get(type).keySet()) {
			wrong = key;
		}
		List<String> names = types.get(type).get(wrong);
		// if (wrong != null && (resourcePath.startsWith(wrong) ||
		// resourcePath.endsWith(wrong))) {
		//if (wrong != null && wrong != "" && (resourcePath.startsWith(wrong) || resourcePath.endsWith(wrong))) {
		if (wrong != null && wrong != "" && resourcePath.contains(wrong)) {
			return false;
		}
		boolean isTool = false;
		for (String name : names) {
			// if (resourcePath.startsWith(name) || resourcePath.endsWith(name)) {
			if (resourcePath.contains(name)) {
				isTool = true;
			}
		}
		// for (String str : resourcePath.split(".")) {
		// for (String name : names) {
		// if (str.startsWith(name) || str.endsWith(name)) {
		// isTool = true;
		// }
		// }
		// }
		return isTool;
		// return resourcePath.startsWith(name1) || resourcePath.startsWith(name2) ||
		// resourcePath.endsWith(name1)
		// || resourcePath.endsWith(name2);
	}

	// public static String getMaterial(ResourceLocation registryName) {
	public static String getMaterial(ResourceLocation registryName, String type) {
		// String material = registryName.getResourceDomain();
		// material += "_";
		// material += registryName.getResourcePath().replaceAll("_", "");
		// String material = registryName.getResourcePath();
		// String material = registryName.getResourcePath().replaceAll("_", "");
		type = type.toLowerCase();
		String material = registryName.getResourcePath().toLowerCase().replaceAll("_", "");
		for (List<String> names : types.get(type).values()) {
			for (String name : names) {
				material = material.replaceAll(name, "");
			}
		}
		// if(types.containsKey(type)) {
		// for (List<String> names : types.get(type).values()) {
		// for (String name : names) {
		// material = material.replaceAll(name, "");
		// }
		// }
		// }
		// else if(types.containsKey(type.substring(0, type.length() - 1))) {
		// for (List<String> names : types.get(type.substring(0, type.length() -
		// 1)).values()) {
		// for (String name : names) {
		// material = material.replaceAll(name, "");
		// }
		// }
		// }
		material = registryName.getResourceDomain() + "_" + material;
		return material;
	}

	public static String getItemType(Item item) {
		if (item instanceof ItemArmor) {
			ItemArmor armor = (ItemArmor) item;
			Armors.add(armor);
			if (isTool(armor, "helmet")) {
				return "helmet";
			} else if (isTool(armor, "chestplate")) {
				return "chestplate";
			} else if (isTool(armor, "leggings")) {
				return "leggings";
			} else if (isTool(armor, "boots")) {
				return "boots";
			}
		}
		if (item instanceof ItemPickaxe || isTool(item, "pickaxe")) {
			return "pickaxe";
		} else if (item instanceof ItemAxe || isTool(item, "axe")) {
			return "axe";
		} else if (item instanceof ItemSpade || isTool(item, "shovel")) {
			return "shovel";
		} else if (item instanceof ItemHoe || isTool(item, "hoe")) {
			return "hoe";
		}
		return null;
	}

}