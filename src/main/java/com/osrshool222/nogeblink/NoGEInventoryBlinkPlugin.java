package com.osrshool222.nogeblink;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.api.events.ClientTick;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "No GE Inventory Blink",
	description = "Stops the inventory from blinking/flashing while the Grand Exchange window is open",
	tags = {"ge", "grand exchange", "blink", "flash", "inventory", "visual"},
	enabledByDefault = true
)
public class NoGEInventoryBlinkPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private NoGEInventoryBlinkConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.debug("NoGEInventoryBlink started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		restoreState();
		log.debug("NoGEInventoryBlink stopped!");
	}

	@Subscribe
	public void onClientTick(ClientTick event)
	{
		if (!config.disableBlink())
		{
			return;
		}

		// Only while the Grand Exchange window is open
		Widget ge = client.getWidget(InterfaceID.GeOffers.UNIVERSE);
		if (ge == null || ge.isHidden())
		{
			return;
		}

		if (config.hideGlow())
		{
			// The pulsing yellow glow around the inventory grid in the GE window
			// (GeOffersSide.GLOW) is animated by the vanilla scripts and makes
			// the inventory look like it is blinking. Hiding it stops the blink.
			Widget glow = client.getWidget(InterfaceID.GeOffersSide.GLOW);
			if (glow != null && !glow.isSelfHidden())
			{
				glow.setHidden(true);
				glow.setOpacity(255);
			}
		}

		if (config.fixInventoryOpacity())
		{
			// Safety net: keep the main inventory item layer fully opaque.
			Widget inventory = client.getWidget(InterfaceID.Inventory.ITEMS);
			if (inventory != null && inventory.getOpacity() != 0)
			{
				inventory.setOpacity(0);
			}
		}
	}

	private void restoreState()
	{
		Widget glow = client.getWidget(InterfaceID.GeOffersSide.GLOW);
		if (glow != null)
		{
			glow.setHidden(false);
			glow.setOpacity(0);
		}

		Widget inventory = client.getWidget(InterfaceID.Inventory.ITEMS);
		if (inventory != null)
		{
			inventory.setOpacity(0);
		}
	}

	@Provides
	NoGEInventoryBlinkConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(NoGEInventoryBlinkConfig.class);
	}
}