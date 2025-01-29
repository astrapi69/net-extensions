
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
