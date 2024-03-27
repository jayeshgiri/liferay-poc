package com.system.setting.configurable.e1.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition.Scope;

import aQute.bnd.annotation.metatype.*;

@ExtendedObjectClassDefinition(category = "address-information-1", scope = Scope.SYSTEM)

@Meta.OCD(id = "com.system.setting.configurable.e1.configuration.CurrentStateConfiguration", name = "Current State")
public interface CurrentStateConfiguration {

	@Meta.AD(deflt = "gujarat",
			description = "Current State",
			name = "currentState",
			optionLabels = {"Gujarat", "MP", "UP"},
			optionValues = {"gujarat", "mp", "up"}
			)
	public String currentState();
}
