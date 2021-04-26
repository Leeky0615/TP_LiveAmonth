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
        if (addScheduleReplyForm.scheduleReplyDesc.value == "" || addScheduleReplyForm.scheduleReplyDesc.value == null) {
            alert("내용을 입력해주세요.");
            addScheduleReplyForm.scheduleReplyDesc.focus();
            return false;
        }
        addScheduleReplyForm.submit();
    }