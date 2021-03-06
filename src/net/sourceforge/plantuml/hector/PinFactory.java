/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2017, Arnaud Roques
 *
 * Project Info:  http://plantuml.com
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 *
 * Original Author:  Arnaud Roques
 * 
 *
 */
package net.sourceforge.plantuml.hector;

import java.util.HashMap;
import java.util.Map;

import net.sourceforge.plantuml.cucadiagram.Link;

public class PinFactory {

	private final Map<Object, Pin> pins = new HashMap<Object, Pin>();

	Pin create(Object userData) {
		return create(Integer.MAX_VALUE, userData);
	}

	public Pin create(int row, Object userData) {
		if (userData == null) {
			return new Pin(row, userData);
		}
		Pin result = pins.get(userData);
		if (result == null) {
			result = new Pin(row, userData);
			pins.put(userData, result);
		}
		return result;
	}

	public PinLink createPinLink(Link link) {
		final PinLink result = new PinLink(create(link.getEntity1()), create(link.getEntity2()), link.getLength(), link);
		return result;
	}

}
