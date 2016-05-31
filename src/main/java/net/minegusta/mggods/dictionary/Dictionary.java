package net.minegusta.mggods.dictionary;

import net.minegusta.mggods.gods.God;
import net.minegusta.mggods.main.GodsPlugin;
import net.minegusta.mggods.playerdata.MGPlayer;
import net.minegusta.mggods.util.RandomUtil;

public class Dictionary {

	public static String getMessageForGod(God god, MGPlayer mgp)
	{
		if(GodsPlugin.getLeadingGod() == god)
		{
			String[] messages = god.getGod().getPositiveSpeech();
			return messages[RandomUtil.randomNumberZeroIncludedMaxExcluded(messages.length)];
		}
		else {
			if (mgp.getPowerEarned() > 0) {
				String[] messages = god.getGod().getPlayerPositiveSpeech();
				return messages[RandomUtil.randomNumberZeroIncludedMaxExcluded(messages.length)];
			} else
			{
				String[] messages = god.getGod().getNegativeSpeech();
				return messages[RandomUtil.randomNumberZeroIncludedMaxExcluded(messages.length)];
			}

		}
	}
}
