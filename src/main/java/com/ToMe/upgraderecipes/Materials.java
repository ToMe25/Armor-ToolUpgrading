package com.ToMe.upgraderecipes;

public enum Materials {
	
	WOOD {
		
		@Override
		public String[] getTypes() {
			return new String[] {"pickaxe", "axe", "shovel", "hoe", "sword", "bow"};
		}
		
	},
	LEATHER {
		
		@Override
		public String[] getTypes() {
			return new String[] {"helmet", "chestplate", "leggings", "boots"};
		}
		
	},
	STONE {
		
		@Override
		public String[] getTypes() {
			return new String[] {"pickaxe", "axe", "shovel", "hoe", "sword"};
		}
		
	},
	CHAIN {
		
		@Override
		public String[] getTypes() {
			return new String[] {"helmet", "chestplate", "leggings", "boots"};
		}
		
	},
	LAPIS {
		
		@Override
		public String getMod() {
			//return "mekanismtools";
			return "MekanismTools";
		}
		
	},
	OSMIUM {
		
		@Override
		public String getMod() {
			//return "mekanismtools";
			return "MekanismTools";
		}
		
	},
	IRON,
	BRONZE {
		
		@Override
		public String getMod() {
			//return "mekanismtools";
			return "MekanismTools";
		}
		
	},
	GOLD,
	GLOWSTONE {
		
		@Override
		public String getMod() {
			//return "mekanismtools";
			return "MekanismTools";
		}
		
	},
	STEEL {
		
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
	DIAMOND,
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
		
		/*@Override
		public void removeRecipes() {
			for(String type:getTypes()) {
				if(UpgradeRecipesMod.cfg.isToolEnabled(getName(), type, getMod())) {
					RecipeRemove.removeToolOrArmorFusionRecipe(getName(), type);
				}
			}
		}*/
		
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
	}
	
}