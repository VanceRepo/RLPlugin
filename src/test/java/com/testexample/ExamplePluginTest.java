package com.testexample;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;
import skillprestige.SkillPrestigePlugin;

public class ExamplePluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(SkillPrestigePlugin.class);
		RuneLite.main(args);
	}
}