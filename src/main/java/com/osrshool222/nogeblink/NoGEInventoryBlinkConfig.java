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

	@ConfigItem(
		keyName = "hideGlow",
		name = "Hide GE glow",
		description = "Hides the pulsing yellow glow/border around the inventory grid in the GE window"
	)
	default boolean hideGlow()
	{
		return true;
	}

	@ConfigItem(
		keyName = "fixInventoryOpacity",
		name = "Fix inventory opacity",
		description = "Keeps the main inventory item layer fully opaque while the GE window is open"
	)
	default boolean fixInventoryOpacity()
	{
		return true;
	}
}