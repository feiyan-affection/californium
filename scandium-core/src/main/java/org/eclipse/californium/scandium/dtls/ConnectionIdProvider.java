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

/**
 * Provider of a DTLS connection id.
 * 
 * <a href="https://datatracker.ietf.org/doc/draft-ietf-tls-dtls-connection-id">draft-ietf-tls-dtls-connection-id</a>
 */
public interface ConnectionIdProvider {
	ConnectionId create(int cidLength);
	void release(ConnectionId cid);
}
