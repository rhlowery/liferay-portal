/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.friendly.url.internal.exportimport.staged.model.repository;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.staged.model.repository.StagedModelRepository;
import com.liferay.exportimport.staged.model.repository.base.BaseStagedModelRepository;
import com.liferay.friendly.url.model.FriendlyURLEntry;
import com.liferay.friendly.url.service.FriendlyURLEntryLocalService;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.MapUtil;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adolfo Pérez
 */
@Component(
	immediate = true,
	property = {
		"model.class.name=com.liferay.friendly.url.model.FriendlyURLEntry"
	},
	service = StagedModelRepository.class
)
public class FriendlyURLEntryStagedModelRepository
	extends BaseStagedModelRepository<FriendlyURLEntry> {

	@Override
	public FriendlyURLEntry addStagedModel(
			PortletDataContext portletDataContext,
			FriendlyURLEntry friendlyURLEntry)
		throws PortalException {

		return _friendlyURLEntryLocalService.addFriendlyURLEntry(
			friendlyURLEntry.getCompanyId(), friendlyURLEntry.getGroupId(),
			friendlyURLEntry.getClassNameId(), friendlyURLEntry.getClassPK(),
			friendlyURLEntry.getUrlTitle());
	}

	@Override
	public void deleteStagedModel(FriendlyURLEntry friendlyURLEntry)
		throws PortalException {

		_friendlyURLEntryLocalService.deleteFriendlyURLEntry(
			friendlyURLEntry.getCompanyId(), friendlyURLEntry.getGroupId(),
			friendlyURLEntry.getClassNameId(), friendlyURLEntry.getClassPK(),
			friendlyURLEntry.getUrlTitle());
	}

	@Override
	public void deleteStagedModel(
			String uuid, long groupId, String className, String extraData)
		throws PortalException {

		FriendlyURLEntry friendlyURLEntry = fetchStagedModelByUuidAndGroupId(
			uuid, groupId);

		if (friendlyURLEntry != null) {
			deleteStagedModel(friendlyURLEntry);
		}
	}

	@Override
	public void deleteStagedModels(PortletDataContext portletDataContext)
		throws PortalException {

		Map<String, String[]> parameterMap =
			portletDataContext.getParameterMap();

		long classNameId = MapUtil.getLong(
			parameterMap, "parentStagedModelClassNameId");

		_friendlyURLEntryLocalService.deleteGroupFriendlyURLEntries(
			portletDataContext.getGroupId(), classNameId);
	}

	@Override
	public List<FriendlyURLEntry> fetchStagedModelsByUuidAndCompanyId(
		String uuid, long companyId) {

		return _friendlyURLEntryLocalService.
			getFriendlyURLEntriesByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext) {

		return _friendlyURLEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public FriendlyURLEntry saveStagedModel(FriendlyURLEntry friendlyURLEntry)
		throws PortalException {

		if (friendlyURLEntry.isMain()) {
			FriendlyURLEntry mainFriendlyURLEntry =
				_friendlyURLEntryLocalService.getMainFriendlyURLEntry(
					friendlyURLEntry.getCompanyId(),
					friendlyURLEntry.getGroupId(),
					friendlyURLEntry.getClassNameId(),
					friendlyURLEntry.getClassPK());

			if (!mainFriendlyURLEntry.equals(friendlyURLEntry)) {
				mainFriendlyURLEntry.setMain(false);

				_friendlyURLEntryLocalService.updateFriendlyURLEntry(
					mainFriendlyURLEntry);
			}
		}

		friendlyURLEntry.setUrlTitle(
			_friendlyURLEntryLocalService.getUniqueUrlTitle(
				friendlyURLEntry.getCompanyId(), friendlyURLEntry.getGroupId(),
				friendlyURLEntry.getClassNameId(),
				friendlyURLEntry.getClassPK(), friendlyURLEntry.getUrlTitle()));

		return _friendlyURLEntryLocalService.updateFriendlyURLEntry(
			friendlyURLEntry);
	}

	@Override
	public FriendlyURLEntry updateStagedModel(
			PortletDataContext portletDataContext,
			FriendlyURLEntry friendlyURLEntry)
		throws PortalException {

		return saveStagedModel(friendlyURLEntry);
	}

	@Reference(unbind = "-")
	protected void setFriendlyURLEntryLocalService(
		FriendlyURLEntryLocalService friendlyURLEntryLocalService) {

		_friendlyURLEntryLocalService = friendlyURLEntryLocalService;
	}

	private FriendlyURLEntryLocalService _friendlyURLEntryLocalService;

}