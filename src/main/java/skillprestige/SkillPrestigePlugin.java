/*
 * Copyright (c) 2018, Joshua Filby <joshua@filby.me>
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package skillprestige;

import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.PluginChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;

@PluginDescriptor(
	name = "Skill Prestige",
	description = "Resets skill level based on past 99 xp.",
	tags = {"skill", "total", "max"},
	enabledByDefault = false
)
public class SkillPrestigePlugin extends Plugin
{

	@Inject
	private SkillPrestigeConfig config;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Provides
	SkillPrestigeConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SkillPrestigeConfig.class);
	}

	@Override
	protected void shutDown()
	{
		clientThread.invoke(this::simulateSkillChange);
	}

	@Subscribe
	public void onPluginChanged(PluginChanged pluginChanged)
	{
		// this is guaranteed to be called after the plugin has been registered by the eventbus. startUp is not.
		if (pluginChanged.getPlugin() == this)
		{
			clientThread.invoke(this::simulateSkillChange);
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (!configChanged.getGroup().equals("SkillPrestige"))
		{
			return;
		}

		clientThread.invoke(this::simulateSkillChange);
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent e) {
		final String eventName = e.getEventName();

		final int[] intStack = client.getIntStack();
		final int intStackSize = client.getIntStackSize();
		final String[] stringStack = client.getStringStack();
		final int stringStackSize = client.getStringStackSize();

		switch (eventName) {
			case "skillTabBaseLevel":
				final int skillId = intStack[intStackSize - 2];
				final Skill skill = Skill.values()[skillId];
				final int exp = (client.getSkillExperience(skill));

				if (client.getSkillExperience(skill) > (13034431 * 15)) {
				// Prestige 15
				intStack[intStackSize - 1] = Experience.getLevelForXp(exp - (13034431*15));
				} else if (client.getSkillExperience(skill) > (13034431 * 14)) {
				// Prestige 14
				intStack[intStackSize - 1] = Experience.getLevelForXp(exp - (13034431*14));
				} else if (client.getSkillExperience(skill) > (13034431 * 13)) {
				// Prestige 13
				intStack[intStackSize - 1] = Experience.getLevelForXp(exp - (13034431*13));
				} else if (client.getSkillExperience(skill) > (13034431 * 12)) {
				// Prestige 12
				intStack[intStackSize - 1] = Experience.getLevelForXp(exp - (13034431*12));
				} else if (client.getSkillExperience(skill) > (13034431 * 11)) {
				// Prestige 11
				intStack[intStackSize - 1] = Experience.getLevelForXp(exp - (13034431*11));
				} else if (client.getSkillExperience(skill) > (13034431 * 10)) {
				// Prestige 10
				intStack[intStackSize - 1] = Experience.getLevelForXp(exp - (13034431*10));
				} else if (client.getSkillExperience(skill) > (13034431 * 9)) {
				// Prestige 9
				intStack[intStackSize - 1] = Experience.getLevelForXp(exp - (13034431*9));
				} else if (client.getSkillExperience(skill) > (13034431 * 8)) {
				// Prestige 8
				intStack[intStackSize - 1] = Experience.getLevelForXp(exp - (13034431*8));
			 	} else if (client.getSkillExperience(skill) > (13034431 * 7)) {
				// Prestige 7
				intStack[intStackSize - 1] = Experience.getLevelForXp(exp - (13034431*7));
				} else if (client.getSkillExperience(skill) > (13034431 * 6)) {
				// Prestige 6
				intStack[intStackSize - 1] = Experience.getLevelForXp(exp - (13034431*6));
				} else if (client.getSkillExperience(skill) > (13034431 * 5)) {
				// Prestige 5
				intStack[intStackSize - 1] = Experience.getLevelForXp(exp - (13034431*5));
				} else if (client.getSkillExperience(skill) > (13034431 * 4)) {
				// Prestige 4
				intStack[intStackSize - 1] = Experience.getLevelForXp(exp - (13034431*4));
				} else if (client.getSkillExperience(skill) > (13034431 * 3)) {
				// Prestige 3
				intStack[intStackSize - 1] = Experience.getLevelForXp(exp - (13034431*3));
				} else if (client.getSkillExperience(skill) > (13034431 * 2)) {
				// Prestige 2
				intStack[intStackSize - 1] = Experience.getLevelForXp(exp - (13034431*2));
				} else {
				// Prestige 1
				intStack[intStackSize - 1] = Experience.getLevelForXp(exp - 13034431);
				}
				break;
		}

	}
	private void simulateSkillChange()
	{
		// this fires widgets listening for all skill changes
		for (Skill skill : Skill.values())
		{
			if (skill != Skill.OVERALL)
			{
				client.queueChangedSkill(skill);
			}
		}
	}
}
