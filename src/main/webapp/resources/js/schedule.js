

		function addScheduleContentButton() {
			var addScheduleForm = document.addScheduleContent;
			if (addScheduleForm.scheduleContentDate.value == ""
					|| addScheduleForm.scheduleContentDate.value == null) {
				alert("날짜를 입력해주세요.");
				addScheduleForm.scheduleContentDate.focus();
				return false;
			} else if (addScheduleForm.scheduleContentSubject.value == ""
					|| addScheduleForm.scheduleContentSubject.value == null) {
				alert("제목을 입력해주세요.");
				addScheduleForm.scheduleContentSubject.focus();
				return false;
			}
			addScheduleForm.submit();
		}
		
		function deleteScheduleContentButton(){
			var deleteScheduleContentForm = document.deleteScheduleContent;
			deleteScheduleContentForm.submit();
		}
		
		function modifyScheduleContentButton(){
			var modifyScheduleContentForm = document.modifyScheduleContent;
			if (modifyScheduleContentForm.modifyScheduleContentSubject.value == ""
					|| modifyScheduleContentForm.modifyScheduleContentSubject.value == null) {
				alert("제목을 입력해주세요.");
				modifyScheduleContentForm.modifyScheduleContentSubject.focus();
				return false;
		}
			
			modifyScheduleContentForm.submit();
		}
		
		function showScheduleContentList(scheduleContentNO, scheduleContentSubject,scheduleContentDate,scheduleContentDesc,scheduleContentCost){
			var query = {scheduleContentDate : scheduleContentDate, scheduleContentSubject : scheduleContentSubject, scheduleContentNO : scheduleContentNO, scheduleContentDesc : scheduleContentDesc,scheduleContentCost : scheduleContentCost};
		
			$.ajax({
			  	url : "showScheduleContentList",
			  	type : "post",
			  	data : query,
			  	success : function(data) {
				  	$(".scheduleContentSubject .scheduleContentSubjectMessage").text("제목: " + scheduleContentSubject);
			    	$(".scheduleContentDesc .scheduleContentDescMessage").text("내용: " + scheduleContentDesc);
			    	$(".scheduleContentCost .scheduleContentCostMessage").text("금액: " + scheduleContentCost);
			    	$('#modifyScheduleContentSubject').val(scheduleContentSubject);
			    	$('#modifyScheduleContentDesc').val(scheduleContentDesc);
			    	$('#modifyScheduleContentDate').val(scheduleContentDate);
			    	$('#modifyScheduleContentCost').val(scheduleContentCost);
			    
			  }
			 }); 
		
		}	
		
		function addSchedulButton() {
			var addScheduleForm = document.addSchedule;
			if (addScheduleForm.scheduleSubject.value == "" || addScheduleForm.scheduleSubject.value == null) {
				alert("제목을 입력해주세요.");
				addScheduleForm.scheduleSubject.focus();
				return false;
				}
			addScheduleForm.submit();
		}

