package com.osrshool222.nogeblink;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("nogeblink")
public interface NoGEInventoryBlinkConfig extends Config
{
	@ConfigItem(
		keyName = "disableBlink",
		name = "Disable blink in GE",
		description = "Prevents the inventory from blinking/flashing while the Grand Exchange window is open"
	)
	default boolean disableBlink()
	{
		return true;
	}
}