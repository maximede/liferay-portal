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

package com.liferay.portalweb.portal.dbupgrade.sampledata606.documentlibrary.shortcut;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddDocumentTest extends BaseTestCase {
	public void testAddDocument() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Communities", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.type("_134_name",
			RuntimeVariables.replace("Document Library Shortcut Community"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//td[2]/a", RuntimeVariables.replace("Open"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Document Library Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//a/strong", RuntimeVariables.replace("Test1 Folder1"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Add Document"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list lfr-menu-expanded right ']/ul/li[5]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list lfr-menu-expanded right ']/ul/li[5]/a",
			RuntimeVariables.replace("Add Document"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		selenium.selectWindow("null");
		selenium.windowFocus();
		selenium.waitForVisible("link=Use the classic uploader.");
		selenium.click("link=Use the classic uploader.");
		selenium.waitForVisible("_20_file");
		selenium.type("_20_file",
			RuntimeVariables.replace(
				"L:\\portal\\build\\portal-web\\test\\com\\liferay\\portalweb\\portal\\dbupgrade\\sampledata606\\documentlibrary\\shortcut\\dependencies\\test_document.txt"));
		selenium.type("_20_title",
			RuntimeVariables.replace("Test1 Document1.txt"));
		selenium.type("_20_description",
			RuntimeVariables.replace("This is test1 document1."));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.waitForText("//section/div/div/div/div",
			"Your request processed successfully.");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div"));
		selenium.waitForText("//a/span/span", "Test1 Document1.txt");
		assertEquals(RuntimeVariables.replace("Test1 Document1.txt"),
			selenium.getText("//a/span/span"));
		selenium.waitForText("//a/div", "This is test1 document1.");
		assertEquals(RuntimeVariables.replace("This is test1 document1."),
			selenium.getText("//a/div"));
	}
}