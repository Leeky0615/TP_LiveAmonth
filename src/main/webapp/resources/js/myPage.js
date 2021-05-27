// 회원 정보 수정 중복 확인.
$(".checkNickName").click(function () {
    var query = {userNickname: $("#userNickname").val()};
    $.ajax({
        url: "checkNickName",
        type: "post",
        data: query,
        success: function (data) {

            if (data == 1) {
                $(".nickNameResult .nickNameMsg").text("사용불가");
                $(".nickNameResult .nickNameMsg").attr("style", "color:#f00");
                $("#submit").attr("disabled", "disabled");
            } else {
                $(".nickNameResult .nickNameMsg").text("사용가능");
                $(".nickNameResult .nickNameMsg").attr("style", "color:#00f");

                $("#submit").removeAttr("disabled");
            }
        }
    });
});
$("#userNickname").keyup(function () {
    $(".nickNameResult .nickNameMsg").text("중복확인을 해주세요");
    $(".nickNameResult .nickNameMsg").attr("style", "color:#000");

    $("#submit").attr("disabled", "disabled");
});