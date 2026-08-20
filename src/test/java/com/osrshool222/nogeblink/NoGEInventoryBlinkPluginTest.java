package com.osrshool222.nogeblink;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class NoGEInventoryBlinkPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(NoGEInventoryBlinkPlugin.class);
		RuneLite.main(args);
	}
}