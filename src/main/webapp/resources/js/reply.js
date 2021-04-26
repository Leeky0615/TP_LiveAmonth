    function showReplyDiv(scheduleReplyNO) {
        var replyDiv = document.getElementById("replyDiv"+scheduleReplyNO);
        if(replyDiv.style.display == "block"){
            replyDiv.style.display = "none";
        } else {
            replyDiv.style.display = "block";
        }
    }

    function addScheduleReply(scheduleReplyNO) {
        var addScheduleReplyForm = document.getElementById("addScheduleReply"+scheduleReplyNO);
        var userID = document.getElementById("userID").value;
        if(userID == "" || userID == null){
            alert("로그인 후 이용해주세요.");
            addScheduleReplyForm.scheduleReplyDesc.focus();
            return false;
        } else if (addScheduleReplyForm.scheduleReplyDesc.value == "" || addScheduleReplyForm.scheduleReplyDesc.value == null) {
            alert("내용을 입력하여 주세요.");
            addScheduleReplyForm.scheduleReplyDesc.focus();
            return false;
        }
        addScheduleReplyForm.submit();
    }

    function deleteScheduleReplyButton(scheduleReplyNO){
        if (confirm("정말 삭제하시겠습니까??") == true){
            location.replace('/deleteScheduleReply?reviewReplyNO='+scheduleReplyNO);
        } else {
            return;
        }
    }