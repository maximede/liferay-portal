/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portlet.assetpublisher.lar.importlarap;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewImportLARTest extends BaseTestCase {
	public void testViewImportLAR() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Asset Publisher Test Page");
		selenium.clickAt("link=Asset Publisher Test Page",
			RuntimeVariables.replace("Asset Publisher Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Options"),
			selenium.getText("//span[@title='Options']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Options']/ul/li/strong/a",
			RuntimeVariables.replace("Options"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a");
		assertEquals(RuntimeVariables.replace("Configuration"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a",
			RuntimeVariables.replace("Configuration"));
		selenium.waitForVisible("//select[@id='_86_selectionStyle']");
		assertEquals("Dynamic",
			selenium.getSelectedLabel("//select[@id='_86_selectionStyle']"));
		assertEquals(RuntimeVariables.replace("Source"),
			selenium.getText("xpath=(//div[@class='lfr-panel-title'])[1]"));
		assertEquals(RuntimeVariables.replace("Filter"),
			selenium.getText("xpath=(//div[@class='lfr-panel-title'])[2]"));
		assertEquals(RuntimeVariables.replace("Custom User Attributes"),
			selenium.getText("xpath=(//div[@class='lfr-panel-title'])[3]"));
		assertEquals(RuntimeVariables.replace("Ordering and Grouping"),
			selenium.getText("xpath=(//div[@class='lfr-panel-title'])[4]"));
		assertEquals(RuntimeVariables.replace("Display Settings"),
			selenium.getText("xpath=(//div[@class='lfr-panel-title'])[5]"));
	}
}