package hb.user.management.api.client.serdes.v1_0;

import hb.user.management.api.client.dto.v1_0.HBOrganizationOnboardedResponse;
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
public class HBOrganizationOnboardedResponseSerDes {

	public static HBOrganizationOnboardedResponse toDTO(String json) {
		HBOrganizationOnboardedResponseJSONParser
			hbOrganizationOnboardedResponseJSONParser =
				new HBOrganizationOnboardedResponseJSONParser();

		return hbOrganizationOnboardedResponseJSONParser.parseToDTO(json);
	}

	public static HBOrganizationOnboardedResponse[] toDTOs(String json) {
		HBOrganizationOnboardedResponseJSONParser
			hbOrganizationOnboardedResponseJSONParser =
				new HBOrganizationOnboardedResponseJSONParser();

		return hbOrganizationOnboardedResponseJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		HBOrganizationOnboardedResponse hbOrganizationOnboardedResponse) {

		if (hbOrganizationOnboardedResponse == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (hbOrganizationOnboardedResponse.getMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(hbOrganizationOnboardedResponse.getMessage()));

			sb.append("\"");
		}

		if (hbOrganizationOnboardedResponse.getOrganizationId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"organizationId\": ");

			sb.append(hbOrganizationOnboardedResponse.getOrganizationId());
		}

		if (hbOrganizationOnboardedResponse.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(_escape(hbOrganizationOnboardedResponse.getStatus()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		HBOrganizationOnboardedResponseJSONParser
			hbOrganizationOnboardedResponseJSONParser =
				new HBOrganizationOnboardedResponseJSONParser();

		return hbOrganizationOnboardedResponseJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		HBOrganizationOnboardedResponse hbOrganizationOnboardedResponse) {

		if (hbOrganizationOnboardedResponse == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (hbOrganizationOnboardedResponse.getMessage() == null) {
			map.put("message", null);
		}
		else {
			map.put(
				"message",
				String.valueOf(hbOrganizationOnboardedResponse.getMessage()));
		}

		if (hbOrganizationOnboardedResponse.getOrganizationId() == null) {
			map.put("organizationId", null);
		}
		else {
			map.put(
				"organizationId",
				String.valueOf(
					hbOrganizationOnboardedResponse.getOrganizationId()));
		}

		if (hbOrganizationOnboardedResponse.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put(
				"status",
				String.valueOf(hbOrganizationOnboardedResponse.getStatus()));
		}

		return map;
	}

	public static class HBOrganizationOnboardedResponseJSONParser
		extends BaseJSONParser<HBOrganizationOnboardedResponse> {

		@Override
		protected HBOrganizationOnboardedResponse createDTO() {
			return new HBOrganizationOnboardedResponse();
		}

		@Override
		protected HBOrganizationOnboardedResponse[] createDTOArray(int size) {
			return new HBOrganizationOnboardedResponse[size];
		}

		@Override
		protected void setField(
			HBOrganizationOnboardedResponse hbOrganizationOnboardedResponse,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "message")) {
				if (jsonParserFieldValue != null) {
					hbOrganizationOnboardedResponse.setMessage(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "organizationId")) {
				if (jsonParserFieldValue != null) {
					hbOrganizationOnboardedResponse.setOrganizationId(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					hbOrganizationOnboardedResponse.setStatus(
						(String)jsonParserFieldValue);
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