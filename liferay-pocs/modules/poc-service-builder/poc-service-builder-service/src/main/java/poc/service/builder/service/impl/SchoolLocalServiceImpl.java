/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package poc.service.builder.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;

import org.osgi.service.component.annotations.Component;

import poc.service.builder.model.School;
import poc.service.builder.service.base.SchoolLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=poc.service.builder.model.School",
	service = AopService.class
)
public class SchoolLocalServiceImpl extends SchoolLocalServiceBaseImpl {
	
	public School addSchoolDetails(School school, long userId, long groupId ) throws PortalException {
		
		School s = addSchool(school);
		
		
		_log.info("School Added...");
		
		assetEntryLocalService.updateEntry(
				userId, groupId, school.getCreateDate(),
				school.getModifiedDate(), School.class.getName(), school.getSchoolId(),
				school.getUuid(), 0, null, null, true, true,
				null, null, school.getCreateDate(), null, null, school.getName(), school.getAddress(), school.getCity(), null,
				null, 0, 0, null);
		
		_log.info("Asset Entry updated...");
		
		Indexer<School> indexer = IndexerRegistryUtil.nullSafeGetIndexer(School.class);
		indexer.reindex(school);
		
		_log.info("Indexing Done for School Object...");

		return s;
		
	}
	
	public School deleteSchoolDetails(long schoolId) throws PortalException {
		
		School school = deleteSchool(schoolId);
		
		_log.info("School Deleted...");
		
		assetEntryLocalService.deleteEntry(School.class.getName(),school.getSchoolId());

		_log.info("Asset Entry updated...");
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(School.class);
		indexer.delete(school);
		
		_log.info("Indexing Deleted for School Object...");
		
		return school;
	}
	
	private Log _log = LogFactoryUtil.getLog(this.getClass());
}