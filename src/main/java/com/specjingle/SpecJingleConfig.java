package com.specjingle;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("specjingle")
public interface SpecJingleConfig extends Config
{
	@Range(min = 1, max = 100)
	@ConfigItem(
			keyName = "volume",
			name = "Volume",
			description = "Jingle volume",
			position = 1
	)
	default int volume() {
		return 100;
	}

	@ConfigItem(
			position = 2,
			keyName = "thresholdList",
			name = "Threshold Values",
			description = "List of special attack values for which jingle must play"
	)
	default String thresholdList()
	{
		return "30:9,50";
	}

	@ConfigItem(
			position = 3,
			keyName = "ethresholdList",
			name = "Exact Equalilty Threshold Values",
			description = "List of special attack values for which jingle must play only upon exact value (100:0 makes 100 silent)"
	)
	default String ethresholdList()
	{
		return "75:4,100:0";
	}

	@ConfigSection(
			name = "Instructions",
			description = "Instructions for adding thresholds",
			position = 4,
			closedByDefault = true
	)
	String instructionsSection = "instructions";

	@ConfigItem(
			position = 5,
			keyName = "thresholdInstructions",
			name = "Entry list formatting:",
			description = "Formatting for correct threshold value lists",
			section = instructionsSection
	)
	default String thresholdInstructions() {
		return "### Valid Style Format:\n\n" +
				"Valuees must be added in a comma separated list. \n" +
				"Entries must be of form spec_value:sound_value.\n" +
				"Spec_value must be between 0 and 100 inclusive. \n"+
				"Sound id must be value between 1 and 9 inclusive. \n"+
				"Entries that only contain spec_value will default the sound id to 1.\n\n"+
				"Consider the list 10:1,20:2,50:1\n\n"+
				"This will play sound one when spec value of 10 is reached, sound 2 when spec value of 20 is reached, and sound 1 when spec value of 50 is reached.\n"+
				"Sound id Names with corresponding effect values: \n"+
				"1 is ge_collect_coins=3924\n"+
				"2 is high_alchemy=97\n"+
				"3 is altar_crystal_chime_=4046\n"+
				"4 is sote_bell_high_c=4152\n"+
				"5 is enchant_sapphire_ring=147\n"+
				"6 is teleportblock_cast=202\n"+
				"7 is teleportblock_impact=203\n"+
				"8 is poh_teleport=984\n"+
				"9 is charge_earth_orb=115\n";

	}

}