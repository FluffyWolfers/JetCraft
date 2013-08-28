package me.FluffyWolfers.Jet;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class JetParticles extends BukkitRunnable{

	@SuppressWarnings("deprecation")
	public void run(){
		
		/*if(!JetCraft.flying.isEmpty()){
			
			for(int i = 0; i < JetCraft.flying.size(); i++){
				
				Player p = JetCraft.flying.get(0);
				ItemStack chest = p.getInventory().getChestplate();
				ItemMeta meta = chest.getItemMeta();
				List<String> lore = meta.getLore();
				
				String per = ChatColor.stripColor(lore.get(0)).split("/")[0].substring(0, ChatColor.stripColor(lore.get(0)).split("/")[0].length() - 1);
				
				
				
			}
			
		}*/
		
		if(!JetCraft.flying.isEmpty()){
			
			for(int i = 0; i < JetCraft.flying.size(); i++){
				
				Player p = JetCraft.flying.get(0);
				
				//if(!p.getGameMode().equals(GameMode.CREATIVE)){
					
					if(p.isFlying() && !p.isOnGround()){

						Location loc = p.getLocation();
						loc.setY(loc.getY() + 0.5);
						
						loc.getWorld().playEffect(loc, Effect.MOBSPAWNER_FLAMES, 1);
						
					}
					
				//}
				
			}
			
		}
		
	}
	
}