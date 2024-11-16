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


}