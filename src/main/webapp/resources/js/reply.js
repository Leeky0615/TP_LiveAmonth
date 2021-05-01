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
        var userNO = document.getElementById("userNO").value;
        if(userNO == "" || userNO == null){
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

    function modifyScheduleReply(scheduleReplyNO){
        var modifyScheduleReplyForm = document.getElementById("modifyScheduleReply"+scheduleReplyNO);
        if (modifyScheduleReplyForm.scheduleReplyDesc.value == "" || modifyScheduleReplyForm.scheduleReplyDesc.value == null) {
            alert("내용을 입력하여 주세요.");
            modifyScheduleReplyForm.scheduleReplyDesc.focus();
            return false;
        }
        modifyScheduleReplyForm.submit();
    }

    function showModifyScheduleReplyDesc(scheduleReplyNO){
        var modifyScheduleForm = document.getElementById("modifyScheduleReplyDesc"+scheduleReplyNO);
        var scheduleP = document.getElementById("scheduleReplyDesc"+scheduleReplyNO);
        if(modifyScheduleForm.style.display == "none" || modifyScheduleForm.style.display == ""){
            modifyScheduleForm.style.display = "block";
            scheduleP.style.display = "none";
        } else {
            modifyScheduleForm.style.display = "none";
            scheduleP.style.display = "block";
        }
    }

    function deleteScheduleReplyButton(scheduleReplyNO){
        var scheduleNO = document.getElementById("selectedScheduleNO").value;
        if (confirm("정말 삭제하시겠습니까??") == true){
            location.replace('/deleteScheduleReply?reviewReplyNO='+scheduleReplyNO+'&scheduleNO='+scheduleNO);
        } else {
            return;
        }
    }

    function updateScheduleLike() {
        var scheduleNO = document.getElementById("selectedScheduleNO").value;
        var userNO = document.getElementById("userNO").value;
        if(userNO == "" || userNO == null){
            alert("로그인 후 이용해주세요.");
            return;
        }
        $.ajax({
            url: "updateScheduleLike",
            type: "get",
            data: {scheduleNO: scheduleNO, userNO: userNO},
            success:
                function (data) {
                    if(data.likeStatus == 1){
                        $("#like").attr('class','icon_heart dis-none');
                    } else if(data.likeStatus == 0){
                        $("#like").attr('class','icon_heart_alt');
                    }
                    $("#likeCount").html("&nbsp;"+data.likeCount);

                },
            error:
                function (request, status, error) {
                    alert("ajax실패")
                }
        });
    }