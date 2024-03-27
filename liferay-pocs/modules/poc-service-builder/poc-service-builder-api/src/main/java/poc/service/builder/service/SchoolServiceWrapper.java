/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package poc.service.builder.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SchoolService}.
 *
 * @author Brian Wing Shun Chan
 * @see SchoolService
 * @generated
 */
public class SchoolServiceWrapper
	implements SchoolService, ServiceWrapper<SchoolService> {

	public SchoolServiceWrapper() {
		this(null);
	}

	public SchoolServiceWrapper(SchoolService schoolService) {
		_schoolService = schoolService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _schoolService.getOSGiServiceIdentifier();
	}

	@Override
	public SchoolService getWrappedService() {
		return _schoolService;
	}

	@Override
	public void setWrappedService(SchoolService schoolService) {
		_schoolService = schoolService;
	}

	private SchoolService _schoolService;

}