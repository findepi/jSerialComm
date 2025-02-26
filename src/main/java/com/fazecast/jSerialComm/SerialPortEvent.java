/*
 * SerialPortEvent.java
 *
 *       Created on:  Feb 25, 2015
 *  Last Updated on:  Dec 17, 2021
 *           Author:  Will Hedgecock
 *
 * Copyright (C) 2012-2021 Fazecast, Inc.
 *
 * This file is part of jSerialComm.
 *
 * jSerialComm is free software: you can redistribute it and/or modify
 * it under the terms of either the Apache Software License, version 2, or
 * the GNU Lesser General Public License as published by the Free Software
 * Foundation, version 3 or above.
 *
 * jSerialComm is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * You should have received a copy of both the GNU Lesser General Public
 * License and the Apache Software License along with jSerialComm. If not,
 * see <http://www.gnu.org/licenses/> and <http://www.apache.org/licenses/>.
 */

package com.fazecast.jSerialComm;

import java.util.EventObject;

/**
 * This class describes an asynchronous serial port event.
 * 
 * @author Will Hedgecock &lt;will.hedgecock@fazecast.com&gt;
 * @version 2.8.0
 * @see java.util.EventObject
 */
public class SerialPortEvent extends EventObject
{
	private static final long serialVersionUID = 3060830619653354150L;
	private final int eventType;
	private final byte[] serialData;

	/**
	 * Constructs a {@link SerialPortEvent} object corresponding to the specified serial event type.
	 * <p>
	 * This constructor should only be used when the {@link SerialPortEvent} does not contain any data bytes.
	 * <p>
	 * Valid serial event types are:
	 * <p>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_DATA_AVAILABLE}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_DATA_RECEIVED}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_DATA_WRITTEN}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_BREAK_INTERRUPT}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_CARRIER_DETECT}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_CTS}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_DSR}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_RING_INDICATOR}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_FRAMING_ERROR}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_FIRMWARE_OVERRUN_ERROR}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_SOFTWARE_OVERRUN_ERROR}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_PARITY_ERROR}<br>
	 * <p>
	 * Note that event-based write callbacks are only supported on Windows operating systems. As such, the {@link SerialPort#LISTENING_EVENT_DATA_WRITTEN}
	 * event will never be called on a non-Windows system.
	 * 
	 * @param comPort The {@link SerialPort} about which this object is being created.
	 * @param serialEventType The type of serial port event that this object describes.
	 * @see SerialPort#LISTENING_EVENT_DATA_AVAILABLE
	 * @see SerialPort#LISTENING_EVENT_DATA_RECEIVED
	 * @see SerialPort#LISTENING_EVENT_DATA_WRITTEN
	 * @see SerialPort#LISTENING_EVENT_BREAK_INTERRUPT
	 * @see SerialPort#LISTENING_EVENT_CARRIER_DETECT
	 * @see SerialPort#LISTENING_EVENT_CTS
	 * @see SerialPort#LISTENING_EVENT_DSR
	 * @see SerialPort#LISTENING_EVENT_RING_INDICATOR
	 * @see SerialPort#LISTENING_EVENT_FRAMING_ERROR
	 * @see SerialPort#LISTENING_EVENT_FIRMWARE_OVERRUN_ERROR
	 * @see SerialPort#LISTENING_EVENT_SOFTWARE_OVERRUN_ERROR
	 * @see SerialPort#LISTENING_EVENT_PARITY_ERROR
	 */
	public SerialPortEvent(SerialPort comPort, int serialEventType)
	{
		super(comPort);
		eventType = serialEventType;
		serialData = null;
	}
	
	/**
	 * Constructs a {@link SerialPortEvent} object corresponding to the specified serial event type and containing the passed-in data bytes.
	 * <p>
	 * Valid serial event types are:
	 * <p>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_DATA_AVAILABLE}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_DATA_RECEIVED}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_DATA_WRITTEN}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_BREAK_INTERRUPT}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_CARRIER_DETECT}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_CTS}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_DSR}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_RING_INDICATOR}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_FRAMING_ERROR}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_FIRMWARE_OVERRUN_ERROR}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_SOFTWARE_OVERRUN_ERROR}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_PARITY_ERROR}<br>
	 * <p>
	 * Note that event-based write callbacks are only supported on Windows operating systems. As such, the {@link SerialPort#LISTENING_EVENT_DATA_WRITTEN}
	 * event will never be called on a non-Windows system.
	 * 
	 * @param comPort The {@link SerialPort} about which this object is being created.
	 * @param serialEventType The type of serial port event that this object describes.
	 * @param data The raw data bytes corresponding to this serial port event.
	 * @see SerialPort#LISTENING_EVENT_DATA_AVAILABLE
	 * @see SerialPort#LISTENING_EVENT_DATA_RECEIVED
	 * @see SerialPort#LISTENING_EVENT_DATA_WRITTEN
	 * @see SerialPort#LISTENING_EVENT_BREAK_INTERRUPT
	 * @see SerialPort#LISTENING_EVENT_CARRIER_DETECT
	 * @see SerialPort#LISTENING_EVENT_CTS
	 * @see SerialPort#LISTENING_EVENT_DSR
	 * @see SerialPort#LISTENING_EVENT_RING_INDICATOR
	 * @see SerialPort#LISTENING_EVENT_FRAMING_ERROR
	 * @see SerialPort#LISTENING_EVENT_FIRMWARE_OVERRUN_ERROR
	 * @see SerialPort#LISTENING_EVENT_SOFTWARE_OVERRUN_ERROR
	 * @see SerialPort#LISTENING_EVENT_PARITY_ERROR
	 */
	public SerialPortEvent(SerialPort comPort, int serialEventType, byte[] data)
	{
		super(comPort);
		eventType = serialEventType;
		serialData = data;
	}
	
	/**
	 * Returns the {@link SerialPort} that triggered this event.
	 * 
	 * @return The {@link SerialPort} that triggered this event.
	 */
	public final SerialPort getSerialPort() { return (SerialPort)source; }
	
	/**
	 * Returns the type of serial port events that caused this object to be created.
	 * <p>
	 * Return value will be a bitmask containing one or more of the following items OR'd together:
	 * <p>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_DATA_AVAILABLE}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_DATA_RECEIVED}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_DATA_WRITTEN}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_BREAK_INTERRUPT}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_CARRIER_DETECT}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_CTS}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_DSR}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_RING_INDICATOR}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_FRAMING_ERROR}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_FIRMWARE_OVERRUN_ERROR}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_SOFTWARE_OVERRUN_ERROR}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_PARITY_ERROR}<br>
	 * <p>
	 * Note that event-based write callbacks are only supported on Windows operating systems. As such, the {@link SerialPort#LISTENING_EVENT_DATA_WRITTEN}
	 * event will never be called on a non-Windows system.
	 * 
	 * @return The serial port event that this object describes.
	 * @see SerialPort#LISTENING_EVENT_DATA_AVAILABLE
	 * @see SerialPort#LISTENING_EVENT_DATA_RECEIVED
	 * @see SerialPort#LISTENING_EVENT_DATA_WRITTEN
	 * @see SerialPort#LISTENING_EVENT_BREAK_INTERRUPT
	 * @see SerialPort#LISTENING_EVENT_CARRIER_DETECT
	 * @see SerialPort#LISTENING_EVENT_CTS
	 * @see SerialPort#LISTENING_EVENT_DSR
	 * @see SerialPort#LISTENING_EVENT_RING_INDICATOR
	 * @see SerialPort#LISTENING_EVENT_FRAMING_ERROR
	 * @see SerialPort#LISTENING_EVENT_FIRMWARE_OVERRUN_ERROR
	 * @see SerialPort#LISTENING_EVENT_SOFTWARE_OVERRUN_ERROR
	 * @see SerialPort#LISTENING_EVENT_PARITY_ERROR
	 */
	public final int getEventType() { return eventType; }
	
	/**
	 * Returns any raw data bytes associated with this serial port event.
	 * 
	 * @return Any data bytes associated with this serial port event or null if none exist.
	 */
	public final byte[] getReceivedData() { return serialData; }
}
