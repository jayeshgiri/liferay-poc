<%@ include file="/init.jsp" %>

<portlet:actionURL name="/save/schooldetails" var="saveSchoolDetails">
</portlet:actionURL>

<div class="row">

<div class="col-4"> </div>
<div class="col-4">
	<aui:form action="${saveSchoolDetails}" name="fm">
	
		<aui:input label="Name" type="text" name="name" localized="true" >
			<aui:validator name="maxLength">200</aui:validator>
		</aui:input>
		
		<aui:input label="Address" type="text" name="address" localized="true" >
			<aui:validator name="maxLength">200</aui:validator>
		</aui:input>
		
		<aui:input label="City" type="text" name="city" localized="true" >
			<aui:validator name="maxLength">200</aui:validator>
		</aui:input>
	
		<aui:input label="State" type="text" name="state" localized="true" >
			<aui:validator name="maxLength">200</aui:validator>
		</aui:input>
		
		<aui:input label="Foundation Date" type="date" name="foundationDate" >
		</aui:input>
		
		<aui:button value="Save School Record" name="submit" type="submit" > </aui:button>
		
		<aui:button value="View School Record" name="view" type="button" > </aui:button>
	</aui:form>
</div>
<div class="col-4"> </div>

</div>