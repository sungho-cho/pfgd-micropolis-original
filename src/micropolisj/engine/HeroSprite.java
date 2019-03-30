// This file is part of MicropolisJ.
// Copyright (C) 2013 Jason Long
// Portions Copyright (C) 1989-2007 Electronic Arts Inc.
//
// MicropolisJ is free software; you can redistribute it and/or modify
// it under the terms of the GNU GPLv3, with additional terms.
// See the README file, included in this distribution, for details.

package micropolisj.engine;

import static micropolisj.engine.TileConstants.*;

/**
 * Implements a hero sprite.
 */
public class HeroSprite extends Sprite
{
	int destX;
	int destY;
	int step;

	//HERO FRAMES
	// 1 : north
	// 2 : east
	// 3 : south
	// 4 : west

	// movement deltas
	static int [] Gx = {  0, 2, 0, -2};
	static int [] Gy = { -2, 0, 2,  0};
	int [] cornerX = new int[4];
	int [] cornerY = new int[4];

	public HeroSprite(Micropolis engine, int xpos, int ypos)
	{
		super(engine, SpriteKind.HERO);
		this.x = xpos * 16 + 8;
		this.y = ypos * 16 + 8;
		this.width = 48;
		this.height = 48;
		
		int width = 20;
		int height = 20;

		cornerX[0] = (xpos -  width/2);
		cornerY[0] = (ypos - height/2);
		cornerX[1] = (xpos +  width/2);
		cornerY[1] = (ypos - height/2);
		cornerX[2] = (xpos +  width/2);
		cornerY[2] = (ypos + height/2);
		cornerX[3] = (xpos -  width/2);
		cornerY[3] = (ypos + height/2);
		
		this.step = 0;
		this.destX = cornerX[step] * 16 + 8;
		this.destY = cornerY[step] * 16 + 8;

		this.frame = 2;
	}

	@Override
	public void moveImpl()
	{
		if (this.frame == 0) {
			return;
		}
		
		if (getDis(x, y, destX, destY) < 1) {
			step = (step + 1) % 4;
			destX = cornerX[step] * 16 + 8;
			destY = cornerY[step] * 16 + 8;
		}
		
		int c = getDir(x, y, destX, destY);
		c = (c - 1) / 2 + 1;   //convert to one of four basic headings
		assert c >= 0 && c < 4;

		frame = c;
		assert this.frame >= 1 && this.frame <= 4;

		this.x += Gx[c-1];
		this.y += Gy[c-1];
	}
}
