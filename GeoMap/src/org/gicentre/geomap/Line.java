package org.gicentre.geomap;

import processing.core.PApplet;
import processing.core.PVector;

//*****************************************************************************************
/** Class for representing and drawing a line feature.
 *  @author Jo Wood , giCentre, City University London.
 *  @version 1.0, 10th January, 2012
 */
// *****************************************************************************************

/* This file is part of giCentre's geoMap library. geoMap is free software: you can
 * redistribute it and/or modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * geoMap is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * source code (see COPYING.LESSER included with this source code). If not, see
 * http://www.gnu.org/licenses/.
 */

public class Line implements Feature
{
	private float[] x,y;			// Coordinates of the line.
    private PApplet parent;			// Parent sketch.

    /** Constructs a new line object with the given geometry.
     *  @param x x coordinates of the line.
     *  @param y y coordinates of the line.
     *  @param parent The parent sketch.
     */
    public Line(float[] x, float[] y, PApplet parent)
    {
    	this.x = x;
        this.y = y;
        this.parent = parent;
    }
    
    /** Reports the number of vertices that make up the line feature.
     *  @return number of vertices that make up the line.
     */
    public int getNumVertices()
    {
    	if (x != null)
    	{
    		return x.length;
    	}
    	return 0;
    }
    
    /** Report the type of feature (line).
	 *  @return Type of feature
	 */
	public FeatureType getType()
	{
		return FeatureType.LINE;
	}
	
	/** Reports the x coordinates coordinates of the line feature.
	 *  @return x coordinates of the line feature.
	 */
	public float[] getXCoords()
	{
		return x;
	}
	
	/** Reports the y coordinates coordinates of the line feature.
	 *  @return y coordinates of the line feature.
	 */
	public float[] getYCoords()
	{
		return y;
	}

    /** Draws the line in the parent sketch.
     *  @param transformer Class that handles the geographic to screen transformations.
     */
    public void draw(Geographic transformer)
    {
    	PVector p1 = transformer.geoToScreen(x[0], y[0]);
    	for (int i=0; i<x.length-1; i++)
    	{
    		PVector p2 = transformer.geoToScreen(x[i+1], y[i+1]);
    		parent.line(p1.x,p1.y,p2.x,p2.y);
    		p1 = p2;
    	}
    }   
    
    /** Tests whether the given point is located somewhere along the line feature. Coordinates 
     *  should be in the same geographic units as the feature.
     *  @param x x coordinate in geographic coordinates.
     *  @param y y coordinate in geographic coordinates.
     *  @return True if the given point is located along the line feature, false if not.
     */
    public boolean contains(float x, float y)
    {
    	// TODO Add testing code here.
    	return false;
    }
}
