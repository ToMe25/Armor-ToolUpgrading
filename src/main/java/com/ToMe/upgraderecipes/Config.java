package com.ToMe.upgraderecipes;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;

public class Config {
	
	protected static Configuration config;
	
	//GENERAL
	public static boolean tools = true;
	public static boolean armor = true;
	public static boolean debug = false;
	public static boolean oreDictBoneBlock = true;
	public static boolean oreDictWool = true;
	
	//SUPPORTED MODS
	public static final String CATEGORY_MODS = "supported_mods";
	public static boolean avaritia = true;
	public static boolean draconicevolution = true;
	public static boolean rubymod = true;
	public static boolean stars = true;
	public static boolean trigems = true;
	public static boolean vanilla = true;
	public static boolean weapons = true;
	
	public static final String CATEGORY_AVARITIA = "avaritia_support";
	public static boolean skullfire = true;
	public static boolean skullfire_bone_blocks = false;
	public static boolean skullfire_netherstar_blocks = false;
	public static boolean skullfire_crystalmatrix_blocks = false;
	/**There is no Skullfire Pickaxe*/
	public static final boolean skullfire_pickaxe = false;
	/**There is no Skullfire Axe*/
	public static final boolean skullfire_axe = false;
	/**There is no Skullfire Shovel*/
	public static final boolean skullfire_shovel = false;
	/**There is no Skullfire Hoe*/
	public static final boolean skullfire_hoe = false;
	public static boolean skullfire_sword = true;
	/**There is no Skullfire Bow*/
	public static final boolean skullfire_bow = false;
	public static boolean infinity = true;
	public static boolean infinity_blocks = false;
	public static boolean infinity_neutronium_blocks = false;
	public static boolean infinity_crystalmatrix_blocks = false;
	public static boolean infinity_pickaxe = true;
	public static boolean infinity_axe = true;
	public static boolean infinity_shovel = true;
	public static boolean infinity_hoe = true;
	///**There is no Infinity Hoe at 1.10.2*/
	//public static final boolean infinity_hoe = false;
	public static boolean infinity_sword = true;
	public static boolean infinity_bow = true;
	public static boolean infinity_helmet = true;
	public static boolean infinity_chestplate = true;
	public static boolean infinity_leggings = true;
	public static boolean infinity_boots = true;
	
	public static final String CATEGORY_DRACONICEVOLUTION = "draconicevolution_support";
	public static boolean wyvern = true;
	public static boolean wyvern_blocks = false;
	public static boolean wyvern_pickaxe = true;
	public static boolean wyvern_axe = true;
	public static boolean wyvern_shovel = true;
	//public static boolean wyvern_hoe = true;
	/**There is no Wyvern Hoe. I was so sure there is a Wyvern Hoe...*/
	public static final boolean wyvern_hoe = false;
	public static boolean wyvern_sword = true;
	public static boolean wyvern_bow = true;
	public static boolean wyvern_helmet = true;
	public static boolean wyvern_chestplate = true;
	public static boolean wyvern_leggings = true;
	public static boolean wyvern_boots = true;
	public static boolean draconic = true;
	public static boolean draconic_awakened_blocks = false;
	public static boolean draconic_pickaxe = true;
	public static boolean draconic_axe = true;
	public static boolean draconic_shovel = true;
	public static boolean draconic_hoe = true;
	public static boolean draconic_sword = true;
	public static boolean draconic_bow = true;
	public static boolean draconic_helmet = true;
	public static boolean draconic_chestplate = true;
	public static boolean draconic_leggings = true;
	public static boolean draconic_boots = true;
	
	public static final String CATEGORY_RUBYMOD = "rubymod_support";
	public static boolean rubyr = true;
	public static boolean rubyr_blocks = false;
	public static boolean rubyr_pickaxe = true;
	public static boolean rubyr_axe = true;
	public static boolean rubyr_shovel = true;
	public static boolean rubyr_hoe = true;
	public static boolean rubyr_sword = true;
	/**There is no Ruby Bow*/
	public static final boolean rubyr_bow = false;
	public static boolean rubyr_helmet = true;
	public static boolean rubyr_chestplate = true;
	public static boolean rubyr_leggings = true;
	public static boolean rubyr_boots = true;
	public static boolean emeraldr = true;
	public static boolean emeraldr_blocks = false;
	public static boolean emeraldr_pickaxe = true;
	public static boolean emeraldr_axe = true;
	public static boolean emeraldr_shovel = true;
	public static boolean emeraldr_hoe = true;
	public static boolean emeraldr_sword = true;
	/**There is no Emerald Bow*/
	public static final boolean emeraldr_bow = false;
	public static boolean emeraldr_helmet = true;
	public static boolean emeraldr_chestplate = true;
	public static boolean emeraldr_leggings = true;
	public static boolean emeraldr_boots = true;
	
	public static final String CATEGORY_STARS = "stars_support";
	public static boolean netherstar = true;
	public static boolean netherstar_blocks = false;
	public static boolean netherstar_pickaxe = true;
	public static boolean netherstar_axe = true;
	public static boolean netherstar_shovel = true;
	public static boolean netherstar_hoe = true;
	public static boolean netherstar_sword = true;
	/**There is no Netherstar Bow*/
	public static final boolean netherstar_bow = false;
	public static boolean netherstar_helmet = true;
	public static boolean netherstar_chestplate = true;
	public static boolean netherstar_leggings = true;
	public static boolean netherstar_boots = true;
	
	public static final String CATEGORY_TRIGEMS = "trigems_support";
	public static boolean topaz = true;
	public static boolean topaz_blocks = false;
	public static boolean topaz_pickaxe = true;
	public static boolean topaz_axe = true;
	public static boolean topaz_shovel = true;
	public static boolean topaz_hoe = true;
	public static boolean topaz_sword = true;
	/**There is no Topaz Bow*/
	public static final boolean topaz_bow = false;
	public static boolean topaz_helmet = true;
	public static boolean topaz_chestplate = true;
	public static boolean topaz_leggings = true;
	public static boolean topaz_boots = true;
	public static boolean rubyt = true;
	public static boolean rubyt_blocks = false;
	public static boolean rubyt_pickaxe = true;
	public static boolean rubyt_axe = true;
	public static boolean rubyt_shovel = true;
	public static boolean rubyt_hoe = true;
	public static boolean rubyt_sword = true;
	/**There is no Ruby Bow*/
	public static final boolean rubyt_bow = false;
	public static boolean rubyt_helmet = true;
	public static boolean rubyt_chestplate = true;
	public static boolean rubyt_leggings = true;
	public static boolean rubyt_boots = true;
	public static boolean sapphire = true;
	public static boolean sapphire_blocks = false;
	public static boolean sapphire_pickaxe = true;
	public static boolean sapphire_axe = true;
	public static boolean sapphire_shovel = true;
	public static boolean sapphire_hoe = true;
	public static boolean sapphire_sword = true;
	/**There is no Sapphire Bow*/
	public static final boolean sapphire_bow = false;
	public static boolean sapphire_helmet = true;
	public static boolean sapphire_chestplate = true;
	public static boolean sapphire_leggings = true;
	public static boolean sapphire_boots = true;
	public static boolean emeraldt = true;
	public static boolean emeraldt_blocks = false;
	public static boolean emeraldt_pickaxe = true;
	public static boolean emeraldt_axe = true;
	public static boolean emeraldt_shovel = true;
	public static boolean emeraldt_hoe = true;
	public static boolean emeraldt_sword = true;
	/**There is no Emerald Bow*/
	public static final boolean emeraldt_bow = false;
	public static boolean emeraldt_helmet = true;
	public static boolean emeraldt_chestplate = true;
	public static boolean emeraldt_leggings = true;
	public static boolean emeraldt_boots = true;
	
	public static final String CATEGORY_VANILLA = "vanilla_support";
	public static boolean stone = true;
	//public static boolean stone_blocks = false;
	/**USELESS Because Stone has no different block variant.*/
	public static final boolean stone_blocks = false;
	public static boolean stone_pickaxe = true;
	public static boolean stone_axe = true;
	public static boolean stone_shovel = true;
	public static boolean stone_hoe = true;
	public static boolean stone_sword = true;
	/**There is no Stone Bow*/
	public static final boolean stone_bow = false;
	public static boolean chain = true;
	/**USELESS Because Chain has no different block variant.*/
	public static final boolean chain_blocks = false;
	public static boolean chain_helmet = true;
	public static boolean chain_chestplate = true;
	public static boolean chain_leggings = true;
	public static boolean chain_boots = true;
	public static boolean iron = true;
	public static boolean iron_blocks = false;
	public static boolean iron_pickaxe = true;
	public static boolean iron_axe = true;
	public static boolean iron_shovel = true;
	public static boolean iron_hoe = true;
	public static boolean iron_sword = true;
	/**There is no Iron Bow*/
	public static final boolean iron_bow = false;
	public static boolean iron_helmet = true;
	public static boolean iron_chestplate = true;
	public static boolean iron_leggings = true;
	public static boolean iron_boots = true;
	public static boolean gold = true;
	public static boolean gold_blocks = false;
	public static boolean gold_pickaxe = true;
	public static boolean gold_axe = true;
	public static boolean gold_shovel = true;
	public static boolean gold_hoe = true;
	public static boolean gold_sword = true;
	/**There is no Gold Bow*/
	public static final boolean gold_bow = false;
	public static boolean gold_helmet = true;
	public static boolean gold_chestplate = true;
	public static boolean gold_leggings = true;
	public static boolean gold_boots = true;
	public static boolean diamond = true;
	public static boolean diamond_blocks = false;
	public static boolean diamond_pickaxe = true;
	public static boolean diamond_axe = true;
	public static boolean diamond_shovel = true;
	public static boolean diamond_hoe = true;
	public static boolean diamond_sword = true;
	/**There is no Diamond Bow*/
	public static final boolean diamond_bow = false;
	public static boolean diamond_helmet = true;
	public static boolean diamond_chestplate = true;
	public static boolean diamond_leggings = true;
	public static boolean diamond_boots = true;
	
	public static final String CATEGORY_WEAPONS = "weapons_support";
	public static boolean redcrystal = true;
	public static boolean redcrystal_blocks = false;
	///**USELESS Because RedCrystal has no different block variant.*/
	//public static final boolean redcrystal_blocks = false;
	public static boolean redcrystal_pickaxe = true;
	public static boolean redcrystal_axe = true;
	public static boolean redcrystal_shovel = true;
	public static boolean redcrystal_hoe = true;
	public static boolean redcrystal_sword = true;
	/**There is no Red Crystal Bow*/
	public static final boolean redcrystal_bow = false;
	public static boolean redcrystal_helmet = true;
	public static boolean redcrystal_chestplate = true;
	public static boolean redcrystal_leggings = true;
	public static boolean redcrystal_boots = true;
	
	public Config(File cfg) {
		config = new Configuration(cfg);
		readConfig();
	}
	
	/**
	 * Reads and initializes the Config File.
	 */
	public static void readConfig() {
		try {
			config.load();
			initConfig();
		} finally {
			// TODO: handle finally clause
			if(config.hasChanged()) {
				config.save();
			}
		}
		checkModsLoaded();
	}
	
	/**
	 * Initializes the Config Object.
	 */
	public static void initConfig() {
		tools = config.getBoolean("tools", Configuration.CATEGORY_GENERAL, tools, "Enables / Disables the Tools Module.");
		armor = config.getBoolean("armor", Configuration.CATEGORY_GENERAL, armor, "Enables / Disables the Armor Module.");
		debug = config.getBoolean("debug", Configuration.CATEGORY_GENERAL, debug, "Enables / Disables some debug Output.");
		oreDictBoneBlock = config.getBoolean("oreDictBoneBlock", Configuration.CATEGORY_GENERAL, oreDictBoneBlock, "Register Minecraft Bone Blocks to OreDictionary \"blockBone\" or not?(needed for skullfire_1_bone_blocks");
		oreDictWool = config.getBoolean("oreDictWool", Configuration.CATEGORY_GENERAL, oreDictWool, "Register Minecraft Wool to OreDictionary \"wool\" or not?");
		
		config.addCustomCategoryComment(CATEGORY_MODS, "Enable / Disable support for any supportet Mod.");
		avaritia = config.getBoolean("enable_avaritia_support", CATEGORY_MODS, avaritia, "Enables / Disables Avaritia support.");
		draconicevolution = config.getBoolean("enable_draconicevolution_support", CATEGORY_MODS, draconicevolution, "Enables / Disables Draconic Evolution support.");
		vanilla = config.getBoolean("enable_vanilla_support", CATEGORY_MODS, vanilla, "Enables / Disables Vanilla support.");
		weapons = config.getBoolean("enable_weapons_support", CATEGORY_MODS, weapons, "Enables / Disables Weapons support.");
		rubymod = config.getBoolean("enable_rubymod_support", CATEGORY_MODS, rubymod, "Enables / Disables Ruby Mod support.");
		stars = config.getBoolean("enable_stars_support", CATEGORY_MODS, stars, "Enables / Disables Stars Mod support.");
		trigems = config.getBoolean("enable_trigems_support", CATEGORY_MODS, trigems, "Enables / Disables TriGems support.");
		
		config.addCustomCategoryComment(CATEGORY_AVARITIA, "Enable / Disable any Part of the Avaritia Integration.");
		skullfire = config.getBoolean("skullfire_0_enable", CATEGORY_AVARITIA, skullfire, "Enables / Disables Recipe Changes for Skullfire Tools and Armor.");
		skullfire_bone_blocks = config.getBoolean("skullfire_1_bone_blocks", CATEGORY_AVARITIA, skullfire_bone_blocks, "Enables / Disables the use of Bone Blocks to Nerf Skullfire Recipes.");
		skullfire_netherstar_blocks = config.getBoolean("skullfire_1_netherstar_blocks", CATEGORY_AVARITIA, skullfire_netherstar_blocks, "Enables / Disables the use of Netherstar Blocks to Nerf Skullfire Recipes.");
		skullfire_crystalmatrix_blocks = config.getBoolean("skullfire_1_crystalmatrix_blocks", CATEGORY_AVARITIA, skullfire_crystalmatrix_blocks, "Enables / Disables the use of Crystal Matrix Blocks to Nerf Skullfire Recipes.");
		skullfire_sword = config.getBoolean("skullfire_sword", CATEGORY_AVARITIA, skullfire_sword, "Enables / Disables Recipe Changes for the Skullfire Sword.");
		
		infinity = config.getBoolean("infinity_0_enable", CATEGORY_AVARITIA, infinity, "Enables / Disables Recipe Changes for Infinity Tools and Armor.");
		infinity_blocks = config.getBoolean("infinity_1_blocks", CATEGORY_AVARITIA, infinity_blocks, "Enables / Disables the use of Blocks to Nerf Infinity Recipes.");
		infinity_neutronium_blocks = config.getBoolean("infinity_1_neutronium_blocks", CATEGORY_AVARITIA, infinity_neutronium_blocks, "Enables / Disables the use of Neutronium Blocks to Nerf Infinity Recipes.");
		infinity_crystalmatrix_blocks = config.getBoolean("infinity_1_crystalmatrix_blocks", CATEGORY_AVARITIA, infinity_crystalmatrix_blocks, "Enables / Disables the use of Crystal Matrix Blocks to Nerf Infinity Recipes.");
		infinity_pickaxe = config.getBoolean("infinity_pickaxe", CATEGORY_AVARITIA, infinity_pickaxe, "Enables / Disables Recipe Changes for the Infinity Pickaxe.");
		infinity_axe = config.getBoolean("infinity_axe", CATEGORY_AVARITIA, infinity_axe, "Enables / Disables Recipe Changes for the Infinity Axe.");
		infinity_shovel = config.getBoolean("infinity_shovel", CATEGORY_AVARITIA, infinity_shovel, "Enables / Disables Recipe Changes for the Infinity Shovel.");
		//infinity_hoe = config.getBoolean("infinity_hoe", CATEGORY_AVARITIA, infinity_hoe, "Enables / Disables Recipe Changes for the Infinity  Hoe.");
		infinity_sword = config.getBoolean("infinity_sword", CATEGORY_AVARITIA, infinity_sword, "Enables / Disables Recipe Changes for the Infinity Sword.");
		infinity_bow = config.getBoolean("infinity_bow", CATEGORY_AVARITIA, infinity_bow, "Enables / Disables Recipe Changes for the Infinity Bow.");
		infinity_helmet = config.getBoolean("infinity_helmet", CATEGORY_AVARITIA, infinity_helmet, "Enables / Disables Recipe Changes for the Infinity Helmet.");
		infinity_chestplate = config.getBoolean("infinity_chestplate", CATEGORY_AVARITIA, infinity_chestplate, "Enables / Disables Recipe Changes for the Infinity Chestplate.");
		infinity_leggings = config.getBoolean("infinity_leggings", CATEGORY_AVARITIA, infinity_leggings, "Enables / Disables Recipe Changes for the Infinity Leggings.");
		infinity_boots = config.getBoolean("infinity_boots", CATEGORY_AVARITIA, infinity_boots, "Enables / Disables Recipe Changes for the Infinity Boots.");
		
		config.addCustomCategoryComment(CATEGORY_DRACONICEVOLUTION, "Enable / Disable any Part of the Draconic Evolution Integration.");
		wyvern = config.getBoolean("wyvern_0_enable", CATEGORY_DRACONICEVOLUTION, wyvern, "Enables / Disables Recipe Changes for Wyvern Tools and Armor.");
		wyvern_blocks = config.getBoolean("wyvern_1_blocks", CATEGORY_DRACONICEVOLUTION, wyvern_blocks, "Enables / Disables the use of Blocks to Nerf Wyvern Recipes.");
		wyvern_pickaxe = config.getBoolean("wyvern_pickaxe", CATEGORY_DRACONICEVOLUTION, wyvern_pickaxe, "Enables / Disables Recipe Changes for the Wyvern Pickaxe.");
		wyvern_axe = config.getBoolean("wyvern_axe", CATEGORY_DRACONICEVOLUTION, wyvern_axe, "Enables / Disables Recipe Changes for the Wyvern Axe.");
		wyvern_shovel = config.getBoolean("wyvern_shovel", CATEGORY_DRACONICEVOLUTION, wyvern_shovel, "Enables / Disables Recipe Changes for the Wyvern Shovel.");
		//wyvern_hoe = config.getBoolean("wyvern_hoe", CATEGORY_DRACONICEVOLUTION, wyvern_hoe, "Enables / Disables Recipe Changes for the Wyvern Hoe.");
		wyvern_sword = config.getBoolean("wyvern_sword", CATEGORY_DRACONICEVOLUTION, wyvern_sword, "Enables / Disables Recipe Changes for the Wyvern Sword.");
		wyvern_bow = config.getBoolean("wyvern_bow", CATEGORY_DRACONICEVOLUTION, wyvern_bow, "Enables / Disables Recipe Changes for the Wyvern Bow.");
		wyvern_helmet = config.getBoolean("wyvern_helmet", CATEGORY_DRACONICEVOLUTION, wyvern_helmet, "Enables / Disables Recipe Changes for the Wyvern Helmet.");
		wyvern_chestplate = config.getBoolean("wyvern_chestplate", CATEGORY_DRACONICEVOLUTION, wyvern_chestplate, "Enables / Disables Recipe Changes for the Wyvern Chestplate.");
		wyvern_leggings = config.getBoolean("wyvern_leggings", CATEGORY_DRACONICEVOLUTION, wyvern_leggings, "Enables / Disables Recipe Changes for the Wyvern Leggings.");
		wyvern_boots = config.getBoolean("wyvern_boots", CATEGORY_DRACONICEVOLUTION, wyvern_boots, "Enables / Disables Recipe Changes for the Wyvern Boots.");
		
		draconic = config.getBoolean("draconic_0_enable", CATEGORY_DRACONICEVOLUTION, draconic, "Enables / Disables Recipe Changes for Draconic Tools and Armor.");
		draconic_awakened_blocks = config.getBoolean("draconic_1_awakened_blocks", CATEGORY_DRACONICEVOLUTION, draconic_awakened_blocks, "Enables / Disables the use of Awakened Blocks to Nerf Draconic Recipes.");
		draconic_pickaxe = config.getBoolean("draconic_pickaxe", CATEGORY_DRACONICEVOLUTION, draconic_pickaxe, "Enables / Disables Recipe Changes for the Draconic Pickaxe.");
		draconic_axe = config.getBoolean("draconic_axe", CATEGORY_DRACONICEVOLUTION, draconic_axe, "Enables / Disables Recipe Changes for the Draconic Axe.");
		draconic_shovel = config.getBoolean("draconic_shovel", CATEGORY_DRACONICEVOLUTION, draconic_shovel, "Enables / Disables Recipe Changes for the Draconic Shovel.");
		draconic_hoe = config.getBoolean("draconic_hoe", CATEGORY_DRACONICEVOLUTION, draconic_hoe, "Enables / Disables Recipe Changes for the Draconic Hoe.");
		draconic_sword = config.getBoolean("draconic_sword", CATEGORY_DRACONICEVOLUTION, draconic_sword, "Enables / Disables Recipe Changes for the Draconic Sword.");
		draconic_bow = config.getBoolean("draconic_bow", CATEGORY_DRACONICEVOLUTION, draconic_bow, "Enables / Disables Recipe Changes for the Draconic Bow.");
		draconic_helmet = config.getBoolean("draconic_helmet", CATEGORY_DRACONICEVOLUTION, draconic_helmet, "Enables / Disables Recipe Changes for the Draconic Helmet.");
		draconic_chestplate = config.getBoolean("draconic_chestplate", CATEGORY_DRACONICEVOLUTION, draconic_chestplate, "Enables / Disables Recipe Changes for the Draconic Chestplate.");
		draconic_leggings = config.getBoolean("draconic_leggings", CATEGORY_DRACONICEVOLUTION, draconic_leggings, "Enables / Disables Recipe Changes for the Draconic Leggings.");
		draconic_boots = config.getBoolean("draconic_boots", CATEGORY_DRACONICEVOLUTION, draconic_boots, "Enables / Disables Recipe Changes for the Draconic Boots.");
		
		config.addCustomCategoryComment(CATEGORY_RUBYMOD, "Enable / Disable any Part of the Ruby Mod Integration.");
		rubyr = config.getBoolean("ruby_0_enable", CATEGORY_RUBYMOD, rubyr, "Enables / Disables Recipe Changes for Ruby Tools and Armor.");
		rubyr_blocks = config.getBoolean("ruby_1_blocks", CATEGORY_RUBYMOD, rubyr_blocks, "Enables / Disables the use of Blocks to Nerf Ruby Recipes.");
		rubyr_pickaxe = config.getBoolean("ruby_pickaxe", CATEGORY_RUBYMOD, rubyr_pickaxe, "Enables / Disables Recipe Changes for the Ruby Pickaxe.");
		rubyr_axe = config.getBoolean("ruby_axe", CATEGORY_RUBYMOD, rubyr_axe, "Enables / Disables Recipe Changes for the Ruby Axe.");
		rubyr_shovel = config.getBoolean("ruby_shovel", CATEGORY_RUBYMOD, rubyr_shovel, "Enables / Disables Recipe Changes for the Ruby Shovel.");
		rubyr_hoe = config.getBoolean("ruby_hoe", CATEGORY_RUBYMOD, rubyr_hoe, "Enables / Disables Recipe Changes for the Ruby Hoe.");
		rubyr_sword = config.getBoolean("ruby_sword", CATEGORY_RUBYMOD, rubyr_sword, "Enables / Disables Recipe Changes for the Ruby Sword.");
		rubyr_helmet = config.getBoolean("ruby_helmet", CATEGORY_RUBYMOD, rubyr_helmet, "Enables / Disables Recipe Changes for the Ruby Helmet.");
		rubyr_chestplate = config.getBoolean("ruby_chestplate", CATEGORY_RUBYMOD, rubyr_chestplate, "Enables / Disables Recipe Changes for the Ruby Chestplate.");
		rubyr_leggings = config.getBoolean("ruby_leggings", CATEGORY_RUBYMOD, rubyr_leggings, "Enables / Disables Recipe Changes for the Ruby Leggings.");
		rubyr_boots = config.getBoolean("ruby_boots", CATEGORY_RUBYMOD, rubyr_boots, "Enables / Disables Recipe Changes for the Ruby Boots.");
		
		emeraldr = config.getBoolean("emerald_0_enable", CATEGORY_RUBYMOD, emeraldr, "Enables / Disables Recipe Changes for Emerald Tools and Armor.");
		emeraldr_blocks = config.getBoolean("emerald_1_blocks", CATEGORY_RUBYMOD, emeraldr_blocks, "Enables / Disables the use of Blocks to Nerf Emerald Recipes.");
		emeraldr_pickaxe = config.getBoolean("emerald_pickaxe", CATEGORY_RUBYMOD, emeraldr_pickaxe, "Enables / Disables Recipe Changes for the Emerald Pickaxe.");
		emeraldr_axe = config.getBoolean("emerald_axe", CATEGORY_RUBYMOD, emeraldr_axe, "Enables / Disables Recipe Changes for the Emerald Axe.");
		emeraldr_shovel = config.getBoolean("emerald_shovel", CATEGORY_RUBYMOD, emeraldr_shovel, "Enables / Disables Recipe Changes for the Emerald Shovel.");
		emeraldr_hoe = config.getBoolean("emerald_hoe", CATEGORY_RUBYMOD, emeraldr_hoe, "Enables / Disables Recipe Changes for the Emerald Hoe.");
		emeraldr_sword = config.getBoolean("emerald_sword", CATEGORY_RUBYMOD, emeraldr_sword, "Enables / Disables Recipe Changes for the Emerald Sword.");
		emeraldr_helmet = config.getBoolean("emerald_helmet", CATEGORY_RUBYMOD, emeraldr_helmet, "Enables / Disables Recipe Changes for the Emerald Helmet.");
		emeraldr_chestplate = config.getBoolean("emerald_chestplate", CATEGORY_RUBYMOD, emeraldr_chestplate, "Enables / Disables Recipe Changes for the Emerald Chestplate.");
		emeraldr_leggings = config.getBoolean("emerald_leggings", CATEGORY_RUBYMOD, emeraldr_leggings, "Enables / Disables Recipe Changes for the Emerald Leggings.");
		emeraldr_boots = config.getBoolean("emerald_boots", CATEGORY_RUBYMOD, emeraldr_boots, "Enables / Disables Recipe Changes for the Emerald Boots.");
		
		config.addCustomCategoryComment(CATEGORY_STARS, "Enable / Disable any Part of the Stars Mod Integration.");
		netherstar = config.getBoolean("netherstar_0_enable", CATEGORY_STARS, netherstar, "Enables / Disables Recipe Changes for Netherstar Tools and Armor.");
		netherstar_blocks = config.getBoolean("netherstar_1_blocks", CATEGORY_STARS, netherstar_blocks, "Enables / Disables the use of Blocks to Nerf Netherstar Recipes.");
		netherstar_pickaxe = config.getBoolean("netherstar_pickaxe", CATEGORY_STARS, netherstar_pickaxe, "Enables / Disables Recipe Changes for the Netherstar Pickaxe.");
		netherstar_axe = config.getBoolean("netherstar_axe", CATEGORY_STARS, netherstar_axe, "Enables / Disables Recipe Changes for the Netherstar Axe.");
		netherstar_shovel = config.getBoolean("netherstar_shovel", CATEGORY_STARS, netherstar_shovel, "Enables / Disables Recipe Changes for the Netherstar Shovel.");
		netherstar_hoe = config.getBoolean("netherstar_hoe", CATEGORY_STARS, netherstar_hoe, "Enables / Disables Recipe Changes for the Netherstar Hoe.");
		netherstar_sword = config.getBoolean("netherstar_sword", CATEGORY_STARS, netherstar_sword, "Enables / Disables Recipe Changes for the Netherstar Sword.");
		netherstar_helmet = config.getBoolean("netherstar_helmet", CATEGORY_STARS, netherstar_helmet, "Enables / Disables Recipe Changes for the Netherstar Helmet.");
		netherstar_chestplate = config.getBoolean("netherstar_chestplate", CATEGORY_STARS, netherstar_chestplate, "Enables / Disables Recipe Changes for the Netherstar Chestplate.");
		netherstar_leggings = config.getBoolean("netherstar_leggings", CATEGORY_STARS, netherstar_leggings, "Enables / Disables Recipe Changes for the Netherstar Leggings.");
		netherstar_boots = config.getBoolean("netherstar_boots", CATEGORY_STARS, netherstar_boots, "Enables / Disables Recipe Changes for the Netherstar Boots.");
		
		config.addCustomCategoryComment(CATEGORY_TRIGEMS, "Enable / Disable any Part of the TriGems Integration.");
		topaz = config.getBoolean("topaz_0_enable", CATEGORY_TRIGEMS, topaz, "Enables / Disables Recipe Changes for Topaz Tools and Armor.");
		topaz_blocks = config.getBoolean("topaz_1_blocks", CATEGORY_TRIGEMS, topaz_blocks, "Enables / Disables the use of Blocks to Nerf Topaz Recipes.");
		topaz_pickaxe = config.getBoolean("topaz_pickaxe", CATEGORY_TRIGEMS, topaz_pickaxe, "Enables / Disables Recipe Changes for the Topaz Pickaxe.");
		topaz_axe = config.getBoolean("topaz_axe", CATEGORY_TRIGEMS, topaz_axe, "Enables / Disables Recipe Changes for the Topaz Axe.");
		topaz_shovel = config.getBoolean("topaz_shovel", CATEGORY_TRIGEMS, topaz_shovel, "Enables / Disables Recipe Changes for the Topaz Shovel.");
		topaz_hoe = config.getBoolean("topaz_hoe", CATEGORY_TRIGEMS, topaz_hoe, "Enables / Disables Recipe Changes for the Topaz Hoe.");
		topaz_sword = config.getBoolean("topaz_sword", CATEGORY_TRIGEMS, topaz_sword, "Enables / Disables Recipe Changes for the Topaz Sword.");
		topaz_helmet = config.getBoolean("topaz_helmet", CATEGORY_TRIGEMS, topaz_helmet, "Enables / Disables Recipe Changes for the Topaz Helmet.");
		topaz_chestplate = config.getBoolean("topaz_chestplate", CATEGORY_TRIGEMS, topaz_chestplate, "Enables / Disables Recipe Changes for the Topaz Chestplate.");
		topaz_leggings = config.getBoolean("topaz_leggings", CATEGORY_TRIGEMS, topaz_leggings, "Enables / Disables Recipe Changes for the Topaz Leggings.");
		topaz_boots = config.getBoolean("topaz_boots", CATEGORY_TRIGEMS, topaz_boots, "Enables / Disables Recipe Changes for the Topaz Boots.");
		
		rubyt = config.getBoolean("ruby_0_enable", CATEGORY_TRIGEMS, rubyt, "Enables / Disables Recipe Changes for Ruby Tools and Armor.");
		rubyt_blocks = config.getBoolean("ruby_1_blocks", CATEGORY_TRIGEMS, rubyt_blocks, "Enables / Disables the use of Blocks to Nerf Ruby Recipes.");
		rubyt_pickaxe = config.getBoolean("ruby_pickaxe", CATEGORY_TRIGEMS, rubyt_pickaxe, "Enables / Disables Recipe Changes for the Ruby Pickaxe.");
		rubyt_axe = config.getBoolean("ruby_axe", CATEGORY_TRIGEMS, rubyt_axe, "Enables / Disables Recipe Changes for the Ruby Axe.");
		rubyt_shovel = config.getBoolean("ruby_shovel", CATEGORY_TRIGEMS, rubyt_shovel, "Enables / Disables Recipe Changes for the Ruby Shovel.");
		rubyt_hoe = config.getBoolean("ruby_hoe", CATEGORY_TRIGEMS, rubyt_hoe, "Enables / Disables Recipe Changes for the Ruby Hoe.");
		rubyt_sword = config.getBoolean("ruby_sword", CATEGORY_TRIGEMS, rubyt_sword, "Enables / Disables Recipe Changes for the Ruby Sword.");
		rubyt_helmet = config.getBoolean("ruby_helmet", CATEGORY_TRIGEMS, rubyt_helmet, "Enables / Disables Recipe Changes for the Ruby Helmet.");
		rubyt_chestplate = config.getBoolean("ruby_chestplate", CATEGORY_TRIGEMS, rubyt_chestplate, "Enables / Disables Recipe Changes for the Ruby Chestplate.");
		rubyt_leggings = config.getBoolean("ruby_leggings", CATEGORY_TRIGEMS, rubyt_leggings, "Enables / Disables Recipe Changes for the Ruby Leggings.");
		rubyt_boots = config.getBoolean("ruby_boots", CATEGORY_TRIGEMS, rubyt_boots, "Enables / Disables Recipe Changes for the Ruby Boots.");
		
		sapphire = config.getBoolean("sapphire_0_enable", CATEGORY_TRIGEMS, sapphire, "Enables / Disables Recipe Changes for Sapphire Tools and Armor.");
		sapphire_blocks = config.getBoolean("sapphire_1_blocks", CATEGORY_TRIGEMS, sapphire_blocks, "Enables / Disables the use of Blocks to Nerf Sapphire Recipes.");
		sapphire_pickaxe = config.getBoolean("sapphire_pickaxe", CATEGORY_TRIGEMS, sapphire_pickaxe, "Enables / Disables Recipe Changes for the Sapphire Pickaxe.");
		sapphire_axe = config.getBoolean("sapphire_axe", CATEGORY_TRIGEMS, sapphire_axe, "Enables / Disables Recipe Changes for the Sapphire Axe.");
		sapphire_shovel = config.getBoolean("sapphire_shovel", CATEGORY_TRIGEMS, sapphire_shovel, "Enables / Disables Recipe Changes for the Sapphire Shovel.");
		sapphire_hoe = config.getBoolean("sapphire_hoe", CATEGORY_TRIGEMS, sapphire_hoe, "Enables / Disables Recipe Changes for the Sapphire Hoe.");
		sapphire_sword = config.getBoolean("sapphire_sword", CATEGORY_TRIGEMS, sapphire_sword, "Enables / Disables Recipe Changes for the Sapphire Sword.");
		sapphire_helmet = config.getBoolean("sapphire_helmet", CATEGORY_TRIGEMS, sapphire_helmet, "Enables / Disables Recipe Changes for the Sapphire Helmet.");
		sapphire_chestplate = config.getBoolean("sapphire_chestplate", CATEGORY_TRIGEMS, sapphire_chestplate, "Enables / Disables Recipe Changes for the Sapphire Chestplate.");
		sapphire_leggings = config.getBoolean("sapphire_leggings", CATEGORY_TRIGEMS, sapphire_leggings, "Enables / Disables Recipe Changes for the Sapphire Leggings.");
		sapphire_boots = config.getBoolean("sapphire_boots", CATEGORY_TRIGEMS, sapphire_boots, "Enables / Disables Recipe Changes for the Sapphire Boots.");
		
		emeraldt = config.getBoolean("emerald_0_enable", CATEGORY_TRIGEMS, emeraldt, "Enables / Disables Recipe Changes for Emerald Tools and Armor.");
		emeraldt_blocks = config.getBoolean("emerald_1_blocks", CATEGORY_TRIGEMS, emeraldt_blocks, "Enables / Disables the use of Blocks to Nerf Emerald Recipes.");
		emeraldt_pickaxe = config.getBoolean("emerald_pickaxe", CATEGORY_TRIGEMS, emeraldt_pickaxe, "Enables / Disables Recipe Changes for the Emerald Pickaxe.");
		emeraldt_axe = config.getBoolean("emerald_axe", CATEGORY_TRIGEMS, emeraldt_axe, "Enables / Disables Recipe Changes for the Emerald Axe.");
		emeraldt_shovel = config.getBoolean("emerald_shovel", CATEGORY_TRIGEMS, emeraldt_shovel, "Enables / Disables Recipe Changes for the Emerald Shovel.");
		emeraldt_hoe = config.getBoolean("emerald_hoe", CATEGORY_TRIGEMS, emeraldt_hoe, "Enables / Disables Recipe Changes for the Emerald Hoe.");
		emeraldt_sword = config.getBoolean("emerald_sword", CATEGORY_TRIGEMS, emeraldt_sword, "Enables / Disables Recipe Changes for the Emerald Sword.");
		emeraldt_helmet = config.getBoolean("emerald_helmet", CATEGORY_TRIGEMS, emeraldt_helmet, "Enables / Disables Recipe Changes for the Emerald Helmet.");
		emeraldt_chestplate = config.getBoolean("emerald_chestplate", CATEGORY_TRIGEMS, emeraldt_chestplate, "Enables / Disables Recipe Changes for the Emerald Chestplate.");
		emeraldt_leggings = config.getBoolean("emerald_leggings", CATEGORY_TRIGEMS, emeraldt_leggings, "Enables / Disables Recipe Changes for the Emerald Leggings.");
		emeraldt_boots = config.getBoolean("emerald_boots", CATEGORY_TRIGEMS, emeraldt_boots, "Enables / Disables Recipe Changes for the Emerald Boots.");
		
		config.addCustomCategoryComment(CATEGORY_VANILLA, "Enable / Disable any Part of the Vanilla Integration.");
		stone = config.getBoolean("stone_0_enable", CATEGORY_VANILLA, stone, "Enables / Disables Recipe Changes for Stone Tools and Armor.");
		stone_pickaxe = config.getBoolean("stone_pickaxe", CATEGORY_VANILLA, stone_pickaxe, "Enables / Disables Recipe Changes for the Stone Pickaxe.");
		stone_axe = config.getBoolean("stone_axe", CATEGORY_VANILLA, stone_axe, "Enables / Disables Recipe Changes for the Stone Axe.");
		stone_shovel = config.getBoolean("stone_shovel", CATEGORY_VANILLA, stone_shovel, "Enables / Disables Recipe Changes for the Stone Shovel.");
		stone_hoe = config.getBoolean("stone_hoe", CATEGORY_VANILLA, stone_hoe, "Enables / Disables Recipe Changes for the Stone Hoe.");
		stone_sword = config.getBoolean("stone_sword", CATEGORY_VANILLA, stone_sword, "Enables / Disables Recipe Changes for the Stone Sword.");
		
		chain = config.getBoolean("chain_0_enable", CATEGORY_VANILLA, chain, "Enables / Disables Recipe Changes for Chain Tools and Armor.");
		chain_helmet = config.getBoolean("chain_helmet", CATEGORY_VANILLA, chain_helmet, "Enables / Disables Recipe Changes for the Chain Helmet.");
		chain_chestplate = config.getBoolean("chain_chestplate", CATEGORY_VANILLA, chain_chestplate, "Enables / Disables Recipe Changes for the Chain Chestplate.");
		chain_leggings = config.getBoolean("chain_leggings", CATEGORY_VANILLA, chain_leggings, "Enables / Disables Recipe Changes for the Chain Leggings.");
		chain_boots = config.getBoolean("chain_boots", CATEGORY_VANILLA, chain_boots, "Enables / Disables Recipe Changes for the Chain Boots.");
		
		iron = config.getBoolean("iron_0_enable", CATEGORY_VANILLA, iron, "Enables / Disables Recipe Changes for Iron Tools and Armor.");
		iron_blocks = config.getBoolean("iron_1_blocks", CATEGORY_VANILLA, iron_blocks, "Enables / Disables the use of Blocks to Nerf Iron Recipes.");
		iron_pickaxe = config.getBoolean("iron_pickaxe", CATEGORY_VANILLA, iron_pickaxe, "Enables / Disables Recipe Changes for the Iron Pickaxe.");
		iron_axe = config.getBoolean("iron_axe", CATEGORY_VANILLA, iron_axe, "Enables / Disables Recipe Changes for the Iron Axe.");
		iron_shovel = config.getBoolean("iron_shovel", CATEGORY_VANILLA, iron_shovel, "Enables / Disables Recipe Changes for the Iron Shovel.");
		iron_hoe = config.getBoolean("iron_hoe", CATEGORY_VANILLA, iron_hoe, "Enables / Disables Recipe Changes for the Iron Hoe.");
		iron_sword = config.getBoolean("iron_sword", CATEGORY_VANILLA, iron_sword, "Enables / Disables Recipe Changes for the Iron Sword.");
		iron_helmet = config.getBoolean("iron_helmet", CATEGORY_VANILLA, iron_helmet, "Enables / Disables Recipe Changes for the Iron Helmet.");
		iron_chestplate = config.getBoolean("iron_chestplate", CATEGORY_VANILLA, iron_chestplate, "Enables / Disables Recipe Changes for the Iron Chestplate.");
		iron_leggings = config.getBoolean("iron_leggings", CATEGORY_VANILLA, iron_leggings, "Enables / Disables Recipe Changes for the Iron Leggings.");
		iron_boots = config.getBoolean("iron_boots", CATEGORY_VANILLA, iron_boots, "Enables / Disables Recipe Changes for the Iron Boots.");
		
		gold = config.getBoolean("gold_0_enable", CATEGORY_VANILLA, gold, "Enables / Disables Recipe Changes for Gold Tools and Armor.");
		gold_blocks = config.getBoolean("gold_1_blocks", CATEGORY_VANILLA, gold_blocks, "Enables / Disables the use of Blocks to Nerf Gold Recipes.");
		gold_pickaxe = config.getBoolean("gold_pickaxe", CATEGORY_VANILLA, gold_pickaxe, "Enables / Disables Recipe Changes for the Gold Pickaxe.");
		gold_axe = config.getBoolean("gold_axe", CATEGORY_VANILLA, gold_axe, "Enables / Disables Recipe Changes for the Gold Axe.");
		gold_shovel = config.getBoolean("gold_shovel", CATEGORY_VANILLA, gold_shovel, "Enables / Disables Recipe Changes for the Gold Shovel.");
		gold_hoe = config.getBoolean("gold_hoe", CATEGORY_VANILLA, gold_hoe, "Enables / Disables Recipe Changes for the Gold Hoe.");
		gold_sword = config.getBoolean("gold_sword", CATEGORY_VANILLA, gold_sword, "Enables / Disables Recipe Changes for the Gold Sword.");
		gold_helmet = config.getBoolean("gold_helmet", CATEGORY_VANILLA, gold_helmet, "Enables / Disables Recipe Changes for the Gold Helmet.");
		gold_chestplate = config.getBoolean("gold_chestplate", CATEGORY_VANILLA, gold_chestplate, "Enables / Disables Recipe Changes for the Gold Chestplate.");
		gold_leggings = config.getBoolean("gold_leggings", CATEGORY_VANILLA, gold_leggings, "Enables / Disables Recipe Changes for the Gold Leggings.");
		gold_boots = config.getBoolean("gold_boots", CATEGORY_VANILLA, gold_boots, "Enables / Disables Recipe Changes for the Gold Boots.");
		
		diamond = config.getBoolean("diamond_0_enable", CATEGORY_VANILLA, diamond, "Enables / Disables Recipe Changes for Diamond Tools and Armor.");
		diamond_blocks = config.getBoolean("diamond_1_blocks", CATEGORY_VANILLA, diamond_blocks, "Enables / Disables the use of Blocks to Nerf Diamond Recipes.");
		diamond_pickaxe = config.getBoolean("diamond_pickaxe", CATEGORY_VANILLA, diamond_pickaxe, "Enables / Disables Recipe Changes for the Diamond Pickaxe.");
		diamond_axe = config.getBoolean("diamond_axe", CATEGORY_VANILLA, diamond_axe, "Enables / Disables Recipe Changes for the Diamond Axe.");
		diamond_shovel = config.getBoolean("diamond_shovel", CATEGORY_VANILLA, diamond_shovel, "Enables / Disables Recipe Changes for the Diamond Shovel.");
		diamond_hoe = config.getBoolean("diamond_hoe", CATEGORY_VANILLA, diamond_hoe, "Enables / Disables Recipe Changes for the Diamond Hoe.");
		diamond_sword = config.getBoolean("diamond_sword", CATEGORY_VANILLA, diamond_sword, "Enables / Disables Recipe Changes for the Diamond Sword.");
		diamond_helmet = config.getBoolean("diamond_helmet", CATEGORY_VANILLA, diamond_helmet, "Enables / Disables Recipe Changes for the Diamond Helmet.");
		diamond_chestplate = config.getBoolean("diamond_chestplate", CATEGORY_VANILLA, diamond_chestplate, "Enables / Disables Recipe Changes for the Diamond Chestplate.");
		diamond_leggings = config.getBoolean("diamond_leggings", CATEGORY_VANILLA, diamond_leggings, "Enables / Disables Recipe Changes for the Diamond Leggings.");
		diamond_boots = config.getBoolean("diamond_boots", CATEGORY_VANILLA, diamond_boots, "Enables / Disables Recipe Changes for the Diamond Boots.");
		
		config.addCustomCategoryComment(CATEGORY_WEAPONS, "Enable / Disable any Part of the New Weapons Mod Integration.");
		redcrystal = config.getBoolean("redcrystal_0_enable", CATEGORY_WEAPONS, redcrystal, "Enables / Disables Recipe Changes for RedCrystal Tools and Armor.");
		redcrystal_blocks = config.getBoolean("redcrystal_1_blocks", CATEGORY_VANILLA, redcrystal_blocks, "Enables / Disables the use of Blocks to Nerf RedCrystal Recipes.");
		redcrystal_pickaxe = config.getBoolean("redcrystal_pickaxe", CATEGORY_WEAPONS, redcrystal_pickaxe, "Enables / Disables Recipe Changes for the RedCrystal Pickaxe.");
		redcrystal_axe = config.getBoolean("redcrystal_axe", CATEGORY_WEAPONS, redcrystal_axe, "Enables / Disables Recipe Changes for the RedCrystal Axe.");
		redcrystal_shovel = config.getBoolean("redcrystal_shovel", CATEGORY_WEAPONS, redcrystal_shovel, "Enables / Disables Recipe Changes for the RedCrystal Shovel.");
		redcrystal_hoe = config.getBoolean("redcrystal_hoe", CATEGORY_WEAPONS, redcrystal_hoe, "Enables / Disables Recipe Changes for the RedCrystal Hoe.");
		redcrystal_sword = config.getBoolean("redcrystal_sword", CATEGORY_WEAPONS, redcrystal_sword, "Enables / Disables Recipe Changes for the RedCrystal Sword.");
		redcrystal_helmet = config.getBoolean("redcrystal_helmet", CATEGORY_VANILLA, redcrystal_helmet, "Enables / Disables Recipe Changes for the RedCrystal Helmet.");
		redcrystal_chestplate = config.getBoolean("redcrystal_chestplate", CATEGORY_VANILLA, redcrystal_chestplate, "Enables / Disables Recipe Changes for the RedCrystal Chestplate.");
		redcrystal_leggings = config.getBoolean("redcrystal_leggings", CATEGORY_VANILLA, redcrystal_leggings, "Enables / Disables Recipe Changes for the RedCrystal Leggings.");
		redcrystal_boots = config.getBoolean("redcrystal_boots", CATEGORY_VANILLA, redcrystal_boots, "Enables / Disables Recipe Changes for the RedCrystal Boots.");
	}
	
	public static void checkModsLoaded() {
		if(!Loader.isModLoaded("avaritia")) {
			avaritia = false;
			if(debug) {
				UpgradeRecipesMod.log.info("Disabling Avaritia Support as Avaritia wasn't loaded!");
			}
		}
		if(!Loader.isModLoaded("draconicevolution")) {
			draconicevolution = false;
			if(debug) {
				UpgradeRecipesMod.log.info("Disabling Draconic Evolution Support as Draconic Evolution wasn't loaded!");
			}
		}
		if(!Loader.isModLoaded("rubymod")) {
			rubymod = false;
			if(debug) {
				UpgradeRecipesMod.log.info("Disabling Ruby Mod Support as Ruby Mod wasn't loaded!");
			}
		}
		if(!Loader.isModLoaded("stars")) {
			stars = false;
			if(debug) {
				UpgradeRecipesMod.log.info("Disabling Stars Mod Support as Stars Mod wasn't loaded!");
			}
		}
		if(!Loader.isModLoaded("trigems")) {
			trigems = false;
			if(debug) {
				UpgradeRecipesMod.log.info("Disabling TriGems Support as TriGems wasn't loaded!");
			}
		}
		if(!Loader.isModLoaded("weapons")) {
			weapons = false;
			if(debug) {
				UpgradeRecipesMod.log.info("Disabling New Weapons Support as New Weapons wasn't loaded!");
			}
		}
	}
	
}