    function writeDropDwon(noticeMap) {
        if (noticeMap.noticeCount == 0) {
            $("#noticeCount").html(null);
        } else {
            $("#noticeCount").html(noticeMap.noticeCount + "+");
        }

        var htmls = "<h6 class=\"dropdown-header\"> Notice Center </h6>";
        htmls += "<div class = \"customClassForDropDown\">";

        for (var i = 0; i < noticeMap.noticeList.length; i++) {

            var url = "";
            if(noticeMap.noticeList[i].noticeType == "REVIEW_LIKE" || noticeMap.noticeList[i].noticeType == "REVIEW_REPLY" || noticeMap.noticeList[i].noticeType == "REVIEW_REPLY_REF"){
                url = "getReview?reviewNO="+ noticeMap.noticeList[i].reviewNO;
            } else if(noticeMap.noticeList[i].noticeType == "SCHEDULE_LIKE" || noticeMap.noticeList[i].noticeType == "SCHEDULE_REPLY" || noticeMap.noticeList[i].noticeType == "SCHEDULE_REPLY_REF"){
                url = "otherSchedule?scheduleNO="+ noticeMap.noticeList[i].scheduleNO;
            }else url = "#";

            if (noticeMap.noticeList[i].readStatus == true) {
                htmls += "<a class=\"dropdown-item-new d-flex align-items-center\" href=" + url + ">";
            } else {
                htmls += "<a class=\"dropdown-item d-flex align-items-center\" href=" + url + ">";
            }

            htmls += "<div class=\"mr-3\">";
            if (noticeMap.noticeList[i].senderVO.userImage == null || url == "#") {
                htmls += "<img class=\"text-white\" alt=\"Profile Picture\" src=\"https://liveamonth-resources.s3.ap-northeast-2.amazonaws.com/img/user/default.jpg\">";
            } else {
                var ImgURL = noticeMap.imgURL + noticeMap.noticeList[i].senderVO.userImage;
                htmls += "<img class=\"text-white\" alt=\"Profile Picture\" src=\"" + ImgURL + "\">";
            }
            htmls += "</div>";
            htmls += "<div>";
            htmls += " <div class=\"small text-gray-500\">" + noticeMap.noticeList[i].noticeDate + "</div>";
            if(url != "#") htmls += "<span class=\"font-weight-bold\">" + noticeMap.noticeList[i].senderVO.userNickname + "</span>?????? ";

            var objectSubject = "<span class=\"font-weight-bold\">" + noticeMap.noticeList[i].objectSubject + "</span>";
            var noticeContent = "<div class=\"small text-gray-700\"> \"" + noticeMap.noticeList[i].noticeContent + "\"</div>";

            switch (noticeMap.noticeList[i].noticeType) {
                case "REVIEW_LIKE" :
                    htmls += "?????? " + objectSubject + " ??? ???????????????.";
                    break;
                case "SCHEDULE_LIKE" :
                    htmls += "????????? " + objectSubject + " ??? ???????????????.";
                    break;
                case "REVIEW_REPLY" :
                    htmls += "?????? " + objectSubject + " ??? ????????? ???????????????.";
                    htmls += noticeContent;
                    break;
                case "SCHEDULE_REPLY" :
                    htmls += "????????? " + objectSubject + " ??? ????????? ???????????????.";
                    htmls += noticeContent;
                    break;
                case "REVIEW_REPLY_REF" :
                    htmls += "?????? ?????? " + objectSubject + " ??? ???????????? ???????????????.";
                    htmls += noticeContent;
                    break;
                case "SCHEDULE_REPLY_REF" :
                    htmls += "????????? ?????? " + objectSubject + " ??? ???????????? ???????????????.";
                    htmls += noticeContent;
                    break;
                default:
                    htmls += "????????? ???????????? ???????????????.";
            }
            htmls += "</div>";
            htmls += "</a>";
        }
        htmls += "</div>";
        $("#noticeDropdown").html(htmls);
    }