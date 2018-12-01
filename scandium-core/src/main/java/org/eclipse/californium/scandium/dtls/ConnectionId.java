/*******************************************************************************
 * Copyright (c) 2018 Bosch Software Innovations GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 *
 * The Eclipse Public License is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 *    http://www.eclipse.org/org/documents/edl-v10.html.
 *
 * Contributors:
 *    Bosch Software Innovations GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.californium.scandium.dtls;

import java.util.Arrays;

import org.eclipse.californium.elements.util.StringUtil;

/**
 * Implementation of DTLS connection id.
 * 
 * <a href="https://datatracker.ietf.org/doc/draft-ietf-tls-dtls-connection-id">draft-ietf-tls-dtls-connection-id</a>
 */
public class ConnectionId {

	/**
	 * Empty connection id.
	 */
	public static final ConnectionId EMPTY = new ConnectionId(new byte[0]);

	/**
	 * Connection id.
	 */
	private final byte[] connectionId;
	/**
	 * Pre-calculated hash.
	 * 
	 * @see #hashCode()
	 */
	private final int hash;


	/**
	 * Create connection id from bytes.
	 * 
	 * @param connectionId connectionId bytes
	 * @throws NullPointerException if connectionId is {@code null}
	 * @throws IllegalArgumentException if tokens length is larger than 255
	 */
	public ConnectionId(byte[] connectionId) {
		if (connectionId == null) {
			throw new NullPointerException("cid must not be null");
		} else if (connectionId.length > 255) {
			throw new IllegalArgumentException("cid length must be between 0 and 255 inclusive");
		}
		this.connectionId = connectionId;
		this.hash = Arrays.hashCode(this.connectionId);
	}

	@Override
	public String toString() {
		return new StringBuilder("CID=").append(getAsString()).toString();
	}

	@Override
	public int hashCode() {
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConnectionId other = (ConnectionId) obj;
		return Arrays.equals(connectionId, other.connectionId);
	}

	/**
	 * Get connection id bytes.
	 * 
	 * @return connection id bytes. Not Copied!
	 */
	public byte[] getBytes() {
		return connectionId;
	}

	/**
	 * Get connection id bytes as (hexadecimal) string.
	 * 
	 * @return connection id bytes as (hexadecimal) string
	 */
	public String getAsString() {
		return StringUtil.byteArray2HexString(connectionId, StringUtil.NO_SEPARATOR, 0);
	}

	/**
	 * Check, if connection id is empty.
	 * 
	 * @return {@code true}, if connection id is empty, {@code false}, otherwise
	 */
	public boolean isEmpty() {
		return connectionId.length == 0;
	}

	/**
	 * Return number of connection id bytes.
	 * 
	 * @return number of connection id bytes. 0 to 255.
	 */
	public int length() {
		return connectionId.length;
	}

	
}
