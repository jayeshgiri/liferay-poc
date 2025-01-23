package hb.user.management.api.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author JayeshGoswami
 * @generated
 */
@Generated("")
@GraphQLName("HBOrganizationOnboardedRequest")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "HBOrganizationOnboardedRequest")
public class HBOrganizationOnboardedRequest implements Serializable {

	public static HBOrganizationOnboardedRequest toDTO(String json) {
		return ObjectMapperUtil.readValue(
			HBOrganizationOnboardedRequest.class, json);
	}

	public static HBOrganizationOnboardedRequest unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(
			HBOrganizationOnboardedRequest.class, json);
	}

	@Schema
	public Boolean getIsOnboarded() {
		return isOnboarded;
	}

	public void setIsOnboarded(Boolean isOnboarded) {
		this.isOnboarded = isOnboarded;
	}

	@JsonIgnore
	public void setIsOnboarded(
		UnsafeSupplier<Boolean, Exception> isOnboardedUnsafeSupplier) {

		try {
			isOnboarded = isOnboardedUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Boolean isOnboarded;

	@Schema
	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	@JsonIgnore
	public void setOrganizationId(
		UnsafeSupplier<Integer, Exception> organizationIdUnsafeSupplier) {

		try {
			organizationId = organizationIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer organizationId;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HBOrganizationOnboardedRequest)) {
			return false;
		}

		HBOrganizationOnboardedRequest hbOrganizationOnboardedRequest =
			(HBOrganizationOnboardedRequest)object;

		return Objects.equals(
			toString(), hbOrganizationOnboardedRequest.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (isOnboarded != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isOnboarded\": ");

			sb.append(isOnboarded);
		}

		if (organizationId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"organizationId\": ");

			sb.append(organizationId);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "hb.user.management.api.dto.v1_0.HBOrganizationOnboardedRequest",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}