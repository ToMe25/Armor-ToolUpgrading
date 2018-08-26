package com.ToMe.upgraderecipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.MissingModsException;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.versioning.ArtifactVersion;
import net.minecraftforge.fml.common.versioning.DefaultArtifactVersion;
//import scala.collection.immutable.HashMap;
import net.minecraftforge.oredict.OreDictionary;

public class UpgradeRecipesCommonProxy {
	
	//protected static HashMap<String, ResourceLocation> materialMap = new HashMap<String, ResourceLocation>();
	//protected static HashMap<String, String> materialMap = new HashMap<String, String>();
	//protected static HashMap<String, String> ToolMap = new HashMap<String, String>();
	/**Used to get the Item IDs.*/
	protected static HashMap<String, ResourceLocation> ToolMap = new HashMap<String, ResourceLocation>();
	/**Used to get the Item IDs.*/
	protected static HashMap<String, ResourceLocation> ArmorMap = new HashMap<String, ResourceLocation>();
	//protected static HashMap<String, ItemStack> ToolMaterialMap = new HashMap<String, ItemStack>();
	//protected static HashMap<String, String> ToolMaterialMap = new HashMap<String, String>();
	protected static HashMap<String, String> MaterialMap = new HashMap<String, String>();
	
	/**
	 * Used to get Items with Custom Recipes.
	 */
	protected static HashMap<String, String> customCrafting = new HashMap<String, String>();
	
	/**
	 * Used to get the Materials to Change their Recipes.
	 */
	protected static ArrayList<String> toChange = new ArrayList<String>();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		UpgradeRecipesMod.log = e.getModLog();
		//initMaterialMap();
		//initToolMap();
		//initChangeList();
		//initMapsAndLists();
		if(!Loader.isModLoaded("trigems") && !Loader.isModLoaded("rubymod")) {
			//UpgradeRecipesMod.proxy.throwModsMissingException("Missing Mods:", "trigems");
			UpgradeRecipesMod.proxy.throwModsMissingException("Missing Mods:", new String[] {"rubymod", "trigems"});
		}
		UpgradeRecipesMod.cfg = new Config(e.getSuggestedConfigurationFile());
		initMapsAndLists();
		if(!Config.rubymod && !Config.trigems) {
			//UpgradeRecipesMod.proxy.throwConfigException("You need to have at least Ruby Mod or TriGems support enabled!");
			UpgradeRecipesMod.proxy.throwConfigException("You need to have at least Ruby Mod or TriGems support enabled!\n"
				+ "You can enable one(or both) in the Config File at " + e.getSuggestedConfigurationFile().getAbsolutePath() + " at \"supported_mods\"!");
		}
		registerOreDict();
		//TestgetBlockOreDict();//Just for Testing.
	}
	
	//public void throwModsMissingException() {
		
	//}
	
	/**
	 * on Server side: Throws a new MissingModsException.
	 * on Client side: gives a new MissingModsException to the FMLClientHandler.
	 * @param cause
	 * @param mods
	 */
	//public void throwModsMissingException(String cause, String... mods) {
	public void throwModsMissingException(String cause, String[]... mods) {
		throw new MissingModsException(setFromArray(mods), UpgradeRecipesMod.MODID, UpgradeRecipesMod.MODID);
	}
	
	/**
	 * on Server side: Throws a new NullPonterException.
	 * on Client side: gives a new ConfigLoadingException to the FMLClientHandler.
	 * @param cause
	 * @param mods
	 */
	//public void throwModsMissingException(String cause, String... mods) {
	public void throwConfigException(String cause) {
		//throw new ConfigLoadingException(cause);
		throw new NullPointerException(cause);
	}
	
	/**
	 * Initializes all Maps and List from this Class.
	 */
	protected void initMapsAndLists(){
		//initMaterialMap();
		initToolMap();
		initArmorMap();
		initChangeList();
		//initToolMaterialMap();
		initMaterialMap();
		initCustomCraftingMap();
	}
	
	/**
	 * Registeres some Default OreDictionary Blocks.
	 */
	private void registerOreDict(){
		if(Config.oreDictBoneBlock) {
			OreDictionary.registerOre("blockBone", Blocks.BONE_BLOCK);
		}
		if(Config.oreDictWool) {
			OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE));
		}
	}
	
	/**
	 * Initializes the Map used to check which Items using a Custom Recipe.
	 */
	protected void initCustomCraftingMap() {
		customCrafting.put("skullfire", "dire");
		customCrafting.put("wyvern", "crafting");
		customCrafting.put("draconic", "fusion");
		customCrafting.put("infinity", "dire");
	}
	
	//public void initMaterialMap() {
		//materialMap.put("wood", "minecraft:wood_");
		//materialMap.put("stone", "minecraft:stone_");
		//materialMap.put("iron", "minecraft:iron_");
		//materialMap.put("gold", "minecraft:gold_");
		//materialMap.put("topaz", "trigems:topaz_");
		//materialMap.put("rubyT", "trigems:ruby_");
		//materialMap.put("rubyR", "rubymod:ruby");
		//materialMap.put("diamond", "minecraft:diamond_");
		//materialMap.put("sapphire", "trigems:sapphire");
		//materialMap.put("emeraldT", "trigems:emerald_");
		//materialMap.put("emeraldR", "rubymod:emerald");
		//materialMap.put("redcrystal", "weapons:redcrystal");
		//materialMap.put("star", "stars:star_");
		//materialMap.put("wyvern", "draconicevolution:wyvern_");
		//materialMap.put("draconic", "draconicevolution:draconic_");
		//materialMap.put("infinity", "avaritia:infinity_");
	//}
	
	/**
	 * Initializes the List used to figure out Items from which Materials should get new Recipes.
	 */
	protected void initChangeList() {
		if(Config.avaritia) {
			if(Config.skullfire) {
				toChange.add("skullfire");
			}
			if(Config.infinity) {
				toChange.add("infinity");
			}
		}
		if(Config.draconicevolution) {
			if(Config.wyvern) {
				toChange.add("wyvern");
			}
			if(Config.draconic) {
				toChange.add("draconic");
			}
		}
		if(Config.rubymod) {
			if(Config.rubyr) {
				toChange.add("rubyr");
			}
			if(Config.emeraldr) {
				toChange.add("emeraldr");
			}
		}
		if(Config.stars) {
			if(Config.netherstar) {
				toChange.add("netherstar");
			}
		}
		if(Config.trigems) {
			if(Config.topaz) {
				toChange.add("topaz");
			}
			if(Config.rubyt) {
				toChange.add("rubyt");
			}
			if(Config.sapphire) {
				toChange.add("sapphire");
			}
			if(Config.emeraldt) {
				toChange.add("emeraldt");
			}
		}
		if(Config.vanilla) {
			if(Config.stone) {
				toChange.add("stone");
			}
			if(Config.chain) {
				toChange.add("chain");
			}
			if(Config.iron) {
				toChange.add("iron");
			}
			if(Config.gold) {
				toChange.add("gold");
			}
			if(Config.diamond) {
				toChange.add("diamond");
			}
		}
		if(Config.weapons) {
			if(Config.redcrystal) {
				toChange.add("redcrystal");
			}
		}
	}
	
	/**
	 * Initializes the Material Map used to get the Crafting Item/OreDict for any Material.
	 */
	protected void initMaterialMap() {
		MaterialMap.put("wood", "plankWood");
		MaterialMap.put("leather", "leather");
		MaterialMap.put("stone", "cobblestone");
		MaterialMap.put("chain", "minecraft:iron_bars");
		MaterialMap.put("iron", "ingotIron");
		MaterialMap.put("gold", "ingotGold");
		MaterialMap.put("topaz", "gemTopaz");
		MaterialMap.put("rubyt", "gemRuby");
		MaterialMap.put("rubyr", "gemRuby");
		MaterialMap.put("diamond", "gemDiamond");
		MaterialMap.put("sapphire", "gemSapphire");
		MaterialMap.put("emeraldt", "gemEmerald");
		MaterialMap.put("emeraldr", "gemEmerald");
		MaterialMap.put("redcrystal", "weapons:Red_Crystal");
		MaterialMap.put("netherstar", "netherStar");
		MaterialMap.put("skullfire", "ingotCrystalMatrix");
		MaterialMap.put("wyvern", "ingotDraconium");
		MaterialMap.put("draconic", "ingotDraconiumAwakened");
		MaterialMap.put("infinity", "ingotInfinity");
	}
	
	/**
	 * Initializes the Tool Material Map.
	 */
	//protected void initToolMaterialMap() {
		//ToolMaterialMap.put("wood", new ItemStack(Item.REGISTRY.getObject(new ResourceLocation("minecraft:planks")), 1, (int)Float.MAX_VALUE));
		//ToolMaterialMap.put("wood", "plankWood");
		//ToolMaterialMap.put("stone", "cobblestone");
		//ToolMaterialMap.put("iron", "ingotIron");
		//ToolMaterialMap.put("gold", "ingotGold");
		//ToolMaterialMap.put("topaz", "gemTopaz");
		//ToolMaterialMap.put("rubyt", "gemRuby");
		//ToolMaterialMap.put("rubyr", "gemRuby");
		//ToolMaterialMap.put("diamond", "gemDiamond");
		//ToolMaterialMap.put("sapphire", "gemSapphire");
		//ToolMaterialMap.put("emeraldt", "gemEmerald");
		//ToolMaterialMap.put("emeraldr", "gemEmerald");
		//ToolMaterialMap.put("skullfire", "ingotCrystalMatrix");//oops the Skullfire Sword is stronger...
		//ToolMaterialMap.put("redcrystal", "weapons:Red_Crystal");
		//ToolMaterialMap.put("netherstar", "netherStar");
		//ToolMaterialMap.put("skullfire", "ingotCrystalMatrix");
		//ToolMaterialMap.put("wyvern", "ingotDraconium");
		//ToolMaterialMap.put("draconic", "ingotDraconiumAwakened");
		//ToolMaterialMap.put("infinity", "ingotInfinity");
	//}
	
	/**
	 * Initializes the Tool Map used to get the Item IDs.
	 */
	//public void initToolMap() {
	protected void initToolMap() {
		//WOOD
		//ToolMap.put("wood:sword", new ResourceLocation("minecraft:wooden_sword"));
		ToolMap.put("wood:pickaxe", new ResourceLocation("minecraft:wooden_pickaxe"));
		ToolMap.put("wood:axe", new ResourceLocation("minecraft:wooden_axe"));
		ToolMap.put("wood:shovel", new ResourceLocation("minecraft:wooden_shovel"));
		ToolMap.put("wood:hoe", new ResourceLocation("minecraft:wooden_hoe"));
		ToolMap.put("wood:sword", new ResourceLocation("minecraft:wooden_sword"));
		ToolMap.put("wood:bow", new ResourceLocation("minecraft:bow"));
		
		//STONE
		//ToolMap.put("stone:sword", new ResourceLocation("minecraft:stone_sword"));
		ToolMap.put("stone:pickaxe", new ResourceLocation("minecraft:stone_pickaxe"));
		ToolMap.put("stone:axe", new ResourceLocation("minecraft:stone_axe"));
		ToolMap.put("stone:shovel", new ResourceLocation("minecraft:stone_shovel"));
		ToolMap.put("stone:hoe", new ResourceLocation("minecraft:stone_hoe"));
		ToolMap.put("stone:sword", new ResourceLocation("minecraft:stone_sword"));
		
		//IRON
		//ToolMap.put("iron:sword", new ResourceLocation("minecraft:iron_sword"));
		ToolMap.put("iron:pickaxe", new ResourceLocation("minecraft:iron_pickaxe"));
		ToolMap.put("iron:axe", new ResourceLocation("minecraft:iron_axe"));
		ToolMap.put("iron:shovel", new ResourceLocation("minecraft:iron_shovel"));
		ToolMap.put("iron:hoe", new ResourceLocation("minecraft:iron_hoe"));
		ToolMap.put("iron:sword", new ResourceLocation("minecraft:iron_sword"));
		
		//GOLD
		//ToolMap.put("gold:sword", new ResourceLocation("minecraft:golden_sword"));
		ToolMap.put("gold:pickaxe", new ResourceLocation("minecraft:golden_pickaxe"));
		ToolMap.put("gold:axe", new ResourceLocation("minecraft:golden_axe"));
		ToolMap.put("gold:shovel", new ResourceLocation("minecraft:golden_shovel"));
		ToolMap.put("gold:hoe", new ResourceLocation("minecraft:golden_hoe"));
		ToolMap.put("gold:sword", new ResourceLocation("minecraft:golden_sword"));
		
		//TOPAZ
		//ToolMap.put("topaz:sword", new ResourceLocation("trigems:topaz_sword"));
		ToolMap.put("topaz:pickaxe", new ResourceLocation("trigems:topaz_pickaxe"));
		ToolMap.put("topaz:axe", new ResourceLocation("trigems:topaz_axe"));
		ToolMap.put("topaz:shovel", new ResourceLocation("trigems:topaz_shovel"));
		ToolMap.put("topaz:hoe", new ResourceLocation("trigems:topaz_hoe"));
		ToolMap.put("topaz:sword", new ResourceLocation("trigems:topaz_sword"));
		
		//RUBYT
		//ToolMap.put("rubyt:sword", new ResourceLocation("trigems:ruby_sword"));
		ToolMap.put("rubyt:pickaxe", new ResourceLocation("trigems:ruby_pickaxe"));
		ToolMap.put("rubyt:axe", new ResourceLocation("trigems:ruby_axe"));
		ToolMap.put("rubyt:shovel", new ResourceLocation("trigems:ruby_shovel"));
		ToolMap.put("rubyt:hoe", new ResourceLocation("trigems:ruby_hoe"));
		ToolMap.put("rubyt:sword", new ResourceLocation("trigems:ruby_sword"));
		
		//RUBYR
		//ToolMap.put("rubyr:sword", new ResourceLocation("rubymod:rubysword"));
		ToolMap.put("rubyr:pickaxe", new ResourceLocation("rubymod:rubypickaxe"));
		ToolMap.put("rubyr:axe", new ResourceLocation("rubymod:rubyaxe"));
		ToolMap.put("rubyr:shovel", new ResourceLocation("rubymod:rubyshovel"));
		ToolMap.put("rubyr:hoe", new ResourceLocation("rubymod:rubyhoe"));
		ToolMap.put("rubyr:sword", new ResourceLocation("rubymod:rubysword"));
		
		//DIAMOND
		//ToolMap.put("diamond:sword", new ResourceLocation("minecraft:diamond_sword"));
		ToolMap.put("diamond:pickaxe", new ResourceLocation("minecraft:diamond_pickaxe"));
		ToolMap.put("diamond:axe", new ResourceLocation("minecraft:diamond_axe"));
		ToolMap.put("diamond:shovel", new ResourceLocation("minecraft:diamond_shovel"));
		ToolMap.put("diamond:hoe", new ResourceLocation("minecraft:diamond_hoe"));
		ToolMap.put("diamond:sword", new ResourceLocation("minecraft:diamond_sword"));
		
		//SAPPHIRE
		//ToolMap.put("sapphire:sword", new ResourceLocation("trigems:sapphire_sword"));
		ToolMap.put("sapphire:pickaxe", new ResourceLocation("trigems:sapphire_pickaxe"));
		ToolMap.put("sapphire:axe", new ResourceLocation("trigems:sapphire_axe"));
		ToolMap.put("sapphire:shovel", new ResourceLocation("trigems:sapphire_shovel"));
		ToolMap.put("sapphire:hoe", new ResourceLocation("trigems:sapphire_hoe"));
		ToolMap.put("sapphire:sword", new ResourceLocation("trigems:sapphire_sword"));
		
		//EMERALDT
		//ToolMap.put("emeraldt:sword", new ResourceLocation("trigems:emerald_sword"));
		ToolMap.put("emeraldt:pickaxe", new ResourceLocation("trigems:emerald_pickaxe"));
		ToolMap.put("emeraldt:axe", new ResourceLocation("trigems:emerald_axe"));
		ToolMap.put("emeraldt:shovel", new ResourceLocation("trigems:emerald_shovel"));
		ToolMap.put("emeraldt:hoe", new ResourceLocation("trigems:emerald_hoe"));
		ToolMap.put("emeraldt:sword", new ResourceLocation("trigems:emerald_sword"));
		
		//EMERALDR
		//ToolMap.put("emeraldr:sword", new ResourceLocation("rubymod:emeraldsword"));
		ToolMap.put("emeraldr:pickaxe", new ResourceLocation("rubymod:emeraldpickaxe"));
		ToolMap.put("emeraldr:axe", new ResourceLocation("rubymod:emeraldaxe"));
		ToolMap.put("emeraldr:shovel", new ResourceLocation("rubymod:emeraldshovel"));
		ToolMap.put("emeraldr:hoe", new ResourceLocation("rubymod:emeraldhoe"));
		ToolMap.put("emeraldr:sword", new ResourceLocation("rubymod:emeraldsword"));
		
		//SKULLFIRE
		//ToolMap.put("skullfire:sword", new ResourceLocation("avaritia:skullfire_sword"));//oops the Skullfire Sword is stronger...
		
		//REDCRYSTAL
		//ToolMap.put("redcrystal:sword", new ResourceLocation("weapons:RedCrystalSword"));
		ToolMap.put("redcrystal:pickaxe", new ResourceLocation("weapons:RedCrystalPickaxe"));
		ToolMap.put("redcrystal:axe", new ResourceLocation("weapons:RedCrystalAxe"));
		ToolMap.put("redcrystal:shovel", new ResourceLocation("weapons:RedCrystalShovel"));
		ToolMap.put("redcrystal:hoe", new ResourceLocation("weapons:RedCrystalHoe"));
		ToolMap.put("redcrystal:sword", new ResourceLocation("weapons:RedCrystalSword"));
		
		//NETHERSTAR
		//ToolMap.put("star:sword", new ResourceLocation("stars:star_sword"));
		ToolMap.put("netherstar:pickaxe", new ResourceLocation("stars:star_pickaxe"));
		ToolMap.put("netherstar:axe", new ResourceLocation("stars:star_axe"));
		ToolMap.put("netherstar:shovel", new ResourceLocation("stars:star_shovel"));
		ToolMap.put("netherstar:hoe", new ResourceLocation("stars:star_hoe"));
		ToolMap.put("netherstar:sword", new ResourceLocation("stars:star_sword"));
		
		//SKULLFIRE
		ToolMap.put("skullfire:sword", new ResourceLocation("avaritia:skullfire_sword"));
		
		//WYVERN
		//ToolMap.put("wyvern:sword", new ResourceLocation("draconicevolution:wyvern_sword"));
		ToolMap.put("wyvern:pickaxe", new ResourceLocation("draconicevolution:wyvern_pick"));
		ToolMap.put("wyvern:axe", new ResourceLocation("draconicevolution:wyvern_axe"));
		ToolMap.put("wyvern:shovel", new ResourceLocation("draconicevolution:wyvern_shovel"));
		//ToolMap.put("wyvern:hoe", new ResourceLocation("draconicevolution:wyvern_hoe"));
		ToolMap.put("wyvern:sword", new ResourceLocation("draconicevolution:wyvern_sword"));
		ToolMap.put("wyvern:bow", new ResourceLocation("draconicevolution:wyvern_bow"));
		
		//DRACONIC
		//ToolMap.put("draconic:sword", new ResourceLocation("draconicevolution:draconic_sword"));
		ToolMap.put("draconic:pickaxe", new ResourceLocation("draconicevolution:draconic_pick"));
		ToolMap.put("draconic:axe", new ResourceLocation("draconicevolution:draconic_axe"));
		ToolMap.put("draconic:shovel", new ResourceLocation("draconicevolution:draconic_shovel"));
		ToolMap.put("draconic:hoe", new ResourceLocation("draconicevolution:draconic_hoe"));
		ToolMap.put("draconic:sword", new ResourceLocation("draconicevolution:draconic_sword"));
		ToolMap.put("draconic:bow", new ResourceLocation("draconicevolution:draconic_bow"));
		
		//INFINITY
		//ToolMap.put("infinity:sword", new ResourceLocation("avaritia:infinity_sword"));
		ToolMap.put("infinity:pickaxe", new ResourceLocation("avaritia:infinity_pickaxe"));
		ToolMap.put("infinity:axe", new ResourceLocation("avaritia:infinity_axe"));
		ToolMap.put("infinity:shovel", new ResourceLocation("avaritia:infinity_shovel"));
		ToolMap.put("infinity:hoe", new ResourceLocation("avaritia:infinity_hoe"));
		ToolMap.put("infinity:sword", new ResourceLocation("avaritia:infinity_sword"));
		ToolMap.put("infinity:bow", new ResourceLocation("avaritia:infinity_bow"));
	}
	
	/**
	 * Initializes the Armor Map used to get the Item IDs.
	 */
	protected static void initArmorMap() {
		//LEATHER
		ArmorMap.put("leather:helmet", new ResourceLocation("minecraft:leather_helmet"));
		ArmorMap.put("leather:chestplate", new ResourceLocation("minecraft:leather_chestplate"));
		ArmorMap.put("leather:leggings", new ResourceLocation("minecraft:leather_leggings"));
		ArmorMap.put("leather:boots", new ResourceLocation("minecraft:leather_boots"));
		
		//CHAIN
		ArmorMap.put("chain:helmet", new ResourceLocation("minecraft:chainmail_helmet"));
		ArmorMap.put("chain:chestplate", new ResourceLocation("minecraft:chainmail_chestplate"));
		ArmorMap.put("chain:leggings", new ResourceLocation("minecraft:chainmail_leggings"));
		ArmorMap.put("chain:boots", new ResourceLocation("minecraft:chainmail_boots"));
		
		//IRON
		ArmorMap.put("iron:helmet", new ResourceLocation("minecraft:iron_helmet"));
		ArmorMap.put("iron:chestplate", new ResourceLocation("minecraft:iron_chestplate"));
		ArmorMap.put("iron:leggings", new ResourceLocation("minecraft:iron_leggings"));
		ArmorMap.put("iron:boots", new ResourceLocation("minecraft:iron_boots"));
		
		//GOLD
		ArmorMap.put("gold:helmet", new ResourceLocation("minecraft:golden_helmet"));
		ArmorMap.put("gold:chestplate", new ResourceLocation("minecraft:golden_chestplate"));
		ArmorMap.put("gold:leggings", new ResourceLocation("minecraft:golden_leggings"));
		ArmorMap.put("gold:boots", new ResourceLocation("minecraft:golden_boots"));
		
		//TOPAZ
		ArmorMap.put("topaz:helmet", new ResourceLocation("trigems:topaz_helmet"));
		ArmorMap.put("topaz:chestplate", new ResourceLocation("trigems:topaz_chestplate"));
		ArmorMap.put("topaz:leggings", new ResourceLocation("trigems:topaz_leggings"));
		ArmorMap.put("topaz:boots", new ResourceLocation("trigems:topaz_boots"));
		
		//RUBYT
		ArmorMap.put("rubyt:helmet", new ResourceLocation("trigems:ruby_helmet"));
		ArmorMap.put("rubyt:chestplate", new ResourceLocation("trigems:ruby_chestplate"));
		ArmorMap.put("rubyt:leggings", new ResourceLocation("trigems:ruby_leggings"));
		ArmorMap.put("rubyt:boots", new ResourceLocation("trigems:ruby_boots"));
		
		//RUBYR
		ArmorMap.put("rubyr:helmet", new ResourceLocation("rubymod:RubyHelmet"));
		ArmorMap.put("rubyr:chestplate", new ResourceLocation("rubymod:RubyChestplate"));
		ArmorMap.put("rubyr:leggings", new ResourceLocation("rubymod:RubyLeggings"));
		ArmorMap.put("rubyr:boots", new ResourceLocation("rubymod:RubyBoots"));
		
		//DIAMOND
		ArmorMap.put("diamond:helmet", new ResourceLocation("minecraft:diamond_helmet"));
		ArmorMap.put("diamond:chestplate", new ResourceLocation("minecraft:diamond_chestplate"));
		ArmorMap.put("diamond:leggings", new ResourceLocation("minecraft:diamond_leggings"));
		ArmorMap.put("diamond:boots", new ResourceLocation("minecraft:diamond_boots"));
		
		//SAPPHIRE
		ArmorMap.put("sapphire:helmet", new ResourceLocation("trigems:sapphire_helmet"));
		ArmorMap.put("sapphire:chestplate", new ResourceLocation("trigems:sapphire_chestplate"));
		ArmorMap.put("sapphire:leggings", new ResourceLocation("trigems:sapphire_leggings"));
		ArmorMap.put("sapphire:boots", new ResourceLocation("trigems:sapphire_boots"));
		
		//EMERALDT
		ArmorMap.put("emeraldt:helmet", new ResourceLocation("trigems:emerald_helmet"));
		ArmorMap.put("emeraldt:chestplate", new ResourceLocation("trigems:emerald_chestplate"));
		ArmorMap.put("emeraldt:leggings", new ResourceLocation("trigems:emerald_leggings"));
		ArmorMap.put("emeraldt:boots", new ResourceLocation("trigems:emerald_boots"));
		
		//EMERALDR
		ArmorMap.put("emeraldr:helmet", new ResourceLocation("rubymod:EmeraldHelmet"));
		ArmorMap.put("emeraldr:chestplate", new ResourceLocation("rubymod:EmeraldChestplate"));
		ArmorMap.put("emeraldr:leggings", new ResourceLocation("rubymod:EmeraldLeggings"));
		ArmorMap.put("emeraldr:boots", new ResourceLocation("rubymod:EmeraldBoots"));
		
		//REDCRYSTAL
		ArmorMap.put("redcrystal:helmet", new ResourceLocation("weapons:RedCrystalHelmet"));
		ArmorMap.put("redcrystal:chestplate", new ResourceLocation("weapons:RedCrystalChestplate"));
		ArmorMap.put("redcrystal:leggings", new ResourceLocation("weapons:RedCrystalLeggings"));
		ArmorMap.put("redcrystal:boots", new ResourceLocation("weapons:RedCrystalBoots"));
		
		//NETHERSTAR
		ArmorMap.put("netherstar:helmet", new ResourceLocation("stars:star_helmet"));
		ArmorMap.put("netherstar:chestplate", new ResourceLocation("stars:star_chestplate"));
		ArmorMap.put("netherstar:leggings", new ResourceLocation("stars:star_leggings"));
		ArmorMap.put("netherstar:boots", new ResourceLocation("stars:star_boots"));
		
		//WYVERN
		ArmorMap.put("wyvern:helmet", new ResourceLocation("draconicevolution:wyvern_helm"));
		ArmorMap.put("wyvern:chestplate", new ResourceLocation("draconicevolution:wyvern_chest"));
		ArmorMap.put("wyvern:leggings", new ResourceLocation("draconicevolution:wyvern_legs"));
		ArmorMap.put("wyvern:boots", new ResourceLocation("draconicevolution:wyvern_boots"));
		
		//DRACONIC
		ArmorMap.put("draconic:helmet", new ResourceLocation("draconicevolution:draconic_helm"));
		ArmorMap.put("draconic:chestplate", new ResourceLocation("draconicevolution:draconic_chest"));
		ArmorMap.put("draconic:leggings", new ResourceLocation("draconicevolution:draconic_legs"));
		ArmorMap.put("draconic:boots", new ResourceLocation("draconicevolution:draconic_boots"));
		
		//INFINITY
		ArmorMap.put("infinity:helmet", new ResourceLocation("avaritia:infinity_helmet"));
		ArmorMap.put("infinity:chestplate", new ResourceLocation("avaritia:infinity_chestplate"));
		ArmorMap.put("infinity:leggings", new ResourceLocation("avaritia:infinity_pants"));
		ArmorMap.put("infinity:boots", new ResourceLocation("avaritia:infinity_boots"));
	}
	
	/**
	 * Used if this mod needs only MODA or MODB.
	 * Creates a HashSet of DefaultArtifactVersions filled with MODA / MODB... for every String Array.
	 * @param missingMods the String Arrays to use.
	 * @return
	 */
	public static Set<ArtifactVersion> setFromArray(String[]... missingMods) {
		Set<ArtifactVersion> ret = new HashSet<ArtifactVersion>();
		for(String[] mods:missingMods) {
			String str = "";
			for(String s:mods) {
				if(str.length() > 0) {
					str += " / ";
				}
				str += s;
			}
			DefaultArtifactVersion mod = new DefaultArtifactVersion(str, true);
			ret.add(mod);
		}
		return ret;
	}
	
	/**
	 * Just for Testing.
	 */
	private static void TestgetBlockOreDict() {
		UpgradeRecipesMod.log.info("TESTING!");
		UpgradeRecipesMod.log.info("**********");
		RecipeAdd.getBlockOreDict("diamond");
		RecipeAdd.getBlockOreDict("gemDiamond");
		RecipeAdd.getBlockOreDict("gold");
		RecipeAdd.getBlockOreDict("ingotGold");
		RecipeAdd.getBlockOreDict("Test");
		UpgradeRecipesMod.log.info("**********");
	}
	
}