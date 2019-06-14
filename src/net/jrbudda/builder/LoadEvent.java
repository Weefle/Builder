package net.jrbudda.builder;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.trait.TraitInfo;

public class LoadEvent implements Listener {
	
	@EventHandler
	public void onLoad(WorldInitEvent e) {
		
		CitizensAPI.getTraitFactory().registerTrait(TraitInfo.create(BuilderTrait.class).withName("builder"));
		Builder.instance.getServer().getPluginManager().registerEvents(new BuilderListener(Builder.instance), Builder.instance);
		
	}

}
