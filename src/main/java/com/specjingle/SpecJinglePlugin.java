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
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

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

	@Override
	protected void startUp() throws Exception
	{
		specialAttack = 0;
		client.playSoundEffect(3924,50);
	}


	@Override
	protected void shutDown() throws Exception
	{
		client.playSoundEffect(3924,50);
		specialAttack = 0;
	}


	public void onVarbitChanged(VarbitChanged varbitChanged) {


		if (varbitChanged.getVarpId() != VarPlayer.SPECIAL_ATTACK_PERCENT) {
			return;
		}

		// the previous code checks we are working with a special attack change

		int newSpecialAttack = varbitChanged.getValue();


		int[] percentValues = {100, 95, 90, 85, 80, 75, 70, 65, 60, 55, 50, 45, 40, 35, 30, 25, 20, 15, 10, 5};
		boolean playCheck = false;

		for (int percent : percentValues) {
			if (newSpecialAttack >= percent && specialAttack < percent) {
				playCheck = true;
				break;
			}
		}

		specialAttack = newSpecialAttack;

		if (playCheck || true) {
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
