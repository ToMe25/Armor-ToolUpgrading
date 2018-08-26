package com.ToMe.upgraderecipes;

/*import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiErrorScreen;
import net.minecraftforge.fml.client.CustomModLoadingErrorDisplayException;
import net.minecraftforge.fml.common.MissingModsException;
import net.minecraftforge.fml.common.versioning.ArtifactVersion;
import net.minecraftforge.fml.common.versioning.DefaultArtifactVersion;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)*/
public class ModsMissingException /*extends *//*CustomModLoadingErrorDisplayException*//*MissingModsException*/ {

	/*//private String cause = "";
	private String[] mods = {""};
	
	//CustomModLoadingErrorDisplayException
	//public ModsMissingException() {
		// TODO Auto-generated constructor stub
	//}
	
	//CustomModLoadingErrorDisplayException
	//public ModsMissingException(String cause, String... mods) {
		// TODO Auto-generated constructor stub
		//this.mods = mods;
		//this.cause = cause;
	//}
	
	//MissingModsException
	//public ModsMissingException(String id, String name, String... missingMods) {
		//this(setFromArray(missingMods), id, name);
	//}
	
	//MissingModsException
	public ModsMissingException(Set<ArtifactVersion> missingMods, String id, String name) {
		super(missingMods, id, name);
		// TODO Auto-generated constructor stub
	}
	
	private static Set<ArtifactVersion> setFromArray(String[] missingMods) {
		Set<ArtifactVersion> ret = new HashSet<ArtifactVersion>();
		for(String s:missingMods) {
			DefaultArtifactVersion mod = new DefaultArtifactVersion(s, true);
			ret.add(mod);
		}
		return ret;
	}
	
	//@Override
	public void initGui(GuiErrorScreen errorScreen, FontRenderer fontRenderer) {
		// TODO Auto-generated method stub
		//System.out.println("Init Gui!");
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		String ret = "";
		//ret += cause;
		for(String s:mods) {
			ret += s;
		}
		return ret;
		//return super.getMessage();
		//return cause;
	}
	
	//@Override
	public void drawScreen(GuiErrorScreen errorScreen, FontRenderer fontRenderer, int mouseRelX, int mouseRelY, float tickTime) {
		// TODO Auto-generated method stub
		//System.out.println("Draw Screen!");
		//int y = errorScreen.height / 2 - mods.length * 5;
		//for (String msg : mods) {
			//errorScreen.drawCenteredString(fontRenderer, msg, errorScreen.width / 2, y, 0xFFFFFF);
			//y += 10;
		//}
		//errorScreen.drawDefaultBackground();
		//ArrayList<String> al = new ArrayList<String>();
		//for (String s : this.mods) {
			//if (s != null) {
				//al.addAll(fontRenderer.listFormattedStringToWidth(s, errorScreen.width));
			//}
		//}
		//int offset = Math.max(85 - al.size() * 10, 10);
		//errorScreen.drawCenteredString(fontRenderer, cause, errorScreen.width / 2, offset, 16777215);
		//offset += 10;
		//for (String s : al) {
			//errorScreen.drawCenteredString(fontRenderer, s, errorScreen.width / 2, offset, 16777215);
			//offset += 10;
		//}
	}
	
	//@Override
	//public void printStackTrace() {
		// TODO Auto-generated method stub
		//System.out.println("null");
		//super.printStackTrace();
	//}
	
	//@Override
	//public void printStackTrace(PrintStream s) {
		// TODO Auto-generated method stub
		//System.out.println("PrintStream");
		//super.printStackTrace(s);
	//}
	
	//@Override
	//public void printStackTrace(PrintWriter s) {
		// TODO Auto-generated method stub
		//System.out.println("PrintWriter");
		//super.printStackTrace(s);
	//}
	
	//@Override
	//public void printStackTrace(WrappedPrintStream s) {
		// TODO Auto-generated method stub
		//System.out.println("WrappedPrintStream");
		//super.printStackTrace(s);
	//}*/
	
}