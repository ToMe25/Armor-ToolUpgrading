package com.ToMe.upgraderecipes;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.GuiCustomModLoadingErrorScreen;
import net.minecraftforge.fml.client.SplashProgress;
import net.minecraftforge.fml.common.MissingModsException;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.versioning.ArtifactVersion;
import net.minecraftforge.fml.common.versioning.DefaultArtifactVersion;

public class UpgradeRecipesClientProxy extends UpgradeRecipesCommonProxy {
	
	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		// TODO Auto-generated method stub
		super.preInit(e);
		//throwModsMissingException("Test", "trigems");
	}
	
	//@Override
	//public void throwModsMissingException() {
		// TODO Auto-generated method stub
		//throw new ModsMissingException();
	//}
	
	/**
	 * on Server side: Throws a new MissingModsException.
	 * on Client side: gives a new MissingModsException to the FMLClientHandler.
	 * @param cause
	 * @param mods
	 */
	@Override
	//public void throwModsMissingException(String cause, String... mods) {
	public void throwModsMissingException(String cause, String[]... mods) {
		// TODO Auto-generated method stub
		//throw new ModsMissingException(cause, mods);
		try {
			//Field f = FMLClientHandler.class.getField("customError");
			//Field f = FMLClientHandler.class.getDeclaredField("customError");
			Field f = FMLClientHandler.class.getDeclaredField("modsMissing");
			f.setAccessible(true);
			//f.set(FMLClientHandler.instance(), new ModsMissingException(cause, mods));
			//f.set(FMLClientHandler.instance(), new ModsMissingException(UpgradeRecipesMod.MODID, UpgradeRecipesMod.NAME, mods));
			f.set(FMLClientHandler.instance(), new MissingModsException(setFromArray(mods), UpgradeRecipesMod.MODID, UpgradeRecipesMod.NAME));
			//f.set(FMLClientHandler.instance(), new ModsMissingException(setFromArray(mods), UpgradeRecipesMod.MODID, UpgradeRecipesMod.NAME));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			UpgradeRecipesMod.log.catching(e);
		}
		//FMLClientHandler.instance().customError = new ModsMissingException(cause, mods);
		//FMLClientHandler.instance().getClient().displayGuiScreen(new GuiModsMissing(new ModsMissingException(cause, mods)));	
		//SplashProgress.finish();
		//FMLClientHandler.instance().showGuiScreen(new GuiModsMissing(new ModsMissingException(cause, mods)));	
		//SplashProgress.finish();
	}
	
	/**
	 * on Server side: Throws a new ConfigLoadingException.
	 * on Client side: gives a new ConfigLoadingException to the FMLClientHandler.
	 * @param cause
	 * @param mods
	 */
	@Override
	public void throwConfigException(String cause) {
		// TODO Auto-generated method stub
		//throw new ConfigLoadingException(cause);
		try {
			Field f = FMLClientHandler.class.getDeclaredField("customError");
			f.setAccessible(true);
			f.set(FMLClientHandler.instance(), new ConfigLoadingException(cause));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			UpgradeRecipesMod.log.catching(e);
		}
	}
	
	/**
	 * Used if this mod needs only MODA or MODB.
	 * Creates a HashSet of DefaultArtifactVersions filled with MODA / MODB... for every String Array.
	 * @param missingMods the String Arrays to use.
	 * @return
	 */
	public static Set<ArtifactVersion> setFromArray(String[]... missingMods) {
		Set<ArtifactVersion> ret = new HashSet<ArtifactVersion>();
		DefaultArtifactVersion help = new DefaultArtifactVersion("The \"/\"s tell you: You need only one of all mods in a single line, but you can use all.");
		ret.add(help);
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
		//DefaultArtifactVersion help = new DefaultArtifactVersion("The \"/\"s tell you", "You need only one of all mods in a single line, but you can use all.");
		//DefaultArtifactVersion help = new DefaultArtifactVersion("The \"/\"s tell you: You need only one of all mods in a single line, but you can use all.", "");
		//DefaultArtifactVersion help = new DefaultArtifactVersion("The \"/\"s tell you: You need only one of all mods in a single line, but you can use all.");
		//ret.add(help);
		return ret;
	}
	
}