// This file is part of MicropolisJ.
// Copyright (C) 2013 Jason Long
// Portions Copyright (C) 1989-2007 Electronic Arts Inc.
//
// MicropolisJ is free software; you can redistribute it and/or modify
// it under the terms of the GNU GPLv3, with additional terms.
// See the README file, included in this distribution, for details.

package micropolisj.engine;

/**
 * Enumeration of the various kinds of sprites that may appear in the city.
 */
public enum SpriteKind
{
	TRA(1,5),
	COP(2,8),
	AIR(3,11),
	SHI(4,8),
	GOD(5,16),
	TOR(6,3),
	EXP(7,6),
	BUS(8,4),
	MONSTER_HUNTER(9,4),
	FIRE_FIGHTER(10,4),
	FLOOD_STOPPER(11,4),
	TORNADO_DESTROYER(12,4),
	EARTHQUAKE_CONTROLLER(13,4),
	MELTDOWN_HANDLER(14,4);

	public final int objectId;
	public final int numFrames;

	private SpriteKind(int objectId, int numFrames)
	{
		this.objectId = objectId;
		this.numFrames = numFrames;
	}
}
