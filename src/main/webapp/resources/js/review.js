
function addReviewButton (){
    var addReviewForm = document.getElementById("reviewForm");
    if (addReviewForm.reviewSubject.value == "" || addReviewForm.reviewSubject.value == null) {
        alert("제목을 입력해주세요.");
        addReviewForm.reviewSubject.focus();
        return false;
    }
    if (addReviewForm.reviewDesc.value == "" || addReviewForm.reviewDesc.value == null) {
        alert("내용을 입력해주세요.");
        addReviewForm.reviewDesc.focus();
        return false;
    }
    addReviewForm.submit();
}

function changeReviewCategory(sVal) {
    var val = document.getElementById("reviewCategoryDiv");
    if (sVal == "REVIEW_BOARD") {
        val.style.display = "block";
    } else if (sVal == "FREE_BOARD") {
        $("#disabledOption").val("").prop("selected", true);
        val.style.display = "none";
    }
}