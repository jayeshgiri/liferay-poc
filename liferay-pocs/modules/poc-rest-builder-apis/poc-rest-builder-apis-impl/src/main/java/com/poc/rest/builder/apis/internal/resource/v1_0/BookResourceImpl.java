package com.poc.rest.builder.apis.internal.resource.v1_0;

import com.poc.rest.builder.apis.resource.v1_0.BookResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Jayesh Goswami
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/book.properties",
	scope = ServiceScope.PROTOTYPE, service = BookResource.class
)
public class BookResourceImpl extends BaseBookResourceImpl {
}