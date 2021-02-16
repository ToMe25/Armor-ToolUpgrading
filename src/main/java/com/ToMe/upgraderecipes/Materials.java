package com.ToMe.upgraderecipes;

public enum Materials {
	
	/**WOOD {//not WOODV because this is the Base Material
		
		@Override
		public String[] getTypes() {
			//return new String[] {"pickaxe", "axe", "shovel", "hoe", "sword", "bow"};
			return new String[] {"pickaxe", "axe", "shovel", "hoe", "rod", "sword", "bow", "shield"};
		}
		
	},
	WOODT {
		
		@Override
		public String getMod() {
			return "thermalfoundation";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"hammer", "excavator", "sickle", "shears"};
		}
		
	},
	WOODE {
		
		@Override
		public String getMod() {
			return "extrautils2";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"sickle"};
		}
		
	},
	LEATHER {
		
		@Override
		public String[] getTypes() {
			return new String[] {"helmet", "chestplate", "leggings", "boots"};
		}
		
	},
	STONE {//not STONEV because this is the Base Material
		
		@Override
		public String[] getTypes() {
			return new String[] {"pickaxe", "axe", "shovel", "hoe", "sword"};
		}
		
	},
	STONET {
		
		@Override
		public String getMod() {
			return "thermalfoundation";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"hammer", "excavator", "sickle", "shears", "rod", "bow", "shield"};
		}
		
	},
	STONEE {
		
		@Override
		public String getMod() {
			return "extrautils2";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"sickle"};
		}
		
	},
	CHAIN {
		
		@Override
		public String[] getTypes() {
			return new String[] {"helmet", "chestplate", "leggings", "boots"};
		}
		
	},
	COPPER {
		
		@Override
		public String getMod() {
			return "thermalfoundation";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"pickaxe", "hammer", "axe", "shovel", "excavator", "hoe", "sickle", "shears", "rod", "sword", "bow", "shield", "helmet", "chestplate", "leggings", "boots"};
		}
		
	},
	TIN {
		
		@Override
		public String getMod() {
			return "thermalfoundation";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"pickaxe", "hammer", "axe", "shovel", "excavator", "hoe", "sickle", "shears", "rod", "sword", "bow", "shield", "helmet", "chestplate", "leggings", "boots"};
		}
		
	},
	LEAD {
		
		@Override
		public String getMod() {
			return "thermalfoundation";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"pickaxe", "hammer", "axe", "shovel", "excavator", "hoe", "sickle", "shears", "rod", "sword", "bow", "shield", "helmet", "chestplate", "leggings", "boots"};
		}
		
	},
	//SILVER {
		
		//@Override
		//public String getMod() {
			//return "thermalfoundation";
		//}
		
	//},
	ALUMINUM {
		
		@Override
		public String getMod() {
			return "thermalfoundation";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"pickaxe", "hammer", "axe", "shovel", "excavator", "hoe", "sickle", "shears", "rod", "sword", "bow", "shield", "helmet", "chestplate", "leggings", "boots"};
		}
		
	},
	//IRON,
	IRON {//not IRONV because this is the Base Material
		
		@Override
		public String[] getTypes() {
			return new String[] {"pickaxe", "axe", "shovel", "hoe", "shears", "sword", "helmet", "chestplate", "leggings", "boots"};
		}
		
	},
	IRONT {
		
		@Override
		public String getMod() {
			return "thermalfoundation";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"hammer", "excavator", "sickle", "rod", "bow", "shield"};
		}
		
	},
	IRONE {
		
		@Override
		public String getMod() {
			return "extrautils2";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"sickle"};
		}
		
	},
	SILVER {
		
		@Override
		public String getMod() {
			return "thermalfoundation";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"pickaxe", "hammer", "axe", "shovel", "excavator", "hoe", "sickle", "shears", "rod", "sword", "bow", "shield", "helmet", "chestplate", "leggings", "boots"};
		}
		
	},
	LAPIS {
		
		@Override
		public String getMod() {
			//return "mekanismtools";
			return "MekanismTools";
		}
		
	},
	NICKEL {
		
		@Override
		public String getMod() {
			return "thermalfoundation";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"pickaxe", "hammer", "axe", "shovel", "excavator", "hoe", "sickle", "shears", "rod", "sword", "bow", "shield", "helmet", "chestplate", "leggings", "boots"};
		}
		
	},
	CONSTANTAN {
		
		@Override
		public String getMod() {
			return "thermalfoundation";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"pickaxe", "hammer", "axe", "shovel", "excavator", "hoe", "sickle", "shears", "rod", "sword", "bow", "shield", "helmet", "chestplate", "leggings", "boots"};
		}
		
	},
	OSMIUM {
		
		@Override
		public String getMod() {
			//return "mekanismtools";
			return "MekanismTools";
		}
		
	},
	//IRON,
	BRONZET {
		
		@Override
		public String getMod() {
			return "thermalfoundation";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"pickaxe", "hammer", "axe", "shovel", "excavator", "hoe", "sickle", "shears", "rod", "sword", "bow", "shield", "helmet", "chestplate", "leggings", "boots"};
		}
		
	},
	//BRONZE {
	BRONZEM {
		
		@Override
		public String getMod() {
			//return "mekanismtools";
			return "MekanismTools";
		}
		
	},
	GOLD,//not GOLDV because this is the Base Material
	GOLDT {
		
		@Override
		public String getMod() {
			return "thermalfoundation";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"hammer", "excavator", "sickle", "shears", "rod", "bow", "shield"};
		}
		
	},
	GOLDE {
		
		@Override
		public String getMod() {
			return "extrautils2";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"sickle"};
		}
		
	},
	ELECTRUM {
		
		@Override
		public String getMod() {
			return "thermalfoundation";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"pickaxe", "hammer", "axe", "shovel", "excavator", "hoe", "sickle", "shears", "rod", "sword", "bow", "shield", "helmet", "chestplate", "leggings", "boots"};
		}
		
	},
	INVAR {
		
		@Override
		public String getMod() {
			return "thermalfoundation";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"pickaxe", "hammer", "axe", "shovel", "excavator", "hoe", "sickle", "shears", "rod", "sword", "bow", "shield", "helmet", "chestplate", "leggings", "boots"};
		}
		
	},
	GLOWSTONE {
		
		@Override
		public String getMod() {
			//return "mekanismtools";
			return "MekanismTools";
		}
		
	},
	STEELT {
		
		@Override
		public String getMod() {
			return "thermalfoundation";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"pickaxe", "hammer", "axe", "shovel", "excavator", "hoe", "sickle", "shears", "rod", "sword", "bow", "shield", "helmet", "chestplate", "leggings", "boots"};
		}
		
	},
	//STEEL {
	STEELM {
		
		@Override
		public String getMod() {
			//return "mekanismtools";
			return "MekanismTools";
		}
		
	},
	TOPAZ {
		
		@Override
		public String getMod() {
			return "trigems";
		}
		
	},
	RUBYT {
		
		@Override
		public String getMod() {
			return "trigems";
		}
		
	},
	RUBYR {
		
		@Override
		public String getMod() {
			return "rubymod";
		}
		
	},
	DIAMOND,//not DIAMONDV because this is the Base Material
	DIAMONDT {
		
		@Override
		public String getMod() {
			return "thermalfoundation";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"hammer", "excavator", "sickle", "shears", "rod", "bow", "shield"};
		}
		
	},
	DIAMONDE {
		
		@Override
		public String getMod() {
			return "extrautils2";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"sickle"};
		}
		
	},
	SAPPHIRE {
		
		@Override
		public String getMod() {
			return "trigems";
		}
		
	},
	EMERALDT {
		
		@Override
		public String getMod() {
			return "trigems";
		}
		
	},
	EMERALDR {
		
		@Override
		public String getMod() {
			return "rubymod";
		}
		
	},
	PLATINUM {
		
		@Override
		public String getMod() {
			return "thermalfoundation";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"pickaxe", "hammer", "axe", "shovel", "excavator", "hoe", "sickle", "shears", "rod", "sword", "bow", "shield", "helmet", "chestplate", "leggings", "boots"};
		}
		
	},
	REDCRYSTAL {
		
		@Override
		public String getMod() {
			return "weapons";
		}
		
	},
	TRITANIUM {
		
		@Override
		public String getMod() {
			//return "mo";
			return "mo/matteroverdrive";
		}
		
		@Override
		public void addRecipes() {
			for(String type:getTypes()) {
				if(UpgradeRecipesMod.cfg.isToolEnabled(getName(), type, getMod())) {
					if(type.equalsIgnoreCase("pickaxe")) {
						RecipeAdd.addPickaxeRecipe(getName());
					}
					else if(type.equalsIgnoreCase("axe")) {
						RecipeAdd.addAxeRecipe(getName());
					}
					else if(type.equalsIgnoreCase("shovel")) {
						RecipeAdd.addShovelRecipe(getName());
					}
					else if(type.equalsIgnoreCase("hoe")) {
						RecipeAdd.addHoeRecipe(getName());
					}
					else if(type.equalsIgnoreCase("sword")) {
						RecipeAdd.addSwordRecipe(getName());
					}
					else if(type.equalsIgnoreCase("bow")) {
						RecipeAdd.addBowRecipe(getName());
					}
					else if(type.equalsIgnoreCase("helmet")) {
						RecipeAdd.addTritaniumHelmetRecipe();
					}
					else if(type.equalsIgnoreCase("chestplate")) {
						RecipeAdd.addTritaniumChestplateRecipe();
					}
					else if(type.equalsIgnoreCase("leggings")) {
						RecipeAdd.addTritaniumLeggingsRecipe();
					}
					else if(type.equalsIgnoreCase("boots")) {
						RecipeAdd.addBootsRecipe(getName());
					}
				}
			}
		}
		
		//@Override
		//public boolean isModLoaded() {
			//return UpgradeRecipesCommonProxy.isModLoaded("mo") || UpgradeRecipesCommonProxy.isModLoaded("matteroverdrive");
		//}
		
	},
	OBSIDIAN {
		
		@Override
		public String getMod() {
			//return "mekanismtools";
			return "MekanismTools";
		}
		
	},
	NETHERSTAR {
		
		@Override
		public String getMod() {
			return "stars";
		}
		
	},
	SKULLFIRE {
		
		@Override
		public String getMod() {
			return "avaritia";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"sword"};
		}
		
		@Override
		public void addRecipes() {
			for(String type:getTypes()) {
				if(UpgradeRecipesMod.cfg.isToolEnabled(getName(), type, getMod())) {
					if(type.equalsIgnoreCase("sword")) {
						DireRecipeHandler.createSkullfireSwordRecipe();
					}
				}
			}
		}
		
		@Override
		public void removeRecipes() {
			for(String type:getTypes()) {
				if(UpgradeRecipesMod.cfg.isToolEnabled(getName(), type, getMod())) {
					RecipeRemove.removeToolOrArmorDireRecipe(getName(), type);
				}
			}
		}
		
	},
	WYVERN {
		
		@Override
		public String getMod() {
			return "draconicevolution";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"pickaxe", "axe", "shovel", "hoe", "sword", "bow", "helmet", "chestplate", "leggings", "boots"};
		}
		
		@Override
		public void addRecipes() {
			for(String type:getTypes()) {
				//if(UpgradeRecipesMod.cfg.isToolEnabled(getName(), type, getMod())) {
					//if(type.equalsIgnoreCase("pickaxe") || type.equalsIgnoreCase("axe") || type.equalsIgnoreCase("shovel") || type.equalsIgnoreCase("hoe") || type.equalsIgnoreCase("sword") || type.equalsIgnoreCase("bow")) {
						//RecipeAdd.createWyvernToolRecipe(type);
					//}
					//else if(type.equalsIgnoreCase("helmet") || type.equalsIgnoreCase("chestplate") || type.equalsIgnoreCase("leggings") || type.equalsIgnoreCase("boots")) {
						//RecipeAdd.createWyvernArmorRecipe(type);
					//}
				//}
				if(Config.wyvern_fusion) {
					if(UpgradeRecipesMod.cfg.isToolEnabled(getName(), type, getMod())) {
						if(type.equalsIgnoreCase("pickaxe") || type.equalsIgnoreCase("axe") || type.equalsIgnoreCase("shovel") || type.equalsIgnoreCase("hoe") || type.equalsIgnoreCase("sword") || type.equalsIgnoreCase("bow")) {
							FusionRecipeHandler.createWyvernToolRecipe(type);
						}
						else if(type.equalsIgnoreCase("helmet") || type.equalsIgnoreCase("chestplate") || type.equalsIgnoreCase("leggings") || type.equalsIgnoreCase("boots")) {
							FusionRecipeHandler.createWyvernArmorRecipe(type);
						}
					}
				}
				else {
					if(UpgradeRecipesMod.cfg.isToolEnabled(getName(), type, getMod())) {
						if(type.equalsIgnoreCase("pickaxe") || type.equalsIgnoreCase("axe") || type.equalsIgnoreCase("shovel") || type.equalsIgnoreCase("hoe") || type.equalsIgnoreCase("sword") || type.equalsIgnoreCase("bow")) {
							RecipeAdd.createWyvernToolRecipe(type);
						}
						else if(type.equalsIgnoreCase("helmet") || type.equalsIgnoreCase("chestplate") || type.equalsIgnoreCase("leggings") || type.equalsIgnoreCase("boots")) {
							RecipeAdd.createWyvernArmorRecipe(type);
						}
					}
				}
			}
		}
		
		//@Override
		//public void removeRecipes() {
			//for(String type:getTypes()) {
				//if(UpgradeRecipesMod.cfg.isToolEnabled(getName(), type, getMod())) {
					//RecipeRemove.removeToolOrArmorFusionRecipe(getName(), type);
				//}
			//}
		//}
		
	},
	OPINIUMCORE {
		
		@Override
		public String getMod() {
			return "extrautils2";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"axe", "sword", "bow"};
		}
		
	},
	DRACONIC {
		
		@Override
		public String getMod() {
			return "draconicevolution";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"staff", "pickaxe", "axe", "shovel", "hoe", "sword", "bow", "helmet", "chestplate", "leggings", "boots"};
			//return new String[] {"pickaxe", "axe", "shovel", "hoe", "sword", "bow", "helmet", "chestplate", "leggings", "boots"};
		}
		
		@Override
		public void addRecipes() {
			for(String type:getTypes()) {
				if(UpgradeRecipesMod.cfg.isToolEnabled(getName(), type, getMod())) {
					if(type.equalsIgnoreCase("pickaxe") || type.equalsIgnoreCase("axe") || type.equalsIgnoreCase("shovel") || type.equalsIgnoreCase("hoe") || type.equalsIgnoreCase("sword") || type.equalsIgnoreCase("bow")) {
						FusionRecipeHandler.createDraconicToolRecipe(type);
					}
					else if(type.equalsIgnoreCase("helmet") || type.equalsIgnoreCase("chestplate") || type.equalsIgnoreCase("leggings") || type.equalsIgnoreCase("boots")) {
						FusionRecipeHandler.createDraconicArmorRecipe(type);
					}
					else if(type.equalsIgnoreCase("staff")) {
						FusionRecipeHandler.createDraconicStaffRecipe();
					}
				}
			}
		}
		
		@Override
		public void removeRecipes() {
			for(String type:getTypes()) {
				if(UpgradeRecipesMod.cfg.isToolEnabled(getName(), type, getMod())) {
					RecipeRemove.removeToolOrArmorFusionRecipe(getName(), type);
				}
			}
		}
		
	},
	INFINITY {
		
		@Override
		public String getMod() {
			return "avaritia";
		}
		
		@Override
		public String[] getTypes() {
			return new String[] {"pickaxe", "axe", "shovel", "hoe", "sword", "bow", "helmet", "chestplate", "leggings", "boots"};
		}
		
		@Override
		public void addRecipes() {
			for(String type:getTypes()) {
				if(UpgradeRecipesMod.cfg.isToolEnabled(getName(), type, getMod())) {
					if(type.equalsIgnoreCase("pickaxe")) {
						DireRecipeHandler.createInfinityPickaxeRecipe();
					}
					else if(type.equalsIgnoreCase("axe")) {
						DireRecipeHandler.createInfinityAxeRecipe();
					}
					else if(type.equalsIgnoreCase("shovel")) {
						DireRecipeHandler.createInfinityShovelRecipe();
					}
					else if(type.equalsIgnoreCase("hoe")) {
						DireRecipeHandler.createInfinityHoeRecipe();
					}
					else if(type.equalsIgnoreCase("sword")) {
						DireRecipeHandler.createInfinitySwordRecipe();
					}
					else if(type.equalsIgnoreCase("bow")) {
						DireRecipeHandler.createInfinityBowRecipe();
					}
					else if(type.equalsIgnoreCase("helmet")) {
						DireRecipeHandler.createInfinityHelmetRecipe();
					}
					else if(type.equalsIgnoreCase("chestplate")) {
						DireRecipeHandler.createInfinityChestplateRecipe();
					}
					else if(type.equalsIgnoreCase("leggings")) {
						DireRecipeHandler.createInfinityLeggingsRecipe();
					}
					else if(type.equalsIgnoreCase("boots")) {
						DireRecipeHandler.createInfinityBootsRecipe();
					}
				}
			}
		}
		
		@Override
		public void removeRecipes() {
			for(String type:getTypes()) {
				if(UpgradeRecipesMod.cfg.isToolEnabled(getName(), type, getMod())) {
					RecipeRemove.removeToolOrArmorDireRecipe(getName(), type);
				}
			}
		}
		
	};
	
	//private String name;
	private byte enabled;
	
	private Materials() {
		//name = this.name();
	}
	
	public String getName() {
		//return name;
		//return this.name();
		return this.name().toLowerCase();
	}
	
	public String getMod() {
		return "vanilla";
		//return "minecraft";
	}
	
	public boolean isEnabled() {
		if(enabled == 0) {
			if(UpgradeRecipesMod.cfg.isMaterialEnabled(getName(), getMod())) {
				enabled = 1;
			}
			else {
				enabled = -1;
			}
		}
		return enabled == 1;
	}
	
	//abstract public Object getItem();
	
	public String[] getTypes() {
		return new String[] {"pickaxe", "axe", "shovel", "hoe", "sword", "helmet", "chestplate", "leggings", "boots"};
	}
	
	public void addRecipes() {
		for(String type:getTypes()) {
			if(UpgradeRecipesMod.cfg.isToolEnabled(getName(), type, getMod())) {
				if(type.equalsIgnoreCase("pickaxe")) {
					RecipeAdd.addPickaxeRecipe(getName());
				}
				else if(type.equalsIgnoreCase("hammer")) {
					RecipeAdd.addHammerRecipe(getName());
				}
				else if(type.equalsIgnoreCase("axe")) {
					RecipeAdd.addAxeRecipe(getName());
				}
				else if(type.equalsIgnoreCase("shovel")) {
					RecipeAdd.addShovelRecipe(getName());
				}
				else if(type.equalsIgnoreCase("excavator")) {
					RecipeAdd.addExcavatorRecipe(getName());
				}
				else if(type.equalsIgnoreCase("hoe")) {
					RecipeAdd.addHoeRecipe(getName());
				}
				else if(type.equalsIgnoreCase("sickle")) {
					RecipeAdd.addSickleRecipe(getName());
				}
				else if(type.equalsIgnoreCase("shears")) {
					RecipeAdd.addShearsRecipe(getName());
				}
				else if(type.equalsIgnoreCase("rod")) {
					RecipeAdd.addRodRecipe(getName());
				}
				else if(type.equalsIgnoreCase("sword")) {
					RecipeAdd.addSwordRecipe(getName());
				}
				else if(type.equalsIgnoreCase("bow")) {
					RecipeAdd.addBowRecipe(getName());
				}
				else if(type.equalsIgnoreCase("shield")) {
					RecipeAdd.addShieldRecipe(getName());
				}
				else if(type.equalsIgnoreCase("helmet")) {
					RecipeAdd.addHelmetRecipe(getName());
				}
				else if(type.equalsIgnoreCase("chestplate")) {
					RecipeAdd.addChestplateRecipe(getName());
				}
				else if(type.equalsIgnoreCase("leggings")) {
					RecipeAdd.addLeggingsRecipe(getName());
				}
				else if(type.equalsIgnoreCase("boots")) {
					RecipeAdd.addBootsRecipe(getName());
				}
			}
		}
	}
	public void removeRecipes() {
		for(String type:getTypes()) {
			if(UpgradeRecipesMod.cfg.isToolEnabled(getName(), type, getMod())) {
				RecipeRemove.removeToolOrArmorRecipe(getName(), type);
			}
		}
	}
	
	//public boolean isGem() {
		//return false;
	//}
	
	public boolean isModLoaded() {
		return UpgradeRecipesCommonProxy.isModLoaded(getMod());
	}*/
	
}