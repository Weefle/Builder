package net.jrbudda.builder;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.trait.TraitInfo;

public class TraitListener implements Listener {
	
	@EventHandler
	public void onLoad(ServerLoadEvent e) {

		CitizensAPI.getTraitFactory().registerTrait(TraitInfo.create(BuilderTrait.class).withName("builder"));
	Builder.instance.getServer().getPluginManager().registerEvents(new BuilderListener(Builder.instance), Builder.instance);

	}

}
