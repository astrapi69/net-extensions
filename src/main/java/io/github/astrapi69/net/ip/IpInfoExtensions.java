package io.github.astrapi69.net.ip;

import static io.github.astrapi69.net.dns.DnsLookupExtensions.PUBLIC_DNS_SERVER_OF_GOOGLE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Enumeration;

/**
 * Utility class for retrieving various types of IP addresses related to the local network and the
 * internet
 */
public final class IpInfoExtensions
{

	/**
	 * Gets the local network IP address of this machine by establishing a connection to a public
	 * DNS server
	 *
	 * @return the local network IP address as a string or an error message if unable to determine
	 */
	public static String getLocalNetworkIPAddress()
	{
		String ipAddress = "Unable to determine IP address";
		try (Socket socket = new Socket(PUBLIC_DNS_SERVER_OF_GOOGLE, 53))
		{
			InetAddress localAddress = socket.getLocalAddress();
			ipAddress = localAddress.getHostAddress();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ipAddress;
	}

	/**
	 * Gets the local IP address of the machine by iterating through available network interfaces
	 *
	 * @return the local IP address as a string or "Not found" if no valid address is available
	 * @throws SocketException
	 *             if an error occurs while retrieving network interfaces
	 */
	public static String getLocalIPAddress() throws SocketException
	{
		Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
		while (networkInterfaces.hasMoreElements())
		{
			NetworkInterface networkInterface = networkInterfaces.nextElement();
			Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
			while (addresses.hasMoreElements())
			{
				InetAddress address = addresses.nextElement();
				if (!address.isLoopbackAddress() && address instanceof Inet4Address)
				{
					return address.getHostAddress();
				}
			}
		}
		return "Not found";
	}

	/**
	 * Gets the default gateway/router IP address by executing the "ip route" command
	 *
	 * @return the router's IP address as a string or "Not found" if unable to retrieve it
	 * @throws IOException
	 *             if an error occurs while executing the command
	 */
	public static String getRouterIPAddress() throws IOException
	{
		ProcessBuilder processBuilder = new ProcessBuilder("ip", "route");
		Process process = processBuilder.start();
		try (BufferedReader reader = new BufferedReader(
			new InputStreamReader(process.getInputStream())))
		{
			String line;
			while ((line = reader.readLine()) != null)
			{
				if (line.startsWith("default via"))
				{
					String[] parts = line.split(" ");
					return parts[2];
				}
			}
		}
		return "Not found";
	}

	/**
	 * Gets the external (public) IP address of the machine by making an HTTP request to an external
	 * service
	 *
	 * @return the external IP address as a string
	 * @throws IOException
	 *             if an error occurs while retrieving the IP address
	 * @throws URISyntaxException
	 *             if an error occurs while the uri is created
	 */
	public static String getExternalIPAddress() throws IOException, URISyntaxException
	{
		URL url = new URI("https://checkip.amazonaws.com").toURL();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream())))
		{
			return reader.readLine();
		}
	}
}
