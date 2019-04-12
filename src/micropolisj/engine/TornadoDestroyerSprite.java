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
public class TornadoDestroyerSprite extends HeroSprite
{
	public TornadoDestroyerSprite(Micropolis engine, int xpos, int ypos)
	{
		super(engine, xpos, ypos, SpriteKind.TORNADO_DESTROYER);
	}

	@Override
	protected int getDisasterX() {
		if (city.hasSprite(SpriteKind.TOR)) return city.getSprite(SpriteKind.TOR).x;
		else return -1;
	}
	
	@Override
	protected int getDisasterY() {
		if (city.hasSprite(SpriteKind.TOR)) return city.getSprite(SpriteKind.TOR).y;
		else return -1;
	}
	
	@Override
	protected void handleDisaster() {
		MonsterSprite tornado = (MonsterSprite) city.getSprite(SpriteKind.TOR);
		if (tornado != null) {
			tornado.frame = 0;
			tornado.count = 0;
		}
		return;
	}
}
