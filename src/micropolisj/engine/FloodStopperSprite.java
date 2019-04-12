// This file is part of MicropolisJ.
// Copyright (C) 2013 Jason Long
// Portions Copyright (C) 1989-2007 Electronic Arts Inc.
//
// MicropolisJ is free software; you can redistribute it and/or modify
// it under the terms of the GNU GPLv3, with additional terms.
// See the README file, included in this distribution, for details.

package micropolisj.engine;

/**
 * Implements a monster hunter sprite.
 */
public class FloodStopperSprite extends HeroSprite
{
	public FloodStopperSprite(Micropolis engine, int xpos, int ypos)
	{
		super(engine, xpos, ypos, SpriteKind.FLOOD_STOPPER);
	}

	@Override
	protected int getDisasterX() {
		if (city.hasSprite(SpriteKind.GOD)) return city.getSprite(SpriteKind.GOD).x;
		else return -1;
	}
	
	@Override
	protected int getDisasterY() {
		if (city.hasSprite(SpriteKind.GOD)) return city.getSprite(SpriteKind.GOD).y;
		else return -1;
	}
	
	@Override
	protected void handleDisaster() {
		MonsterSprite monster = (MonsterSprite) city.getSprite(SpriteKind.GOD);
		if (monster != null) {
			monster.frame = 0;
			monster.count = 0;
		}
		return;
	}
}
