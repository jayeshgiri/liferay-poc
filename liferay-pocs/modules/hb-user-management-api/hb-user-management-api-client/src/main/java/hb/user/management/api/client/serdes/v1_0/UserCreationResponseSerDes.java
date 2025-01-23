package hb.user.management.api.client.serdes.v1_0;

import hb.user.management.api.client.dto.v1_0.UserCreationResponse;
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
public class UserCreationResponseSerDes {

	public static UserCreationResponse toDTO(String json) {
		UserCreationResponseJSONParser userCreationResponseJSONParser =
			new UserCreationResponseJSONParser();

		return userCreationResponseJSONParser.parseToDTO(json);
	}

	public static UserCreationResponse[] toDTOs(String json) {
		UserCreationResponseJSONParser userCreationResponseJSONParser =
			new UserCreationResponseJSONParser();

		return userCreationResponseJSONParser.parseToDTOs(json);
	}

	public static String toJSON(UserCreationResponse userCreationResponse) {
		if (userCreationResponse == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (userCreationResponse.getEmailAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"emailAddress\": ");

			sb.append("\"");

			sb.append(_escape(userCreationResponse.getEmailAddress()));

			sb.append("\"");
		}

		if (userCreationResponse.getMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(userCreationResponse.getMessage()));

			sb.append("\"");
		}

		if (userCreationResponse.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(_escape(userCreationResponse.getStatus()));

			sb.append("\"");
		}

		if (userCreationResponse.getUserId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userId\": ");

			sb.append(userCreationResponse.getUserId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		UserCreationResponseJSONParser userCreationResponseJSONParser =
			new UserCreationResponseJSONParser();

		return userCreationResponseJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		UserCreationResponse userCreationResponse) {

		if (userCreationResponse == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (userCreationResponse.getEmailAddress() == null) {
			map.put("emailAddress", null);
		}
		else {
			map.put(
				"emailAddress",
				String.valueOf(userCreationResponse.getEmailAddress()));
		}

		if (userCreationResponse.getMessage() == null) {
			map.put("message", null);
		}
		else {
			map.put(
				"message", String.valueOf(userCreationResponse.getMessage()));
		}

		if (userCreationResponse.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(userCreationResponse.getStatus()));
		}

		if (userCreationResponse.getUserId() == null) {
			map.put("userId", null);
		}
		else {
			map.put("userId", String.valueOf(userCreationResponse.getUserId()));
		}

		return map;
	}

	public static class UserCreationResponseJSONParser
		extends BaseJSONParser<UserCreationResponse> {

		@Override
		protected UserCreationResponse createDTO() {
			return new UserCreationResponse();
		}

		@Override
		protected UserCreationResponse[] createDTOArray(int size) {
			return new UserCreationResponse[size];
		}

		@Override
		protected void setField(
			UserCreationResponse userCreationResponse,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "emailAddress")) {
				if (jsonParserFieldValue != null) {
					userCreationResponse.setEmailAddress(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "message")) {
				if (jsonParserFieldValue != null) {
					userCreationResponse.setMessage(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					userCreationResponse.setStatus(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userId")) {
				if (jsonParserFieldValue != null) {
					userCreationResponse.setUserId(
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