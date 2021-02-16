package com.ToMe.upgraderecipes;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.Proxy;
import java.util.UUID;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;

import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.profiler.Profiler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.server.management.PlayerProfileCache;
import net.minecraft.util.DamageSource;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.SaveHandlerMP;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.IFMLSidedHandler;

/**
 * 
 * @author ToMe25
 * 
 * a Fake Player for Armor Protection Testing
 */
//public class DamageTestFakePlayer extends FakePlayer {
public class DamageTestFakePlayer extends EntityPlayer {
	
	private static DamageTestFakePlayer INSTANCE;
	private static final UUID uuid = UUID.fromString("30303030-c6fa-4983-9c19-544d32355552");//30303030 = 0000, 544d32355443 = TM25UR, everything else is random.
	private static final ItemStack weapon = new ItemStack(Items.DIAMOND_SWORD, 1, 0);
	private static boolean damaged = false;
	//private static WorldThread thread;
	
	public DamageTestFakePlayer(String name) {
		//this(DummyWorldServer.INSTANCE, name);
		//this(getWorldServer(), name);
		this(getWorld(), name);
	}
	
	//public DamageTestFakePlayer(WorldServer world, String name) {
	public DamageTestFakePlayer(World world, String name) {
		this(world, new GameProfile(uuid, name));
	}
	
	//public DamageTestFakePlayer(WorldServer world, GameProfile name) {
	public DamageTestFakePlayer(World world, GameProfile name) {
		super(world, name);
		//NBTTagCompound weaponTag = new NBTTagCompound();
		//weaponTag.setBoolean("Unbreakable", true);
		//NBTTagList attributeModifiers = new NBTTagList();
		//weaponTag.setTag("AttributeModifiers", attributeModifiers);
		//NBTTagCompound attackDamage = new NBTTagCompound();
		//attributeModifiers.set(0, attackDamage);
		//attackDamage.setString("Slot", "mainhand");
		//attackDamage.setString("AttributeName", "generic.attackDamage");
		//attackDamage.setString("Name", "generic.attackDamage");
		//attackDamage.setInteger("Amount", 992);
		//attackDamage.setInteger("Operation", 0);
		//weapon.setTagCompound(weaponTag);
		//weapon.addAttributeModifier("generic.attackDamage", new AttributeModifier("generic.attackDamage", 992, 0), EntityEquipmentSlot.MAINHAND);
		//weapon.addAttributeModifier("generic.attackDamage", new AttributeModifier("generic.attackDamage", 92, 0), EntityEquipmentSlot.MAINHAND);
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, weapon);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1024D);
	}

	@Override
	public boolean isSpectator() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCreative() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private static World getWorld() {
		return new DummyWorld();
		//return (thread = new WorldThread(new DummyWorld())).world;
	}
	
	public double getDamage(ItemArmor helmet, ItemArmor chestplate, ItemArmor leggings, ItemArmor boots) {
		//return getDamage(new ItemStack(helmet), new ItemStack(chestplate), new ItemStack(leggings), new ItemStack(boots));
		return getDamage(Config.getStackWithEnergy(helmet), Config.getStackWithEnergy(chestplate), Config.getStackWithEnergy(leggings), Config.getStackWithEnergy(boots));
	}
	
	public double getDamage(ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots) {
		setHealth(1024);
		setItemStackToSlot(EntityEquipmentSlot.HEAD, helmet);
		setItemStackToSlot(EntityEquipmentSlot.CHEST, chestplate);
		setItemStackToSlot(EntityEquipmentSlot.LEGS, leggings);
		setItemStackToSlot(EntityEquipmentSlot.FEET, boots);
		setHealth(getMaxHealth());
		float startHealth = getHealth();
		//int i = 0;
		//while(i < 10) {
			//worldObj.updateEntities();
			//i++;
		//}
		//while(!damaged) {
			
		//}
		//damaged = false;
		//attackTargetEntityWithCurrentItem(this);
		//weapon.hitEntity(this, this);
		//damageEntity(DamageSource.causePlayerDamage(this), 1000);
		//damageEntity(DamageSource.causePlayerDamage(this), 100);
		float finishHealth = getHealth();
		float damage = startHealth - finishHealth;
		//System.out.println("Damage Dealt: " + damage);
		System.out.println("Damage dealt to " + chestplate.getDisplayName() + ": " + damage);
		return damage;
	}
	
	private static class DummyWorld extends World {
		
		private int ticks = 0;

		protected DummyWorld() {
			//super(new SaveHandlerMP(), new WorldInfo(new WorldSettings(0, GameType.NOT_SET, false, false, WorldType.FLAT), "[DAMAGE-TEST-WORLD]"), null, null, false);
			//super(new SaveHandlerMP(), new WorldInfo(new WorldSettings(0, GameType.NOT_SET, false, false, WorldType.FLAT), "[DAMAGE-TEST-WORLD]"), DimensionManager.createProviderFor(0), null, false);
			this(DimensionManager.createProviderFor(0));
		}
		
		protected DummyWorld(WorldProvider provider) {
			//super(new SaveHandlerMP(), new WorldInfo(new WorldSettings(0, GameType.NOT_SET, false, false, WorldType.FLAT), "[DAMAGE-TEST-WORLD]"), provider, null, false);
			super(new SaveHandlerMP(), new WorldInfo(new WorldSettings(0, GameType.NOT_SET, false, false, WorldType.FLAT), "[DAMAGE-TEST-WORLD]"), provider, new Profiler(), false);
			provider.registerWorld(this);
			chunkProvider = createChunkProvider();
		}

		@Override
		protected IChunkProvider createChunkProvider() {
			//return null;
	        return new ChunkProviderClient(this);
		}

		@Override
		protected boolean isChunkLoaded(int x, int z, boolean allowEmpty) {
			return false;
		}
		
		@Override
		//public void tickPlayers() {
		//public void tick() {
		public void updateEntities() {
			//super.tickPlayers();
			//super.tick();
			super.updateEntities();
			ticks++;
			if(ticks >= 10) {
				INSTANCE.damageEntity(DamageSource.causePlayerDamage(INSTANCE), 100);
				ticks = 0;
				damaged = true;
			}
		}
		
	}
	
	/*private static class WorldThread extends Thread {
		
		private World world;
		
		private WorldThread(DummyWorld world) {
			super("[" + UpgradeRecipesMod.MODID + "] Damage Test World Thread");
			this.world = world;
			start();
		}
		
		public void run() {
			while(true) {
				if(!world.loadedEntityList.contains(INSTANCE)) {
					world.loadedEntityList.add(INSTANCE);
				}
				world.updateEntities();
			}
		}
		
	}*/
	
	/*private static WorldServer getWorldServer() {
		return new DummyWorldServer();
	}
	
	private static MinecraftServer getDummyServer() {
		DummyServer server = new DummyServer();
		try {
			Field sidedDelegateField = FMLCommonHandler.class.getDeclaredField("sidedDelegate");
			sidedDelegateField.setAccessible(true);
			IFMLSidedHandler sidedDelegate = (IFMLSidedHandler) sidedDelegateField.get(FMLCommonHandler.instance());
			sidedDelegate.beginServerLoading(server);
			sidedDelegate.finishServerLoading();
			System.out.println(sidedDelegate.getServer());
		} catch (Exception e) {
			UpgradeRecipesMod.log.catching(e);
		}
		//return new DummyServer();
		return server;
	}
	
	private static class DummyWorldServer extends WorldServer {
		
		//private static final DummyWorldServer INSTANCE = new DummyWorldServer();

		public DummyWorldServer() {
			//super(null, null, null, 0, null);
			//super(getDummyServer(), null, null, 0, null);
			//super(getDummyServer(), null, new WorldInfo(new WorldSettings(0, GameType.NOT_SET, false, false, WorldType.FLAT), "[DAMAGE-TEST-WORLD]"), 0, null);
			super(getDummyServer(), new SaveHandlerMP(), new WorldInfo(new WorldSettings(0, GameType.NOT_SET, false, false, WorldType.FLAT), "[DAMAGE-TEST-WORLD]"), 0, null);
		}
		
	}
	
	private static class DummyServer extends MinecraftServer {
	//private static class DummyServer extends DedicatedServer {

		public DummyServer() {
			//super(null, null, null, null, null, null, null);
			super(new File("damageTest/"), null, null, null, null, null, null);
			//super(new File(""), null, null, null, null, null);
			setPlayerList(new DummyPlayerList(this));
		}

		@Override
		public boolean startServer() throws IOException {
			return false;
		}

		@Override
		public boolean canStructuresSpawn() {
			return false;
		}

		@Override
		public GameType getGameType() {
			return null;
		}

		@Override
		public EnumDifficulty getDifficulty() {
			return null;
		}

		@Override
		public boolean isHardcore() {
			return false;
		}

		@Override
		public int getOpPermissionLevel() {
			return 0;
		}

		@Override
		public boolean shouldBroadcastRconToOps() {
			return false;
		}

		@Override
		public boolean shouldBroadcastConsoleToOps() {
			return false;
		}

		@Override
		public boolean isDedicatedServer() {
			return false;
		}

		@Override
		public boolean shouldUseNativeTransport() {
			return false;
		}

		@Override
		public boolean isCommandBlockEnabled() {
			return false;
		}

		@Override
		public String shareToLAN(GameType type, boolean allowCheats) {
			return null;
		}
		
		*//*@Override
		public PlayerList getPlayerList() {
			return new DummyPlayerList(this);
		}*//*
		
	}
	
	*//**
	 * 
	 * @author ToMe25
	 * 
	 * This class is needed(its not really needed) because there is only one server side only and one client side only PlayerList class.
	 *//*
	private static class DummyPlayerList extends PlayerList {

		public DummyPlayerList(MinecraftServer server) {
			super(server);
		}
		
	}*/
	
}