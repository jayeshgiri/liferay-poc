package hb.user.management.api.client.serdes.v1_0;

import hb.user.management.api.client.dto.v1_0.HBOrganizationOnboardedRequest;
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
public class HBOrganizationOnboardedRequestSerDes {

	public static HBOrganizationOnboardedRequest toDTO(String json) {
		HBOrganizationOnboardedRequestJSONParser
			hbOrganizationOnboardedRequestJSONParser =
				new HBOrganizationOnboardedRequestJSONParser();

		return hbOrganizationOnboardedRequestJSONParser.parseToDTO(json);
	}

	public static HBOrganizationOnboardedRequest[] toDTOs(String json) {
		HBOrganizationOnboardedRequestJSONParser
			hbOrganizationOnboardedRequestJSONParser =
				new HBOrganizationOnboardedRequestJSONParser();

		return hbOrganizationOnboardedRequestJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		HBOrganizationOnboardedRequest hbOrganizationOnboardedRequest) {

		if (hbOrganizationOnboardedRequest == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (hbOrganizationOnboardedRequest.getIsOnboarded() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isOnboarded\": ");

			sb.append(hbOrganizationOnboardedRequest.getIsOnboarded());
		}

		if (hbOrganizationOnboardedRequest.getOrganizationId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"organizationId\": ");

			sb.append(hbOrganizationOnboardedRequest.getOrganizationId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		HBOrganizationOnboardedRequestJSONParser
			hbOrganizationOnboardedRequestJSONParser =
				new HBOrganizationOnboardedRequestJSONParser();

		return hbOrganizationOnboardedRequestJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		HBOrganizationOnboardedRequest hbOrganizationOnboardedRequest) {

		if (hbOrganizationOnboardedRequest == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (hbOrganizationOnboardedRequest.getIsOnboarded() == null) {
			map.put("isOnboarded", null);
		}
		else {
			map.put(
				"isOnboarded",
				String.valueOf(
					hbOrganizationOnboardedRequest.getIsOnboarded()));
		}

		if (hbOrganizationOnboardedRequest.getOrganizationId() == null) {
			map.put("organizationId", null);
		}
		else {
			map.put(
				"organizationId",
				String.valueOf(
					hbOrganizationOnboardedRequest.getOrganizationId()));
		}

		return map;
	}

	public static class HBOrganizationOnboardedRequestJSONParser
		extends BaseJSONParser<HBOrganizationOnboardedRequest> {

		@Override
		protected HBOrganizationOnboardedRequest createDTO() {
			return new HBOrganizationOnboardedRequest();
		}

		@Override
		protected HBOrganizationOnboardedRequest[] createDTOArray(int size) {
			return new HBOrganizationOnboardedRequest[size];
		}

		@Override
		protected void setField(
			HBOrganizationOnboardedRequest hbOrganizationOnboardedRequest,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "isOnboarded")) {
				if (jsonParserFieldValue != null) {
					hbOrganizationOnboardedRequest.setIsOnboarded(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "organizationId")) {
				if (jsonParserFieldValue != null) {
					hbOrganizationOnboardedRequest.setOrganizationId(
						Integer.valueOf((String)jsonParserFieldValue));
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