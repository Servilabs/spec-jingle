package com.specjingle;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

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
			name = "Values upon which notification must be triggered",
			description = "List of special attack values for which jingle must play"
	)
	default String thresholdList()
	{
		return "30,50,75";
	}


}