package me.FluffyWolfers.Jet;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class JetCraft extends JavaPlugin{

	public static JetCraft j;
	public static PluginDescriptionFile pdf;
	
	public static ItemStack is1;
	public static ItemStack is2;
	public static ItemStack is3;
	public static ItemStack is4;
	
	public static ArrayList<Player> flying = new ArrayList<Player>();
	
	public BukkitTask particles;
	public BukkitTask fuelcheck;
	
	public static HashMap<Player, Long> time = new HashMap<Player, Long>();

	public void onEnable(){
		
		j = this;
		pdf = this.getDescription();
		
		Bukkit.getLogger().info("[JetCraft v" + pdf.getVersion() + "] Starting up...");
		
		this.getServer().getPluginManager().registerEvents(new JetListener(), this);
		
		this.craft();
		
		particles = new JetParticles().runTaskTimer(this, 0, 5);
		fuelcheck = new JetFuelCheck().runTaskTimer(this, 0, 1);
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		
	}
	
	public void craft(){
		
		ArrayList<String> list = new ArrayList<String>();
		list.add(ChatColor.DARK_RED + "0 / 100");
		
		is1 = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		ItemMeta im1 = is1.getItemMeta();
		im1.setDisplayName(ChatColor.DARK_PURPLE + "Jet Pack");
		im1.setLore(list);
		is1.setItemMeta(im1);
		
		is2 = new ItemStack(Material.IRON_CHESTPLATE, 1);
		ItemMeta im2 = is2.getItemMeta();
		im2.setDisplayName(ChatColor.DARK_PURPLE + "Jet Pack");
		im2.setLore(list);
		is2.setItemMeta(im2);
		
		is3 = new ItemStack(Material.GOLD_CHESTPLATE, 1);
		ItemMeta im3 = is3.getItemMeta();
		im3.setDisplayName(ChatColor.DARK_PURPLE + "Jet Pack");
		im3.setLore(list);
		is3.setItemMeta(im3);
		
		is4 = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
		ItemMeta im4 = is4.getItemMeta();
		im4.setDisplayName(ChatColor.DARK_PURPLE + "Jet Pack");
		im4.setLore(list);
		is4.setItemMeta(im4);
		
		ShapedRecipe r1 = new ShapedRecipe(is1);
		r1.shape(
			"ABA",
			"AAA",
			"AAA"
		);
		r1.setIngredient('A', Material.LEATHER);
		r1.setIngredient('B', Material.REDSTONE);
		getServer().addRecipe(r1);
		
		ShapedRecipe r2 = new ShapedRecipe(is2);
		r2.shape(
			"ABA",
			"AAA",
			"AAA"
		);
		r2.setIngredient('A', Material.IRON_INGOT);
		r2.setIngredient('B', Material.REDSTONE);
		getServer().addRecipe(r2);
		
		ShapedRecipe r3 = new ShapedRecipe(is3);
		r3.shape(
			"ABA",
			"AAA",
			"AAA"
		);
		r3.setIngredient('A', Material.GOLD_INGOT);
		r3.setIngredient('B', Material.REDSTONE);
		getServer().addRecipe(r3);
		
		ShapedRecipe r4 = new ShapedRecipe(is4);
		r4.shape(
			"ABA",
			"AAA",
			"AAA"
		);
		r4.setIngredient('A', Material.DIAMOND);
		r4.setIngredient('B', Material.REDSTONE);
		getServer().addRecipe(r4);
		
	}

}