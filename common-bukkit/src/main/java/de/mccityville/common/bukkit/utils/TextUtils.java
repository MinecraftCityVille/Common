package de.mccityville.common.bukkit.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.ChatColor;

import com.google.common.collect.ImmutableMap;

public final class TextUtils {
	
	public static final char HUMAN_INDICATOR = '&';
	
	private static final ImmutableMap<String, String> REPLACEMENTS;
	private static final Pattern PARSE_PATTERN;
	
	static {
		ImmutableMap.Builder<String, String> b = ImmutableMap.builder();
		
		b.put("<black>", ChatColor.BLACK.toString());
		b.put("<navy>", ChatColor.DARK_BLUE.toString());
		b.put("<darkgreen>", ChatColor.DARK_GREEN.toString());
		b.put("<darkaqua>", ChatColor.DARK_AQUA.toString());
		b.put("<darkred>", ChatColor.DARK_RED.toString());
		b.put("<purple>", ChatColor.DARK_PURPLE.toString());
		b.put("<gold>", ChatColor.GOLD.toString());
		b.put("<gray>", ChatColor.GRAY.toString());
		b.put("<darkgray>", ChatColor.DARK_GRAY.toString());
		b.put("<blue>", ChatColor.BLUE.toString());
		b.put("<green>", ChatColor.GREEN.toString());
		b.put("<cyan>", ChatColor.AQUA.toString());
		b.put("<red>", ChatColor.RED.toString());
		b.put("<pink>", ChatColor.LIGHT_PURPLE.toString());
		b.put("<yellow>", ChatColor.YELLOW.toString());
		b.put("<white>", ChatColor.WHITE.toString());
		b.put("<random>", ChatColor.MAGIC.toString());
		b.put("<bold>", ChatColor.BOLD.toString());
		b.put("<strikethrough>", ChatColor.STRIKETHROUGH.toString());
		b.put("<underlined>", ChatColor.UNDERLINE.toString());
		b.put("<reset>", ChatColor.RESET.toString());
		
		for (ChatColor color : ChatColor.values())
			b.put(String.valueOf(HUMAN_INDICATOR) + color.getChar(), color.toString());
		
		REPLACEMENTS = b.build();
		
		StringBuilder patternBuilder = new StringBuilder();
		for (String key : REPLACEMENTS.keySet()) {
			if (patternBuilder.length() > 0)
				patternBuilder.append("|");
			
			patternBuilder.append(Pattern.quote(key));
		}
		patternBuilder.insert(0, "(");
		patternBuilder.append(")");
		PARSE_PATTERN = Pattern.compile(patternBuilder.toString());
	}
	
	public static String format(String str) {
		StringBuffer sb = new StringBuffer();
		Matcher matcher = PARSE_PATTERN.matcher(str);
		
		while (matcher.find())
			matcher.appendReplacement(sb, REPLACEMENTS.get(matcher.group(0)));
		
		matcher.appendTail(sb);
		
		return sb.toString();
	}
	
	public static String format(String pattern, Object... objects) {
		String str = String.format(pattern, objects);
		
		return format(str);
	}
	
	private TextUtils() { }
}
