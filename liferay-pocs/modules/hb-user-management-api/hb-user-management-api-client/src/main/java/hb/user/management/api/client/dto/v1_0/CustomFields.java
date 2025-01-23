package hb.user.management.api.client.dto.v1_0;

import hb.user.management.api.client.function.UnsafeSupplier;
import hb.user.management.api.client.serdes.v1_0.CustomFieldsSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author JayeshGoswami
 * @generated
 */
@Generated("")
public class CustomFields implements Cloneable, Serializable {

	public static CustomFields toDTO(String json) {
		return CustomFieldsSerDes.toDTO(json);
	}

	public String getBenefitsEffectiveDate() {
		return benefitsEffectiveDate;
	}

	public void setBenefitsEffectiveDate(String benefitsEffectiveDate) {
		this.benefitsEffectiveDate = benefitsEffectiveDate;
	}

	public void setBenefitsEffectiveDate(
		UnsafeSupplier<String, Exception> benefitsEffectiveDateUnsafeSupplier) {

		try {
			benefitsEffectiveDate = benefitsEffectiveDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String benefitsEffectiveDate;

	public String getCoverageLevel() {
		return coverageLevel;
	}

	public void setCoverageLevel(String coverageLevel) {
		this.coverageLevel = coverageLevel;
	}

	public void setCoverageLevel(
		UnsafeSupplier<String, Exception> coverageLevelUnsafeSupplier) {

		try {
			coverageLevel = coverageLevelUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String coverageLevel;

	public String getEmployeeClass() {
		return employeeClass;
	}

	public void setEmployeeClass(String employeeClass) {
		this.employeeClass = employeeClass;
	}

	public void setEmployeeClass(
		UnsafeSupplier<String, Exception> employeeClassUnsafeSupplier) {

		try {
			employeeClass = employeeClassUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String employeeClass;

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public void setEmployeeDepartment(
		UnsafeSupplier<String, Exception> employeeDepartmentUnsafeSupplier) {

		try {
			employeeDepartment = employeeDepartmentUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String employeeDepartment;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setEmployeeId(
		UnsafeSupplier<String, Exception> employeeIdUnsafeSupplier) {

		try {
			employeeId = employeeIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String employeeId;

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public void setHireDate(
		UnsafeSupplier<String, Exception> hireDateUnsafeSupplier) {

		try {
			hireDate = hireDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String hireDate;

	public String getMedicalCoverage() {
		return medicalCoverage;
	}

	public void setMedicalCoverage(String medicalCoverage) {
		this.medicalCoverage = medicalCoverage;
	}

	public void setMedicalCoverage(
		UnsafeSupplier<String, Exception> medicalCoverageUnsafeSupplier) {

		try {
			medicalCoverage = medicalCoverageUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String medicalCoverage;

	public String getPharmacyBenefits() {
		return pharmacyBenefits;
	}

	public void setPharmacyBenefits(String pharmacyBenefits) {
		this.pharmacyBenefits = pharmacyBenefits;
	}

	public void setPharmacyBenefits(
		UnsafeSupplier<String, Exception> pharmacyBenefitsUnsafeSupplier) {

		try {
			pharmacyBenefits = pharmacyBenefitsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String pharmacyBenefits;

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public void setPlan(UnsafeSupplier<String, Exception> planUnsafeSupplier) {
		try {
			plan = planUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String plan;

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public void setRelationship(
		UnsafeSupplier<String, Exception> relationshipUnsafeSupplier) {

		try {
			relationship = relationshipUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String relationship;

	public String getScheduledHours() {
		return scheduledHours;
	}

	public void setScheduledHours(String scheduledHours) {
		this.scheduledHours = scheduledHours;
	}

	public void setScheduledHours(
		UnsafeSupplier<String, Exception> scheduledHoursUnsafeSupplier) {

		try {
			scheduledHours = scheduledHoursUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String scheduledHours;

	@Override
	public CustomFields clone() throws CloneNotSupportedException {
		return (CustomFields)super.clone();
	}

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
		return CustomFieldsSerDes.toJSON(this);
	}

}