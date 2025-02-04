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
			name = "Thresholds",
			description = "List of special attack values for which jingle must play"
	)
	default String thresholdList()
	{
		return "30:9,50";
	}

	@ConfigItem(
			position = 3,
			keyName = "ethresholdList",
			name = "Exact Thresholds",
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
				"Values must be added in a comma separated list. \n" +
				"Entries must be of form spec_value:sound_value.\n" +
				"Spec_value must be between 0 and 100 inclusive. \n"+
				"Sound id should be value between 1 and 9 inclusive. \n"+
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
				"9 is charge_earth_orb=115\n"+
				"Specific sound I'ds can also be used if user knows them.";

	}

	@ConfigSection(
			name = "Additional preset options",
			description = "Additional preset options",
			position = 6,
			closedByDefault = true
	)
	String additionalPresetoptions = "Additional preset options";

	@Range(min = 1, max = 100)
	@ConfigItem(
			keyName = "selectedPreset",
			name = "Selected preset",
			description = "Jingle volume",
			position = 7,
			section = additionalPresetoptions
	)
	default int selectedPreset() {
		return 1;
	}

	@ConfigItem(
			position = 8,
			keyName = "thresholdList2 ",
			name = "Thresholds for preset 2",
			description = "List of special attack values for which jingle must play on preset 2",
			section = additionalPresetoptions
	)
	default String thresholdList2()
	{
		return "30:9,50";
	}

	@ConfigItem(
			position = 9,
			keyName = "ethresholdList2",
			name = "Exact Thresholds for preset 2",
			description = "List of special attack values for which jingle must play only upon exact value on second preset",
			section = additionalPresetoptions
	)
	default String ethresholdList2()
	{
		return "75:4,100:0";
	}

	@ConfigItem(
			position = 10,
			keyName = "thresholdList3 ",
			name = "Thresholdsfor preset 3",
			description = "List of special attack values for which jingle must play on preset 3",
			section = additionalPresetoptions
	)
	default String thresholdList3()
	{
		return "30:9,50";
	}

	@ConfigItem(
			position = 11,
			keyName = "ethresholdList3",
			name = "Exact Thresholds for preset 3",
			description = "List of special attack values for which jingle must play only upon exact value for preset 3",
			section = additionalPresetoptions
	)
	default String ethresholdList3()
	{
		return "75:4,100:0";
	}

}