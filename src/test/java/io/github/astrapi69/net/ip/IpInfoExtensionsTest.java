/**
 * The MIT License
 *
 * Copyright (C) 2022 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package io.github.astrapi69.net.ip;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.SocketException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

/**
 * Test class for {@link IpInfoExtensions}
 */
class IpInfoExtensionsTest
{

	/**
	 * Test method for {@link IpInfoExtensions#getLocalIPAddress()} Ensures the method returns a
	 * valid local IP address
	 *
	 * @throws SocketException
	 *             if an error occurs while retrieving the IP address
	 */
	@Test
	void testGetLocalIPAddress() throws SocketException
	{
		String localIP = IpInfoExtensions.getLocalIPAddress();
		System.out.println("Local IP Address: " + localIP);
		assertNotNull(localIP);
		assertFalse(localIP.isEmpty());
		assertNotEquals("Not found", localIP);
	}

	/**
	 * Test method for {@link IpInfoExtensions#getRouterIPAddress()} Ensures the method returns a
	 * valid router IP address
	 *
	 * @throws IOException
	 *             if an error occurs while retrieving the router's IP
	 */
	@Test
	void testGetRouterIPAddress() throws IOException
	{
		String routerIP = IpInfoExtensions.getRouterIPAddress();
		System.out.println("Router IP Address: " + routerIP);
		assertNotNull(routerIP);
		assertFalse(routerIP.isEmpty());
		assertNotEquals("Not found", routerIP);
	}

	/**
	 * Test method for {@link IpInfoExtensions#getExternalIPAddress()} Ensures the method returns a
	 * valid external IP address
	 *
	 * @throws IOException
	 *             if an error occurs while retrieving the external IP
	 * @throws URISyntaxException
	 *             if an error occurs while the uri is created
	 */
	@Test
	void testGetExternalIPAddress() throws IOException, URISyntaxException
	{
		String externalIP = IpInfoExtensions.getExternalIPAddress();
		System.out.println("External IP Address: " + externalIP);
		assertNotNull(externalIP);
		assertFalse(externalIP.isEmpty());
	}

	/**
	 * Test method for {@link IpInfoExtensions#getLocalNetworkIPAddress()} Ensures the method
	 * returns a valid network IP address
	 */
	@Test
	void testGetLocalNetworkIPAddress()
	{
		String networkIP = IpInfoExtensions.getLocalNetworkIPAddress();
		System.out.println("Local Network IP Address: " + networkIP);
		assertNotNull(networkIP);
		assertFalse(networkIP.isEmpty());
		assertNotEquals("Unable to determine IP address", networkIP);
	}
}
