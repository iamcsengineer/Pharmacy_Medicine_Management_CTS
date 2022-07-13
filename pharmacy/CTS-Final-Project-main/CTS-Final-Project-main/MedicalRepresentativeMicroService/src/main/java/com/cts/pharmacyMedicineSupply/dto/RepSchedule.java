package com.cts.pharmacyMedicineSupply.dto;

import java.time.LocalDate;

//import javax.persistence.Entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepSchedule {
	@ApiModelProperty(value = "Name of the Medical Representative")
	private String medicalRepName;
	@ApiModelProperty(value = "Name of the Targetted Doctor")
	private String doctorName;
	@ApiModelProperty(value = "Name of the Treating Ailment")
	private String treatingAilment;
	@ApiModelProperty(value = "Name of the Medicine")
	private String medicine;
	
	@ApiModelProperty(value = "Time Slot For the Meeeting")
	private String meetingSlot;
	@ApiModelProperty(value = "Date fixed for the meeting")
	private String date_Of_Meeting;
	@ApiModelProperty(value = "Contact Number for the doctor")
	private String doctorNumber;
}
