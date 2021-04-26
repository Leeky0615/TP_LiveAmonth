package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Getter
@Setter
public class ScheduleContentVO {

	private int scheduleContentNO;
	private String scheduleContentSubject;
	private String scheduleContentDesc;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String scheduleContentDate;
	private int scheduleContentCost;

	// Reference
	private int scheduleNO;

	public ScheduleContentVO() {
		this.scheduleContentNO = 0;
		this.scheduleContentSubject = null;
		this.scheduleContentDesc = null;
		this.scheduleContentDate = null;
		this.scheduleContentCost=0;

		// Reference
		this.scheduleNO = 0;
	}
}
