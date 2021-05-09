<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>SummerNoteExample</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <script src="resources/summernote-0.8.18-dist/summernote-bs4.js"></script>
    <script src="resources/summernote-0.8.18-dist/lang/summernote-ko-KR.js"></script>
    <link rel="stylesheet" href="resources/summernote-0.8.18-dist/summernote-bs4.css">


</head>
<body>
<section class="property-submit-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="property-submit-form">
                    <form form id = "reviewForm" action="addReivew">
                        <div class="pf-feature-price">
                            <h4>Category</h4>
                            <div class="search-form-content">
                                <div action="#" class="filter-form">
                                    <select class="sm-width">
                                        <option value="후기글">후기글</option>
                                        <option value="자유글">자유글</option>
                                    </select>
                                    <select class="sm-width">
                                        <option value="간 곳">간 곳</option>
                                        <option value="먹은 곳">먹은 곳</option>
                                        <option value="느낀점">느낀점</option>
                                    </select>
                                    <select class="sm-width">
                                        <option value="서울">서울</option>
                                        <option value="제주">제주</option>
                                        <option value="여수">여수</option>
                                        <option value="강릉">강릉</option>
                                        <option value="부산">부산</option>
                                        <option value="경주">경주</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="pf-title">
                            <h4>Title</h4>
                            <input type="text" placeholder="제목을 입력해주세요">
                        </div>
                        <div class="pf-summernote">
                            <h4>Content</h4>
                            <textarea class="summernote" id ="summernote" name="editordata"></textarea>
                        </div>
                        <script type="text/javascript">
                            $('.summernote').summernote({
                                toolbar: [
                                    ['fontname', ['fontname']],
                                    ['fontsize', ['fontsize']],
                                    ['style', ['bold', 'italic', 'underline', 'strikethrough', 'clear']],
                                    ['color', ['forecolor', 'color']],
                                    ['table', ['table']],
                                    ['para', ['ul', 'ol', 'paragraph']],
                                    ['height', ['height']],
                                    ['insert', ['picture', 'link', 'video']],
                                    ['view', ['fullscreen', 'codeview', 'help']]
                                ],
                                fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', '맑은 고딕', '궁서', '굴림체', '굴림', '돋움체', '바탕체'],
                                fontSizes: ['8', '9', '10', '11', '12', '14', '16', '18', '20', '22', '24', '28', '30', '36', '50', '72'],
                                placeholder: '내용을 입력해주세요',
                                height: 300,
                                lang: "ko-KR",
                                callbacks: {	//여기 부분이 이미지를 첨부하는 부분
                                    onImageUpload : function(files) {
                                        uploadSummernoteImageFile(files[0],this);
                                    },
                                    onPaste: function (e) {
                                        var clipboardData = e.originalEvent.clipboardData;
                                        if (clipboardData && clipboardData.items && clipboardData.items.length) {
                                            var item = clipboardData.items[0];
                                            if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
                                                e.preventDefault();
                                            }
                                        }
                                    }
                                }
                            });

                            function uploadSummernoteImageFile(file, editor) {
                                data = new FormData();
                                data.append("file", file);
                                $.ajax({
                                    data : data,
                                    type : "POST",
                                    url : "/uploadSummernoteImageFile",
                                    contentType : false,
                                    processData : false,
                                    success : function(data) {
                                        //항상 업로드된 파일의 url이 있어야 한다.
                                        $(editor).summernote('insertImage', data.url);
                                    }
                                });
                            }

                            $('.dropdown-toggle').dropdown();

                            // $("div.note-editable").on('drop',function(e){
                            //     for(i=0; i< e.originalEvent.dataTransfer.files.length; i++){
                            //         uploadSummernoteImageFile(e.originalEvent.dataTransfer.files[i],$("#summernote")[0]);
                            //     }
                            //     e.preventDefault();
                            // })
                        </script>

                        <input type="submit" class="search-btn sm-width" style="float: right;" value="확인">
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>