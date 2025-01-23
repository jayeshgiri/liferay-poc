package hb.user.management.api.client.serdes.v1_0;

import hb.user.management.api.client.dto.v1_0.HBUser;
import hb.user.management.api.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author JayeshGoswami
 * @generated
 */
@Generated("")
public class HBUserSerDes {

	public static HBUser toDTO(String json) {
		HBUserJSONParser hbUserJSONParser = new HBUserJSONParser();

		return hbUserJSONParser.parseToDTO(json);
	}

	public static HBUser[] toDTOs(String json) {
		HBUserJSONParser hbUserJSONParser = new HBUserJSONParser();

		return hbUserJSONParser.parseToDTOs(json);
	}

	public static String toJSON(HBUser hbUser) {
		if (hbUser == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (hbUser.getAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"address\": ");

			sb.append(String.valueOf(hbUser.getAddress()));
		}

		if (hbUser.getCustomFields() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"customFields\": ");

			sb.append(String.valueOf(hbUser.getCustomFields()));
		}

		if (hbUser.getEmailAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"emailAddress\": ");

			sb.append("\"");

			sb.append(_escape(hbUser.getEmailAddress()));

			sb.append("\"");
		}

		if (hbUser.getFirstName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"firstName\": ");

			sb.append("\"");

			sb.append(_escape(hbUser.getFirstName()));

			sb.append("\"");
		}

		if (hbUser.getIsActive() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isActive\": ");

			sb.append(hbUser.getIsActive());
		}

		if (hbUser.getJobTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"jobTitle\": ");

			sb.append("\"");

			sb.append(_escape(hbUser.getJobTitle()));

			sb.append("\"");
		}

		if (hbUser.getLastName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lastName\": ");

			sb.append("\"");

			sb.append(_escape(hbUser.getLastName()));

			sb.append("\"");
		}

		if (hbUser.getMiddleName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"middleName\": ");

			sb.append("\"");

			sb.append(_escape(hbUser.getMiddleName()));

			sb.append("\"");
		}

		if (hbUser.getOrganizationId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"organizationId\": ");

			sb.append(hbUser.getOrganizationId());
		}

		if (hbUser.getRoleIds() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"roleIds\": ");

			sb.append("[");

			for (int i = 0; i < hbUser.getRoleIds().length; i++) {
				sb.append(hbUser.getRoleIds()[i]);

				if ((i + 1) < hbUser.getRoleIds().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (hbUser.getSex() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"sex\": ");

			sb.append("\"");

			sb.append(_escape(hbUser.getSex()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		HBUserJSONParser hbUserJSONParser = new HBUserJSONParser();

		return hbUserJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(HBUser hbUser) {
		if (hbUser == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (hbUser.getAddress() == null) {
			map.put("address", null);
		}
		else {
			map.put("address", String.valueOf(hbUser.getAddress()));
		}

		if (hbUser.getCustomFields() == null) {
			map.put("customFields", null);
		}
		else {
			map.put("customFields", String.valueOf(hbUser.getCustomFields()));
		}

		if (hbUser.getEmailAddress() == null) {
			map.put("emailAddress", null);
		}
		else {
			map.put("emailAddress", String.valueOf(hbUser.getEmailAddress()));
		}

		if (hbUser.getFirstName() == null) {
			map.put("firstName", null);
		}
		else {
			map.put("firstName", String.valueOf(hbUser.getFirstName()));
		}

		if (hbUser.getIsActive() == null) {
			map.put("isActive", null);
		}
		else {
			map.put("isActive", String.valueOf(hbUser.getIsActive()));
		}

		if (hbUser.getJobTitle() == null) {
			map.put("jobTitle", null);
		}
		else {
			map.put("jobTitle", String.valueOf(hbUser.getJobTitle()));
		}

		if (hbUser.getLastName() == null) {
			map.put("lastName", null);
		}
		else {
			map.put("lastName", String.valueOf(hbUser.getLastName()));
		}

		if (hbUser.getMiddleName() == null) {
			map.put("middleName", null);
		}
		else {
			map.put("middleName", String.valueOf(hbUser.getMiddleName()));
		}

		if (hbUser.getOrganizationId() == null) {
			map.put("organizationId", null);
		}
		else {
			map.put(
				"organizationId", String.valueOf(hbUser.getOrganizationId()));
		}

		if (hbUser.getRoleIds() == null) {
			map.put("roleIds", null);
		}
		else {
			map.put("roleIds", String.valueOf(hbUser.getRoleIds()));
		}

		if (hbUser.getSex() == null) {
			map.put("sex", null);
		}
		else {
			map.put("sex", String.valueOf(hbUser.getSex()));
		}

		return map;
	}

	public static class HBUserJSONParser extends BaseJSONParser<HBUser> {

		@Override
		protected HBUser createDTO() {
			return new HBUser();
		}

		@Override
		protected HBUser[] createDTOArray(int size) {
			return new HBUser[size];
		}

		@Override
		protected void setField(
			HBUser hbUser, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "address")) {
				if (jsonParserFieldValue != null) {
					hbUser.setAddress(
						CustomAddressSerDes.toDTO(
							(String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "customFields")) {
				if (jsonParserFieldValue != null) {
					hbUser.setCustomFields(
						CustomFieldsSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "emailAddress")) {
				if (jsonParserFieldValue != null) {
					hbUser.setEmailAddress((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "firstName")) {
				if (jsonParserFieldValue != null) {
					hbUser.setFirstName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "isActive")) {
				if (jsonParserFieldValue != null) {
					hbUser.setIsActive((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "jobTitle")) {
				if (jsonParserFieldValue != null) {
					hbUser.setJobTitle((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "lastName")) {
				if (jsonParserFieldValue != null) {
					hbUser.setLastName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "middleName")) {
				if (jsonParserFieldValue != null) {
					hbUser.setMiddleName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "organizationId")) {
				if (jsonParserFieldValue != null) {
					hbUser.setOrganizationId(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "roleIds")) {
				if (jsonParserFieldValue != null) {
					hbUser.setRoleIds(
						toIntegers((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "sex")) {
				if (jsonParserFieldValue != null) {
					hbUser.setSex((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
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
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}