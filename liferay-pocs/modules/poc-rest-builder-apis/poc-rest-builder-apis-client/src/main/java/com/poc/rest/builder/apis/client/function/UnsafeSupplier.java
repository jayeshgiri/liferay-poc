package com.poc.rest.builder.apis.client.function;

import javax.annotation.Generated;

/**
 * @author Jayesh Goswami
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}