
addReviewButton = function(){
    var addReviewForm = document.reviewForm;
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