// This file is part of MicropolisJ.
// Copyright (C) 2013 Jason Long
// Portions Copyright (C) 1989-2007 Electronic Arts Inc.
//
// MicropolisJ is free software; you can redistribute it and/or modify
// it under the terms of the GNU GPLv3, with additional terms.
// See the README file, included in this distribution, for details.

package micropolisj.engine;

import static micropolisj.engine.TileConstants.*;

class BuildingTool extends ToolStroke
{
	public BuildingTool(Micropolis engine, MicropolisTool tool, int xpos, int ypos)
	{
		super(engine, tool, xpos, ypos);
	}

	@Override
	public void dragTo(int xdest, int ydest)
	{
		this.xpos = xdest;
		this.ypos = ydest;
		this.xdest = xdest;
		this.ydest = ydest;
	}

	@Override
	boolean apply1(ToolEffectIfc eff)
	{
		switch (tool)
		{
		case FIRE:
			return applyZone(eff, FIRESTATION);

		case POLICE:
			return applyZone(eff, POLICESTATION);

		case POWERPLANT:
			return applyZone(eff, POWERPLANT);

		case STADIUM:
			return applyZone(eff, STADIUM);

		case SEAPORT:
			return applyZone(eff, PORT);

		case NUCLEAR:
			return applyZone(eff, NUCLEAR);

		case AIRPORT:
			return applyZone(eff, AIRPORT);
			
		case MONSTER_HUNTER:
			if (city.hasSprite(SpriteKind.MONSTER_HUNTER)) return false;
			city.makeMonsterHunter(xpos, ypos);
			doze(eff);
			city.spend(tool.getToolCost());
			return true;
			
		case FIRE_FIGHTER:
			if (city.hasSprite(SpriteKind.FIRE_FIGHTER)) return false;
			city.makeFireFighter(xpos, ypos);
			doze(eff);
			city.spend(tool.getToolCost());
			return true;
			
		case FLOOD_STOPPER:
			if (city.hasSprite(SpriteKind.FLOOD_STOPPER)) return false;
			city.makeFloodStopper(xpos, ypos);
			doze(eff);
			city.spend(tool.getToolCost());
			return true;
			
		case TORNADO_DESTROYER:
			if (city.hasSprite(SpriteKind.TORNADO_DESTROYER)) return false;
			city.makeTornadoDestroyer(xpos, ypos);
			doze(eff);
			city.spend(tool.getToolCost());
			return true;
			
		case EARTHQUAKE_CONTROLLER:
			if (city.hasSprite(SpriteKind.EARTHQUAKE_CONTROLLER)) return false;
			city.makeEarthquakeController(xpos, ypos);
			doze(eff);
			city.spend(tool.getToolCost());
			return true;
			
		case MELTDOWN_HANDLER:
			if (city.hasSprite(SpriteKind.MELTDOWN_HANDLER)) return false;
			city.makeMeltdownHandler(xpos, ypos);
			doze(eff);
			city.spend(tool.getToolCost());
			return true;

		default:
			// not expected
			throw new Error("unexpected tool: "+tool);
		}
	}
	
	// Bulldoze this building right away
	void doze(ToolEffectIfc eff) {
		Bulldozer dozer = new Bulldozer(city, 0,0);
		dozer.dozeField(eff);
	}
}
