/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package poc.service.builder.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the School service. Represents a row in the &quot;POC_School&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SchoolModel
 * @generated
 */
@ImplementationClassName("poc.service.builder.model.impl.SchoolImpl")
@ProviderType
public interface School extends PersistedModel, SchoolModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>poc.service.builder.model.impl.SchoolImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<School, Long> SCHOOL_ID_ACCESSOR =
		new Accessor<School, Long>() {

			@Override
			public Long get(School school) {
				return school.getSchoolId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<School> getTypeClass() {
				return School.class;
			}

		};

}