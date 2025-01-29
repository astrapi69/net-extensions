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
package io.github.astrapi69.net.swing;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import io.github.astrapi69.net.ip.IpInfo;
import io.github.astrapi69.net.ip.IpInfoExtensions;

/**
 * Swing panel to display IP information
 */
public class IpInfoPanelMain
{

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(() -> {
			try
			{
				IpInfo ipInfo = new IpInfo(IpInfoExtensions.getLocalIPAddress(),
					IpInfoExtensions.getRouterIPAddress(), IpInfoExtensions.getExternalIPAddress(),
					IpInfoExtensions.getLocalNetworkIPAddress());
				IpInfoPanel ipInfoPanel = new IpInfoPanel(ipInfo);
				JFrame frame = new JFrame("IP Information");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(400, 200);
				frame.add(ipInfoPanel);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
			catch (IOException | URISyntaxException e)
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,
					"Error retrieving IP information: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			}
		});
	}
}