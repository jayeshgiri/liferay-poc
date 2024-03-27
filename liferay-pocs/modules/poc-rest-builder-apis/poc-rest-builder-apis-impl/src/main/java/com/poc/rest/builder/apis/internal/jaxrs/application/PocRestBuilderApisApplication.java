package com.poc.rest.builder.apis.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jayesh Goswami
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/poc-rest-builder-apis",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=PocRestBuilderApis"
	},
	service = Application.class
)
@Generated("")
public class PocRestBuilderApisApplication extends Application {
}