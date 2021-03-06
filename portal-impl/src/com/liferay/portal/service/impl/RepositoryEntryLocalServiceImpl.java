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

package com.liferay.portal.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.RepositoryEntry;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.base.RepositoryEntryLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 * @author Michael C. Han
 */
public class RepositoryEntryLocalServiceImpl
	extends RepositoryEntryLocalServiceBaseImpl {

	public RepositoryEntry addRepositoryEntry(
			long groupId, long repositoryId, String mappedId,
			ServiceContext serviceContext)
		throws SystemException {

		long repositoryEntryId = counterLocalService.increment();

		RepositoryEntry repositoryEntry = repositoryEntryPersistence.create(
			repositoryEntryId);

		repositoryEntry.setGroupId(groupId);
		repositoryEntry.setUuid(serviceContext.getUuid());
		repositoryEntry.setRepositoryId(repositoryId);
		repositoryEntry.setMappedId(mappedId);

		repositoryEntryPersistence.update(repositoryEntry, false);

		return repositoryEntry;
	}

	public RepositoryEntry updateRepositoryEntry(
			long repositoryEntryId, String mappedId)
		throws PortalException, SystemException {

		RepositoryEntry repositoryEntry =
			repositoryEntryPersistence.findByPrimaryKey(repositoryEntryId);

		repositoryEntry.setMappedId(mappedId);

		repositoryEntryPersistence.update(repositoryEntry, false);

		return repositoryEntry;
	}

}