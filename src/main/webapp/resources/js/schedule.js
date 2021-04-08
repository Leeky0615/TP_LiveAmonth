function addScheduleButton() {
			var addScheduleForm = document.addSchedule;
			if (addScheduleForm.scheduleContentDate.value == ""
					|| addScheduleForm.scheduleContentDate.value == null) {
				alert("날짜를 입력해주세요.");
				addScheduleForm.scheduleContentDate.focus();
				return false;
			} else if (addScheduleForm.scheduleContentSubject.value == ""
					|| addScheduleForm.scheduleContentSubject.value == null) {
				alert("제목을 입력해주세요.");
				addScheduleForm.scheduleContentDate.focus();
				return false;
			}
			addScheduleForm.submit();
		}
		function showSchedule() {

			
		}