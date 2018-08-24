package com.ToMe.upgraderecipes;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.Logger;

import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.MissingModsException;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModClassLoader;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLLoadEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLStateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.functions.ArtifactVersionNameFunction;
import net.minecraftforge.fml.common.versioning.ArtifactVersion;
import net.minecraftforge.fml.common.versioning.DefaultArtifactVersion;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.client.CustomModLoadingErrorDisplayException;
import net.minecraftforge.fml.client.GuiModsMissing;

@EventBusSubscriber
@Mod(modid = UpgradeRecipesMod.MODID, name = UpgradeRecipesMod.NAME, version = UpgradeRecipesMod.VERSION, acceptedMinecraftVersions = UpgradeRecipesMod.MCVERSION, dependencies = UpgradeRecipesMod.DEPENDENCIES)
public class UpgradeRecipesMod {
	
	public static final String MODID = "upgraderecipes";
	public static final String NAME = "Armor & Tool Upgrading";
	public static final String VERSION = "1.0";
	public static final String MCVERSION = "[1.10,1.10.2]";
	public static final String DEPENDENCIES = "after:avaritia;" +
											  "after:draconicevolution;" +
											  "after:weapons;" +
											  "after:rubymod;" +
											  "after:stars;" +
											  "after:trigems";
	
	@Instance
	public UpgradeRecipesMod instance;
	
	@SidedProxy(clientSide = "com.ToMe.upgraderecipes.UpgradeRecipesClientProxy", serverSide = "com.ToMe.upgraderecipes.UpgradeRecipesCommonProxy")
	public static UpgradeRecipesCommonProxy proxy;
	
	public static Config cfg;
	
	public static Logger log;
	
	//@SubscribeEvent
	//@EventHandler
	//public void construction(FMLStateEvent e) {
	//public static void construction(FMLStateEvent e) {
		//System.out.println("Test");
		//if(!Loader.isModLoaded("trigems") && !Loader.isModLoaded("rubymod")) {
			//System.out.println("Test");
			//HashSet<ArtifactVersion> set = new HashSet<ArtifactVersion>();
			//set.add(new DefaultArtifactVersion("trigems/rubymod", true));
			//throw new MissingModsException(set, MODID, NAME);
		//}
	//}
	
	//@SubscribeEvent
	//@EventHandler
	//public void onLoad(FMLLoadEvent e) {
	//public static void onLoad(FMLLoadEvent e) {
	//public void onLoad(FMLLoadCompleteEvent e) {
	//public staticvoid onLoad(FMLLoadCompleteEvent e) {
	//public void onLoad(FMLConstructionEvent e) {
	//public static void onLoad(FMLConstructionEvent e) {
		//System.out.println("Test");
		//if(!Loader.isModLoaded("trigems") && !Loader.isModLoaded("rubymod")) {
			//System.out.println("Test");
			//HashSet<ArtifactVersion> set = new HashSet<ArtifactVersion>();
			//set.add(new DefaultArtifactVersion("trigems/rubymod", true));
			//throw new MissingModsException(set, MODID, NAME);
		//}
	//}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
		//throw new CustomModLoadingErrorDisplayException();
		//if(!Loader.isModLoaded("trigems") && !Loader.isModLoaded("rubymod")) {
			//System.out.println("Test");
			//throw new MissingModsException(new HashSet<ArtifactVersion>().add(new DefaultArtifactVersion("trigems/rubymod", true)), MODID, NAME);
			//HashSet<ArtifactVersion> set = new HashSet<ArtifactVersion>();
			//set.add(new DefaultArtifactVersion("trigems/rubymod", true));
			//throw new MissingModsException(set, MODID, NAME);
			//throw new ModsMissingException();
			//proxy.throwModsMissingException();
			//proxy.throwModsMissingException("Missed", "trigems");
		//}
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent e) {
		//proxy.throwModsMissingException("Missed", "trigems");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		RecipeRemove.removeRecipes();
		RecipeAdd.addRecipes();
	}
	
	//@SubscribeEvent
	//public static void onRecipeRegistered(RegistryEvent.Register<IRecipe> e) {
		
	//}
	
}