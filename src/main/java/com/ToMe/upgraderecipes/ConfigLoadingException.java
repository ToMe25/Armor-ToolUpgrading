package com.ToMe.upgraderecipes;

import java.util.ArrayList;

//import java.awt.Color;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiErrorScreen;
import net.minecraftforge.fml.client.CustomModLoadingErrorDisplayException;

public class ConfigLoadingException extends CustomModLoadingErrorDisplayException {
	
	private String msg;
	
	public ConfigLoadingException(String Message) {
		// TODO Auto-generated constructor stub
		//super();
		msg = Message;
	}
	
	@Override
	public void initGui(GuiErrorScreen errorScreen, FontRenderer fontRenderer) {
		// TODO Auto-generated method stub
		//errorScreen.drawDefaultBackground();
		//errorScreen.drawString(fontRenderer, msg, errorScreen.height / 2, errorScreen.height / 2, 16777215);
		//errorScreen.drawCenteredString(fontRenderer, msg, errorScreen.width / 2, errorScreen.height / 2, 16777215);
	}
	
	@Override
	public void drawScreen(GuiErrorScreen errorScreen, FontRenderer fontRenderer, int mouseRelX, int mouseRelY, float tickTime) {
		// TODO Auto-generated method stub
		errorScreen.drawDefaultBackground();
		//errorScreen.drawString(fontRenderer, msg, errorScreen.height / 2, errorScreen.height / 2, 16777215);
		//errorScreen.drawCenteredString(fontRenderer, msg, errorScreen.width / 2, errorScreen.height / 2, 16777215);
		ArrayList<String> lines = new ArrayList<String>();
		for(String s:msg.split("\n")) {
			while(s.length() > 0) {
				lines.add(fontRenderer.trimStringToWidth(s, errorScreen.width));
				s = s.substring(fontRenderer.trimStringToWidth(s, errorScreen.width).length());
			}
			//lines.add(fontRenderer.trimStringToWidth(s, errorScreen.width));
			//if(!fontRenderer.trimStringToWidth(s, errorScreen.width).equals(s)) {
				
			//}
		}
		int i = 0;
		for(String s:lines) {
			errorScreen.drawCenteredString(fontRenderer, s, errorScreen.width / 2, (errorScreen.height - (msg.split("\n").length * 5)) / 2 + i * 10, 16777215);
			i++;
		}
		//int i = 0;
		//for(String str:msg.split("\n")) {
			//errorScreen.drawCenteredString(fontRenderer, str, errorScreen.width / 2, errorScreen.height / 2, 16777215);
			//errorScreen.drawCenteredString(fontRenderer, str, (errorScreen.width - (msg.split("\n").length * 10)) / 2, errorScreen.height / 2, 16777215);
			//errorScreen.drawCenteredString(fontRenderer, str, errorScreen.width / 2, (errorScreen.height - (msg.split("\n").length * 5)) / 2 + i * 10, 16777215);
			//errorScreen.drawCenteredString(fontRenderer, fontRenderer.trimStringToWidth(str, errorScreen.width), errorScreen.width / 2, (errorScreen.height - (msg.split("\n").length * 5)) / 2 + i * 10, 16777215);
			//i++;
		//}
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		//return super.getMessage();
		return msg;
	}
	
}