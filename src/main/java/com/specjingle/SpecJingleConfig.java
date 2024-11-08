package com.specjingle;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("example")
public interface SpecJingleConfig extends Config
{
	@Range(min = 1, max = 100)
	@ConfigItem(
			keyName = "volume",
			name = "Volume",
			description = "Jingle volume",
			position = -1
	)
	default int volume() {
		return 20;
	}

	@ConfigItem(
			keyName = "playJingleAtFivePercent",
			name = "Play at 5%",
			position = 0,
			description = "Should the sound effect play when your spec regens to 5%?"
	)
	default boolean playJingleAtFivePercent()
	{
		return false;
	}

	@ConfigItem(
			keyName = "playJingleAtTenPercent",
			name = "Play at 10%",
			position = 1,
			description = "Should the sound effect play when your spec regens to 10%?"
	)
	default boolean playJingleAtTenPercent()
	{
		return false;
	}

	@ConfigItem(
			keyName = "playJingleAtFifteenPercent",
			name = "Play at 15%",
			position = 2,
			description = "Should the sound effect play when your spec regens to 15%?"
	)
	default boolean playJingleAtFifteenPercent()
	{
		return false;
	}

	@ConfigItem(
			keyName = "playJingleAtTwentyPercent",
			name = "Play at 20%",
			position = 3,
			description = "Should the sound effect play when your spec regens to 20%?"
	)
	default boolean playJingleAtTwentyPercent()
	{
		return false;
	}

	@ConfigItem(
			keyName = "playJingleAtTwentyFivePercent",
			name = "Play at 25%",
			position = 4,
			description = "Should the sound effect play when your spec regens to 25%?"
	)
	default boolean playJingleAtTwentyFivePercent()
	{
		return false;
	}

	@ConfigItem(
			keyName = "playJingleAtThirtyPercent",
			name = "Play at 30%",
			position = 5,
			description = "Should the sound effect play when your spec regens to 30%?"
	)
	default boolean playJingleAtThirtyPercent()
	{
		return false;
	}

	@ConfigItem(
			keyName = "playJingleAtThirtyFivePercent",
			name = "Play at 35%",
			position = 6,
			description = "Should the sound effect play when your spec regens to 35%?"
	)
	default boolean playJingleAtThirtyFivePercent()
	{
		return false;
	}

	@ConfigItem(
			keyName = "playJingleAtFortyPercent",
			name = "Play at 40%",
			position = 7,
			description = "Should the sound effect play when your spec regens to 40%?"
	)
	default boolean playJingleAtFortyPercent()
	{
		return false;
	}

	@ConfigItem(
			keyName = "playJingleAtFortyFivePercent",
			name = "Play at 45%",
			position = 8,
			description = "Should the sound effect play when your spec regens to 45%?"
	)
	default boolean playJingleAtFortyFivePercent()
	{
		return false;
	}

	@ConfigItem(
			keyName = "playJingle50",
			name = "Play at 50%",
			position = 9,
			description = "Should the sound effect play when your spec regens to 50%?"
	)
	default boolean playJingle50()
	{
		return false;
	}

	@ConfigItem(
			keyName = "playJingleAtFiftyFivePercent",
			name = "Play at 55%",
			position = 10,
			description = "Should the sound effect play when your spec regens to 55%?"
	)
	default boolean playJingle55()
	{
		return false;
	}

	@ConfigItem(
			keyName = "playJingle60",
			name = "Play at 60%",
			position = 11,
			description = "Should the sound effect play when your spec regens to 60%?"
	)
	default boolean playJingle60()
	{
		return false;
	}

	@ConfigItem(
			keyName = "playJingle65",
			name = "Play at 65%",
			position = 12,
			description = "Should the sound effect play when your spec regens to 65%?"
	)
	default boolean playJingle65()
	{
		return false;
	}

	@ConfigItem(
			keyName = "playJingle70",
			name = "Play at 70%",
			position = 13,
			description = "Should the sound effect play when your spec regens to 70%?"
	)
	default boolean playJingle70()
	{
		return false;
	}

	@ConfigItem(
			keyName = "playJingle75",
			name = "Play at 75%",
			position = 14,
			description = "Should the sound effect play when your spec regens to 75%?"
	)
	default boolean playJingle75()
	{
		return false;
	}

	@ConfigItem(
			keyName = "playJingle80",
			name = "Play at 80%",
			position = 15,
			description = "Should the sound effect play when your spec regens to 80%?"
	)
	default boolean playJingle80()
	{
		return false;
	}

	@ConfigItem(
			keyName = "playJingle85",
			name = "Play at 85%",
			position = 16,
			description = "Should the sound effect play when your spec regens to 85%?"
	)
	default boolean playJingle85()
	{
		return false;
	}

	@ConfigItem(
			keyName = "playJingle90",
			name = "Play at 90%",
			position = 17,
			description = "Should the sound effect play when your spec regens to 90%?"
	)
	default boolean playJingle90()
	{
		return false;
	}

	@ConfigItem(
			keyName = "playJingle95",
			name = "Play at 95%",
			position = 18,
			description = "Should the sound effect play when your spec regens to 95%?"
	)
	default boolean playJingle95()
	{
		return false;
	}

	@ConfigItem(
			keyName = "playJingle100",
			name = "Play at 100%",
			position = 19,
			description = "Should the sound effect play when your spec regens to 100%?"
	)
	default boolean playJingle100()
	{
		return false;
	}
}