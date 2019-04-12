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
public class EarthquakeControllerSprite extends HeroSprite implements EarthquakeListener
{
	public EarthquakeControllerSprite(Micropolis engine, int xpos, int ypos)
	{
		super(engine, xpos, ypos, SpriteKind.EARTHQUAKE_CONTROLLER);
	}

	@Override
	protected int getDisasterX() {
		return -1;
	}
	
	@Override
	protected int getDisasterY() {
		return -1;
	}
	
	@Override
	protected void handleDisaster() {
		return;
	}
	
	@Override
	public void earthquakeStarted() {
		city.earthquakeStopped = true;
	}
}
