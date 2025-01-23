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
@GraphQLName("CustomFields")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "CustomFields")
public class CustomFields implements Serializable {

	public static CustomFields toDTO(String json) {
		return ObjectMapperUtil.readValue(CustomFields.class, json);
	}

	public static CustomFields unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(CustomFields.class, json);
	}

	@Schema
	public String getBenefitsEffectiveDate() {
		return benefitsEffectiveDate;
	}

	public void setBenefitsEffectiveDate(String benefitsEffectiveDate) {
		this.benefitsEffectiveDate = benefitsEffectiveDate;
	}

	@JsonIgnore
	public void setBenefitsEffectiveDate(
		UnsafeSupplier<String, Exception> benefitsEffectiveDateUnsafeSupplier) {

		try {
			benefitsEffectiveDate = benefitsEffectiveDateUnsafeSupplier.get();
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
	protected String benefitsEffectiveDate;

	@Schema
	public String getCoverageLevel() {
		return coverageLevel;
	}

	public void setCoverageLevel(String coverageLevel) {
		this.coverageLevel = coverageLevel;
	}

	@JsonIgnore
	public void setCoverageLevel(
		UnsafeSupplier<String, Exception> coverageLevelUnsafeSupplier) {

		try {
			coverageLevel = coverageLevelUnsafeSupplier.get();
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
	protected String coverageLevel;

	@Schema
	public String getEmployeeClass() {
		return employeeClass;
	}

	public void setEmployeeClass(String employeeClass) {
		this.employeeClass = employeeClass;
	}

	@JsonIgnore
	public void setEmployeeClass(
		UnsafeSupplier<String, Exception> employeeClassUnsafeSupplier) {

		try {
			employeeClass = employeeClassUnsafeSupplier.get();
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
	protected String employeeClass;

	@Schema
	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	@JsonIgnore
	public void setEmployeeDepartment(
		UnsafeSupplier<String, Exception> employeeDepartmentUnsafeSupplier) {

		try {
			employeeDepartment = employeeDepartmentUnsafeSupplier.get();
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
	protected String employeeDepartment;

	@Schema
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@JsonIgnore
	public void setEmployeeId(
		UnsafeSupplier<String, Exception> employeeIdUnsafeSupplier) {

		try {
			employeeId = employeeIdUnsafeSupplier.get();
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
	protected String employeeId;

	@Schema
	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	@JsonIgnore
	public void setHireDate(
		UnsafeSupplier<String, Exception> hireDateUnsafeSupplier) {

		try {
			hireDate = hireDateUnsafeSupplier.get();
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
	protected String hireDate;

	@Schema
	public String getMedicalCoverage() {
		return medicalCoverage;
	}

	public void setMedicalCoverage(String medicalCoverage) {
		this.medicalCoverage = medicalCoverage;
	}

	@JsonIgnore
	public void setMedicalCoverage(
		UnsafeSupplier<String, Exception> medicalCoverageUnsafeSupplier) {

		try {
			medicalCoverage = medicalCoverageUnsafeSupplier.get();
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
	protected String medicalCoverage;

	@Schema
	public String getPharmacyBenefits() {
		return pharmacyBenefits;
	}

	public void setPharmacyBenefits(String pharmacyBenefits) {
		this.pharmacyBenefits = pharmacyBenefits;
	}

	@JsonIgnore
	public void setPharmacyBenefits(
		UnsafeSupplier<String, Exception> pharmacyBenefitsUnsafeSupplier) {

		try {
			pharmacyBenefits = pharmacyBenefitsUnsafeSupplier.get();
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
	protected String pharmacyBenefits;

	@Schema
	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	@JsonIgnore
	public void setPlan(UnsafeSupplier<String, Exception> planUnsafeSupplier) {
		try {
			plan = planUnsafeSupplier.get();
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
	protected String plan;

	@Schema
	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	@JsonIgnore
	public void setRelationship(
		UnsafeSupplier<String, Exception> relationshipUnsafeSupplier) {

		try {
			relationship = relationshipUnsafeSupplier.get();
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
	protected String relationship;

	@Schema
	public String getScheduledHours() {
		return scheduledHours;
	}

	public void setScheduledHours(String scheduledHours) {
		this.scheduledHours = scheduledHours;
	}

	@JsonIgnore
	public void setScheduledHours(
		UnsafeSupplier<String, Exception> scheduledHoursUnsafeSupplier) {

		try {
			scheduledHours = scheduledHoursUnsafeSupplier.get();
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
	protected String scheduledHours;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CustomFields)) {
			return false;
		}

		CustomFields customFields = (CustomFields)object;

		return Objects.equals(toString(), customFields.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (benefitsEffectiveDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"benefitsEffectiveDate\": ");

			sb.append("\"");

			sb.append(_escape(benefitsEffectiveDate));

			sb.append("\"");
		}

		if (coverageLevel != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"coverageLevel\": ");

			sb.append("\"");

			sb.append(_escape(coverageLevel));

			sb.append("\"");
		}

		if (employeeClass != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"employeeClass\": ");

			sb.append("\"");

			sb.append(_escape(employeeClass));

			sb.append("\"");
		}

		if (employeeDepartment != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"employeeDepartment\": ");

			sb.append("\"");

			sb.append(_escape(employeeDepartment));

			sb.append("\"");
		}

		if (employeeId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"employeeId\": ");

			sb.append("\"");

			sb.append(_escape(employeeId));

			sb.append("\"");
		}

		if (hireDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"hireDate\": ");

			sb.append("\"");

			sb.append(_escape(hireDate));

			sb.append("\"");
		}

		if (medicalCoverage != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"medicalCoverage\": ");

			sb.append("\"");

			sb.append(_escape(medicalCoverage));

			sb.append("\"");
		}

		if (pharmacyBenefits != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"pharmacyBenefits\": ");

			sb.append("\"");

			sb.append(_escape(pharmacyBenefits));

			sb.append("\"");
		}

		if (plan != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"plan\": ");

			sb.append("\"");

			sb.append(_escape(plan));

			sb.append("\"");
		}

		if (relationship != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"relationship\": ");

			sb.append("\"");

			sb.append(_escape(relationship));

			sb.append("\"");
		}

		if (scheduledHours != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"scheduledHours\": ");

			sb.append("\"");

			sb.append(_escape(scheduledHours));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "hb.user.management.api.dto.v1_0.CustomFields",
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