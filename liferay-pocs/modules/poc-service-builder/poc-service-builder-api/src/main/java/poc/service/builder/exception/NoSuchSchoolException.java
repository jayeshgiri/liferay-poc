/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package poc.service.builder.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchSchoolException extends NoSuchModelException {

	public NoSuchSchoolException() {
	}

	public NoSuchSchoolException(String msg) {
		super(msg);
	}

	public NoSuchSchoolException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchSchoolException(Throwable throwable) {
		super(throwable);
	}

}