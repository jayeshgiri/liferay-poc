package hb.user.management.api.client.serdes.v1_0;

import hb.user.management.api.client.dto.v1_0.CustomFields;
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
public class CustomFieldsSerDes {

	public static CustomFields toDTO(String json) {
		CustomFieldsJSONParser customFieldsJSONParser =
			new CustomFieldsJSONParser();

		return customFieldsJSONParser.parseToDTO(json);
	}

	public static CustomFields[] toDTOs(String json) {
		CustomFieldsJSONParser customFieldsJSONParser =
			new CustomFieldsJSONParser();

		return customFieldsJSONParser.parseToDTOs(json);
	}

	public static String toJSON(CustomFields customFields) {
		if (customFields == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (customFields.getBenefitsEffectiveDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"benefitsEffectiveDate\": ");

			sb.append("\"");

			sb.append(_escape(customFields.getBenefitsEffectiveDate()));

			sb.append("\"");
		}

		if (customFields.getCoverageLevel() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"coverageLevel\": ");

			sb.append("\"");

			sb.append(_escape(customFields.getCoverageLevel()));

			sb.append("\"");
		}

		if (customFields.getEmployeeClass() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"employeeClass\": ");

			sb.append("\"");

			sb.append(_escape(customFields.getEmployeeClass()));

			sb.append("\"");
		}

		if (customFields.getEmployeeDepartment() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"employeeDepartment\": ");

			sb.append("\"");

			sb.append(_escape(customFields.getEmployeeDepartment()));

			sb.append("\"");
		}

		if (customFields.getEmployeeId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"employeeId\": ");

			sb.append("\"");

			sb.append(_escape(customFields.getEmployeeId()));

			sb.append("\"");
		}

		if (customFields.getHireDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"hireDate\": ");

			sb.append("\"");

			sb.append(_escape(customFields.getHireDate()));

			sb.append("\"");
		}

		if (customFields.getMedicalCoverage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"medicalCoverage\": ");

			sb.append("\"");

			sb.append(_escape(customFields.getMedicalCoverage()));

			sb.append("\"");
		}

		if (customFields.getPharmacyBenefits() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"pharmacyBenefits\": ");

			sb.append("\"");

			sb.append(_escape(customFields.getPharmacyBenefits()));

			sb.append("\"");
		}

		if (customFields.getPlan() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"plan\": ");

			sb.append("\"");

			sb.append(_escape(customFields.getPlan()));

			sb.append("\"");
		}

		if (customFields.getRelationship() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"relationship\": ");

			sb.append("\"");

			sb.append(_escape(customFields.getRelationship()));

			sb.append("\"");
		}

		if (customFields.getScheduledHours() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"scheduledHours\": ");

			sb.append("\"");

			sb.append(_escape(customFields.getScheduledHours()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CustomFieldsJSONParser customFieldsJSONParser =
			new CustomFieldsJSONParser();

		return customFieldsJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(CustomFields customFields) {
		if (customFields == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (customFields.getBenefitsEffectiveDate() == null) {
			map.put("benefitsEffectiveDate", null);
		}
		else {
			map.put(
				"benefitsEffectiveDate",
				String.valueOf(customFields.getBenefitsEffectiveDate()));
		}

		if (customFields.getCoverageLevel() == null) {
			map.put("coverageLevel", null);
		}
		else {
			map.put(
				"coverageLevel",
				String.valueOf(customFields.getCoverageLevel()));
		}

		if (customFields.getEmployeeClass() == null) {
			map.put("employeeClass", null);
		}
		else {
			map.put(
				"employeeClass",
				String.valueOf(customFields.getEmployeeClass()));
		}

		if (customFields.getEmployeeDepartment() == null) {
			map.put("employeeDepartment", null);
		}
		else {
			map.put(
				"employeeDepartment",
				String.valueOf(customFields.getEmployeeDepartment()));
		}

		if (customFields.getEmployeeId() == null) {
			map.put("employeeId", null);
		}
		else {
			map.put("employeeId", String.valueOf(customFields.getEmployeeId()));
		}

		if (customFields.getHireDate() == null) {
			map.put("hireDate", null);
		}
		else {
			map.put("hireDate", String.valueOf(customFields.getHireDate()));
		}

		if (customFields.getMedicalCoverage() == null) {
			map.put("medicalCoverage", null);
		}
		else {
			map.put(
				"medicalCoverage",
				String.valueOf(customFields.getMedicalCoverage()));
		}

		if (customFields.getPharmacyBenefits() == null) {
			map.put("pharmacyBenefits", null);
		}
		else {
			map.put(
				"pharmacyBenefits",
				String.valueOf(customFields.getPharmacyBenefits()));
		}

		if (customFields.getPlan() == null) {
			map.put("plan", null);
		}
		else {
			map.put("plan", String.valueOf(customFields.getPlan()));
		}

		if (customFields.getRelationship() == null) {
			map.put("relationship", null);
		}
		else {
			map.put(
				"relationship", String.valueOf(customFields.getRelationship()));
		}

		if (customFields.getScheduledHours() == null) {
			map.put("scheduledHours", null);
		}
		else {
			map.put(
				"scheduledHours",
				String.valueOf(customFields.getScheduledHours()));
		}

		return map;
	}

	public static class CustomFieldsJSONParser
		extends BaseJSONParser<CustomFields> {

		@Override
		protected CustomFields createDTO() {
			return new CustomFields();
		}

		@Override
		protected CustomFields[] createDTOArray(int size) {
			return new CustomFields[size];
		}

		@Override
		protected void setField(
			CustomFields customFields, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "benefitsEffectiveDate")) {
				if (jsonParserFieldValue != null) {
					customFields.setBenefitsEffectiveDate(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "coverageLevel")) {
				if (jsonParserFieldValue != null) {
					customFields.setCoverageLevel((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "employeeClass")) {
				if (jsonParserFieldValue != null) {
					customFields.setEmployeeClass((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "employeeDepartment")) {

				if (jsonParserFieldValue != null) {
					customFields.setEmployeeDepartment(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "employeeId")) {
				if (jsonParserFieldValue != null) {
					customFields.setEmployeeId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "hireDate")) {
				if (jsonParserFieldValue != null) {
					customFields.setHireDate((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "medicalCoverage")) {
				if (jsonParserFieldValue != null) {
					customFields.setMedicalCoverage(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "pharmacyBenefits")) {
				if (jsonParserFieldValue != null) {
					customFields.setPharmacyBenefits(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "plan")) {
				if (jsonParserFieldValue != null) {
					customFields.setPlan((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "relationship")) {
				if (jsonParserFieldValue != null) {
					customFields.setRelationship((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "scheduledHours")) {
				if (jsonParserFieldValue != null) {
					customFields.setScheduledHours(
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