package com.specjingle;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.VarPlayer;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

@Slf4j
@PluginDescriptor(
		name = "Spec Jingle"
)
public class SpecJinglePlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private SpecJingleConfig config;

	private int specialAttack = 100;
	private boolean unknownSpecial = true;

	public ArrayList<String> thresholdValues = new ArrayList<>();

	@Override
	protected void startUp() throws Exception
	{
		unknownSpecial = true;
		thresholdValues.clear();
		if (!config.thresholdList().equals(""))
		{
			String temp = config.thresholdList();
			for (String str : temp.split(","))
			{
				if (!str.trim().equals("")) { thresholdValues.add(str.trim());}
			}
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event) {
		if (!event.getGroup().equals("specjingle"))
		{
			return;
		}
		thresholdValues.clear();
		if (!config.thresholdList().equals(""))
		{
			String temp = config.thresholdList();
			for (String str : temp.split(","))
			{
				if (!str.trim().equals("")) { thresholdValues.add(str.trim());}
			}
		}
	}


	@Override
	protected void shutDown() throws Exception
	{
		thresholdValues.clear();
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged varbitChanged) {
		if( unknownSpecial == true){
			unknownSpecial = false;
			return;
		}

		if (varbitChanged.getVarpId() != VarPlayer.SPECIAL_ATTACK_PERCENT) {
			return;
		}

		// the previous code checks we are working with a special attack change

		int newSpecialAttack = varbitChanged.getValue();

		boolean playCheck = false;

		for (String entry : thresholdValues){
			int value = -1;
			if( StringUtils.isNumeric(entry)){
				value = Integer.parseInt(entry);
			}
			if( newSpecialAttack >= value*10 && specialAttack < value*10 ) playCheck = true;
		}
		specialAttack = newSpecialAttack;

		if (playCheck) {
			client.playSoundEffect(3924, this.config.volume());
		}

		specialAttack = newSpecialAttack;
	}



	@Provides
	SpecJingleConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SpecJingleConfig.class);
	}
}
