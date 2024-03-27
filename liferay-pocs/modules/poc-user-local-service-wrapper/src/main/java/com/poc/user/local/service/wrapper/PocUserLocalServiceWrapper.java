package com.poc.user.local.service.wrapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.UserLocalServiceWrapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jayesh Goswami
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class PocUserLocalServiceWrapper extends UserLocalServiceWrapper {

	public PocUserLocalServiceWrapper() {
		super(null);
	}
	
	@Override
	public int authenticateByEmailAddress(
			long companyId, String emailAddress, String password,
			java.util.Map<String, String[]> headerMap,
			java.util.Map<String, String[]> parameterMap,
			java.util.Map<String, Object> resultsMap)
		throws com.liferay.portal.kernel.exception.PortalException {

		_log.info("PocUserLocalServiceWrapperService ::: Pre authenticateByEmailAddress  ::: Wrapper For User Local Service Called");
		_log.info("PocUserLocalServiceWrapperService ::: Pre authenticateByEmailAddress  ::: Email Address ::: " + emailAddress);
		
		int authenticationStatus = super.authenticateByEmailAddress(companyId, emailAddress, password, headerMap, parameterMap, resultsMap);
		
		_log.info("PocUserLocalServiceWrapperService ::: Post authenticateByEmailAddress  ::: Email Address ::: " + emailAddress + " authenticationStatus ::: " + authenticationStatus);
		
		return authenticationStatus; 
	}
	
	private Log _log = LogFactoryUtil.getLog(PocUserLocalServiceWrapper.class);

}