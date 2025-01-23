package hb.user.management.api.client.serdes.v1_0;

import hb.user.management.api.client.dto.v1_0.CustomAddress;
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
public class CustomAddressSerDes {

	public static CustomAddress toDTO(String json) {
		CustomAddressJSONParser customAddressJSONParser =
			new CustomAddressJSONParser();

		return customAddressJSONParser.parseToDTO(json);
	}

	public static CustomAddress[] toDTOs(String json) {
		CustomAddressJSONParser customAddressJSONParser =
			new CustomAddressJSONParser();

		return customAddressJSONParser.parseToDTOs(json);
	}

	public static String toJSON(CustomAddress customAddress) {
		if (customAddress == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (customAddress.getCity() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"city\": ");

			sb.append("\"");

			sb.append(_escape(customAddress.getCity()));

			sb.append("\"");
		}

		if (customAddress.getCountry() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"country\": ");

			sb.append("\"");

			sb.append(_escape(customAddress.getCountry()));

			sb.append("\"");
		}

		if (customAddress.getPostalCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"postalCode\": ");

			sb.append("\"");

			sb.append(_escape(customAddress.getPostalCode()));

			sb.append("\"");
		}

		if (customAddress.getState() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"state\": ");

			sb.append("\"");

			sb.append(_escape(customAddress.getState()));

			sb.append("\"");
		}

		if (customAddress.getStreet() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"street\": ");

			sb.append("\"");

			sb.append(_escape(customAddress.getStreet()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CustomAddressJSONParser customAddressJSONParser =
			new CustomAddressJSONParser();

		return customAddressJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(CustomAddress customAddress) {
		if (customAddress == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (customAddress.getCity() == null) {
			map.put("city", null);
		}
		else {
			map.put("city", String.valueOf(customAddress.getCity()));
		}

		if (customAddress.getCountry() == null) {
			map.put("country", null);
		}
		else {
			map.put("country", String.valueOf(customAddress.getCountry()));
		}

		if (customAddress.getPostalCode() == null) {
			map.put("postalCode", null);
		}
		else {
			map.put(
				"postalCode", String.valueOf(customAddress.getPostalCode()));
		}

		if (customAddress.getState() == null) {
			map.put("state", null);
		}
		else {
			map.put("state", String.valueOf(customAddress.getState()));
		}

		if (customAddress.getStreet() == null) {
			map.put("street", null);
		}
		else {
			map.put("street", String.valueOf(customAddress.getStreet()));
		}

		return map;
	}

	public static class CustomAddressJSONParser
		extends BaseJSONParser<CustomAddress> {

		@Override
		protected CustomAddress createDTO() {
			return new CustomAddress();
		}

		@Override
		protected CustomAddress[] createDTOArray(int size) {
			return new CustomAddress[size];
		}

		@Override
		protected void setField(
			CustomAddress customAddress, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "city")) {
				if (jsonParserFieldValue != null) {
					customAddress.setCity((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "country")) {
				if (jsonParserFieldValue != null) {
					customAddress.setCountry((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "postalCode")) {
				if (jsonParserFieldValue != null) {
					customAddress.setPostalCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "state")) {
				if (jsonParserFieldValue != null) {
					customAddress.setState((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "street")) {
				if (jsonParserFieldValue != null) {
					customAddress.setStreet((String)jsonParserFieldValue);
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